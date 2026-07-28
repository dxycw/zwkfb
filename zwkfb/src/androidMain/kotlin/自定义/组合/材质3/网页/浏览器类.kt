package 自定义.组合.材质3.网页

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import 安卓x.组合.界面.单位.有固定宽度
import 安卓x.组合.界面.单位.有固定高度
import 安卓x.组合.界面.视图互操作.安卓视图
import 安卓x.组合.运行时.记住

@SuppressLint("ComposableNaming","ModifierParameter")
@Composable
fun 浏览器(
    状态: 浏览器状态,
    修饰符: Modifier = Modifier,
    捕获返回键按下: Boolean = true,
    导航状态: 浏览器导航 = 记住浏览器导航状态(),
    浏览器配置: ((WebSettings) -> Unit)? = null,
    浏览器客户端事件: 浏览器客户端事件 = 浏览器客户端,
    网络浏览器客户端事件: 网络浏览器客户端事件 = 网络浏览器客户端,
    下载监听事件: 网络下载监听事件 = 网络下载监听,
    销毁浏览器: ((WebView) -> Unit)? = null,
    重置浏览器: ((WebView) -> Unit)? = null,
    更新内容: ((WebView) -> Unit)? = null
) = BoxWithConstraints(修饰符) {
    // WebView 根据其 layoutParams 改变布局策略。 我们在这里将 Compose Modifier 转换为布局参数。
    val 宽度 = if (this.constraints.有固定宽度) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT
    val 高度 = if (this.constraints.有固定高度) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT
    val 布局参数 = FrameLayout.LayoutParams(宽度, 高度)
    浏览器(状态, 布局参数, 修饰符, 捕获返回键按下, 导航状态, 浏览器配置, 浏览器客户端事件, 网络浏览器客户端事件,
        下载监听事件, 销毁浏览器, 重置浏览器, 更新内容)
}


@SuppressLint("ComposableNaming","ModifierParameter")
@Composable
fun 浏览器(
    状态: 浏览器状态,
    布局参数: FrameLayout.LayoutParams,
    修饰符: Modifier = Modifier,
    捕获返回键按下: Boolean = true,
    导航状态: 浏览器导航 = 记住浏览器导航状态(),
    浏览器配置: ((WebSettings) -> Unit)? = null,
    浏览器客户端事件: 浏览器客户端事件 = 浏览器客户端,
    网络浏览器客户端事件: 网络浏览器客户端事件 = 网络浏览器客户端,
    下载监听事件: 网络下载监听事件 = 网络下载监听,
    销毁浏览器: ((WebView) -> Unit)? = null,
    重置浏览器: ((WebView) -> Unit)? = null,
    更新内容: ((WebView) -> Unit)? = null
) {
    val 预览模式 = LocalInspectionMode.current
    val 浏览器 = 状态.浏览器
    BackHandler(捕获返回键按下 && 导航状态.可后退) {
        浏览器?.goBack()
    }
    浏览器?.let {
        DisposableEffect(it) { // 销毁
            onDispose {
                // 避免内存泄漏
                it.stopLoading() // 停止加载
                it.destroy() // 销毁
            }
        }
        LaunchedEffect(it, 导航状态) {
            with(导航状态) {
                it.处理导航事件()
            }
        }
        LaunchedEffect(it, 状态) {
            snapshotFlow { 状态.内容 }.collect { 内容 ->
                when (内容) {
                    is 网页内容类.网址 -> {
                        it.loadUrl(内容.网址, 内容.附加HTTP头)
                    }
                    is 网页内容类.数据 -> {
                        it.loadDataWithBaseURL(
                            内容.基础网址, 内容.数据, 内容.媒体类型,
                            内容.编码, 内容.历史网址
                        )
                    }
                    is 网页内容类.提交 -> {
                        it.postUrl(内容.网址, 内容.提交数据)
                    }
                    is 网页内容类.NavigatorOnly -> {
                        // NO-OP
                    }
                    else -> {
                        throw IllegalStateException("Unknown WebContent type: $内容")
                    }
                }
            }
        }
    }

    浏览器客户端事件.状态 = 状态
    浏览器客户端事件.导航状态 = 导航状态
    网络浏览器客户端事件.状态 = 状态
    下载监听事件.状态 = 状态

    安卓视图(
        原生 = { 上下文 ->
            WebView(上下文).apply {
                this.layoutParams = 布局参数
                状态.视图状态?.let { this.restoreState(it) }
                浏览器配置?.invoke(this.settings)
                this.setWebViewClient(浏览器客户端事件)
                this.setWebChromeClient(网络浏览器客户端事件)
                this.setDownloadListener(下载监听事件)

            }.also {
                状态.浏览器 = it
                状态.上下文 = 上下文
            }
        },
        修饰符 = 修饰符,
        重置回调 = { 重置浏览器?.invoke(it) },
        释放回调 = { 销毁浏览器?.invoke(it) },
        更新 = { 更新内容?.invoke(it) }
    )
}

