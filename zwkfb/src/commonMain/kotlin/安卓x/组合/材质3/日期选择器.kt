package 安卓x.组合.材质3

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design date picker](https://m3.material.io/components/date-pickers/overview)
 *
 * 日期选择器让用户选择一个日期，并且最好将其嵌入到对话框中。请参阅 [DatePickerDialog]。
 *
 * 默认情况下，日期选择器通过日历界面让你选择日期。不过，它也允许切换到日期输入模式，以便通过键盘上的数字手动输入日期。
 *
 * ![Date picker image](https://developer.android.com/images/reference/androidx/compose/material3/date-picker.png)
 *
 * @param 状态 日期选择器的状态。请参阅 [rememberDatePickerState]。
 * @param 修饰符 要应用于此日期选择器的 [Modifier]
 * @param 日期格式化器 一个为日期显示提供格式化骨架的 [DatePickerFormatter]
 * @param 颜色集 用于解析此日期选择器在不同状态下所使用颜色的 [DatePickerColors]。请参阅 [DatePickerDefaults.colors]。
 * @param 标题 要在日期选择器中显示的标题
 * @param 大标题 要在日期选择器中显示的大标题
 * @param 显示模式切换 指示此日期选择器是否应显示一个模式切换操作，将其转换为日期输入模式
 * @param 焦点请求 一个焦点请求器，用于在日期选择器处于输入模式时将焦点设置到文本字段。如果希望文本字段不自动获取焦点，请传入 null。
 */
@Suppress("ComposableNaming")
@Composable
fun 日期选择器(
    状态: DatePickerState,
    修饰符: Modifier = Modifier,
    日期格式化器: DatePickerFormatter = remember { DatePickerDefaults.dateFormatter() },
    颜色集: DatePickerColors = DatePickerDefaults.colors(),
    标题: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerTitle(
            displayMode = 状态.displayMode,
            modifier = Modifier.padding(DatePickerTitlePadding),
            contentColor = 颜色集.titleContentColor,
        )
    },
    大标题: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerHeadline(
            selectedDateMillis = 状态.selectedDateMillis,
            displayMode = 状态.displayMode,
            dateFormatter = 日期格式化器,
            modifier = Modifier.padding(DatePickerHeadlinePadding),
            contentColor = 颜色集.headlineContentColor,
        )
    },
    显示模式切换: Boolean = true,
    焦点请求: FocusRequester? = remember { FocusRequester() },
) =
    DatePicker(
        state = 状态,
        modifier = 修饰符,
        dateFormatter = 日期格式化器,
        colors = 颜色集,
        title = 标题,
        headline = 大标题,
        showModeToggle = 显示模式切换,
        focusRequester = 焦点请求,
    )


/** 一个可被提升的状态对象，用于观察日期选择器的状态。请参阅 [rememberDatePickerState]。*/
@Stable
interface 日期选择器状态 { // DatePickerState

    /**
     * 一个时间戳，表示所选日期当天起始时刻的UTC 毫秒数，自纪元起算。
     *
     * @throws IllegalArgumentException 以防设置的值所对应的时间戳不在 [年份范围] 范围内。
     */
    @get:Suppress("AutoBoxing") var 已选择日期毫秒: Long? // selectedDateMillis

    /**
     * 一个时间戳，表示当前显示的月份首日的UTC 毫秒数，自纪元起算。
     *
     * @throws IllegalArgumentException 以防设置的值所对应的时间戳不在 [年份范围] 范围内。
     */
    var 已显示月份毫秒: Long // displayedMonthMillis

    /** 一个表示当前 UI 模式的 [DisplayMode]（即选择器模式或输入模式）。 */
    var 显示模式: DisplayMode // displayMode

    /** 一个 [IntRange]，用于限定日期选择器可选择年份的范围。 */
    val 年份范围: IntRange // yearRange

    /**
     * 一个 [SelectableDates]，用于检查某个日期是否允许被选择。
     *
     * 如果某个日期不允许被选择，它在界面中将显示为禁用状态。
     */
    val 可选日期: SelectableDates // selectableDates

    /** 一个语言环境，用于格式化日期、确定输入格式、星期名称显示等。*/
    val 语言环境: CalendarLocale // locale

}

//=================================================================================

/**
 * 一个时间戳，表示所选日期当天起始时刻的UTC 毫秒数，自纪元起算。
 *
 * @throws IllegalArgumentException 以防设置的值所对应的时间戳不在 [年份范围] 范围内。
 */
