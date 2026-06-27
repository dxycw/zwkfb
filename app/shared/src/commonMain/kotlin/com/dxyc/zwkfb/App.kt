package com.dxyc.zwkfb

import androidx.annotation.IntRange
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.input.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds
import multiplatform.zwkfb.Greeting
import org.jetbrains.compose.resources.painterResource
import zwkfbmultiplatform.app.shared.generated.resources.*
import 安卓x.组合.动画.动画可见性
import 安卓x.组合.基础.图像
import 安卓x.组合.基础.布局.*
import 安卓x.组合.材质3.*

@Composable
@Preview
fun App() {
    材质主题 {
        脚手架(
            容器颜色 = Color.Transparent
        ) { 内边距 ->
            列(
                修饰符 = Modifier.padding(内边距).fillMaxSize(),
                水平对齐 = Alignment.CenterHorizontally,
            ) {

                ClickToLoadLinear()

                val 测试值 = remember { TextFieldState("测试") }
                var 图标状态 by remember { mutableStateOf(Icons.Filled.Visibility) }
                轮廓安全文本字段(
                    状态 = 测试值,
                    标签 = { 文本("测试") },
                    尾随图标 = {
                        图标按钮(
                            单击回调 = {
                                图标状态 = when (图标状态) {
                                    Icons.Filled.Visibility -> Icons.Filled.VisibilityOff
                                    else -> Icons.Filled.Visibility
                                }
                            }
                        ) {
                            图标(
                                图像矢量 = 图标状态,
                                内容描述 = null,
                            )
                        }
                    },
                    输入转换 = 最大长度输入转换(20),
                    文本混淆模式 = when (图标状态) {
                        Icons.Filled.Visibility -> TextObfuscationMode.Visible
                        else -> TextObfuscationMode.RevealLastTyped
                    }
                )

                var showContent by remember { mutableStateOf(false) }
                按钮(单击回调 = { showContent = !showContent }
                ) { 文本("单击我!") }

                动画可见性(showContent) {
                    val greeting = remember { Greeting().greet() }
                    列(
                        修饰符 = Modifier.fillMaxWidth(),
                        水平对齐 = Alignment.CenterHorizontally,
                    ) {
                        图像(
                            绘制器 = painterResource(Res.drawable.compose_multiplatform),
                            内容描述 = null,
                            修饰符 = Modifier.size(200.dp)
                        )
                        文本("Compose: $greeting")
                    }
                }

            }
        }

    }
}


/**
 * 最大长度输入转换
 *
 * @param 最大长度 最大长度范围，0-100之间超过100位时，截断到100位
 * @throws IllegalArgumentException 如果最大长度不在0-100之间，抛出异常
 */
class 最大长度输入转换(
    @field:IntRange(from = 0, to = 100) private val 最大长度: Int
) : InputTransformation {
    override fun TextFieldBuffer.transformInput() {
        // 移除输入中的所有空格
        val trimmed = this.asCharSequence().filterNot { it.isWhitespace() }
        // 如果长度超过16位，截断到16位
        if (trimmed.length > 最大长度) {
            replace(0, length, trimmed.take(最大长度))
        } else if (trimmed.length != length) {
            // 如果有空格需要移除，更新内容
            replace(0, length, trimmed)
        }
    }
}


@Preview
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
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

    val scope = rememberCoroutineScope()
    //    保存协程作用域
    列 (
        修饰符 = Modifier.padding(10.dp),
        水平对齐 = Alignment.CenterHorizontally
    ) {
        // 进度条

        线性进度指示器(
            进度 = { 进度 / 100f },
            修饰符 = Modifier.fillMaxWidth().padding(16.dp),
            绘制停止指示器 = {}
        )

        LinearWavyProgressIndicator(
            progress = { 进度 / 100f },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
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
                修饰符 = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
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
                修饰符 = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
                已启用 = 加载中 || 进度 > 0 // 正在运行或有进度时可用
            ) { 文本(文本 = "重置") }
        }

    }
}
