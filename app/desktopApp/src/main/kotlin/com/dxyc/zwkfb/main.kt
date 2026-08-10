package com.dxyc.zwkfb

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogWindow
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberDialogState
import com.formdev.flatlaf.FlatLightLaf
import com.iffly.compose.markdown.multiplatform.ActionHandler
import com.iffly.compose.markdown.multiplatform.MarkdownView
import com.iffly.compose.markdown.multiplatform.util.nodeTextContent
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.过滤芯片
import 自定义.组合.材质3.凸起辅助芯片
import 自定义.组合.材质3.辅助芯片
import java.awt.Insets
import javax.swing.UIManager
import kotlin.time.Duration.Companion.milliseconds


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

            MenuBar {
                Menu("<html>文件(<u>F</u>)</html>", mnemonic = 'F') { // 文件(F̲)
                    Menu("<html>新建(<u>N</u>)</html>") {
                        Item(
                            "<html>新建项目(<u>N</u>)</html>",
                            shortcut = KeyShortcut(key = Key.N, ctrl = true, alt = true)
                        ) {}
                        Item("<html>打开项目(<u>O</u>)</html>") {}
                        Item("<html>保存项目(<u>S</u>)</html>") {}
                    }
                    Item(
                        "<html>打开项目(<u>O</u>)</html>",
                        icon = painterResource("drawable/compose-multiplatform.xml"),
                        shortcut = KeyShortcut(key = Key.O, ctrl = true, alt = true)
                    ) {}
                    Separator()
                    Item(
                        "<html>保存项目(<u>S</u>)</html>",
                        icon = painterResource("drawable/compose-multiplatform.xml"),
                        shortcut = KeyShortcut(key = Key.S, ctrl = true, alt = true)
                    ) {}
                    Item("<html>退出(<u>X</u>)</html>") {
                        exitApplication()
                    }
                }
                Menu("<html>编辑(<u>E</u>)</html>", mnemonic = 'E') { // 编辑(E̲)
                    Item("新建") {}
                    Item("打开") {}
                    Item("保存") {}
                    Item("退出") {}
                }
                Menu("<html>视图(<u>V</u>)</html>", mnemonic = 'V') { // 视图(V̲)
                    Item("新建") {}
                    Item("打开") {}
                    Item("保存") {}
                    Item("退出") {}
                }
            }

            App()

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
    DialogWindow(
        onCloseRequest = onDismiss,
        title = title,
        resizable = false,
        state = rememberDialogState(
            position = WindowPosition(Alignment.Center),
            size = DpSize(360.dp, 180.dp)
        )
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

