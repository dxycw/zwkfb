package com.dxyc.zwkfb

import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.dxyc.zwkfb.组件.CloseConfirmDialog
import com.dxyc.zwkfb.组件.视频播放器
import com.formdev.flatlaf.FlatLightLaf
import java.awt.Insets
import javax.swing.UIManager

//fun main() = flatlaf布局()
//application {
//    Window(
//        onCloseRequest = ::exitApplication,
//        state = WindowState(position = WindowPosition.Aligned(Alignment.Center)),
//        title = "中文开发包",
//        icon = compose_multiplatform,
//    ) {
////        App()
//        视频播放器()
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

//    Tray(
//        icon = painterResource("drawable/compose-multiplatform.xml"),
//        onAction = { windowVisible = true },
//        menu = {
//            Item("显示素材看板", onClick = { windowVisible = true })
//            Item("退出", onClick = ::exitApplication)
//        }
//    )

    if (windowVisible) {

        Window(
            onCloseRequest = { showCloseDialog = true },
            state = WindowState(position = WindowPosition.Aligned(Alignment.Center)),
            title = "中文开发包",
            icon = compose_multiplatform
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
                        icon = compose_multiplatform,
                        shortcut = KeyShortcut(key = Key.O, ctrl = true, alt = true)
                    ) {}
                    Separator()
                    Item(
                        "<html>保存项目(<u>S</u>)</html>",
                        icon = compose_multiplatform,
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
