package com.dxyc.zwkfb

//// 使用 Unicode 版本（W 后缀）的 Windows API
//interface User32 : W32APIOptions {
//    // Unicode 版本，接收宽字符（WCHAR*）
//    fun FindWindowW(lpClassName: WString?, lpWindowName: WString?): WinDef.HWND?
//    fun GetWindowTextW(hWnd: WinDef.HWND?, lpString: CharArray, nMaxCount: Int): Int
//    // 获取窗口标题所需的长度
//    fun GetWindowTextLengthW(hWnd: WinDef.HWND?): Int
//
//    companion object {
//        val INSTANCE: User32 = Native.load(
//            "user32",
//            User32::class.java,
//            W32APIOptions.UNICODE_OPTIONS  // 关键：使用 Unicode 选项
//        )
//    }
//}
//
//fun main() = application {
//    Window(
//        onCloseRequest = ::exitApplication,
//        title = "JNA Unicode Demo"
//    ) {
//        var windowTitle by remember { mutableStateOf("点击按钮获取窗口标题") }
//
//        Column(
//            modifier = Modifier.fillMaxSize().padding(16.dp),
//            verticalArrangement = Arrangement.Center
//        ) {
//            Button(onClick = {
//                // 使用 WString 传递 Unicode 字符串
//                val hWnd = User32.INSTANCE.FindWindowW(WString("Notepad"), null)
//
//                if (hWnd != null) {
//                    // 先获取标题长度
//                    val length = User32.INSTANCE.GetWindowTextLengthW(hWnd)
//                    if (length > 0) {
//                        // 分配足够大的 CharArray（WCHAR 是 2 字节）
//                        val buffer = CharArray(length + 1)
//                        User32.INSTANCE.GetWindowTextW(hWnd, buffer, buffer.size)
//                        val rawTitle = String(buffer).trimEnd('\u0000')
//                        windowTitle = rawTitle.substringBefore(" - Notepad")
//                    } else {
//                        windowTitle = "窗口无标题"
//                    }
//                } else {
//                    windowTitle = "未找到记事本窗口"
//                }
//            }) {
//                Text("获取记事本窗口标题")
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Text(
//                text = "标题: $windowTitle",
//                style = MaterialTheme.typography.bodyLarge
//            )
//        }
//    }
//}

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

import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.formdev.flatlaf.FlatLightLaf
import java.awt.Color
import java.awt.Insets
import javax.swing.UIManager


fun main() = application {

    // ===== 菜单栏顶级菜单（JMenu）的圆角选中效果 =====
    UIManager.put("MenuBar.margin", Insets(5, 0, 5, 0))
    UIManager.put("MenuBar.selectionArc", 10) // 圆角直径（半径=4）
    UIManager.put("MenuBar.selectionInsets", Insets(10, 5, 10, 5)) // 普通菜单栏边距
    UIManager.put("MenuBar.selectionEmbeddedInsets", Insets(8, 3, 8, 3)) // 嵌入标题栏时的边距
    UIManager.put("MenuBar.itemMargins", Insets(10, 10, 10, 10)) // 菜单项文字边距


    // 颜色配置（IntelliJ Light 风格）
    UIManager.put("MenuBar.hoverBackground", Color(0xE8E8E8)) // 悬停背景色（浅灰）
    UIManager.put("MenuBar.selectionBackground", Color(0xD4D4D4)) // 选中背景色（稍深）
    UIManager.put("MenuBar.selectionForeground", Color(0x000000)) // 选中文字色

    // 可选：菜单栏底部边框颜色
    UIManager.put("MenuBar.borderColor", Color(0xC9C9C9))


    // ===== 弹出菜单项（JMenu）的圆角选中效果 =====
    UIManager.put("Menu.selectionArc", 10)
    UIManager.put("Menu.selectionInsets", Insets(0, 5, 0, 5))
    UIManager.put("Menu.margin", Insets(5, 12, 5, 12))
    UIManager.put("Menu.selectionBackground", Color(0xE8E8E8))
    UIManager.put("Menu.selectionForeground", Color(0x000000))

    // ===== 弹出菜单项（JMenuItem）的圆角选中效果 =====
    UIManager.put("MenuItem.selectionArc", 10)
    UIManager.put("MenuItem.selectionInsets", Insets(0, 5, 0, 5))
    UIManager.put("MenuItem.margin", Insets(5, 12, 5, 12))
    UIManager.put("MenuItem.selectionBackground", Color(0xE8E8E8))
    UIManager.put("MenuItem.selectionForeground", Color(0x000000))


//    UIManager.put("CheckBoxMenuBar.margin", Insets(10, 10, 10, 10))
//    UIManager.put("RadioButtonMenuBar.margin", Insets(10, 10, 10, 10))
//    UIManager.put("CheckBoxMenu.margin", Insets(10, 10, 10, 10))
//    UIManager.put("RadioButtonMenu.margin", Insets(10, 10, 10, 10))
//
//    UIManager.put("CheckBoxMenuItem.margin", Insets(0, 5, 0, 5))
//    UIManager.put("RadioButtonMenuItem.margin", Insets(0, 5, 0, 5))

    // 系统属性配置（必须在任何 Swing 组件创建前）
    System.setProperty("flatlaf.useWindowDecorations", "true")
    System.setProperty("flatlaf.menuBarEmbedded", "true")

    // 初始化主题
    FlatLightLaf.setup()

    Window(
        onCloseRequest = ::exitApplication,
        title = "中文开发包",
        icon = painterResource("drawable/compose-multiplatform.xml")
    ) {

        // 场景 2：自定义标题栏高度
        this.window.getRootPane().putClientProperty("JRootPane.titleBarHeight", 45);

        MenuBar {
            Menu("<html>文件(<u>F</u>)</html>", mnemonic = 'F') { // 文件(F̲)
                Menu("<html>新建(<u>N</u>)</html>"){
                    Item(
                        "<html>新建项目(<u>N</u>)</html>",
                        shortcut = KeyShortcut(key = Key.N, ctrl = true, alt = true)
                    ){}
                    Item("<html>打开项目(<u>O</u>)</html>"){}
                    Item("<html>保存项目(<u>S</u>)</html>"){}
                }
                Item(
                    "<html>打开项目(<u>O</u>)</html>",
                    icon = painterResource("drawable/compose-multiplatform.xml"),
                    shortcut = KeyShortcut(key = Key.O, ctrl = true, alt = true)
                ){}
                Separator()
                Item(
                    "<html>保存项目(<u>S</u>)</html>",
                    icon = painterResource("drawable/compose-multiplatform.xml"),
                    shortcut = KeyShortcut(key = Key.S, ctrl = true, alt = true)
                ){}
                Item("<html>退出(<u>X</u>)</html>"){
                    exitApplication()
                }
            }
            Menu("<html>编辑(<u>E</u>)</html>", mnemonic = 'E') { // 编辑(E̲)
                Item("新建"){}
                Item("打开"){}
                Item("保存"){}
                Item("退出"){}
            }
            Menu("<html>视图(<u>V</u>)</html>", mnemonic = 'V') { // 视图(V̲)
                Item("新建"){}
                Item("打开"){}
                Item("保存"){}
                Item("退出"){}
            }
        }

        App()
    }
}







