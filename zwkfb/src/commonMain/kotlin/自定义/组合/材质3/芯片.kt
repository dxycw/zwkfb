package 自定义.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import 自定义.组合.材质3.内部芯片.ChipContent
import 自定义.组合.材质3.内部芯片.containerColor
import 自定义.组合.材质3.内部芯片.labelColor
import 自定义.组合.材质3.内部芯片.leadingIconContentColor
import 自定义.组合.材质3.内部芯片.shadowElevation
import 自定义.组合.材质3.内部芯片.trailingIconContentColor
import 自定义.组合.材质3.内部芯片.表面


@Suppress("ComposableNaming")
@Composable
fun 辅助芯片(
    单击回调: () -> Unit,
    长按回调: () -> Unit = {},
    标签: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    形状: Shape = AssistChipDefaults.shape,
    颜色集: ChipColors = AssistChipDefaults.assistChipColors(),
    阴影: ChipElevation? = AssistChipDefaults.assistChipElevation(),
    边框: BorderStroke? = AssistChipDefaults.assistChipBorder(已启用),
    水平排列: Arrangement.Horizontal = AssistChipDefaults.horizontalArrangement(),
    内容内边距: PaddingValues = AssistChipDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
) =
    芯片(
        修饰符 = 修饰符,
        单击回调 = 单击回调,
        长按回调 = 长按回调,
        已启用 = 已启用,
        标签 = 标签,
        标签文本样式 = MaterialTheme.typography.labelLarge,
        标签颜色 = 颜色集.labelColor(已启用),
        前导图标 = 前导图标,
        尾随图标 = 尾随图标,
        形状 = 形状,
        颜色集 = 颜色集,
        阴影 = 阴影,
        边框 = 边框,
        最小高度 = AssistChipDefaults.Height,
        水平排列 = 水平排列,
        内边距值集 = 内容内边距,
        交互源 = 交互源,
    )


@Suppress("ComposableNaming")
@Composable
fun 凸起辅助芯片(
    单击回调: () -> Unit,
    长按回调: () -> Unit = {},
    标签: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    形状: Shape = AssistChipDefaults.shape,
    颜色集: ChipColors = AssistChipDefaults.elevatedAssistChipColors(),
    阴影: ChipElevation? = AssistChipDefaults.elevatedAssistChipElevation(),
    边框: BorderStroke? = null,
    水平排列: Arrangement.Horizontal = AssistChipDefaults.horizontalArrangement(),
    内容内边距: PaddingValues = AssistChipDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
) =
    芯片(
        修饰符 = 修饰符,
        单击回调 = 单击回调,
        长按回调 = 长按回调,
        已启用 = 已启用,
        标签 = 标签,
        标签文本样式 = MaterialTheme.typography.labelLarge,
        标签颜色 = 颜色集.labelColor(已启用),
        前导图标 = 前导图标,
        尾随图标 = 尾随图标,
        形状 = 形状,
        颜色集 = 颜色集,
        阴影 = 阴影,
        边框 = 边框,
        最小高度 = AssistChipDefaults.Height,
        水平排列 = 水平排列,
        内边距值集 = 内容内边距,
        交互源 = 交互源,
    )


@Suppress("ComposableNaming")
@Composable
fun 建议芯片(
    单击回调: () -> Unit,
    长按回调: () -> Unit = {},
    标签: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    图标: @Composable (() -> Unit)? = null,
    形状: Shape = SuggestionChipDefaults.shape,
    颜色集: ChipColors = SuggestionChipDefaults.suggestionChipColors(),
    阴影: ChipElevation? = SuggestionChipDefaults.suggestionChipElevation(),
    边框: BorderStroke? = SuggestionChipDefaults.suggestionChipBorder(已启用),
    水平排列: Arrangement.Horizontal = SuggestionChipDefaults.horizontalArrangement(),
    内容内边距: PaddingValues = SuggestionChipDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
) =
    芯片(
        修饰符 = 修饰符,
        单击回调 = 单击回调,
        长按回调 = 长按回调,
        已启用 = 已启用,
        标签 = 标签,
        标签文本样式 = MaterialTheme.typography.labelLarge,
        标签颜色 = 颜色集.labelColor(已启用),
        前导图标 = 图标,
        尾随图标 = null,
        形状 = 形状,
        颜色集 = 颜色集,
        阴影 = 阴影,
        边框 = 边框,
        最小高度 = SuggestionChipDefaults.Height,
        水平排列 = 水平排列,
        内边距值集 = 内容内边距,
        交互源 = 交互源,
    )

