package 自定义.组合.材质3.内部芯片

import androidx.compose.material3.ChipColors
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

/**
 * Represents the container color for this chip, depending on [enabled].
 *
 * @param enabled whether the chip is enabled
 */
@Stable
internal fun ChipColors.containerColor(enabled: Boolean): Color =
    if (enabled) containerColor else disabledContainerColor

/**
 * Represents the label color for this chip, depending on [enabled].
 *
 * @param enabled whether the chip is enabled
 */
@Stable
internal fun ChipColors.labelColor(enabled: Boolean): Color =
    if (enabled) labelColor else disabledLabelColor

/**
 * Represents the leading icon's content color for this chip, depending on [enabled].
 *
 * @param enabled whether the chip is enabled
 */
@Stable
internal fun ChipColors.leadingIconContentColor(enabled: Boolean): Color =
    if (enabled) leadingIconContentColor else disabledLeadingIconContentColor

/**
 * Represents the trailing icon's content color for this chip, depending on [enabled].
 *
 * @param enabled whether the chip is enabled
 */
@Stable
internal fun ChipColors.trailingIconContentColor(enabled: Boolean): Color =
    if (enabled) trailingIconContentColor else disabledTrailingIconContentColor
