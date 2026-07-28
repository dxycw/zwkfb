package 自定义.组合.基础.布局

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TooltipScope
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.CombinedModifier
import androidx.compose.ui.Modifier
import 自定义.组合.基础.可单击变灰

/**
 * 组件变灰提示盒子案例：
 * ```
 * 组件变灰提示盒子(
 *    单击回调 = {},
 *    工具提示 = {
 *        this.普通工具提示 { Text("提示") }
 *     },
 * ) {
 *    Text("按钮")
 * }
 * ```
 */
@Suppress("ComposableNaming")
@Composable
fun 组件变灰提示盒子(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    是否禁用变灰: Boolean = false,
    工具提示: @Composable TooltipScope.() -> Unit = {},
    内容: @Composable (BoxScope.() -> Unit)
) {
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(), // 位置提供者
        tooltip = 工具提示, // 工具提示内容
        state = rememberTooltipState(), // 状态
        focusable = false, // 焦点可获取
        enableUserInput = true, // 启用用户输入
    ) {
        Box(
            modifier = CombinedModifier(Modifier.可单击变灰(是否禁用变灰, 单击回调),修饰符),//修饰符,
            contentAlignment = Alignment.Center, // 内容对齐
            content = 内容
        )
    }
}

/**
 * 组件变灰提示行案例：
 * ```
 * 组件变灰提示行(
 *    单击回调 = {},
 *    工具提示 = {
 *        this.普通工具提示 { Text("提示") }
 *     },
 * ) {
 *    Text("按钮")
 * }
 * ```
 */
@Suppress("ComposableNaming")
@Composable
fun 组件变灰提示行(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    是否禁用变灰: Boolean = false,
    工具提示: @Composable TooltipScope.() -> Unit = {},
    内容: @Composable (RowScope.() -> Unit)
) {
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(), // 位置提供者
        tooltip = 工具提示, // 工具提示内容
        state = rememberTooltipState(), // 状态
        focusable = false, // 焦点可获取
        enableUserInput = true, // 启用用户输入
    ) {
        Row(
            modifier = CombinedModifier(Modifier.可单击变灰(是否禁用变灰, 单击回调),修饰符),//修饰符,
            horizontalArrangement = Arrangement.Center, // 水平对齐
            verticalAlignment = Alignment.CenterVertically, // 垂直对齐
            content = 内容
        )
    }
}

/**
 * 组件变灰提示列案例：
 * ```
 * 组件变灰提示列(
 *    单击回调 = {},
 *    工具提示 = {
 *        this.普通工具提示 { Text("提示") }
 *     },
 * ) {
 *    Text("按钮")
 * }
 * ```
 */
@Suppress("ComposableNaming")
@Composable
fun 组件变灰提示列(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    是否禁用变灰: Boolean = false,
    工具提示: @Composable TooltipScope.() -> Unit = {},
    内容: @Composable (ColumnScope.() -> Unit)
) {
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(), // 位置提供者
        tooltip = 工具提示, // 工具提示内容
        state = rememberTooltipState(), // 状态
        focusable = false, // 焦点可获取
        enableUserInput = true, // 启用用户输入
    ) {
        Column(
            modifier = CombinedModifier(Modifier.可单击变灰(是否禁用变灰, 单击回调),修饰符),//修饰符,
            verticalArrangement = Arrangement.Center, // 垂直对齐
            horizontalAlignment = Alignment.CenterHorizontally, // 水平对齐
            content = 内容
        )
    }
}