package 自定义.系统

import kotlinx.browser.window


actual fun 用默认浏览器打开网址(网址: String) {
    window.open(网址, "_blank")
}