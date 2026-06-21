package 安卓x.组合.材质3

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * [Material Design radio button](https://m3.material.io/components/radio-button/overview)
 *
 * 单选按钮允许用户从一组选项中选择一个。
 *
 * ![Radio button image](https://developer.android.com/images/reference/androidx/compose/material3/radio-button.png)
 *
 * @param 已选择 此单选按钮是否被选中
 * @param 单击回调 在此单选按钮被点击时调用。如果为 `null`，则此单选按钮将不可交互，除非有其他组件处理其输入事件并更新其状态。
 * @param 修饰符 要应用于此单选按钮的 [Modifier]
 * @param 已启用 控制此单选按钮的启用状态。当为 `false` 时，此组件将不响应用户输入，并在视觉上呈现为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 颜色集 用于解析此单选按钮在不同状态下所使用颜色的 [RadioButtonColors]。参见 [RadioButtonDefaults.colors]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此单选按钮的 [Interaction]。
 * 你可以用它来改变单选按钮的外观，或在不同状态下预览单选按钮。注意，如果传入 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 单选按钮(
    已选择: Boolean,
    单击回调: (() -> Unit)?,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: RadioButtonColors = RadioButtonDefaults.colors(),
    交互源: MutableInteractionSource? = null,
) {
    RadioButton(
        selected = 已选择,
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
    )
}


/** [RadioButton] 中使用的默认值。 */
object 单选按钮默认值 { // RadioButtonDefaults

    /** 创建一个 [RadioButtonColors]，它将根据 Material 规范在提供的颜色之间进行动画过渡。*/
    @Composable
    fun 颜色集() = RadioButtonDefaults.colors()

    /**
     * 创建一个 [RadioButtonColors]，它将根据 Material 规范在提供的颜色之间进行动画过渡。
     *
     * @param 已选择颜色 单选按钮在已选中且启用状态下使用的颜色。
     * @param 未已选择颜色 单选按钮在未选中且启用状态下使用的颜色。
     * @param 禁用已选择颜色 单选按钮在禁用且已选中状态下使用的颜色。
     * @param 禁用未已选择颜色 单选按钮在禁用且未选中状态下使用的颜色。
     * @return 用于该单选按钮的生成的 [RadioButtonColors]
     */
    @Composable
    fun 颜色集(
        已选择颜色: Color = Color.Unspecified,
        未已选择颜色: Color = Color.Unspecified,
        禁用已选择颜色: Color = Color.Unspecified,
        禁用未已选择颜色: Color = Color.Unspecified,
    ): RadioButtonColors =
        RadioButtonDefaults.colors(
            selectedColor = 已选择颜色,
            unselectedColor = 未已选择颜色,
            disabledSelectedColor = 禁用已选择颜色,
            disabledUnselectedColor = 禁用未已选择颜色,
        )

}


/**
 * 表示 [RadioButton] 在不同状态下所使用的颜色。
 *
 * @param 已选择颜色 单选按钮在已选中且启用状态下使用的颜色。
 * @param 未已选择颜色 单选按钮在未选中且启用状态下使用的颜色。
 * @param 禁用已选择颜色 单选按钮在禁用且已选中状态下使用的颜色。
 * @param 禁用未已选择颜色 单选按钮在禁用且未选中状态下使用的颜色。
 * @constructor 使用任意颜色创建一个实例。有关遵循 Material 规范的默认实现，请参见 [RadioButtonDefaults.colors]。
 */
fun 单选按钮颜色集(
    已选择颜色: Color,
    未已选择颜色: Color,
    禁用已选择颜色: Color,
    禁用未已选择颜色: Color,
) =
    RadioButtonColors(
        selectedColor = 已选择颜色,
        unselectedColor= 未已选择颜色,
        disabledSelectedColor= 禁用已选择颜色,
        disabledUnselectedColor= 禁用未已选择颜色,
    )

/** 返回此 SelectableChipColors 的副本，可选择性地覆盖其中某些值。此处使用 Color.Unspecified 表示"使用源对象中的值"。*/
fun RadioButtonColors.复制(
    已选择颜色: Color = this.selectedColor,
    未已选择颜色: Color = this.unselectedColor,
    禁用已选择颜色: Color = this.disabledSelectedColor,
    禁用未已选择颜色: Color = this.disabledUnselectedColor,
) =
    this.copy(
        selectedColor = 已选择颜色,
        unselectedColor= 未已选择颜色,
        disabledSelectedColor= 禁用已选择颜色,
        disabledUnselectedColor= 禁用未已选择颜色,
    )

