package com.dxyc.zwkfb

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import multiplatform.zwkfb.Greeting
import org.jetbrains.compose.resources.painterResource
import zwkfbmultiplatform.app.shared.generated.resources.Res
import zwkfbmultiplatform.app.shared.generated.resources.compose_multiplatform
import 安卓x.组合.材质3.分段按钮颜色集
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.日期范围选择器
import 安卓x.组合.材质3.日期选择器对话框
import 安卓x.组合.材质3.记住时间选择器状态

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
//                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var selectedDestination by rememberSaveable { mutableIntStateOf(0) }

            PrimaryTabRow(
                selectedTabIndex = selectedDestination,
                modifier = Modifier.padding(10.dp),
                containerColor = Color.Transparent,
                divider = {  },
            ) {
                Tab(
                    selected = selectedDestination == 0,
                    onClick = {
                        selectedDestination = 0
                    },
                    text = {
                        Text(
                            text = "${0 + 1}",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
                Tab(
                    selected = selectedDestination == 1,
                    onClick = {
                        selectedDestination = 1
                    },
                    text = {
                        Text(
                            text = "${0 + 2}",
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
            }

            SingleChoiceSegmentedButton()

            Button(onClick = { showContent = !showContent }) {
                Text("点击我！")
            }
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
    }
}


@Preview
@Composable
fun SingleChoiceSegmentedButton() {
    var selectedIndex by remember { mutableIntStateOf(0) }
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


//@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
//@Composable
//@Preview
//fun App(内容: @Composable () -> Unit = {  }) {
//    材质主题 {
//        val 状态 = remember { SnackbarHostState() }
//        脚手架(
//            顶部栏 = {
//                if (Greeting().platform() != "desktop") {
//                    TopAppBar(
//                        title = { 文本("灵阁") },
//                        navigationIcon = {
//                            图标按钮(
//                                单击回调 = {},
//                                颜色集 = IconButtonColors(
//                                    containerColor = Color.White,
//                                    contentColor = Color.Unspecified,
//                                    disabledContainerColor = Color.Transparent,
//                                    disabledContentColor = Color.Unspecified
//                                )
//                            ) {
//                                图标(
//                                    绘制器 = painterResource(Res.drawable.compose_multiplatform),
//                                    内容描述 = null,
//                                    修饰符 = Modifier.size(40.dp),
//                                    色调 = Color.Unspecified
//                                )
//                            }
//                        },
//                        actions = {
//                            按钮(单击回调 = { }) { 文本("单击 我!") }
//                        }
//                    )
//                }
//            },
//            提示条主机 = {
//                提示条主机(主机状态 = 状态)
//                rememberCoroutineScope().launch {
//                    状态.showSnackbar(
//                        message = "Hello, World!",
//                        actionLabel = "Dismiss"
//                    )
//                }
//
//            }
//        ) { 内边距 ->
//            var showContent by remember { mutableStateOf(false) }
//            列(
//                修饰符 = Modifier.padding(内边距)
//                    .background(color = Color.White)
//                    .safeContentPadding().fillMaxSize()
//                    .verticalScroll(rememberScrollState()),
//                水平对齐 = Alignment.CenterHorizontally,
//            ) {
//                按钮(单击回调 = { showContent = !showContent }) { 文本("Click me!") }
//                水平分隔线()
//                val greeting = remember { Greeting().greet() }
//                动画可见性(showContent) {
//                    列(
//                        修饰符 = Modifier.fillMaxWidth(),
//                        水平对齐 = Alignment.CenterHorizontally,
//                    ) {
//                        图像(
//                            绘制器 = painterResource(Res.drawable.compose_multiplatform),
//                            内容描述 = null,
//                            修饰符 = Modifier.size(200.dp)
//                        )
//                        文本("Compose: $greeting")
//                    }
//                }
//                内容()
//                ButtonGroupSample()
//
//                var 测试值 by remember { mutableStateOf("") }
//                文本字段(
//                    值 = 测试值,
//                    值改变回调 = {
//                        测试值 = it
//                    },
//                    标签 = { 文本("测试") }
//                )
//                基础文本字段(
//                    值 = 测试值,
//                    值改变回调 = {
//                        测试值 = it
//                    },
//                )
//                轮廓文本字段(
//                    值 = 测试值,
//                    值改变回调 = {
//                        测试值 = it
//                    },
//                    标签 = { 文本("测试") }
//                )
//
//                val 测试值1 = remember { TextFieldState("测试") }
//
//                var 图标状态 by remember {
//                    mutableStateOf(Icons.Filled.Visibility)
//                }
//
//                安全文本字段(
//                    状态 = 测试值1,
//                    标签 = { 文本("测试") },
//                )
//
//                基础安全文本字段(
//                    状态 = 测试值1,
//                )
//
//                轮廓安全文本字段(
//                    状态 = 测试值1,
//                    标签 = { 文本("测试") },
//                    尾随图标 = {
//                        图标按钮(
//                            单击回调 = {
//                                图标状态 = when (图标状态) {
//                                    Icons.Filled.Visibility -> Icons.Filled.VisibilityOff
//                                    else -> Icons.Filled.Visibility
//                                }
//                            }
//                        ) {
//                            图标(
//                                图像矢量 = 图标状态,
//                                内容描述 = null,
//                            )
//                        }
//                    }
//                )
//
//                Spacer(Modifier.height(10.dp))
//
//                LinearProgressIndicator(
//                    progress = { 0.5f },
//                    modifier = Modifier.padding(10.dp)
//                        .wrapContentSize(Alignment.Center)
//                        .height(10.dp)
//                )
//
//                Slider(
//                    state = remember { SliderState(0.8f) },
//                    modifier = Modifier.padding(10.dp)
//                        .wrapContentSize(Alignment.Center),
//                    thumb = {
//                        SliderDefaults.Thumb(
//                            interactionSource = remember { MutableInteractionSource() },
//                            thumbSize = DpSize(20.0.dp, 20.0.dp)
//                        )
//                    },
//                )
//
//                MultiSelectConnectedButtonGroupSample()
//            }
//        }
//
//    }
//}
//
//
//@OptIn(ExperimentalMaterial3ExpressiveApi::class)
//@Preview
//@Composable
//fun ButtonGroupSample() {
//    val numButtons = 10
//    ButtonGroup(
//        overflowIndicator = { menuState ->
//            ButtonGroupDefaults.OverflowIndicator(menuState = menuState)
//        },
//        verticalAlignment = Alignment.Top,
//    ) {
//        for (i in 0 until numButtons) {
//            clickableItem(onClick = {}, label = "$i")
//        }
//    }
//}


//@OptIn(ExperimentalMaterial3ExpressiveApi::class)
//@Composable
//fun MultiSelectConnectedButtonGroupSample() {
//    val options = listOf("Work", "Restaurant", "Coffee")
//    val unCheckedIcons =
//        listOf(Icons.Outlined.Work, Icons.Outlined.Restaurant, Icons.Outlined.Coffee)
//    val checkedIcons = listOf(Icons.Filled.Work, Icons.Filled.Restaurant,
//        Icons.Filled.Coffee)
//    val checked = remember { mutableStateListOf(false, false, false) }
//    Row(
//        Modifier.padding(horizontal = 8.dp),
//        horizontalArrangement = Arrangement.spacedBy(
//            ButtonGroupDefaults.ConnectedSpaceBetween
//        ),
//    ) {
//        val modifiers = listOf(Modifier.weight(1f), Modifier.weight(1f), Modifier.weight(1f))
//        options.forEachIndexed { index, label ->
//            ToggleButton(
//                checked = checked[index],
//                onCheckedChange = { checked[index] = it },
//                modifier = modifiers[index],
//                shapes =
//                    when (index) {
//                        0 -> ButtonGroupDefaults.connectedLeadingButtonShapes()
//                        options.lastIndex -> ButtonGroupDefaults.connectedTrailingButtonShapes()
//                        else -> ButtonGroupDefaults.connectedMiddleButtonShapes()
//                    },
//            ) {
//                Icon(
//                    if (checked[index]) checkedIcons[index] else unCheckedIcons[index],
//                    contentDescription = "Localized description",
//                )
//                Spacer(Modifier.size(ToggleButtonDefaults.IconSpacing))
//                Text(label)
//            }
//        }
//    }
//}