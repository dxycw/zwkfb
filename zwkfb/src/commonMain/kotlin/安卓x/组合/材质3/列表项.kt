package 安卓x.组合.材质3

//import androidx.compose.material3.Checkbox
//import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
//import androidx.compose.material3.ListItemColors
//import androidx.compose.material3.ListItemDefaults
//import androidx.compose.material3.ListItemElevation
//import androidx.compose.material3.ListItemShapes
//import androidx.compose.material3.RadioButton
//import androidx.compose.foundation.interaction.Interaction
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.material3.ListItem
//import androidx.compose.material3.SegmentedListItem
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.Dp
//
//
//
///**
// * [Material Design list item](https://m3.material.io/components/lists/overview)
// *
// * Lists are continuous, vertical indexes of text or images.
// *
// * This overload of list item does not handle any user interaction. See other overloads for handling
// * general click actions, single-selection, or multi-selection.
// *
// * ![Lists image](https://developer.android.com/images/reference/androidx/compose/material3/lists.png)
// *
// * This component can be used to achieve the list item templates existing in the spec. One-line list
// * items have a singular line of headline content. Two-line list items additionally have either
// * supporting or overline content. Three-line list items have either both supporting and overline
// * content, or extended (two-line) supporting text. For example:
// * - one-line item
// *
// * @param headlineContent the headline content of the list item
// * @param modifier [Modifier] to be applied to the list item
// * @param overlineContent the content displayed above the headline content
// * @param supportingContent the supporting content of the list item
// * @param leadingContent the leading content of the list item
// * @param trailingContent the trailing meta text, icon, switch or checkbox
// * @param colors [ListItemColors] that will be used to resolve the background and content color for
// *   this list item in different states. See [ListItemDefaults.colors]
// * @param tonalElevation the tonal elevation of this list item
// * @param shadowElevation the shadow elevation of this list item
// */
//@Suppress("ComposableNaming")
//@Composable
//fun 列表项(
//    headlineContent: @Composable () -> Unit,
//    modifier: Modifier = Modifier,
//    overlineContent: @Composable (() -> Unit)? = null,
//    supportingContent: @Composable (() -> Unit)? = null,
//    leadingContent: @Composable (() -> Unit)? = null,
//    trailingContent: @Composable (() -> Unit)? = null,
//    colors: ListItemColors = ListItemDefaults.colors(),
//    tonalElevation: Dp = ListItemDefaults.Elevation,
//    shadowElevation: Dp = ListItemDefaults.Elevation,
//) =
//    ListItem(
//        headlineContent = headlineContent,
//        modifier = modifier,
//        overlineContent = overlineContent,
//        supportingContent = supportingContent,
//        leadingContent = leadingContent,
//        trailingContent = trailingContent,
//        colors = colors,
//        tonalElevation = tonalElevation,
//        shadowElevation = shadowElevation,
//    )
//
//
///**
// * [Material Design standard list item](https://m3.material.io/components/lists/overview)
// *
// * Lists are continuous, vertical indexes of text or images.
// *
// * This overload of [ListItem] handles click events, calling its [onClick] lambda to trigger an
// * action. See other overloads for handling single-selection, multi-selection, or no interaction
// * handling.
// *
// * @param onClick called when this list item is clicked.
// * @param modifier the [Modifier] to be applied to this list item.
// * @param enabled controls the enabled state of this list item. When `false`, this component will
// *   not respond to user input, and it will appear visually disabled and disabled to accessibility
// *   services.
// * @param leadingContent the leading content of this list item, such as an icon or avatar.
// * @param trailingContent the trailing content of this list item, such as a checkbox, switch, or
// *   icon.
// * @param overlineContent the content displayed above the main content of the list item.
// * @param supportingContent the content displayed below the main content of the list item.
// * @param verticalAlignment the vertical alignment of children within the list item, after
// *   accounting for [contentPadding].
// * @param onLongClick called when this list item is long clicked (long-pressed).
// * @param onLongClickLabel semantic / accessibility label for the [onLongClick] action.
// * @param shapes the [ListItemShapes] that this list item will use to morph between depending on the
// *   user's interaction with the list item. See [ListItemDefaults.shapes].
// * @param colors the [ListItemColors] that will be used to resolve the colors used for this list
// *   item in different states. See [ListItemDefaults.colors].
// * @param elevation the [ListItemElevation] used to resolve the elevation for this list item in
// *   different states. See [ListItemDefaults.elevation].
// * @param contentPadding the padding to be applied to the content of this list item.
// * @param interactionSource an optional hoisted [MutableInteractionSource] for observing and
// *   emitting [Interaction]s for this list item. You can use this to change the list item's
// *   appearance or preview the list item in different states. Note that if `null` is provided,
// *   interactions will still happen internally.
// * @param content the main content of this list item. Also known as the headline or label.
// */
//@Suppress("ComposableNaming")
//@ExperimentalMaterial3ExpressiveApi
//@Composable
//fun 列表项(
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    leadingContent: @Composable (() -> Unit)? = null,
//    trailingContent: @Composable (() -> Unit)? = null,
//    overlineContent: @Composable (() -> Unit)? = null,
//    supportingContent: @Composable (() -> Unit)? = null,
//    verticalAlignment: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
//    onLongClick: (() -> Unit)? = null,
//    onLongClickLabel: String? = null,
//    shapes: ListItemShapes = ListItemDefaults.shapes(),
//    colors: ListItemColors = ListItemDefaults.colors(),
//    elevation: ListItemElevation = ListItemDefaults.elevation(),
//    contentPadding: PaddingValues = ListItemDefaults.ContentPadding,
//    interactionSource: MutableInteractionSource? = null,
//    content: @Composable () -> Unit,
//) =
//    ListItem(
//        onClick = onClick,
//        modifier = modifier,
//        enabled = enabled,
//        leadingContent = leadingContent,
//        trailingContent = trailingContent,
//        overlineContent = overlineContent,
//        supportingContent = supportingContent,
//        verticalAlignment = verticalAlignment,
//        onLongClick = onLongClick,
//        onLongClickLabel = onLongClickLabel,
//        shapes = shapes,
//        colors = colors,
//        elevation = elevation,
//        contentPadding = contentPadding,
//        interactionSource = interactionSource,
//        content = content
//    )
//
///**
// * [Material Design standard list item](https://m3.material.io/components/lists/overview)
// *
// * Lists are continuous, vertical indexes of text or images.
// *
// * This overload of [ListItem] represents a single-selection item, analogous to a [RadioButton]. See
// * other overloads for handling general click actions, multi-selection, or no interaction handling.
// *
// * @param selected whether or not this list item is selected.
// * @param onClick called when this list item is clicked.
// * @param modifier the [Modifier] to be applied to this list item.
// * @param enabled controls the enabled state of this list item. When `false`, this component will
// *   not respond to user input, and it will appear visually disabled and disabled to accessibility
// *   services.
// * @param leadingContent the leading content of this list item, such as an icon or avatar.
// * @param trailingContent the trailing content of this list item, such as a checkbox, switch, or
// *   icon.
// * @param overlineContent the content displayed above the main content of the list item.
// * @param supportingContent the content displayed below the main content of the list item.
// * @param verticalAlignment the vertical alignment of children within the list item, after
// *   accounting for [contentPadding].
// * @param onLongClick called when this list item is long clicked (long-pressed).
// * @param onLongClickLabel semantic / accessibility label for the [onLongClick] action.
// * @param shapes the [ListItemShapes] that this list item will use to morph between depending on the
// *   user's interaction with the list item. See [ListItemDefaults.shapes].
// * @param colors the [ListItemColors] that will be used to resolve the colors used for this list
// *   item in different states. See [ListItemDefaults.colors].
// * @param elevation the [ListItemElevation] used to resolve the elevation for this list item in
// *   different states. See [ListItemDefaults.elevation].
// * @param contentPadding the padding to be applied to the content of this list item.
// * @param interactionSource an optional hoisted [MutableInteractionSource] for observing and
// *   emitting [Interaction]s for this list item. You can use this to change the list item's
// *   appearance or preview the list item in different states. Note that if `null` is provided,
// *   interactions will still happen internally.
// * @param content the main content of this list item. Also known as the headline or label.
// */
//@Suppress("ComposableNaming")
//@ExperimentalMaterial3ExpressiveApi
//@Composable
//fun 列表项(
//    selected: Boolean,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    leadingContent: @Composable (() -> Unit)? = null,
//    trailingContent: @Composable (() -> Unit)? = null,
//    overlineContent: @Composable (() -> Unit)? = null,
//    supportingContent: @Composable (() -> Unit)? = null,
//    verticalAlignment: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
//    onLongClick: (() -> Unit)? = null,
//    onLongClickLabel: String? = null,
//    shapes: ListItemShapes = ListItemDefaults.shapes(),
//    colors: ListItemColors = ListItemDefaults.colors(),
//    elevation: ListItemElevation = ListItemDefaults.elevation(),
//    contentPadding: PaddingValues = ListItemDefaults.ContentPadding,
//    interactionSource: MutableInteractionSource? = null,
//    content: @Composable () -> Unit,
//) =
//    ListItem(
//        selected = selected,
//        onClick = onClick,
//        modifier = modifier,
//        enabled = enabled,
//        leadingContent = leadingContent,
//        trailingContent = trailingContent,
//        overlineContent = overlineContent,
//        supportingContent = supportingContent,
//        verticalAlignment = verticalAlignment,
//        onLongClick = onLongClick,
//        onLongClickLabel = onLongClickLabel,
//        shapes = shapes,
//        colors = colors,
//        elevation = elevation,
//        contentPadding = contentPadding,
//        interactionSource = interactionSource,
//        content = content
//    )
//
///**
// * [Material Design standard list item](https://m3.material.io/components/lists/overview)
// *
// * Lists are continuous, vertical indexes of text or images.
// *
// * This overload of [ListItem] represents a multi-selection (toggleable) item, analogous to a
// * [Checkbox]. See other overloads for handling general click actions, single-selection, or no
// * interaction handling.
// *
// * @param checked whether this list item is toggled on or off.
// * @param onCheckedChange called when this toggleable list item is clicked.
// * @param modifier the [Modifier] to be applied to this list item.
// * @param enabled controls the enabled state of this list item. When `false`, this component will
// *   not respond to user input, and it will appear visually disabled and disabled to accessibility
// *   services.
// * @param leadingContent the leading content of this list item, such as an icon or avatar.
// * @param trailingContent the trailing content of this list item, such as a checkbox, switch, or
// *   icon.
// * @param overlineContent the content displayed above the main content of the list item.
// * @param supportingContent the content displayed below the main content of the list item.
// * @param verticalAlignment the vertical alignment of children within the list item, after
// *   accounting for [contentPadding].
// * @param onLongClick called when this list item is long clicked (long-pressed).
// * @param onLongClickLabel semantic / accessibility label for the [onLongClick] action.
// * @param shapes the [ListItemShapes] that this list item will use to morph between depending on the
// *   user's interaction with the list item. See [ListItemDefaults.shapes].
// * @param colors the [ListItemColors] that will be used to resolve the colors used for this list
// *   item in different states. See [ListItemDefaults.colors].
// * @param elevation the [ListItemElevation] used to resolve the elevation for this list item in
// *   different states. See [ListItemDefaults.elevation].
// * @param contentPadding the padding to be applied to the content of this list item.
// * @param interactionSource an optional hoisted [MutableInteractionSource] for observing and
// *   emitting [Interaction]s for this list item. You can use this to change the list item's
// *   appearance or preview the list item in different states. Note that if `null` is provided,
// *   interactions will still happen internally.
// * @param content the main content of this list item. Also known as the headline or label.
// */
//@Suppress("ComposableNaming")
//@ExperimentalMaterial3ExpressiveApi
//@Composable
//fun 列表项(
//    checked: Boolean,
//    onCheckedChange: (Boolean) -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    leadingContent: @Composable (() -> Unit)? = null,
//    trailingContent: @Composable (() -> Unit)? = null,
//    overlineContent: @Composable (() -> Unit)? = null,
//    supportingContent: @Composable (() -> Unit)? = null,
//    verticalAlignment: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
//    onLongClick: (() -> Unit)? = null,
//    onLongClickLabel: String? = null,
//    shapes: ListItemShapes = ListItemDefaults.shapes(),
//    colors: ListItemColors = ListItemDefaults.colors(),
//    elevation: ListItemElevation = ListItemDefaults.elevation(),
//    contentPadding: PaddingValues = ListItemDefaults.ContentPadding,
//    interactionSource: MutableInteractionSource? = null,
//    content: @Composable () -> Unit,
//) =
//    ListItem(
//        checked = checked,
//        onCheckedChange = onCheckedChange,
//        modifier = modifier,
//        enabled = enabled,
//        leadingContent = leadingContent,
//        trailingContent = trailingContent,
//        overlineContent = overlineContent,
//        supportingContent = supportingContent,
//        verticalAlignment = verticalAlignment,
//        onLongClick = onLongClick,
//        onLongClickLabel = onLongClickLabel,
//        shapes = shapes,
//        colors = colors,
//        elevation = elevation,
//        contentPadding = contentPadding,
//        interactionSource = interactionSource,
//        content = content
//    )
//
///**
// * [Material Design segmented list item](https://m3.material.io/components/lists/overview)
// *
// * Lists are continuous, vertical indexes of text or images.
// *
// * This overload of [SegmentedListItem] handles click events, calling its [onClick] lambda to
// * trigger an action. See other overloads for handling single-selection, multi-selection, or no
// * interaction handling.
// *
// * @param onClick called when this list item is clicked.
// * @param shapes the [ListItemShapes] that this list item will use to morph between depending on the
// *   user's interaction with the list item. The base shape depends on the index of the item within
// *   the overall list. See [ListItemDefaults.segmentedShapes].
// * @param modifier the [Modifier] to be applied to this list item.
// * @param enabled controls the enabled state of this list item. When `false`, this component will
// *   not respond to user input, and it will appear visually disabled and disabled to accessibility
// *   services.
// * @param leadingContent the leading content of this list item, such as an icon or avatar.
// * @param trailingContent the trailing content of this list item, such as a checkbox, switch, or
// *   icon.
// * @param overlineContent the content displayed above the main content of the list item.
// * @param supportingContent the content displayed below the main content of the list item.
// * @param verticalAlignment the vertical alignment of children within the list item, after
// *   accounting for [contentPadding].
// * @param onLongClick called when this list item is long clicked (long-pressed).
// * @param onLongClickLabel semantic / accessibility label for the [onLongClick] action.
// * @param colors the [ListItemColors] that will be used to resolve the colors used for this list
// *   item in different states. See [ListItemDefaults.segmentedColors].
// * @param elevation the [ListItemElevation] used to resolve the elevation for this list item in
// *   different states. See [ListItemDefaults.elevation].
// * @param contentPadding the padding to be applied to the content of this list item.
// * @param interactionSource an optional hoisted [MutableInteractionSource] for observing and
// *   emitting [Interaction]s for this list item. You can use this to change the list item's
// *   appearance or preview the list item in different states. Note that if `null` is provided,
// *   interactions will still happen internally.
// * @param content the main content of this list item. Also known as the headline or label.
// */
//@Suppress("ComposableNaming")
//@ExperimentalMaterial3ExpressiveApi
//@Composable
//fun 分段列表项(
//    onClick: () -> Unit,
//    shapes: ListItemShapes,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    leadingContent: @Composable (() -> Unit)? = null,
//    trailingContent: @Composable (() -> Unit)? = null,
//    overlineContent: @Composable (() -> Unit)? = null,
//    supportingContent: @Composable (() -> Unit)? = null,
//    verticalAlignment: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
//    onLongClick: (() -> Unit)? = null,
//    onLongClickLabel: String? = null,
//    colors: ListItemColors = ListItemDefaults.segmentedColors(),
//    elevation: ListItemElevation = ListItemDefaults.elevation(),
//    contentPadding: PaddingValues = ListItemDefaults.ContentPadding,
//    interactionSource: MutableInteractionSource? = null,
//    content: @Composable () -> Unit,
//) =
//    SegmentedListItem(
//        onClick = onClick,
//        shapes = shapes,
//        modifier = modifier,
//        enabled = enabled,
//        leadingContent = leadingContent,
//        trailingContent = trailingContent,
//        overlineContent = overlineContent,
//        supportingContent = supportingContent,
//        verticalAlignment = verticalAlignment,
//        onLongClick = onLongClick,
//        onLongClickLabel = onLongClickLabel,
//        colors = colors,
//        elevation = elevation,
//        contentPadding = contentPadding,
//        interactionSource = interactionSource,
//        content = content
//    )
//
///**
// * [Material Design segmented list item](https://m3.material.io/components/lists/overview)
// *
// * Lists are continuous, vertical indexes of text or images.
// *
// * This overload of [SegmentedListItem] represents a single-selection item, analogous to a
// * [RadioButton]. See other overloads for handling general click actions, multi-selection, or no
// * interaction handling.
// *
// * @param selected whether or not this list item is selected.
// * @param onClick called when this list item is clicked.
// * @param shapes the [ListItemShapes] that this list item will use to morph between depending on the
// *   user's interaction with the list item. The base shape depends on the index of the item within
// *   the overall list. See [ListItemDefaults.segmentedShapes].
// * @param modifier the [Modifier] to be applied to this list item.
// * @param enabled controls the enabled state of this list item. When `false`, this component will
// *   not respond to user input, and it will appear visually disabled and disabled to accessibility
// *   services.
// * @param leadingContent the leading content of this list item, such as an icon or avatar.
// * @param trailingContent the trailing content of this list item, such as a checkbox, switch, or
// *   icon.
// * @param overlineContent the content displayed above the main content of the list item.
// * @param supportingContent the content displayed below the main content of the list item.
// * @param verticalAlignment the vertical alignment of children within the list item, after
// *   accounting for [contentPadding].
// * @param onLongClick called when this list item is long clicked (long-pressed).
// * @param onLongClickLabel semantic / accessibility label for the [onLongClick] action.
// * @param colors the [ListItemColors] that will be used to resolve the colors used for this list
// *   item in different states. See [ListItemDefaults.segmentedColors].
// * @param elevation the [ListItemElevation] used to resolve the elevation for this list item in
// *   different states. See [ListItemDefaults.elevation].
// * @param contentPadding the padding to be applied to the content of this list item.
// * @param interactionSource an optional hoisted [MutableInteractionSource] for observing and
// *   emitting [Interaction]s for this list item. You can use this to change the list item's
// *   appearance or preview the list item in different states. Note that if `null` is provided,
// *   interactions will still happen internally.
// * @param content the main content of this list item. Also known as the headline or label.
// */
//@Suppress("ComposableNaming")
//@ExperimentalMaterial3ExpressiveApi
//@Composable
//fun 分段列表项(
//    selected: Boolean,
//    onClick: () -> Unit,
//    shapes: ListItemShapes,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    leadingContent: @Composable (() -> Unit)? = null,
//    trailingContent: @Composable (() -> Unit)? = null,
//    overlineContent: @Composable (() -> Unit)? = null,
//    supportingContent: @Composable (() -> Unit)? = null,
//    verticalAlignment: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
//    onLongClick: (() -> Unit)? = null,
//    onLongClickLabel: String? = null,
//    colors: ListItemColors = ListItemDefaults.segmentedColors(),
//    elevation: ListItemElevation = ListItemDefaults.elevation(),
//    contentPadding: PaddingValues = ListItemDefaults.ContentPadding,
//    interactionSource: MutableInteractionSource? = null,
//    content: @Composable () -> Unit,
//) =
//    SegmentedListItem(
//        selected = selected,
//        onClick = onClick,
//        shapes = shapes,
//        modifier = modifier,
//        enabled = enabled,
//        leadingContent = leadingContent,
//        trailingContent = trailingContent,
//        overlineContent = overlineContent,
//        supportingContent = supportingContent,
//        verticalAlignment = verticalAlignment,
//        onLongClick = onLongClick,
//        onLongClickLabel = onLongClickLabel,
//        colors = colors,
//        elevation = elevation,
//        contentPadding = contentPadding,
//        interactionSource = interactionSource,
//        content = content
//    )
//
///**
// * [Material Design segmented list item](https://m3.material.io/components/lists/overview)
// *
// * Lists are continuous, vertical indexes of text or images.
// *
// * This overload of [SegmentedListItem] represents a multi-selection (toggleable) item, analogous to
// * a [Checkbox]. See other overloads for handling general click actions, single-selection, or no
// * interaction handling.
// *
// * @param checked whether this list item is toggled on or off.
// * @param onCheckedChange called when this toggleable list item is clicked.
// * @param shapes the [ListItemShapes] that this list item will use to morph between depending on the
// *   user's interaction with the list item. The base shape depends on the index of the item within
// *   the overall list. See [ListItemDefaults.segmentedShapes].
// * @param modifier the [Modifier] to be applied to this list item.
// * @param enabled controls the enabled state of this list item. When `false`, this component will
// *   not respond to user input, and it will appear visually disabled and disabled to accessibility
// *   services.
// * @param leadingContent the leading content of this list item, such as an icon or avatar.
// * @param trailingContent the trailing content of this list item, such as a checkbox, switch, or
// *   icon.
// * @param overlineContent the content displayed above the main content of the list item.
// * @param supportingContent the content displayed below the main content of the list item.
// * @param verticalAlignment the vertical alignment of children within the list item, after
// *   accounting for [contentPadding].
// * @param onLongClick called when this list item is long clicked (long-pressed).
// * @param onLongClickLabel semantic / accessibility label for the [onLongClick] action.
// * @param colors the [ListItemColors] that will be used to resolve the colors used for this list
// *   item in different states. See [ListItemDefaults.segmentedColors].
// * @param elevation the [ListItemElevation] used to resolve the elevation for this list item in
// *   different states. See [ListItemDefaults.elevation].
// * @param contentPadding the padding to be applied to the content of this list item.
// * @param interactionSource an optional hoisted [MutableInteractionSource] for observing and
// *   emitting [Interaction]s for this list item. You can use this to change the list item's
// *   appearance or preview the list item in different states. Note that if `null` is provided,
// *   interactions will still happen internally.
// * @param content the main content of this list item. Also known as the headline or label.
// */
//@Suppress("ComposableNaming")
//@ExperimentalMaterial3ExpressiveApi
//@Composable
//fun 分段列表项(
//    checked: Boolean,
//    onCheckedChange: (Boolean) -> Unit,
//    shapes: ListItemShapes,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    leadingContent: @Composable (() -> Unit)? = null,
//    trailingContent: @Composable (() -> Unit)? = null,
//    overlineContent: @Composable (() -> Unit)? = null,
//    supportingContent: @Composable (() -> Unit)? = null,
//    verticalAlignment: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
//    onLongClick: (() -> Unit)? = null,
//    onLongClickLabel: String? = null,
//    colors: ListItemColors = ListItemDefaults.segmentedColors(),
//    elevation: ListItemElevation = ListItemDefaults.elevation(),
//    contentPadding: PaddingValues = ListItemDefaults.ContentPadding,
//    interactionSource: MutableInteractionSource? = null,
//    content: @Composable () -> Unit,
//) =
//    SegmentedListItem(
//        checked = checked,
//        onCheckedChange = onCheckedChange,
//        shapes = shapes,
//        modifier = modifier,
//        enabled = enabled,
//        leadingContent = leadingContent,
//        trailingContent = trailingContent,
//        overlineContent = overlineContent,
//        supportingContent = supportingContent,
//        verticalAlignment = verticalAlignment,
//        onLongClick = onLongClick,
//        onLongClickLabel = onLongClickLabel,
//        colors = colors,
//        elevation = elevation,
//        contentPadding = contentPadding,
//        interactionSource = interactionSource,
//        content = content
//    )


