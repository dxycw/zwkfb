@file:OptIn(ExperimentalMaterial3Api::class)

package 安卓x.组合.材质3

import androidx.annotation.IntRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.TimePickerSelectionMode
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.isHourInputValid
import androidx.compose.material3.isInputValid
import androidx.compose.material3.isMinuteInputValid
import androidx.compose.material3.isPm
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.jvm.JvmInline

/**
 * [Material Design time picker](https://m3.material.io/components/time-pickers/overview)
 *
 * 时间选择器帮助用户选择并设置特定时间。
 *
 * 显示一个允许用户选择时间的选择器。通过 [TimePickerState] 订阅更新。
 *
 * ![Time picker image](https://developer.android.com/images/reference/androidx/compose/material3/time-picker.png)
 *
 * 此时间选择器的状态，允许订阅 [TimePickerState.hour] 和 [TimePickerState.minute] 的变化，并设置此选择器的初始时间。
 *
 * @param 状态 此时间输入框的状态，允许订阅 [TimePickerState.hour] 和 [TimePickerState.minute] 的变化，并设置此输入框的初始时间。
 * @param 修饰符 要应用于此时间输入框的 [Modifier]。
 * @param 颜色集 colors用于解析此时间选择器在不同状态下所使用的颜色的 [TimePickerColors]。参见 [TimePickerDefaults.colors]。
 * @param 布局类型 此时间选择器支持的不同 [TimePickerLayoutType]，它会改变时间选择器各组件的位置和尺寸。
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalMaterial3Api
fun 时间选择器(
    状态: TimePickerState,
    修饰符: Modifier = Modifier,
    颜色集: TimePickerColors = TimePickerDefaults.colors(),
    布局类型: TimePickerLayoutType = TimePickerDefaults.layoutType(),
) {
    TimePicker(
        state = 状态,
        modifier = 修饰符,
        colors = 颜色集,
        layoutType = 布局类型,
    )
}

/**
 * 时间选择器帮助用户选择并设置特定时间。
 *
 * 显示一个时间输入框，允许用户通过两个文本字段输入时间，一个用于分钟，一个用于小时。通过 [TimePickerState] 订阅更新。
 *
 * @param 状态 此时间选择器的状态，允许订阅 [TimePickerState.hour] 和 [TimePickerState.minute] 的变化，并设置此选择器的初始时间。
 * @param 修饰符 要应用于此时间输入框的 [Modifier]。
 * @param 颜色集 colors 用于解析此时间输入框在不同状态下所使用的颜色的 [TimePickerColors]。参见 [TimePickerDefaults.colors]。
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalMaterial3Api
fun 时间输入(
    状态: TimePickerState,
    修饰符: Modifier = Modifier,
    颜色集: TimePickerColors = TimePickerDefaults.colors(),
) {
    TimeInput(
        state = 状态,
        modifier = 修饰符,
        colors = 颜色集
    )
}


/** 包含 [TimePicker] 所使用的默认值。 */
@ExperimentalMaterial3Api
@Stable
object 时间选择器默认值 { // TimePickerDefaults

    /** [TimePicker] 在不同状态下使用的默认颜色。 */
    @Composable
    fun 颜色集() = TimePickerDefaults.colors()

