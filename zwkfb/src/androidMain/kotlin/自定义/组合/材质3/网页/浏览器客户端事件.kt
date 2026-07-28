package 自定义.组合.材质3.网页

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.webkit.ClientCertRequest
import android.webkit.HttpAuthHandler
import android.webkit.RenderProcessGoneDetail
import android.webkit.SafeBrowsingResponse
import android.webkit.SslErrorHandler
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient


var 浏览器客户端: 浏览器客户端事件 = 浏览器客户端事件()

//====================================================================================

private var 网页开始加载: 网页开始加载事件? = null
private var 网页完成加载: 网页完成加载事件? = null
private var 网页跳转拦截事件网址: 网页跳转拦截事件网址事件? = null
private var 网页跳转拦截事件请求: 网页跳转拦截事件请求事件? = null

private var 更新访问历史记录: 更新访问历史记录事件? = null

private var 接收错误: 接收错误事件? = null

private var 接收错误2: 接收错误2事件? = null

//====================================================================================

open class 浏览器客户端事件 : WebViewClient() {
    open lateinit var 状态: 浏览器状态
        internal set
    open lateinit var 导航状态: 浏览器导航
        internal set

    override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        状态.加载状态 = 网页加载状态.加载(0.0f)
        状态.请求的错误列表.clear() // 确保错误列表被清空
        状态.网页标题 = null // 确保标题被清空
        状态.网页图标 = null // 确保图标被清空

        状态.网页网址 = url // 保存当前加载的URL

        导航状态.可后退 = view.canGoBack() // 保存是否可后退
        导航状态.可前进 = view.canGoForward() // 确保是否可前进被保存

        if (网页开始加载 != null) {
            网页开始加载!!.网页开始加载(view, url, favicon)
        }
    }

    override fun onPageFinished(view: WebView, url: String?) {
        super.onPageFinished(view, url)
        状态.加载状态 = 网页加载状态.完成

        导航状态.可后退 = view.canGoBack()
        导航状态.可前进 = view.canGoForward()

        if (网页完成加载 != null) {
            网页完成加载!!.网页完成加载(view, url)
        }
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        if (网页跳转拦截事件网址 != null) {
            return 网页跳转拦截事件网址!!.网页跳转拦截(view, url)
        }
        return super.shouldOverrideUrlLoading(view, url)
    }

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return if (网页跳转拦截事件请求 != null) {
            网页跳转拦截事件请求!!.网页跳转拦截(view, request)
        }else{
            super.shouldOverrideUrlLoading(view, request)
        }
    }

    override fun doUpdateVisitedHistory(view: WebView, url: String?, isReload: Boolean) {
        super.doUpdateVisitedHistory(view, url, isReload)
        if (更新访问历史记录 != null) {
            更新访问历史记录!!.更新访问历史记录(view, url, isReload)
        }
    }

    override fun onReceivedError(view: WebView, request: WebResourceRequest?, error: WebResourceError?) {
        super.onReceivedError(view, request, error)
        if (error != null) {
            状态.请求的错误列表.add(浏览器错误(request, error))
        }
        if (接收错误 != null) {
            接收错误!!.接收错误(view, request, error)
        }
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
        super.onReceivedError(view, errorCode, description, failingUrl)
        if (接收错误2 != null) {
            接收错误2!!.接收错误(view, errorCode, description, failingUrl)
        }
    }

    override fun onFormResubmission(view: WebView?, dontResend: Message?, resend: Message?) {
        super.onFormResubmission(view, dontResend, resend)
    }

    override fun onLoadResource(view: WebView?, url: String?) {
        super.onLoadResource(view, url)
    }

    override fun onPageCommitVisible(view: WebView?, url: String?) {
        super.onPageCommitVisible(view, url)
    }

    override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) {
        super.onReceivedClientCertRequest(view, request)
    }

    override fun onReceivedHttpAuthRequest(view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm)
    }

    override fun onReceivedHttpError(view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) {
        super.onReceivedHttpError(view, request, errorResponse)
    }

    override fun onReceivedLoginRequest(view: WebView?, realm: String?, account: String?, args: String?) {
        super.onReceivedLoginRequest(view, realm, account, args)
    }

    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
        super.onReceivedSslError(view, handler, error)
    }

    override fun onRenderProcessGone(view: WebView?, detail: RenderProcessGoneDetail?): Boolean {
        return super.onRenderProcessGone(view, detail)
    }

    override fun onSafeBrowsingHit(
        view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponse?
    ) {
        super.onSafeBrowsingHit(view, request, threatType, callback)
    }

    override fun onScaleChanged(view: WebView?, oldScale: Float, newScale: Float) {
        super.onScaleChanged(view, oldScale, newScale)
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onTooManyRedirects(view: WebView?, cancelMsg: Message?, continueMsg: Message?) {
        super.onTooManyRedirects(view, cancelMsg, continueMsg)
    }

    override fun onUnhandledKeyEvent(view: WebView?, event: KeyEvent?) {
        super.onUnhandledKeyEvent(view, event)
    }

    override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?): WebResourceResponse? {
        return super.shouldInterceptRequest(view, request)
    }

    override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
        return super.shouldOverrideKeyEvent(view, event)
    }
}

