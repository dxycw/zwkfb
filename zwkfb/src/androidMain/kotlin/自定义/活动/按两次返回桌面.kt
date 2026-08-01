package 自定义.活动

import android.app.Activity
import android.widget.Toast


private var 第一次点击时间: Long = 0

/**
 * 按两次返回桌面
 * @param 信息 再按一次返回桌面
 */
fun Activity.按两次返回桌面(信息: CharSequence = "再按一次返回桌面"){
    // 在这里处理返回键事件
    if ((System.currentTimeMillis() - 第一次点击时间) > 2000) {
        // 第一次点击或超时，更新时间点并提示
        第一次点击时间 = System.currentTimeMillis()
        Toast.makeText(this, 信息, Toast.LENGTH_SHORT).show()
    } else {
        // 两次点击间隔在阈值内，执行返回桌面
        this.moveTaskToBack(true)
    } //返回桌面指令
}