//=============================================================================================

// 这里我们重新创建状态而不是使用 .apply {}，这样可以防止
// 当webview自己更新url时出现的重组循环
@Composable
fun 记住浏览器状态(网址: String): 浏览器状态 =
    记住 { 浏览器状态(网页内容类.网址(网址)) }.apply { this.内容 = 网页内容类.网址(网址) }

// 这里我们重新创建状态而不是使用 .apply {}，这样可以防止
// 当webview自己更新url时出现的重组循环
@Composable
fun 记住浏览器状态(网址: String, 附加HTTP头: Map<String, String> = emptyMap()): 浏览器状态 =
    记住 { 浏览器状态(网页内容类.网址(网址, 附加HTTP头))
    }.apply { this.内容 = 网页内容类.网址(网址, 附加HTTP头) }

//=============================================================================================

/**
 * 创建一个在组合间被记住的WebView状态。
 * 这里我们重新创建状态而不是使用 .apply {}，这样可以防止当webview自己更新url时出现的重组循环
 * @param 网址 要在WebView中加载的网址
 * @param 提交数据 要随网址一起发送到WebView的数据
 */
@Composable
fun 记住浏览器状态(网址: String, 提交数据: ByteArray): 浏览器状态 =
    记住 { 浏览器状态(网页内容类.提交(网址, 提交数据)) }.apply { this.内容 = 网页内容类.提交(网址,提交数据) }

//=============================================================================================

/**
 * 创建一个在组合间被记住的WebView状态。
 * @param 数据 要在WebView中加载的URI
 * @param 基础网址 基础网址
 * @param 编码 编码
 * @param 媒体类型 媒体类型
 * @param 历史网址 历史网址
 */
@Composable
fun 记住浏览器状态与HTML数据(
    数据: String, 基础网址: String? = null, 编码: String = "utf-8", 媒体类型: String? = null,
    历史网址: String? = null
): 浏览器状态 = 记住 { 浏览器状态(网页内容类.数据(数据, 基础网址, 编码, 媒体类型, 历史网址))
}.apply { this.内容 = 网页内容类.数据(数据, 基础网址, 编码, 媒体类型, 历史网址) }

//=============================================================================================

/**
 * 使用默认的 [协程作用域] 或提供的覆盖来创建并记住一个 [浏览器导航]。
 */
@Composable
fun 记住浏览器导航状态(协程作用域: CoroutineScope = rememberCoroutineScope()): 浏览器导航 =
    记住(协程作用域) { 浏览器导航(协程作用域) }

//=============================================================================================

/**
 * 创建一个在组合间被记住并在Activity重建时保存的WebView状态。
 * 当使用保存的状态时，您不能通过重组来更改URL。加载URL的唯一方式是通过浏览器导航。
 */
