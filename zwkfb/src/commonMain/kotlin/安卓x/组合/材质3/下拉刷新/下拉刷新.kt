package 安卓x.组合.材质3.下拉刷新

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import kotlin.js.JsName


// TODO: 在可用时链接到 Material Design 规范。
/**
 * [下拉刷新盒子] 是一个容器，期望可滚动布局作为内容，并添加手势支持，以便用户在内容起始位置向下滑动时手动刷新。
 * 默认情况下，它使用 [PullToRefreshDefaults.Indicator] 作为刷新指示器，但你也可以选择设置自己的指示器，
 * 或使用 [PullToRefreshDefaults.LoadingIndicator]。
 *
 * @param 是否正在刷新 是否正在发生刷新
 * @param 刷新回调 当用户手势越过阈值从而请求刷新时调用的回调。
 * @param 修饰符 要应用于此容器的 [Modifier]。
 * @param 状态 跟踪下拉距离的状态。
 * @param 内容对齐 盒子 内部的默认对齐方式。
 * @param 指示器 当用户开始下拉或正在发生刷新时，绘制在内容顶部的指示器。
 * @param 已启用 嵌套滚动事件是否应由此组件消费。
 * @param 阈值 在调用 [刷新回调] 之前，可以向下滑动的距离。
 * @param 内容 下拉刷新容器的内容，通常为可滚动布局，例如 [LazyColumn] 或使用
 * [androidx.compose.foundation.verticalScroll] 的布局。
 */
@Suppress("ComposableNaming")
@Composable
fun 下拉刷新盒子(
    是否正在刷新: Boolean,
    刷新回调: () -> Unit,
    修饰符: Modifier = Modifier,
    状态: PullToRefreshState = rememberPullToRefreshState(),
    内容对齐: Alignment = Alignment.TopStart,
    指示器: @Composable BoxScope.() -> Unit = {
        PullToRefreshDefaults.Indicator(
            modifier = Modifier.align(Alignment.TopCenter),
            isRefreshing = 是否正在刷新,
            state = 状态,
        )
    },
    已启用: Boolean = true,
    阈值: Dp = PullToRefreshDefaults.PositionalThreshold,
    内容: @Composable BoxScope.() -> Unit,
) =
    PullToRefreshBox(
        isRefreshing = 是否正在刷新,
        onRefresh = 刷新回调,
        modifier = 修饰符,
        state = 状态,
        contentAlignment = 内容对齐,
        indicator = 指示器,
        enabled = 已启用,
        threshold = 阈值,
        content = 内容,
    )



/**
 * 一个为容器添加嵌套滚动以支持下拉刷新手势的 Modifier。当用户下拉距离超过 [阈值] 并释放手势时，
 * 将调用 [刷新回调]。[下拉刷新盒子] 会自动应用此功能。
 *
 * @param 是否正在刷新 是否正在发生刷新。如果没有正在进行的手势，当 isRefreshing 为 false 时，
 * `state.distanceFraction` 将动画过渡到 0f；否则将动画过渡到 1f。
 * @param 状态 跟踪下拉距离的状态。
 * @param 已启用 嵌套滚动事件是否应由此修饰符消费。
 * @param 阈值 在调用 [刷新回调] 之前，可以向下滑动的距离。
 * @param 刷新回调 当下拉距离超过 [阈值] 时调用的回调。
 */
fun Modifier.下拉刷新(
    是否正在刷新: Boolean,
    状态: PullToRefreshState,
    已启用: Boolean = true,
    阈值: Dp = PullToRefreshDefaults.PositionalThreshold,
    刷新回调: () -> Unit,
): Modifier =
    this.pullToRefresh(
        isRefreshing = 是否正在刷新,
        state = 状态,
        enabled = 已启用,
        threshold = 阈值,
        onRefresh = 刷新回调,
    )


/** 包含 [下拉刷新盒子] 的默认值。 */
object 下拉刷新默认值 { // PullToRefreshDefaults

    /** [指示器] 的默认形状。 */
    @Deprecated("Use indicatorShape instead", ReplaceWith("indicatorShape"))
    val 形状: Shape = PullToRefreshDefaults.shape

    /** [指示器] 的默认形状。 */
    val 指示器形状: Shape = PullToRefreshDefaults.indicatorShape

