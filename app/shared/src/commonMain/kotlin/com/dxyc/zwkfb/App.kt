package com.dxyc.zwkfb

import androidx.annotation.IntRange
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import 安卓x.组合.基础.布局.行
import 安卓x.组合.材质3.图标
import 安卓x.组合.材质3.图标按钮
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.轮廓安全文本字段
import 自定义.组合.界面.窗口.信息对话框


@OptIn(ExperimentalMaterial3Api::class)
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

//            LunarCalendarScreen(
////                // 可选：初始选中某天，不传则默认今天
////                initialSelectedDate = LocalDate(2026, 8, 18),
//                onDateSelected = { date ->
//                    val lunar = LunarCalendar.solarToLunar(
//                        date.year, date.monthNumber, date.dayOfMonth
//                    )
//                    println("选中: ${date} -> ${lunar.monthName()}${lunar.dayName()}")
//                }
//            )

            轮廓安全文本字段限制长度为100()

            Label(
                label = {
                    Text("标签")
                },
//                isPersistent = true,
            ){ Text("文本") }

            Button(
                onClick = {
                    显示信息对话框 = true
                }
            ) {
                Text("显示信息对话框")
            }

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



/**
 * 轮廓安全文本字段限制长度为100
 *
 * 在 SDK 37.1 及以上版本中使用其他版本的预览不能使用该函数所以禁用该函数的
 * 预览模式，只显示"这是预览模式"文本。
 *
 * @param 文本 文本字段的初始文本
 * @param 标签 文本字段的标签
 * @param 最大长度 最大输入长度
 */
@Suppress("ComposableNaming")
@Composable
fun 轮廓安全文本字段限制长度为100(
    文本: String = "文本",
    标签: String = "标签",
    @IntRange(from = 0, to = 100) 最大长度: Int = 20,
){
    val isInPreview = LocalInspectionMode.current
    if (isInPreview) {
        // 当前处于 Android Studio 的 Preview 模式
        Text("这是预览模式")
    } else {
        // 这是实际运行
        val 测试值 = rememberTextFieldState(文本)
        var 图标状态 by remember {
            mutableStateOf(Icons.Filled.Visibility)
        }

        行(
//            水平排列 = Arrangement.Center,
            垂直对齐 = Alignment.CenterVertically,
        ){
            轮廓安全文本字段(
                状态 = 测试值,
                标签 = { 文本(标签) },
                尾随图标 = {
                    图标按钮(
                        单击回调 = {
                            图标状态 = when (图标状态) {
                                Icons.Filled.Visibility -> Icons.Filled.VisibilityOff
                                else -> Icons.Filled.Visibility
                            }
                        }
                    ) { 图标(图像矢量 = 图标状态, 内容描述 = null) }
                },
                输入转换 = InputTransformation.maxLength(最大长度),
                文本混淆模式 = when (图标状态) {
                    Icons.Filled.Visibility -> TextObfuscationMode.Visible
                    else -> TextObfuscationMode.RevealLastTyped
                }
            )

            文本(
                文本 = if (测试值.text.any { it.isWhitespace() }) "文本不能包含空格" else "",
                颜色 = Color.Red,
            )

        }

    }
}

