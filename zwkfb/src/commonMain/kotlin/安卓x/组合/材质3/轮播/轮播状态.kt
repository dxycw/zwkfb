package 安卓x.组合.材质3.轮播

import androidx.annotation.FloatRange
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.carousel.CarouselItemDrawInfo
import androidx.compose.material3.carousel.CarouselState
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.geometry.Rect


/**
 * 可用于控制所有类型轮播的状态。
 *
 * @param 当前项 要滚动到的当前项目。
 * @param 当前项偏移量比例 当前项目的偏移量，以项目尺寸的分数表示。该值应在 -0.5 到 0.5 之间，表示当前项目相对于吸附位置的偏移程度。
 * @param 项数量 此轮播将拥有的项目数量。
 */
fun 轮播状态(
    当前项: Int = 0,
    @FloatRange(from = -0.5, to = 0.5) 当前项偏移量比例: Float = 0f,
    项数量: () -> Int,
) =
    CarouselState(
        currentItem = 当前项,
        currentItemOffsetFraction = 当前项偏移量比例,
        itemCount = 项数量,
    )


val CarouselState.是否正在滚动: Boolean
    get() = this.isScrollInProgress


/**
 * 最靠近吸附位置的项目。这是一个可观察值，当轮播通过手势或动画滚动时会发生变化。
 *
 * 有关更多信息，请参阅 [PagerState.currentPage]。
 */
val CarouselState.当前项: Int
    get() = this.currentItem


fun CarouselState.分发原始增量(增量: Float): Float =
    this.dispatchRawDelta(delta = 增量)


suspend fun CarouselState.滚动(
    滚动优先级: MutatePriority,
    块: suspend ScrollScope.() -> Unit,
) = this.scroll(scrollPriority = 滚动优先级, block = 块)


/**
 * 滚动（立即跳转）到指定的 [项]。
 *
 * @param 项 要滚动到的目标项目。
 */
suspend fun CarouselState.滚动到项(项: Int) = this.scrollToItem(item = 项)

/**
 * 滚动并动画到指定的 [项]。如果 [项] 距离 [currentItem] 太远，轮播会先跳转到较近的项目，然后再执行滚动动画，以避免组合所有中间项目。
 *
 * 请参阅示例以了解如何使用此 API。
 *
 * @param 项 要滚动到的项目的索引（带动画）。
 * @param 动画规格 用于在各项之间滚动的 [AnimationSpec]。
 */
suspend fun CarouselState.动画滚动到项(项: Int, 动画规格: AnimationSpec<Float> = spring()) =
    this.animateScrollToItem(item = 项, animationSpec = 动画规格)


object 轮播状态{

    /** 用于保存当前项目和项目偏移量。 */
    val 保存器: Saver<CarouselState, *> = CarouselState.Saver

}

/**
 * 创建一个在组合之间被记住的 [CarouselState]。
 *
 * @param 初始项 应滚动到的初始项目。
 * @param 项数量 此轮播将拥有的项目数量。
 */
@Composable
fun 记住轮播状态(初始项: Int = 0, 项数量: () -> Int): CarouselState =
    rememberCarouselState(initialItem = 初始项, itemCount = 项数量)


/** 用于保存轮播项及其尺寸信息的接口。*/
sealed interface 轮播项绘制信息 { // CarouselItemDrawInfo

    /** 轮播项在主轴方向上的尺寸，单位为像素。 */
    val 大小: Float // size

    /** 轮播项在主轴方向上的最小尺寸，单位为像素，例如项目滚动至轮播两侧时的尺寸。*/
    val 最小大小: Float // minSize

    /** 轮播项在主轴方向上的最大尺寸，单位为像素，例如项目处于焦点位置时的尺寸。*/
    val 最大大小: Float // maxSize

    /** 轮播项正在被裁切的 [Rect]。 */
    val 遮罩矩形: Rect // maskRect

}

/** 轮播项在主轴方向上的尺寸，单位为像素。 */
val CarouselItemDrawInfo.大小: Float
    get() = this.size

/** 轮播项在主轴方向上的最小尺寸，单位为像素，例如项目滚动至轮播两侧时的尺寸。*/
val CarouselItemDrawInfo.最小大小: Float
    get() = this.minSize

/** 轮播项在主轴方向上的最大尺寸，单位为像素，例如项目处于焦点位置时的尺寸。*/
val CarouselItemDrawInfo.最大大小: Float
    get() = this.maxSize

/** 轮播项正在被裁切的 [Rect]。 */
val CarouselItemDrawInfo.遮罩矩形: Rect
    get() = this.maskRect