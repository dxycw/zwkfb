package 自定义.应用

import android.app.Activity
import android.content.Intent
import 安卓.应用.移动任务到后台


/**
 * 返回桌面,直接退出到后台，不会关闭应用程序
 */
fun Activity.退出后台() = this.移动任务到后台(true)


/**
 * 返回桌面,直接退出到后台，不会关闭应用程序
 */
@Deprecated("请使用退出后台方法，该方法已过时“this.退出后台()”")
fun Activity.返回桌面() =
    this.startActivity(Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME))