    /** [指示器] 的默认容器颜色。 */
    @Deprecated("Use indicatorContainerColor instead", ReplaceWith("indicatorContainerColor"))
    val 容器颜色: Color
        @Composable get() = PullToRefreshDefaults.containerColor

    /** [指示器] 的默认容器颜色。 */
    val 指示器容器颜色: Color
        @Composable get() = PullToRefreshDefaults.indicatorContainerColor

    /** 下拉刷新时出现的加载指示器的默认容器颜色。*/
    @ExperimentalMaterial3ExpressiveApi
    val 加载指示器容器颜色: Color
        @Composable get() = PullToRefreshDefaults.loadingIndicatorContainerColor

    /** [指示器] 的默认指示器颜色。 */
    val 指示器颜色: Color
        @Composable get() = PullToRefreshDefaults.indicatorColor

    /** 下拉刷新时出现的加载指示器的默认活动指示器颜色。*/
    @ExperimentalMaterial3ExpressiveApi
    val 加载指示器颜色: Color
        @Composable get() = PullToRefreshDefaults.loadingIndicatorColor

    /** [rememberPullToRefreshState] 的默认刷新阈值。 */
    val 位置阈值 = PullToRefreshDefaults.PositionalThreshold

    /** [指示器]、[指示器盒子] 和 [加载指示器] 在触发刷新前可被下拉的最大距离默认值。*/
    val 指示器最大距离 = PullToRefreshDefaults.IndicatorMaxDistance

    /** 应用于 [指示器] 的 [指示器盒子] 的默认海拔高度。 */
    val 阴影 = PullToRefreshDefaults.Elevation

    /** 应用于 [加载指示器] 的 [指示器盒子] 的默认海拔高度。 */
    val 加载指示器阴影 = PullToRefreshDefaults.LoadingIndicatorElevation

    /**
     * 一个处理下拉刷新指示器的大小、偏移、裁剪、阴影和背景绘制的包装器，在实现自定义指示器时非常有用。
     * [PullToRefreshDefaults.Indicator] 使用它作为容器。
     *
     * @param 状态 此修饰符的状态，将使用 `state.distanceFraction` 和 [最大距离] 来计算偏移量。
     * @param 是否正在刷新 是否正在发生刷新
     * @param 修饰符 应用于此布局的修饰符。
     * @param 最大距离 指示器在释放触发刷新前可被下拉的最大距离。
     * @param 形状 此指示器的 [Shape]。
     * @param 容器颜色 此指示器的容器颜色。
     * @param 阴影 指示器的海拔高度。
     * @param 内容 此 [指示器盒子] 的内容。
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 指示器盒子(
        状态: PullToRefreshState,
        是否正在刷新: Boolean,
        修饰符: Modifier = Modifier,
        最大距离: Dp = PullToRefreshDefaults.IndicatorMaxDistance,
        形状: Shape = PullToRefreshDefaults.indicatorShape,
        容器颜色: Color = Color.Unspecified,
        阴影: Dp = PullToRefreshDefaults.Elevation,
        内容: @Composable BoxScope.() -> Unit,
    ) =
        PullToRefreshDefaults.IndicatorBox(
            state = 状态,
            isRefreshing = 是否正在刷新,
            modifier = 修饰符,
            maxDistance = 最大距离,
            shape = 形状,
            containerColor = 容器颜色,
            elevation = 阴影,
            content = 内容,
        )

    /**
     * [下拉刷新盒子] 的默认指示器。
     *
     * @param 状态 此修饰符的状态，将使用 `state.distanceFraction` 和 [最大距离] 来计算偏移量。
     * @param 是否正在刷新 是否正在发生刷新。
     * @param 修饰符 应用于此布局的修饰符。
     * @param 容器颜色 此指示器的容器颜色。
     * @param 颜色 此指示器的颜色。
     * @param 最大距离 指示器在释放触发刷新前可被下拉的最大距离。
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 指示器(
        状态: PullToRefreshState,
        是否正在刷新: Boolean,
        修饰符: Modifier = Modifier,
        容器颜色: Color = PullToRefreshDefaults.indicatorContainerColor,
        颜色: Color = PullToRefreshDefaults.indicatorColor,
        最大距离: Dp = PullToRefreshDefaults.IndicatorMaxDistance,
    ) =
        PullToRefreshDefaults.Indicator(
            state = 状态,
            isRefreshing = 是否正在刷新,
            modifier = 修饰符,
            containerColor = 容器颜色,
            color = 颜色,
            maxDistance = 最大距离,
        )


    /**
     * [PullToRefreshBox] 的 [加载指示器] 指示器。
     *
     * @param 状态 此修饰符的状态，将使用 state.distanceFraction 和 [最大距离] 来计算偏移量。
     * @param 是否正在刷新 是否正在发生刷新。
     * @param 修饰符 应用于此布局的修饰符。
     * @param 容器颜色 此指示器的容器颜色。
     * @param 颜色 此指示器的颜色。
     * @param 阴影 指示器的海拔高度。
     * @param 最大距离 指示器在释放触发刷新前可被下拉的最大距离。
     */
    @Suppress("ComposableNaming")
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 加载指示器(
        状态: PullToRefreshState,
        是否正在刷新: Boolean,
        修饰符: Modifier = Modifier,
        容器颜色: Color = PullToRefreshDefaults.loadingIndicatorContainerColor,
        颜色: Color = PullToRefreshDefaults.loadingIndicatorColor,
        阴影: Dp = PullToRefreshDefaults.LoadingIndicatorElevation,
        最大距离: Dp = PullToRefreshDefaults.IndicatorMaxDistance,
    ) =
        PullToRefreshDefaults.LoadingIndicator(
            state = 状态,
            isRefreshing = 是否正在刷新,
            modifier = 修饰符,
            containerColor = 容器颜色,
            color = 颜色,
            elevation = 阴影,
            maxDistance = 最大距离,
        )

}

