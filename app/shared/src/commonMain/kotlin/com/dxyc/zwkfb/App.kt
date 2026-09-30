package com.dxyc.zwkfb


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zwkfb.组合.界面.窗口.信息对话框

@Composable
@Preview
fun App() {
    MaterialTheme {
        var 显示信息对话框 by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            轮廓安全文本字段限制长度为100()
            Button(
                onClick = {
                    显示信息对话框 = true
                }
            ) { Text("显示信息对话框") }
        }
        if (显示信息对话框){
            信息对话框(
                关闭请求回调 = {
                    显示信息对话框 = false
                },
                忽略按钮单击回调 = {
                    显示信息对话框 = false
                },
                取消按钮单击回调 ={
                    显示信息对话框 = false
                },
                确定按钮单击回调 = {
                    显示信息对话框 = false
                }
            )
        }
    }
}


//@Composable
//@Preview
//fun App() {
//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primaryContainer)
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("点击我！")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                ) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//
//        }
//
//    }
//}