@get:Suppress("AutoBoxing") var DatePickerState.已选择日期毫秒: Long?
    get() = this.selectedDateMillis
    set(value) {
        this.selectedDateMillis = value
    }

/**
 * 一个时间戳，表示当前显示的月份首日的UTC 毫秒数，自纪元起算。
 *
 * @throws IllegalArgumentException 以防设置的值所对应的时间戳不在 [年份范围] 范围内。
 */
var DatePickerState.已显示月份毫秒: Long
    get() = this.displayedMonthMillis
    set(value) {
        this.displayedMonthMillis = value
    }

/** 一个表示当前 UI 模式的 [DisplayMode]（即选择器模式或输入模式）。 */
var DatePickerState.显示模式: DisplayMode
    get() = this.displayMode
    set(value) {
        this.displayMode = value
    }

/** 一个 [IntRange]，用于限定日期选择器可选择年份的范围。 */
val DatePickerState.年份范围: IntRange
    get() = this.yearRange

/**
 * 一个 [SelectableDates]，用于检查某个日期是否允许被选择。
 *
 * 如果某个日期不允许被选择，它在界面中将显示为禁用状态。
 */
val DatePickerState.可选日期: SelectableDates
    get() = this.selectableDates

/** 一个语言环境，用于格式化日期、确定输入格式、星期名称显示等。*/
val DatePickerState.语言环境: CalendarLocale
    get() = this.locale

//=================================================================================

/** 一个用于控制日期选择器界面中可选日期和年份的接口。 */
@Stable
interface 可选日期 { // SelectableDates

    /** 如果代表 [utc时间毫秒] 的日期项应在界面中启用以供选择，则返回 true。*/
    fun 是否可选日期(utc时间毫秒: Long) = true // isSelectableDate

    /** 如果给定的 [年] 应在界面中启用以供选择，则返回 true。当某一年份被定义为不可选时，该年份中的所有日期也将不可选。*/
    fun 是否可选年份(年: Int) = true // isSelectableYear

}

//=================================================================================

/** 如果代表 [utc时间毫秒] 的日期项应在界面中启用以供选择，则返回 true。*/
fun SelectableDates.是否可选日期(utc时间毫秒: Long) = this.isSelectableDate(utcTimeMillis = utc时间毫秒)

/** 如果给定的 [年] 应在界面中启用以供选择，则返回 true。当某一年份被定义为不可选时，该年份中的所有日期也将不可选。*/
fun SelectableDates.是否可选年份(年: Int) = this.isSelectableYear(year = 年)

//=================================================================================

/** 一个由 [日期选择器] 使用的日期格式化器接口。 */
interface 日期选择器格式化器 { // DatePickerFormatter

    /**
     * 将给定的 [月份毫秒时间戳] 格式化为月和年的字符串表示形式（例如：2023年1月）。
     *
     * @param 月份毫秒时间戳 自纪元起的 UTC 毫秒时间戳，表示该月份
     * @param 语言环境 一个用于格式化月份和年份的 [CalendarLocale]
     */
    fun 格式化月份年份(@Suppress("AutoBoxing") 月份毫秒时间戳: Long?, 语言环境: CalendarLocale): String?

    /**
     * 将给定的 [日期毫秒时间戳] 格式化为日期的字符串表示形式（例如：2021年3月27日）。
     *
     * @param 日期毫秒时间戳 自纪元起的 UTC 毫秒时间戳，表示该日期
     * @param 语言环境 一个用于格式化日期的 [CalendarLocale]
     * @param 用于内容描述 指示所请求的格式化是用于内容描述。在这些情况下，输出可能包含更具描述性的措辞，以便传递给屏幕阅读器。
     */
    fun 格式化日期(
        @Suppress("AutoBoxing") 日期毫秒时间戳: Long?,
        语言环境: CalendarLocale,
        用于内容描述: Boolean = false,
    ): String?

}

//=================================================================================

/**
 * 将给定的 [月份毫秒时间戳] 格式化为月和年的字符串表示形式（例如：2023年1月）。
 *
 * @param 月份毫秒时间戳 自纪元起的 UTC 毫秒时间戳，表示该月份
 * @param 语言环境 一个用于格式化月份和年份的 [CalendarLocale]
 */
fun DatePickerFormatter.格式化月份年份(@Suppress("AutoBoxing") 月份毫秒时间戳: Long?, 语言环境: CalendarLocale): String? =
    this.formatMonthYear(monthMillis = 月份毫秒时间戳, locale = 语言环境)

