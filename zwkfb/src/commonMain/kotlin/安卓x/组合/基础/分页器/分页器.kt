package 安卓x.组合.基础.分页器

import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.annotation.FloatRange
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.OverscrollEffect
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.TargetedFlingBehavior
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.snapping.snapFlingBehavior
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.rememberOverscrollEffect
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * 一个水平滚动的 Pager。页面会根据可用的视口大小进行懒加载放置。根据定义，[Pager] 中的页面具有相同的大小，由 [页面大小] 定义，
 * 并使用由 [抛掷行为] 提供的吸附动画将页面滚动到特定位置。您可以使用 [超出视口页面数量] 在可见页面之前和之后放置更多页面。
 *
 * 如果您需要对不同大小的页面进行吸附效果，可以将 [snapFlingBehavior] 与适配到 LazyList 的 [SnapLayoutInfoProvider] 一起使用。
 *
 * @param 状态 用于控制此 分页器 的状态。
 * @param 修饰符 要应用于此 Pager 外部布局的修饰符实例。
 * @param 内容内边距 整个内容周围的内边距。这会在内容被裁剪后为其添加内边距，这是通过 [修饰符] 参数无法实现的。
 * 您可以用它在第一页之前或最后一页之后添加内边距。使用 [页面间距] 来添加页面之间的间距。
 * @param 页面大小 使用此参数来改变页面在此 Pager 中的外观。
 * @param 超出视口页面数量 要在可见页面列表之前和之后进行组合和布局的页面数量。注意：请注意，为 [超出视口页面数量]
 * 使用过大的值会导致大量页面被组合、测量和放置，这将违背使用懒加载的目的。此参数应作为优化手段，用于在可见页面之前和之后预加载少量页面。
 * 这不包括滚动事件期间，预取器在滚动方向上自动组合和布局的页面。
 * @param 页面间距 用于分隔此 Pager 中各页面的间距大小。
 * @param 垂直对齐 页面在此 Pager 中的垂直对齐方式。
 * @param 抛掷行为 用于滚动后手势的 [TargetedFlingBehavior]。
 * @param 用户滚动已启用 是否允许通过用户手势或无障碍操作进行滚动。即使禁用了此功能，您仍然可以使用 [PagerState.scroll] 以编程方式滚动。
 * @param 反向布局 反转滚动和布局的方向。
 * @param 键 表示条目的稳定且唯一的键。当您指定键时，滚动位置将基于该键进行维护，这意味着如果您在当前可见条目之前添加或移除条目，
 * 具有给定键的条目仍将被保留为第一个可见条目。如果传入 null，则列表中的位置将代表该键。
 * @param 页面嵌套滚动连接 一个 [NestedScrollConnection]，用于规定此 [Pager] 与嵌套列表的交互行为。
 * 默认行为是 [Pager] 会消费所有嵌套滚动增量。
 * @param 吸附位置 此 Pager 如何执行页面吸附的计算方式。使用此参数可以为布局中的不同位置提供不同的吸附效果。[Pager]
 * 将其用作计算 [PagerState.currentPage] 的方式，currentPage 是布局中最接近吸附位置的页面（例如，如果吸附位置是布局的起始位置，
 * 那么 currentPage 将是距离该位置最近的页面）。
 * @param 过度滚动效果 用于为此 Pager 渲染 overscroll 效果的 [OverscrollEffect]。请注意，[OverscrollEffect.node]
 * 也会在内部被应用——您不需要单独使用 Modifier.overscroll。
 * @param 页面内容 此 Pager 的页面可组合项。
 * @see androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider for the implementation
 *   of a [SnapLayoutInfoProvider] that uses [androidx.compose.foundation.lazy.LazyListState].
 *
 * 请参阅示例以了解如何使用此 API。
 */
