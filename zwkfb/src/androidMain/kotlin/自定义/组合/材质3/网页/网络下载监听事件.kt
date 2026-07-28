package 自定义.组合.材质3.网页

import android.webkit.DownloadListener

var 网络下载监听: 网络下载监听事件 = 网络下载监听事件()

//===========================================================================================

private var 网络下载监听1: 网络下载监听事件1? = null


//===========================================================================================

open class 网络下载监听事件 : DownloadListener {
    open lateinit var 状态: 浏览器状态
        internal set

    override fun onDownloadStart(
        url: String?, userAgent: String?, contentDisposition: String?,
        mimetype: String?, contentLength: Long) {
        状态.下载网址 = url!!
        状态.下载用户代理 = userAgent!!
        状态.下载内容处理 = contentDisposition!!
        状态.下载文件类型 = mimetype!!
        状态.下载内容长度 = contentLength
        if (网络下载监听1 != null){
            网络下载监听1!!.网络下载监听(url, userAgent, contentDisposition, mimetype, contentLength)
        }
    }
}

//===========================================================================================

private interface 网络下载监听事件1{
    fun 网络下载监听(网址: String?, 用户代理: String?, 内容处理: String?, 文件类型: String?, 内容长度: Long)
}

//===========================================================================================

fun 网络下载监听事件.下载监听事件(
    内容代码: (网址: String?, 用户代理: String?, 内容处理: String?, 文件类型: String?, 内容长度: Long) -> Unit
): 网络下载监听事件 {
    网络下载监听1 = object : 网络下载监听事件1 {
        override fun 网络下载监听(网址: String?, 用户代理: String?, 内容处理: String?, 文件类型: String?, 内容长度: Long) {
            内容代码(网址, 用户代理, 内容处理, 文件类型, 内容长度)
        }
    }
    return this
}