/**
 * 将给定的 [日期毫秒时间戳] 格式化为日期的字符串表示形式（例如：2021年3月27日）。
 *
 * @param 日期毫秒时间戳 自纪元起的 UTC 毫秒时间戳，表示该日期
 * @param 语言环境 一个用于格式化日期的 [CalendarLocale]
 * @param 用于内容描述 指示所请求的格式化是用于内容描述。在这些情况下，输出可能包含更具描述性的措辞，以便传递给屏幕阅读器。
 */
fun DatePickerFormatter.格式化日期(
    @Suppress("AutoBoxing") 日期毫秒时间戳: Long?,
    语言环境: CalendarLocale,
    用于内容描述: Boolean = false,
): String? =
    this.formatDate(
        dateMillis = 日期毫秒时间戳, locale = 语言环境, forContentDescription = 用于内容描述
    )

//=================================================================================


/** 表示日期选择器可以处于的不同模式。 */
object 显示模式{

    /** 日期选择器模式 */
    val 选择器 = DisplayMode.Picker

    /** 日期文本输入模式 */
    val 输入 = DisplayMode.Input

}


/**
 * 为 [日期选择器] 创建一个在重组过程中被记住的 [DatePickerState]。
 *
 * 若要在组合作用域之外创建日期选择器状态，请参阅 [DatePickerState] 函数。
 *
 * @param 初始选中日期毫秒时间戳 自纪元起的 UTC 毫秒时间戳，表示日期的初始选中状态。传入 null 表示未选中任何日期。
 * @param 初始显示月份毫秒时间戳 自纪元起的 UTC 毫秒时间戳，表示要展示给用户的初始月份。默认情况下，如果提供了
 * `初始选中日期毫秒时间戳`，则初始显示的月份为所选日期所在的月份。否则，如果传入 null，则显示当前月份。
 * @param 年份范围 一个 [IntRange]，用于限定日期选择器可选择年份的范围
 * @param 初始显示模式 此状态初始持有的 [显示模式]
 * @param 可选日期 一个 [SelectableDates]，用于检查某个日期是否允许被选择。如果某个日期不允许被选择，它在界面中将显示为禁用状态。
 */
@Composable
fun 记住日期选择器状态(
    @Suppress("AutoBoxing") 初始选中日期毫秒时间戳: Long? = null,
    @Suppress("AutoBoxing") 初始显示月份毫秒时间戳: Long? = 初始选中日期毫秒时间戳,
    年份范围: IntRange = DatePickerDefaults.YearRange,
    初始显示模式: DisplayMode = DisplayMode.Picker,
    可选日期: SelectableDates = DatePickerDefaults.AllDates,
): DatePickerState =
    rememberDatePickerState(
        initialSelectedDateMillis = 初始选中日期毫秒时间戳,
        initialDisplayedMonthMillis = 初始显示月份毫秒时间戳,
        yearRange = 年份范围,
        initialDisplayMode = 初始显示模式,
        selectableDates = 可选日期,
    )


/**
 * 创建一个 [DatePickerState]。
 *
 * 在大多数情况下，建议在组合作用域内使用 [rememberDatePickerState]。
 *
 * 请注意，如果你提供的 [语言环境] 与平台默认语言环境不同，你可能需要确保选择器的标题和大标题被正确本地化。以下示例展示了一种可行的方式，
 * 即通过应用 LocalContext 和 LocaleConfiguration 的局部组合来实现。
 *
 * @param 语言环境 一个 [CalendarLocale]，用于格式化日期、确定输入格式、显示星期名称、确定每周第一天等。请注意，如果提供的 [CalendarLocale]
 * 与平台默认语言环境不同，你可能需要确保选择器的标题和大标题被正确本地化，并且在某些情况下，你可能需要应用 RTL 布局。
 * @param 初始选中日期毫秒时间戳 自纪元起的 UTC 毫秒时间戳，表示日期的初始选中状态。传入 null 表示未选中任何日期。请注意，
 * 状态中的 [DatePickerState.selectedDateMillis] 返回的时间戳代表当天的起始时刻，这可能与你传入的 initialSelectedDateMillis 不同。
 * @param 初始显示月份毫秒时间戳 自纪元起的 UTC 毫秒时间戳，表示要展示给用户的初始月份。如果传入 null，则显示当前月份。
 * @param 年份范围 一个 [IntRange]，用于限定日期选择器可选择年份的范围
 * @param 初始显示模式 此状态初始持有的 [DisplayMode]
 * @param 可选日期 一个 [SelectableDates]，用于检查某个日期是否允许被选择。如果某个日期不允许被选择，它在界面中将显示为禁用状态。
 * @throws [IllegalArgumentException] 如果初始选中日期或显示月份所对应的年份超出了年份范围。
 * @see rememberDatePickerState
 */