@Composable
fun 记住浏览器状态(): 浏览器状态 = 记住(网页保存器) { 浏览器状态(网页内容类.NavigatorOnly) }

//==============================================================================================

val 网页保存器: Saver<浏览器状态, Any> = run {
    val pageTitleKey = "pagetitle"
    val lastLoadedUrlKey = "lastloaded"
    val stateBundle = "bundle"
    mapSaver(
        save = {
            val 视图状态 = Bundle().apply { it.浏览器?.saveState(this) }
            mapOf(
                pageTitleKey to it.网页标题,
                lastLoadedUrlKey to it.网页网址,
                stateBundle to 视图状态
            )
        },
        restore = {
            浏览器状态(网页内容类.NavigatorOnly).apply {
                this.网页标题 = it[pageTitleKey] as String?
                this.网页网址 = it[lastLoadedUrlKey] as String?
                this.视图状态 = it[stateBundle] as Bundle?
            }
        }
    )
}

//=================================================================================

open class 浏览器状态(网页内容: 网页内容类) {

    internal var 上下文 by mutableStateOf<Context?>(null)
    /**
     * 我们需要在状态保存器中访问这个变量。内部的 DisposableEffect 或 AndroidView
     * 的 onDestroy 方法在状态保存器之后被调用，因此不能使用。
     */
    internal var 浏览器 by mutableStateOf<WebView?>(null)
    
    /**
     *  浏览器正在加载的内容
     */
    var 内容: 网页内容类 by mutableStateOf(网页内容)

    /**
     * WebView当前是否正在[网页加载状态.加载]主框架中的数据（包括进度），或者数据加载已经[网页加载状态.完成]。
     * 参见[网页加载状态]
     */
    var 加载状态: 网页加载状态 by mutableStateOf(网页加载状态.初始化)
        internal set

    /**
     * WebView当前是否正在其主框架中加载数据
     */
    val 是否加载: Boolean
        get() = 加载状态 !is 网页加载状态.完成

    /**
     * 从当前页面加载的内容中接收到的标题
     */
    var 网页标题: String? by mutableStateOf(null)
        internal set

    /**
     *  上次加载的URL
     */
    var 网页网址: String? by mutableStateOf(null)
        internal set

    /**
     * 从当前页面加载的内容中接收到的网站图标
     */
    var 网页图标: Bitmap? by mutableStateOf(null)
        internal set

    /**
     * 一个用于记录上次加载过程中捕获的错误列表。当加载新页面时会重置。错误可能来自任何资源（iframe、图片等），
     * 而不仅仅是主页面。如需更精细的控制，请使用WebView的OnError回调
     */
    val 请求的错误列表: SnapshotStateList<浏览器错误> = mutableStateListOf()

    /**
     * 上次视图被销毁时保存的视图状态。要恢复状态，请使用导航器，并且只有在bundle为null时才调用loadUrl。
     * 参见WebViewSaveStateSample。
     */
    var 视图状态: Bundle? = null
        internal set

//===================================新属性=================================================

    var 下载网址: String by mutableStateOf("")
        internal set
    var 下载用户代理: String by mutableStateOf("")
        internal set
    var 下载内容处理: String by mutableStateOf("")
        internal set
    var 下载文件类型: String by mutableStateOf("")
        internal set
    var 下载内容长度: Long by mutableLongStateOf(0)
        internal set

}

//==============================================================================================

class 浏览器导航(private val 协程作用域: CoroutineScope) {
    private sealed interface 导航事件数据 {
        data object 后退 : 导航事件数据
        data object 前进 : 导航事件数据
        data object 重载 : 导航事件数据
        data object 停止加载 : 导航事件数据

        data class 加载网址(
            val 网址: String, val 附加HTTP头: Map<String, String> = emptyMap()
        ) : 导航事件数据

        data class 加载Html(
            val html: String, val baseUrl: String? = null, val mimeType: String? = null,
            val encoding: String? = "utf-8", val historyUrl: String? = null
        ) : 导航事件数据

