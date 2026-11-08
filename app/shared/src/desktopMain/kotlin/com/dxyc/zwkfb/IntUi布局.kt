package com.dxyc.zwkfb

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


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
