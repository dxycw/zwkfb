package 自定义.组合.内容.资源

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration


private val 当前本地配置
    @Composable
    get() = LocalConfiguration.current


val 是否竖屏: Boolean
    @Composable
    get() = 是否竖屏()

val 是否横屏: Boolean
    @Composable
    get() = 是否横屏()

//=====================================================================================

@Composable
fun 是否竖屏(): Boolean {
    return 当前本地配置.orientation == Configuration.ORIENTATION_PORTRAIT
}

@Composable
fun 是否横屏(): Boolean {
    return 当前本地配置.orientation == Configuration.ORIENTATION_LANDSCAPE
}

//=====================================================================================

private val 当前本地活动
    @Composable
    get() = LocalActivity.current!!


@SuppressLint("ComposableNaming")
@Composable
fun 强制横屏() {
    当前本地活动.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE // 固定横屏
}


@SuppressLint("ComposableNaming")
@Composable
fun 强制竖屏() {
    当前本地活动.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED // 固定竖屏
}