    /**
     * [TimePicker] 在不同状态下使用的默认颜色。
     *
     * @param 时钟表盘颜色 时钟表盘的颜色。
     * @param 时钟表盘选中内容颜色 时钟表盘上的数字在被选中或与选择器重叠时的颜色。
     * @param 时钟表盘未选中内容颜色 时钟表盘上的数字在未选中时的颜色。
     * @param 选择器颜色 时钟表盘选择器的颜色。
     * @param 容器颜色 时间选择器的容器颜色。
     * @param 周期选择器边框颜色 上午/下午切换按钮边框所使用的颜色。
     * @param 周期选择器选中容器颜色 上午/下午切换按钮中所选中容器的颜色。
     * @param 周期选择器未选中容器颜色 上午/下午切换按钮中未选中容器的颜色。
     * @param 周期选择器选中内容颜色 上午/下午切换按钮中所选中内容的颜色。
     * @param 周期选择器未选中内容颜色 上午/下午切换按钮中未选中内容的颜色。
     * @param 时间选择器选中容器颜色 用于切换小时和分钟显示按钮的选中容器的颜色。
     * @param 时间选择器未选中容器颜色 用于切换小时和分钟显示按钮的未选中容器的颜色。
     * @param 时间选择器选中内容颜色 用于切换小时和分钟显示按钮的选中内容的颜色。
     * @param 时间选择器未选中内容颜色 用于切换小时和分钟显示按钮的未选中内容的颜色。
     */
    @Composable
    fun 颜色集(
        时钟表盘颜色: Color = Color.Unspecified,
        时钟表盘选中内容颜色: Color = Color.Unspecified,
        时钟表盘未选中内容颜色: Color = Color.Unspecified,
        选择器颜色: Color = Color.Unspecified,
        容器颜色: Color = Color.Unspecified,
        周期选择器边框颜色: Color = Color.Unspecified,
        周期选择器选中容器颜色: Color = Color.Unspecified,
        周期选择器未选中容器颜色: Color = Color.Unspecified,
        周期选择器选中内容颜色: Color = Color.Unspecified,
        周期选择器未选中内容颜色: Color = Color.Unspecified,
        时间选择器选中容器颜色: Color = Color.Unspecified,
        时间选择器未选中容器颜色: Color = Color.Unspecified,
        时间选择器选中内容颜色: Color = Color.Unspecified,
        时间选择器未选中内容颜色: Color = Color.Unspecified,
    ) =
        TimePickerDefaults.colors(
            clockDialColor = 时钟表盘颜色,
            clockDialSelectedContentColor = 时钟表盘选中内容颜色,
            clockDialUnselectedContentColor = 时钟表盘未选中内容颜色,
            selectorColor = 选择器颜色,
            containerColor = 容器颜色,
            periodSelectorBorderColor = 周期选择器边框颜色,
            periodSelectorSelectedContainerColor = 周期选择器选中容器颜色,
            periodSelectorUnselectedContainerColor = 周期选择器未选中容器颜色,
            periodSelectorSelectedContentColor = 周期选择器选中内容颜色,
            periodSelectorUnselectedContentColor = 周期选择器未选中内容颜色,
            timeSelectorSelectedContainerColor = 时间选择器选中容器颜色,
            timeSelectorUnselectedContainerColor = 时间选择器未选中容器颜色,
            timeSelectorSelectedContentColor = 时间选择器选中内容颜色,
            timeSelectorUnselectedContentColor = 时间选择器未选中内容颜色,
        )

    /** 默认布局类型，使用屏幕尺寸来选择合适的布局。 */
    @ReadOnlyComposable
    @Composable
    fun 布局类型(): TimePickerLayoutType = TimePickerDefaults.layoutType()

}


/**
 * 表示 [TimePicker] 在不同状态下所使用的颜色。
 *
 * @param 时钟表盘颜色 时钟表盘的颜色。
 * @param 时钟表盘选中内容颜色 时钟表盘上的数字在被选中或与选择器重叠时的颜色。
 * @param 时钟表盘未选中内容颜色 时钟表盘上的数字在未选中时的颜色。
 * @param 选择器颜色 时钟表盘选择器的颜色。
 * @param 容器颜色 时间选择器的容器颜色。
 * @param 周期选择器边框颜色 上午/下午切换按钮边框所使用的颜色。
 * @param 周期选择器选中容器颜色 上午/下午切换按钮中所选中容器的颜色。
 * @param 周期选择器未选中容器颜色 上午/下午切换按钮中未选中容器的颜色。
 * @param 周期选择器选中内容颜色 上午/下午切换按钮中所选中内容的颜色。
 * @param 周期选择器未选中内容颜色 上午/下午切换按钮中未选中内容的颜色。
 * @param 时间选择器选中容器颜色 用于切换小时和分钟显示按钮的选中容器的颜色。
 * @param 时间选择器未选中容器颜色 用于切换小时和分钟显示按钮的未选中容器的颜色。
 * @param 时间选择器选中内容颜色 用于切换小时和分钟显示按钮的选中内容的颜色。
 * @param 时间选择器未选中内容颜色 用于切换小时和分钟显示按钮的未选中内容的颜色。
 * @constructor 使用任意颜色创建实例。有关遵循 Material 规范的默认实现，请参见 [TimePickerDefaults.colors]。
 */
@ExperimentalMaterial3Api
fun 时间选择器颜色集(
    时钟表盘颜色: Color,
    选择器颜色: Color,
    容器颜色: Color,
    周期选择器边框颜色: Color,
    时钟表盘选中内容颜色: Color,
    时钟表盘未选中内容颜色: Color,
    周期选择器选中容器颜色: Color,
    周期选择器未选中容器颜色: Color,
    周期选择器选中内容颜色: Color,
    周期选择器未选中内容颜色: Color,
    时间选择器选中容器颜色: Color,
    时间选择器未选中容器颜色: Color,
    时间选择器选中内容颜色: Color,
    时间选择器未选中内容颜色: Color,
) {
    TimePickerColors(
        clockDialColor = 时钟表盘颜色,
        selectorColor = 选择器颜色,
        containerColor = 容器颜色,
        periodSelectorBorderColor = 周期选择器边框颜色,
        clockDialSelectedContentColor = 时钟表盘选中内容颜色,
        clockDialUnselectedContentColor = 时钟表盘未选中内容颜色,
        periodSelectorSelectedContainerColor = 周期选择器选中容器颜色,
        periodSelectorUnselectedContainerColor = 周期选择器未选中容器颜色,
        periodSelectorSelectedContentColor = 周期选择器选中内容颜色,
        periodSelectorUnselectedContentColor = 周期选择器未选中内容颜色,
        timeSelectorSelectedContainerColor = 时间选择器选中容器颜色,
        timeSelectorUnselectedContainerColor = 时间选择器未选中容器颜色,
        timeSelectorSelectedContentColor = 时间选择器选中内容颜色,
        timeSelectorUnselectedContentColor = 时间选择器未选中内容颜色,
    )
}

