package 安卓x.组合.材质3.轮播

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.gestures.TargetedFlingBehavior
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.carousel.CarouselDefaults
import androidx.compose.material3.carousel.CarouselItemScope
import androidx.compose.material3.carousel.CarouselState
import androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design Carousel](https://m3.material.io/components/carousel/overview)
 *
 * 一种水平轮播，旨在同时展示多个项目，以便快速浏览较小的内容，如专辑封面或照片缩略图。
 *
 * 请注意，此轮播可能会调整项目的大小，以确保大、中、小三种尺寸的项目能够完美适配可用空间，并以视觉上令人愉悦的方式排列。
 * 轮播随后使用大尺寸来布局项目，并根据项目的滚动偏移量进行裁切（或遮罩），从而创建出在大、中、小尺寸之间平滑展开和收缩的项目效果。
 *
 * 更多信息，请参阅 [design guidelines](https://m3.material.io/components/carousel/overview)
 *
 * @param 状态 用于控制轮播状态的状态对象。
 * @param 首选项宽度 大尺寸完全可见项目在水平轴上期望的宽度。此宽度仅为目标值，轮播可能会对其进行调整，以便在容器内容纳整数个项目。
 * 轮播首先调整小尺寸项目（在 [最小小项宽度] 和 [最大小项宽度] 之间），然后调整中等尺寸项目（如有），使其宽度介于小尺寸项目
 * 宽度和大尺寸项目宽度之间，最后在必要时调整大尺寸项目。
 * @param 修饰符 要应用于此轮播容器的修饰符实例。
 * @param 项间距 轮播中用于分隔项目的间距。
 * @param 抛掷行为 用于滚动后手势的 [TargetedFlingBehavior]。
 * @param 用户滚动已启用 是否允许通过用户手势或无障碍操作进行滚动。
 * @param 最小小项宽度 小尺寸项目允许的最小宽度，单位为 dp。根据 [首选项宽度] 和轮播宽度，小尺寸项目的宽度将在
 * [最小小项宽度] 和 [最大小项宽度] 范围内选取。
 * @param 最大小项宽度 小尺寸项目允许的最大宽度，单位为 dp。根据 [首选项宽度] 和轮播宽度，小尺寸项目的宽度将在
 * [最小小项宽度] 和 [最大小项宽度] 范围内选取。
 * @param 内容内边距 整个内容周围的内边距。这将在内容被裁切后添加内边距。可用于在第一个项目之前或最后一个项目之后添加内边距。
 * 使用 [项间距] 在各项之间添加间距。
 * @param 内容 轮播内容的可组合函数。
 */
@Suppress("ComposableNaming")
@Composable
fun 水平多浏览轮播(
    状态: CarouselState,
    首选项宽度: Dp,
    修饰符: Modifier = Modifier,
    项间距: Dp = 0.dp,
    抛掷行为: TargetedFlingBehavior = CarouselDefaults.singleAdvanceFlingBehavior(state = 状态),
    用户滚动已启用: Boolean = true,
    最小小项宽度: Dp = CarouselDefaults.MinSmallItemSize,
    最大小项宽度: Dp = CarouselDefaults.MaxSmallItemSize,
    内容内边距: PaddingValues = PaddingValues(0.dp),
    内容: @Composable CarouselItemScope.(itemIndex: Int) -> Unit,
) =
    HorizontalMultiBrowseCarousel(
        state = 状态,
        preferredItemWidth = 首选项宽度,
        modifier = 修饰符,
        itemSpacing = 项间距,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动已启用,
        minSmallItemWidth = 最小小项宽度,
        maxSmallItemWidth = 最大小项宽度,
        contentPadding = 内容内边距,
        content = 内容,
    )


/**
 * [Material Design Carousel](https://m3.material.io/components/carousel/overview)
 *
 * 一种水平轮播，以给定尺寸展示其项目，仅末尾有一个项目被截断。
 *
 * 请注意，项目尺寸受轮播尺寸限制。除此之外，此轮播会以给定尺寸尽可能多地布局项目，并改变末尾被截断项目的尺寸，
 * 使得项目在滚动至边缘时具有一定的运动范围。
 *
 * 更多信息，请参阅 [design guidelines](https://m3.material.io/components/carousel/overview)
 *
 * @param 状态 用于控制轮播状态的状态对象。
 * @param 项宽度 轮播中项目的宽度。
 * @param 修饰符 要应用于此轮播容器的修饰符实例。
 * @param 项间距 轮播中用于分隔项目的间距。
 * @param 抛掷行为 用于滚动后手势的 [TargetedFlingBehavior]。
 * @param 用户滚动已启用 是否允许通过用户手势或无障碍操作进行滚动。
 * @param 内容内边距 整个内容周围的内边距。这将在内容被裁切后添加内边距。可用于在第一个项目之前或最后一个项目之后添加内边距。
 * 使用 [项间距] 在各项之间添加间距。
 * @param 内容 轮播内容的可组合函数。
 */
@Suppress("ComposableNaming")
@Composable
fun 水平无约束轮播(
    状态: CarouselState,
    项宽度: Dp,
    修饰符: Modifier = Modifier,
    项间距: Dp = 0.dp,
    抛掷行为: TargetedFlingBehavior = CarouselDefaults.noSnapFlingBehavior(),
    用户滚动已启用: Boolean = true,
    内容内边距: PaddingValues = PaddingValues(0.dp),
    内容: @Composable CarouselItemScope.(itemIndex: Int) -> Unit,
) =
    HorizontalUncontainedCarousel(
        state = 状态,
        itemWidth = 项宽度,
        modifier = 修饰符,
        itemSpacing = 项间距,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动已启用,
        contentPadding = 内容内边距,
        content = 内容,
    )


/**
 * [Material Design Carousel](https://m3.material.io/components/carousel/overview)
 *
 * 一种水平轮播，在两个小尺寸项目之间居中至少放置一个大尺寸项目。
 *
 * @param 状态 用于控制轮播状态的状态对象。
 * @param 修饰符 要应用于此轮播容器的修饰符实例。
 * @param 最大项宽度 大尺寸项目允许的最大宽度，单位为 dp。默认值 [Dp.Unspecified] 允许单个大尺寸项目增长至填满整个
 * 视口减去两侧两个小尺寸项目的空间。非未指定的值将在空间允许时添加额外的大尺寸项目。若要允许项目按特定宽高比增长，可使用轮播
 * 的交叉轴尺寸乘以倍数（例如 `220.dp * 2` 表示最大宽高比为 2:1）。
 * @param 项间距 轮播中用于分隔项目的间距。
 * @param 抛掷行为 用于滚动后手势的 [TargetedFlingBehavior]。
 * @param 用户滚动已启用 是否允许通过用户手势或无障碍操作进行滚动。
 * @param 最小小项宽度 小尺寸项目允许的最小宽度，单位为 dp。
 * @param 最大小项宽度 小尺寸项目允许的最大宽度，单位为 dp。
 * @param 内容内边距 整个内容周围的内边距。这将在内容被裁切后添加内边距。可用于在第一个项目之前或最后一个项目之后添加内边距。
 * 使用 [项间距] 在各项之间添加间距。
 * @param 内容 轮播内容的可组合函数。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3Api
@Composable
fun 水平居中焦点轮播(
    状态: CarouselState,
    修饰符: Modifier = Modifier,
    最大项宽度: Dp = Dp.Unspecified,
    项间距: Dp = 0.dp,
    抛掷行为: TargetedFlingBehavior = CarouselDefaults.singleAdvanceFlingBehavior(state = 状态),
    用户滚动已启用: Boolean = true,
    最小小项宽度: Dp = CarouselDefaults.MinSmallItemSize,
    最大小项宽度: Dp = CarouselDefaults.MaxSmallItemSize,
    内容内边距: PaddingValues = PaddingValues(0.dp),
    内容: @Composable CarouselItemScope.(itemIndex: Int) -> Unit,
) =
    HorizontalCenteredHeroCarousel(
        state = 状态,
        modifier = 修饰符,
        maxItemWidth = 最大项宽度,
        itemSpacing = 项间距,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动已启用,
        minSmallItemWidth = 最小小项宽度,
        maxSmallItemWidth = 最大小项宽度,
        contentPadding = 内容内边距,
        content = 内容,
    )


/** 包含 [Carousel] 使用的默认值。 */
object 轮播默认值 { // CarouselDefaults

    /**
     * 一种 [TargetedFlingBehavior]，将每次抛掷限制为一个项目。[吸附动画规格] 可用于控制吸附动画。
     *
     * @param 状态 控制此 [TargetedFlingBehavior] 将应用于哪个轮播的 [CarouselState]。
     * @param 吸附动画规格 用于最终吸附到目标位置的动画规格。
     * @return 一种 [TargetedFlingBehavior] 实例，执行吸附到下一个项目。动画将由滚动后速度控制，轮播将使用
     * [吸附动画规格] 来接近吸附位置。
     */
    @Composable
    fun 单次推进抛掷行为(
        状态: CarouselState,
        吸附动画规格: AnimationSpec<Float> = spring(stiffness = Spring.StiffnessMediumLow),
    ): TargetedFlingBehavior =
        CarouselDefaults.singleAdvanceFlingBehavior(
            state = 状态,
            snapAnimationSpec = 吸附动画规格,
        )


    /**
     * 一种 [TargetedFlingBehavior]，以无限距离抛掷，并根据手势速度吸附到最终项目。
     *
     * 轮播可能会使用 [衰减动画规格] 或 [吸附动画规格] 来接近滚动后的目标项目（根据抛掷速度计算）。
     * 如果手势具有足够高的速度来接近目标项目，轮播将先使用 [衰减动画规格]，然后在动画的最后一步使用 [吸附动画规格]。
     * 如果手势速度不足，则将使用 [吸附动画规格] 直接到达吸附位置。
     *
     * @param 状态 控制此 [TargetedFlingBehavior] 将应用于哪个轮播的 [CarouselState]。
     * @param 衰减动画规格 用于当抛掷速度足够大以自然衰减时，接近目标偏移量的动画规格。
     * @param 吸附动画规格 用于最终吸附到目标位置的动画规格。
     * @return 一种 [TargetedFlingBehavior] 实例，基于手势速度执行抛掷，然后在抛掷后吸附到最近的项目。动画将由滚动后速度控制，
     * 轮播将使用 [吸附动画规格] 来接近吸附位置。
     */
    @Composable
    fun 多浏览抛掷行为(
        状态: CarouselState,
        衰减动画规格: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
        吸附动画规格: AnimationSpec<Float> = spring(stiffness = Spring.StiffnessMediumLow),
    ): TargetedFlingBehavior =
        CarouselDefaults.multiBrowseFlingBehavior(
            state = 状态,
            decayAnimationSpec = 衰减动画规格,
            snapAnimationSpec = 吸附动画规格,
        )

    /**
     * 一种 [TargetedFlingBehavior]，根据手势速度执行抛掷，抛掷后不进行吸附。
     *
     * @return 一种 [TargetedFlingBehavior] 实例，基于手势速度执行抛掷，抛掷后不会吸附到任何位置。
     */
    @Composable
    fun 无吸附抛掷行为(): TargetedFlingBehavior = CarouselDefaults.noSnapFlingBehavior()

    /** 轮播策略可选择其小尺寸项目的最小尺寸。 * */
    val 最小小项大小 = CarouselDefaults.MinSmallItemSize

    /** 轮播策略可选择其小尺寸项目的最大尺寸。 * */
    val 最大小项大小 = CarouselDefaults.MaxSmallItemSize

}
