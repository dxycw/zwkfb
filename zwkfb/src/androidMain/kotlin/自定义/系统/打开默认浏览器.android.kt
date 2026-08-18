package 自定义.系统


import android.content.Intent
import androidx.core.net.toUri
import 自定义.内容.appCtx


actual fun 用默认浏览器打开网址(网址: String) {
    val intent = Intent(Intent.ACTION_VIEW, 网址.toUri()).apply {
        // 强制使用默认浏览器，不弹出选择器
        addCategory(Intent.CATEGORY_BROWSABLE)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)  // ← 加上这行
    }
    appCtx.startActivity(intent)
}



//private fun Context.用默认浏览器打开网址(网址: String) {
//    val intent = Intent(Intent.ACTION_VIEW, 网址.toUri()).apply {
//        // 强制使用默认浏览器，不弹出选择器
//        addCategory(Intent.CATEGORY_BROWSABLE)
//    }
//
//    // 方式一：直接启动，如果有多个浏览器会弹选择器
//    this.startActivity(intent)
//}