@Suppress("ComposableNaming")
@Composable
fun 凸起建议芯片(
    单击回调: () -> Unit,
    长按回调: () -> Unit = {},
    标签: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    图标: @Composable (() -> Unit)? = null,
    形状: Shape = SuggestionChipDefaults.shape,
    颜色集: ChipColors = SuggestionChipDefaults.elevatedSuggestionChipColors(),
    阴影: ChipElevation? = SuggestionChipDefaults.elevatedSuggestionChipElevation(),
    边框: BorderStroke? = null,
    水平排列: Arrangement.Horizontal = SuggestionChipDefaults.horizontalArrangement(),
    内容内边距: PaddingValues = SuggestionChipDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
) =
    芯片(
        修饰符 = 修饰符,
        单击回调 = 单击回调,
        长按回调 = 长按回调,
        已启用 = 已启用,
        标签 = 标签,
        标签文本样式 = MaterialTheme.typography.labelLarge,
        标签颜色 = 颜色集.labelColor(已启用),
        前导图标 = 图标,
        尾随图标 = null,
        阴影 = 阴影,
        颜色集 = 颜色集,
        最小高度 = SuggestionChipDefaults.Height,
        水平排列 = 水平排列,
        内边距值集 = 内容内边距,
        形状 = 形状,
        边框 = 边框,
        交互源 = 交互源,
    )

//=======================================================================================

@Suppress("ComposableNaming")
@Composable
private fun 芯片(
    修饰符: Modifier,
    单击回调: () -> Unit,
    长按回调: () -> Unit,
    已启用: Boolean,
    标签: @Composable () -> Unit,
    标签文本样式: TextStyle,
    标签颜色: Color,
    前导图标: @Composable (() -> Unit)?,
    尾随图标: @Composable (() -> Unit)?,
    形状: Shape,
    颜色集: ChipColors,
    阴影: ChipElevation?,
    边框: BorderStroke?,
    最小高度: Dp,
    水平排列: Arrangement.Horizontal =
        Arrangement.spacedBy(HorizontalElementsPadding, Alignment.CenterHorizontally),
    内边距值集: PaddingValues,
    交互源: MutableInteractionSource?,
) {
    @Suppress("NAME_SHADOWING")
    val 交互源 = 交互源 ?: remember { MutableInteractionSource() }
    表面(
        单击回调 = 单击回调,
        长按回调 = 长按回调,
        修饰符 = 修饰符.semantics { role = Role.Button },
        已启用 = 已启用,
        形状 = 形状,
        颜色 = 颜色集.containerColor(已启用),
        视觉阴影 = 阴影?.shadowElevation(已启用, 交互源)?.value ?: 0.dp,
        边框 = 边框,
        交互源 = 交互源,
    ) {
        ChipContent(
            label = 标签,
            labelTextStyle = 标签文本样式,
            labelColor = 标签颜色,
            leadingIcon = 前导图标,
            avatar = null,
            trailingIcon = 尾随图标,
            leadingIconColor = 颜色集.leadingIconContentColor(已启用),
            trailingIconColor = 颜色集.trailingIconContentColor(已启用),
            minHeight = 最小高度,
            horizontalArrangement = 水平排列,
            paddingValues = 内边距值集,
        )
    }
}


//================================================================================

/** The padding between the elements in the chip. */
private val HorizontalElementsPadding = 8.dp