@Suppress("ComposableNaming")
@Composable
fun 水平分页器(
    状态: PagerState,
    修饰符: Modifier = Modifier,
    内容内边距: PaddingValues = PaddingValues(0.dp),
    页面大小: PageSize = PageSize.Fill,
    超出视口页面数量: Int = PagerDefaults.BeyondViewportPageCount,
    页面间距: Dp = 0.dp,
    垂直对齐: Alignment.Vertical = Alignment.CenterVertically,
    抛掷行为: TargetedFlingBehavior = PagerDefaults.flingBehavior(state = 状态),
    用户滚动已启用: Boolean = true,
    反向布局: Boolean = false,
    键: ((index: Int) -> Any)? = null,
    页面嵌套滚动连接: NestedScrollConnection =
        PagerDefaults.pageNestedScrollConnection(状态, Orientation.Horizontal),
    吸附位置: SnapPosition = SnapPosition.Start,
    过度滚动效果: OverscrollEffect? = rememberOverscrollEffect(),
    页面内容: @Composable PagerScope.(page: Int) -> Unit,
) =
    HorizontalPager(
        state = 状态,
        modifier = 修饰符,
        contentPadding = 内容内边距,
        pageSize = 页面大小,
        beyondViewportPageCount = 超出视口页面数量,
        pageSpacing = 页面间距,
        verticalAlignment = 垂直对齐,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动已启用,
        reverseLayout = 反向布局,
        key = 键,
        pageNestedScrollConnection = 页面嵌套滚动连接,
        snapPosition = 吸附位置,
        overscrollEffect = 过度滚动效果,
        pageContent = 页面内容,
    )



/**
 * 一个垂直滚动的 Pager。页面会根据可用的视口大小进行懒加载放置。根据定义，[Pager] 中的页面具有相同的大小，由 [页面大小] 定义，
 * 并使用由 [抛掷行为] 提供的吸附动画将页面滚动到特定位置。您可以使用 [超出视口页面数量] 在可见页面之前和之后放置更多页面。
 *
 * 如果您需要对不同大小的页面进行吸附效果，可以将 [snapFlingBehavior] 与适配到 LazyList 的 [SnapLayoutInfoProvider] 一起使用。
 *
 * @param 状态 用于控制此 Pager 的状态。
 * @param 修饰符 要应用于此 Pager 外部布局的修饰符实例。
 * @param 内容内边距 整个内容周围的内边距。这会在内容被裁剪后为其添加内边距，这是通过 [修饰符] 参数无法实现的。
 * 您可以用它在第一页之前或最后一页之后添加内边距。使用 [页面间距] 来添加页面之间的间距。
 * @param 页面大小 使用此参数来改变页面在此 Pager 中的外观。
 * @param 超出视口页面数量 要在可见页面列表之前和之后进行组合和布局的页面数量。注意：请注意，为 [超出视口页面数量]
 * 使用过大的值会导致大量页面被组合、测量和放置，这将违背使用懒加载的目的。此参数应作为优化手段，用于在可见页面之前和之后预加载少量页面。
 * 这不包括滚动事件期间，预取器在滚动方向上自动组合和布局的页面。
 * @param 页面间距 用于分隔此 Pager 中各页面的间距大小。
 * @param 水平对齐 页面在此 Pager 中的水平对齐方式。
 * @param 抛掷行为 用于滚动后手势的 [TargetedFlingBehavior]。
 * @param 用户滚动已启用 是否允许通过用户手势或无障碍操作进行滚动。即使禁用了此功能，您仍然可以使用 [PagerState.scroll] 以编程方式滚动。
 * @param 反向布局 反转滚动和布局的方向。
 * @param 键 表示条目的稳定且唯一的键。当您指定键时，滚动位置将基于该键进行维护，这意味着如果您在当前可见条目之前添加或移除条目，
 * 具有给定键的条目仍将被保留为第一个可见条目。如果传入 null，则列表中的位置将代表该键。
 * @param 页面嵌套滚动连接 一个 [NestedScrollConnection]，用于规定此 [Pager] 与嵌套列表的交互行为。
 * 默认行为是 [Pager] 会消费所有嵌套滚动增量。
 * @param 吸附位置 此 Pager 如何执行页面吸附的计算方式。使用此参数可以为布局中的不同位置提供不同的吸附效果。[Pager]
 * 将其用作计算 [PagerState.currentPage] 的方式，currentPage 是布局中最接近吸附位置的页面（例如，如果吸附位置是布局的起始位置，
 * 那么 currentPage 将是距离该位置最近的页面）。
 * @param 过度滚动效果 用于为此 Pager 渲染 overscroll 效果的 [OverscrollEffect]。请注意，[OverscrollEffect.node]
 * 也会在内部被应用——您不需要单独使用 Modifier.overscroll。
 * @param 页面内容 此 Pager 的页面可组合项。
 * @see androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider for the implementation
 *   of a [SnapLayoutInfoProvider] that uses [androidx.compose.foundation.lazy.LazyListState].
 *
 * 请参阅示例以了解如何使用此 API。
 */