//====================================================================================

interface 网页开始加载事件{
    fun 网页开始加载(浏览器: WebView?, 网址: String?, 图标: Bitmap?)
}
interface 网页完成加载事件{
    fun 网页完成加载(浏览器: WebView?, 网址: String?)
}

interface 网页跳转拦截事件网址事件{
    fun 网页跳转拦截(浏览器: WebView?, 网址: String?): Boolean
}
interface 网页跳转拦截事件请求事件{
    fun 网页跳转拦截(浏览器: WebView?, 请求:WebResourceRequest?): Boolean
}

interface 更新访问历史记录事件{
    fun 更新访问历史记录(浏览器: WebView?, 请求:String?,是否重载:Boolean?)
}

interface 接收错误事件{
    fun 接收错误(浏览器: WebView?, 请求:WebResourceRequest?,错误:WebResourceError?)
}

interface 接收错误2事件{
    fun 接收错误(浏览器: WebView?, 错误代码: Int, 错误描述: String?, 失败的URL: String?)
}

//====================================================================================

fun 浏览器客户端事件.网页开始加载事件(
    内容代码: (浏览器: WebView, 网址:String, 图标: Bitmap) -> Unit
): 浏览器客户端事件{
    网页开始加载 = object : 网页开始加载事件{
        override fun 网页开始加载(浏览器: WebView?, 网址: String?, 图标: Bitmap?) {
            内容代码(浏览器!!,网址!!,图标!!)
        }
    }
    return this
}

fun 浏览器客户端事件.网页完成加载事件(
    内容代码: (浏览器: WebView,网址:String) -> Unit
): 浏览器客户端事件{
    网页完成加载 = object : 网页完成加载事件{
        override fun 网页完成加载(浏览器: WebView?, 网址: String?) {
            内容代码(浏览器!!,网址!!)
        }
    }
    return this
}


fun 浏览器客户端事件.网页跳转拦截事件网址事件(
    内容代码: (浏览器: WebView,网址:String) -> Boolean
): 浏览器客户端事件{
    网页跳转拦截事件网址 = object : 网页跳转拦截事件网址事件{
        override fun 网页跳转拦截(浏览器: WebView?, 网址: String?): Boolean {
            return 内容代码(浏览器!!,网址!!)
        }
    }
    return this
}

fun 浏览器客户端事件.网页跳转拦截事件请求事件(
    内容代码: (浏览器: WebView,请求:WebResourceRequest) -> Boolean
): 浏览器客户端事件{
    网页跳转拦截事件请求 = object : 网页跳转拦截事件请求事件{
        override fun 网页跳转拦截(浏览器: WebView?, 请求: WebResourceRequest?): Boolean {
            return 内容代码(浏览器!!,请求!!)
        }
    }
    return this
}
