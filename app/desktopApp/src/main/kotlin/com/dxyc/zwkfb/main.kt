package com.dxyc.zwkfb


//fun main() = application {
//    Window(
//        onCloseRequest = ::exitApplication,
//        title = "中文开发包 - 表单示例",
//        state = WindowState(position = WindowPosition.Aligned(Alignment.Center)),
//    ) {
//        App()
//    }
//}

//fun main() = application {
//    Window(
//        onCloseRequest = ::exitApplication,
//        title = "中文开发包 - 表单示例",
//        state = WindowState(position = WindowPosition.Aligned(Alignment.Center)),
//    ) {
//        SwingPanel(
//            factory = {
//                JFXPanel().apply {
//                    val titleLabel = Label("用户注册")
//                    titleLabel.style = "-fx-font-size: 24px; -fx-font-weight: bold;"
//
//                    val nameLabel = Label("姓名：")
//                    val nameField = TextField()
//                    nameField.promptText = "请输入姓名"
//
//                    val emailLabel = Label("邮箱：")
//                    val emailField = TextField()
//                    emailField.promptText = "请输入邮箱"
//
//                    val addressLabel = Label("地址：")
//                    val addressArea = TextArea()
//                    addressArea.promptText = "请输入详细地址"
//                    addressArea.prefRowCount = 3
//
//                    addressArea.style = """
//                        -fx-font-size: 14px;
//                        -fx-control-inner-background: white;
//                    """.trimIndent()
//
//                    val passwordLabel = Label("密码：")
//                    val passwordField = TextField()
//                    passwordField.promptText = "请输入密码"
//
//                    val registerButton = javafx.scene.control.Button("注册")
//                    registerButton.style = "-fx-font-size: 16px; -fx-padding: 10px 30px; -fx-background-color: #007bff; -fx-text-fill: white; -fx-background-radius: 5px;"
//
//                    val formVBox = javafx.scene.layout.VBox(10.0,
//                        titleLabel,
//                        nameLabel,
//                        nameField,
//                        emailLabel,
//                        emailField,
//                        addressLabel,
//                        addressArea,
//                        passwordLabel,
//                        passwordField,
//                        registerButton
//                    )
//
//                    formVBox.alignment = Pos.CENTER_LEFT
//                    formVBox.style = "-fx-padding: 30px; -fx-background-color: #f5f5f5;"
//
//                    this.scene = Scene(formVBox, 400.0, 600.0)
//                }
//            },
//            modifier = Modifier.fillMaxSize(),
//        )
//    }
//}



import androidx.compose.ui.Modifier
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.DropdownMenuPopup
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.DialogWindow
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.rememberDialogState
import com.formdev.flatlaf.FlatLightLaf
import org.publicvalue.multiplatform.qrcode.CameraPosition
import org.publicvalue.multiplatform.qrcode.CodeType
import org.publicvalue.multiplatform.qrcode.Scanner
import org.publicvalue.multiplatform.qrcode.ScannerWithPermissions
import java.awt.Insets
import javax.swing.UIManager


//fun main() = application {
//    val windowState = rememberWindowState()
//
//    IntUiTheme(
//        theme = JewelTheme.lightThemeDefinition(),
//        styling = ComponentStyling.default().decoratedWindow(
//            titleBarStyle = TitleBarStyle.dark()
//        )
//    ) {
//        DecoratedWindow(
//            onCloseRequest = ::exitApplication,
//            state = windowState,
//            title = "Jewel Menu Demo"
//        ) {
//            // ========== 顶部菜单栏 ==========
//            TitleBar {
//                // 水平菜单栏（类似 IntelliJ 的顶部菜单）
//                MenuBar {
//                    Menu("File") {
//                        Item("New Project...", shortcut = KeyShortcut(Key.N, ctrl = true, shift = true)) { }
//                        Item("Open...", shortcut = KeyShortcut(Key.N, ctrl = true, shift = true)) { }
//                        Item("Recent Projects") { }
//                        Separator()
//                        Item("Settings...", shortcut = KeyShortcut(Key.N, ctrl = true, shift = true)) { }
//                        Separator()
//                        Item("Exit", shortcut = KeyShortcut(Key.N, ctrl = true, shift = true)) { exitApplication() }
//                    }
//
//                    Menu("Edit") {
//                        Item("Undo", shortcut = KeyShortcut(Key.Z, ctrl = true)) { }
//                        Item("Redo", shortcut = KeyShortcut(Key.Z, ctrl = true, shift = true)) { }
//                        Separator()
//                        Item("Cut", shortcut = KeyShortcut(Key.X, ctrl = true)) { }
//                        Item("Copy", shortcut = KeyShortcut(Key.C, ctrl = true)) { }
//                        Item("Paste", shortcut = KeyShortcut(Key.V, ctrl = true)) { }
//                    }
//
//                    Menu("View") {
//                        Item("Tool Windows") { }
//                        Item("Appearance") { }
//                        Item("Enter Full Screen", shortcut = KeyShortcut(Key.F, alt = true)) { }
//                    }
//
//                    Menu("Navigate") {
//                        Item("Class...", shortcut = KeyShortcut(Key.N, ctrl = true)) { }
//                        Item("File...", shortcut = KeyShortcut(Key.N, ctrl = true, shift = true)) { }
//                        Item("Symbol...", shortcut = KeyShortcut(Key.N, ctrl = true, alt = true, shift = true)) { }
//                    }
//
//                    Menu("Help") {
//                        Item("Find Action...", shortcut = KeyShortcut(Key.A, ctrl = true, shift = true)) { }
//                        Item("Tip of the Day") { }
//                        Separator()
//                        Item("About") { }
//                    }
//                }
//            }
//
//            // ========== 主内容区域 ==========
//            Text(
//                "主内容区域",
//                modifier = Modifier,
//                style = JewelTheme.defaultTextStyle
//            )
//        }
//    }
//}



