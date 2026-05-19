package com.dxyc.zwkfb

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material.icons.outlined.Work
import androidx.compose.material3.*
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import multiplatform.zwkfb.Greeting
import org.jetbrains.compose.resources.painterResource
import zwkfbmultiplatform.composeapp.generated.resources.Res
import zwkfbmultiplatform.composeapp.generated.resources.compose_multiplatform
import 安卓x.组合.动画.动画可见性
import 安卓x.组合.基础.图像
import 安卓x.组合.基础.布局.列
import 安卓x.组合.基础.文本.基础安全文本字段
import 安卓x.组合.基础.文本.基础文本字段
import 安卓x.组合.材质3.*


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
@Preview
fun App(内容: @Composable () -> Unit = {  }) {
    材质主题 {
        val 状态 = remember { SnackbarHostState() }
        脚手架(
            顶部栏 = {
                if (Greeting().platform() != "desktop") {
                    TopAppBar(
                        title = { 文本("灵阁") },
                        navigationIcon = {
                            图标按钮(
                                单击回调 = {},
                                颜色集 = IconButtonColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Unspecified,
                                    disabledContainerColor = Color.Transparent,
                                    disabledContentColor = Color.Unspecified
                                )
                            ) {
                                图标(
                                    绘制器 = painterResource(Res.drawable.compose_multiplatform),
                                    内容描述 = null,
                                    修饰符 = Modifier.size(40.dp),
                                    色调 = Color.Unspecified
                                )
                            }
                        },
                        actions = {
                            按钮(单击回调 = { }) { 文本("Click me!") }
                        }
                    )
                }
            },
            提示条主机 = {
                提示条主机(主机状态 = 状态)
                rememberCoroutineScope().launch {
                    状态.showSnackbar(
                        message = "Hello, World!",
                        actionLabel = "Dismiss"
                    )
                }

            }
        ) { 内边距 ->
            var showContent by remember { mutableStateOf(false) }
            列(
                修饰符 = Modifier.padding(内边距)
                    .background(color = Color.White)
                    .safeContentPadding().fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                水平对齐 = Alignment.CenterHorizontally,
            ) {
                按钮(单击回调 = { showContent = !showContent }) { 文本("Click me!") }
                水平分隔线()
                val greeting = remember { Greeting().greet() }
                动画可见性(showContent) {
                    列(
                        修饰符 = Modifier.fillMaxWidth(),
                        水平对齐 = Alignment.CenterHorizontally,
                    ) {
                        图像(
                            绘制器 = painterResource(Res.drawable.compose_multiplatform),
                            内容描述 = null,
                            修饰符 = Modifier.size(200.dp)
                        )
                        文本("Compose: $greeting")
                    }
                }
                内容()
                ButtonGroupSample()

                var 测试值 by remember { mutableStateOf("") }
                文本字段(
                    值 = 测试值,
                    值改变回调 = {
                        测试值 = it
                    },
                    标签 = { 文本("测试") }
                )
                基础文本字段(
                    值 = 测试值,
                    值改变回调 = {
                        测试值 = it
                    },
                )
                轮廓文本字段(
                    值 = 测试值,
                    值改变回调 = {
                        测试值 = it
                    },
                    标签 = { 文本("测试") }
                )

                val 测试值1 = remember { TextFieldState("测试") }

                var 图标状态 by remember {
                    mutableStateOf(Icons.Filled.Visibility)
                }

                安全文本字段(
                    状态 = 测试值1,
                    标签 = { 文本("测试") },
                )

                基础安全文本字段(
                    状态 = 测试值1,
                )

                轮廓安全文本字段(
                    状态 = 测试值1,
                    标签 = { 文本("测试") },
                    尾随图标 = {
                        图标按钮(
                            单击回调 = {
                                图标状态 = when (图标状态) {
                                    Icons.Filled.Visibility -> Icons.Filled.VisibilityOff
                                    else -> Icons.Filled.Visibility
                                }
                            }
                        ) {
                            图标(
                                图像矢量 = 图标状态,
                                内容描述 = null,
                            )
                        }
                    }
                )


                PullToRefreshBox(
                    isRefreshing = true,
                    onRefresh = {

                    }
                ){
                    Text("Hello World")
                }

                MultiSelectConnectedButtonGroupSample()
            }
        }

    }
}


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Composable
fun ButtonGroupSample() {
    val numButtons = 10
    ButtonGroup(
        overflowIndicator = { menuState ->
            ButtonGroupDefaults.OverflowIndicator(menuState = menuState)
        },
        verticalAlignment = Alignment.Top,
    ) {
        for (i in 0 until numButtons) {
            clickableItem(onClick = {}, label = "$i")
        }
    }
}


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MultiSelectConnectedButtonGroupSample() {
    val options = listOf("Work", "Restaurant", "Coffee")
    val unCheckedIcons =
        listOf(Icons.Outlined.Work, Icons.Outlined.Restaurant, Icons.Outlined.Coffee)
    val checkedIcons = listOf(Icons.Filled.Work, Icons.Filled.Restaurant, Icons.Filled.Coffee)
    val checked = remember { mutableStateListOf(false, false, false) }
    Row(
        Modifier.padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(ButtonGroupDefaults.ConnectedSpaceBetween),
    ) {
        val modifiers = listOf(Modifier.weight(1f), Modifier.weight(1f), Modifier.weight(1f))
        options.forEachIndexed { index, label ->
            ToggleButton(
                checked = checked[index],
                onCheckedChange = { checked[index] = it },
                modifier = modifiers[index],
                shapes =
                    when (index) {
                        0 -> ButtonGroupDefaults.connectedLeadingButtonShapes()
                        options.lastIndex -> ButtonGroupDefaults.connectedTrailingButtonShapes()
                        else -> ButtonGroupDefaults.connectedMiddleButtonShapes()
                    },
            ) {
                Icon(
                    if (checked[index]) checkedIcons[index] else unCheckedIcons[index],
                    contentDescription = "Localized description",
                )
                Spacer(Modifier.size(ToggleButtonDefaults.IconSpacing))
                Text(label)
            }
        }
    }
}