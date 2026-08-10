package com.dxyc.zwkfb

import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dxyc.zwkfb.ui.theme.AppTheme
import 安卓x.组合.基础.布局.列
import 安卓x.组合.材质3.扩展悬浮操作按钮
import 安卓x.组合.材质3.按钮
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.模态底部面板
import 安卓x.组合.材质3.脚手架


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent { Home() }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Home() {
    val 上下文 = LocalActivity.current
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
                    //.verticalScroll(rememberScrollState())
            ) {

                按钮(
                    单击回调 = { 显示日期选择器 = !显示日期选择器 }
                ) { 文本("显示") }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    DateWheelPickerPreview()
                }


//                val backStack = remember { mutableStateListOf("home") }
//                androidx.navigation3.ui.NavDisplay(
//                    backStack = backStack
//                ) { key ->
//                    when(key) {
//                        "home" -> NavEntry(key){
//                            Column() {
//                                App()
//                                按钮(单击回调 = {
//                                    backStack.add("home1")
//                                }) { 文本("显示") }
//                            }
//                        }
//                        "home1" -> NavEntry(key){ Text("hom1") }
//                        else -> NavEntry(key){ Text("其他") }
//                    }
//                }

                App()

            }
            if (显示日期选择器) {
                模态底部面板 (
                    关闭请求回调 = { 显示日期选择器 = false },
                ) {
                    DatePicker(
                        state = rememberDatePickerState(),
                        colors = DatePickerDefaults.colors(
                            containerColor = BottomSheetDefaults.ContainerColor,
                        ),
                    )
                }
            }
        }
    }
}


