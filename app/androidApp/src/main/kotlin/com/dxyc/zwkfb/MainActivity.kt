package com.dxyc.zwkfb

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dxyc.zwkfb.ui.theme.AppTheme
import kotlinx.coroutines.launch
import 安卓x.组合.基础.布局.列
import 安卓x.组合.材质3.图标
import 安卓x.组合.材质3.图标按钮
import 安卓x.组合.材质3.导航抽屉项
import 安卓x.组合.材质3.扩展悬浮操作按钮
import 安卓x.组合.材质3.按钮
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.模态导航抽屉
import 安卓x.组合.材质3.模态底部面板
import 安卓x.组合.材质3.模态底部面板默认值
import 安卓x.组合.材质3.模态抽屉面板
import 安卓x.组合.材质3.水平分隔线
import 安卓x.组合.材质3.脚手架

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            App()
//            Home()
//            SimpleDrawer()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
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

