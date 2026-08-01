package 自定义.活动

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.lifecycle.LifecycleOwner

@SuppressLint("ComposableNaming")
fun ComponentActivity.注册返回键回调事件(
    持有者: LifecycleOwner? = null,
    已启动: Boolean = true,
    返回按压回调: OnBackPressedCallback.() -> Unit,
) = this.onBackPressedDispatcher.addCallback(owner = 持有者, enabled = 已启动, onBackPressed = 返回按压回调)


@SuppressLint("ComposableNaming")
fun ComponentActivity.注册返回键两次回调事件(){
    this.onBackPressedDispatcher.addCallback(owner = null, enabled = true){
        this@注册返回键两次回调事件.按两次返回桌面()
    }
}

