package 安卓x.组合.材质3

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerDefaults
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * [Material Design date range picker](https://m3.material.io/components/date-pickers/overview)
 *
 * 日期范围选择器允许用户选择一个日期范围，并可嵌入到对话框中使用。
 *
 * ![Date range picker image](https://developer.android.com/images/reference/androidx/compose/material3/range-picker.png)
 *
 * @param 状态 日期范围选择器的状态。请参阅 [rememberDateRangePickerState]。
 * @param 修饰符 要应用于此日期范围选择器的 [Modifier]。
 * @param 日期格式化器 一个 [DatePickerFormatter]，用于提供日期显示的格式化模板。
 * @param 颜色集 用于解析此日期范围选择器在不同状态下所使用颜色的 [DatePickerColors]。请参阅 [DatePickerDefaults.colors]。
 * @param 标题 要在日期范围选择器中显示的标题。
 * @param 大标题 要在日期范围选择器中显示的大标题。
 * @param 显示模式切换 指示此 `日期范围选择器` 是否应显示模式切换操作，以将其转换为日期范围输入模式。
 * @param 焦点请求 当日期选择器处于输入模式时，用于聚焦文本框的焦点请求器。如果不需要自动聚焦文本框，请传入 null。
 */
@Suppress("ComposableNaming")
@Composable
fun 日期范围选择器(
    状态: DateRangePickerState,
    修饰符: Modifier = Modifier,
    日期格式化器: DatePickerFormatter = remember { DatePickerDefaults.dateFormatter() },
    颜色集: DatePickerColors = DatePickerDefaults.colors(),
    标题: (@Composable () -> Unit)? = {
        DateRangePickerDefaults.DateRangePickerTitle(
            displayMode = 状态.displayMode,
            modifier = Modifier.padding(DateRangePickerTitlePadding),
            contentColor = 颜色集.titleContentColor,
        )
    },
    大标题: (@Composable () -> Unit)? = {
        DateRangePickerDefaults.DateRangePickerHeadline(
            selectedStartDateMillis = 状态.selectedStartDateMillis,
            selectedEndDateMillis = 状态.selectedEndDateMillis,
            displayMode = 状态.displayMode,
            日期格式化器,
            modifier = Modifier.padding(DateRangePickerHeadlinePadding),
            contentColor = 颜色集.headlineContentColor,
        )
    },
    显示模式切换: Boolean = true,
    焦点请求: FocusRequester? = remember { FocusRequester() },
) =
    DateRangePicker(
        state = 状态,
        modifier = 修饰符,
        dateFormatter = 日期格式化器,
        colors = 颜色集,
        title = 标题,
        headline = 大标题,
        showModeToggle = 显示模式切换,
        focusRequester = 焦点请求,
    )


/** 一个可提升的状态对象，用于观察日期范围选择器的状态。请参阅 [rememberDateRangePickerState]。*/
@Stable
interface 日期范围选择器状态 { // DateRangePickerState

    /**
     * 一个时间戳，表示所选开始日期的当天开始时刻，以纪元以来的 UTC 毫秒为单位。
     *
     * @see [置选择] 用于同时设置此值与 [已选择结束日期毫秒]。
     */
    @get:Suppress("AutoBoxing") val 已选择开始日期毫秒: Long? // selectedStartDateMillis

    /**
     * 一个时间戳，表示所选结束日期的当天开始时刻，以纪元以来的 UTC 毫秒为单位。
     *
     * @see [置选择] 用于同时设置此值与 [已选择开始日期毫秒]。
     */
    @get:Suppress("AutoBoxing") val 已选择结束日期毫秒: Long? // selectedEndDateMillis

    /**
     * 一个时间戳，表示当前显示月份的开始日期，以纪元以来的 UTC 毫秒为单位。
     *
     * @throws IllegalArgumentException 如果设置的值不在 [年份范围] 范围内。
     */
    var 显示月份毫秒: Long // displayedMonthMillis

    /** 一个 [DisplayMode]，表示当前的界面模式（即选择器模式或输入模式）。 */
    var 显示模式: DisplayMode // displayMode

    /** 一个 [IntRange]，用于限定日期选择器可选的年份范围。*/
    val 年份范围: IntRange // yearRange

    /**
     * 一个 [SelectableDates]，用于检查某个日期是否允许被选择。
     *
     * 如果某个日期不允许被选择，它将在界面中显示为禁用状态。
     */
    val 可选择日期: SelectableDates // selectableDates

    /** 一个用于格式化日期、确定输入格式、星期等的语言环境。*/
    val 语言环境: CalendarLocale // locale

    /**
     * 设置开始和结束选择日期。
     *
     * 该函数要求日期必须在状态所指定的年份范围内，且开始日期必须早于或等于结束日期。此外，如果提供了结束日期（即不为 null），
     * 则也必须提供开始日期。在其他任何情况下，都会抛出 [IllegalArgumentException]。
     *
     * @param 开始日期毫秒 一个从纪元开始的 UTC 毫秒时间戳，表示开始日期的选择。提供 null 表示无选择。
     * @param 结束日期毫秒 一个从纪元开始的 UTC 毫秒时间戳，表示结束日期的选择。提供 null 表示无选择。
     * @throws IllegalArgumentException 如果给定的时间戳不符合上述指定的预期值。
     */
    fun 置选择(
        @Suppress("AutoBoxing") 开始日期毫秒: Long?,
        @Suppress("AutoBoxing") 结束日期毫秒: Long?,
    ) // setSelection

}

//=========================================================================

/**
 * 一个时间戳，表示所选开始日期的当天开始时刻，以纪元以来的 UTC 毫秒为单位。
 *
 * @see [置选择] 用于同时设置此值与 [已选择结束日期毫秒]。
 */
@get:Suppress("AutoBoxing") val DateRangePickerState.已选择开始日期毫秒: Long?
    get() = this.selectedStartDateMillis

/**
 * 一个时间戳，表示所选结束日期的当天开始时刻，以纪元以来的 UTC 毫秒为单位。
 *
 * @see [置选择] 用于同时设置此值与 [已选择开始日期毫秒]。
 */
@get:Suppress("AutoBoxing") val DateRangePickerState.已选择结束日期毫秒: Long?
    get() = this.selectedEndDateMillis

/**
 * 一个时间戳，表示当前显示月份的开始日期，以纪元以来的 UTC 毫秒为单位。
 *
 * @throws IllegalArgumentException 如果设置的值不在 [年份范围] 范围内。
 */
var DateRangePickerState.显示月份毫秒: Long
    get() = this.displayedMonthMillis
    set(value) {
        this.displayedMonthMillis = value
    }

/** 一个 [DisplayMode]，表示当前的界面模式（即选择器模式或输入模式）。 */
var DateRangePickerState.显示模式: DisplayMode
    get() = this.displayMode
    set(value) {
        this.displayMode = value
    }

/** 一个 [IntRange]，用于限定日期选择器可选的年份范围。*/
val DateRangePickerState.年份范围: IntRange
    get() = this.yearRange

/**
 * 一个 [SelectableDates]，用于检查某个日期是否允许被选择。
 *
 * 如果某个日期不允许被选择，它将在界面中显示为禁用状态。
 */
val DateRangePickerState.可选择日期: SelectableDates
    get() = this.selectableDates

/** 一个用于格式化日期、确定输入格式、星期等的语言环境。*/
val DateRangePickerState.语言环境: CalendarLocale
    get() = this.locale

/**
 * 设置开始和结束选择日期。
 *
 * 该函数要求日期必须在状态所指定的年份范围内，且开始日期必须早于或等于结束日期。此外，如果提供了结束日期（即不为 null），
 * 则也必须提供开始日期。在其他任何情况下，都会抛出 [IllegalArgumentException]。
 *
 * @param 开始日期毫秒 一个从纪元开始的 UTC 毫秒时间戳，表示开始日期的选择。提供 null 表示无选择。
 * @param 结束日期毫秒 一个从纪元开始的 UTC 毫秒时间戳，表示结束日期的选择。提供 null 表示无选择。
 * @throws IllegalArgumentException 如果给定的时间戳不符合上述指定的预期值。
 */
fun DateRangePickerState.置选择(
    @Suppress("AutoBoxing") 开始日期毫秒: Long?,
    @Suppress("AutoBoxing") 结束日期毫秒: Long?,
) =
    this.setSelection(
        startDateMillis = 开始日期毫秒,
        endDateMillis = 结束日期毫秒,
    )

//=========================================================================

/**
 * 创建一个在组合之间保持记忆的 [DateRangePicker] 的 [DateRangePickerState]。
 *
 * 要在组合外部创建日期范围选择器状态，请参阅 DateRangePickerState 函数。
 *
 * @param 初始已选择开始日期毫秒 一个从纪元开始的 UTC 毫秒时间戳，表示开始日期的初始选择。提供 null 表示无选择。
 * @param 初始已选择结束日期毫秒 一个从纪元开始的 UTC 毫秒时间戳，表示结束日期的初始选择。提供 null 表示无选择。
 * @param 初始显示月份毫秒 一个从纪元开始的 UTC 毫秒时间戳，表示要展示给用户的初始月份。默认情况下，如果提供了
 * `初始已选择开始日期毫秒`，则初始显示的月份为所选日期的月份。否则，如果提供 null，则显示当前月份。
 * @param 年份范围 一个 [IntRange]，用于限定日期范围选择器可选的年份范围。
 * @param 初始显示模式 该状态将持有的初始 [DisplayMode]。
 * @param 可选择日期 一个 [SelectableDates]，用于检查某个日期是否允许被选择。如果某个日期不允许被选择，它将在界面中显示为禁用状态。
 */
@Composable
fun 记住日期范围选择器状态(
    @Suppress("AutoBoxing") 初始已选择开始日期毫秒: Long? = null,
    @Suppress("AutoBoxing") 初始已选择结束日期毫秒: Long? = null,
    @Suppress("AutoBoxing") 初始显示月份毫秒: Long? = 初始已选择开始日期毫秒,
    年份范围: IntRange = DatePickerDefaults.YearRange,
    初始显示模式: DisplayMode = DisplayMode.Picker,
    可选择日期: SelectableDates = DatePickerDefaults.AllDates,
): DateRangePickerState =
    rememberDateRangePickerState(
        initialSelectedStartDateMillis = 初始已选择开始日期毫秒,
        initialSelectedEndDateMillis = 初始已选择结束日期毫秒,
        initialDisplayedMonthMillis = 初始显示月份毫秒,
        yearRange = 年份范围,
        initialDisplayMode = 初始显示模式,
        selectableDates = 可选择日期,
    )


/**
 * 创建一个 [DateRangePickerState]。
 *
 * 在大多数情况下，建议您在组合中使用 [rememberDateRangePickerState]。
 *
 * 请注意，如果您提供的 [语言环境] 与默认的平台语言环境不同，您可能需要确保选择器的标题和标题栏已正确本地化。以下示例展示了一种
 * 可能的实现方式，即通过应用 LocalContext 和 LocaleConfiguration 的局部组合来实现。
 *
 * @param 语言环境 用于格式化日期、确定输入格式、显示星期、确定每周第一天等的 [CalendarLocale]。请注意，如果所提供的 [CalendarLocale]
 * 与平台的默认语言环境不同，您可能需要确保选择器的标题和标题栏已正确本地化，在某些情况下，您可能还需要应用 RTL 布局。
 * @param 初始已选择开始日期毫秒 一个从纪元开始的 UTC 毫秒时间戳，表示开始日期的初始选择。提供 null 表示无选择。
 * @param 初始已选择结束日期毫秒 一个从纪元开始的 UTC 毫秒时间戳，表示结束日期的初始选择。提供 null 表示无选择。
 * @param 初始显示月份毫秒 一个从纪元开始的 UTC 毫秒时间戳，表示要展示给用户的初始月份。默认情况下，如果提供了
 * `初始已选择开始日期毫秒`，则初始显示的月份为所选日期的月份。否则，如果提供 null，则显示当前月份。
 * @param 年份范围 一个 [IntRange]，用于限定日期选择器可选的年份范围。
 * @param 初始显示模式 该状态将持有的初始 [DisplayMode]。
 * @param 可选择日期 一个 [SelectableDates]，用于检查某个日期是否允许被选择。如果某个日期不允许被选择，它将在界面中显示为禁用状态。
 * @throws IllegalArgumentException 如果初始时间戳不在创建该状态时所指定的年份范围内，或者结束日期早于开始日期，
 * 或者提供了结束日期但未提供开始日期（例如开始日期为 null，而结束日期不为 null）。
 * @see rememberDateRangePickerState
 */
fun 日期范围选择器状态(
    语言环境: CalendarLocale,
    @Suppress("AutoBoxing") 初始已选择开始日期毫秒: Long? = null,
    @Suppress("AutoBoxing") 初始已选择结束日期毫秒: Long? = null,
    @Suppress("AutoBoxing") 初始显示月份毫秒: Long? = 初始已选择开始日期毫秒,
    年份范围: IntRange = DatePickerDefaults.YearRange,
    初始显示模式: DisplayMode = DisplayMode.Picker,
    可选择日期: SelectableDates = DatePickerDefaults.AllDates,
): DateRangePickerState =
    DateRangePickerState(
        locale = 语言环境,
        initialSelectedStartDateMillis = 初始已选择开始日期毫秒,
        initialSelectedEndDateMillis = 初始已选择结束日期毫秒,
        initialDisplayedMonthMillis = 初始显示月份毫秒,
        yearRange = 年份范围,
        initialDisplayMode = 初始显示模式,
        selectableDates = 可选择日期,
    )


/** 包含 [DateRangePicker] 所使用的默认值。 */
@Stable
object 日期范围选择器默认值 { // DateRangePickerDefaults

    /**
     * 一个默认的日期范围选择器标题可组合函数。
     *
     * @param 显示模式 当前的 [DisplayMode]
     * @param 修饰符 应用于标题的 [Modifier]。
     * @param 内容颜色 此标题的内容颜色
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 日期范围选择器标题(
        显示模式: DisplayMode,
        修饰符: Modifier = Modifier,
        内容颜色: Color = DatePickerDefaults.colors().titleContentColor,
    ) =
        DateRangePickerDefaults.DateRangePickerTitle(
            displayMode = 显示模式,
            modifier = 修饰符,
            contentColor = 内容颜色,
        )

    /**
     * 一个默认的日期选择器标题可组合函数 lambda，当没有选择日期时显示默认标题文本，当选择了日期时显示实际的日期字符串。
     *
     * @param 已选择开始日期毫秒数 一个时间戳，表示所选开始日期的当天开始时刻，以纪元以来的 UTC 毫秒为单位。
     * @param 已选择结束日期毫秒数 一个时间戳，表示所选结束日期的当天开始时刻，以纪元以来的 UTC 毫秒为单位。
     * @param 显示模式 当前的 [DisplayMode]
     * @param 日期格式化器 一个 [DatePickerFormatter]
     * @param 修饰符 应用于大标题的 [Modifier]。
     * @param 内容颜色 此大标题的内容颜色
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 日期范围选择器大标题(
        @Suppress("AutoBoxing") 已选择开始日期毫秒数: Long?,
        @Suppress("AutoBoxing") 已选择结束日期毫秒数: Long?,
        显示模式: DisplayMode,
        日期格式化器: DatePickerFormatter,
        修饰符: Modifier = Modifier,
        内容颜色: Color = DatePickerDefaults.colors().headlineContentColor,
    ) =
        DateRangePickerDefaults.DateRangePickerHeadline(
            selectedStartDateMillis = 已选择开始日期毫秒数,
            selectedEndDateMillis = 已选择结束日期毫秒数,
            displayMode = 显示模式,
            dateFormatter = 日期格式化器,
            modifier = 修饰符,
            contentColor = 内容颜色,
        )

}


private val DateRangePickerTitlePadding = PaddingValues(start = 64.dp, end = 12.dp)
private val DateRangePickerHeadlinePadding =
    PaddingValues(start = 64.dp, end = 12.dp, bottom = 12.dp)

