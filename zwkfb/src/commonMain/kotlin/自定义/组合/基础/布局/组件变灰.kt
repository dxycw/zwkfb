package 自定义.组合.基础.布局

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import 自定义.组合.基础.可单击变灰
import kotlin.jvm.JvmName

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ComposableNaming")
@JvmName("组件变灰Box")
@Composable
fun 组件变灰(
    修饰符: Modifier = Modifier,
    单击回调: () -> Unit = {},
    是否显示提示: Boolean = false,
    是否禁用: Boolean = false,
    提示事件: @Composable () -> Unit = {},
    内容: @Composable (BoxScope.() -> Unit) = {}
) {
    Column(
        modifier = Modifier.background(Color.Transparent).可单击变灰(是否禁用, 单击回调),
        verticalArrangement = Arrangement.Center, // 垂直对齐
        horizontalAlignment = Alignment.CenterHorizontally // 水平对齐
    ) {
        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(), // 位置提供者
            tooltip = {
                if (是否显示提示) {
                    PlainTooltip { 提示事件() }
                }
            }, // 工具提示内容
            state = rememberTooltipState(), // 状态
            focusable = false, // 焦点可获取
            enableUserInput = true, // 启用用户输入
        ) {
            Box(
                modifier = 修饰符.wrapContentSize().padding(10.dp),
                contentAlignment = Alignment.Center, // 内容对齐
                content = 内容
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ComposableNaming")
@JvmName("组件变灰Row")
@Composable
fun 组件变灰(
    修饰符: Modifier = Modifier,
    单击回调: () -> Unit = {},
    是否显示提示: Boolean = false,
    是否禁用: Boolean = false,
    提示事件: @Composable () -> Unit = {},
    内容: @Composable (RowScope.() -> Unit) = {}
) {
    Column(
        modifier = Modifier.background(Color.Transparent).可单击变灰(是否禁用, 单击回调),
        verticalArrangement = Arrangement.Center, // 垂直对齐
        horizontalAlignment = Alignment.CenterHorizontally // 水平对齐
    ) {
        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(), // 位置提供者
            tooltip = { if (是否显示提示) PlainTooltip { 提示事件() } }, // 工具提示内容
            state = rememberTooltipState(), // 状态
            focusable = false, // 焦点可获取
            enableUserInput = true, // 启用用户输入
        ) {
            Row(
                modifier = 修饰符.wrapContentSize().padding(10.dp),
                horizontalArrangement = Arrangement.Center, // 水平对齐
                verticalAlignment = Alignment.CenterVertically, // 垂直对齐
                content = 内容
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ComposableNaming")
@JvmName("组件变灰Column")
@Composable
fun 组件变灰(
    修饰符: Modifier = Modifier,
    单击回调: () -> Unit = {},
    是否显示提示: Boolean = false,
    是否禁用: Boolean = false,
    提示事件: @Composable () -> Unit = {},
    内容: @Composable (ColumnScope.() -> Unit) = {}
) {
    Column(
        modifier = Modifier.background(Color.Transparent).可单击变灰(是否禁用, 单击回调),
        verticalArrangement = Arrangement.Center, // 垂直对齐
        horizontalAlignment = Alignment.CenterHorizontally // 水平对齐
    ) {
        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(), // 位置提供者
            tooltip = { if (是否显示提示) PlainTooltip { 提示事件() } }, // 工具提示内容
            state = rememberTooltipState(), // 状态
            focusable = false, // 焦点可获取
            enableUserInput = true, // 启用用户输入
        ) {
            Column(
                modifier = 修饰符.wrapContentSize().padding(10.dp),
                verticalArrangement = Arrangement.Center, // 垂直对齐
                horizontalAlignment = Alignment.CenterHorizontally, // 水平对齐
                content = 内容
            )
        }
    }
}