fun 日期选择器状态(
    语言环境: CalendarLocale,
    @Suppress("AutoBoxing") 初始选中日期毫秒时间戳: Long? = null,
    @Suppress("AutoBoxing") 初始显示月份毫秒时间戳: Long? = 初始选中日期毫秒时间戳,
    年份范围: IntRange = DatePickerDefaults.YearRange,
    初始显示模式: DisplayMode = DisplayMode.Picker,
    可选日期: SelectableDates = DatePickerDefaults.AllDates,
): DatePickerState =
    DatePickerState(
        locale = 语言环境,
        initialSelectedDateMillis = 初始选中日期毫秒时间戳,
        initialDisplayedMonthMillis = 初始显示月份毫秒时间戳,
        yearRange = 年份范围,
        initialDisplayMode = 初始显示模式,
        selectableDates = 可选日期,
    )


/** 包含 [日期选择器] 使用的默认值。 */
@Stable
object 日期选择器默认值 { // DatePickerDefaults

    /** 创建一个 [DatePickerColors]，它会根据 Material 规范在提供的颜色之间进行动画过渡。*/
    @Composable fun 颜色集() = DatePickerDefaults.colors()

    /**
     * 创建一个 [DatePickerColors]，它会根据 Material 规范在提供的颜色之间进行动画过渡。
     *
     * @param 容器颜色 日期选择器背景所使用的颜色
     * @param 标题内容颜色 日期选择器标题所使用的颜色
     * @param 大标题内容颜色 日期选择器大标题所使用的颜色
     * @param 工作日内容颜色 星期名称文字所使用的颜色
     * @param 子标题内容颜色 在 DateRangePicker 中显示月份时出现的月份和年份子标题标签所使用的颜色。
     * @param 导航内容颜色 在 DatePicker 中显示时，年份选择菜单按钮和月份箭头导航所使用的内容颜色。
     * @param 年份内容颜色 年份列表项内容所使用的颜色
     * @param 禁用年份内容颜色 禁用年份列表项内容所使用的颜色
     * @param 当前年份内容颜色 选择年份时，当前年份内容所使用的颜色
     * @param 已选择年份内容颜色 选中年份列表项内容所使用的颜色
     * @param 禁用已选择年份内容颜色 禁用且选中的年份列表项内容所使用的颜色
     * @param 已选择年份容器颜色 选中年份列表项容器所使用的颜色
     * @param 禁用已选择年份容器颜色 禁用且选中的年份列表项容器所使用的颜色
     * @param 日期内容颜色 日期数字内容所使用的颜色
     * @param 禁用日期内容颜色 禁用日期内容所使用的颜色
     * @param 已选择日期内容颜色 选中日期内容所使用的颜色
     * @param 禁用已选择日期内容颜色 禁用且选中的日期内容所使用的颜色
     * @param 已选择日期容器颜色 选中日期容器所使用的颜色
     * @param 禁用已选择日期容器颜色 禁用且选中的日期容器所使用的颜色
     * @param 今天内容颜色 标记当前日期的那一天所使用的颜色
     * @param 今天日期边框颜色 标记当前日期的那一天的边框所使用的颜色
     * @param 日期选中范围内容颜色 日期范围选择内所包含日期内容所使用的颜色
     * @param 日期选中范围容器颜色 日期范围选择内各日期的容器所使用的颜色
     * @param 分隔线颜色 日期选择器中分隔线所使用的颜色
     * @param 日期文本字段颜色集 在 [DisplayMode.Input]（输入模式）下，日期文本框所使用的 [TextFieldColors]
     * 默认值。请参阅 [OutlinedTextFieldDefaults.colors]。
     */
    @Composable
    fun 颜色集(
        容器颜色: Color = Color.Unspecified,
        标题内容颜色: Color = Color.Unspecified,
        大标题内容颜色: Color = Color.Unspecified,
        工作日内容颜色: Color = Color.Unspecified,
        子标题内容颜色: Color = Color.Unspecified,
        导航内容颜色: Color = Color.Unspecified,
        年份内容颜色: Color = Color.Unspecified,
        禁用年份内容颜色: Color = Color.Unspecified,
        当前年份内容颜色: Color = Color.Unspecified,
        已选择年份内容颜色: Color = Color.Unspecified,
        禁用已选择年份内容颜色: Color = Color.Unspecified,
        已选择年份容器颜色: Color = Color.Unspecified,
        禁用已选择年份容器颜色: Color = Color.Unspecified,
        日期内容颜色: Color = Color.Unspecified,
        禁用日期内容颜色: Color = Color.Unspecified,
        已选择日期内容颜色: Color = Color.Unspecified,
        禁用已选择日期内容颜色: Color = Color.Unspecified,
        已选择日期容器颜色: Color = Color.Unspecified,
        禁用已选择日期容器颜色: Color = Color.Unspecified,
        今天内容颜色: Color = Color.Unspecified,
        今天日期边框颜色: Color = Color.Unspecified,
        日期选中范围内容颜色: Color = Color.Unspecified,
        日期选中范围容器颜色: Color = Color.Unspecified,
        分隔线颜色: Color = Color.Unspecified,
        日期文本字段颜色集: TextFieldColors? = null,
    ): DatePickerColors =
        DatePickerDefaults.colors(
            containerColor = 容器颜色,
            titleContentColor = 标题内容颜色,
            headlineContentColor = 大标题内容颜色,
            weekdayContentColor = 工作日内容颜色,
            subheadContentColor = 子标题内容颜色,
            navigationContentColor = 导航内容颜色,
            yearContentColor = 年份内容颜色,
            disabledYearContentColor = 禁用年份内容颜色,
            currentYearContentColor = 当前年份内容颜色,
            selectedYearContentColor = 已选择年份内容颜色,
            disabledSelectedYearContentColor = 禁用已选择年份内容颜色,
            selectedYearContainerColor = 已选择年份容器颜色,
            disabledSelectedYearContainerColor = 禁用已选择年份容器颜色,
            dayContentColor = 日期内容颜色,
            disabledDayContentColor = 禁用日期内容颜色,
            selectedDayContentColor = 已选择日期内容颜色,
            disabledSelectedDayContentColor = 禁用已选择日期内容颜色,
            selectedDayContainerColor = 已选择日期容器颜色,
            disabledSelectedDayContainerColor = 禁用已选择日期容器颜色,
            todayContentColor = 今天内容颜色,
            todayDateBorderColor = 今天日期边框颜色,
            dayInSelectionRangeContentColor = 日期选中范围内容颜色,
            dayInSelectionRangeContainerColor = 日期选中范围容器颜色,
            dividerColor = 分隔线颜色,
            dateTextFieldColors = 日期文本字段颜色集,
        )


