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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun Home(上下文 : Activity? = LocalActivity.current) {
    AppTheme{
        var 显示日期选择器 by remember { mutableStateOf(false) }
        脚手架(
            修饰符 = Modifier.fillMaxSize(),
            悬浮操作按钮 = {
                ExtendedFloatingActionButton(
                    onClick = {
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

                    按钮(
                        单击回调 = { 显示日期选择器 = !显示日期选择器 }
                    ) { 文本("显示") }
                    
                    val primaryColor = MaterialTheme.colorScheme.primary
                    val r = (primaryColor.red * 255).toInt()
                    val g = (primaryColor.green * 255).toInt()
                    val b = (primaryColor.blue * 255).toInt()
                    val a = (primaryColor.alpha * 255).toInt()

                    // 结果示例: "RGB(62, 130, 255)"
                    val rgbString = "RGB($r, $g, $b, $a)"

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
                HorizontalDivider()
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

