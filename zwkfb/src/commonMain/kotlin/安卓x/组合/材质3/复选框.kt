package 安卓x.组合.材质3

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.state.ToggleableState


/**
 * [Material Design checkbox](https://m3.material.io/components/checkbox/overview)
 *
 * 复选框允许用户从一组选项中选择一个或多个项目。复选框可以将某个选项开启或关闭。
 *
 * ![Checkbox image](https://developer.android.com/images/reference/androidx/compose/material3/checkbox.png)
 *
 * @param 已选中 此复选框是选中还是未选中
 * @param 已选中改变回调 在此复选框被点击时调用。如果为 `null`，则此复选框将不可交互，除非有其他组件处理其输入事件并更新其状态。
 * @param 修饰符 要应用于此复选框的 [Modifier]
 * @param 已启用 控制此复选框的启用状态。当为 `false` 时，此组件将不响应用户输入，并在视觉上呈现为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 颜色集 用于解析此复选框在不同状态下所使用颜色的 [CheckboxColors]。参见 [CheckboxDefaults.colors]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此复选框的 [Interaction]。
 * 你可以用它来改变复选框的外观，或在不同状态下预览复选框。注意，如果传入 null，交互仍会在内部发生。
 * @see [TriStateCheckbox] 如需支持不确定状态，请使用
 */
@Suppress("ComposableNaming")
@Composable
fun 复选框(
    已选中: Boolean,
    已选中改变回调: ((Boolean) -> Unit)?,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: CheckboxColors = CheckboxDefaults.colors(),
    交互源: MutableInteractionSource? = null,
) =
    Checkbox(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
    )


/**
 * [Material Design checkbox](https://m3.material.io/components/checkbox/overview)
 *
 * 复选框允许用户从一组选项中选择一个或多个项目。复选框可以将某个选项开启或关闭。
 *
 * ![Checkbox image](https://developer.android.com/images/reference/androidx/compose/material3/checkbox.png)
 *
 * 此 Checkbox 函数在视觉自定义方面提供了更大的灵活性。使用 [Stroke] 参数，你可以控制勾选标记及其外围方框的外观。
 *
 * @param 已选中 此复选框是选中还是未选中
 * @param 已选中改变回调 在此复选框被点击时调用。如果为 null，则此复选框将不可交互，除非有其他组件处理其输入事件并更新其状态。
 * @param 勾选标记描边 勾选标记的描边
 * @param 轮廓描边 勾选标记方框轮廓的描边。注意，此描边在绘制轮廓的圆角矩形时应用，因此诸如 [androidx.compose.ui.graphics.StrokeJoin] 之类的属性将被忽略。
 * @param 修饰符 要应用于此复选框的 [Modifier]
 * @param 已启用 控制此复选框的启用状态。当为 false 时，此组件将不响应用户输入，并在视觉上呈现为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 颜色集 用于解析此复选框在不同状态下所使用颜色的 [CheckboxColors]。参见 [CheckboxDefaults.colors]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此复选框的 [Interaction]。
 * 你可以用它来改变复选框的外观，或在不同状态下预览复选框。注意，如果传入 null，交互仍会在内部发生。
 * @see [TriStateCheckbox] 如果你需要支持不确定状态。
 */
@Suppress("ComposableNaming")
@Composable
fun 复选框(
    已选中: Boolean,
    已选中改变回调: ((Boolean) -> Unit)?,
    勾选标记描边: Stroke,
    轮廓描边: Stroke,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: CheckboxColors = CheckboxDefaults.colors(),
    交互源: MutableInteractionSource? = null,
) =
    Checkbox(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        checkmarkStroke = 勾选标记描边,
        outlineStroke = 轮廓描边,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
    )


