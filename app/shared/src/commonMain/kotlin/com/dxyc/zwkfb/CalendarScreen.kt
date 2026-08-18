package com.dxyc.zwkfb

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.*
import kotlin.time.Clock

/**
 * Compose Multiplatform 日历组件（带农历）
 * 全平台兼容：Android / iOS / Desktop / Web
 */
@Composable
fun LunarCalendarScreen(
    modifier: Modifier = Modifier,
    initialSelectedDate: LocalDate? = null,
    onDateSelected: ((LocalDate) -> Unit)? = null
) {
    val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    var currentYearMonth by remember { mutableStateOf(today.toYearMonth()) }
    var selectedDate by remember { mutableStateOf(initialSelectedDate ?: today) }

    Column(
        modifier = modifier//.padding(16.dp)
    ) {
        // 头部：年月 + 切换按钮 + 今日按钮
        CalendarHeader(
            yearMonth = currentYearMonth,
            selectedDate = selectedDate,
            onPreviousMonth = { currentYearMonth = currentYearMonth.minusMonths(1) },
            onNextMonth = { currentYearMonth = currentYearMonth.plusMonths(1) },
            onTodayClick = {
                selectedDate = today
                currentYearMonth = today.toYearMonth()
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 星期标题
        WeekDayHeader()

        Spacer(modifier = Modifier.height(4.dp))

        // 日期网格
        CalendarGrid(
            yearMonth = currentYearMonth,
            today = today,
            selectedDate = selectedDate,
            onDateClick = { date ->
                selectedDate = date
                onDateSelected?.invoke(date)
            }
        )
    }
}

@Composable
private fun CalendarHeader(
    yearMonth: YearMonth,
    selectedDate: LocalDate,
    onPreviousMonth: () -> Unit,
    onNextMonth: () -> Unit,
    onTodayClick: () -> Unit
) {
    // 计算该月大致中间的日期，用于显示农历年份
    val sampleDate = LocalDate(yearMonth.year, yearMonth.month, 15)
    val lunar = LunarCalendar.solarToLunar(sampleDate.year, sampleDate.monthNumber, sampleDate.dayOfMonth)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onPreviousMonth) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "上一月",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "${yearMonth.year}年${yearMonth.month.toChinese()}",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "${lunar.ganZhiYear()}年 · ${lunar.zodiac()}年",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            // 今日按钮
            Text(
                text = "今",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .clickable(onClick = onTodayClick)
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.width(4.dp))

            IconButton(onClick = onNextMonth) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "下一月",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun WeekDayHeader() {
    val weekDays = listOf("日", "一", "二", "三", "四", "五", "六")
    Row(modifier = Modifier.fillMaxWidth()) {
        weekDays.forEach { day ->
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = day,
                    style = MaterialTheme.typography.labelMedium,
                    color = if (day == "日") Color(0xFFE53935) else MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
private fun CalendarGrid(
    yearMonth: YearMonth,
    today: LocalDate,
    selectedDate: LocalDate,
    onDateClick: (LocalDate) -> Unit
) {
    val days = remember(yearMonth) { generateCalendarDays(yearMonth) }

    Column {
        days.chunked(7).forEach { week ->
            Row(modifier = Modifier.fillMaxWidth()) {
                week.forEach { calendarDay ->
                    DayCell(
                        calendarDay = calendarDay,
                        isToday = calendarDay.date == today,
                        isSelected = calendarDay.date == selectedDate,
                        isCurrentMonth = calendarDay.isCurrentMonth,
                        modifier = Modifier.weight(1f),
                        onClick = { onDateClick(calendarDay.date) }
                    )
                }
            }
        }
    }
}

@Composable
private fun DayCell(
    calendarDay: CalendarDay,
    isToday: Boolean,
    isSelected: Boolean,
    isCurrentMonth: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val date = calendarDay.date
    val lunar = remember(date) {
        LunarCalendar.solarToLunar(date.year, date.monthNumber, date.dayOfMonth)
    }

    // 农历显示逻辑：初一显示月份名，否则显示日期名
    val lunarText = when {
        lunar.day == 1 -> lunar.monthName()
        else -> lunar.dayName()
    }

    val isWeekend = date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY

    // 今天且选中 → 实心；今天未选中 → 轮廓；其他选中 → 浅色背景
    val isTodaySelected = isToday && isSelected
    val isTodayUnselected = isToday && !isSelected

    val solarColor = when {
        !isCurrentMonth -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.35f)
        isTodaySelected -> MaterialTheme.colorScheme.onPrimary
        isTodayUnselected -> MaterialTheme.colorScheme.primary
        isSelected -> MaterialTheme.colorScheme.primary
        isWeekend -> Color(0xFFE53935)
        else -> MaterialTheme.colorScheme.onSurface
    }
    val lunarColor = when {
        !isCurrentMonth -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.25f)
        isTodaySelected -> MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.9f)
        isTodayUnselected -> MaterialTheme.colorScheme.primary
        isSelected -> MaterialTheme.colorScheme.primary
        lunar.day == 1 -> Color(0xFFFB8C00)
        else -> MaterialTheme.colorScheme.onSurfaceVariant
    }

    val backgroundColor = when {
        isTodaySelected -> MaterialTheme.colorScheme.primary
        isSelected -> MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
        else -> Color.Transparent
    }

    val borderModifier = if (isTodayUnselected) {
        Modifier.border(
            width = 1.5.dp,
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(8.dp)
        )
    } else {
        Modifier
    }

    Box(
        modifier = modifier
            .aspectRatio(1f) // 0.85f
            .padding(2.dp)
            .clip(RoundedCornerShape(8.dp))
            .then(borderModifier)
            .background(backgroundColor)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "${date.dayOfMonth}",
                fontSize = 16.sp,
                fontWeight = if (isToday || isSelected) FontWeight.Bold else FontWeight.Normal,
                color = solarColor,
                textAlign = TextAlign.Center
            )
            Text(
                text = lunarText,
                fontSize = 10.sp,
                color = lunarColor,
                textAlign = TextAlign.Center,
                lineHeight = 12.sp
            )
        }
    }
}