//fun main() = application {
//    IntUiTheme(
//        theme = JewelTheme.lightThemeDefinition(),
//        styling = ComponentStyling.decoratedWindow(
//            windowStyle = DecoratedWindowStyle.light(
//                DecoratedWindowColors.light(
//                    borderColor = Color.Transparent,
//                    inactiveBorderColor = Color.Transparent,
//                ),
//                metrics = DecoratedWindowMetrics.defaults(0.dp)
//            )
//        )
//    ) {
//        DecoratedWindow(
//            onCloseRequest = ::exitApplication,
//            title = "Jewel IDEA 风格菜单 — 0.39.1",
//        ) {
//
//            TitleBar(Modifier.newFullscreenControls()) {
//                MyPluginMenu(true, {})
//            }
//
//            // ===== 主内容区 =====
//            Column(
//                modifier = Modifier.fillMaxSize().padding(16.dp)
//            ) {
//                Text(
//                    text = "Jewel 0.39.1 IDEA 风格菜单",
//                    style = JewelTheme.typography.medium
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = "使用 DecoratedWindow + TitleBar + Popup + Menu 实现",
//                    style = JewelTheme.typography.medium
//                )
//            }
//        }
//    }
//}




//fun main() = application {
//    IntUiTheme(
//        theme = JewelTheme.lightThemeDefinition(),
//        styling = ComponentStyling.decoratedWindow(
//            windowStyle = DecoratedWindowStyle.light(
////                DecoratedWindowColors.light(
////                    borderColor = Color.Transparent,
////                    inactiveBorderColor = Color.Transparent,
////                ),
////                metrics = DecoratedWindowMetrics.defaults(0.dp)
//            ),
//            titleBarStyle = TitleBarStyle.light(
////                TitleBarColors.light(
////                    backgroundColor = Color.White,
////                    inactiveBackground = Color.White,
////                )
//            ),
//        ),
//    ) {
//        DecoratedWindow(
//            onCloseRequest = ::exitApplication,
//            state = rememberWindowState(
//                width = 1200.dp,
//                height = 800.dp,
//                position = WindowPosition.Aligned(Alignment.Center)
//            ),
//            style = JewelTheme.defaultDecoratedWindowStyle,
//        ) {
//            TitleBar (
//                gradientStartColor = Color.Transparent,
//                style = TitleBarStyle.light(
//                    colors = TitleBarColors.light(
//                        backgroundColor = Color.White,
//                        inactiveBackground = Color.Transparent,
//                        borderColor = Color.Transparent,
//                    ),
//                ),
//            ){
//
////                // 标题栏整体布局
////                Row(
////                    modifier = Modifier
////                        .fillMaxSize()
////                        .padding(horizontal = 8.dp),
////                    verticalAlignment = Alignment.CenterVertically,
////                    horizontalArrangement = Arrangement.spacedBy(4.dp)
////                ) {
//                // 左侧：菜单按钮（汉堡菜单）或应用菜单
//                IconActionButton(
//                    key = AllIconsKeys.Actions.MenuOpen,
//                    onClick = { /* 打开主菜单 */ },
//                    contentDescription = "Main Menu"
//                )
//
//                // 分隔线
//                Divider(
//                    orientation = Orientation.Vertical,
//                    modifier = Modifier.height(20.dp)
//                )
//
//                // 水平菜单栏（类似 IntelliJ 的顶部菜单）
//                MenuBar {
//                    Menu("File") {
//                        Item("New Project...", shortcut = KeyShortcut(Key.N, ctrl = true, shift = true)) { }
//                        Item("Open...", shortcut = KeyShortcut(Key.N, ctrl = true, shift = true)) { }
//                        Item("Recent Projects") { }
//                        Separator()
//                        Item("Settings...", shortcut = KeyShortcut(Key.N, ctrl = true, shift = true)) { }
//                        Separator()
//                        Item("Exit", shortcut = KeyShortcut(Key.N, ctrl = true, shift = true)) { exitApplication() }
//                    }
//
//                    Menu("Edit") {
//                        Item("Undo", shortcut = KeyShortcut(Key.Z, ctrl = true)) { }
//                        Item("Redo", shortcut = KeyShortcut(Key.Z, ctrl = true, shift = true)) { }
//                        Separator()
//                        Item("Cut", shortcut = KeyShortcut(Key.X, ctrl = true)) { }
//                        Item("Copy", shortcut = KeyShortcut(Key.C, ctrl = true)) { }
//                        Item("Paste", shortcut = KeyShortcut(Key.V, ctrl = true)) { }
//                    }
//
//                    Menu("View") {
//                        Item("Tool Windows") { }
//                        Item("Appearance") { }
//                        Item("Enter Full Screen", shortcut = KeyShortcut(Key.F, alt = true)) { }
//                    }
//
//                    Menu("Navigate") {
//                        Item("Class...", shortcut = KeyShortcut(Key.N, ctrl = true)) { }
//                        Item("File...", shortcut = KeyShortcut(Key.N, ctrl = true, shift = true)) { }
//                        Item("Symbol...", shortcut = KeyShortcut(Key.N, ctrl = true, alt = true, shift = true)) { }
//                    }
//
//                    Menu("Help") {
//                        Item("Find Action...", shortcut = KeyShortcut(Key.A, ctrl = true, shift = true)) { }
//                        Item("Tip of the Day") { }
//                        Separator()
//                        Item("About") { }
//                    }
//                }
//
//                // 右侧：窗口控制按钮区域（由 DecoratedWindow 自动处理）
//                // 或者自定义工具按钮
//                IconActionButton(
//                    key = AllIconsKeys.Actions.Search,
//                    onClick = { /* 搜索 */ },
//                    contentDescription = "Search"
//                )
////                    IconActionButton(
////                        key = AllIconsKeys.Actions.Settings,
////                        onClick = { /* 设置 */ },
////                        contentDescription = "Settings"
////                    )
////                }
//
//            }
//        }
//
//    }
//}


