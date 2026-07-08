package com.dxyc.zwkfb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * 通用滚轮选择器
 * @param items 选项列表
 * @param selectedIndex 当前选中索引
 * @param onSelected 选中回调
 * @param itemHeight 每一项高度
 * @param visibleItemsCount 可视区域显示几项（建议奇数）
 */
@Composable
fun WheelPicker(
    items: List<String>,
    selectedIndex: Int,
    onSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    itemHeight: Dp = 44.dp,
    visibleItemsCount: Int = 5,
) {
    val halfVisible = visibleItemsCount / 2
    // 防止越界
    val safeIndex = remember(items, selectedIndex) {
        if (items.isEmpty()) 0 else selectedIndex.coerceIn(0, items.lastIndex)
    }

    val listState = rememberLazyListState(initialFirstVisibleItemIndex = safeIndex)
    val flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)

    // 计算当前滚动到中心的是哪一项
    val centerIndex by remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val viewportCenter = layoutInfo.viewportStartOffset + layoutInfo.viewportSize.height / 2
            layoutInfo.visibleItemsInfo.minByOrNull {
                kotlin.math.abs((it.offset + it.size / 2) - viewportCenter)
            }?.index ?: safeIndex
        }
    }

    // 中心项变化时通知外部
    LaunchedEffect(centerIndex) {
        if (centerIndex in items.indices) {
            onSelected(centerIndex)
        }
    }

    // 外部传入的 selectedIndex 变化时，自动滚动到对应位置
    LaunchedEffect(safeIndex) {
        if (safeIndex != centerIndex && safeIndex in items.indices) {
            listState.animateScrollToItem(safeIndex)
        }
    }

    Box(modifier = modifier.height(itemHeight * visibleItemsCount)) {
        LazyColumn(
            state = listState,
            flingBehavior = flingBehavior,
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = itemHeight * halfVisible),
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(items) { index, item ->
                val distance = kotlin.math.abs(index - centerIndex)
                // 距离中心越远，透明度和缩放越小，营造 3D 滚轮感
                val alpha = (1f - distance / (halfVisible + 1f)).coerceIn(0.3f, 1f)
                val scale = (1f - distance / (halfVisible + 1f) * 0.2f).coerceIn(0.8f, 1f)

                Box(
                    modifier = Modifier
                        .height(itemHeight)
                        .fillMaxWidth()
                        .alpha(alpha)
                        .scale(scale),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = item,
                        style = if (index == centerIndex)
                            MaterialTheme.typography.titleMedium
                        else
                            MaterialTheme.typography.bodyMedium,
                        color = if (index == centerIndex)
                            MaterialTheme.colorScheme.primary
                        else
                            LocalContentColor.current.copy(alpha = 0.5f),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // 中间选中区域的上下分隔线
        val lineColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .offset(y = itemHeight * halfVisible)
                .background(lineColor)
                .align(Alignment.TopCenter)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .offset(y = itemHeight * (halfVisible + 1))
                .background(lineColor)
                .align(Alignment.TopCenter)
        )

        // 顶部渐变遮罩（淡出效果）
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeight * halfVisible)
                .align(Alignment.TopCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.background,
                            Color.Transparent
                        )
                    )
                )
        )
        // 底部渐变遮罩
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeight * halfVisible)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
        )
    }
}

/**
 * 日期滚轮选择器（年月日）
 * @param startDate 初始日期
 * @param onDateSelected 日期选中回调
 * @param yearRange 年份范围
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateWheelPicker(
    modifier: Modifier = Modifier,
    startDate: LocalDate = LocalDate.now(),
    onDateSelected: (LocalDate) -> Unit,
    yearRange: IntRange = 1900..2100,
) {
    var selectedDate by remember { mutableStateOf(startDate) }

    val years = remember(yearRange) { yearRange.map { "${it}年" } }
    val months = remember { (1..12).map { "${it}月" } }

    // 根据当前选中年月动态计算天数
    val daysInMonth by remember(selectedDate) {
        derivedStateOf { selectedDate.lengthOfMonth() }
    }
    val days = remember(daysInMonth) { (1..daysInMonth).map { "${it}日" } }

    val yearIndex = selectedDate.year - yearRange.first
    val monthIndex = selectedDate.monthValue - 1
    val dayIndex = (selectedDate.dayOfMonth - 1).coerceIn(0, days.lastIndex.coerceAtLeast(0))

    // 当月份变化导致日期越界时（如 1月31日 切到 2月），自动修正日期
    LaunchedEffect(daysInMonth) {
        if (selectedDate.dayOfMonth > daysInMonth) {
            val adjusted = selectedDate.withDayOfMonth(daysInMonth)
            selectedDate = adjusted
            onDateSelected(adjusted)
        }
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // 年
        WheelPicker(
            items = years,
            selectedIndex = yearIndex,
            onSelected = {
                val newDate = selectedDate.withYear(yearRange.first + it)
                selectedDate = newDate
                onDateSelected(newDate)
            },
            modifier = Modifier.weight(1f)
        )
        // 月
        WheelPicker(
            items = months,
            selectedIndex = monthIndex,
            onSelected = {
                val newDate = selectedDate.withMonth(it + 1)
                selectedDate = newDate
                onDateSelected(newDate)
            },
            modifier = Modifier.weight(1f)
        )
        // 日
        WheelPicker(
            items = days,
            selectedIndex = dayIndex,
            onSelected = {
                val newDate = selectedDate.withDayOfMonth(it + 1)
                selectedDate = newDate
                onDateSelected(newDate)
            },
            modifier = Modifier.weight(1f)
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DateWheelPickerPreview() {
    MaterialTheme {
        Surface {
            var date by remember { mutableStateOf(LocalDate.now()) }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                DateWheelPicker(
                    onDateSelected = { date = it }
                )
                Text(
                    text = "选中: ${date.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"))}",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}