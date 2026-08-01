package 自定义.组合.材质3.内部芯片

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
internal fun ChipContent(
    label: @Composable () -> Unit,
    labelTextStyle: TextStyle,
    labelColor: Color,
    leadingIcon: @Composable (() -> Unit)?,
    avatar: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    leadingIconColor: Color,
    trailingIconColor: Color,
    minHeight: Dp,
    horizontalArrangement: Arrangement.Horizontal,
    paddingValues: PaddingValues,
) {
    CompositionLocalProvider(
        LocalContentColor provides labelColor,
        LocalTextStyle provides labelTextStyle,
    ) {
        Row(
            modifier =
                Modifier.width(IntrinsicSize.Max)
                    .defaultMinSize(minHeight = minHeight)
                    .padding(paddingValues),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = horizontalArrangement,
            content = {
                if (avatar != null || leadingIcon != null) {
                    Box(
                        contentAlignment = Alignment.Center,
                        content = {
                            val leadingContent =
                                leadingContent(avatar, leadingIcon, leadingIconColor)
                            if (leadingContent != null) {
                                leadingContent()
                            }
                        },
                    )
                } else {
                    Spacer(modifier = Modifier.width(0.dp))
                }
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    content = { label() },
                )
                if (trailingIcon != null) {
                    Box(
                        contentAlignment = Alignment.Center,
                        content = {
                            val trailingContent = trailingContent(trailingIcon, trailingIconColor)
                            if (trailingContent != null) {
                                trailingContent()
                            }
                        },
                    )
                } else {
                    Spacer(modifier = Modifier.width(0.dp))
                }
            },
        )
    }
}


@Composable
internal fun AnimatingChipContent(
    label: @Composable () -> Unit,
    labelTextStyle: TextStyle,
    labelColor: Color,
    leadingIcon: @Composable (() -> Unit)?,
    avatar: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    leadingIconColor: Color,
    trailingIconColor: Color,
    minHeight: Dp,
    horizontalArrangement: Arrangement.Horizontal,
    paddingValues: PaddingValues,
    fadeInSpec: FiniteAnimationSpec<Float>,
    fadeOutSpec: FiniteAnimationSpec<Float>,
    expandSpec: FiniteAnimationSpec<IntSize>,
    shrinkSpec: FiniteAnimationSpec<IntSize>,
) {
    CompositionLocalProvider(
        LocalContentColor provides labelColor,
        LocalTextStyle provides labelTextStyle,
    ) {
        Row(
            modifier =
                Modifier.widthIn(max = maxChipWidth)
                    .defaultMinSize(minHeight = minHeight)
                    .padding(paddingValues),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = horizontalArrangement,
            content = {
                Box {
                    this@Row.AnimatedVisibility(
                        visible = avatar != null || leadingIcon != null,
                        enter =
                            expandHorizontally(
                                animationSpec = expandSpec,
                                expandFrom = Alignment.Start,
                            ) + fadeIn(animationSpec = fadeInSpec),
                        exit =
                            shrinkHorizontally(
                                animationSpec = shrinkSpec,
                                shrinkTowards = Alignment.Start,
                            ) + fadeOut(animationSpec = fadeOutSpec),
                    ) {
                        val leadingContentRetainedState =
                            rememberRetainedState(
                                targetValue = leadingContent(avatar, leadingIcon, leadingIconColor)
                            )
                        Box(contentAlignment = Alignment.Center) {
                            leadingContentRetainedState.value?.invoke()
                        }
                    }
                    if (avatar == null && leadingIcon == null) {
                        Spacer(modifier = Modifier.width(0.dp))
                    }
                }

                Row(
                    modifier = Modifier.weight(1f, fill = false),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    content = { label() },
                )

                Box {
                    this@Row.AnimatedVisibility(
                        visible = trailingIcon != null,
                        enter =
                            expandHorizontally(
                                animationSpec = expandSpec,
                                expandFrom = Alignment.End,
                            ) + fadeIn(animationSpec = fadeInSpec),
                        exit =
                            shrinkHorizontally(
                                animationSpec = shrinkSpec,
                                shrinkTowards = Alignment.End,
                            ) + fadeOut(animationSpec = fadeOutSpec),
                    ) {
                        val trailingContentRetainedState =
                            rememberRetainedState(
                                targetValue = trailingContent(trailingIcon, trailingIconColor)
                            )
                        Box(contentAlignment = Alignment.Center) {
                            trailingContentRetainedState.value?.invoke()
                        }
                    }
                    if (trailingIcon == null) {
                        Spacer(modifier = Modifier.width(0.dp))
                    }
                }
            },
        )
    }
}

//=======================================================================================

/**
 * Returns the actual leading content lambda based on priority (avatar > leadingIcon) and applied
 * with the given content color.
 */
@Composable
private fun leadingContent(
    avatar: @Composable (() -> Unit)?,
    leadingIcon: @Composable (() -> Unit)?,
    leadingIconColor: Color,
): @Composable (() -> Unit)? =
    when {
        avatar != null -> avatar // An avatar takes precedence
        leadingIcon != null -> {
            @Composable {
                CompositionLocalProvider(
                    LocalContentColor provides leadingIconColor,
                    content = leadingIcon,
                )
            }
        }
        else -> null // Neither exists
    }


/** Returns the trailing content lambda applied with the given content color. */
@Composable
private fun trailingContent(
    trailingIcon: @Composable (() -> Unit)?,
    trailingIconColor: Color,
): @Composable (() -> Unit)? =
    if (trailingIcon != null) {
        @Composable {
            CompositionLocalProvider(
                LocalContentColor provides trailingIconColor,
                content = trailingIcon,
            )
        }
    } else {
        null
    }


//================================================================================

@Composable
private fun <T> rememberRetainedState(targetValue: T?): State<T?> {
    val retainedState = remember { mutableStateOf(targetValue) }
    if (targetValue != null) {
        retainedState.value = targetValue
    }
    return retainedState
}

//================================================================================

/**
 * Max width for a chip. This is required to allow animations with Row and have expected behavior in
 * the case where the chip is within a scrolling container.
 */
private val maxChipWidth = 1000.dp