    /**
     * 返回一个 [DatePickerFormatter]。
     *
     * 日期格式化器将应用给定骨架和语言环境的最佳本地化形式。骨架与 Unicode UTS #35 模式类似，并使用相同的格式字符。
     *
     * 其中一个区别是顺序无关紧要。例如，"MMMMd" 在 en_US（美国英语）语言环境下将返回 "MMMM d"，但在 de_CH（瑞士德语）
     * 语言环境下将返回 "d. MMMM"。
     *
     * @param 年份选择骨架 一个日期格式骨架，用于格式化日期选择器的年份选择菜单按钮（例如："2021年3月"）。
     * @param 已选择日期骨架 一个日期格式骨架，用于格式化选中的日期（例如："2021年3月27日"）。
     * @param 已选择日期描述骨架 一个日期格式骨架，用于格式化选中的日期，以作为屏幕阅读器的内容描述（例如："2021年3月27日，星期六"）。
     */
    fun 日期格式化器(
        年份选择骨架: String = DatePickerDefaults.YearMonthSkeleton,
        已选择日期骨架: String = DatePickerDefaults.YearAbbrMonthDaySkeleton,
        已选择日期描述骨架: String = DatePickerDefaults.YearMonthWeekdayDaySkeleton,
    ): DatePickerFormatter =
        DatePickerDefaults.dateFormatter(
            yearSelectionSkeleton = 年份选择骨架,
            selectedDateSkeleton = 已选择日期骨架,
            selectedDateDescriptionSkeleton = 已选择日期描述骨架,
        )