/**
 * [下拉刷新盒子] 的状态，用于跟踪容器和指示器已被下拉的距离。
 *
 * [下拉刷新盒子] 的每个实例都应拥有自己独立的 [PullToRefreshState]。
 *
 * [PullToRefreshState] 可以像这样使用其他进度指示器：
 *
 * @sample androidx.compose.material3.samples.PullToRefreshLinearProgressIndicatorSample
 */
@Stable
interface 下拉刷新状态 { // PullToRefreshState

    /** 朝向刷新阈值的距离百分比。0.0 表示无距离，1.0 表示达到阈值偏移量，大于 1.0 表示超出所提供的阈值。*/
    @get:FloatRange(from = 0.0) val 距离比例: Float

    /** 状态当前是否正在将指示器动画过渡到阈值偏移量，或返回到隐藏偏移量。*/
    val 是否正在动画: Boolean

    /** 将距离动画过渡到锚点或阈值位置，刷新时指示器将显示在该位置。*/
    suspend fun 动画到阈值()

    /** 将距离动画过渡到指示器在空闲时隐藏的位置。 */
    suspend fun 动画到隐藏()

    /** 将指示器吸附到所需的阈值比例。 */
    suspend fun 吸附到(@FloatRange(from = 0.0) 目标值: Float)

}

//==========================================================================

/** 朝向刷新阈值的距离百分比。0.0 表示无距离，1.0 表示达到阈值偏移量，大于 1.0 表示超出所提供的阈值。*/
@get:FloatRange(from = 0.0) val PullToRefreshState.距离比例: Float
    get() = this.distanceFraction

/** 状态当前是否正在将指示器动画过渡到阈值偏移量，或返回到隐藏偏移量。*/
val PullToRefreshState.是否正在动画: Boolean
    get() = this.isAnimating

/** 将距离动画过渡到锚点或阈值位置，刷新时指示器将显示在该位置。*/
suspend fun PullToRefreshState.动画到阈值() = this.animateToThreshold()

/** 将距离动画过渡到指示器在空闲时隐藏的位置。 */
suspend fun PullToRefreshState.动画到隐藏() = this.animateToHidden()

/** 将指示器吸附到所需的阈值比例。 */
suspend fun PullToRefreshState.吸附到(@FloatRange(from = 0.0) 目标值: Float) =
    this.snapTo(targetValue = 目标值)

//==========================================================================

/** 创建并记住默认的 [下拉刷新状态]。 */
@Composable
fun 记住下拉刷新状态(): PullToRefreshState = rememberPullToRefreshState()


/**
 * 创建一个 [下拉刷新状态]。
 *
 * 请注意，在大多数情况下，建议在组合中使用 [记住下拉刷新状态]。
 */
@JsName("funPullToRefreshState")
fun 下拉刷新状态(): PullToRefreshState = PullToRefreshState()

