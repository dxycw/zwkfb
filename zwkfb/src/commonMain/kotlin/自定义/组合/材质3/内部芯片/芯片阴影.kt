package 自定义.组合.材质3.内部芯片

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.material3.ChipElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp


/**
 * Represents the shadow elevation used in a chip, depending on its [enabled] state and
 * [interactionSource].
 *
 * Shadow elevation is used to apply a shadow around the chip to give it higher emphasis.
 *
 * @param enabled whether the chip is enabled
 * @param interactionSource the [InteractionSource] for this chip
 */
@Composable
internal fun ChipElevation.shadowElevation(
    enabled: Boolean,
    interactionSource: InteractionSource,
): State<Dp> {
    return animateElevation(enabled = enabled, interactionSource = interactionSource)
}

@Composable
private fun ChipElevation.animateElevation(
    enabled: Boolean,
    interactionSource: InteractionSource,
): State<Dp> {
    val interactions = remember { mutableStateListOf<Interaction>() }
    var lastInteraction by remember { mutableStateOf<Interaction?>(null) }
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is HoverInteraction.Enter -> {
                    interactions.add(interaction)
                }
                is HoverInteraction.Exit -> {
                    interactions.remove(interaction.enter)
                }
                is FocusInteraction.Focus -> {
                    interactions.add(interaction)
                }
                is FocusInteraction.Unfocus -> {
                    interactions.remove(interaction.focus)
                }
                is PressInteraction.Press -> {
                    interactions.add(interaction)
                }
                is PressInteraction.Release -> {
                    interactions.remove(interaction.press)
                }
                is PressInteraction.Cancel -> {
                    interactions.remove(interaction.press)
                }
                is DragInteraction.Start -> {
                    interactions.add(interaction)
                }
                is DragInteraction.Stop -> {
                    interactions.remove(interaction.start)
                }
                is DragInteraction.Cancel -> {
                    interactions.remove(interaction.start)
                }
            }
        }
    }

    val interaction = interactions.lastOrNull()

    val target =
        if (!enabled) {
            disabledElevation
        } else {
            when (interaction) {
                is PressInteraction.Press -> pressedElevation
                is HoverInteraction.Enter -> hoveredElevation
                is FocusInteraction.Focus -> focusedElevation
                is DragInteraction.Start -> draggedElevation
                else -> elevation
            }
        }

    val animatable = remember { Animatable(target, Dp.VectorConverter) }

    LaunchedEffect(target) {
        if (animatable.targetValue != target) {
            if (!enabled) {
                // No transition when moving to a disabled state
                animatable.snapTo(target)
            } else {
                animatable.animateElevation(
                    from = lastInteraction,
                    to = interaction,
                    target = target,
                )
            }
            lastInteraction = interaction
        }
    }

    return animatable.asState()
}

private suspend fun Animatable<Dp, *>.animateElevation(
    target: Dp,
    from: Interaction? = null,
    to: Interaction? = null,
) {
    val spec =
        when {
            // Moving to a new state
            to != null -> ElevationDefaults.incomingAnimationSpecForInteraction(to)
            // Moving to default, from a previous state
            from != null -> ElevationDefaults.outgoingAnimationSpecForInteraction(from)
            // Loading the initial state, or moving back to the baseline state from a disabled /
            // unknown state, so just snap to the final value.
            else -> null
        }
    if (spec != null) animateTo(target, spec) else snapTo(target)
}

//================================================================================


/**
 * Contains default [AnimationSpec]s used for animating elevation between different [Interaction]s.
 *
 * Typically you should use [animateElevation] instead, which uses these [AnimationSpec]s
 * internally. [animateElevation] in turn is used by the defaults for cards and buttons.
 *
 * @see animateElevation
 */
internal object ElevationDefaults {
    /**
     * Returns the [AnimationSpec]s used when animating elevation to [interaction], either from a
     * previous [Interaction], or from the default state. If [interaction] is unknown, then returns
     * `null`.
     *
     * @param interaction the [Interaction] that is being animated to
     */
    fun incomingAnimationSpecForInteraction(interaction: Interaction): AnimationSpec<Dp>? {
        return when (interaction) {
            is PressInteraction.Press -> DefaultIncomingSpec
            is DragInteraction.Start -> DefaultIncomingSpec
            is HoverInteraction.Enter -> DefaultIncomingSpec
            is FocusInteraction.Focus -> DefaultIncomingSpec
            else -> null
        }
    }

    /**
     * Returns the [AnimationSpec]s used when animating elevation away from [interaction], to the
     * default state. If [interaction] is unknown, then returns `null`.
     *
     * @param interaction the [Interaction] that is being animated away from
     */
    fun outgoingAnimationSpecForInteraction(interaction: Interaction): AnimationSpec<Dp>? {
        return when (interaction) {
            is PressInteraction.Press -> DefaultOutgoingSpec
            is DragInteraction.Start -> DefaultOutgoingSpec
            is HoverInteraction.Enter -> HoveredOutgoingSpec
            is FocusInteraction.Focus -> DefaultOutgoingSpec
            else -> null
        }
    }
}

//================================================================================

private val OutgoingSpecEasing: Easing = CubicBezierEasing(0.40f, 0.00f, 0.60f, 1.00f)

private val DefaultIncomingSpec = TweenSpec<Dp>(durationMillis = 120, easing = FastOutSlowInEasing)

private val DefaultOutgoingSpec = TweenSpec<Dp>(durationMillis = 150, easing = OutgoingSpecEasing)

private val HoveredOutgoingSpec = TweenSpec<Dp>(durationMillis = 120, easing = OutgoingSpecEasing)
