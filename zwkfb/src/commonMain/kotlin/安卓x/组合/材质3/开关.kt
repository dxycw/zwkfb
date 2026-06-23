package 安卓x.组合.材质3

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

/**
 * [Material Design switch](https://m3.material.io/components/switch)
 *
 * 开关用于将单个项目的状态切换为开启或关闭。
 *
 * ![Switch image](https://developer.android.com/images/reference/androidx/compose/material3/switch.png)
 *
 * @param 已选中 此开关是否已选中
 * @param 已选中改变回调 当此开关被点击时调用。如果为 `null`，则此开关将不可交互，除非有其他组件处理其输入事件并更新其状态。
 * @param 修饰符 要应用于此开关的 [Modifier]。
 * @param 滑块内容 将绘制在滑块（thumb）内部的内容，预期测量尺寸为 [SwitchDefaults.IconSize]。
 * @param 已启用 控制此开关的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上和辅助功能服务中均显示为禁用状态。
 * @param 颜色集 用于解析此开关在不同状态下所使用的颜色的 [SwitchColors]。请参阅 [SwitchDefaults.colors]。
 * @param 交互源 用于观察和发送此开关的 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改开关的外观或在不同状态下预览开关。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Composable
@Suppress("ComposableLambdaParameterNaming", "ComposableLambdaParameterPosition",
    "ComposableNaming"
)
fun 开关(
    已选中: Boolean,
    已选中改变回调: ((Boolean) -> Unit)?,
    修饰符: Modifier = Modifier,
    滑块内容: (@Composable () -> Unit)? = null,
    已启用: Boolean = true,
    颜色集: SwitchColors = SwitchDefaults.colors(),
    交互源: MutableInteractionSource? = null,
) =
    Switch(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        thumbContent = 滑块内容,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
    )


/** 包含 [Switch] 使用的默认值。 */
object 开关默认值 { // SwitchDefaults

    /** 创建一个 [SwitchColors]，用于表示 [Switch] 在不同状态下使用的不同颜色。*/
    @Composable
    fun 颜色集() = SwitchDefaults.colors()