//fun main() = application {
//    IntUiTheme(isDark = false) {
//        val state = rememberWindowState(
//            width = 1200.dp,
//            height = 800.dp,
//            position = WindowPosition.Aligned(Alignment.Center)
//        )
//        DecoratedWindow(
//            onCloseRequest = ::exitApplication,
//            state = state,
//            style = JewelTheme.defaultDecoratedWindowStyle,
//        ) {
//            TitleBar (
//                gradientStartColor = Color.Transparent,
//                style = TitleBarStyle.light(
//                    colors = TitleBarColors.light(
//                        backgroundColor = Color.White,
//                        inactiveBackground = Color.Transparent,
//                        borderColor = Color.Transparent,
//                    ),
//                ),
//            ){
//
////                // 标题栏整体布局
////                Row(
////                    modifier = Modifier
////                        .fillMaxSize()
////                        .padding(horizontal = 8.dp),
////                    verticalAlignment = Alignment.CenterVertically,
////                    horizontalArrangement = Arrangement.spacedBy(4.dp)
////                ) {
//                // 左侧：菜单按钮（汉堡菜单）或应用菜单
//                IconActionButton(
//                    key = AllIconsKeys.Actions.MenuOpen,
//                    onClick = { /* 打开主菜单 */ },
//                    contentDescription = "Main Menu"
//                )
//
//                // 分隔线
//                Divider(
//                    orientation = Orientation.Vertical,
//                    modifier = Modifier.height(20.dp)
//                )
//
//                // 右侧：窗口控制按钮区域（由 DecoratedWindow 自动处理）
//                // 或者自定义工具按钮
//                IconActionButton(
//                    key = AllIconsKeys.Actions.Search,
//                    onClick = { /* 搜索 */ },
//                    contentDescription = "Search"
//                )
//
//                IconActionButton(
//                    key = AllIconsKeys.Actions.Exit,
//                    onClick = { /* 设置 */ },
//                    contentDescription = "Settings"
//                )
//
//            }
//        }
//
//    }
//}


