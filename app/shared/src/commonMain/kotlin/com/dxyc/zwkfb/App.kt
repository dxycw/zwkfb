package com.dxyc.zwkfb

import androidx.annotation.IntRange
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import 安卓x.组合.基础.布局.列
import 安卓x.组合.基础.布局.行
import 安卓x.组合.基础.布局.间隔器
import 安卓x.组合.材质3.图标
import 安卓x.组合.材质3.图标按钮

import 安卓x.组合.材质3.按钮
import 安卓x.组合.材质3.文本
import 安卓x.组合.材质3.轮廓安全文本字段
import 自定义.组合.材质3.信息底部面板
import 自定义.组合.材质3.圆形进度指示器
import 自定义.组合.材质3.线性进度指示器


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        var 信息底部面板值 by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ClickToLoadLinear()
            轮廓安全文本字段限制长度为100()

            圆形进度指示器()

            按钮(
                单击回调 = {
                    信息底部面板值 = true
                },
            ){ 文本("打开信息底部面板") }
        }

        if (信息底部面板值 ){
            信息底部面板(
                请求关闭回调 = {
                    信息底部面板值 = false
                },
                标题 = "标题阿达阿达是的阿是打算大打算大声道阿萨德阿萨德阿是",
                内容 = "撒大声地撒啊实打实大山东科技阿是登记卡搜嘎鲸打卡噶伤筋动骨尽快阿三哥登记卡三个结婚蛋糕哈时间跨度规划局啊送给大家客户噶时间看到过好贱啊说课稿带回家阿三哥很简单噶事看到过回家阿是看到过哈吉斯开关打开撒给大家好看噶数据库的话噶伤筋动骨阿九十多个几哈送给大家灰咖色孤岛惊魂",
                忽略按钮 = {
                    信息底部面板值 = false
                },
                取消按钮 = {
                    信息底部面板值 = false
                },
                确定按钮 = {
                    信息底部面板值 = false
                },
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
        var 图标状态 by remember { mutableStateOf(Icons.Filled.Visibility) }
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
            输入转换 = InputTransformation.maxLength(最大长度),//最大长度输入转换(最大长度),
            文本混淆模式 = when (图标状态) {
                Icons.Filled.Visibility -> TextObfuscationMode.Visible
                else -> TextObfuscationMode.RevealLastTyped
            }
        )
    }
}



@Preview
@Composable
fun ClickToLoadLinear() {
    // 当前进度：0..100
    var 进度 by remember { mutableIntStateOf(0) }
    // 是否正在加载（防止重复点击）
    var 加载中 by remember { mutableStateOf(false) }
    // 是否暂停状态
    var 暂停 by remember { mutableStateOf(false) }
    // 添加一个job引用以便能够取消
    var 加载中Job by remember { mutableStateOf<Job?>(null) }

    // 保存协程作用域
    val scope = rememberCoroutineScope()

    列 (水平对齐 = Alignment.CenterHorizontally) {
        // 进度条
        线性进度指示器(
            进度 = { 进度 / 100f },
            修饰符 = Modifier.fillMaxWidth().padding(10.dp),
            绘制停止指示器 = {}
        )

        LinearWavyProgressIndicator(
            progress = { 进度 / 100f },
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            stopSize = 0.dp
        )

        文本(文本 = "单击进度条开始加载：${进度}%")

        行{
            按钮 (
                单击回调 = {
                    if (!加载中 || 暂停) {
                        // 如果未运行或已暂停，则开始/恢复加载
                        加载中 = true
                        暂停 = false
                        加载中Job = scope.launch {
                            while (进度 < 100 && 加载中 && !暂停) {
                                delay(100.milliseconds)  // 每 100 ms 前进一次
                                进度 += 1
                            }
                            // 只有正常完成才设为false
                            if (进度 >= 100) {
                                加载中 = false
                                暂停 = false
                            }
                        }
                    }else if (加载中 && !暂停) {
                        // 如果正在运行，则暂停加载
                        暂停 = true
                        加载中Job?.cancel()
                    }
                },
                修饰符 = Modifier.padding(top = 10.dp, bottom = 10.dp),
            ) {
                文本(
                    文本 = when {
                        暂停 -> "继续"
                        加载中 -> "暂停"
                        else -> "加载"
                    }
                )
            }

            间隔器(修饰符 = Modifier.width(50.dp))

            按钮(
                单击回调 = {
                    // 停止加载并重置进度
                    加载中 = false
                    暂停 = false
                    进度 = 0
                    加载中Job?.cancel()
                },
                修饰符 = Modifier.padding(top = 10.dp, bottom = 10.dp),
                已启用 = 加载中 || 进度 > 0 // 正在运行或有进度时可用
            ) { 文本(文本 = "重置") }
        }

    }
}

