package 安卓x.组合.材质3

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scrim
import androidx.compose.material3.ScrimDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * 一种遮罩层，用于遮挡模态表面后方的内容。
 *
 * @param 内容描述 供无障碍服务使用的文本，用于描述此遮罩层可以关闭的内容。除非该遮罩层仅用于装饰目的且 [单击回调]
 * 为 `null`，否则应始终提供此值。
 * @param 修饰符 遮罩层的可选 [Modifier]。
 * @param 单击回调 当用户点击遮罩层时调用的可选回调。若设为 `null`，则不提供点击语义。
 * @param 透明度 要应用到 [颜色] 的不透明度，范围从 0.0f（完全透明）到 1.0f（完全不透明）。该值始终被强制限定在 0.0f 和 1.0f 之间。
 * @param 颜色 遮罩层的颜色。该遮罩层要被绘制，此颜色不得为 [Color.Unspecified]。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 遮罩(
    内容描述: String?,
    修饰符: Modifier = Modifier,
    单击回调: (() -> Unit)? = {},
    透明度: () -> Float = { 1f },
    颜色: Color = ScrimDefaults.color,
) =
    Scrim(
        contentDescription = 内容描述,
        modifier = 修饰符,
        onClick = 单击回调,
        alpha = 透明度,
        color = 颜色,
    )


/** 包含 [遮罩] 组件默认值的对象。 */
object 遮罩默认值 { // ScrimDefaults

    /** [遮罩] 的默认颜色和不透明度。 */
    val 颜色: Color
        @Composable
        @ReadOnlyComposable
        get() = ScrimDefaults.color

}