/** 返回此 TimePickerColors 的副本，可选择性地覆盖某些值。这里使用 Color.Unspecified 表示"使用源值"。*/
@ExperimentalMaterial3Api
fun TimePickerColors.复制(
    时钟表盘颜色: Color = this.containerColor,
    选择器颜色: Color = this.selectorColor,
    容器颜色: Color = this.containerColor,
    周期选择器边框颜色: Color = this.periodSelectorBorderColor,
    时钟表盘选中内容颜色: Color = this.clockDialSelectedContentColor,
    时钟表盘未选中内容颜色: Color = this.clockDialUnselectedContentColor,
    周期选择器选中容器颜色: Color = this.periodSelectorSelectedContainerColor,
    周期选择器未选中容器颜色: Color = this.periodSelectorUnselectedContainerColor,
    周期选择器选中内容颜色: Color = this.periodSelectorSelectedContentColor,
    周期选择器未选中内容颜色: Color = this.periodSelectorUnselectedContentColor,
    时间选择器选中容器颜色: Color = this.timeSelectorSelectedContainerColor,
    时间选择器未选中容器颜色: Color = this.timeSelectorUnselectedContainerColor,
    时间选择器选中内容颜色: Color = this.timeSelectorSelectedContentColor,
    时间选择器未选中内容颜色: Color = this.timeSelectorUnselectedContentColor,
) =
    this.copy(
        clockDialColor = 时钟表盘颜色,
        selectorColor = 选择器颜色,
        containerColor = 容器颜色,
        periodSelectorBorderColor = 周期选择器边框颜色,
        clockDialSelectedContentColor = 时钟表盘选中内容颜色,
        clockDialUnselectedContentColor = 时钟表盘未选中内容颜色,
        periodSelectorSelectedContainerColor = 周期选择器选中容器颜色,
        periodSelectorUnselectedContainerColor = 周期选择器未选中容器颜色,
        periodSelectorSelectedContentColor = 周期选择器选中内容颜色,
        periodSelectorUnselectedContentColor = 周期选择器未选中内容颜色,
        timeSelectorSelectedContainerColor = 时间选择器选中容器颜色,
        timeSelectorUnselectedContainerColor = 时间选择器未选中容器颜色,
        timeSelectorSelectedContentColor = 时间选择器选中内容颜色,
        timeSelectorUnselectedContentColor = 时间选择器未选中内容颜色,
    )


/**
 * 创建一个在重组和配置变更之间被记住的 [TimePickerState]，用于时间选择器。
 *
 * @param 初始小时 此状态的初始小时数，启动时将在时间选择器中显示。范围为 0 到 23。
 * @param 初始分钟 此状态的初始分钟数，启动时将在时间选择器中显示。范围为 0 到 59。
 * @param 是否24小时制 此时间选择器的格式。false 表示带有上午/下午切换按钮的 12 小时制，true 表示不带切换按钮的 24 小时制。默认遵循系统设置。
 */
@Composable
@ExperimentalMaterial3Api
fun 记住时间选择器状态(
    初始小时: Int = 0,
    初始分钟: Int = 0,
    是否24小时制: Boolean = is24HourFormat,
): TimePickerState =
    rememberTimePickerState(
        initialHour = 初始小时,
        initialMinute = 初始分钟,
        is24Hour = 是否24小时制
    )


/** 表示时间选择器布局的不同配置。 */
@Immutable
object 时间选择器布局类型{

    /** 以水平布局显示时间选择器。应在横屏模式下使用。 */
    val 水平 = TimePickerLayoutType.Horizontal

    /** 以垂直布局显示时间选择器。应在竖屏模式下使用。 */
    val 垂直 = TimePickerLayoutType.Vertical

}


private const val MaxHourValue = 23

private const val MaxMinuteValue = 59

/**
 * 一个可提升的状态对象，用于观察时间选择器的状态。它保存当前值，并允许直接设置这些值。
 *
 * @see rememberTimePickerState 用于构造默认实现。
 */
