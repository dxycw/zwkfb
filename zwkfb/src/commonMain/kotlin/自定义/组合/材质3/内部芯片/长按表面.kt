package 自定义.组合.材质3.内部芯片

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalRippleThemeConfiguration
import androidx.compose.material3.LocalTonalElevationEnabled
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RippleThemeConfiguration
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.material3.ripple
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.node.SemanticsModifierNode
import androidx.compose.ui.node.TraversableNode
import androidx.compose.ui.node.invalidateSemantics
import androidx.compose.ui.node.traverseAncestors
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Suppress("ComposableNaming")
@Composable
@NonRestartableComposable
internal fun 表面(
    单击回调: () -> Unit,
    长按回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = RectangleShape,
    颜色: Color = MaterialTheme.colorScheme.surface,
    内容颜色: Color = contentColorFor(颜色),
    色调阴影: Dp = 0.dp,
    视觉阴影: Dp = 0.dp,
    边框: BorderStroke? = null,
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = 交互源 ?: remember { MutableInteractionSource() }
    val absoluteElevation = LocalAbsoluteTonalElevation.current + 色调阴影
    CompositionLocalProvider(
        LocalContentColor provides 内容颜色,
        LocalAbsoluteTonalElevation provides absoluteElevation,
    ) {
        Box(
            modifier =
                修饰符.minimumInteractiveComponentSize()
                    .then(
                        if (
                            LocalRippleThemeConfiguration.current.focus
                                    is RippleThemeConfiguration.Focus.InsetRing
                        ) {
                            Modifier.indication(
                                interactionSource = interactionSource,
                                indication =
                                    ripple(
                                        focusRingShape = 形状,
                                        enablePressIndication = false,
                                        enableFocusIndication = true,
                                        enableDragIndication = false,
                                        enableHoverIndication = false,
                                    ),
                            )
                        } else {
                            Modifier
                        }
                    )
                    .surface(
                        shape = 形状,
                        backgroundColor =
                            surfaceColorAtElevation(color = 颜色, elevation = absoluteElevation),
                        border = 边框,
                        shadowElevation = with(LocalDensity.current) { 视觉阴影.toPx() },
                    )
                    .combinedClickable(
                        interactionSource = interactionSource,
                        indication =
                            ripple(
                                focusRingShape = 形状,
                                enableFocusIndication =
                                    LocalRippleThemeConfiguration.current.focus
                                            !is RippleThemeConfiguration.Focus.InsetRing,
                            ),
                        enabled = 已启用,
                        onClick = 单击回调,
                        onLongClick = 长按回调,
                    )
                    .childSemantics(),
            propagateMinConstraints = true,
        ) {
            内容()
        }
    }
}



//=======================================================================================


private fun Modifier.childSemantics(properties: SemanticsPropertyReceiver.() -> Unit = {}) =
    this then ChildSemanticsNodeElement(properties)
private class ChildSemanticsNodeElement(val properties: SemanticsPropertyReceiver.() -> Unit) :
    ModifierNodeElement<ChildSemanticsNode>() {
    override fun create(): ChildSemanticsNode = ChildSemanticsNode(properties)

    override fun update(node: ChildSemanticsNode) {
        node.properties = properties
        node.invalidateSemantics()
    }

    override fun InspectorInfo.inspectableProperties() {
        name = "childSemantics"
        this@inspectableProperties.properties["properties"] =
            this@ChildSemanticsNodeElement.properties
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChildSemanticsNodeElement) return false

        return properties === other.properties
    }

    override fun hashCode(): Int {
        return properties.hashCode()
    }
}


private class ParentSemanticsNodeElement(val properties: SemanticsPropertyReceiver.() -> Unit) :
    ModifierNodeElement<ParentSemanticsNode>() {
    override fun create(): ParentSemanticsNode = ParentSemanticsNode(properties)

    override fun update(node: ParentSemanticsNode) {
        node.properties = properties
        node.invalidateSemantics()
    }

    override fun InspectorInfo.inspectableProperties() {
        name = "parentSemantics"
        this@inspectableProperties.properties["properties"] =
            this@ParentSemanticsNodeElement.properties
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ParentSemanticsNodeElement) return false

        return properties === other.properties
    }

    override fun hashCode(): Int {
        return properties.hashCode()
    }
}

private class ChildSemanticsNode(var properties: SemanticsPropertyReceiver.() -> Unit) :
    Modifier.Node(), SemanticsModifierNode {

    override fun SemanticsPropertyReceiver.applySemantics() {
        traverseAncestors(ParentSemanticsNodeKey) { node ->
            with(node as ParentSemanticsNode) {
                obtainSemantics()
                false
            }
        }
        properties()
    }

    override fun onDetach() {
        super.onDetach()
        traverseAncestors(ParentSemanticsNodeKey) { node ->
            (node as ParentSemanticsNode)
            node.releaseSemantics()
            false
        }
    }
}

private class ParentSemanticsNode(var properties: SemanticsPropertyReceiver.() -> Unit) :
    Modifier.Node(), TraversableNode, SemanticsModifierNode {

    private var semanticsConsumed: Boolean = false

    override val shouldMergeDescendantSemantics: Boolean
        get() = true

    override val traverseKey: Any = ParentSemanticsNodeKey

    override fun SemanticsPropertyReceiver.applySemantics() {
        if (!semanticsConsumed) {
            properties()
        }
    }

    fun SemanticsPropertyReceiver.obtainSemantics() {
        semanticsConsumed = true
        properties()
        invalidateSemantics()
    }

    fun releaseSemantics() {
        semanticsConsumed = false
        invalidateSemantics()
    }
}

private object ParentSemanticsNodeKey



@Stable
private fun Modifier.surface(
    shape: Shape,
    backgroundColor: Color,
    border: BorderStroke?,
    shadowElevation: Float,
) =
    this.then(
        if (shadowElevation > 0f) {
            Modifier.graphicsLayer(
                shadowElevation = shadowElevation,
                shape = shape,
                clip = false,
            )
        } else {
            Modifier
        }
    )
        .then(if (border != null) Modifier.border(border, shape) else Modifier)
        .background(color = backgroundColor, shape = shape)
        .clip(shape)

@Composable
private fun surfaceColorAtElevation(color: Color, elevation: Dp): Color =
    MaterialTheme.colorScheme.applyTonalElevation(color, elevation)

/**
 * Returns [ColorScheme.surfaceColorAtElevation] with the provided elevation if
 * [LocalTonalElevationEnabled] is set to true, and the provided background color matches
 * [ColorScheme.surface]. Otherwise, the provided color is returned unchanged.
 *
 * @param backgroundColor The background color to compare to [ColorScheme.surface]
 * @param elevation The elevation provided to [ColorScheme.surfaceColorAtElevation] if
 *   [backgroundColor] matches surface.
 * @return [ColorScheme.surfaceColorAtElevation] at [elevation] if [backgroundColor] ==
 *   [ColorScheme.surface] and [LocalTonalElevationEnabled] is set to true. Else [backgroundColor]
 */
@Composable
@ReadOnlyComposable
private fun ColorScheme.applyTonalElevation(backgroundColor: Color, elevation: Dp): Color {
    val tonalElevationEnabled = LocalTonalElevationEnabled.current
    return if (backgroundColor == surface && tonalElevationEnabled) {
        surfaceColorAtElevation(elevation)
    } else {
        backgroundColor
    }
}