/**
 * [Material Design checkbox](https://m3.material.io/components/checkbox/guidelines)
 *
 * 复选框可以与其他复选框形成父子关系。当父复选框被选中时，所有子复选框都会被选中。如果父复选框被取消选中，所有子复选框都会被取消选中。
 * 如果部分（而非全部）子复选框被选中，则父复选框变为不确定状态。
 *
 * ![Checkbox image](https://developer.android.com/images/reference/androidx/compose/material3/indeterminate-checkbox.png)
 *
 * @param 状态 此复选框是选中、未选中，还是处于不确定状态
 * @param 单击回调 在此复选框被点击时调用。如果为 `null`，则此复选框将不可交互，除非有其他组件处理其输入事件并更新其 [状态]。
 * @param 修饰符 要应用于此复选框的 [Modifier]
 * @param 已启用 控制此复选框的启用状态。当为 `false` 时，此组件将不响应用户输入，并在视觉上呈现为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 颜色集 用于解析此复选框在不同状态下所使用颜色的 [CheckboxColors]。参见 [CheckboxDefaults.colors]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此复选框的 [Interaction]。
 * 你可以用它来改变复选框的外观，或在不同状态下预览复选框。注意，如果传入 null，交互仍会在内部发生。
 * @see [Checkbox] 如果你需要一个表示布尔状态的简单组件
 */
@Suppress("ComposableNaming")
@Composable
fun 三态复选框(
    状态: ToggleableState,
    单击回调: (() -> Unit)?,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: CheckboxColors = CheckboxDefaults.colors(),
    交互源: MutableInteractionSource? = null,
) =
    TriStateCheckbox(
        state = 状态,
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
    )

/**
 * [Material Design checkbox](https://m3.material.io/components/checkbox/guidelines)
 *
 * 复选框可以与其他复选框形成父子关系。当父复选框被选中时，所有子复选框都会被选中。如果父复选框被取消选中，所有子复选框都会被取消选中。
 * 如果部分（而非全部）子复选框被选中，则父复选框变为不确定状态。
 *
 * ![Checkbox image](https://developer.android.com/images/reference/androidx/compose/material3/indeterminate-checkbox.png)
 *
 * 此 Checkbox 函数在视觉自定义方面提供了更大的灵活性。使用 [Stroke] 参数，你可以控制勾选标记及其外围方框的外观。
 *
 * @param 状态 此复选框是选中、未选中，还是处于不确定状态
 * @param 单击回调 在此复选框被点击时调用。如果为 null，则此复选框将不可交互，除非有其他组件处理其输入事件并更新其 [状态]。
 * @param 勾选标记描边 勾选标记的描边
 * @param 轮廓描边 勾选标记方框轮廓的描边。注意，此描边在绘制轮廓的圆角矩形时应用，因此诸如
 * [androidx.compose.ui.graphics.StrokeJoin] 之类的属性将被忽略。
 * @param 修饰符 要应用于此复选框的 [Modifier]
 * @param 已启用 控制此复选框的启用状态。当为 false 时，此组件将不响应用户输入，并在视觉上呈现为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 颜色集 用于解析此复选框在不同状态下所使用颜色的 [CheckboxColors]。参见 [CheckboxDefaults.colors]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此复选框的 [Interaction]。
 * 你可以用它来改变复选框的外观，或在不同状态下预览复选框。注意，如果传入 null，交互仍会在内部发生。
 * @see [Checkbox] 如果你需要一个表示布尔状态的简单组件
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 三态复选框(
    状态: ToggleableState,
    单击回调: (() -> Unit)?,
    勾选标记描边: Stroke,
    轮廓描边: Stroke,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: CheckboxColors = CheckboxDefaults.colors(),
    交互源: MutableInteractionSource? = null,
) =
    TriStateCheckbox(
        state = 状态,
        onClick = 单击回调,
        checkmarkStroke = 勾选标记描边,
        outlineStroke = 轮廓描边,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
    )


/** [Checkbox] 和 [TriStateCheckbox] 中使用的默认值。 */
object 复选框默认值 { // CheckboxDefaults

    /** 创建一个 [CheckboxColors]，它将根据 Material 规范在提供的颜色之间进行动画过渡。*/
    @Composable fun 颜色集() = CheckboxDefaults.colors()

