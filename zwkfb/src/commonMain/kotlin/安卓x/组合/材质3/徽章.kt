package 安卓x.组合.材质3

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Material Design 徽章盒子。
 *
 * 徽章用于表示动态信息，例如导航栏中待处理请求的数量。
 *
 * 徽章可以仅包含图标，也可以包含简短文本。
 *
 * ![Badge image](https://developer.android.com/images/reference/androidx/compose/material3/badge.png)
 *
 * 一个常见的用例是在导航栏项中显示徽章。有关更多信息，请参阅 [Navigation Bar](https://m3.material.io/components/navigation-bar/overview)
 *
 * 带有徽章的简单图标示例如下：
 *
 * @param 徽章 要显示的徽章 —— 通常是一个 [Badge]。
 * @param 修饰符 要应用于此 徽章盒子 的 [Modifier]。
 * @param 内容 此徽章将定位到的锚点。
 */
@Suppress("ComposableNaming")
@Composable
fun 徽章盒子(
    徽章: @Composable BoxScope.() -> Unit,
    修饰符: Modifier = Modifier,
    内容: @Composable BoxScope.() -> Unit,
) {
    BadgedBox(
        badge = 徽章,
        modifier = 修饰符,
        content = 内容,
    )
}

/**
 * 徽章用于表示动态信息，例如导航栏中待处理请求的数量。
 *
 * 徽章可以仅包含图标，也可以包含简短文本。
 *
 * ![Badge image](https://developer.android.com/images/reference/androidx/compose/material3/badge.png)
 *
 * 请参阅 [徽章盒子]，这是一个顶层布局，可将徽章相对于内容（如文本或图标）正确放置。
 *
 * @param 修饰符 要应用于此徽章的 [Modifier]。
 * @param 容器颜色 用于此徽章背景的色值。
 * @param 内容颜色 徽章内部内容的首选颜色。默认情况下，如果 [容器颜色] 是主题中的颜色，则使用与 [容器颜色] 匹配的内容颜色；
 * 如果 [容器颜色] 不是主题中的颜色，则使用当前的 [LocalContentColor]。
 * @param 内容 可选的，要在此徽章内部渲染的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 徽章(
    修饰符: Modifier = Modifier,
    容器颜色: Color = BadgeDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    内容: @Composable (RowScope.() -> Unit)? = null,
) {
    Badge(
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        content = 内容,
    )
}

/** 用于 [Badge] 实现的默认值。 */
object 徽章默认值 { // BadgeDefaults

    /** 徽章的默认容器颜色。 */
    val 容器颜色: Color
        @Composable get() = BadgeDefaults.containerColor

}
