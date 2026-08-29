package 自定义.系统.组合.相机

import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel


@SuppressLint("ComposableNaming", "ModifierParameter")
@Composable
fun 相机扫码(
    修饰符: Modifier = Modifier,
    相机回调: (Camera) -> Unit = {},
    相册启动器: (ManagedActivityResultLauncher<String, Uri?>) -> Unit = {},
    解析结果回调: (String) -> Unit,
) {
    Box(
        modifier = 修饰符.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        val 预览视图 = LocalInspectionMode.current
        val 上下文 = LocalContext.current
        if (预览视图) {
            Text(
                text = "相机预览",
                modifier = Modifier,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        } else {
            val 扫码视图模型: 扫码视图模型 = viewModel()
            val 生命周期 = LocalLifecycleOwner.current
            // 选择后置摄像头
            var 相机选择器 by remember { mutableStateOf(CameraSelector.DEFAULT_BACK_CAMERA) }
            相册启动器(扫码视图模型.相册启动器(上下文, 解析结果回调))
            AndroidView(
                factory = { ctx ->
                    PreviewView(ctx).apply {
                        // 在渲染相机预览时选择的一种实现模式
                        implementationMode = PreviewView.ImplementationMode.COMPATIBLE

                        val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)
                        cameraProviderFuture.addListener({
                            val cameraProvider = cameraProviderFuture.get()

                            // 预览用例
                            val 预览用例 = Preview.Builder().build()
                                .also {
                                    it.surfaceProvider = this.surfaceProvider
                                }

                            try {
                                // 解绑所有用例
                                cameraProvider.unbindAll()

                                val 相机 = cameraProvider.bindToLifecycle(
                                    lifecycleOwner = 生命周期,
                                    cameraSelector = 相机选择器,
                                    预览用例,
                                    扫码视图模型.图像分析(解析结果回调 = 解析结果回调)
                                )

                                // 绑定用例到相机
                                相机回调(相机)
                            } catch (e: Exception) {
                                解析结果回调("用例绑定失败:${e.message}")
                            }

                        }, ContextCompat.getMainExecutor(ctx))

                    }

                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


//@SuppressLint("ComposableNaming", "ModifierParameter", "RestrictedApi")
//@Composable
//fun 相机扫码(
//    修饰符: Modifier = Modifier,
//    是否前置摄像头: Boolean = false,
//    相机回调: (Camera) -> Unit = {},
//    解析结果回调: (String) -> Unit,
//) {
//    val 生命周期 = LocalLifecycleOwner.current
//
//    // 关键修改：remember 加上 key，切换摄像头时重新计算
//    val 相机选择器 = remember(是否前置摄像头) {
//        if (是否前置摄像头) {
//            CameraSelector.DEFAULT_FRONT_CAMERA
//        } else {
//            CameraSelector.DEFAULT_BACK_CAMERA
//        }
//    }
//
//    // 配置 ML Kit
//    val options = remember {
//        BarcodeScannerOptions.Builder()
//            .setBarcodeFormats(
//                Barcode.FORMAT_QR_CODE,
//                Barcode.FORMAT_AZTEC,
//                Barcode.FORMAT_CODE_128,
//                Barcode.FORMAT_CODE_39,
//                Barcode.FORMAT_CODE_93,
//                Barcode.FORMAT_EAN_13,
//                Barcode.FORMAT_EAN_8,
//                Barcode.FORMAT_UPC_A,
//                Barcode.FORMAT_UPC_E,
//                Barcode.FORMAT_DATA_MATRIX,
//                Barcode.FORMAT_PDF417
//            )
//            .build()
//    }
//
//    val barcodeScanner = remember { BarcodeScanning.getClient(options) }
//    // 分析器执行器
//    val analysisExecutor = remember { Executors.newSingleThreadExecutor() }
//
//    // 清理资源
//    DisposableEffect(Unit) {
//        onDispose {
//            barcodeScanner.close()
//            analysisExecutor.shutdown()
//        }
//    }
//
//    // 用于在 update 中重新绑定
//    var 相机提供者 by remember { mutableStateOf<ProcessCameraProvider?>(null) }
//    var 预览用例 by remember { mutableStateOf<Preview?>(null) }
//    var 图像分析 by remember { mutableStateOf<ImageAnalysis?>(null) }
//
//    AndroidView(
//        factory = { ctx ->
//            val 预览视图 = PreviewView(ctx).apply {
//                implementationMode = PreviewView.ImplementationMode.COMPATIBLE
//            }
//
//            val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)
//            cameraProviderFuture.addListener({
//                val cameraProvider = cameraProviderFuture.get()
//                相机提供者 = cameraProvider
//
//                // 预览用例
//                预览用例 = Preview.Builder().build().also {
//                    it.surfaceProvider = 预览视图.surfaceProvider
//                }
//
//                // 图像分析用例
//                图像分析 = ImageAnalysis.Builder()
//                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
//                    .build()
//                    .also { analysis ->
//                        analysis.setAnalyzer(analysisExecutor) { imageProxy ->
//                            处理图像(
//                                图片代理 = imageProxy,
//                                条码扫描器 = barcodeScanner,
//                                解析结果回调 = 解析结果回调
//                            )
//                        }
//                    }
//
//                try {
//                    // 解绑所有用例
//                    cameraProvider.unbindAll()
//                    val 相机 = cameraProvider.bindToLifecycle(
//                        lifecycleOwner = 生命周期,
//                        cameraSelector = 相机选择器,
//                        预览用例,
//                        图像分析
//                    )
//                    // 绑定用例到相机
//                    相机回调(相机)
//                } catch (e: Exception) {
//                    Log.e("CameraPreview", "用例绑定失败", e)
//                }
//            }, ContextCompat.getMainExecutor(ctx))
//
//            预览视图
//        },
//        // 关键修改：update 回调里检测选择器变化，重新绑定
//        update = { _ ->
//            val provider = 相机提供者 ?: return@AndroidView
//            val preview = 预览用例 ?: return@AndroidView
//            val analysis = 图像分析 ?: return@AndroidView
//
//            try {
//                provider.unbindAll()
//                val 相机 = provider.bindToLifecycle(
//                    lifecycleOwner = 生命周期,
//                    cameraSelector = 相机选择器,
//                    preview,
//                    analysis
//                )
//                相机回调(相机)
//            } catch (e: Exception) {
//                Log.e("CameraPreview", "切换摄像头重新绑定失败", e)
//            }
//        },
//        modifier = 修饰符.fillMaxSize()
//    )
//}