    /**
     * 一个默认的日期选择器标题可组合项。
     *
     * @param 显示模式 当前的 [显示模式]
     * @param 修饰符 要应用于标题的 [Modifier]
     * @param 内容颜色 此标题的内容颜色
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 日期选择器标题(
        显示模式: DisplayMode,
        修饰符: Modifier = Modifier,
        内容颜色: Color = DatePickerDefaults.colors().titleContentColor,
    ) =
        DatePickerDefaults.DatePickerTitle(
            displayMode = 显示模式,
            modifier = 修饰符,
            contentColor = 内容颜色,
        )

    /**
     * 一个默认的日期选择器大标题可组合项，当未选择日期时显示默认的大标题文本，当已选择日期时显示实际的日期字符串。
     *
     * @param 已选择日期毫秒 一个时间戳，表示所选日期当天起始时刻的 UTC 毫秒数，自纪元起算
     * @param 显示模式 当前的 [DisplayMode]
     * @param 日期格式化器 一个 [DatePickerFormatter]
     * @param 修饰符 要应用于大标题的 [Modifier]
     * @param 内容颜色 此大标题的内容颜色
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 日期选择器大标题(
        @Suppress("AutoBoxing") 已选择日期毫秒: Long?,
        显示模式: DisplayMode,
        日期格式化器: DatePickerFormatter,
        修饰符: Modifier = Modifier,
        内容颜色: Color = DatePickerDefaults.colors().headlineContentColor,
    ) =
        DatePickerDefaults.DatePickerHeadline(
            selectedDateMillis = 已选择日期毫秒,
            displayMode = 显示模式,
            dateFormatter = 日期格式化器,
            modifier = 修饰符,
            contentColor = 内容颜色,
        )

    /** 日期选择器对话框的年份范围。 */
    val 年份范围: IntRange = DatePickerDefaults.YearRange

    /** [DatePickerDialog] 使用的默认色调高度。 */
    val 色调阴影: Dp = DatePickerDefaults.TonalElevation

    /** 日期选择器对话框的默认形状。 */
    val 形状: Shape
        @Composable get() = DatePickerDefaults.shape

    /** 一个默认的 [SelectableDates]，允许选择所有日期。 */
    val 所有日期: SelectableDates = DatePickerDefaults.AllDates

    /** 一个日期格式骨架，用于格式化日期选择器的年份选择菜单按钮（例如："2021年3月"）。*/
    const val 年月骨架: String = DatePickerDefaults.YearMonthSkeleton

    /** 一个日期格式骨架，用于格式化选中的日期（例如："2021年3月27日"）。 */
    const val 年缩写月日骨架: String = DatePickerDefaults.YearAbbrMonthDaySkeleton

    /** 一个日期格式骨架，用于格式化选中的日期，以作为屏幕阅读器的内容描述（例如："2021年3月27日，星期六"）。*/
    const val 年月星期日骨架: String = DatePickerDefaults.YearMonthWeekdayDaySkeleton
}


/**
 * 表示日期选择器使用的颜色。
 *
 * @param 容器颜色 日期选择器背景所使用的颜色
 * @param 标题内容颜色 日期选择器标题所使用的颜色
 * @param 大标题内容颜色 日期选择器大标题所使用的颜色
 * @param 工作日内容颜色 星期名称文字所使用的颜色
 * @param 子标题内容颜色 在 DateRangePicker 中显示月份时出现的月份和年份子标题标签所使用的颜色。
 * @param 导航内容颜色 在 DatePicker 中显示时，年份选择菜单按钮和月份箭头导航所使用的内容颜色。
 * @param 年份内容颜色 年份列表项内容所使用的颜色
 * @param 禁用年份内容颜色 禁用年份列表项内容所使用的颜色
 * @param 当前年份内容颜色 选择年份时，当前年份内容所使用的颜色
 * @param 已选择年份内容颜色 选中年份列表项内容所使用的颜色
 * @param 禁用已选择年份内容颜色 禁用且选中的年份列表项内容所使用的颜色
 * @param 已选择年份容器颜色 选中年份列表项容器所使用的颜色
 * @param 禁用已选择年份容器颜色 禁用且选中的年份列表项容器所使用的颜色
 * @param 日期内容颜色 日期数字内容所使用的颜色
 * @param 禁用日期内容颜色 禁用日期内容所使用的颜色
 * @param 已选择日期内容颜色 选中日期内容所使用的颜色
 * @param 禁用已选择日期内容颜色 禁用且选中的日期内容所使用的颜色
 * @param 已选择日期容器颜色 选中日期容器所使用的颜色
 * @param 禁用已选择日期容器颜色 禁用且选中的日期容器所使用的颜色
 * @param 今天内容颜色 标记当前日期的那一天所使用的颜色
 * @param 今天日期边框颜色 标记当前日期的那一天的边框所使用的颜色
 * @param 日期选中范围内容颜色 日期范围选择内所包含日期内容所使用的颜色
 * @param 日期选中范围容器颜色 日期范围选择内各日期的容器所使用的颜色
 * @param 分隔线颜色 日期选择器中分隔线所使用的颜色
 * @param 日期文本字段颜色集 在 [DisplayMode.Input]（输入模式）下，日期文本框所使用的 [TextFieldColors]
 * @constructor 创建具有任意颜色的实例，如需遵循 Material 规范的默认实现，请参阅 [DatePickerDefaults.colors]。
 */
