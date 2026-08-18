package 自定义.系统

import java.awt.Desktop
import java.net.URI


actual fun 用默认浏览器打开网址(网址: String) {
    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
        Desktop.getDesktop().browse(URI(网址))
    } else {
        // Linux 某些桌面环境不支持 Desktop，用 Runtime 兜底
        val command = when {
            System.getProperty("os.name").lowercase().contains("win") -> "rundll32 url.dll,FileProtocolHandler $网址"
            System.getProperty("os.name").lowercase().contains("mac") -> "open $网址"
            else -> "xdg-open $网址"
        }
        Runtime.getRuntime().exec(command)
    }
}