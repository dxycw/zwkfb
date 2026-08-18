package 自定义.应用

import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.lifecycle.LifecycleOwner


fun ComponentActivity.注册返回键回调事件(
    持有者: LifecycleOwner? = null,
    已启动: Boolean = true,
    返回按压回调: OnBackPressedCallback.() -> Unit,
) = this.onBackPressedDispatcher.addCallback(owner = 持有者, enabled = 已启动, onBackPressed = 返回按压回调)


fun ComponentActivity.注册返回键两次回调事件(){
    this.onBackPressedDispatcher.addCallback(owner = null, enabled = true){
        this@注册返回键两次回调事件.按两次返回桌面()
    }
}

