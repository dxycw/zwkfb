package com.dxyc.zwkfb

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.sun.jna.Native
import com.sun.jna.WString
import com.sun.jna.platform.win32.WinDef
import com.sun.jna.win32.W32APIOptions

// 使用 Unicode 版本（W 后缀）的 Windows API
interface User32 : W32APIOptions {
    // Unicode 版本，接收宽字符（WCHAR*）
    fun FindWindowW(lpClassName: WString?, lpWindowName: WString?): WinDef.HWND?
    fun GetWindowTextW(hWnd: WinDef.HWND?, lpString: CharArray, nMaxCount: Int): Int
    // 获取窗口标题所需的长度
    fun GetWindowTextLengthW(hWnd: WinDef.HWND?): Int

    companion object {
        val INSTANCE: User32 = Native.load(
            "user32",
            User32::class.java,
            W32APIOptions.UNICODE_OPTIONS  // 关键：使用 Unicode 选项
        )
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "JNA Unicode Demo"
    ) {
        var windowTitle by remember { mutableStateOf("点击按钮获取窗口标题") }

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                // 使用 WString 传递 Unicode 字符串
                val hWnd = User32.INSTANCE.FindWindowW(WString("Notepad"), null)

                if (hWnd != null) {
                    // 先获取标题长度
                    val length = User32.INSTANCE.GetWindowTextLengthW(hWnd)
                    if (length > 0) {
                        // 分配足够大的 CharArray（WCHAR 是 2 字节）
                        val buffer = CharArray(length + 1)
                        User32.INSTANCE.GetWindowTextW(hWnd, buffer, buffer.size)
                        val rawTitle = String(buffer).trimEnd('\u0000')
                        windowTitle = rawTitle.substringBefore(" - Notepad")
                    } else {
                        windowTitle = "窗口无标题"
                    }
                } else {
                    windowTitle = "未找到记事本窗口"
                }
            }) {
                Text("获取记事本窗口标题")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "标题: $windowTitle",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

//fun main() = application {
//    Window(
//        onCloseRequest = ::exitApplication,
//        title = "中文开发包 - 表单示例",
//        state = WindowState(position = WindowPosition.Aligned(Alignment.Center)),
//    ) {
//        App()
////        SwingPanel(
////            factory = {
////                JFXPanel().apply {
////                    val titleLabel = Label("用户注册")
////                    titleLabel.style = "-fx-font-size: 24px; -fx-font-weight: bold;"
////
////                    val nameLabel = Label("姓名：")
////                    val nameField = TextField()
////                    nameField.promptText = "请输入姓名"
////
////                    val emailLabel = Label("邮箱：")
////                    val emailField = TextField()
////                    emailField.promptText = "请输入邮箱"
////
////                    val addressLabel = Label("地址：")
////                    val addressArea = TextArea()
////                    addressArea.promptText = "请输入详细地址"
////                    addressArea.prefRowCount = 3
////
////                    addressArea.style = """
////                        -fx-font-size: 14px;
////                        -fx-control-inner-background: white;
////                    """.trimIndent()
////
////                    val passwordLabel = Label("密码：")
////                    val passwordField = TextField()
////                    passwordField.promptText = "请输入密码"
////
////                    val registerButton = Button("注册")
////                    registerButton.style = "-fx-font-size: 16px; -fx-padding: 10px 30px; -fx-background-color: #007bff; -fx-text-fill: white; -fx-background-radius: 5px;"
////
////                    val formVBox = VBox(10.0,
////                        titleLabel,
////                        nameLabel,
////                        nameField,
////                        emailLabel,
////                        emailField,
////                        addressLabel,
////                        addressArea,
////                        passwordLabel,
////                        passwordField,
////                        registerButton
////                    )
////
////                    formVBox.alignment = Pos.CENTER_LEFT
////                    formVBox.style = "-fx-padding: 30px; -fx-background-color: #f5f5f5;"
////
////                    this.scene = Scene(formVBox, 400.0, 600.0)
////                }
////            },
////            modifier = Modifier.fillMaxSize(),
////        )
//    }
//}


//package com.dxyc.zwkfb
//
//import androidx.compose.ui.window.Window
//import androidx.compose.ui.window.application
//
//fun main() = application {
//    Window(
//        onCloseRequest = ::exitApplication,
//        title = "Zwkfbmultiplatform",
//    ) {
//        App()
//    }
//}