    /**
     * 创建一个 [CheckboxColors]，它将根据 Material 规范在提供的颜色之间进行动画过渡。
     *
     * @param 已选中颜色 选中时边框和方框所使用的颜色
     * @param 未已选中颜色 未选中时边框所使用的颜色。默认情况下，未选中时内部方框为透明。
     * @param 勾选标记颜色 选中时勾选标记所使用的颜色
     * @param 禁用已选中颜色 禁用且已选中时方框和边框所使用的颜色
     * @param 禁用未已选中颜色 禁用且未选中时边框所使用的颜色。默认情况下，未选中时内部方框为透明。
     * @param 禁用未确定颜色 [TriStateCheckbox] 在禁用且处于 [ToggleableState.Indeterminate] 状态时，方框和边框所使用的颜色
     */
    @Composable
    fun 颜色集(
        已选中颜色: Color = Color.Unspecified,
        未已选中颜色: Color = Color.Unspecified,
        勾选标记颜色: Color = Color.Unspecified,
        禁用已选中颜色: Color = Color.Unspecified,
        禁用未已选中颜色: Color = Color.Unspecified,
        禁用未确定颜色: Color = Color.Unspecified,
    ): CheckboxColors =
        CheckboxDefaults.colors(
            checkedColor = 已选中颜色,
            uncheckedColor = 未已选中颜色,
            checkmarkColor = 勾选标记颜色,
            disabledCheckedColor = 禁用已选中颜色,
            disabledUncheckedColor = 禁用未已选中颜色,
            disabledIndeterminateColor = 禁用未确定颜色,
        )

    /**
     * 创建一个 [CheckboxColors]，它将根据 Material 规范在提供的颜色之间进行动画过渡。
     *
     * @param 已选中勾选标记颜色 选中时勾选标记所使用的颜色
     * @param 未已选中勾选标记颜色 未选中时勾选标记所使用的颜色
     * @param 禁用勾选标记颜色 禁用时勾选标记所使用的颜色
     * @param 复选框颜色 选中时方框所使用的颜色
     * @param 未复选框颜色 未选中时方框所使用的颜色
     * @param 禁用复选框颜色 禁用且已选中时方框所使用的颜色
     * @param 禁用未复选框颜色 禁用且未选中时方框所使用的颜色
     * @param 禁用不确定框颜色 [TriStateCheckbox] 在禁用且处于 [ToggleableState.Indeterminate] 状态时，方框和边框所使用的颜色。
     * @param 已选中边框颜色 选中时边框所使用的颜色
     * @param 未已选中边框颜色 未选中时边框所使用的颜色
     * @param 禁用边框颜色 禁用且已选中时边框所使用的颜色
     * @param 禁用未已选中边框颜色 禁用且未选中时边框所使用的颜色
     * @param 禁用不确定边框颜色 禁用且处于 [ToggleableState.Indeterminate] 状态时边框所使用的颜色。
     */
    @Composable
    fun colors(
        已选中勾选标记颜色: Color = Color.Unspecified,
        未已选中勾选标记颜色: Color = Color.Unspecified,
        禁用勾选标记颜色: Color = Color.Unspecified,
        复选框颜色: Color = Color.Unspecified,
        未复选框颜色: Color = Color.Unspecified,
        禁用复选框颜色: Color = Color.Unspecified,
        禁用未复选框颜色: Color = Color.Unspecified,
        禁用不确定框颜色: Color = Color.Unspecified,
        已选中边框颜色: Color = Color.Unspecified,
        未已选中边框颜色: Color = Color.Unspecified,
        禁用边框颜色: Color = Color.Unspecified,
        禁用未已选中边框颜色: Color = Color.Unspecified,
        禁用不确定边框颜色: Color = Color.Unspecified,
    ): CheckboxColors =
        CheckboxDefaults.colors(
            checkedCheckmarkColor = 已选中勾选标记颜色,
            uncheckedCheckmarkColor = 未已选中勾选标记颜色,
            disabledCheckmarkColor = 禁用勾选标记颜色,
            checkedBoxColor = 复选框颜色,
            uncheckedBoxColor = 未复选框颜色,
            disabledCheckedBoxColor = 禁用复选框颜色,
            disabledUncheckedBoxColor = 禁用未复选框颜色,
            disabledIndeterminateBoxColor = 禁用不确定框颜色,
            checkedBorderColor = 已选中边框颜色,
            uncheckedBorderColor = 未已选中边框颜色,
            disabledBorderColor = 禁用边框颜色,
            disabledUncheckedBorderColor = 禁用未已选中边框颜色,
            disabledIndeterminateBorderColor = 禁用不确定边框颜色,
        )


