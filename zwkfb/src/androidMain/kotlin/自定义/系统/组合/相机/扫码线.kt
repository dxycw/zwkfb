package 自定义.系统.组合.相机


import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.Rect
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.zwkfb.R
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds


@SuppressLint("ComposableNaming", "ModifierParameter", "LocalContextResourcesRead")
@Composable
fun 扫码线(
    修饰符: Modifier = Modifier,
    显示扫描线: Boolean = false,
    扫描线颜色: Color = Color.White,
    显示斑点: Boolean = false,
    斑点颜色: Color = Color.White
) {
    val 上下文 = LocalContext.current
    val infiniteTransition = rememberInfiniteTransition()
    // 创建上下移动的动画
    val scanLineOffset by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    // 创建透明度动画（淡入淡出）
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 2500
                0f at 0 using LinearEasing
                1f at 200 using LinearEasing
                1f at 2300 using LinearEasing
                0f at 2500 using LinearEasing
            },
            repeatMode = RepeatMode.Restart
        )
    )
    // 生成随机斑点列表
    val spotList = remember { mutableStateListOf<ScanSpot>() }
    if (显示斑点){
        // 定时生成新斑点
        LaunchedEffect(Unit) {
            while (true) {
                delay(30.milliseconds) // 每30ms生成一个新斑点
                if (spotList.size > 20) { // 限制最大斑点数
                    spotList.add(
                        ScanSpot(
                            id = System.currentTimeMillis(),
                            x = (0.1f + (0.9f - 0.1f) * Math.random()).toFloat(),
                            y = (0.1f + (0.9f - 0.1f) * Math.random()).toFloat(),
                            size = (2f + (8f - 2f) * Math.random()).toFloat(),   // 更小的斑点
                            alpha = (0.2f + (0.6f - 0.2f) * Math.random()).toFloat() // 更透明的斑点
                        )
                    )
                }
                // 移除过期斑点(存在超过200ms的)
                val currentTime = System.currentTimeMillis()
                spotList.removeAll { spot ->
                    currentTime - spot.id > 200
                }
            }
        }
    }
    Canvas(修饰符.fillMaxSize()) {
        // 定义扫描区域
        val frameSize = size.width * 0.9f
        val frameHeight = frameSize // 使扫描区域为正方形
        val frameOffsetX = (size.width - frameSize) / 2
        val frameOffsetY = (size.height - frameHeight) / 2 // 居中显示扫描区域
        // 绘制随机斑点
        if (显示斑点) {
            spotList.forEach { spot ->
                drawCircle(
                    color = 斑点颜色,
                    radius = spot.size,
                    center = Offset(
                        frameOffsetX + frameSize * spot.x,
                        frameOffsetY + frameHeight * spot.y
                    ),
                    alpha = spot.alpha
                )
            }
        }
        if (显示扫描线) {
            // 计算扫描线位置 - 在扫描区域内居中移动
            val scanLineY = frameOffsetY + (scanLineOffset * frameHeight)
            // 绘制扫描线图片并着色
            val paint = Paint()
            val bitmap = BitmapFactory.decodeResource(上下文.resources, R.drawable.smx)
            // 使用 PorterDuffColorFilter 设置颜色滤镜（兼容性更好）
            paint.colorFilter = PorterDuffColorFilter(
                扫描线颜色.toArgb(), // 可以改为任何你想要的颜色
                PorterDuff.Mode.SRC_IN
            )
            drawIntoCanvas {
                // 计算扫描线图片的绘制位置和大小
                val scanLineHeight = 10f // 假设扫描线图片高度为10像素
                it.nativeCanvas.drawBitmap(
                    bitmap, null,
                    Rect(
                        (frameOffsetX - 20f).toInt(),
                        (scanLineY - scanLineHeight/2).toInt(),
                        (frameOffsetX + frameSize + 20f).toInt(),
                        (scanLineY + scanLineHeight/2).toInt()
                    ),
                    paint.apply { this.alpha = (alpha * 255).toInt() } // 应用透明度
                )
            }
        }
    }
}


// 斑点数据类
internal data class ScanSpot(
    val id: Long,     // 用于标识和计算生命周期
    val x: Float,     // 相对于扫描框的X位置(0f-1f)
    val y: Float,     // 相对于扫描框的Y位置(0f-1f)
    val size: Float,  // 斑点大小
    val alpha: Float  // 斑点透明度
)