package 安卓x.组合.材质3

import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

/**
 * [Material Design divider](https://m3.material.io/components/divider/overview)
 *
 * 分隔线是将列表和布局中的内容分组的细线。
 *
 * ![Divider image](https://developer.android.com/images/reference/androidx/compose/material3/divider.png)
 *
 * @param 修饰符 要应用于此分隔线的[Modifier]。
 * @param 厚度 此分隔线的粗细。使用 [Dp.Hairline] 将生成一个单像素分隔线，不受屏幕密度影响。
 * @param 颜色 这条分隔线的颜色。
 */
@Suppress("ComposableNaming")
@Composable
fun 水平分隔线(
    修饰符: Modifier = Modifier,
    厚度: Dp = DividerDefaults.Thickness,
    颜色: Color = DividerDefaults.color,
) =
    HorizontalDivider(
        modifier = 修饰符,
        thickness = 厚度,
        color = 颜色,
    )

/**
 * [Material Design divider](https://m3.material.io/components/divider/overview)
 *
 * 分隔线是将列表和布局中的内容分组的细线。
 *
 * ![Divider image](https://developer.android.com/images/reference/androidx/compose/material3/divider.png)
 *
 * @param 修饰符 要应用于此分隔线的[Modifier]。
 * @param 厚度 该分隔线的粗细。使用 [Dp.Hairline] 将产生**单像素**分隔线，且不受屏幕密度影响。
 * @param 颜色 这条分隔线的颜色。
 */
@Suppress("ComposableNaming")
@Composable
fun 垂直分隔线(
    修饰符: Modifier = Modifier,
    厚度: Dp = DividerDefaults.Thickness,
    颜色: Color = DividerDefaults.color,
) =
    VerticalDivider(
        modifier = 修饰符,
        thickness = 厚度,
        color = 颜色,
    )

@Suppress("ComposableNaming")
@Deprecated(
    message = "Renamed to HorizontalDivider",
    replaceWith = ReplaceWith("HorizontalDivider(modifier, thickness, color)"),
)
@Composable
fun 分隔线(
    修饰符: Modifier = Modifier,
    厚度: Dp = DividerDefaults.Thickness,
    颜色: Color = DividerDefaults.color,
) {
    Divider(
        modifier = 修饰符,
        thickness = 厚度,
        color = 颜色
    )
}

/** [分隔线] 的默认值 */
object 分隔线默认值 { // DividerDefaults

    /** 分隔线的默认粗细。" */
    val 厚度: Dp = DividerDefaults.Thickness

    /** 分隔线的默认颜色。 */
    val 颜色: Color
        @Composable get() = DividerDefaults.color

}