// ==================== 数据模型与工具 ====================

data class CalendarDay(
    val date: LocalDate,
    val isCurrentMonth: Boolean
)

/**
 * 生成某月日历所需的所有日期（包括前后月填充）
 */
private fun generateCalendarDays(yearMonth: YearMonth): List<CalendarDay> {
    val firstDayOfMonth = LocalDate(yearMonth.year, yearMonth.month, 1)
    // 计算该月第一天是星期几（0=周日, 1=周一...）
    val firstDayWeekday = firstDayOfMonth.dayOfWeek.isoDayNumber % 7

    // 该月天数
    val daysInMonth = yearMonth.month.length(yearMonth.year.isLeap())

    val result = mutableListOf<CalendarDay>()

    // 前月填充
    if (firstDayWeekday > 0) {
        val prevMonth = yearMonth.minusMonths(1)
        val daysInPrevMonth = prevMonth.month.length(prevMonth.year.isLeap())
        val startDay = daysInPrevMonth - firstDayWeekday + 1
        for (d in startDay..daysInPrevMonth) {
            result.add(CalendarDay(LocalDate(prevMonth.year, prevMonth.month, d), isCurrentMonth = false))
        }
    }

    // 当月
    for (d in 1..daysInMonth) {
        result.add(CalendarDay(LocalDate(yearMonth.year, yearMonth.month, d), isCurrentMonth = true))
    }

    // 后月填充，补齐到 42 格（6行）或 35 格（5行）
    val remaining = (7 - result.size % 7) % 7
    if (remaining > 0) {
        val nextMonth = yearMonth.plusMonths(1)
        for (d in 1..remaining) {
            result.add(CalendarDay(LocalDate(nextMonth.year, nextMonth.month, d), isCurrentMonth = false))
        }
    }

    return result
}

// ==================== YearMonth 扩展 ====================

private fun LocalDate.toYearMonth(): YearMonth = YearMonth(this.year, this.month)

private data class YearMonth(val year: Int, val month: Month) {
    fun minusMonths(n: Int): YearMonth {
        var newYear = year
        var newMonthValue = month.number - n
        while (newMonthValue <= 0) {
            newYear--
            newMonthValue += 12
        }
        return YearMonth(newYear, Month(newMonthValue))
    }

    fun plusMonths(n: Int): YearMonth {
        var newYear = year
        var newMonthValue = month.number + n
        while (newMonthValue > 12) {
            newYear++
            newMonthValue -= 12
        }
        return YearMonth(newYear, Month(newMonthValue))
    }
}

private fun Int.isLeap(): Boolean {
    return (this % 4 == 0 && this % 100 != 0) || (this % 400 == 0)
}

private fun Month.length(leapYear: Boolean): Int = when (this) {
    Month.FEBRUARY -> if (leapYear) 29 else 28
    Month.APRIL, Month.JUNE, Month.SEPTEMBER, Month.NOVEMBER -> 30
    else -> 31
}

/**
 * Month 转中文月份名称
 */
private fun Month.toChinese(): String = when (this) {
    Month.JANUARY -> "1月"
    Month.FEBRUARY -> "2月"
    Month.MARCH -> "3月"
    Month.APRIL -> "4月"
    Month.MAY -> "5月"
    Month.JUNE -> "6月"
    Month.JULY -> "7月"
    Month.AUGUST -> "8月"
    Month.SEPTEMBER -> "9月"
    Month.OCTOBER -> "10月"
    Month.NOVEMBER -> "11月"
    Month.DECEMBER -> "12月"
    else -> "${this.number}月"
}