fun 日期选择器颜色集( // DatePickerColors
    容器颜色: Color,
    标题内容颜色: Color,
    大标题内容颜色: Color,
    工作日内容颜色: Color,
    子标题内容颜色: Color,
    导航内容颜色: Color,
    年份内容颜色: Color,
    禁用年份内容颜色: Color,
    当前年份内容颜色: Color,
    已选择年份内容颜色: Color,
    禁用已选择年份内容颜色: Color,
    已选择年份容器颜色: Color,
    禁用已选择年份容器颜色: Color,
    日期内容颜色: Color,
    禁用日期内容颜色: Color,
    已选择日期内容颜色: Color,
    禁用已选择日期内容颜色: Color,
    已选择日期容器颜色: Color,
    禁用已选择日期容器颜色: Color,
    今天内容颜色: Color,
    今天日期边框颜色: Color,
    日期选中范围内容颜色: Color,
    日期选中范围容器颜色: Color,
    分隔线颜色: Color,
    日期文本字段颜色集: TextFieldColors,
) =
    DatePickerColors(
        containerColor = 容器颜色,
        titleContentColor = 标题内容颜色,
        headlineContentColor = 大标题内容颜色,
        weekdayContentColor = 工作日内容颜色,
        subheadContentColor = 子标题内容颜色,
        navigationContentColor = 导航内容颜色,
        yearContentColor = 年份内容颜色,
        disabledYearContentColor = 禁用年份内容颜色,
        currentYearContentColor = 当前年份内容颜色,
        selectedYearContentColor = 已选择年份内容颜色,
        disabledSelectedYearContentColor = 禁用已选择年份内容颜色,
        selectedYearContainerColor = 已选择年份容器颜色,
        disabledSelectedYearContainerColor = 禁用已选择年份容器颜色,
        dayContentColor = 日期内容颜色,
        disabledDayContentColor = 禁用日期内容颜色,
        selectedDayContentColor = 已选择日期内容颜色,
        disabledSelectedDayContentColor = 禁用已选择日期内容颜色,
        selectedDayContainerColor = 已选择日期容器颜色,
        disabledSelectedDayContainerColor = 禁用已选择日期容器颜色,
        todayContentColor = 今天内容颜色,
        todayDateBorderColor = 今天日期边框颜色,
        dayInSelectionRangeContainerColor = 日期选中范围内容颜色,
        dayInSelectionRangeContentColor = 日期选中范围容器颜色,
        dividerColor = 分隔线颜色,
        dateTextFieldColors = 日期文本字段颜色集,
    )


/**
 * 返回此 DatePickerColors 的副本，可选择性地覆盖部分值。其中 Color.Unspecified 表示"使用源值"；
 * 对于 dateTextFieldColors 则使用 null 表示"使用源值"。
 */
