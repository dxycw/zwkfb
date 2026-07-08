package 安卓x.组合.材质3

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.TabIndicatorScope
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * [Material Design fixed primary tabs](https://m3.material.io/components/tabs/overview)
 *
 * 主选项卡（Primary tabs） 放置在顶部应用栏下方的内容面板顶部，用于展示主要的内容导航目的地。固定选项卡（Fixed tabs）
 * 会同时显示一组中的所有选项卡，最适合在相关内容之间快速切换的场景，例如在地图中切换不同的交通方式。要在固定选项卡之间导航，
 * 可以点击单个选项卡，或者在内容区域向左或向右滑动。
 *
 * `标签页行` 包含一行 [标签页]，并在当前选中的选项卡下方显示一个指示器。`标签页行` 将其选项卡沿整行均匀分布，每个选项卡占据相同的空间。
 * 如需不强制等宽、并允许滚动查看屏幕外选项卡的选项卡行，请参阅 [PrimaryScrollableTabRow]。
 *
 * 除了自定义选项卡外，您还可以提供一个自定义的 [指示器]，用于自定义为选项卡显示的指示器。[指示器] 将被放置以填充整个
 * `标签页行`，因此它应当在内部处理指示器的大小和定位，以匹配 [已选择标签页索引] 的变化。
 *
 * 您可能还希望使用自定义过渡动画，以便在指示器在选项卡之间切换时动态改变其外观，例如更改颜色或大小。[指示器] 堆叠在整个
 * `标签页行` 的上方，因此您只需提供一个自定义过渡动画，使其从 `标签页行` 的起始位置开始动画化指示器的偏移量。例如，请看以下示例，
 * 它使用过渡动画来动画化之前同一个 FancyIndicator 的偏移量、宽度和颜色，同时为运动方向上的指示器添加基于物理的"弹簧"效果
 *
 * @param 已选择标签页索引 当前选中选项卡的索引
 * @param 修饰符 应用于该选项卡行的 [Modifier]
 * @param 容器颜色 用于该选项卡行背景的颜色。使用 [Color.Transparent] 表示无背景色。
 * @param 内容颜色 该选项卡行内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容颜色；如果 [容器颜色]
 * 不是主题中的颜色，则默认为当前的 [LocalContentColor]。
 * @param 指示器 表示当前选中的是哪个选项卡的指示器。默认情况下，这将是 [TabRowDefaults.PrimaryIndicator]，
 * 使用 [TabRowDefaults.tabIndicatorOffset] 修饰符来动画化其位置。
 * @param 分隔线 显示在选项卡行底部的分隔线。它在选项卡行与其下方显示的内容之间提供一层分隔。
 * @param 标签页集 该选项卡行内的选项卡。通常应为多个 [标签页]。此 lambda 内的每个元素将被测量并沿整行均匀放置，每个元素占据相同的空间。
 */
@Suppress("ComposableNaming")
@Composable
fun 主标签页行(
    已选择标签页索引: Int,
    修饰符: Modifier = Modifier,
    容器颜色: Color = TabRowDefaults.primaryContainerColor,
    内容颜色: Color = TabRowDefaults.primaryContentColor,
    指示器: @Composable TabIndicatorScope.() -> Unit = {
        TabRowDefaults.PrimaryIndicator(
            modifier = Modifier.tabIndicatorOffset(已选择标签页索引, matchContentSize = true),
            width = Dp.Unspecified,
        )
    },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    标签页集: @Composable () -> Unit,
) =
    PrimaryTabRow(
        selectedTabIndex = 已选择标签页索引,
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        indicator = 指示器,
        divider = 分隔线,
        tabs = 标签页集,
    )


/**
 * [Material Design fixed secondary tabs](https://m3.material.io/components/tabs/overview)
 *
 * 二级标签页（Secondary tabs）用于在内容区域内进一步划分相关内容并建立层级关系。固定标签页（Fixed tabs）会同时显示一组中的所有标签页。
 * 要在固定标签页之间切换，点击单个标签页，或在内容区域向左或向右滑动。
 *
 * `标签页行` 包含一行 [标签页]，并在当前选中的标签页下方显示指示器。Fixed TabRow 将其标签页沿整行均匀分布，每个标签页占据相同大小的空间。
 * 如需使用不强制等宽、并允许滚动以查看屏幕外标签页的标签行，请参阅 [SecondaryScrollableTabRow]。
 *
 * @param 已选择标签页索引 当前选中的标签页的索引
 * @param 修饰符 要应用于此标签行的 [Modifier]
 * @param 容器颜色 用于此标签行背景的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此标签行内部内容的首选颜色。默认情况下，使用与 [容器颜色] 匹配的内容颜色；如果 [容器颜色]
 * 不是来自主题的颜色，则默认使用当前的 [LocalContentColor]。
 * @param 指示器 表示当前选中标签页的指示器。默认情况下，这将是一个 [TabRowDefaults.SecondaryIndicator]，
 * 使用 [TabRowDefaults.tabIndicatorOffset] 修饰符来动画化其位置。请注意，此指示器将被强制填充整个标签行，
 * 因此您应该使用 [TabRowDefaults.tabIndicatorOffset] 或类似方法来动画化在此空间内实际绘制的指示器，并提供从起始位置的偏移量。
 * @param 分隔线 显示在标签行底部的分隔线。它在标签行与下方显示的内容之间提供一层分隔。
 * @param 标签页集 此标签行内的标签页。通常这将是多个 [标签页]。此 lambda 内的每个元素都将被测量并沿整行均匀放置，每个元素占据相同大小的空间。
 */
@Suppress("ComposableNaming")
@Composable
fun 次标签页行(
    已选择标签页索引: Int,
    修饰符: Modifier = Modifier,
    容器颜色: Color = TabRowDefaults.secondaryContainerColor,
    内容颜色: Color = TabRowDefaults.secondaryContentColor,
    指示器: @Composable TabIndicatorScope.() -> Unit =
        @Composable {
            TabRowDefaults.SecondaryIndicator(
                Modifier.tabIndicatorOffset(已选择标签页索引, matchContentSize = false)
            )
        },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    标签页集: @Composable () -> Unit,
) =
    SecondaryTabRow(
        selectedTabIndex = 已选择标签页索引,
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        indicator = 指示器,
        divider = 分隔线,
        tabs = 标签页集,
    )


/**
 * [Material Design scrollable primary tabs](https://m3.material.io/components/tabs/overview)
 *
 * 主要标签页（Primary tabs）放置在内容窗格顶部、顶部应用栏的下方。它们显示主要的内容目的地。当一组标签页无法容纳在屏幕上时，
 * 请使用可滚动标签页。可滚动标签页可以使用更长的文本标签和更多的标签页数量。它们最适合用于触摸界面上的浏览。
 *
 * A可滚动标签行包含一行 [标签页]，并在当前选中的标签页下方显示指示器。可滚动标签行将其标签页从起始边缘偏移放置，并允许滚动到屏幕外的标签页。
 * 如需使用不允许滚动且均匀放置标签页的固定标签行，请参阅 [PrimaryTabRow]。
 *
 * @param 已选择标签页索引 当前选中的标签页的索引
 * @param 修饰符 要应用于此标签行的 [Modifier]
 * @param 滚动状态 此标签行的 [ScrollState]
 * @param 容器颜色 用于此标签行背景的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此标签行内部内容的首选颜色。默认情况下，使用与 [容器颜色] 匹配的内容颜色；
 * 如果 [containerColor] 不是来自主题的颜色，则默认使用当前的 [LocalContentColor]。
 * @param 边缘内边距 可滚动标签行的起始边缘和结束边缘与行内标签页之间的内边距。此内边距有助于提示用户该标签行可以滚动，
 * 这与 [TabRow] 不同。
 * @param 指示器 表示当前选中标签页的指示器。默认情况下，这将是一个 [TabRowDefaults.PrimaryIndicator]，
 * 使用 [TabRowDefaults.tabIndicatorOffset] 修饰符来动画化其位置。
 * @param 分隔线 显示在标签行底部的分隔线。它在标签行与下方显示的内容之间提供一层分隔。
 * @param 最小标签页宽度 此标签行中 [标签页] 的最小宽度，不受内容大小影响。
 * @param 标签页集 此标签行内的标签页。通常这将是多个 [标签页]。此 lambda 内的每个元素都将被测量并沿整行均匀放置，每个元素占据相同大小的空间。
 */
@Suppress("ComposableNaming")
@Composable
fun 主可滚动标签页行(
    已选择标签页索引: Int,
    修饰符: Modifier = Modifier,
    滚动状态: ScrollState = rememberScrollState(),
    容器颜色: Color = TabRowDefaults.primaryContainerColor,
    内容颜色: Color = TabRowDefaults.primaryContentColor,
    边缘内边距: Dp = TabRowDefaults.ScrollableTabRowEdgeStartPadding,
    指示器: @Composable TabIndicatorScope.() -> Unit =
        @Composable {
            TabRowDefaults.PrimaryIndicator(
                Modifier.tabIndicatorOffset(已选择标签页索引, matchContentSize = true),
                width = Dp.Unspecified,
            )
        },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    最小标签页宽度: Dp = TabRowDefaults.ScrollableTabRowMinTabWidth,
    标签页集: @Composable () -> Unit,
) =
    PrimaryScrollableTabRow(
        selectedTabIndex = 已选择标签页索引,
        modifier = 修饰符,
        scrollState = 滚动状态,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        edgePadding = 边缘内边距,
        indicator = 指示器,
        divider = 分隔线,
        minTabWidth = 最小标签页宽度,
        tabs = 标签页集,
    )


/**
 * [Material Design scrollable secondary tabs](https://m3.material.io/components/tabs/overview)
 *
 * Material Design 可滚动标签页。
 *
 * 二级标签页（Secondary tabs）用于在内容区域内进一步划分相关内容并建立层级关系。当一组标签页无法容纳在屏幕上时，请使用可滚动标签页。
 * 可滚动标签页可以使用更长的文本标签和更多的标签页数量。它们最适合用于触摸界面上的浏览。
 *
 * 可滚动标签行包含一行 [标签页]，并在当前选中的标签页下方显示指示器。可滚动标签行将其标签页从起始边缘偏移放置，并允许滚动到屏幕外的标签页。
 * 如需使用不允许滚动且均匀放置标签页的固定标签行，请参阅 [SecondaryTabRow]。
 *
 * @param 已选择标签页索引 当前选中的标签页的索引
 * @param 修饰符 要应用于此标签行的 [Modifier]
 * @param 滚动状态 此标签行的 [ScrollState]
 * @param 容器颜色 用于此标签行背景的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此标签行内部内容的首选颜色。默认情况下，使用与 [容器颜色] 匹配的内容颜色；如果 [容器颜色]
 * 不是来自主题的颜色，则默认使用当前的 [LocalContentColor]。
 * @param 边缘内边距 可滚动标签行的起始边缘和结束边缘与行内标签页之间的内边距。此内边距有助于提示用户该标签行可以滚动，这与 [标签页行] 不同。
 * @param 指示器 表示当前选中标签页的指示器。默认情况下，这将是一个 [TabRowDefaults.SecondaryIndicator]，使用
 * [TabRowDefaults.tabIndicatorOffset] 修饰符来动画化其位置。请注意，此指示器将被强制填充整个标签行，因此您应该使用
 * [TabRowDefaults.tabIndicatorOffset] 或类似方法来动画化在此空间内实际绘制的指示器，并提供从起始位置的偏移量。
 * @param 分隔线 显示在标签行底部的分隔线。它在标签行与下方显示的内容之间提供一层分隔。
 * @param 最小标签页宽度 此标签行中 [标签页] 的最小宽度，不受内容大小影响。
 * @param 标签页集 此标签行内的标签页。通常这将是多个 [标签页]。此 lambda 内的每个元素都将被测量并沿整行均匀放置，每个元素占据相同大小的空间。
 */
@Suppress("ComposableNaming")
@Composable
fun 次可滚动标签页行(
    已选择标签页索引: Int,
    修饰符: Modifier = Modifier,
    滚动状态: ScrollState = rememberScrollState(),
    容器颜色: Color = TabRowDefaults.secondaryContainerColor,
    内容颜色: Color = TabRowDefaults.secondaryContentColor,
    边缘内边距: Dp = TabRowDefaults.ScrollableTabRowEdgeStartPadding,
    指示器: @Composable TabIndicatorScope.() -> Unit =
        @Composable {
            TabRowDefaults.SecondaryIndicator(
                Modifier.tabIndicatorOffset(已选择标签页索引, matchContentSize = false)
            )
        },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    最小标签页宽度: Dp = TabRowDefaults.ScrollableTabRowMinTabWidth,
    标签页集: @Composable () -> Unit,
) =
    SecondaryScrollableTabRow(
        selectedTabIndex = 已选择标签页索引,
        modifier = 修饰符,
        scrollState = 滚动状态,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        edgePadding = 边缘内边距,
        indicator = 指示器,
        divider = 分隔线,
        minTabWidth = 最小标签页宽度,
        tabs = 标签页集,
    )


/**
 * 用于渲染标签页指示器的可组合项作用域，可用于需要标签页布局信息的更复杂指示器，如 [TabRowDefaults.PrimaryIndicator]
 * 和 [TabRowDefaults.SecondaryIndicator]。
 */
interface 标签页指示器范围 { // TabIndicatorScope

    /** 一种提供标签页位置的布局修饰符，可用于根据每个标签页的大小、位置和内容大小来动画化和布局 TabIndicator。*/
    fun Modifier.标签页指示器布局(
        测量: MeasureScope.(Measurable, Constraints, List<TabPosition>) -> MeasureResult
    ): Modifier

    /**
     * 一种遵循默认偏移量和动画的 Modifier。
     *
     * @param 已选择标签页索引 当前选中的标签页的索引
     * @param 匹配内容大小 此修饰符还可以动画化指示器的宽度，以匹配标签页的内容大小。
     */
    fun Modifier.标签页指示器偏移量(
        已选择标签页索引: Int,
        匹配内容大小: Boolean = false,
    ): Modifier

}


//============================================================================================

val TabPosition.左: Dp
    get() = this.left

val TabPosition.宽度: Dp
    get() = this.width

val TabPosition.内容宽度: Dp
    get() = this.contentWidth

val TabPosition.右: Dp
    get() = this.right

//============================================================================================


/** 包含 TabRow 的默认实现和值。 */
object 标签页行默认值 { // TabRowDefaults

    /** 包含 TabRow 的默认实现和值。*/
    val 可滚动标签页行最小标签页宽度 = TabRowDefaults.ScrollableTabRowMinTabWidth

    /** 在 [PrimaryScrollableTabRow] 或 [SecondaryScrollableTabRow] 中，标签页起始边缘之前的默认内边距。*/
    val 可滚动标签页行边缘开始内边距 = TabRowDefaults.ScrollableTabRowEdgeStartPadding

    /** 标签行的默认容器颜色。 */
    @Deprecated(
        message = "Use TabRowDefaults.primaryContainerColor instead",
        replaceWith = ReplaceWith("primaryContainerColor"),
    )
    val 容器颜色: Color
        @Composable get() = TabRowDefaults.containerColor

    /** [PrimaryTabRow] 的默认容器颜色。 */
    val 主容器颜色: Color
        @Composable get() = TabRowDefaults.primaryContainerColor

    /** [SecondaryTabRow] 的默认容器颜色。 */
    val 次容器颜色: Color
        @Composable get() = TabRowDefaults.secondaryContainerColor

    /** 标签行的默认内容颜色。 */
    @Deprecated(
        message = "Use TabRowDefaults.primaryContentColor instead",
        replaceWith = ReplaceWith("primaryContentColor"),
    )
    val 内容颜色: Color
        @Composable get() = TabRowDefaults.contentColor

    /** [PrimaryTabRow] 的默认内容颜色。 */
    val 主内容颜色: Color
        @Composable get() = TabRowDefaults.primaryContentColor

    /** [SecondaryTabRow] 的默认内容颜色。 */
    val 次内容颜色: Color
        @Composable get() = TabRowDefaults.secondaryContentColor

    /**
     * 默认指示器，将位于 [TabRow] 的底部，在分隔线的上方。
     *
     * @param 修饰符 指示器的布局修饰符
     * @param 高度 指示器的高度
     * @param 颜色 指示器的颜色
     */
    @Suppress("ComposableNaming")
    @Composable
    @Deprecated(
        message = "Use SecondaryIndicator instead.",
        replaceWith = ReplaceWith("SecondaryIndicator(modifier, height, color)"),
    )
    fun 指示器(
        修饰符: Modifier = Modifier,
        高度: Dp = 3.0.dp,
        颜色: Color = MaterialTheme.colorScheme.primary,
    ) =
        TabRowDefaults.Indicator(
            modifier = 修饰符,
            height = 高度,
            color = 颜色,
        )


    /**
     * 主指示器，将位于 [TabRow] 的底部，在分隔线的上方。
     *
     * @param 修饰符 指示器的布局修饰符
     * @param 宽度 指示器的宽度
     * @param 高度 指示器的高度
     * @param 颜色 指示器的颜色
     * @param 形状 指示器的形状
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 主指示器(
        修饰符: Modifier = Modifier,
        宽度: Dp = 24.dp,
        高度: Dp = 3.0.dp,
        颜色: Color = MaterialTheme.colorScheme.primary,
        形状: Shape = RoundedCornerShape(3.0.dp),
    ) =
        TabRowDefaults.PrimaryIndicator(
            modifier = 修饰符,
            width = 宽度,
            height = 高度,
            color = 颜色,
            shape = 形状
        )


    /**
     * 次指示器，将位于 [TabRow] 的底部，在分隔线的上方。
     *
     * @param 修饰符 指示器的布局修饰符
     * @param 高度 指示器的高度
     * @param 颜色 指示器的颜色
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 次指示器(
        修饰符: Modifier = Modifier,
        高度: Dp = 3.0.dp,
        颜色: Color = MaterialTheme.colorScheme.primary,
    ) =
        TabRowDefaults.SecondaryIndicator(
            modifier = 修饰符,
            height = 高度,
            color = 颜色,
        )


    /**
     * [Modifier]，它会占据 [TabRow] 内的所有可用宽度，然后根据 [当前标签页位置] 动画化所应用指示器的偏移量。
     *
     * @param 当前标签页位置 当前选中的标签页的 [TabPosition]。这用于计算此修饰符所应用的指示器的偏移量及其宽度。
     */
    @Deprecated(
        level = DeprecationLevel.WARNING,
        message =
            "Solely for use alongside deprecated TabRowDefaults.Indicator method. For " +
                    "recommended PrimaryIndicator and SecondaryIndicator methods, please use " +
                    "TabIndicatorScope.tabIndicatorOffset method.",
    )
    fun Modifier.标签页指示器偏移量(当前标签页位置: TabPosition): Modifier =
        this.tabIndicatorOffset(currentTabPosition = 当前标签页位置)

}


/**
 * [Material Design tabs](https://m3.material.io/components/tabs/overview)
 *
 * Material Design 固定标签页。
 *
 * 对于主指示器标签页，请使用 [PrimaryTabRow]。对于次指示器标签页，请使用 [SecondaryTabRow]。
 *
 * 固定标签页会同时显示一组中的所有标签页。它们最适合在相关内容之间快速切换，例如在地图中的不同交通方式之间切换。
 * 要在固定标签页之间导航，点击单个标签页，或在内容区域向左或向右滑动。
 *
 * `标签页行` 包含一行 [标签页]，并在当前选中的标签页下方显示指示器。`标签页行` 将其标签页沿整行均匀分布，每个标签页占据相同大小的空间。
 * 如需使用不强制等宽、并允许滚动以查看屏幕外标签页的标签行，请参阅 [ScrollableTabRow]。
 *
 * 除了自定义标签页外，您还可以提供一个自定义的 [指示器]，以自定义为标签页显示的指示器。[指示器] 将被放置以填充整个
 * `标签页行`，因此它内部应负责调整指示器的大小和位置，以匹配 [已选择标签页索引] 的变化。
 *
 * 您可能还希望使用自定义过渡效果，以便在指示器在标签页之间动画切换时动态改变其外观，例如改变颜色或大小。[指示器] 是堆叠
 * 在整个 `标签页行` 之上的，因此您只需提供一个自定义过渡效果，用于动画化指示器相对于 `标签页行` 起始位置的偏移量。例如，请看以下示例，
 * 它使用过渡效果来动画化之前那个 FancyIndicator 的偏移量、宽度和颜色，同时为运动方向上的指示器添加了基于物理的"弹簧"效果
 *
 * @param 已选择标签页索引 当前选中的标签页的索引
 * @param 修饰符 要应用于此标签行的 [Modifier]
 * @param 容器颜色 用于此标签行背景的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此标签行内部内容的首选颜色。默认情况下，使用与 [容器颜色] 匹配的内容颜色；如果 [容器颜色]
 * 不是来自主题的颜色，则默认使用当前的 [LocalContentColor]。
 * @param 指示器 表示当前选中标签页的指示器。默认情况下，这将是一个 [TabRowDefaults.SecondaryIndicator]，使用
 * [TabRowDefaults.tabIndicatorOffset] 修饰符来动画化其位置。请注意，此指示器将被强制填充整个标签行，因此您应该使用
 * [TabRowDefaults.tabIndicatorOffset] 或类似方法来动画化在此空间内实际绘制的指示器，并提供从起始位置的偏移量。
 * @param 分隔线 显示在标签行底部的分隔线。它在标签行与下方显示的内容之间提供一层分隔。
 * @param 标签页集 此标签行内的标签页。通常这将是多个 [标签页]。此 lambda 内的每个元素都将被测量并沿整行均匀放置，每个元素占据相同大小的空间。
 */
@Composable
@Deprecated(
    level = DeprecationLevel.WARNING,
    message = "Replaced with PrimaryTabRow and SecondaryTabRow.",
    replaceWith =
        ReplaceWith(
            "SecondaryTabRow(selectedTabIndex, modifier, containerColor, contentColor, indicator, divider, tabs)"
        ),
)
@Suppress("DEPRECATION", "ComposableNaming")
fun 标签页行(
    已选择标签页索引: Int,
    修饰符: Modifier = Modifier,
    容器颜色: Color = TabRowDefaults.primaryContainerColor,
    内容颜色: Color = TabRowDefaults.primaryContentColor,
    指示器: @Composable (tabPositions: List<TabPosition>) -> Unit =
        @Composable { tabPositions ->
            if (已选择标签页索引 < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[已选择标签页索引])
                )
            }
        },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    标签页集: @Composable () -> Unit,
) =
    TabRow(
        selectedTabIndex = 已选择标签页索引,
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        indicator = 指示器,
        divider = 分隔线,
        tabs = 标签页集
    )


