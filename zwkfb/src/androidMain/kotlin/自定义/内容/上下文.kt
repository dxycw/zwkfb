package 自定义.内容

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * 描述：启动活动
 * @param 活动 活动。
 */
fun Context.启动活动(活动: Class<out Activity>) =
    this.startActivity(Intent(this, 活动))

/**
 * 描述：启动活动
 * @param 活动 活动。
 */
fun Context.启动活动(活动: Activity) =
    this.startActivity(Intent(this, 活动::class.java))

//=================================================================================

/**
 * 启动活动到地址
 */
@SuppressLint("UnsafeImplicitIntentLaunch")
fun Context.启动活动到地址(网址: Uri) =
    this.startActivity(Intent(Intent.ACTION_VIEW, 网址))