        data class 提交网址(val 网址: String, val 提交数据: ByteArray) : 导航事件数据 {
            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false
                other as 提交网址
                if (网址 != other.网址) return false
                if (!提交数据.contentEquals(other.提交数据)) return false
                return true
            }

            override fun hashCode(): Int {
                var result = 网址.hashCode()
                result = 31 * result + 提交数据.contentHashCode()
                return result
            }
        }
    }

    private val 导航事件: MutableSharedFlow<导航事件数据> = MutableSharedFlow(replay = 1)

    /**
     * 使用 Dispatchers.Main 确保 WebView 方法在 UI 线程上调用
     */
    @Suppress("REDUNDANT_ELSE_IN_WHEN")
    internal suspend fun WebView.处理导航事件(): Nothing = withContext(Dispatchers.Main) {
        导航事件.collect { event ->
            when (event) {
                is 导航事件数据.后退 -> goBack()
                is 导航事件数据.前进 -> goForward()
                is 导航事件数据.重载 -> reload()
                is 导航事件数据.停止加载 -> stopLoading()
                is 导航事件数据.加载Html -> loadDataWithBaseURL(
                    event.baseUrl, event.html, event.mimeType,
                    event.encoding, event.historyUrl
                )
                is 导航事件数据.加载网址 -> {
                    loadUrl(event.网址, event.附加HTTP头)
                }
                is 导航事件数据.提交网址 -> { postUrl(event.网址, event.提交数据) }
                else -> {}
            }
        }
    }

    /**
     * 当 WebView 能够向后导航时为 true，否则为 false。
     */
    var 可后退: Boolean by mutableStateOf(false)
        internal set

    /**
     * 当 WebView 能够向前导航时为 true，否则为 false。
     */
    var 可前进: Boolean by mutableStateOf(false)
        internal set

    fun 加载网址(网址: String, 附加HTTP头: Map<String, String> = emptyMap()) {
        协程作用域.launch { 导航事件.emit(导航事件数据.加载网址(网址, 附加HTTP头)) }
    }

    fun 加载Html(
        html: String, baseUrl: String? = null, mimeType: String? = null,
        encoding: String? = "utf-8", historyUrl: String? = null
    ) {
        协程作用域.launch {
            导航事件.emit(导航事件数据.加载Html(html, baseUrl, mimeType, encoding, historyUrl))
        }
    }

    fun 提交地址(网址: String, 提交数据: ByteArray) {
        协程作用域.launch { 导航事件.emit(导航事件数据.提交网址(网址, 提交数据)) }
    }

    /**
     * 使 WebView 导航回到上一页。
     */
    fun 后退() { 协程作用域.launch { 导航事件.emit(导航事件数据.后退) } }

    /**
     * 在从页面返回后，使 WebView 向前导航。
     */
    fun 前进() { 协程作用域.launch { 导航事件.emit(导航事件数据.前进) } }

    /**
     * 重新加载 WebView 中的当前页面。
     */
    fun 重载() { 协程作用域.launch { 导航事件.emit(导航事件数据.重载) } }

    /**
     * 停止当前页面的加载（如果正在加载的话）。
     */
    fun 停止加载() { 协程作用域.launch { 导航事件.emit(导航事件数据.停止加载) } }
}

//=============================================================================================

sealed class 网页内容类 {
    data class 网址(val 网址: String, val 附加HTTP头: Map<String, String> = emptyMap()) : 网页内容类()

    data class 数据(
        val 数据: String, val 基础网址: String? = null, val 编码: String = "utf-8",
        val 媒体类型: String? = null, val 历史网址: String? = null
    ) : 网页内容类()

    data class 提交(val 网址: String, val 提交数据: ByteArray) : 网页内容类() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as 提交

