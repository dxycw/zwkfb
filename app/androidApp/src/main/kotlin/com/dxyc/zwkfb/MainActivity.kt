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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dxyc.zwkfb.ui.theme.AppTheme
import 安卓x.组合.基础.布局.列
import 安卓x.组合.材质3.扩展悬浮操作按钮
import 安卓x.组合.材质3.文本
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
    AppTheme{
        val 上下文 = LocalActivity.current
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
            列(
                修饰符 = Modifier.padding(内边距)
                    .fillMaxSize()
                    //.verticalScroll(rememberScrollState())
            ) {
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
        }
    }
}