    /**
     * 创建一个 [SwitchColors]，用于表示 [Switch] 在不同状态下使用的不同颜色。
     *
     * @param 已选中滑块颜色 开关启用且已选中时滑块使用的颜色。
     * @param 已选中轨道颜色 开关启用且已选中时轨道使用的颜色。
     * @param 已选中边框颜色 启用且已选中时边框使用的颜色。
     * @param 已选中图标颜色 启用且已选中时图标使用的颜色。
     * @param 未已选中滑块颜色 启用且未选中时滑块使用的颜色。
     * @param 未已选中轨道颜色 启用且未选中时轨道使用的颜色。
     * @param 未已选中边框颜色 启用且未选中时边框使用的颜色。
     * @param 未已选中图标颜色 启用且未选中时图标使用的颜色。
     * @param 禁用已选中滑块颜色 禁用且已选中时滑块使用的颜色。
     * @param 禁用已选中轨道颜色 禁用且已选中时轨道使用的颜色。
     * @param 禁用已选中边框颜色 禁用且已选中时边框使用的颜色。
     * @param 禁用已选中图标颜色 禁用且已选中时图标使用的颜色。
     * @param 禁用未已选中滑块颜色 禁用且未选中时滑块使用的颜色。
     * @param 禁用未已选中轨道颜色 禁用且未选中时轨道使用的颜色。
     * @param 禁用未已选中边框颜色 禁用且未选中时边框使用的颜色。
     * @param 禁用未已选中图标颜色 禁用且未选中时图标使用的颜色。
     */
    @Composable
    fun 颜色集(
        已选中滑块颜色: Color = MaterialTheme.colorScheme.onPrimary,
        已选中轨道颜色: Color = MaterialTheme.colorScheme.primary,
        已选中边框颜色: Color = Color.Transparent,
        已选中图标颜色: Color = MaterialTheme.colorScheme.onPrimaryContainer,
        未已选中滑块颜色: Color = MaterialTheme.colorScheme.outline,
        未已选中轨道颜色: Color = MaterialTheme.colorScheme.surfaceContainerHighest,
        未已选中边框颜色: Color = MaterialTheme.colorScheme.outline,
        未已选中图标颜色: Color = MaterialTheme.colorScheme.surfaceContainerHighest,
        禁用已选中滑块颜色: Color = MaterialTheme.colorScheme.surface.copy(alpha = 1.0f)
                .compositeOver(MaterialTheme.colorScheme.surface),
        禁用已选中轨道颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                .compositeOver(MaterialTheme.colorScheme.surface),
        禁用已选中边框颜色: Color = Color.Transparent,
        禁用已选中图标颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                .compositeOver(MaterialTheme.colorScheme.surface),
        禁用未已选中滑块颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                .compositeOver(MaterialTheme.colorScheme.surface),
        禁用未已选中轨道颜色: Color = MaterialTheme.colorScheme.surfaceContainerHighest.copy(alpha = 0.12f)
                .compositeOver(MaterialTheme.colorScheme.surface),
        禁用未已选中边框颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                .compositeOver(MaterialTheme.colorScheme.surface),
        禁用未已选中图标颜色: Color = MaterialTheme.colorScheme.surfaceContainerHighest.copy(alpha = 0.38f)
                .compositeOver(MaterialTheme.colorScheme.surface),
    ): SwitchColors =
        SwitchDefaults.colors(
            checkedThumbColor = 已选中滑块颜色,
            checkedTrackColor = 已选中轨道颜色,
            checkedBorderColor = 已选中边框颜色,
            checkedIconColor = 已选中图标颜色,
            uncheckedThumbColor = 未已选中滑块颜色,
            uncheckedTrackColor = 未已选中轨道颜色,
            uncheckedBorderColor = 未已选中边框颜色,
            uncheckedIconColor = 未已选中图标颜色,
            disabledCheckedThumbColor = 禁用已选中滑块颜色,
            disabledCheckedTrackColor = 禁用已选中轨道颜色,
            disabledCheckedBorderColor = 禁用已选中边框颜色,
            disabledCheckedIconColor = 禁用已选中图标颜色,
            disabledUncheckedThumbColor = 禁用未已选中滑块颜色,
            disabledUncheckedTrackColor = 禁用未已选中轨道颜色,
            disabledUncheckedBorderColor = 禁用未已选中边框颜色,
            disabledUncheckedIconColor = 禁用未已选中图标颜色,
        )

    /** 用于 `滑块内容` 的图标尺寸。 */
    val 图标大小 = SwitchDefaults.IconSize

}


/**
 * 表示 [Switch] 在不同状态下使用的颜色。
 *
 * @param 已选中滑块颜色 开关启用且已选中时滑块使用的颜色。
 * @param 已选中轨道颜色 开关启用且已选中时轨道使用的颜色。
 * @param 已选中边框颜色 开关启用且已选中时边框使用的颜色。
 * @param 已选中图标颜色 开关启用且已选中时图标使用的颜色。
 * @param 未已选中滑块颜色 开关启用且未选中时滑块使用的颜色。
 * @param 未已选中轨道颜色 开关启用且未选中时轨道使用的颜色。
 * @param 未已选中边框颜色 开关启用且未选中时边框使用的颜色。
 * @param 未已选中图标颜色 开关启用且未选中时图标使用的颜色。
 * @param 禁用已选中滑块颜色 开关禁用且已选中时滑块使用的颜色。
 * @param 禁用已选中轨道颜色 开关禁用且已选中时轨道使用的颜色。
 * @param 禁用已选中边框颜色 开关禁用且已选中时边框使用的颜色。
 * @param 禁用已选中图标颜色 开关禁用且已选中时图标使用的颜色。
 * @param 禁用未已选中滑块颜色 开关禁用且未选中时滑块使用的颜色。
 * @param 禁用未已选中轨道颜色 开关禁用且未选中时轨道使用的颜色。
 * @param 禁用未已选中边框颜色 开关禁用且未选中时边框使用的颜色。
 * @param 禁用未已选中图标颜色 开关禁用且未选中时图标使用的颜色。
 * @constructor 使用任意颜色创建一个实例。请参阅遵循 Material 规范的默认实现 [SwitchDefaults.colors]。
 */