            if (网址 != other.网址) return false
            if (!提交数据.contentEquals(other.提交数据)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = 网址.hashCode()
            result = 31 * result + 提交数据.contentHashCode()
            return result
        }
    }

    @Suppress("REDUNDANT_ELSE_IN_WHEN")
    fun getCurrentUrl(): String? {
        return when (this) {
            is 网址 -> 网址
            is 数据 -> 基础网址
            is 提交 -> 网址
            is NavigatorOnly -> throw IllegalStateException("Unsupported")
            else -> { throw IllegalStateException("Unknown WebContent type: $this")}
        }
    }

    object NavigatorOnly : 网页内容类()
}

internal fun 网页内容类.带网址(网址: String) = when (this) {
    is 网页内容类.网址 -> copy(网址)
    else -> 网页内容类.网址(网址)
}

//=========================================================================================

sealed class 网页加载状态 {
    data object 初始化 : 网页加载状态() // 描述一个尚未首次加载的WebView。

    /**
     * 描述在 onPageStarted 和 onPageFinished 事件之间的WebView状态，包含一个由WebView更新的 [进度] 属性。
     */
    data class 加载(val 进度: Float) : 网页加载状态()

    data object 完成 : 网页加载状态() // 描述一个已完成内容加载的WebView。
}

//=====================================================================================

data class 浏览器错误(
    val 请求: WebResourceRequest?, //错误来源的请求。
    val 错误: WebResourceError //所报告的错误。
)

//==============================================================================================

@Suppress("DEPRECATION")
fun 浏览器配置(上下文: Activity, 配置: WebSettings) {
    配置.javaScriptEnabled = true
    配置.userAgentString = 浏览器配置集.Android.夸克UA // if (上下文.是否为平板()) 浏览器配置.Windows.夸克UA else

//    配置.domStorageEnabled = true
//    配置.useWideViewPort = true //启用支持自定义窗口。
//    配置.loadWithOverviewMode = true //启用支持内容大小。
//    配置.domStorageEnabled = true //启用 DOM 存储。
//    配置.allowFileAccess = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R //启用文件访问。
//    配置.setSupportZoom(true) //启用缩放。
//    配置.builtInZoomControls = true //启用缩放控制。
//    配置.displayZoomControls = false //禁用缩放控制。
//    配置.databaseEnabled = true //启用数据库。
//    配置.mixedContentMode = WebSettings.LOAD_CACHE_ONLY //混合内容
//    配置.javaScriptCanOpenWindowsAutomatically = true //启用 JavaScript 自动打开窗口。
//    配置.defaultTextEncodingName = "utf-8" //设置编码格式。
//    配置.cacheMode = WebSettings.LOAD_NO_CACHE //缓存模式。
//    配置.pluginState = WebSettings.PluginState.ON //启用插件。
//    配置.savePassword = true //保存密码。
//    配置.saveFormData = true //保存表单数据。
//    配置.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL //NARROW_COLUMNS
//    配置.loadsImagesAutomatically = true //启用图片。
//    配置.setGeolocationDatabasePath(上下文.getDir("database", 0).path) //启用定位数据库
//    配置.setGeolocationEnabled(true) //启用定位
//    配置.mediaPlaybackRequiresUserGesture = true //启用视频播放时需要用户手势
//    配置.allowFileAccessFromFileURLs = false //允许从文件URL访问文件
//    配置.allowUniversalAccessFromFileURLs = Build.VERSION.SDK_INT < 30 //允许从文件URL访问文件
//    //这个一定要设置为false 否则会弹出权限请求框
//    配置.setSupportMultipleWindows(false) //启用多窗口

//    val instance = CookieManager.getInstance() //启用Cookie
//    instance.setAcceptCookie(true) //启用Cookie
//    instance.setAcceptThirdPartyCookies(this, true) //启用第三方Cookie
//    可用Cookie() //启用Cookie
}