fun main() = application {

    // ===== 菜单栏顶级菜单（JMenu）的圆角选中效果 =====
    UIManager.put("MenuBar.margin", Insets(5, 0, 5, 0))
    UIManager.put("MenuBar.selectionArc", 10) // 圆角直径（半径=4）
    UIManager.put("MenuBar.selectionInsets", Insets(10, 5, 10, 5)) // 普通菜单栏边距
    UIManager.put("MenuBar.selectionEmbeddedInsets", Insets(8, 3, 8, 3)) // 嵌入标题栏时的边距
    UIManager.put("MenuBar.itemMargins", Insets(10, 10, 10, 10)) // 菜单项文字边距

    // ===== 弹出菜单项（JMenu）的圆角选中效果 =====
    UIManager.put("Menu.selectionArc", 10)
    UIManager.put("Menu.selectionInsets", Insets(0, 5, 0, 5))
    UIManager.put("Menu.margin", Insets(5, 12, 5, 12))
//    UIManager.put("Menu.selectionBackground", Color(0xE8E8E8))
//    UIManager.put("Menu.selectionForeground", Color(0x000000))

    // ===== 弹出菜单项（JMenuItem）的圆角选中效果 =====
    UIManager.put("MenuItem.selectionArc", 10)
    UIManager.put("MenuItem.selectionInsets", Insets(0, 5, 0, 5))
    UIManager.put("MenuItem.margin", Insets(5, 12, 5, 12))
//    UIManager.put("MenuItem.selectionBackground", Color(0xE8E8E8))
//    UIManager.put("MenuItem.selectionForeground", Color(0x000000))

    // 系统属性配置（必须在任何 Swing 组件创建前）
    System.setProperty("flatlaf.useWindowDecorations", "true")
    System.setProperty("flatlaf.menuBarEmbedded", "true")

    // 初始化主题
    FlatLightLaf.setup()

    var windowVisible by remember { mutableStateOf(true) }
    var showCloseDialog by remember { mutableStateOf(false) }

    Tray(
        icon = painterResource("drawable/compose-multiplatform.xml"),
        onAction = { windowVisible = true },
        menu = {
            Item("显示素材看板", onClick = { windowVisible = true })
            Item("退出", onClick = ::exitApplication)
        }
    )

    if (windowVisible) {

        Window(
            onCloseRequest = { showCloseDialog = true },
            state = WindowState(position = WindowPosition.Aligned(Alignment.Center)),
            title = "中文开发包",
            icon = painterResource("drawable/compose-multiplatform.xml")
        ) {

            // 场景 2：自定义标题栏高度
            this.window.getRootPane().putClientProperty("JRootPane.titleBarHeight", 45)

//            MenuBar {
//                Menu("<html>文件(<u>F</u>)</html>", mnemonic = 'F') { // 文件(F̲)
//                    Menu("<html>新建(<u>N</u>)</html>") {
//                        Item(
//                            "<html>新建项目(<u>N</u>)</html>",
//                            shortcut = KeyShortcut(key = Key.N, ctrl = true, alt = true)
//                        ) {}
//                        Item("<html>打开项目(<u>O</u>)</html>") {}
//                        Item("<html>保存项目(<u>S</u>)</html>") {}
//                    }
//                    Item(
//                        "<html>打开项目(<u>O</u>)</html>",
//                        icon = painterResource("drawable/compose-multiplatform.xml"),
//                        shortcut = KeyShortcut(key = Key.O, ctrl = true, alt = true)
//                    ) {}
//                    Separator()
//                    Item(
//                        "<html>保存项目(<u>S</u>)</html>",
//                        icon = painterResource("drawable/compose-multiplatform.xml"),
//                        shortcut = KeyShortcut(key = Key.S, ctrl = true, alt = true)
//                    ) {}
//                    Item("<html>退出(<u>X</u>)</html>") {
//                        exitApplication()
//                    }
//                }
//                Menu("<html>编辑(<u>E</u>)</html>", mnemonic = 'E') { // 编辑(E̲)
//                    Item("新建") {}
//                    Item("打开") {}
//                    Item("保存") {}
//                    Item("退出") {}
//                }
//                Menu("<html>视图(<u>V</u>)</html>", mnemonic = 'V') { // 视图(V̲)
//                    Item("新建") {}
//                    Item("打开") {}
//                    Item("保存") {}
//                    Item("退出") {}
//                }
//            }

            if (showCloseDialog) {
                CloseConfirmDialog(
                    onDismiss = {
                        showCloseDialog = false
                    },
                    onExitApp = {
                        showCloseDialog = false
                        exitApplication()
                    }
                )
            }
        }
    }
}


@Composable
fun CloseConfirmDialog(
    onDismiss: () -> Unit,
    onExitApp: () -> Unit,
    title: String = "确认关闭",
    content: String = "您想要如何操作？"
) {
    val state = rememberDialogState(
        position = WindowPosition(Alignment.Center),
        size = DpSize(360.dp, 180.dp)
    )
    DialogWindow(
        onCloseRequest = onDismiss,
        title = title,
        resizable = false,
        state = state
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = content,
                style = MaterialTheme.typography.bodyLarge
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(onClick = onDismiss) {
                    Text("取消")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = onExitApp) {
                    Text("退出")
                }
            }
        }
    }
}