@Suppress("ComposableNaming")
@Composable
fun 垂直分页器(
    状态: PagerState,
    修饰符: Modifier = Modifier,
    内容内边距: PaddingValues = PaddingValues(0.dp),
    页面大小: PageSize = PageSize.Fill,
    超出视口页面数量: Int = PagerDefaults.BeyondViewportPageCount,
    页面间距: Dp = 0.dp,
    水平对齐: Alignment.Horizontal = Alignment.CenterHorizontally,
    抛掷行为: TargetedFlingBehavior = PagerDefaults.flingBehavior(state = 状态),
    用户滚动已启用: Boolean = true,
    反向布局: Boolean = false,
    键: ((index: Int) -> Any)? = null,
    页面嵌套滚动连接: NestedScrollConnection =
        PagerDefaults.pageNestedScrollConnection(状态, Orientation.Vertical),
    吸附位置: SnapPosition = SnapPosition.Start,
    过度滚动效果: OverscrollEffect? = rememberOverscrollEffect(),
    页面内容: @Composable PagerScope.(page: Int) -> Unit,
) =
    VerticalPager(
        state = 状态,
        modifier = 修饰符,
        contentPadding = 内容内边距,
        pageSize = 页面大小,
        beyondViewportPageCount = 超出视口页面数量,
        pageSpacing = 页面间距,
        horizontalAlignment = 水平对齐,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动已启用,
        reverseLayout = 反向布局,
        key = 键,
        pageNestedScrollConnection = 页面嵌套滚动连接,
        snapPosition = 吸附位置,
        overscrollEffect = 过度滚动效果,
        pageContent = 页面内容,
    )




/** 包含 [Pager] 使用的默认值。 */
object 分页器默认值 { // PagerDefaults

