package 自定义.组合.材质3.网页

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.Uri
import android.os.Message
import android.view.View
import android.webkit.ConsoleMessage
import android.webkit.GeolocationPermissions
import android.webkit.JsPromptResult
import android.webkit.JsResult
import android.webkit.PermissionRequest
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebStorage
import android.webkit.WebView


var 网络浏览器客户端: 网络浏览器客户端事件 = 网络浏览器客户端事件()

//=============================================================================================


private var 接收标题: 接收标题事件? = null
private var 接收图标: 接收图标事件? = null

private var 网页加载进度: 网页加载进度事件? = null

//===========================================================================================

open class 网络浏览器客户端事件 : WebChromeClient() {
    open lateinit var 状态: 浏览器状态
        internal set

    override fun onReceivedTitle(view: WebView, title: String?) {
        super.onReceivedTitle(view, title)
        状态.网页标题 = title
        if (接收标题 != null){
            接收标题!!.接收标题(view, title)
        }
    }

    override fun onReceivedIcon(view: WebView, icon: Bitmap?) {
        super.onReceivedIcon(view, icon)
        状态.网页图标 = icon
        if (接收图标 != null){
            接收图标!!.接收图标(view, icon)
        }
    }

    @SuppressLint("RequiresFeature")
    override fun onProgressChanged(view: WebView, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
        if (状态.加载状态 is 网页加载状态.完成) return
        状态.加载状态 = 网页加载状态.加载(newProgress / 100.0f)
        if (网页加载进度 != null) {
            网页加载进度!!.进度改变(view, newProgress)
        }
    }


    override fun getDefaultVideoPoster(): Bitmap? {
        return super.getDefaultVideoPoster()
    }

    override fun getVideoLoadingProgressView(): View? {
        return super.getVideoLoadingProgressView()
    }

    override fun getVisitedHistory(callback: ValueCallback<Array<out String?>?>?) {
        super.getVisitedHistory(callback)
    }

    override fun onCloseWindow(window: WebView?) {
        super.onCloseWindow(window)
    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
        return super.onConsoleMessage(consoleMessage)
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onConsoleMessage(message: String?, lineNumber: Int, sourceID: String?) {
        super.onConsoleMessage(message, lineNumber, sourceID)
    }

    override fun onCreateWindow(view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?): Boolean {
        return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onExceededDatabaseQuota(url: String?, databaseIdentifier: String?, quota: Long, estimatedDatabaseSize: Long,
                                         totalQuota: Long, quotaUpdater: WebStorage.QuotaUpdater?
    ) {
        super.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize,
            totalQuota, quotaUpdater
        )
    }

    override fun onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt()
    }

    override fun onGeolocationPermissionsShowPrompt(origin: String?, callback: GeolocationPermissions.Callback?) {
        super.onGeolocationPermissionsShowPrompt(origin, callback)
    }

    override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
        return super.onJsAlert(view, url, message, result)
    }

    override fun onJsBeforeUnload(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
        return super.onJsBeforeUnload(view, url, message, result)
    }

    override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
        return super.onJsConfirm(view, url, message, result)
    }

    override fun onJsPrompt(view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?): Boolean {
        return super.onJsPrompt(view, url, message, defaultValue, result)
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onJsTimeout(): Boolean {
        return super.onJsTimeout()
    }

    override fun onPermissionRequest(request: PermissionRequest?) {
        super.onPermissionRequest(request)
    }

    override fun onPermissionRequestCanceled(request: PermissionRequest?) {
        super.onPermissionRequestCanceled(request)
    }

    override fun onReceivedTouchIconUrl(view: WebView?, url: String?, precomposed: Boolean) {
        super.onReceivedTouchIconUrl(view, url, precomposed)
    }

    override fun onRequestFocus(view: WebView?) {
        super.onRequestFocus(view)
    }

    override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
        super.onShowCustomView(view, callback)
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onShowCustomView(view: View?, requestedOrientation: Int, callback: CustomViewCallback?) {
        super.onShowCustomView(view, requestedOrientation, callback)
    }

    override fun onHideCustomView() {
        super.onHideCustomView()
    }

    override fun onShowFileChooser(webView: WebView?, filePathCallback: ValueCallback<Array<out Uri?>?>?, fileChooserParams: FileChooserParams?): Boolean {
        return super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }
}

//===========================================================================================

private interface 接收标题事件{
    fun 接收标题(浏览器: WebView?, 标题: String?)
}
private interface 接收图标事件{
    fun 接收图标(浏览器: WebView?, 图标: Bitmap?)
}

private interface 网页加载进度事件{
    fun 进度改变(浏览器: WebView?, 进度:Int?)
}

//===========================================================================================

fun 网络浏览器客户端事件.接收标题事件(
    内容代码: (浏览器: WebView, 标题: String) -> Unit
): 网络浏览器客户端事件 {
    接收标题 = object : 接收标题事件{
        override fun 接收标题(浏览器: WebView?, 标题: String?) {
            内容代码(浏览器!!,标题!!)
        }
    }
    return this
}

fun 网络浏览器客户端事件.接收图标事件(
    内容代码: (浏览器: WebView,图标: Bitmap) -> Unit
): 网络浏览器客户端事件 {
    接收图标 = object : 接收图标事件{
        override fun 接收图标(浏览器: WebView?, 图标: Bitmap?) {
            内容代码(浏览器!!,图标!!)
        }
    }
    return this
}

fun 网络浏览器客户端事件.网页加载进度事件(
    内容代码: (浏览器: WebView,进度:Int) -> Unit
): 网络浏览器客户端事件 {
    网页加载进度 = object : 网页加载进度事件{
        override fun 进度改变(浏览器: WebView?, 进度: Int?) {
            内容代码(浏览器!!,进度!!)
        }
    }
    return this
}