fun DatePickerColors.复制(
    容器颜色: Color = this.containerColor,
    标题内容颜色: Color = this.titleContentColor,
    大标题内容颜色: Color = this.headlineContentColor,
    工作日内容颜色: Color = this.weekdayContentColor,
    子标题内容颜色: Color = this.subheadContentColor,
    导航内容颜色: Color = this.navigationContentColor,
    年份内容颜色: Color = this.yearContentColor,
    禁用年份内容颜色: Color = this.disabledYearContentColor,
    当前年份内容颜色: Color = this.currentYearContentColor,
    已选择年份内容颜色: Color = this.selectedYearContentColor,
    禁用已选择年份内容颜色: Color = this.disabledSelectedYearContentColor,
    已选择年份容器颜色: Color = this.selectedYearContainerColor,
    禁用已选择年份容器颜色: Color = this.disabledSelectedYearContainerColor,
    日期内容颜色: Color = this.dayContentColor,
    禁用日期内容颜色: Color = this.disabledDayContentColor,
    已选择日期内容颜色: Color = this.selectedDayContentColor,
    禁用已选择日期内容颜色: Color = this.disabledSelectedDayContentColor,
    已选择日期容器颜色: Color = this.selectedDayContainerColor,
    禁用已选择日期容器颜色: Color = this.disabledSelectedDayContainerColor,
    今天内容颜色: Color = this.todayContentColor,
    今天日期边框颜色: Color = this.todayDateBorderColor,
    日期选中范围内容颜色: Color = this.dayInSelectionRangeContainerColor,
    日期选中范围容器颜色: Color = this.dayInSelectionRangeContentColor,
    分隔线颜色: Color = this.dividerColor,
    日期文本字段颜色集: TextFieldColors? = this.dateTextFieldColors,
) =
    this.copy(
        containerColor = 容器颜色,
        titleContentColor = 标题内容颜色,
        headlineContentColor = 大标题内容颜色,
        weekdayContentColor = 工作日内容颜色,
        subheadContentColor = 子标题内容颜色,
        navigationContentColor = 导航内容颜色,
        yearContentColor = 年份内容颜色,
        disabledYearContentColor = 禁用年份内容颜色,
        currentYearContentColor = 当前年份内容颜色,
        selectedYearContentColor = 已选择年份内容颜色,
        disabledSelectedYearContentColor = 禁用已选择年份内容颜色,
        selectedYearContainerColor = 已选择年份容器颜色,
        disabledSelectedYearContainerColor = 禁用已选择年份容器颜色,
        dayContentColor = 日期内容颜色,
        disabledDayContentColor = 禁用日期内容颜色,
        selectedDayContentColor = 已选择日期内容颜色,
        disabledSelectedDayContentColor = 禁用已选择日期内容颜色,
        selectedDayContainerColor = 已选择日期容器颜色,
        disabledSelectedDayContainerColor = 禁用已选择日期容器颜色,
        todayContentColor = 今天内容颜色,
        todayDateBorderColor = 今天日期边框颜色,
        dayInSelectionRangeContainerColor = 日期选中范围内容颜色,
        dayInSelectionRangeContentColor = 日期选中范围容器颜色,
        dividerColor = 分隔线颜色,
        dateTextFieldColors = 日期文本字段颜色集,
    )
//=================================================================================

val DatePickerColors.容器颜色: Color
    get() = this.containerColor

val DatePickerColors.标题内容颜色: Color
    get() = this.titleContentColor

val DatePickerColors.大标题内容颜色: Color
    get() = this.headlineContentColor

val DatePickerColors.工作日内容颜色: Color
    get() = this.weekdayContentColor

val DatePickerColors.子标题内容颜色: Color
    get() = this.subheadContentColor

val DatePickerColors.导航内容颜色: Color
    get() = this.navigationContentColor

val DatePickerColors.年份内容颜色: Color
    get() = this.yearContentColor

val DatePickerColors.禁用年份内容颜色: Color
    get() = this.disabledYearContentColor

val DatePickerColors.当前年份内容颜色: Color
    get() = this.currentYearContentColor

val DatePickerColors.已选择年份内容颜色: Color
    get() = this.selectedYearContentColor

val DatePickerColors.禁用已选择年份内容颜色: Color
    get() = this.disabledSelectedYearContentColor

val DatePickerColors.已选择年份容器颜色: Color
    get() = this.selectedYearContainerColor

val DatePickerColors.禁用已选择年份容器颜色: Color
    get() = this.disabledSelectedYearContainerColor

val DatePickerColors.日期内容颜色: Color
    get() = this.dayContentColor

val DatePickerColors.禁用日期内容颜色: Color
    get() = this.disabledDayContentColor

val DatePickerColors.已选择日期内容颜色: Color
    get() = this.selectedDayContentColor

val DatePickerColors.禁用已选择日期内容颜色: Color
    get() = this.disabledSelectedDayContentColor

val DatePickerColors.已选择日期容器颜色: Color
    get() = this.selectedDayContainerColor

val DatePickerColors.禁用已选择日期容器颜色: Color
    get() = this.disabledSelectedDayContainerColor

val DatePickerColors.今天内容颜色: Color
    get() = this.todayContentColor

val DatePickerColors.今天日期边框颜色: Color
    get() = this.todayDateBorderColor

val DatePickerColors.日期选中范围内容颜色: Color
    get() = this.dayInSelectionRangeContainerColor

val DatePickerColors.日期选中范围容器颜色: Color
    get() = this.dayInSelectionRangeContentColor

val DatePickerColors.分隔线颜色: Color
    get() = this.dividerColor

val DatePickerColors.日期文本字段颜色集: TextFieldColors
    get() = this.dateTextFieldColors


//=================================================================================


private val DatePickerTitlePadding = PaddingValues(start = 24.dp, end = 12.dp, top = 16.dp)
private val DatePickerHeadlinePadding = PaddingValues(start = 24.dp, end = 12.dp, bottom = 12.dp)