    /**
     * 一个将页面吸附到布局起始位置的 [snapFlingBehavior]。可以使用给定的参数来控制吸附动画的执行方式。
     *
     * @param 状态 控制此 FlingBehavior 将应用到的 Pager 的 [PagerState]。
     * @param 分页器吸附距离 用于控制此 [Pager] 吸附目标位置的方式。默认行为会使任何 fling 操作滑向 fling
     * 方向上的下一页（如果 fling 具有足够的速度，否则 Pager 将回弹）。使用 [PagerSnapDistance.atMost] 可定义此
     * [Pager] 在滚动结束且 fling 开始后，最多允许 fling 经过的页数。
     * @param 衰减动画规格 用于接近目标偏移量的动画规格。当 fling 速度足够大时生效。"足够大"指的是大到足以自然衰减。
     * 对于单页吸附来说，这通常不会发生，因为没有足够的空间来运行衰减动画。
     * @param 吸附动画规格 用于最终吸附到目标位置的动画规格。此动画通常在两种情况下使用：1）有足够的空间执行趋近动画，
     * Pager 会在动画的最后一步使用 [吸附动画规格] 使页面归位到目标位置；2）没有足够的空间来执行趋近动画。
     * @param 吸附位置阈值 如果 fling 速度较低（例如缓慢滚动），此 fling 行为将使用该吸附阈值来决定 Pager 应该回弹还是前进。
     * 使用 0 到 1 之间的数值作为页面尺寸的分数，表示 Pager 认为应该移动到下一页之前需要滚动的比例。例如，如果 snapPositionalThreshold = 0.35，
     * 意味着如果此 Pager 以较低速度滚动且滚动距离超过页面尺寸的 35%，则会跳转到下一页，否则回滚。请注意，任何速度足够高的 fling
     * 都始终会沿着 fling 方向移动到下一页。
     * @return 默认情况下执行吸附到下一页的 [FlingBehavior] 实例。动画由滚动后的速度控制，Pager 将使用 [吸附动画规格]
     * 或 [衰减动画规格] 来趋近吸附位置。如果速度不够高，Pager 将使用 [吸附动画规格] 到达吸附位置。
     * 如果速度足够高，Pager 将使用 [衰减动画规格] 和 [吸附动画规格] 中描述的逻辑。
     * @see androidx.compose.foundation.gestures.snapping.snapFlingBehavior 有关各参数在整个吸附动画中具体控制什么的更多信息。
     *
     * fling 行为使用的动画规格取决于两个因素：
     * 1）手势速度。
     * 2）[分页器吸附距离] 建议的目标页。
     *
     * 如果使用单页吸附（[Pager] 最常见的使用场景），没有足够的空间来实际运行衰减动画以趋近目标页，因此 Pager 将始终使用
     * [吸附动画规格] 中的吸附动画。如果使用多页吸附（即 abs(targetPage - currentPage) > 1），Pager
     * 可能会使用 [衰减动画规格] 或 [吸附动画规格] 来趋近 targetPage，这取决于触发手势产生的速度。
     * 如果手势具有足够高的速度来趋近目标页，Pager 将先使用 [衰减动画规格]，然后在动画的最后一步使用 [吸附动画规格]。
     * 如果手势速度不够，Pager 将以类似方式使用 [吸附动画规格] + [吸附动画规格]。
     *
     */
    @Composable
    fun 抛掷行为(
        状态: PagerState,
        分页器吸附距离: PagerSnapDistance = PagerSnapDistance.atMost(1),
        衰减动画规格: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
        吸附动画规格: AnimationSpec<Float> =
            spring(
                stiffness = Spring.StiffnessMediumLow,
                visibilityThreshold = Int.VisibilityThreshold.toFloat(),
            ),
        @FloatRange(from = 0.0, to = 1.0) 吸附位置阈值: Float = 0.5f,
    ): TargetedFlingBehavior =
        PagerDefaults.flingBehavior(
            state = 状态,
            pagerSnapDistance = 分页器吸附距离,
            decayAnimationSpec = 衰减动画规格,
            snapAnimationSpec = 吸附动画规格,
            snapPositionalThreshold = 吸附位置阈值,
        )

    /**
     * 分页器 的 页面嵌套滚动连接 的默认实现。
     *
     * @param 状态 分页器 的状态
     * @param 方向 分页器 的方向。这将用于确定嵌套滚动连接在哪些方向上操作和响应。
     */
    @Composable
    fun 页面嵌套滚动连接(
        状态: PagerState,
        方向: Orientation,
    ): NestedScrollConnection =
        PagerDefaults.pageNestedScrollConnection(state = 状态, orientation = 方向,)

    /**
     * 超出视口页面数量 的默认值，用于指定在可见页面之前和之后需要组合（compose）和布局（layout）的页面数量。
     * 这不包括滚动事件期间，预取器（pre-fetcher）在滚动方向上自动组合和布局的页面。
     */
    const val 超出视口页面数量 = PagerDefaults.BeyondViewportPageCount

}