/**
 * [Material Design tabs](https://m3.material.io/components/tabs/overview)
 *
 * Material Design 可滚动标签页。
 *
 * 对于主指示器标签页，请使用 [PrimaryScrollableTabRow]。对于次指示器标签页，请使用 [SecondaryScrollableTabRow]。
 *
 * 当一组标签页无法容纳在屏幕上时，请使用可滚动标签页。可滚动标签页可以使用更长的文本标签和更多的标签页数量。它们最适合用于触摸界面上的浏览。
 *
 * `可滚动标签页行` 包含一行 [标签页]，并在当前选中的标签页下方显示指示器。`可滚动标签页行` 将其标签页从起始边缘偏移放置，
 * 并允许滚动到屏幕外的标签页。如需使用不允许滚动且均匀放置标签页的固定标签行，请参阅 [标签页行]。
 *
 * @param 已选择标签页索引 当前选中的标签页的索引
 * @param 修饰符 要应用于此标签行的 [Modifier]
 * @param 容器颜色 用于此标签行背景的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此标签行内部内容的首选颜色。默认情况下，使用与 [容器颜色] 匹配的内容颜色；如果 [容器颜色]
 * 不是来自主题的颜色，则默认使用当前的 [LocalContentColor]。
 * @param 边缘内边距 可滚动标签行的起始边缘和结束边缘与行内标签页之间的内边距。此内边距有助于提示用户该标签行可以滚动，这与 [标签页行] 不同。
 * @param 指示器 表示当前选中标签页的指示器。默认情况下，这将是一个 [TabRowDefaults.SecondaryIndicator]，使用
 * [TabRowDefaults.tabIndicatorOffset] 修饰符来动画化其位置。请注意，此指示器将被强制填充整个标签行，因此您应该使用
 * [TabRowDefaults.tabIndicatorOffset] 或类似方法来动画化在此空间内实际绘制的指示器，并提供从起始位置的偏移量。
 * @param 分隔线 显示在标签行底部的分隔线。它在标签行与下方显示的内容之间提供一层分隔。
 * @param 标签页集 此标签行内的标签页。通常这将是多个 [标签页]。此 lambda 内的每个元素都将被测量并沿整行均匀放置，每个元素占据相同大小的空间。
 */
