package 自定义.组合.活动

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import 自定义.应用.按两次返回桌面



@SuppressLint("ComposableNaming")
@Composable
fun 注册返回键回调事件(
    已启动: Boolean = true,
    返回回调: () -> Unit
) = BackHandler(enabled = 已启动, onBack = 返回回调)


@SuppressLint("ComposableNaming")
@Composable
fun 注册返回键两次回调事件(
    已启动: Boolean = true,
) {
    val 上下文 = LocalActivity.current
    BackHandler(enabled = 已启动){
        上下文!!.按两次返回桌面()
    }
}