    /**
     * [Checkbox] 的默认描边宽度。当 `Checkbox` 处于已选中或不确定状态时，此宽度将用于勾选标记；当未选中时，此宽度将用于轮廓线。
     */
    val 描边宽度 = CheckboxDefaults.StrokeWidth

}


/**
 * 表示 [Checkbox] 或 [TriStateCheckbox] 的三个不同部分（勾选标记、方框和边框）在不同状态下所使用的颜色。
 *
 * @param 已选中勾选标记颜色 选中时勾选标记所使用的颜色
 * @param 未已选中勾选标记颜色 未选中时勾选标记所使用的颜色
 * @param 复选框颜色 选中时方框所使用的颜色
 * @param 未复选框颜色 未选中时方框所使用的颜色
 * @param 禁用复选框颜色 禁用且已选中时方框所使用的颜色
 * @param 禁用未复选框颜色 禁用且未选中时方框所使用的颜色
 * @param 禁用不确定框颜色 [TriStateCheckbox] 在禁用且处于 [ToggleableState.Indeterminate] 状态时，方框和边框所使用的颜色。
 * @param 已选中边框颜色 选中时边框所使用的颜色
 * @param 未已选中边框颜色 未选中时边框所使用的颜色
 * @param 禁用边框颜色 禁用且已选中时边框所使用的颜色
 * @param 禁用未已选中边框颜色 禁用且未选中时边框所使用的颜色
 * @param 禁用不确定边框颜色 禁用且处于 [ToggleableState.Indeterminate] 状态时边框所使用的颜色。
 * @param 禁用勾选颜色 禁用时勾选标记所使用的颜色
 * @constructor 使用任意颜色创建一个实例，有关遵循 Material 规范的默认实现，请参见 [CheckboxDefaults.colors]。
 */
fun 复选框颜色集(
    已选中勾选标记颜色: Color,
    未已选中勾选标记颜色: Color,
    复选框颜色: Color,
    未复选框颜色: Color,
    禁用复选框颜色: Color,
    禁用未复选框颜色: Color,
    禁用不确定框颜色: Color,
    已选中边框颜色: Color,
    未已选中边框颜色: Color,
    禁用边框颜色: Color,
    禁用未已选中边框颜色: Color,
    禁用不确定边框颜色: Color,
    禁用勾选颜色: Color,
) =
    CheckboxColors(
        checkedCheckmarkColor = 已选中勾选标记颜色,
        uncheckedCheckmarkColor = 未已选中勾选标记颜色,
        checkedBoxColor = 复选框颜色,
        uncheckedBoxColor = 未复选框颜色,
        disabledCheckedBoxColor = 禁用复选框颜色,
        disabledUncheckedBoxColor = 禁用未复选框颜色,
        disabledIndeterminateBoxColor = 禁用不确定框颜色,
        checkedBorderColor = 已选中边框颜色,
        uncheckedBorderColor = 未已选中边框颜色,
        disabledBorderColor = 禁用边框颜色,
        disabledUncheckedBorderColor = 禁用未已选中边框颜色,
        disabledIndeterminateBorderColor = 禁用不确定边框颜色,
        disabledCheckmarkColor = 禁用勾选颜色,
    )


