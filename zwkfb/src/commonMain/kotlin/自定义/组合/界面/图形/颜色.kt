package 自定义.组合.界面.图形

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import 安卓x.组合.材质3.文本

/**
 * @return 结果示例: "RGBA(76, 94, 139, 255)"
 */

@Suppress("ComposableNaming")
@Composable
fun 颜色转整数(
    颜色: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primary,
){
    val r = (颜色.red * 255).toInt()
    val g = (颜色.green * 255).toInt()
    val b = (颜色.blue * 255).toInt()
    val a = (颜色.alpha * 255).toInt()

    文本(
        文本 = "RGBA($r, $g, $b, $a)",
        修饰符 = Modifier.padding(8.dp)
    )
}

/**
 * @return 格式化为 #AARRGGBB 或 #RRGGBBAA
 */
@Suppress("ComposableNaming")
@Composable
fun 颜色转字符串(
    颜色: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primary,
){
    val r = (颜色.red * 255).toInt()
    val g = (颜色.green * 255).toInt()
    val b = (颜色.blue * 255).toInt()
    val a = (颜色.alpha * 255).toInt()

    val rHex = r.toString(16).padStart(2, '0').uppercase()
    val gHex = g.toString(16).padStart(2, '0').uppercase()
    val bHex = b.toString(16).padStart(2, '0').uppercase()
    val aHex = a.toString(16).padStart(2, '0').uppercase()
    val hex = if (a == 255) {
        "#$rHex$gHex$bHex"
    } else {
        "#$rHex$gHex$bHex$aHex"
    }

    文本(
        文本 = hex,
        修饰符 = Modifier.padding(8.dp)
    )
}


/**
 * @return 结果示例: "RGBA(76, 94, 139, 255)"
 */
@Suppress("ComposableNaming")
@Composable
fun 颜色转整数(
    颜色: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primary,
    结果:@Composable (Int,Int,Int,Int) -> Unit = {_,_,_,_ -> }
){
    val r = (颜色.red * 255).toInt()
    val g = (颜色.green * 255).toInt()
    val b = (颜色.blue * 255).toInt()
    val a = (颜色.alpha * 255).toInt()

    结果(r,g,b,a)
}

/**
 * @return 格式化为 #AARRGGBB 或 #RRGGBBAA
 */
@Suppress("ComposableNaming")
@Composable
fun 颜色转字符串(
    颜色: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primary,
    结果:@Composable (String) -> Unit = {_->}
){
    val r = (颜色.red * 255).toInt()
    val g = (颜色.green * 255).toInt()
    val b = (颜色.blue * 255).toInt()
    val a = (颜色.alpha * 255).toInt()

    val rHex = r.toString(16).padStart(2, '0').uppercase()
    val gHex = g.toString(16).padStart(2, '0').uppercase()
    val bHex = b.toString(16).padStart(2, '0').uppercase()
    val aHex = a.toString(16).padStart(2, '0').uppercase()
    val hex = if (a == 255) {
        "#$rHex$gHex$bHex"
    } else {
        "#$rHex$gHex$bHex$aHex"
    }

    结果(hex)
}

