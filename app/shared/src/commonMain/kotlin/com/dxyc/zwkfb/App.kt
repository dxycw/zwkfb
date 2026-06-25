package com.dxyc.zwkfb

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.material.icons.outlined.Work
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.carousel.CarouselItemDrawInfo
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import multiplatform.zwkfb.Greeting
import org.jetbrains.compose.resources.painterResource
import zwkfbmultiplatform.app.shared.generated.resources.Res
import zwkfbmultiplatform.app.shared.generated.resources.compose_multiplatform
import 安卓x.组合.动画.动画可见性
import 安卓x.组合.基础.图像
import 安卓x.组合.基础.布局.列
import 安卓x.组合.材质3.分段按钮颜色集
import 安卓x.组合.材质3.图标
import 安卓x.组合.材质3.图标按钮
import 安卓x.组合.材质3.按钮
import 安卓x.组合.材质3.提示条主机
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.材质主题
import 安卓x.组合.材质3.脚手架
import 安卓x.组合.材质3.轮廓安全文本字段
import 安卓x.组合.材质3.轮廓文本字段
import 自定义.组合.动画.下拉逐渐缩小隐藏动画


@Composable
@Preview
fun App() {
    MaterialTheme {
        下拉逐渐缩小隐藏动画(
            修饰符 = Modifier
                .safeContentPadding()
//                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            水平对齐 = Alignment.CenterHorizontally,
        ) {
            SingleChoiceSegmentedButton()
            var showContent by remember { mutableStateOf(false) }
            Button(
                onClick = { showContent = !showContent },
            ) { Text("点击我！") }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painterResource(Res.drawable.compose_multiplatform),
                        null,
                        Modifier.size(100.dp)
                    )
                    Text("Compose: $greeting")
                }
            }

        }
        HorizontalMultiBrowseCarousel()
    }
}


@Preview
@Composable
fun SingleChoiceSegmentedButton() {
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    val options = listOf("Day", "Month", "Week")

    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                colors = 分段按钮颜色集(
                    激活容器颜色 = Color(76, 94, 139,50),
                    激活内容颜色 = Color(76, 94, 139),
                    激活边框颜色 = Color(76, 94, 139),
                    未激活容器颜色 = Color.Transparent,
                    未激活内容颜色 = Color.Black,
                    未激活边框颜色 = Color(76, 94, 139),
                    禁用激活容器颜色 = Color.Transparent,
                    禁用激活内容颜色 = Color.Black,
                    禁用激活边框颜色 = Color(76, 94, 139),
                    禁用未激活容器颜色 = Color.Transparent,
                    禁用未激活内容颜色 = Color.Black,
                    禁用未激活边框颜色 = Color(76, 94, 139),
                ),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                icon = {},
                label = { Text(label) }
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
@Preview
fun App1() {
    材质主题 {
        val 状态 = remember { SnackbarHostState() }
        脚手架(
            顶部栏 = {
                if (Greeting().platform() != "desktop") {
                    TopAppBar(
                        title = { 文本("灵阁") },
                        navigationIcon = {
                            图标按钮(单击回调 = {},) {
                                图标(
                                    绘制器 = painterResource(Res.drawable.compose_multiplatform),
                                    内容描述 = null,
                                    修饰符 = Modifier.size(40.dp),
                                    色调 = Color.Unspecified
                                )
                            }
                        },
                        actions = {
                            按钮(单击回调 = { }) { 文本("单击我!") }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.Transparent
                        )
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

            },
            容器颜色 = Color.Transparent
        ) { 内边距 ->
            列(
                修饰符 = Modifier.padding(内边距)
                    .safeContentPadding().fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                水平对齐 = Alignment.CenterHorizontally,
            ) {
                var showContent by remember { mutableStateOf(false) }
                按钮(
                    单击回调 = { showContent = !showContent }
                ) { 文本("单击我!") }

                动画可见性(showContent) {
                    val greeting = remember { Greeting().greet() }
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

                val 测试值 = remember { TextFieldState("测试") }
                轮廓文本字段(
                    状态 = 测试值,
                    标签 = { 文本("测试") }
                )

                var 图标状态 by remember { mutableStateOf(Icons.Filled.Visibility) }
                轮廓安全文本字段(
                    状态 = 测试值,
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
                    },
                    文本混淆模式 = when (图标状态) {
                            Icons.Filled.Visibility -> TextObfuscationMode.Visible
                            else -> TextObfuscationMode.RevealLastTyped
                        }
                )

                MultiSelectConnectedButtonGroupSample()

            }
        }

    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MultiSelectConnectedButtonGroupSample() {
    val options = listOf("Work", "Restaurant", "Coffee")
    val unCheckedIcons =
        listOf(Icons.Outlined.Work, Icons.Outlined.Restaurant, Icons.Outlined.Coffee)
    val checkedIcons = listOf(Icons.Filled.Work, Icons.Filled.Restaurant,
        Icons.Filled.Coffee)
    val checked = remember { mutableStateListOf(false, false, false) }
    Row(
        Modifier.padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(
            ButtonGroupDefaults.ConnectedSpaceBetween
        ),
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