@Deprecated(
    message =
        "This constructor is deprecated. Use the primary constructor that includes 'disabledCheckmarkColor'",
    level = DeprecationLevel.WARNING,
)
fun 复选框颜色集(
    已选中勾选标记颜色: Color,
    未已选中勾选标记颜色: Color,
    复选框颜色: Color,
    未复选框颜色: Color,
    禁用复选框颜色: Color,
    禁用未复选框颜色: Color,
    禁用不确定框颜色: Color,
    已选中边框颜色: Color,
    未已选中边框颜色: Color,
    禁用边框颜色: Color,
    禁用未已选中边框颜色: Color,
    禁用不确定边框颜色: Color,
)  =
    CheckboxColors(
        checkedCheckmarkColor = 已选中勾选标记颜色,
        uncheckedCheckmarkColor = 未已选中勾选标记颜色,
        checkedBoxColor = 复选框颜色,
        uncheckedBoxColor = 未复选框颜色,
        disabledCheckedBoxColor = 禁用复选框颜色,
        disabledUncheckedBoxColor = 禁用未复选框颜色,
        disabledIndeterminateBoxColor = 禁用不确定框颜色,
        checkedBorderColor = 已选中边框颜色,
        uncheckedBorderColor = 未已选中边框颜色,
        disabledBorderColor = 禁用边框颜色,
        disabledUncheckedBorderColor = 禁用未已选中边框颜色,
        disabledIndeterminateBorderColor = 禁用不确定边框颜色,
    )


/** 返回此 CheckboxColors 的副本，可选择性地覆盖其中某些值。此处使用 Color.Unspecified 表示"使用源对象中的值"。*/
fun CheckboxColors.复制(
    已选中勾选标记颜色: Color = this.checkedCheckmarkColor,
    未已选中勾选标记颜色: Color = this.uncheckedCheckmarkColor,
    复选框颜色: Color = this.checkedBoxColor,
    未复选框颜色: Color = this.uncheckedBoxColor,
    禁用复选框颜色: Color = this.disabledCheckedBoxColor,
    禁用未复选框颜色: Color = this.disabledUncheckedBoxColor,
    禁用不确定框颜色: Color = this.disabledIndeterminateBoxColor,
    已选中边框颜色: Color = this.checkedBorderColor,
    未已选中边框颜色: Color = this.uncheckedBorderColor,
    禁用边框颜色: Color = this.disabledBorderColor,
    禁用未已选中边框颜色: Color = this.disabledUncheckedBorderColor,
    禁用不确定边框颜色: Color = this.disabledIndeterminateBorderColor,
    禁用勾选颜色: Color = this.disabledCheckmarkColor,
) =
    this.copy(
        checkedCheckmarkColor = 已选中勾选标记颜色,
        uncheckedCheckmarkColor = 未已选中勾选标记颜色,
        checkedBoxColor = 复选框颜色,
        uncheckedBoxColor = 未复选框颜色,
        disabledCheckedBoxColor = 禁用复选框颜色,
        disabledUncheckedBoxColor = 禁用未复选框颜色,
        disabledIndeterminateBoxColor = 禁用不确定框颜色,
        checkedBorderColor = 已选中边框颜色,
        uncheckedBorderColor = 未已选中边框颜色,
        disabledBorderColor = 禁用边框颜色,
        disabledUncheckedBorderColor = 禁用未已选中边框颜色,
        disabledIndeterminateBorderColor = 禁用不确定边框颜色,
        disabledCheckmarkColor = 禁用勾选颜色,
    )


val CheckboxColors.已选中勾选标记颜色: Color
    get() = this.checkedCheckmarkColor

val CheckboxColors.未已选中勾选标记颜色: Color
    get() = this.uncheckedCheckmarkColor

val CheckboxColors.复选框颜色: Color
    get() = this.checkedBoxColor

val CheckboxColors.未复选框颜色: Color
    get() = this.uncheckedBoxColor

val CheckboxColors.禁用复选框颜色: Color
    get() = this.disabledCheckedBoxColor

val CheckboxColors.禁用未复选框颜色: Color
    get() = this.disabledUncheckedBoxColor

val CheckboxColors.禁用不确定框颜色: Color
    get() = this.disabledIndeterminateBoxColor

val CheckboxColors.已选中边框颜色: Color
    get() = this.checkedBorderColor

val CheckboxColors.未已选中边框颜色: Color
    get() = this.uncheckedBorderColor

val CheckboxColors.禁用边框颜色: Color
    get() = this.disabledBorderColor

val CheckboxColors.禁用未已选中边框颜色: Color
    get() = this.disabledUncheckedBorderColor

val CheckboxColors.禁用不确定边框颜色: Color
    get() = this.disabledIndeterminateBorderColor

val CheckboxColors.禁用勾选颜色: Color
    get() = this.disabledCheckmarkColor