interface 时间选择器状态 { // TimePickerState

    /** 当前选中的分钟数（0-59）。 */
    @get:IntRange(from = 0, to = 59) @setparam:IntRange(from = 0, to = 59)
    var 分钟: Int

    /** 当前选中的小时数（0-23）。 */
    @get:IntRange(from = 0, to = 23) @setparam:IntRange(from = 0, to = 23)
    var 小时: Int

    /** 小时的输入值。UI 应绑定到此值。默认实现会验证新值，如果有效则更新 [小时]。*/
    @get:IntRange(from = 0)
    var 小时输入: Int
        get() = 小时
        set(value) {
            if (value in 0..MaxHourValue) {
                小时 = value
            }
        }

    /** 分钟的原始输入值。UI 应绑定到此值。默认实现会验证新值，如果有效则更新 [分钟]。*/
    @get:IntRange(from = 0)
    var 分钟输入: Int
        get() = 分钟
        set(value) {
            if (value in 0..MaxMinuteValue) {
                分钟 = value
            }
        }

    /** 指示时间选择器是否使用 24 小时制（true）或带有上午/下午的 12 小时制（false）。*/
    var 是否24小时制: Boolean

    /** 指定用户当前正在主动选择小时还是分钟组件。 */
    var 选择: TimePickerSelectionMode

}

//===========================================================

/** 当前选中的分钟数（0-59）。 */
@get:IntRange(from = 0, to = 59) @setparam:IntRange(from = 0, to = 59)
var TimePickerState.分钟: Int
    get() = this.minute
    set(value) {
        this.minute = value
    }

/** 当前选中的小时数（0-23）。 */
@get:IntRange(from = 0, to = 23) @setparam:IntRange(from = 0, to = 23)
var TimePickerState.小时: Int
    get() = this.hour
    set(value) {
        this.hour = value
    }


/** 小时的输入值。UI 应绑定到此值。默认实现会验证新值，如果有效则更新 [小时]。*/
@get:IntRange(from = 0)
var TimePickerState.小时输入: Int
    get() = this.hourInput
    set(value) {
        this.hourInput = value
    }

/** 分钟的原始输入值。UI 应绑定到此值。默认实现会验证新值，如果有效则更新 [分钟]。*/
@get:IntRange(from = 0)
var TimePickerState.分钟输入: Int
    get() = this.minuteInput
    set(value) {
        this.minuteInput = value
    }

/** 指示时间选择器是否使用 24 小时制（true）或带有上午/下午的 12 小时制（false）。*/
var TimePickerState.是否24小时制: Boolean
    get() = this.is24hour
    set(value) {
        this.is24hour = value
    }

/** 指定用户当前正在主动选择小时还是分钟组件。 */
var TimePickerState.选择: TimePickerSelectionMode
    get() = this.selection
    set(value) {
        this.selection = value
    }

//===========================================================


/** 指示所选时间是否属于从中午 12 点（含）到午夜 12 点（不含）的时段。*/
val TimePickerState.是否下午: Boolean
    get() = this.isPm

/** 如果当前 hourInput 表示有效的小时数（0-23），则为 true。 */
val TimePickerState.是否小时输入有效: Boolean
    get() = this.isHourInputValid

/** 如果当前 `minuteInput` 表示有效的分钟数（0-59），则为 `true`。 */
val TimePickerState.是否分钟输入有效: Boolean
    get() = this.isMinuteInputValid

/**  如果时间输入值有效，则为 `true`。 */
val TimePickerState.是否输入有效: Boolean
    get() = this.isInputValid

/**
 * [TimePickerState] 默认实现的工厂函数，在大多数情况下应使用 [rememberTimePickerState]。
 *
 * @param 初始小时 此状态的初始小时数，启动时将在时间选择器中显示。范围为 0 到 23。
 * @param 初始分钟 此状态的初始分钟数，启动时将在时间选择器中显示。范围为 0 到 59。
 * @param 是否24小时制 此时间选择器的格式。`false` 表示带有上午/下午切换按钮的 12 小时制，`true` 表示不带切换按钮的 24 小时制。默认遵循系统设置。
 */
@ExperimentalMaterial3Api
fun 时间选择器状态(
    初始小时: Int,
    初始分钟: Int,
    是否24小时制: Boolean
): TimePickerState =
    TimePickerState(
        initialHour = 初始小时,
        initialMinute = 初始分钟,
        is24Hour = 是否24小时制
    )


/** 时间选择器的选择模式 */
@ExperimentalMaterial3Api
object 时间选择器选择模式{

    val 小时 = TimePickerSelectionMode.Hour

    val 分钟 = TimePickerSelectionMode.Minute

}

