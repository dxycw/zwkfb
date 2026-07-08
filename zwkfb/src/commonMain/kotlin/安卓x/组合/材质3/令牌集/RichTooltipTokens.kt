package 安卓x.组合.材质3.令牌集

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

internal object RichTooltipTokens {
    val ActionFocusLabelTextColor = ColorSchemeKeyTokens.Primary
    val ActionHoverLabelTextColor = ColorSchemeKeyTokens.Primary
    val ActionLabelTextColor = ColorSchemeKeyTokens.Primary
    val ActionLabelTextFont
        @Composable
        get() = MaterialTheme.typography.labelLarge
    val ActionPressedLabelTextColor = ColorSchemeKeyTokens.Primary
    val ContainerColor = ColorSchemeKeyTokens.SurfaceContainer
    val ContainerElevation = ElevationTokens.Level2
    val ContainerShape
        @Composable
        get() = MaterialTheme.shapes.medium

    val SubheadColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val SubheadFont
        @Composable
        get() = MaterialTheme.typography.titleSmall
    val SupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant
    val SupportingTextFont
        @Composable
        get() = MaterialTheme.typography.bodyMedium
}
