package com.dxyc.zwkfb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dxyc.zwkfb.ui.theme.AppTheme
import com.mikepenz.markdown.m3.Markdown
import com.zwkfb.markdownBottomSheetHeight
import 安卓x.组合.基础.布局.列
import 安卓x.组合.材质3.扩展悬浮操作按钮
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.脚手架

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            Home()
        }
    }
}

@Preview
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
                修饰符 = Modifier
                    .padding(内边距)
                    .fillMaxSize()
                //.verticalScroll(rememberScrollState())
            ) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    DateWheelPickerPreview()
//                }

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


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppAndroidPreview() {
//    App()
    Scaffold(

    ) { 内边距 ->
        按钮打开模态底部面板(
            modifier = Modifier.padding(内边距),
            buttoncontent = {
                Text(text = "打开Markdown文件")
            },
            modalBottomSheetcontent = {
                val markdown =
                    """
                        # 你好
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这是一个Markdown文件
                        这                    
                        """.trimIndent()
                Markdown(
                    content = markdown,
                    modifier = Modifier
                        .markdownBottomSheetHeight()
                        .verticalScroll(rememberScrollState()),
                )
            }
        )
    }
}


@SuppressLint("ComposableNaming")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun 按钮打开模态底部面板(
    modifier: Modifier = Modifier,
    buttoncontent: @Composable (RowScope.() -> Unit),
    modalBottomSheetcontent: @Composable (ColumnScope.() -> Unit)
) {
    var isBottomSheetOpen by remember { mutableStateOf(false) }
    Column(
        modifier = modifier,
    ) {
        Button(
            onClick = {
                isBottomSheetOpen = true
            },
            content = buttoncontent
        )
    }

    if (isBottomSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = {
                isBottomSheetOpen = false
            },
            content = modalBottomSheetcontent
        )
    }
}
