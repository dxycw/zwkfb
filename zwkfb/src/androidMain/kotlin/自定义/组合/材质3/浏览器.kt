package 自定义.组合.材质3

import android.annotation.SuppressLint
import android.view.View
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import 安卓.应用.关闭
import 安卓.应用.覆盖待处理过渡
import 安卓x.组合.基础.布局.列
import 安卓x.组合.运行时.记住
import 自定义.组合.材质3.网页.接收标题事件
import 自定义.组合.材质3.网页.浏览器
import 自定义.组合.材质3.网页.浏览器客户端
import 自定义.组合.材质3.网页.浏览器客户端事件
import 自定义.组合.材质3.网页.浏览器导航
import 自定义.组合.材质3.网页.浏览器状态
import 自定义.组合.材质3.网页.浏览器配置
import 自定义.组合.材质3.网页.网络下载监听
import 自定义.组合.材质3.网页.网络下载监听事件
import 自定义.组合.材质3.网页.网络浏览器客户端
import 自定义.组合.材质3.网页.网络浏览器客户端事件
import 自定义.组合.材质3.网页.网页加载进度事件
import 自定义.组合.材质3.网页.网页完成加载事件
import 自定义.组合.材质3.网页.网页跳转拦截事件请求
import 自定义.组合.材质3.网页.网页跳转拦截事件请求事件
import 自定义.组合.材质3.网页.记住浏览器导航状态
import 自定义.组合.材质3.网页.记住浏览器状态
import 自定义.组合.活动.注册返回键回调事件


/**
 * @param 状态 浏览器状态
 * @param 导航状态 浏览器导航
 * @param 修饰符 修饰符
 * @param 浏览器客户端事件 浏览器客户端事件
 * @param 网络浏览器客户端事件 网络浏览器客户端事件
 * @param 下载监听事件 网络下载监听事件
 * @param 返回键回调 返回键回调
 */
@SuppressLint("ComposableNaming","ModifierParameter")
@Preview
@Composable
fun 默认浏览器(
    状态: 浏览器状态 = 记住浏览器状态("https://www.baidu.com"),
    导航状态: 浏览器导航 = 记住浏览器导航状态(),
    修饰符: Modifier = Modifier,
    浏览器客户端事件: 浏览器客户端事件 = 浏览器客户端,
    网络浏览器客户端事件: 网络浏览器客户端事件 = 网络浏览器客户端,
    下载监听事件: 网络下载监听事件 = 网络下载监听,
    返回键回调: () -> Unit = {}
){
    val 上下文 = LocalActivity.current
    注册返回键回调事件{
        if (导航状态.可后退){ 导航状态.后退() }
        else{ 返回键回调() }
    }
    浏览器(
        状态 = 状态, 导航状态 = 导航状态,
        修饰符 = 修饰符.fillMaxSize(),
        更新内容 = { 浏览器 ->
            浏览器.apply {
                // 硬件加速,防止窗口在深色模式闪烁
                setLayerType(View.LAYER_TYPE_HARDWARE, null)
            }
        },
        浏览器配置 = { 配置 -> 浏览器配置(上下文!!,配置) },
        浏览器客户端事件 = 浏览器客户端事件.网页跳转拦截事件请求事件{ _, 网址请求 ->
            return@网页跳转拦截事件请求事件 网页跳转拦截事件请求(上下文!!,网址请求)
        },
        网络浏览器客户端事件 = 网络浏览器客户端事件,
    )
}



/**
 * @param 进度条位置  false: 上 , true: 下
 * @param 状态 浏览器状态
 * @param 导航状态 浏览器导航
 * @param 修饰符 修饰符
 * @param 浏览器客户端事件 浏览器客户端事件
 * @param 网络浏览器客户端事件 网络浏览器客户端事件
 * @param 下载监听事件 网络下载监听事件
 */
@SuppressLint("ComposableNaming","ModifierParameter")
@Preview
@Composable
fun 默认进度条浏览器(
    进度条位置: Boolean = false,
    状态: 浏览器状态 = 记住浏览器状态("https://www.baidu.com"),
    导航状态: 浏览器导航 = 记住浏览器导航状态(),
    修饰符: Modifier = Modifier,
    浏览器客户端事件: 浏览器客户端事件 = 浏览器客户端,
    网络浏览器客户端事件: 网络浏览器客户端事件 = 网络浏览器客户端,
    下载监听事件: 网络下载监听事件 = 网络下载监听,
) {
    val 上下文 = LocalActivity.current
    var 标题状态 by 记住 { mutableStateOf("") } //恢复重载后标题是网址的Bug
    var 加载进度状态 by 记住 { mutableFloatStateOf(0f) }
    var 显示加载进度 by 记住 { mutableStateOf(false) }

    列(修饰符){
        if (!进度条位置 && 显示加载进度) {
            线性进度指示器 (
                进度 = { 加载进度状态 },
                修饰符 = Modifier.fillMaxWidth(),
                轨道颜色 = Color.Transparent,
                线条高度 = 2.dp,
                绘制停止指示器 = {} //去掉末端进度条
            )
        }
        默认浏览器(
            状态 = 状态,
            导航状态 = 导航状态,
            修饰符 = Modifier.weight(1f),
            浏览器客户端事件 = 浏览器客户端事件
                .网页完成加载事件{ 浏览器,_ ->
                    状态.网页标题 = 标题状态
                },
            网络浏览器客户端事件 = 网络浏览器客户端事件
                .接收标题事件{ 浏览器,标题 ->
                    标题状态 = 标题
                }
                .网页加载进度事件 { 浏览器, 进度 ->
//                    显示加载进度 = 进度 < 100
                    加载进度状态 = 进度 * 0.01f
                    显示加载进度 = 加载进度状态 < 0.5f
                },
            下载监听事件 = 下载监听事件,
            返回键回调 = {
                上下文?.关闭()
                上下文?.覆盖待处理过渡(0, 0)
            }
        )
        if (进度条位置 && 显示加载进度) {
            线性进度指示器(
                进度 = { 加载进度状态 },
                修饰符 = Modifier.fillMaxWidth(),
                轨道颜色 = Color.Transparent,
                线条高度 = 2.dp,
                绘制停止指示器 = {} //去掉末端进度条
            )
        }
    }
}
