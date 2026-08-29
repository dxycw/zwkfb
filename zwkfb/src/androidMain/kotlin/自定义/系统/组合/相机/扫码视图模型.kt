package 自定义.系统.组合.相机

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import java.util.concurrent.Executors


internal class 扫码视图模型 : ViewModel() {

    private var 扫描器  = BarcodeScanning.getClient(
        BarcodeScannerOptions.Builder()
            .setBarcodeFormats(
                Barcode.FORMAT_QR_CODE,
                Barcode.FORMAT_AZTEC,
                Barcode.FORMAT_CODE_128,
                Barcode.FORMAT_CODE_39,
                Barcode.FORMAT_CODE_93,
                Barcode.FORMAT_EAN_13,
                Barcode.FORMAT_EAN_8,
                Barcode.FORMAT_UPC_A,
                Barcode.FORMAT_UPC_E,
                Barcode.FORMAT_DATA_MATRIX,
                Barcode.FORMAT_PDF417
            )
            .build()
    )

    // 分析器执行器
    val 分析执行器 = Executors.newSingleThreadExecutor()

    @SuppressLint("ComposableNaming")
    @Composable
    fun 相册启动器(
        上下文: Context,
        解析结果回调: (String) -> Unit
    ): ManagedActivityResultLauncher<String, Uri?> {
        val 相册启动器 = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri ->
            uri?.let {
                处理地址图像(
                    上下文 = 上下文,
                    网址 = it,
                    解析结果回调 = 解析结果回调
                )
            }
        }
        return 相册启动器
    }

    // 图像分析用例
    fun 图像分析(
        解析结果回调: (String) -> Unit
    ): ImageAnalysis {
        return ImageAnalysis.Builder()
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()
            .also { analysis ->
                analysis.setAnalyzer(分析执行器) { imageProxy ->
                    处理图像(
                        图片代理 = imageProxy,
                        解析结果回调 = 解析结果回调
                    )
                }
            }
    }

    @OptIn(ExperimentalGetImage::class)
    internal fun 处理图像(
        图片代理: ImageProxy? = null,
        解析结果回调: (String) -> Unit
    ) {
        val mediaImage = 图片代理?.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(
                mediaImage,
                图片代理.imageInfo.rotationDegrees
            )
            扫描器.process(image)
                .addOnSuccessListener { barcodes ->
                    for (barcode in barcodes) {
                        barcode.rawValue?.let { value ->
                            解析结果回调(value)
                        }
                    }
                }
                .addOnFailureListener { e ->
                    Log.e("BarcodeScanner", "条码识别失败", e)
                }
                .addOnCompleteListener {
                    // 必须关闭 imageProxy，否则后续帧不会进来
                    图片代理.close()
                }
        } else {
            图片代理?.close()
        }
    }

    /**
     * 从 Uri 扫描二维码，结果通过回调返回
     */
    internal fun 处理地址图像(
        上下文: Context,
        网址: Uri,
        解析结果回调: (String) -> Unit
    ) {
        // 创建 InputImage
        val image = InputImage.fromFilePath(上下文, 网址)
        扫描器.process(image)
            // 成功监听器
            .addOnSuccessListener { barcodes ->
                val result = if (barcodes.isNotEmpty()) {
                    barcodes.firstOrNull()?.rawValue ?: "未找到二维码内容"
                } else {
                    "未检测到二维码"
                }
                解析结果回调(result)
            }
            // 失败监听器
            .addOnFailureListener { e ->
                解析结果回调("扫描失败：${e.message}")
            }
    }


    @SuppressLint("EmptySuperCall")
    override fun onCleared() {
        // 清理资源
        扫描器.close()
        分析执行器.shutdown()
        super.onCleared()
    }

}

