package 自定义.系统.屏幕

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp


private val 当前本地配置
    @Composable
    get() = LocalConfiguration.current


val 屏幕宽度: Int
    @Composable
    get() = 取屏幕宽度()

val 屏幕高度: Int
    @Composable
    get() = 取屏幕高度()

//=====================================================================================

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun 取屏幕宽度(): Int{
    return 当前本地配置.screenWidthDp
}

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun 取屏幕高度(): Int {
    return 当前本地配置.screenHeightDp
}

//=====================================================================================

val 屏幕宽度像素: Int
    @Composable
    get() = 取屏幕宽度像素()

val 屏幕高度像素: Int
    @Composable
    get() = 取屏幕高度像素()

//=====================================================================================

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun 取屏幕宽度像素(): Int {
    val density = LocalDensity.current
    val screenWidthDp = 当前本地配置.screenWidthDp.dp
    return with(density) { screenWidthDp.roundToPx() }
}

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun 取屏幕高度像素(): Int {
    val density = LocalDensity.current
    val screenHeightDp = 当前本地配置.screenHeightDp.dp
    return with(density) { screenHeightDp.roundToPx() }
}