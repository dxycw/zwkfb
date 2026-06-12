package com.dxyc.zwkfb

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.*
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dxyc.zwkfb.ui.theme.AppTheme
import kotlinx.coroutines.launch
import 安卓x.组合.基础.布局.列
import 安卓x.组合.基础.文本.选择.选择容器
import 安卓x.组合.材质3.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            Home()
//            SimpleDrawer()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun Home(上下文 : Activity? = LocalActivity.current) {
    AppTheme{
        val 状态 = remember { SnackbarHostState() }
        val 范围 = rememberCoroutineScope()
        var 显示日期选择器 by remember { mutableStateOf(false) }
        脚手架(
            修饰符 = Modifier.fillMaxSize(),
            提示条主机 = { SnackbarHost(状态) },
            悬浮操作按钮 = {
                ExtendedFloatingActionButton(
                    onClick = {
                        范围.launch {
                            val result = 状态.showSnackbar(
                                message = "Snackbar Message",//消息内容文字
                                // Action 按钮显示文字,设置后会有一个 Action 按钮
                                actionLabel = "确定",
                                // 显示时长 Short、Long 参考 Toast, Indefinite 一直显示 不会自动消失
                                duration = SnackbarDuration.Short,//Indefinite,
                                // 是否显示 Dismiss Action 按钮 ，true 的话最右边会有一个 X 的按钮
                                //                            withDismissAction = true
                            )

                            when (result) {
                                //点击了 显示时配置的 Action 按钮
                                SnackbarResult.ActionPerformed -> {}
                                //点击了 X 按钮
                                SnackbarResult.Dismissed -> {}
                            }
                        }
                        上下文?.startActivity(Intent(上下文, 欢迎窗口::class.java))
                    }
                ) { 文本(文本 = "显示") }
            },
        ) { 内边距 ->
            选择容器 {
                列(
                    修饰符 = Modifier.padding(内边距)
                        .verticalScroll(rememberScrollState())
                ) {
//                    ClickToLoadLinear()

                    按钮(单击回调 = { 显示日期选择器 = !显示日期选择器 }) {
                        文本(文本 = "显示")
                    }

                    图标按钮(单击回调 = {}){
                        图标(
                            图像矢量 = Icons.Filled.ArrowDropDown,
                            内容描述 = null
                        )
                    }
                    var 状态2 by remember { mutableStateOf(false) }
                    RadioButton(
                        selected = 状态2,
                        onClick = { 状态2 = !状态2 }
                    )

                    var 状态1 by remember { mutableStateOf(false) }
                    Checkbox(
                        checked = 状态1,
                        onCheckedChange = { 状态1 = it }
                    )

                    var 状态 by remember { mutableStateOf(ToggleableState.Indeterminate) }
                    TriStateCheckbox(
                        state = 状态,
                        onClick = {
                            if (状态 == ToggleableState.Off) {
                                状态 = ToggleableState.On
                            } else if (状态 == ToggleableState.On) {
                                状态 = ToggleableState.Indeterminate
                            } else {
                                状态 = ToggleableState.Off
                            }
                        }
                    )

                    val primaryColor = MaterialTheme.colorScheme.primary
                    val r = (primaryColor.red * 255).toInt()
                    val g = (primaryColor.green * 255).toInt()
                    val b = (primaryColor.blue * 255).toInt()

                    // 结果示例: "RGB(62, 130, 255)"
                    val rgbString = "RGB($r, $g, $b)"

                    文本(
                        文本 = rgbString,
                        修饰符 = Modifier.padding(8.dp)
                    )

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        DateWheelPickerPreview()
                    }

                    App()

                }

            }

            if (显示日期选择器) {

                ModalBottomSheet (
                    onDismissRequest = { 显示日期选择器 = false },
                    dragHandle = null
                ) {
                    列(水平对齐 = Alignment.CenterHorizontally) {
                        BottomSheetDefaults.DragHandle()
                        DatePicker(
                            state = rememberDatePickerState(),
                            colors = DatePickerDefaults.colors(
                                containerColor = BottomSheetDefaults.ContainerColor,//MaterialTheme.colorScheme.background,
//                                navigationContentColor = Color.Red,
                            ),
                        )
                    }
                }

            }

        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleDrawer() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope  = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("抽屉标题", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text("首页") },
                    selected = true,
                    onClick = { scope.launch { drawerState.close() } }
                )
                NavigationDrawerItem(
                    label = { Text("设置") },
                    selected = false,
                    onClick = { scope.launch { drawerState.close() } }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("主界面") },
                    navigationIcon = {
                        IconButton(
                            onClick = { scope.launch { drawerState.open() } }
                        ) {
                            Icon(Icons.Default.Menu,
                                contentDescription = "打开抽屉")
                        }
                    }
                )
            }
        ) { innerPadding ->
            // 主屏幕内容
            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text("主屏幕")
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3ExpressiveApi::class)
//@Composable
//fun ClickToLoadLinear() {
//    // 当前进度：0..100
//    var 进度 by remember { mutableIntStateOf(0) }
//    // 是否正在加载（防止重复点击）
//    var 加载中 by remember { mutableStateOf(false) }
//    // 是否暂停状态
//    var 暂停 by remember { mutableStateOf(false) }
//    // 添加一个job引用以便能够取消
//    var 加载中Job by remember { mutableStateOf<Job?>(null) }
//
//    val scope = rememberCoroutineScope()
//    //    保存协程作用域
//    列 (
//        修饰符 = Modifier.padding(10.dp),
//        水平对齐 = Alignment.CenterHorizontally
//    ) {
//        // 进度条
//        线性进度指示器(
////            进度 = { progress / 100f },
//            修饰符 = Modifier.fillMaxWidth().padding(16.dp),
////            绘制终止指示器 = {}
//        )
//
//        线性进度指示器(
//            进度 = { 进度 / 100f },
//            修饰符 = Modifier.fillMaxWidth().padding(16.dp),
//            绘制停止指示器 = {}
//        )
//
//        LinearWavyProgressIndicator(
//            modifier = Modifier.fillMaxWidth().padding(16.dp)
//        )
//
//        LinearWavyProgressIndicator(
//            progress = { 进度 / 100f },
//            modifier = Modifier.fillMaxWidth().padding(16.dp),
//            stopSize = 0.dp
//        )
//
//        文本(文本 = "单击进度条开始加载：$进度%")
//
//        按钮 (
//            单击回调 = {
//                if (!加载中 || 暂停) {
//                    // 如果未运行或已暂停，则开始/恢复加载
//                    加载中 = true
//                    暂停 = false
//                    加载中Job = scope.launch {
//                        while (进度 < 100 && 加载中 && !暂停) {
//                            delay(50)  // 每 50 ms 前进一次
//                            进度 += 1
//                        }
//                        // 只有正常完成才设为false
//                        if (进度 >= 100) {
//                            加载中 = false
//                            暂停 = false
//                        }
//                    }
//                }
//            },
//            修饰符 = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
//            已启用 = !加载中 || 暂停 // 未运行或已暂停时可用
//        ) {
//            文本(
//                文本 = when {
//                    暂停 -> "继续"
//                    加载中 -> "加载中..."
//                    else -> "加载"
//                }
//            )
//        }
//
//        按钮(
//            单击回调 = {
//                // 如果正在运行，则暂停加载
//                if (加载中 && !暂停) {
//                    暂停 = true
//                    加载中Job?.cancel()
//                }
//            },
//            修饰符 = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
//            已启用 = 加载中 && !暂停 // 正在运行且未暂停时可用
//        ) { 文本(文本 = "暂停") }
//
//        按钮(
//            单击回调 = {
//                // 停止加载并重置进度
//                加载中 = false
//                暂停 = false
//                进度 = 0
//                加载中Job?.cancel()
//            },
//            修饰符 = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
//            已启用 = 加载中 || 进度 > 0 // 正在运行或有进度时可用
//        ) { 文本(文本 = "重置") }
//
//    }
//}