@Composable
@Deprecated(
    level = DeprecationLevel.WARNING,
    message = "Replaced with PrimaryScrollableTabRow and SecondaryScrollableTabRow tab variants.",
    replaceWith =
        ReplaceWith(
            "SecondaryScrollableTabRow(selectedTabIndex, modifier, containerColor, contentColor, edgePadding, indicator, divider, tabs)"
        ),
)
@Suppress("DEPRECATION", "ComposableNaming")
fun 可滚动标签页行(
    已选择标签页索引: Int,
    修饰符: Modifier = Modifier,
    容器颜色: Color = TabRowDefaults.primaryContainerColor,
    内容颜色: Color = TabRowDefaults.primaryContentColor,
    边缘内边距: Dp = TabRowDefaults.ScrollableTabRowEdgeStartPadding,
    指示器: @Composable (tabPositions: List<TabPosition>) -> Unit =
        @Composable { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                Modifier.tabIndicatorOffset(tabPositions[已选择标签页索引])
            )
        },
    分隔线: @Composable () -> Unit = @Composable { HorizontalDivider() },
    标签页集: @Composable () -> Unit,
) =
    ScrollableTabRow(
        selectedTabIndex = 已选择标签页索引,
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        edgePadding = 边缘内边距,
        indicator = 指示器,
        divider = 分隔线,
        tabs = 标签页集,
    )

