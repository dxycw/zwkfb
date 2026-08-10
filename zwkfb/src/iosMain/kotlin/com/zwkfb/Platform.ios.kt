package com.zwkfb

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val platform: String = "iOS"
}

actual fun getPlatform(): Platform = IOSPlatform()

fun 解析Gitee文件内容(jsonString: String): Gitee文件内容 {
    val json = Json.parseToJsonElement(jsonString).jsonObject

    return Gitee文件内容(
        type = json["type"]?.jsonPrimitive?.content ?: "", // 文件类型
        encoding = json["encoding"]?.jsonPrimitive?.content ?: "",     // ← 对应 "encoding" 字段（值是 "base64"）
        size = json["size"]?.jsonPrimitive?.int ?: 0,            // ← 对应 "size" 字段（文件大小）
        name = json["name"]?.jsonPrimitive?.content ?: "",         // ← 对应 "name" 字段（文件名）
        path = json["path"]?.jsonPrimitive?.content ?: "",         // ← 对应 "path" 字段（文件路径）
        content = json["content"]?.jsonPrimitive?.content ?: "",      // ← 对应 JSON 里的 "content" 字段（Base64编码的文件内容）
        sha = json["sha"]?.jsonPrimitive?.content ?: "",          // ← 对应 "sha" 字段（文件哈希）
        url = json["url"]?.jsonPrimitive?.content ?: "",          // ← 对应 "url" 字段（文件URL）
        html_url = json["html_url"]?.jsonPrimitive?.content ?: "",     // ← 对应 "html_url" 字段（文件HTML URL）
        download_url = json["download_url"]?.jsonPrimitive?.content ?: "", // ← 对应 "download_url" 字段（文件下载URL）
        _links = links(
            self = json["self"]?.jsonPrimitive?.content ?: "",
            html = json["html"]?.jsonPrimitive?.content ?: "",
        )
    )
}