fun 开关颜色集(
    已选中滑块颜色: Color,
    已选中轨道颜色: Color,
    已选中边框颜色: Color,
    已选中图标颜色: Color,
    未已选中滑块颜色: Color,
    未已选中轨道颜色: Color,
    未已选中边框颜色: Color,
    未已选中图标颜色: Color,
    禁用已选中滑块颜色: Color,
    禁用已选中轨道颜色: Color,
    禁用已选中边框颜色: Color,
    禁用已选中图标颜色: Color,
    禁用未已选中滑块颜色: Color,
    禁用未已选中轨道颜色: Color,
    禁用未已选中边框颜色: Color,
    禁用未已选中图标颜色: Color,
) =
    SwitchColors(
        checkedThumbColor = 已选中滑块颜色,
        checkedTrackColor = 已选中轨道颜色,
        checkedBorderColor = 已选中边框颜色,
        checkedIconColor = 已选中图标颜色,
        uncheckedThumbColor = 未已选中滑块颜色,
        uncheckedTrackColor = 未已选中轨道颜色,
        uncheckedBorderColor = 未已选中边框颜色,
        uncheckedIconColor = 未已选中图标颜色,
        disabledCheckedThumbColor = 禁用已选中滑块颜色,
        disabledCheckedTrackColor = 禁用已选中轨道颜色,
        disabledCheckedBorderColor = 禁用已选中边框颜色,
        disabledCheckedIconColor = 禁用已选中图标颜色,
        disabledUncheckedThumbColor = 禁用未已选中滑块颜色,
        disabledUncheckedTrackColor = 禁用未已选中轨道颜色,
        disabledUncheckedBorderColor = 禁用未已选中边框颜色,
        disabledUncheckedIconColor = 禁用未已选中图标颜色,
    )


/** 返回此 SwitchColors 的副本，可选择性地覆盖部分值。此处使用 Color.Unspecified 表示"使用源中的值"。*/
fun SwitchColors.复制(
    已选中滑块颜色: Color = this.checkedThumbColor,
    已选中轨道颜色: Color = this.checkedTrackColor,
    已选中边框颜色: Color = this.checkedBorderColor,
    已选中图标颜色: Color = this.checkedIconColor,
    未已选中滑块颜色: Color = this.uncheckedThumbColor,
    未已选中轨道颜色: Color = this.uncheckedTrackColor,
    未已选中边框颜色: Color = this.uncheckedBorderColor,
    未已选中图标颜色: Color = this.uncheckedIconColor,
    禁用已选中滑块颜色: Color = this.disabledCheckedThumbColor,
    禁用已选中轨道颜色: Color = this.disabledCheckedTrackColor,
    禁用已选中边框颜色: Color = this.disabledCheckedBorderColor,
    禁用已选中图标颜色: Color = this.disabledCheckedIconColor,
    禁用未已选中滑块颜色: Color = this.disabledUncheckedThumbColor,
    禁用未已选中轨道颜色: Color = this.disabledUncheckedTrackColor,
    禁用未已选中边框颜色: Color = this.disabledUncheckedBorderColor,
    禁用未已选中图标颜色: Color = this.disabledUncheckedIconColor,
) =
    this.copy(
        checkedThumbColor = 已选中滑块颜色,
        checkedTrackColor = 已选中轨道颜色,
        checkedBorderColor = 已选中边框颜色,
        checkedIconColor = 已选中图标颜色,
        uncheckedThumbColor = 未已选中滑块颜色,
        uncheckedTrackColor = 未已选中轨道颜色,
        uncheckedBorderColor = 未已选中边框颜色,
        uncheckedIconColor = 未已选中图标颜色,
        disabledCheckedThumbColor = 禁用已选中滑块颜色,
        disabledCheckedTrackColor = 禁用已选中轨道颜色,
        disabledCheckedBorderColor = 禁用已选中边框颜色,
        disabledCheckedIconColor = 禁用已选中图标颜色,
        disabledUncheckedThumbColor = 禁用未已选中滑块颜色,
        disabledUncheckedTrackColor = 禁用未已选中轨道颜色,
        disabledUncheckedBorderColor = 禁用未已选中边框颜色,
        disabledUncheckedIconColor = 禁用未已选中图标颜色,
    )


