package 安卓x.组合.材质3

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TooltipScope
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Label
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


/**
 * 用于将 [标签] 附加到 [内容] 的 Label 组件。其定位逻辑使用 [TooltipDefaults.rememberTooltipPositionProvider]。
 *
 * @param 标签 将被附加到 [内容] 的可组合项。
 * @param 修饰符 将应用于 [内容] 的 [Modifier]。
 * @param 交互源 表示 [内容] 的 [Interaction] 流的 [MutableInteractionSource]。
 * @param 是否持久化 用于确定 label 是否持续显示的布尔值。如果为 true，label 将始终显示并锚定到 [内容]；
 * 如果为 false，则仅在按下或悬停于 [内容] 上时显示。
 * @param 内容 [标签] 将锚定到的可组合项。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3Api
@Composable
fun 标签(
    标签: @Composable TooltipScope.() -> Unit,
    修饰符: Modifier = Modifier,
    交互源: MutableInteractionSource? = null,
    是否持久化: Boolean = false,
    内容: @Composable () -> Unit,
) =
    Label(
        label = 标签,
        modifier = 修饰符,
        interactionSource = 交互源,
        isPersistent = 是否持久化,
        content = 内容,
    )

