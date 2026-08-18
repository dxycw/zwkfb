package 自定义.应用

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri

/**
 * 启动活动
 */
fun Activity.启动活动(窗口: Class<out Activity>) =
    this.startActivity(Intent(this, 窗口))

/**
 * 启动活动
 */
fun Activity.启动活动(窗口: Activity) =
    this.startActivity(Intent(this, 窗口::class.java))

//=================================================================================

/**
 * 启动活动到地址
 */
@SuppressLint("UnsafeImplicitIntentLaunch")
fun Activity.启动活动到地址(网址: Uri) =
    this.startActivity(Intent(Intent.ACTION_VIEW, 网址))