//@SuppressLint("NewApi")
//private fun 可用Cookie(浏览器控件: 浏览器?) {
//    val instance = CookieManager.getInstance()
//    instance.setAcceptCookie(true)
//    instance.setAcceptThirdPartyCookies(浏览器控件, true)
//}

fun 网页跳转拦截事件请求(
    上下文: Activity,
    网址请求: WebResourceRequest?
): Boolean{
//    吐司.自定义信息提示(上下文,
//        "请求网址：${网址请求.url}, 请求方式：${网址请求.method}, 请求头：${网址请求.requestHeaders}, 请求协议：${网址请求.url.scheme}",
//        吐司.短).显示()

    val 网页协议列表 = arrayOf(
        "http://m.baidu.com",
        "baiduboxapp", //     baiduboxapp: 百度;
        "baiduboxlite", //     baiduboxlite: 百度极速版;
        "mttbrowser", //     mttbrowser: 搜狗搜索;
        "sohunews", //     sohunews: 搜狐新闻;
        "qqnews", //     qqnews: 腾讯新闻;
        "jiemiannews", //     jiemiannews: 界面新闻;
        "sinanews", //     sinanews: 新浪新闻;
        "snssdk32", //     snssdk32: 西瓜视频;
        "bilibili",  //     bilibili: 哔哩哔哩;
        "baiduhaokan", //     baiduhaokan: 好看视频;
        "uniteqqreader", //     uniteqqreader: QQ阅读;
        "shuqi", //     shuqi: 书旗小说
        "dragon1967",  //     dragon1967: 番茄小说;
        "txcomicout", //     txcomicout: 腾讯漫画;
        "mqqopensdkapi", //     mqqopensdkapi: QQ;
        "alipays", //     alipays: 支付宝;
        "baidumap", //     baidumap: 百度地图;
        "amapuri", //     amapuri: 高德地图;
        "pan", //     pan: 123云盘;
        "yuexia" //     yuexia: 月匣;
    )
    for (网页协议 in 网页协议列表){
        if(网址请求?.url?.scheme == 网页协议){
            try {
                上下文.startActivity(Intent(Intent.ACTION_VIEW, 网址请求.url))
            }catch (e: Exception){
                Toast.makeText(上下文,"打开失败,未找到该应用！", Toast.LENGTH_SHORT).show()
            }
            return true
        }
    }
    return false
}


//        置网页跳转拦截事件(object : 网页跳转拦截事件请求{
//            override fun 网页跳转拦截(浏览器: WebView?, 请求: WebResourceRequest?): Boolean {
//                val url = 请求!!.url.toString()
//                网页链接头 = arrayListOf("snssdk1128://", "baiduboxapp://", "baiduboxlite://", "baiduhaokan://",
//                    "market://", "bilibili://", "wvhzpj://", "freereader://", "mttbrowser://", "baiduhaokan://", "sohunews://")
//                // 检查URL是否以http或https开头
//                for (值 in 网页链接头!!) {
//                    if (url.startsWith(值)) {
//                        try {
//                            //判断是否有应用，如果有运行此代码
//                            // 上面的参数中，url对应文件下载地址，mimetype对应下载文件的MIME类型
////                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));//创建 Intent
////                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// 设置启动模式
////                    上下文.startActivity(intent);// 启动 Intent
//                            return true
//                        } catch (e: Exception) { // 捕获异常
//                            //判断是否有应用，如果没有运行此代码
//
////                    if (!url.startsWith("market://") || !url.startsWith("freereader://")){
////                        new 对话框.构建器(上下文)
////                                .置标题("提示").置内容("是否打开外部应用")
////                                .setPositiveButton("确定", (dialog, which) -> {
////                                    //if (!公用设置.打开应用商店(上下文)){
////                                    //if (url.startsWith("baiduhaokan://")){
////                                    //    view.loadUrl("http://xbox.m.baidu.com/mo/home");
////                                    //}//else if (url.startsWith("wvhzpj://") ){
////                                    //    view.loadUrl("https://www.csdn.net/apps/download/");
////                                    //}
////
////                                    //Toast.makeText(上下文, String.valueOf(公用设置.是否是下载链接(url)), Toast.LENGTH_SHORT).show();
////                                    // }
////                                })
////                                .setPositiveButton("取消", (dialog, which) -> {
////                                    dialog.dismiss();
////                                })
////                                .show();
////                    }
//
//                            return true
//                        }
//                    } else {
//                        return false
//                    }
//                }
//                return false
//            }
//        })


