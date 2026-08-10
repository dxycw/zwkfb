package 自定义.活动

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

fun ComponentActivity.使用声明式界面代码(内容代码: @Composable () -> Unit) {
    this.setContent {
        内容代码()
    }
}

//================================================================================