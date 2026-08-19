package 自定义.系统

import org.jetbrains.compose.resources.painterResource
import platform.Foundation.NSURL
import platform.UIKit.UIApplication


actual fun 用默认浏览器打开网址(网址: String) {
    val nsUrl = NSURL.URLWithString(网址) ?: return
    UIApplication.sharedApplication.openURL(nsUrl)
}