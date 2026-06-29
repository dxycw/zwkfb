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
        脚手架(
            修饰符 = Modifier.fillMaxSize(),
            悬浮操作按钮 = {
                扩展悬浮操作按钮(
                    单击回调 = {
                        上下文?.startActivity(
                            Intent(上下文, 欢迎窗口::class.java)
                        )
                    },
                    内容 = { 文本(文本 = "显示") }
                )
            },
        ) { 内边距 ->
            var 显示日期选择器 by remember { mutableStateOf(false) }
            列(
                修饰符 = Modifier.padding(内边距).fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                按钮(单击回调 = { 显示日期选择器 = !显示日期选择器 }) { 文本("显示") }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    DateWheelPickerPreview()
                }
                App()
            }
            if (显示日期选择器) {
                模态底部面板 (
                    关闭请求回调 = { 显示日期选择器 = false },
                    拖拽手柄 = null
                ) {
                    列(
                        水平对齐 = Alignment.CenterHorizontally
                    ) {
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
    模态导航抽屉(
        抽屉内容 = {
            模态抽屉面板 {
                文本("抽屉标题", 修饰符 = Modifier.padding(16.dp))
                水平分隔线()
                导航抽屉项(
                    标签 = { Text("首页") },
                    已选择 = true,
                    单击回调 = { scope.launch { drawerState.close() } }
                )
                导航抽屉项(
                    标签 = { Text("设置") },
                    已选择 = false,
                    单击回调 = { scope.launch { drawerState.close() } }
                )
                导航抽屉项(
                    标签 = { Text("设置1") },
                    已选择 = false,
                    单击回调 = { scope.launch { drawerState.close() } }
                )
            }
        },
        抽屉状态 = drawerState,
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("主界面") },
                    navigationIcon = {
                        图标按钮(
                            单击回调 = { scope.launch { drawerState.open() } }
                        ) {
                            图标(Icons.Default.Menu, 内容描述 = "打开抽屉")
                        }
                    }
                )
            }
        ) { 内边距 ->
            Box(
                modifier = Modifier.fillMaxSize().padding(内边距),
                contentAlignment = Alignment.Center
            ) {
                Text("主屏幕")
            }
        }
    }
}

