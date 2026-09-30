package 安卓x.组合.材质3

//import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
//import androidx.compose.material3.ListItem
//import androidx.compose.material3.SegmentedListItem
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.material3.ListItemColors
//import androidx.compose.material3.ListItemDefaults
//import androidx.compose.material3.ListItemElevation
//import androidx.compose.material3.ListItemShapes
//import 安卓x.组合.材质3.令牌集.ListTokens
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.ReadOnlyComposable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Shape
//import androidx.compose.ui.unit.Dp
//
//
///** Contains the default values used by list items. */
//object 列表项默认值 { // ListItemDefaults
//
//    /** The default padding applied to all content within a list item. */
//    val ContentPadding: PaddingValues = ListItemDefaults.ContentPadding
//
//
//    /** The default elevation of a list item */
//    val Elevation: Dp = ListItemDefaults.Elevation
//
//    /** The default shape of a list item */
//    val shape: Shape
//        @Composable @ReadOnlyComposable get() = ListItemDefaults.shape
//
//    /** The container color of a list item */
//    val containerColor: Color
//        @Composable @ReadOnlyComposable get() = ListItemDefaults.containerColor
//
//    /** The content color of a list item */
//    val contentColor: Color
//        @Composable @ReadOnlyComposable get() = ListItemDefaults.contentColor
//
//    /**
//     * Creates a [ListItemColors] that represents the default colors for a [ListItem] in different
//     * states.
//     */
//    @Composable fun colors() = ListItemDefaults.colors()
//
//    /**
//     * Creates a [ListItemColors] that represents the default colors for a [ListItem] in different
//     * states.
//     *
//     * @param containerColor the container color of the list item.
//     * @param contentColor the content color of the list item.
//     * @param leadingContentColor the leading content color of the list item.
//     * @param trailingContentColor the trailing content color of the list item.
//     * @param overlineContentColor the overline content color of the list item.
//     * @param supportingContentColor the supporting content color of the list item.
//     * @param disabledContainerColor the container color of the list item when disabled.
//     * @param disabledContentColor the content color of the list item when disabled.
//     * @param disabledLeadingContentColor the leading content color of the list item when disabled.
//     * @param disabledTrailingContentColor the trailing content color of the list item when
//     *   disabled.
//     * @param disabledOverlineContentColor the overline content color of the list item when
//     *   disabled.
//     * @param disabledSupportingContentColor the supporting content color of the list item when
//     *   disabled.
//     * @param selectedContainerColor the container color of the list item when selected.
//     * @param selectedContentColor the content color of the list item when selected.
//     * @param selectedLeadingContentColor the leading content color of the list item when selected.
//     * @param selectedTrailingContentColor the trailing content color of the list item when
//     *   selected.
//     * @param selectedOverlineContentColor the overline content color of the list item when
//     *   selected.
//     * @param selectedSupportingContentColor the supporting content color of the list item when
//     *   selected.
//     * @param draggedContainerColor the container color of the list item when dragged.
//     * @param draggedContentColor the content color of the list item when dragged.
//     * @param draggedLeadingContentColor the leading content color of the list item when dragged.
//     * @param draggedTrailingContentColor the trailing content color of the list item when dragged.
//     * @param draggedOverlineContentColor the overline content color of the list item when dragged.
//     * @param draggedSupportingContentColor the supporting content color of the list item when
//     *   dragged.
//     */
//    @Composable
//    fun colors(
//        // default
//        containerColor: Color = Color.Unspecified,
//        contentColor: Color = Color.Unspecified,
//        leadingContentColor: Color = Color.Unspecified,
//        trailingContentColor: Color = Color.Unspecified,
//        overlineContentColor: Color = Color.Unspecified,
//        supportingContentColor: Color = Color.Unspecified,
//        // disabled
//        disabledContainerColor: Color = Color.Unspecified,
//        disabledContentColor: Color = Color.Unspecified,
//        disabledLeadingContentColor: Color = Color.Unspecified,
//        disabledTrailingContentColor: Color = Color.Unspecified,
//        disabledOverlineContentColor: Color = Color.Unspecified,
//        disabledSupportingContentColor: Color = Color.Unspecified,
//        // selected
//        selectedContainerColor: Color = Color.Unspecified,
//        selectedContentColor: Color = Color.Unspecified,
//        selectedLeadingContentColor: Color = Color.Unspecified,
//        selectedTrailingContentColor: Color = Color.Unspecified,
//        selectedOverlineContentColor: Color = Color.Unspecified,
//        selectedSupportingContentColor: Color = Color.Unspecified,
//        // dragged
//        draggedContainerColor: Color = Color.Unspecified,
//        draggedContentColor: Color = Color.Unspecified,
//        draggedLeadingContentColor: Color = Color.Unspecified,
//        draggedTrailingContentColor: Color = Color.Unspecified,
//        draggedOverlineContentColor: Color = Color.Unspecified,
//        draggedSupportingContentColor: Color = Color.Unspecified,
//    ): ListItemColors =
//        ListItemDefaults.colors(
//            containerColor = containerColor,
//            contentColor = contentColor,
//            leadingContentColor = leadingContentColor,
//            trailingContentColor = trailingContentColor,
//            overlineContentColor = overlineContentColor,
//            supportingContentColor = supportingContentColor,
//            disabledContainerColor = disabledContainerColor,
//            disabledContentColor = disabledContentColor,
//            disabledLeadingContentColor = disabledLeadingContentColor,
//            disabledTrailingContentColor = disabledTrailingContentColor,
//            disabledOverlineContentColor = disabledOverlineContentColor,
//            disabledSupportingContentColor = disabledSupportingContentColor,
//            selectedContainerColor = selectedContainerColor,
//            selectedContentColor = selectedContentColor,
//            selectedLeadingContentColor = selectedLeadingContentColor,
//            selectedTrailingContentColor = selectedTrailingContentColor,
//            selectedOverlineContentColor = selectedOverlineContentColor,
//            selectedSupportingContentColor = selectedSupportingContentColor,
//            draggedContainerColor = draggedContainerColor,
//            draggedContentColor = draggedContentColor,
//            draggedLeadingContentColor = draggedLeadingContentColor,
//            draggedTrailingContentColor = draggedTrailingContentColor,
//            draggedOverlineContentColor = draggedOverlineContentColor,
//            draggedSupportingContentColor = draggedSupportingContentColor,
//        )
//
//    /**
//     * Creates a [ListItemColors] that represents the default colors for a [SegmentedListItem] in
//     * different states.
//     */
//    @ExperimentalMaterial3ExpressiveApi
//    @Composable
//    fun segmentedColors(): ListItemColors = ListItemDefaults.segmentedColors()
//
//    /**
//     * Creates a [ListItemColors] that represents the default colors for a [SegmentedListItem] in
//     * different states.
//     *
//     * @param containerColor the container color of the list item.
//     * @param contentColor the content color of the list item.
//     * @param leadingContentColor the leading content color of the list item.
//     * @param trailingContentColor the trailing content color of the list item.
//     * @param overlineContentColor the overline content color of the list item.
//     * @param supportingContentColor the supporting content color of the list item.
//     * @param disabledContainerColor the container color of the list item when disabled.
//     * @param disabledContentColor the content color of the list item when disabled.
//     * @param disabledLeadingContentColor the leading content color of the list item when disabled.
//     * @param disabledTrailingContentColor the trailing content color of the list item when
//     *   disabled.
//     * @param disabledOverlineContentColor the overline content color of the list item when
//     *   disabled.
//     * @param disabledSupportingContentColor the supporting content color of the list item when
//     *   disabled.
//     * @param selectedContainerColor the container color of the list item when selected.
//     * @param selectedContentColor the content color of the list item when selected.
//     * @param selectedLeadingContentColor the leading content color of the list item when selected.
//     * @param selectedTrailingContentColor the trailing content color of the list item when
//     *   selected.
//     * @param selectedOverlineContentColor the overline content color of the list item when
//     *   selected.
//     * @param selectedSupportingContentColor the supporting content color of the list item when
//     *   selected.
//     * @param draggedContainerColor the container color of the list item when dragged.
//     * @param draggedContentColor the content color of the list item when dragged.
//     * @param draggedLeadingContentColor the leading content color of the list item when dragged.
//     * @param draggedTrailingContentColor the trailing content color of the list item when dragged.
//     * @param draggedOverlineContentColor the overline content color of the list item when dragged.
//     * @param draggedSupportingContentColor the supporting content color of the list item when
//     *   dragged.
//     */
//    @ExperimentalMaterial3ExpressiveApi
//    @Composable
//    fun segmentedColors(
//        // default
//        containerColor: Color = Color.Unspecified,
//        contentColor: Color = Color.Unspecified,
//        leadingContentColor: Color = Color.Unspecified,
//        trailingContentColor: Color = Color.Unspecified,
//        overlineContentColor: Color = Color.Unspecified,
//        supportingContentColor: Color = Color.Unspecified,
//        // disabled
//        disabledContainerColor: Color = Color.Unspecified,
//        disabledContentColor: Color = Color.Unspecified,
//        disabledLeadingContentColor: Color = Color.Unspecified,
//        disabledTrailingContentColor: Color = Color.Unspecified,
//        disabledOverlineContentColor: Color = Color.Unspecified,
//        disabledSupportingContentColor: Color = Color.Unspecified,
//        // selected
//        selectedContainerColor: Color = Color.Unspecified,
//        selectedContentColor: Color = Color.Unspecified,
//        selectedLeadingContentColor: Color = Color.Unspecified,
//        selectedTrailingContentColor: Color = Color.Unspecified,
//        selectedOverlineContentColor: Color = Color.Unspecified,
//        selectedSupportingContentColor: Color = Color.Unspecified,
//        // dragged
//        draggedContainerColor: Color = Color.Unspecified,
//        draggedContentColor: Color = Color.Unspecified,
//        draggedLeadingContentColor: Color = Color.Unspecified,
//        draggedTrailingContentColor: Color = Color.Unspecified,
//        draggedOverlineContentColor: Color = Color.Unspecified,
//        draggedSupportingContentColor: Color = Color.Unspecified,
//    ): ListItemColors =
//        ListItemDefaults.segmentedColors(
//            containerColor = containerColor,
//            contentColor = contentColor,
//            leadingContentColor = leadingContentColor,
//            trailingContentColor = trailingContentColor,
//            overlineContentColor = overlineContentColor,
//            supportingContentColor = supportingContentColor,
//            disabledContainerColor = disabledContainerColor,
//            disabledContentColor = disabledContentColor,
//            disabledLeadingContentColor = disabledLeadingContentColor,
//            disabledTrailingContentColor = disabledTrailingContentColor,
//            disabledOverlineContentColor = disabledOverlineContentColor,
//            disabledSupportingContentColor = disabledSupportingContentColor,
//            selectedContainerColor = selectedContainerColor,
//            selectedContentColor = selectedContentColor,
//            selectedLeadingContentColor = selectedLeadingContentColor,
//            selectedTrailingContentColor = selectedTrailingContentColor,
//            selectedOverlineContentColor = selectedOverlineContentColor,
//            selectedSupportingContentColor = selectedSupportingContentColor,
//            draggedContainerColor = draggedContainerColor,
//            draggedContentColor = draggedContentColor,
//            draggedLeadingContentColor = draggedLeadingContentColor,
//            draggedTrailingContentColor = draggedTrailingContentColor,
//            draggedOverlineContentColor = draggedOverlineContentColor,
//            draggedSupportingContentColor = draggedSupportingContentColor,
//        )
//
//
//    /**
//     * Creates a [ListItemShapes] that represents the default shapes for a [ListItem] in different
//     * states.
//     */
//    @ExperimentalMaterial3ExpressiveApi
//    @Composable
//    fun shapes(): ListItemShapes = ListItemDefaults.shapes()
//
//    /**
//     * Creates a [ListItemShapes] that represents the default shapes for a [ListItem] in different
//     * states.
//     *
//     * @param shape the default shape of the list item.
//     * @param selectedShape the shape of the list item when selected.
//     * @param pressedShape the shape of the list item when pressed.
//     * @param focusedShape the shape of the list item when focused.
//     * @param hoveredShape the shape of the list item when hovered.
//     * @param draggedShape the shape of the list item when dragged.
//     */
//    @ExperimentalMaterial3ExpressiveApi
//    @Composable
//    fun shapes(
//        shape: Shape? = null,
//        selectedShape: Shape? = null,
//        pressedShape: Shape? = null,
//        focusedShape: Shape? = null,
//        hoveredShape: Shape? = null,
//        draggedShape: Shape? = null,
//    ): ListItemShapes =
//        ListItemDefaults.shapes(
//            shape = shape,
//            selectedShape = selectedShape,
//            pressedShape = pressedShape,
//            focusedShape = focusedShape,
//            hoveredShape = hoveredShape,
//            draggedShape = draggedShape,
//        )
//
//    /**
//     * Constructor for [ListItemShapes] to be used by a [SegmentedListItem] which has an [index] in
//     * a list that has a total of [count] items.
//     *
//     * @param index the index for this list item in the overall list.
//     * @param count the total count of list items in the overall list.
//     * @param defaultShapes the default [ListItemShapes] that should be used for standalone items or
//     *   items in the middle of the list.
//     */
//    @ExperimentalMaterial3ExpressiveApi
//    @Composable
//    fun segmentedShapes(
//        index: Int,
//        count: Int,
//        defaultShapes: ListItemShapes = shapes(),
//    ): ListItemShapes =
//        ListItemDefaults.segmentedShapes(
//            index = index,
//            count = count,
//            defaultShapes = defaultShapes
//        )
//
//
//    /**
//     * Creates a [ListItemElevation] that represents the elevation for a [ListItem] in different
//     * states.
//     *
//     * @param elevation the default elevation of the list item.
//     * @param draggedElevation the elevation of the list item when dragged.
//     */
//    @ExperimentalMaterial3ExpressiveApi
//    fun elevation(
//        elevation: Dp = ListTokens.ItemContainerElevation,
//        draggedElevation: Dp = ListTokens.ItemDraggedContainerElevation,
//    ): ListItemElevation =
//        ListItemDefaults.elevation(
//            elevation = elevation,
//            draggedElevation = draggedElevation
//        )
//
//    /** The vertical space between different [SegmentedListItem]s. */
//    @ExperimentalMaterial3ExpressiveApi val SegmentedGap: Dp = ListItemDefaults.SegmentedGap
//
//    /**
//     * Returns the default vertical alignment of children content within a [ListItem]. This is
//     * equivalent to [Alignment.CenterVertically] for shorter items and [Alignment.Top] for taller
//     * items.
//     */
//    @ExperimentalMaterial3ExpressiveApi
//    @Composable
//    fun verticalAlignment(): Alignment.Vertical = ListItemDefaults.verticalAlignment()
//
//    /**
//     * Creates a [ListItemColors] that represents the default container and content colors used in a
//     * [ListItem].
//     *
//     * @param containerColor the container color of this list item when enabled.
//     * @param headlineColor the headline text content color of this list item when enabled.
//     * @param leadingIconColor the color of this list item's leading content when enabled.
//     * @param overlineColor the overline text color of this list item
//     * @param supportingColor the supporting text color of this list item
//     * @param trailingIconColor the color of this list item's trailing content when enabled.
//     * @param disabledHeadlineColor the content color of this list item when not enabled.
//     * @param disabledLeadingIconColor the color of this list item's leading content when not
//     *   enabled.
//     * @param disabledTrailingIconColor the color of this list item's trailing content when not
//     *   enabled.
//     */
//    @Composable
//    fun colors(
//        containerColor: Color = Color.Unspecified,
//        headlineColor: Color = Color.Unspecified,
//        leadingIconColor: Color = Color.Unspecified,
//        overlineColor: Color = Color.Unspecified,
//        supportingColor: Color = Color.Unspecified,
//        trailingIconColor: Color = Color.Unspecified,
//        disabledHeadlineColor: Color = Color.Unspecified,
//        disabledLeadingIconColor: Color = Color.Unspecified,
//        disabledTrailingIconColor: Color = Color.Unspecified,
//    ): ListItemColors =
//        ListItemDefaults.colors(
//            containerColor = containerColor,
//            contentColor = headlineColor,
//            leadingContentColor = leadingIconColor,
//            overlineContentColor = overlineColor,
//            supportingContentColor = supportingColor,
//            trailingContentColor = trailingIconColor,
//            disabledContentColor = disabledHeadlineColor,
//            disabledLeadingContentColor = disabledLeadingIconColor,
//            disabledTrailingContentColor = disabledTrailingIconColor,
//        )
//
//}
//
///**
// * Represents the colors of a list item in different states.
// *
// * @param containerColor the container color of the list item.
// * @param contentColor the content color of the list item.
// * @param leadingContentColor the color of the leading content of the list item.
// * @param trailingContentColor the color of the trailing content of the list item.
// * @param overlineContentColor the color of the overline content of the list item.
// * @param supportingContentColor the color of the supporting content of the list item.
// * @param disabledContainerColor the container color of the list item when disabled.
// * @param disabledContentColor the content color of the list item when disabled.
// * @param disabledLeadingContentColor the color of the leading content of the list item when
// *   disabled.
// * @param disabledTrailingContentColor the color of the trailing content of the list item when
// *   disabled.
// * @param disabledOverlineContentColor the color of the overline content of the list item when
// *   disabled.
// * @param disabledSupportingContentColor the color of the supporting content of the list item when
// *   disabled.
// * @param selectedContainerColor the container color of the list item when selected.
// * @param selectedContentColor the content color of the list item when selected.
// * @param selectedLeadingContentColor the color of the leading content of the list item when
// *   selected.
// * @param selectedTrailingContentColor the color of the trailing content of the list item when
// *   selected.
// * @param selectedOverlineContentColor the color of the overline content of the list item when
// *   selected.
// * @param selectedSupportingContentColor the color of the supporting content of the list item when
// *   selected.
// * @param draggedContainerColor the container color of the list item when dragged.
// * @param draggedContentColor the content color of the list item when dragged.
// * @param draggedLeadingContentColor the color of the leading content of the list item when dragged.
// * @param draggedTrailingContentColor the color of the trailing content of the list item when
// *   dragged.
// * @param draggedOverlineContentColor the color of the overline content of the list item when
// *   dragged.
// * @param draggedSupportingContentColor the color of the supporting content of the list item when
// *   dragged.
// */
//fun 列表项颜色集(
//    // default
//    containerColor: Color,
//    contentColor: Color,
//    leadingContentColor: Color,
//    trailingContentColor: Color,
//    overlineContentColor: Color,
//    supportingContentColor: Color,
//    // disabled
//    disabledContainerColor: Color,
//    disabledContentColor: Color,
//    disabledLeadingContentColor: Color,
//    disabledTrailingContentColor: Color,
//    disabledOverlineContentColor: Color,
//    disabledSupportingContentColor: Color,
//    // selected
//    selectedContainerColor: Color,
//    selectedContentColor: Color,
//    selectedLeadingContentColor: Color,
//    selectedTrailingContentColor: Color,
//    selectedOverlineContentColor: Color,
//    selectedSupportingContentColor: Color,
//    // dragged
//    draggedContainerColor: Color,
//    draggedContentColor: Color,
//    draggedLeadingContentColor: Color,
//    draggedTrailingContentColor: Color,
//    draggedOverlineContentColor: Color,
//    draggedSupportingContentColor: Color,
//) =
//    ListItemColors(
//        // default
//        containerColor = containerColor,
//        contentColor = contentColor,
//        leadingContentColor = leadingContentColor,
//        trailingContentColor = trailingContentColor,
//        overlineContentColor = overlineContentColor,
//        supportingContentColor = supportingContentColor,
//        // disabled
//        disabledContainerColor = disabledContainerColor,
//        disabledContentColor = disabledContentColor,
//        disabledLeadingContentColor = disabledLeadingContentColor,
//        disabledTrailingContentColor = disabledTrailingContentColor,
//        disabledOverlineContentColor = disabledOverlineContentColor,
//        disabledSupportingContentColor = disabledSupportingContentColor,
//        // selected
//        selectedContainerColor = selectedContainerColor,
//        selectedContentColor = selectedContentColor,
//        selectedLeadingContentColor = selectedLeadingContentColor,
//        selectedTrailingContentColor = selectedTrailingContentColor,
//        selectedOverlineContentColor = selectedOverlineContentColor,
//        selectedSupportingContentColor = selectedSupportingContentColor,
//        // dragged
//        draggedContainerColor = draggedContainerColor,
//        draggedContentColor = draggedContentColor,
//        draggedLeadingContentColor = draggedLeadingContentColor,
//        draggedTrailingContentColor = draggedTrailingContentColor,
//        draggedOverlineContentColor = draggedOverlineContentColor,
//        draggedSupportingContentColor = draggedSupportingContentColor,
//    )
//
//fun 列表项颜色集(
//    containerColor: Color,
//    headlineColor: Color,
//    leadingIconColor: Color,
//    overlineColor: Color,
//    supportingTextColor: Color,
//    trailingIconColor: Color,
//    disabledHeadlineColor: Color,
//    disabledLeadingIconColor: Color,
//    disabledTrailingIconColor: Color,
//) =
//    ListItemColors(
//        // default
//        containerColor = containerColor,
//        headlineColor = headlineColor,
//        leadingIconColor = leadingIconColor,
//        overlineColor = overlineColor,
//        supportingTextColor = supportingTextColor,
//        trailingIconColor = trailingIconColor,
//        disabledHeadlineColor = disabledHeadlineColor,
//        disabledLeadingIconColor = disabledLeadingIconColor,
//        disabledTrailingIconColor = disabledTrailingIconColor,
//    )
//
//
///**
// * Returns the container color of the list item based on the current state.
// *
// * @param enabled whether the list item is enabled.
// * @param selected whether the list item is selected.
// * @param dragged whether the list item is dragged.
// */
//fun ListItemColors.containerColor(enabled: Boolean, selected: Boolean, dragged: Boolean): Color =
//    when {
//        !enabled -> disabledContainerColor
//        dragged -> draggedContainerColor
//        selected -> selectedContainerColor
//        else -> containerColor
//    }
//
///**
// * Returns the content color of the list item based on the current state.
// *
// * @param enabled whether the list item is enabled.
// * @param selected whether the list item is selected.
// * @param dragged whether the list item is dragged.
// */
//fun ListItemColors.contentColor(enabled: Boolean, selected: Boolean, dragged: Boolean): Color =
//    when {
//        !enabled -> disabledContentColor
//        dragged -> draggedContentColor
//        selected -> selectedContentColor
//        else -> contentColor
//    }
//
///**
// * Returns the color of the leading content of the list item based on the current state.
// *
// * @param enabled whether the list item is enabled.
// * @param selected whether the list item is selected.
// * @param dragged whether the list item is dragged.
// */
//fun ListItemColors.leadingContentColor(enabled: Boolean, selected: Boolean, dragged: Boolean): Color =
//    when {
//        !enabled -> disabledLeadingContentColor
//        dragged -> draggedLeadingContentColor
//        selected -> selectedLeadingContentColor
//        else -> leadingContentColor
//    }
//
///**
// * Returns the color of the trailing content of the list item based on the current state.
// *
// * @param enabled whether the list item is enabled.
// * @param selected whether the list item is selected.
// * @param dragged whether the list item is dragged.
// */
//fun ListItemColors.trailingContentColor(enabled: Boolean, selected: Boolean, dragged: Boolean): Color =
//    when {
//        !enabled -> disabledTrailingContentColor
//        dragged -> draggedTrailingContentColor
//        selected -> selectedTrailingContentColor
//        else -> trailingContentColor
//    }
//
///**
// * Returns the color of the overline content of the list item based on the current state.
// *
// * @param enabled whether the list item is enabled.
// * @param selected whether the list item is selected.
// * @param dragged whether the list item is dragged.
// */
//fun ListItemColors.overlineContentColor(enabled: Boolean, selected: Boolean, dragged: Boolean): Color =
//    when {
//        !enabled -> disabledOverlineContentColor
//        dragged -> draggedOverlineContentColor
//        selected -> selectedOverlineContentColor
//        else -> overlineContentColor
//    }
//
///**
// * Returns the color of the supporting content of the list item based on the current state.
// *
// * @param enabled whether the list item is enabled.
// * @param selected whether the list item is selected.
// * @param dragged whether the list item is dragged.
// */
//fun ListItemColors.supportingContentColor(enabled: Boolean, selected: Boolean, dragged: Boolean): Color =
//    when {
//        !enabled -> disabledSupportingContentColor
//        dragged -> draggedSupportingContentColor
//        selected -> selectedSupportingContentColor
//        else -> supportingContentColor
//    }
//
//
///**
// * Returns a copy of this [ListItemColors], optionally overriding some of the values. This uses
// * [Color.Unspecified] to mean “use the value from the source”.
// */
//fun ListItemColors.复制(
//    // default
//    containerColor: Color = this.containerColor,
//    contentColor: Color = this.contentColor,
//    leadingContentColor: Color = this.leadingContentColor,
//    trailingContentColor: Color = this.trailingContentColor,
//    overlineContentColor: Color = this.overlineContentColor,
//    supportingContentColor: Color = this.supportingContentColor,
//    // disabled
//    disabledContainerColor: Color = this.disabledContainerColor,
//    disabledContentColor: Color = this.disabledContentColor,
//    disabledLeadingContentColor: Color = this.disabledLeadingContentColor,
//    disabledTrailingContentColor: Color = this.disabledTrailingContentColor,
//    disabledOverlineContentColor: Color = this.disabledOverlineContentColor,
//    disabledSupportingContentColor: Color = this.disabledSupportingContentColor,
//    // selected
//    selectedContainerColor: Color = this.selectedContainerColor,
//    selectedContentColor: Color = this.selectedContentColor,
//    selectedLeadingContentColor: Color = this.selectedLeadingContentColor,
//    selectedTrailingContentColor: Color = this.selectedTrailingContentColor,
//    selectedOverlineContentColor: Color = this.selectedOverlineContentColor,
//    selectedSupportingContentColor: Color = this.selectedSupportingContentColor,
//    // dragged
//    draggedContainerColor: Color = this.draggedContainerColor,
//    draggedContentColor: Color = this.draggedContentColor,
//    draggedLeadingContentColor: Color = this.draggedLeadingContentColor,
//    draggedTrailingContentColor: Color = this.draggedTrailingContentColor,
//    draggedOverlineContentColor: Color = this.draggedOverlineContentColor,
//    draggedSupportingContentColor: Color = this.draggedSupportingContentColor,
//): ListItemColors =
//    this.copy(
//        containerColor = containerColor,
//        contentColor = contentColor,
//        leadingContentColor = leadingContentColor,
//        trailingContentColor = trailingContentColor,
//        overlineContentColor = overlineContentColor,
//        supportingContentColor = supportingContentColor,
//        disabledContainerColor = disabledContainerColor,
//        disabledContentColor = disabledContentColor,
//        disabledLeadingContentColor = disabledLeadingContentColor,
//        disabledTrailingContentColor = disabledTrailingContentColor,
//        disabledOverlineContentColor = disabledOverlineContentColor,
//        disabledSupportingContentColor = disabledSupportingContentColor,
//        selectedContainerColor = selectedContainerColor,
//        selectedContentColor = selectedContentColor,
//        selectedLeadingContentColor = selectedLeadingContentColor,
//        selectedTrailingContentColor = selectedTrailingContentColor,
//        selectedOverlineContentColor = selectedOverlineContentColor,
//        selectedSupportingContentColor = selectedSupportingContentColor,
//        draggedContainerColor = draggedContainerColor,
//        draggedContentColor = draggedContentColor,
//        draggedLeadingContentColor = draggedLeadingContentColor,
//        draggedTrailingContentColor = draggedTrailingContentColor,
//        draggedOverlineContentColor = draggedOverlineContentColor,
//        draggedSupportingContentColor = draggedSupportingContentColor,
//    )
//
//
//@Deprecated("Renamed to contentColor", replaceWith = ReplaceWith("contentColor"))
//val ListItemColors.headlineColor: Color
//    get() = this.headlineColor
//
//@Deprecated("Renamed to leadingContentColor", replaceWith = ReplaceWith("leadingContentColor"))
//val ListItemColors.leadingIconColor: Color
//    get() = this.leadingIconColor
//
//@Deprecated(
//    "Renamed to overlineContentColor",
//    replaceWith = ReplaceWith("overlineContentColor"),
//)
//val ListItemColors.overlineColor: Color
//    get() = this.overlineColor
//
//@Deprecated(
//    "Renamed to supportingContentColor",
//    replaceWith = ReplaceWith("supportingContentColor"),
//)
//val ListItemColors.supportingTextColor: Color
//    get() = this.supportingTextColor
//
//@Deprecated(
//    "Renamed to trailingContentColor",
//    replaceWith = ReplaceWith("trailingContentColor"),
//)
//val ListItemColors.trailingIconColor: Color
//    get() = this.trailingIconColor
//
//@Deprecated(
//    "Renamed to disabledContentColor",
//    replaceWith = ReplaceWith("disabledContentColor"),
//)
//val ListItemColors.disabledHeadlineColor: Color
//    get() = this.disabledHeadlineColor
//
//@Deprecated(
//    "Renamed to disabledLeadingContentColor",
//    replaceWith = ReplaceWith("disabledLeadingContentColor"),
//)
//val ListItemColors.disabledLeadingIconColor: Color
//    get() = this.disabledLeadingIconColor
//
//@Deprecated(
//    "Renamed to disabledTrailingContentColor",
//    replaceWith = ReplaceWith("disabledTrailingContentColor"),
//)
//val ListItemColors.disabledTrailingIconColor: Color
//    get() = this.disabledTrailingIconColor
//
//@Deprecated("Use overload with parameters for selected and dragged colors")
//@Suppress("DEPRECATION")
//fun ListItemColors.复制(
//    containerColor: Color = this.containerColor,
//    headlineColor: Color = this.headlineColor,
//    leadingIconColor: Color = this.leadingIconColor,
//    overlineColor: Color = this.overlineColor,
//    supportingTextColor: Color = this.supportingTextColor,
//    trailingIconColor: Color = this.trailingIconColor,
//    disabledHeadlineColor: Color = this.disabledHeadlineColor,
//    disabledLeadingIconColor: Color = this.disabledLeadingIconColor,
//    disabledTrailingIconColor: Color = this.disabledTrailingIconColor,
//) =
//    this.copy(
//        containerColor = containerColor,
//        headlineColor = headlineColor,
//        leadingIconColor = leadingIconColor,
//        overlineColor = overlineColor,
//        supportingTextColor = supportingTextColor,
//        trailingIconColor = trailingIconColor,
//        disabledHeadlineColor = disabledHeadlineColor,
//        disabledLeadingIconColor = disabledLeadingIconColor,
//        disabledTrailingIconColor = disabledTrailingIconColor,
//    )
//
//
////==================================================================================
//
//
///**
// * 表示列表项在不同状态下的形状。
// *
// * @param 形状 列表项的默认形状。
// * @param 已选择形状 列表项被选中时的形状。
// * @param 按压形状 列表项按下时的形状。
// * @param 聚焦形状 列表项聚焦时的形状。
// * @param 悬停形状 列表项悬停时的形状。
// * @param 拖拽形状 列表项拖拽时的形状。
// */
//@ExperimentalMaterial3ExpressiveApi
//fun 列表项形状集(
//    形状: Shape,
//    已选择形状: Shape,
//    按压形状: Shape,
//    聚焦形状: Shape,
//    悬停形状: Shape,
//    拖拽形状: Shape,
//): ListItemShapes =
//    ListItemShapes(
//        shape = 形状,
//        selectedShape = 已选择形状,
//        pressedShape = 按压形状,
//        focusedShape = 聚焦形状,
//        hoveredShape = 悬停形状,
//        draggedShape = 拖拽形状,
//    )
//
//@ExperimentalMaterial3ExpressiveApi
//val ListItemShapes.形状: Shape
//    get() = this.shape
//
//@ExperimentalMaterial3ExpressiveApi
//val ListItemShapes.已选择形状: Shape
//    get() = this.selectedShape
//
//@ExperimentalMaterial3ExpressiveApi
//val ListItemShapes.按压形状: Shape
//    get() = this.pressedShape
//
//@ExperimentalMaterial3ExpressiveApi
//val ListItemShapes.聚焦形状: Shape
//    get() = this.focusedShape
//
//@ExperimentalMaterial3ExpressiveApi
//val ListItemShapes.悬停形状: Shape
//    get() = this.hoveredShape
//
//@ExperimentalMaterial3ExpressiveApi
//val ListItemShapes.拖拽形状: Shape
//    get() = this.draggedShape
//
///** 返回此 [ListItemShapes] 的副本，可选择性地覆盖其中某些值。*/
//@ExperimentalMaterial3ExpressiveApi
//fun ListItemShapes.复制(
//    形状: Shape? = this.shape,
//    已选择形状: Shape? = this.selectedShape,
//    按压形状: Shape? = this.pressedShape,
//    聚焦形状: Shape? = this.focusedShape,
//    悬停形状: Shape? = this.hoveredShape,
//    拖拽形状: Shape? = this.draggedShape,
//): ListItemShapes =
//    this.copy(
//        shape = 形状,
//        selectedShape = 已选择形状,
//        pressedShape = 按压形状,
//        focusedShape = 聚焦形状,
//        hoveredShape = 悬停形状,
//        draggedShape = 拖拽形状,
//    )
//
//
////==================================================================================
//
//
///**
// * 表示列表项在不同状态下的阴影高度（elevation）。
// *
// * @param 阴影 列表项的默认阴影高度。
// * @param 拖拽阴影 列表项被拖拽时的阴影高度。
// */
//@ExperimentalMaterial3ExpressiveApi
//fun 列表项阴影(
//    阴影: Dp,
//    拖拽阴影: Dp
//) =
//    ListItemElevation(
//        elevation = 阴影,
//        draggedElevation = 拖拽阴影,
//    )
//
//@ExperimentalMaterial3ExpressiveApi
//val ListItemElevation.阴影: Dp
//    get() = this.elevation
//
//@ExperimentalMaterial3ExpressiveApi
//val ListItemElevation.拖拽阴影: Dp
//    get() = this.draggedElevation