//        置显示自定义视图事件(object : 显示自定义视图事件{
//            //override fun 显示自定义视图(视图: View?, 回调: WebChromeClient.CustomViewCallback?) {
////                if (网页视频控件 != null) {
////                    回调!!.onCustomViewHidden() // 隐藏自定义视图
////                    return
////                }
////                网页视频控件 = 视图
////                网页视频回调 = 回调
////                val decor = 上下文.window.decorView as FrameLayout //获取activity的根布局
////                decor.addView(视图, 帧布局.布局参数(-1, -1))
////
////                上下文!!.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE //横屏
////                状态栏沉浸式类.初始化沉浸式(上下文!!).状态栏导航栏透明().状态栏字体图标自动深色模式(
////                    !主题类.是否是深色模式(
////                        上下文!!
////                    )
////                ).导航栏图标自动深色模式(!主题类.是否是深色模式(上下文!!)).刷新()
////                状态栏沉浸式.隐藏状态栏导航栏(上下文!!)
//            //}
//        })
//        置隐藏自定义视图事件(object : 隐藏自定义视图事件 {
//            @SuppressLint("SourceLockedOrientationActivity")
//            override fun 隐藏自定义视图() {
//                if (网页视频控件 == null) {
//                    return
//                }
//
//                val decor = 上下文!!.window.decorView as FrameLayout //获取activity的根布局
//                decor.removeView(网页视频控件)
//                网页视频控件 = null
//                网页视频回调!!.onCustomViewHidden() //隐藏自定义视图
//                网页视频回调 = null
//
//                上下文!!.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED //默认
//                状态栏沉浸式类.初始化沉浸式(上下文!!).状态栏导航栏透明().状态栏字体图标自动深色模式(
//                    !主题类.是否是深色模式(
//                        上下文!!
//                    )
//                ).导航栏图标自动深色模式(!主题类.是否是深色模式(上下文!!)).刷新()
//
//                状态栏沉浸式.显示状态栏导航栏(上下文!!)
//            }
//        })



//    @Suppress("DEPRECATION")
//    fun 修复浏览器弹出键盘输入框位置的Bug(
//        上下文: Activity,
//        浏览器底部导航栏: View?,
//        浏览器进度条: View?
//    ) {
//        // 设置 Activity 的软键盘模式为 adjustResize
//        上下文.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
//        // 监听布局变化
//        val activityRootView = 上下文.findViewById<View>(android.R.id.content)
//        activityRootView.viewTreeObserver.addOnGlobalLayoutListener {
//            val r = Rect()
//            activityRootView.getWindowVisibleDisplayFrame(r) // 获取当前窗口可视区域
//            val screenHeight = activityRootView.rootView.height
//            val keyboardHeight = screenHeight - r.bottom // 键盘高度
//            if (keyboardHeight > 100) {
//                // 键盘弹出，增加 WebView 的底部内边距
//                this.setPadding(
//                    0, 0, 0, (keyboardHeight
//                            - (浏览器底部导航栏?.height ?: 0)
//                            - 状态栏沉浸式.用资源文件获取导航栏高度(上下文)
//                            - (浏览器进度条?.height ?: 0))
//                )
//            } else {
//                // 键盘关闭，重置 WebView 的底部内边距
//                this.setPadding(0, 0, 0, 0)
//            }
//        }
//    }