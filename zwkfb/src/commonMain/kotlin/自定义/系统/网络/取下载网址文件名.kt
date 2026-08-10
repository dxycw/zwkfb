package 自定义.系统.网络


/**
 * 从 URL 中提取文件名，自动解码 URL 编码
 */
fun 取下载网址文件名(url: String): String {
    // 先尝试从 URL 路径提取
    val fromPath = extractFromPath(url)
    if (fromPath != null) return fromPath

    // 兜底
    return "unknown"
}

private fun extractFromPath(url: String): String? {
    // 去掉查询参数和锚点
    val cleanUrl = url.substringBefore("?").substringBefore("#")

    return cleanUrl
        .substringAfterLast("/")
        .takeIf { it.isNotBlank() && it.contains(".") }
        ?.let { decodeUrl(it) }
}

/**
 * 纯 Kotlin URL 解码（支持 UTF-8 % 编码）
 */
private fun decodeUrl(encoded: String): String {
    val bytes = mutableListOf<Byte>()
    var i = 0
    while (i < encoded.length) {
        when {
            encoded[i] == '%' && i + 2 < encoded.length -> {
                val hex = encoded.substring(i + 1, i + 3)
                bytes.add(hex.toInt(16).toByte())
                i += 3
            }
            encoded[i] == '+' -> {
                bytes.add(' '.code.toByte())
                i++
            }
            else -> {
                bytes.add(encoded[i].code.toByte())
                i++
            }
        }
    }
    return bytes.toByteArray().decodeToString()
}

