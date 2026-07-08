package 安卓x.组合.材质3.令牌集


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

internal object SheetBottomTokens {
    val DockedContainerColor = ColorSchemeKeyTokens.SurfaceContainerLow
    val DockedContainerShape = RoundedCornerShape(
        topStart = 28.dp,   // 对应 CornerExtraLargeTop
        topEnd = 28.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )
    val DockedDragHandleColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val DockedDragHandleHeight = 4.0.dp
    val DockedDragHandleWidth = 32.0.dp
    val DockedMinimizedContainerShape = RectangleShape
    val DockedModalContainerElevation = ElevationTokens.Level1
    val DockedStandardContainerElevation = ElevationTokens.Level1
    val FocusIndicatorColor = ColorSchemeKeyTokens.Secondary
}
