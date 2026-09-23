package 安卓x.组合.材质3

import androidx.annotation.FloatRange
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationState
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.animateDecay
import androidx.compose.animation.core.animateTo
import androidx.compose.animation.core.tween
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.DraggableState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.*
import 安卓x.组合.材质3.令牌集.MotionTokens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.annotation.FrequentlyChangingValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.PopupProperties
import kotlin.math.abs
import kotlin.math.roundToInt

/**
 * [Material Design search](https://m3.material.io/components/search/overview)
 *
 * 搜索栏表示一个允许用户输入关键词或短语并获取相关信息的输入框。它可以作为用户通过搜索查询在应用中导航的一种方式。
 *
 * ![Search bar image](https://developer.android.com/images/reference/androidx/compose/material3/search-bar.png)
 *
 * [搜索栏] 组件表示收起状态下的搜索栏。它应与 [ExpandedFullScreenSearchBar] 或 [ExpandedDockedSearchBar]
 * 配合使用，以便在展开时显示搜索结果。
 *
 * @param 状态 搜索栏的状态。此状态也应传递给 [输入字段] 和展开的搜索栏。
 * @param 输入字段 此搜索栏的输入框，用于输入查询内容，通常为 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于收起状态下此搜索栏的 [Modifier]。
 * @param 形状 此搜索栏在收起状态下的形状。
 * @param 颜色集 用于解析此搜索栏在不同状态下所使用颜色的 [SearchBarColors]。参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 取值为 [ColorScheme.surface] 时，
 * 容器上方会叠加一层半透明的主题色。色调海拔值越高，在浅色主题下颜色越深，在深色主题下颜色越浅。另见：[表面]。
 * @param 视觉阴影 此搜索栏下方阴影的海拔高度。
 */
@Suppress("ComposableLambdaParameterNaming", "ComposableLambdaParameterPosition",
    "ComposableNaming"
)
@ExperimentalMaterial3Api
@Composable
fun 搜索栏(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色集: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
) =
    SearchBar(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
    )

/**
 * [Material Design search](https://m3.material.io/components/search/overview)
 *
 * 搜索栏代表一个允许用户输入关键词或短语并获取相关信息的字段。它可以作为用户通过搜索查询在应用中导航的一种方式。
 *
 * ![Search bar image](https://developer.android.com/images/reference/androidx/compose/material3/search-bar.png)
 *
 * [顶部搜索栏] 是一个 [搜索栏]，额外处理了顶部应用栏的行为，例如窗口内边距和滚动。将 [顶部搜索栏] 用作 [脚手架]
 * 的顶部栏可确保搜索栏始终位于屏幕顶部。与 [搜索栏] 一样，[顶部搜索栏] 应与 [ExpandedFullScreenSearchBar]
 * 或 [ExpandedDockedSearchBar] 配合使用，以便在展开时显示搜索结果。
 *
 * @param 状态 搜索栏的状态。此状态也应传递给 [输入字段] 和展开后的搜索栏。
 * @param 输入字段 此搜索栏的输入字段，允许输入查询，通常是 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于折叠状态下此搜索栏的 [Modifier]。
 * @param 形状 折叠状态下此搜索栏的形状。
 * @param 颜色集 用于解析此搜索栏在不同状态下所用颜色的 [SearchBarColors]。参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方应用一层半透明的主色叠加层。
 * 较高的色调海拔值会在浅色主题下产生更深的颜色，在深色主题下产生更浅的颜色。另请参见：[表面]。
 * @param 视觉阴影 此搜索栏下方阴影的海拔高度。
 * @param 窗口插入 搜索栏在折叠状态下会遵守的窗口内边距。
 * @param 滚动行为 一个 [SearchBarScrollBehavior]，它与滚动内容配合使用，在内容滚动时改变搜索栏的外观。
 * 如果为 null，搜索栏将不会自动响应滚动。
 */
@Deprecated(
    message = "Renamed to `AppBarWithSearch`",
    replaceWith =
        ReplaceWith(
            "AppBarWithSearch(state, inputField, modifier, navigationIcon, actions, shape, " +
                    "colors, tonalElevation, windowInsets, scrollBehavior)"
        ),
)
@Suppress("ComposableLambdaParameterNaming", "ComposableLambdaParameterPosition",
    "ComposableNaming"
)
@ExperimentalMaterial3Api
@Composable
fun 顶部搜索栏(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色集: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    窗口插入: WindowInsets = SearchBarDefaults.windowInsets,
    滚动行为: SearchBarScrollBehavior? = null,
) =
    TopSearchBar(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        windowInsets = 窗口插入,
        scrollBehavior = 滚动行为,
    )


/**
 * [Material Design search](https://m3.material.io/components/search/overview)
 *
 * 搜索栏代表一个允许用户输入关键词或短语并获取相关信息的字段。它可以作为用户通过搜索查询在应用中导航的一种方式。
 *
 * ![Search bar image](https://developer.android.com/images/reference/androidx/compose/material3/search-bar.png)
 *
 * [应用栏带搜索] 是一个 [搜索栏]，额外处理了顶部应用栏的行为，例如窗口内边距和滚动。将 [应用栏带搜索]
 * 用作 [脚手架] 的顶部栏可确保搜索栏始终位于屏幕顶部。与 [搜索栏] 一样，[应用栏带搜索] 应与
 * [ExpandedFullScreenSearchBar] 或 [ExpandedDockedSearchBar] 配合使用，以便在展开时显示搜索结果。
 *
 * @param 状态 搜索栏的状态。此状态也应传递给 [输入字段] 和展开后的搜索栏。
 * @param 输入字段 此搜索栏的输入字段，允许输入查询，通常是 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于折叠状态下此搜索栏的 [Modifier]。
 * @param 导航图标 显示在应用栏搜索栏之前的图标。通常应为 [图标按钮] 或 [图标切换按钮]。
 * @param 操作集 显示在应用栏搜索栏之后的图标。通常应为 [图标按钮]。此处的默认布局是 [Row]，因此其中的图标将水平排列。
 * @param 形状 折叠状态下此搜索栏的形状。
 * @param 颜色集 用于解析此搜索栏所用颜色的 [SearchBarColors]。参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方
 * 应用一层半透明的主色叠加层。较高的色调海拔值会在浅色主题下产生更深的颜色，在深色主题下产生更浅的颜色。另请参见：[表面]。
 * @param 视觉阴影 此搜索栏下方阴影的海拔高度。
 * @param 内容内边距 应用于容器与内容之间内部的间距值。
 * @param 窗口插入 搜索栏在折叠状态下会遵守的窗口内边距。
 * @param 滚动行为 一个 [SearchBarScrollBehavior]，它与滚动内容配合使用，在内容滚动时改变搜索栏的外观。
 * 如果为 null，搜索栏将不会自动响应滚动。
 */
@Suppress("ComposableLambdaParameterNaming", "ComposableLambdaParameterPosition",
    "ComposableNaming"
)
@ExperimentalMaterial3Api
@Composable
fun 应用栏带搜索(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable (() -> Unit)? = null,
    操作集: @Composable (RowScope.() -> Unit)? = null,
    形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色集: AppBarWithSearchColors = SearchBarDefaults.appBarWithSearchColors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    内容内边距: PaddingValues = SearchBarDefaults.AppBarContentPadding,
    窗口插入: WindowInsets = SearchBarDefaults.windowInsets,
    滚动行为: SearchBarScrollBehavior? = null,
) =
    AppBarWithSearch(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 操作集,
        shape = 形状,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        contentPadding = 内容内边距,
        windowInsets = 窗口插入,
        scrollBehavior = 滚动行为,
    )


/**
 * [ExpandedFullScreenContainedSearchBar] 代表一个正在展开或已处于展开状态的搜索栏，显示搜索结果，保留 [输入字段]
 * 的折叠形状且不带分隔线。此组件在新的全屏对话框中显示。如果这种展开行为不符合需求，例如在中等或大屏幕设备（如平板电脑）上，
 * 可以使用 [ExpandedDockedSearchBar] 替代。
 *
 * @param 状态 搜索栏的状态。此状态也应传递给 [输入字段] 和折叠状态下的搜索栏。
 * @param 输入字段 此搜索栏的输入字段，允许输入查询，通常是 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于展开状态下此搜索栏的 [Modifier]。
 * @param 已折叠形状 搜索栏折叠时的形状。当完全展开时，形状将始终为 [SearchBarDefaults.fullScreenShape]。
 * @param 颜色集 用于解析此搜索栏在不同状态下所用颜色的 [SearchBarColors]。参见 [SearchBarDefaults.containedColors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方应用一层半透明的主色叠加层。
 * 较高的色调海拔值会在浅色主题下产生更深的颜色，在深色主题下产生更浅的颜色。另请参见：[表面]。
 * @param 视觉阴影 此搜索栏下方阴影的海拔高度。
 * @param 窗口插入 此搜索栏在展开状态下会遵守的窗口内边距。
 * @param 属性集 用于配置对话框行为的平台特定属性。任何限制对话框大小的属性（例如 [DialogProperties.usePlatformDefaultWidth]）均会被忽略。
 * @param 内容 此搜索栏的内容，用于在 [输入字段] 下方显示搜索结果。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 已展开全屏容器搜索栏(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已折叠形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色集: SearchBarColors = SearchBarDefaults.containedColors(state = 状态),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    窗口插入: @Composable () -> WindowInsets = { SearchBarDefaults.fullScreenWindowInsets },
    属性集: DialogProperties = DialogProperties(),
    内容: @Composable ColumnScope.() -> Unit,
) =
    ExpandedFullScreenContainedSearchBar(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        collapsedShape = 已折叠形状,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        windowInsets = 窗口插入,
        properties = 属性集,
        content = 内容,
    )


/**
 * [ExpandedFullScreenSearchBar] 代表一个正在展开或已处于展开状态的搜索栏，显示搜索结果。此组件在新的全屏对话框中显示。
 * 如果这种展开行为不符合需求，例如在中等或大屏幕设备（如平板电脑）上，可以使用 [ExpandedDockedSearchBar] 替代。
 *
 * @param 状态 搜索栏的状态。此状态也应传递给 [输入字段] 和折叠状态下的搜索栏。
 * @param 输入字段 此搜索栏的输入字段，允许输入查询，通常是 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于展开状态下此搜索栏的 [Modifier]。
 * @param 已折叠形状 搜索栏折叠时的形状。当完全展开时，形状将始终为 [SearchBarDefaults.fullScreenShape]。
 * @param 颜色集 用于解析此搜索栏在不同状态下所用颜色的 [SearchBarColors]。参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方应用一层半透明的主色叠加层。
 * 较高的色调海拔值会在浅色主题下产生更深的颜色，在深色主题下产生更浅的颜色。另请参见：[表面]。
 * @param 视觉阴影 此搜索栏下方阴影的海拔高度。
 * @param 窗口插入 此搜索栏在展开状态下会遵守的窗口内边距。
 * @param 属性集 用于配置对话框行为的平台特定属性。任何限制对话框大小的属性（例如 [DialogProperties.usePlatformDefaultWidth]）均会被忽略。
 * @param 内容 此搜索栏的内容，用于在 [输入字段] 下方显示搜索结果。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3Api
@Composable
fun 已展开全屏搜索栏(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已折叠形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色集: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    窗口插入: @Composable () -> WindowInsets = { SearchBarDefaults.fullScreenWindowInsets },
    属性集: DialogProperties = DialogProperties(),
    内容: @Composable ColumnScope.() -> Unit,
) =
    ExpandedFullScreenSearchBar(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        collapsedShape = 已折叠形状,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        windowInsets = 窗口插入,
        properties = 属性集,
        content = 内容,
    )


/**
 * [ExpandedDockedSearchBarWithGap] 代表一个正在展开或已处于展开状态的搜索栏，显示搜索结果。此组件在折叠搜索栏下方以
 * 弹出窗口形式显示（带间隙）。建议在中等和大型屏幕设备（如平板电脑）上使用 [ExpandedDockedSearchBarWithGap]，
 * 而在紧凑型屏幕设备（如手机）上使用[ExpandedFullScreenSearchBar]。
 *
 * @param 状态 搜索栏的状态。此状态也应传递给 [输入字段] 和折叠状态下的搜索栏。
 * @param 输入字段 此搜索栏的输入字段，允许输入查询，通常是 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于展开状态下此搜索栏的 [Modifier]。
 * @param 形状 包裹 [输入字段] 和 [内容] 的容器的形状。
 * @param 下拉形状 包含搜索结果的下拉框的形状。
 * @param 下拉间隙大小 包含搜索结果的下拉框与搜索栏之间的间隙大小。
 * @param 下拉遮罩颜色 用于下拉框后方遮罩层的 [Color]。使用 [Color.Unspecified] 可移除遮罩层。
 * @param 颜色集 用于解析此搜索栏在不同状态下所用颜色的 [SearchBarColors]。参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方应用一层半透明的主色叠加层。
 * 较高的色调海拔值会在浅色主题下产生更深的颜色，在深色主题下产生更浅的颜色。另请参见：[表面]。
 * @param 视觉阴影 此搜索栏下方阴影的海拔高度。
 * @param 属性集 用于配置对话框行为的平台特定属性。任何限制对话框大小的属性（例如 [DialogProperties.usePlatformDefaultWidth]）均会被忽略。
 * @param 内容 此搜索栏的内容，用于在 [输入字段] 下方显示搜索结果。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 已展开固定搜索栏带间隙(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = SearchBarDefaults.dockedShape,
    下拉形状: Shape = SearchBarDefaults.dockedDropdownShape,
    下拉间隙大小: Dp = SearchBarDefaults.dockedDropdownGapSize,
    下拉遮罩颜色: Color = SearchBarDefaults.dockedDropdownScrimColor,
    颜色集: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    属性集: PopupProperties = PopupProperties(focusable = true, clippingEnabled = false),
    内容: @Composable ColumnScope.() -> Unit,
) =
    ExpandedDockedSearchBarWithGap(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        shape = 形状,
        dropdownShape = 下拉形状,
        dropdownGapSize = 下拉间隙大小,
        dropdownScrimColor = 下拉遮罩颜色,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        properties = 属性集,
        content = 内容,
    )


/**
 * [已展开固定搜索栏] 代表一个正在展开或已处于展开状态的搜索栏，显示搜索结果。此组件在折叠搜索栏上方以弹出窗口形式显示。
 * 建议在中等和大型屏幕设备（如平板电脑）上使用 [已展开固定搜索栏]，而在紧凑型屏幕设备（如手机）上使用[ExpandedFullScreenSearchBar]。
 *
 * @param 状态 搜索栏的状态。此状态也应传递给 [输入字段] 和折叠状态下的搜索栏。
 * @param 输入字段 此搜索栏的输入字段，允许输入查询，通常是 [SearchBarDefaults.InputField]。
 * @param 修饰符 应用于展开状态下此搜索栏的 [Modifier]。
 * @param 形状 包裹 [输入字段] 和 [内容] 的容器的形状。
 * @param 颜色集 用于解析此搜索栏在不同状态下所用颜色的 [SearchBarColors]。参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方应用一层半透明的主色叠加层。
 * 较高的色调海拔值会在浅色主题下产生更深的颜色，在深色主题下产生更浅的颜色。另请参见：[表面]。
 * @param 视觉阴影 此搜索栏下方阴影的海拔高度。
 * @param 属性集 用于配置对话框行为的平台特定属性。任何限制对话框大小的属性（例如 [DialogProperties.usePlatformDefaultWidth]）均会被忽略。
 * @param 内容 此搜索栏的内容，用于在 [输入字段] 下方显示搜索结果。
 */
@ExperimentalMaterial3Api
@Composable
fun 已展开固定搜索栏(
    状态: SearchBarState,
    输入字段: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = SearchBarDefaults.dockedShape,
    颜色集: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    属性集: PopupProperties = PopupProperties(focusable = true, clippingEnabled = false),
    内容: @Composable ColumnScope.() -> Unit,
) =
    ExpandedDockedSearchBar(
        state = 状态,
        inputField = 输入字段,
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        properties = 属性集,
        content = 内容,
    )


/**
 * [Material Design search](https://m3.material.io/components/search/overview)
 *
 * 搜索栏代表一个浮动搜索字段，允许用户输入关键词或短语并获取相关信息。它可以作为用户通过搜索查询在应用中导航的一种方式。
 *
 * 搜索栏可以展开为一个搜索"视图"，并可用于显示动态建议或搜索结果。
 *
 * ![Search bar image](https://developer.android.com/images/reference/androidx/compose/material3/search-bar.png)
 *
 * [搜索栏] 在展开状态下会尝试占据其允许尺寸的全部空间。要实现 Material 指南规定的全屏行为，[搜索栏] 的父布局不得传递任何
 * 限制其大小的 [Constraints]，并且宿主 Activity 应设置 WindowCompat.setDecorFitsSystemWindows(window, false)。
 *
 * 如果这种展开行为不符合需求，例如在大型平板电脑屏幕上，可以使用 [DockedSearchBar] 替代。
 *
 * @param 输入字段 此搜索栏的输入字段，允许输入查询，通常是 [SearchBarDefaults.InputField]。
 * @param 已展开 此搜索栏是否已展开并显示搜索结果。
 * @param 已展开改变回调 当此搜索栏的展开状态改变时调用的回调。
 * @param 修饰符 应用于此搜索栏的 [Modifier]。
 * @param 形状 此搜索栏在未展开时的形状。当展开时，形状将始终为 [SearchBarDefaults.fullScreenShape]。
 * @param 颜色集 用于解析此搜索栏在不同状态下所用颜色的 [SearchBarColors]。参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方应用一层
 * 半透明的主色叠加层。较高的色调海拔值会在浅色主题下产生更深的颜色，在深色主题下产生更浅的颜色。另请参见：[表面]。
 * @param 视觉阴影 此搜索栏下方阴影的海拔高度。
 * @param 窗口插入 此搜索栏将遵守的窗口内边距。
 * @param 内容 此搜索栏的内容，用于在 [输入字段] 下方显示搜索结果。
 */
@ExperimentalMaterial3Api
@Composable
fun 搜索栏(
    输入字段: @Composable () -> Unit,
    已展开: Boolean,
    已展开改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色集: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    窗口插入: WindowInsets = SearchBarDefaults.windowInsets,
    内容: @Composable ColumnScope.() -> Unit,
) =
    SearchBar(
        inputField = 输入字段,
        expanded = 已展开,
        onExpandedChange = 已展开改变回调,
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        windowInsets = 窗口插入,
        content = 内容,
    )

/**
 * [Material Design search](https://m3.material.io/components/search/overview)
 *
 * 搜索栏代表一个浮动搜索字段，允许用户输入关键词或短语并获取相关信息。它可以作为用户通过搜索查询在应用中导航的一种方式。
 *
 * 搜索栏可以展开为一个搜索"视图"，并可用于显示动态建议或搜索结果。
 *
 * ![Search bar image](https://developer.android.com/images/reference/androidx/compose/material3/docked-search-bar.png)
 *
 * [固定搜索栏] 在输入字段下方以有界表格形式显示搜索结果。当在大型屏幕（如平板电脑）上不希望展开到全屏尺寸时，它是 [搜索栏] 的替代方案。
 *
 * @param 输入字段 此搜索栏的输入字段，允许输入查询，通常是 [SearchBarDefaults.InputField]。
 * @param 已展开 此搜索栏是否已展开并显示搜索结果。
 * @param 已展开改变回调 当此搜索栏的展开状态改变时调用的回调。
 * @param 修饰符 应用于此搜索栏的 [Modifier]。
 * @param 形状 此搜索栏的形状。
 * @param 颜色集 用于解析此搜索栏在不同状态下所用颜色的 [SearchBarColors]。参见 [SearchBarDefaults.colors]。
 * @param 色调阴影 当 [SearchBarColors.containerColor] 为 [ColorScheme.surface] 时，会在容器上方应用一层半
 * 透明的主色叠加层。较高的色调海拔值会在浅色主题下产生更深的颜色，在深色主题下产生更浅的颜色。另请参见：[表面]。
 * @param 视觉阴影 搜索栏下方阴影的海拔高度。
 * @param 内容 此搜索栏的内容，用于在 [输入字段] 下方显示搜索结果。
 */
@ExperimentalMaterial3Api
@Composable
fun 固定搜索栏(
    输入字段: @Composable () -> Unit,
    已展开: Boolean,
    已展开改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = SearchBarDefaults.dockedShape,
    颜色集: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    内容: @Composable ColumnScope.() -> Unit,
) =
    DockedSearchBar(
        inputField = 输入字段,
        expanded = 已展开,
        onExpandedChange = 已展开改变回调,
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        content = 内容,
    )


/** [搜索栏状态] 的可能取值。 */
@ExperimentalMaterial3Api
object 搜索栏值 { // SearchBarValue

    /** 搜索栏处于折叠状态时的状态。 */
    val 已折叠 = SearchBarValue.Collapsed

    /** 搜索栏处于展开状态时的状态。 */
    val 已展开 = SearchBarValue.Expanded

}

/**
 * 构造一个 [SearchBarState]。
 *
 * @param 初始值 搜索栏是收起还是展开的初始值。
 * @param 动画规格用于展开 搜索栏展开时使用的动画规格。
 * @param 动画规格用于折叠 搜索栏收起时使用的动画规格。
 */
@ExperimentalMaterial3Api
fun 搜索栏状态 (
    初始值: SearchBarValue,
    动画规格用于展开: AnimationSpec<Float>,
    动画规格用于折叠: AnimationSpec<Float>,
) =
    SearchBarState(
        initialValue = 初始值,
        animationSpecForExpand = 动画规格用于展开,
        animationSpecForCollapse = 动画规格用于折叠,
    )

/**
 * 构造一个 [SearchBarState]。
 *
 * @param 初始值 搜索栏是收起还是展开的初始值。
 * @param 动画规格用于展开 搜索栏展开时使用的动画规格。
 * @param 动画规格用于折叠 搜索栏收起时使用的动画规格。
 * @param 动画规范用于内容淡入 搜索栏展开时内容使用的动画规格。
 * @param 动画规格用于内容淡出 搜索栏收起时内容使用的动画规格。
 */
@ExperimentalMaterial3Api
fun 搜索栏状态 (
    初始值: SearchBarValue,
    动画规格用于展开: AnimationSpec<Float>,
    动画规格用于折叠: AnimationSpec<Float>,
    动画规范用于内容淡入: AnimationSpec<Float>,
    动画规格用于内容淡出: AnimationSpec<Float>,
) =
    SearchBarState(
        initialValue = 初始值,
        animationSpecForExpand = 动画规格用于展开,
        animationSpecForCollapse = 动画规格用于折叠,
        animationSpecForContentFadeIn = 动画规范用于内容淡入,
        animationSpecForContentFadeOut = 动画规格用于内容淡出,
    )

//===================================================================================

/** 搜索栏收起时的布局坐标（如果可用）。用于协调展开动画。*/
@ExperimentalMaterial3Api
var SearchBarState.折叠坐标: LayoutCoordinates?
    get() =  this.collapsedCoords
    set(value) {
        this.collapsedCoords = value
    }

/** 搜索栏的动画进度，其中 0 表示 [SearchBarValue.Collapsed]（收起状态），1 表示 [SearchBarValue.Expanded]（展开状态）。*/
@ExperimentalMaterial3Api
@get:FloatRange(from = 0.0, to = 1.0)
val SearchBarState.进度: Float
    get() = this.progress


/** 当前状态是否正在执行动画 */
@ExperimentalMaterial3Api
val SearchBarState.是否正在动画: Boolean
    get() = this.isAnimating

/** 搜索栏将要展开还是收起。 */
@ExperimentalMaterial3Api
val SearchBarState.目标值: SearchBarValue
    get() = this.targetValue

/**
 * 搜索栏当前是展开还是收起状态。如果搜索栏当前正在向展开状态或从展开状态执行动画，则 [当前值] 在动画完成前始终为
 * [SearchBarValue.Expanded]。
 */
@ExperimentalMaterial3Api
val SearchBarState.当前值: SearchBarValue
    get() = this.currentValue


/** 将搜索栏动画过渡到展开状态。 */
@ExperimentalMaterial3Api
suspend fun SearchBarState.动画到已展开() = this.animateToExpanded()


/** 将搜索栏动画过渡到收起状态。 */
@ExperimentalMaterial3Api
suspend fun SearchBarState.动画到已折叠() = this.animateToCollapsed()

/**
 * 将搜索栏进度直接跳转到指定的 [fraction]，其中 0 表示 [SearchBarValue.Collapsed]（收起状态），1 表示
 * [SearchBarValue.Expanded]（展开状态）。
 */
@ExperimentalMaterial3Api
suspend fun SearchBarState.吸附到(fraction: Float) = this.snapTo(fraction)

//===================================================================================
@ExperimentalMaterial3Api
object 搜索栏状态 {

    /** [SearchBarState] 的默认 [保存器] 实现。*/
    fun 保存器(
        动画规格用于展开: AnimationSpec<Float>,
        动画规格用于折叠: AnimationSpec<Float>,
    ): Saver<SearchBarState, *> =
        SearchBarState.Saver(
            animationSpecForExpand = 动画规格用于展开,
            animationSpecForCollapse = 动画规格用于折叠,
        )

    /** [SearchBarState] 的默认 [保存器] 实现。 */
    fun 保存器(
        动画规格用于展开: AnimationSpec<Float>,
        动画规格用于折叠: AnimationSpec<Float>,
        动画规范用于内容淡入: AnimationSpec<Float>,
        动画规格用于内容淡出: AnimationSpec<Float>,
    ): Saver<SearchBarState, *> =
        SearchBarState.Saver(
            animationSpecForExpand = 动画规格用于展开,
            animationSpecForCollapse = 动画规格用于折叠,
            animationSpecForContentFadeIn = 动画规范用于内容淡入,
            animationSpecForContentFadeOut = 动画规格用于内容淡出,
        )

}


/**
 * 创建并记住一个 [SearchBarState]。
 *
 * @param 初始值 搜索栏是收起还是展开的初始值。
 * @param 动画规格用于展开 搜索栏展开时使用的动画规格。
 * @param 动画规格用于折叠 搜索栏收起时使用的动画规格。
 */
@ExperimentalMaterial3Api
@Composable
fun 记住搜索栏状态(
    初始值: SearchBarValue = SearchBarValue.Collapsed,
    动画规格用于展开: AnimationSpec<Float> = MaterialTheme.motionScheme.slowSpatialSpec(),
    动画规格用于折叠: AnimationSpec<Float> = MaterialTheme.motionScheme.defaultSpatialSpec(),
): SearchBarState =
    rememberSearchBarState(
        initialValue = 初始值,
        animationSpecForExpand = 动画规格用于展开,
        animationSpecForCollapse = 动画规格用于折叠,
    )


/**
 * 创建并记住一个 [SearchBarState]，以便与 [ExpandedFullScreenContainedSearchBar] 配合使用。
 *
 * @param 初始值 搜索栏是收起还是展开的初始值。
 * @param 动画规格用于展开 搜索栏展开时使用的动画规格。
 * @param 动画规格用于折叠 搜索栏收起时使用的动画规格。
 * @param 动画规范用于内容淡入 搜索栏展开时内容使用的动画规格。
 * @param 动画规格用于内容淡出 搜索栏收起时内容使用的动画规格。
 */
@ExperimentalMaterial3Api
@Composable
fun 记住容器搜索栏状态(
    初始值: SearchBarValue = SearchBarValue.Collapsed,
    动画规格用于展开: AnimationSpec<Float> = MaterialTheme.motionScheme.fastSpatialSpec(),
    动画规格用于折叠: AnimationSpec<Float> = MaterialTheme.motionScheme.fastSpatialSpec(),
    动画规范用于内容淡入: AnimationSpec<Float> = AnimationForContentFadeInSpec,
    动画规格用于内容淡出: AnimationSpec<Float> = AnimationForContentFadeOutSpec,
): SearchBarState =
    rememberContainedSearchBarState(
        initialValue = 初始值,
        animationSpecForExpand = 动画规格用于展开,
        animationSpecForCollapse = 动画规格用于折叠,
        animationSpecForContentFadeIn = 动画规范用于内容淡入,
        animationSpecForContentFadeOut = 动画规格用于内容淡出,
    )


/**
 * 创建并记住一个 [SearchBarState]，以便与 [ExpandedDockedSearchBarWithGap] 配合使用。
 *
 * @param 初始值 搜索栏是收起还是展开的初始值。
 * @param 动画规格用于展开 搜索栏展开时使用的动画规格。
 * @param 动画规格用于折叠 搜索栏收起时使用的动画规格。
 * @param 动画规范用于内容淡入 搜索栏展开时内容使用的动画规格。
 * @param 动画规格用于内容淡出 搜索栏收起时内容使用的动画规格。
 */
@ExperimentalMaterial3Api
@Composable
fun 记住搜索栏带间隙状态(
    初始值: SearchBarValue = SearchBarValue.Collapsed,
    动画规格用于展开: AnimationSpec<Float> = MaterialTheme.motionScheme.defaultSpatialSpec(),
    动画规格用于折叠: AnimationSpec<Float> = MaterialTheme.motionScheme.fastSpatialSpec(),
    动画规范用于内容淡入: AnimationSpec<Float> = AnimationForContentFadeInSpec,
    动画规格用于内容淡出: AnimationSpec<Float> = AnimationForContentFadeOutSpec,
): SearchBarState =
    rememberSearchBarWithGapState(
        initialValue = 初始值,
        animationSpecForExpand = 动画规格用于展开,
        animationSpecForCollapse = 动画规格用于折叠,
        animationSpecForContentFadeIn = 动画规范用于内容淡入,
        animationSpecForContentFadeOut = 动画规格用于内容淡出,
    )

/**
 * [搜索栏滚动行为] 定义了当搜索栏下方的内容发生滚动时，搜索栏应如何表现。
 *
 * @see [SearchBarDefaults.enterAlwaysSearchBarScrollBehavior]
 */
@ExperimentalMaterial3Api
@Stable
interface 搜索栏滚动行为 { // SearchBarScrollBehavior

    /**
     * 搜索栏因滚动产生的当前偏移量，单位为像素。该偏移量会应用于搜索栏的固定尺寸，以在内容滚动时控制其显示大小。
     *
     * 该值通常为负数。
     *
     * 对 [滚动偏移量] 值的更新会被限制在 [滚动偏移量限制] 和 0 之间。
     */
    @get:FrequentlyChangingValue var 滚动偏移量: Float // scrollOffset

    /**
     * 搜索栏因滚动可产生的偏移量上限，单位为像素。
     *
     * 该值通常为负数。
     *
     * 在 [滚动偏移量] 值更新时，使用此限制来对其进行约束。
     */
    var 滚动偏移量限制: Float // scrollOffsetLimit

    /**
     * 搜索栏下方内容滚动的总偏移量。
     *
     * 内容偏移量用于计算 [重叠比例]，后续可由具体实现读取。
     *
     * 该值由 [SearchBarScrollBehavior] 在嵌套滚动连接消费滚动事件时进行更新。常见的实现方式是将该值更新为所有
     * [NestedScrollConnection.onPostScroll] 中 consumed.y 值的总和。
     */
    @get:FrequentlyChangingValue var 内容偏移量: Float // contentOffset

    /** 一个 [NestedScrollConnection]，应附加到 [androidx.compose.ui.input.nestedscroll.nestedScroll] 上，以便跟踪滚动事件。*/
    val 嵌套滚动连接: NestedScrollConnection // nestedScrollConnection

    /** 为搜索栏组件添加滚动行为的修饰符。[AppBarWithSearch] 会自动应用此修饰符。*/
    fun Modifier.搜索栏滚动行为(): Modifier // searchBarScrollBehavior

}

//===============================================================================

/**
 * 搜索栏因滚动产生的当前偏移量，单位为像素。该偏移量会应用于搜索栏的固定尺寸，以在内容滚动时控制其显示大小。
 *
 * 该值通常为负数。
 *
 * 对 [滚动偏移量] 值的更新会被限制在 [滚动偏移量限制] 和 0 之间。
 */
@ExperimentalMaterial3Api
@get:FrequentlyChangingValue var SearchBarScrollBehavior.滚动偏移量: Float
    get() = this.scrollOffset
    set(scrollOffset) {
        this.scrollOffset = scrollOffset
    }


/**
 * 搜索栏因滚动可产生的偏移量上限，单位为像素。
 *
 * 该值通常为负数。
 *
 * 在 [滚动偏移量] 值更新时，使用此限制来对其进行约束。
 */
@ExperimentalMaterial3Api
var SearchBarScrollBehavior.滚动偏移量限制: Float
    get() = this.scrollOffsetLimit
    set(newLimit) {
        this.scrollOffsetLimit = newLimit
    }

/**
 * 搜索栏下方内容滚动的总偏移量。
 *
 * 内容偏移量用于计算 [重叠比例]，后续可由具体实现读取。
 *
 * 该值由 [SearchBarScrollBehavior] 在嵌套滚动连接消费滚动事件时进行更新。常见的实现方式是将该值更新为所有
 * [NestedScrollConnection.onPostScroll] 中 consumed.y 值的总和。
 */
@ExperimentalMaterial3Api
@get:FrequentlyChangingValue var SearchBarScrollBehavior.内容偏移量: Float
    get() = this.contentOffset
    set(newOffset) {
        this.contentOffset = newOffset
    }

/** 一个 [NestedScrollConnection]，应附加到 [androidx.compose.ui.input.nestedscroll.nestedScroll] 上，以便跟踪滚动事件。*/
@ExperimentalMaterial3Api
val SearchBarScrollBehavior.嵌套滚动连接: NestedScrollConnection
    get() = this.nestedScrollConnection

//===============================================================================

@OptIn(ExperimentalMaterial3Api::class)
@Stable
private class EnterAlwaysSearchBarScrollBehavior(
    initialOffset: Float,
    initialOffsetLimit: Float,
    initialContentOffset: Float,
    val canScroll: () -> Boolean,
    val reverseLayout: Boolean,
    val snapAnimationSpec: AnimationSpec<Float>,
    val flingAnimationSpec: DecayAnimationSpec<Float>,
) : SearchBarScrollBehavior {
    private var _scrollOffset by mutableFloatStateOf(initialOffset)
    private var _scrollOffsetLimit by mutableFloatStateOf(initialOffsetLimit)
    private var _contentOffset by mutableFloatStateOf(initialContentOffset)

    override var scrollOffset: Float
        @FrequentlyChangingValue get() = _scrollOffset
        set(newOffset) {
            _scrollOffset = newOffset.coerceIn(scrollOffsetLimit, 0f)
        }

    override var scrollOffsetLimit: Float
        get() = _scrollOffsetLimit
        set(newOffset) {
            _scrollOffsetLimit = newOffset
        }

    override var contentOffset: Float
        @FrequentlyChangingValue get() = _contentOffset
        set(newOffset) {
            _contentOffset = newOffset
        }

    override fun Modifier.searchBarScrollBehavior(): Modifier {
        return this.draggable(
            orientation = Orientation.Vertical,
            state = DraggableState { delta -> scrollOffset += delta },
            onDragStopped = { velocity -> settleSearchBar(velocity) },
            enabled = canScroll(),
        )
            .clipToBounds()
            .layout { measurable, constraints ->
                val placeable = measurable.measure(constraints)
                val scrollOffset = scrollOffset.roundToInt()
                val scrolledHeight = (placeable.height + scrollOffset).coerceAtLeast(0)
                layout(placeable.width, scrolledHeight) {
                    placeable.placeWithLayer(0, scrollOffset)
                }
            }
            .onSizeChanged { size -> scrollOffsetLimit = -size.height.toFloat() }
    }

    override val nestedScrollConnection: NestedScrollConnection =
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                if (!canScroll()) return Offset.Zero
                val prevScrollOffset = scrollOffset
                scrollOffset += available.y
                // The scrollOffset is coerced between scrollOffsetLimit and 0, so we check if its
                // value was actually changed after available.y is added. If so, the search bar is
                // currently  in between scroll states.
                // Note: when the content is set with reversed layout, we always return Offset.Zero.
                return if (!reverseLayout && prevScrollOffset != scrollOffset) {
                    available.copy(x = 0f)
                } else {
                    Offset.Zero
                }
            }

            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource,
            ): Offset {
                if (!canScroll()) return Offset.Zero
                if (reverseLayout && available.y > 0f) {
                    // In a reversed layout, consume scroll if it's a pull down
                    // to reveal the search bar but not if it's a pull up to hide.
                    scrollOffset += available.y
                    contentOffset += available.y
                    return available.copy(x = 0f)
                }
                if (!reverseLayout) {
                    scrollOffset += consumed.y
                    contentOffset += consumed.y
                }
                return Offset.Zero
            }

            override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {
                if (!canScroll()) return Velocity.Zero
                return settleSearchBar(available.y)
            }
        }

    private suspend fun settleSearchBar(velocity: Float): Velocity {
        // Check if the search bar scroll is at a scroll limit. If so, no need to settle the search
        // bar, and just return Velocity.Zero.
        // Note that we don't check for 0f due to float precision with the scrollFraction
        // calculation.
        val scrollFraction = if (scrollOffsetLimit != 0f) scrollOffset / scrollOffsetLimit else 0f
        if (scrollFraction < 0.01f || scrollFraction == 1f) {
            return Velocity.Zero
        }
        var remainingVelocity = velocity
        // In case there is an initial velocity that was left after a previous user fling, animate
        // to continue the motion to scroll the search bar.
        if (abs(velocity) > 1f) {
            var lastValue = 0f
            AnimationState(initialValue = 0f, initialVelocity = velocity).animateDecay(
                flingAnimationSpec
            ) {
                val delta = value - lastValue
                val initialScrollOffset = scrollOffset
                scrollOffset = initialScrollOffset + delta
                val consumed = abs(initialScrollOffset - scrollOffset)
                lastValue = value
                remainingVelocity = this.velocity
                // avoid rounding errors and stop if anything is unconsumed
                if (abs(delta - consumed) > 0.5f) this.cancelAnimation()
            }
        }
        if (scrollOffsetLimit < scrollOffset && scrollOffset < 0) {
            AnimationState(initialValue = scrollOffset).animateTo(
                targetValue = if (scrollFraction < 0.5f) 0f else scrollOffsetLimit,
                animationSpec = snapAnimationSpec,
            ) {
                scrollOffset = value
            }
        }

        return Velocity(0f, remainingVelocity)
    }

    companion object {
        fun Saver(
            canScroll: () -> Boolean,
            snapAnimationSpec: AnimationSpec<Float>,
            flingAnimationSpec: DecayAnimationSpec<Float>,
        ): Saver<EnterAlwaysSearchBarScrollBehavior, *> =
            listSaver(
                save = {
                    listOf(
                        it.scrollOffset,
                        it.scrollOffsetLimit,
                        it.contentOffset,
                        it.reverseLayout,
                    )
                },
                restore = {
                    EnterAlwaysSearchBarScrollBehavior(
                        initialOffset = it[0] as Float,
                        initialOffsetLimit = it[1] as Float,
                        initialContentOffset = it[2] as Float,
                        reverseLayout = it[3] as Boolean,
                        canScroll = canScroll,
                        snapAnimationSpec = snapAnimationSpec,
                        flingAnimationSpec = flingAnimationSpec,
                    )
                },
            )
    }
}

/** [搜索栏] 和 [固定搜索栏] 中使用的默认值。 */
@ExperimentalMaterial3Api
object 搜索栏默认值 { // SearchBarDefaults

    /** 搜索栏的默认色调海拔。 */
    val 色调阴影: Dp = SearchBarDefaults.TonalElevation

    /** 搜索栏的默认阴影海拔。 */
    val 视觉阴影: Dp = SearchBarDefaults.ShadowElevation

    @Deprecated(
        message = "Renamed to TonalElevation. Not to be confused with ShadowElevation.",
        replaceWith = ReplaceWith("TonalElevation"),
        level = DeprecationLevel.WARNING,
    )
    val 阴影: Dp = SearchBarDefaults.Elevation

    /** 搜索栏输入字段的默认高度，或未展开状态下搜索栏的默认高度。 */
    val 输入字段高度: Dp = SearchBarDefaults.InputFieldHeight

    /** 搜索栏输入字段的默认形状，或未展开状态下搜索栏的默认形状。 */
    val 输入字段形状: Shape
        @Composable get() = SearchBarDefaults.inputFieldShape

    /** 展开状态下 [搜索栏] 的默认形状。 */
    val 全屏形状: Shape
        @Composable get() = SearchBarDefaults.fullScreenShape

    /** 收起状态下 [ExpandedFullScreenContainedSearchBar] 的默认容器颜色。*/
    val 已折叠容器搜索栏颜色: Color
        @Composable get() = SearchBarDefaults.collapsedContainedSearchBarColor

    /** 展开状态下 [ExpandedFullScreenContainedSearchBar] 的默认容器颜色。*/
    val 全屏容器搜索栏颜色: Color
        @Composable
        get() =SearchBarDefaults.fullScreenContainedSearchBarColor // TODO: 替换为令牌。

    /** [DockedSearchBar] 的默认形状。 */
    val 停靠形状: Shape
        @Composable get() = SearchBarDefaults.dockedShape

    /** 附加到 [DockedSearchBar] 的搜索结果下拉列表的默认形状。 */
    val 停靠下拉形状: Shape
        get() = SearchBarDefaults.dockedDropdownShape // TODO: 替换为令牌。

    /** 附加到 [DockedSearchBar] 的下拉列表的默认间隙大小。 */
    val 停靠下拉间隙大小: Dp = SearchBarDefaults.dockedDropdownGapSize // TODO: 替换为令牌。

    /** 这是 [DockedSearchBar] 所附下拉菜单的默认遮罩颜色。 */
    val 停靠下拉遮罩颜色: Color
        @Composable
        get() = SearchBarDefaults.dockedDropdownScrimColor

    /** [AppBarWithSearch] 内容使用的默认内边距。 */
    val 应用栏内容内边距 = SearchBarDefaults.AppBarContentPadding

    /** [AppBarWithSearch] 的默认窗口边衬。 */
    val 窗口插入: WindowInsets
        @Composable
        get() = SearchBarDefaults.windowInsets

    /** [ExpandedFullScreenSearchBar] 使用并消费的默认窗口边衬。 */
    val 全屏窗口插入: WindowInsets
        @Composable get() =  SearchBarDefaults.fullScreenWindowInsets

    /**
     * 返回一个 [SearchBarScrollBehavior]。配置此行为的搜索栏会在内容向上拉动时立即向上滚出屏幕，并在内容向下拉动时立即出现。
     *
     * T返回的 [SearchBarScrollBehavior] 会在重组过程中被记住（跨组合保留）。
     *
     * @param 初始偏移量 [SearchBarScrollBehavior.scrollOffset] 的初始值。应介于 [初始偏移量限制] 和 0 之间。
     * @param 初始偏移量限制 [SearchBarScrollBehavior.scrollOffsetLimit] 的初始值，表示当内容滚动时，搜索栏允许滚出屏幕的像素上限。
     * @param 初始内容偏移量 [SearchBarScrollBehavior.contentOffset] 的初始值。
     * @param 可以滚动 用于确定滚动事件是否应由此 [SearchBarScrollBehavior] 处理的回调。
     * @param 吸附动画规范 一个 [AnimationSpec]，用于定义当快速滑动或拖拽滚动使搜索栏处于中间位置时，其滚动偏移量如何吸附到上限值或 0。
     * @param 抛掷动画规格 一个 [DecayAnimationSpec]，用于定义当用户快速滑动搜索栏本身或其下方内容时，搜索栏的减速动画行为。
     * @param 反向布局 表示此行为应用于具有反向滚动和布局方向的可滚动内容。
     */
    @ExperimentalMaterial3Api
    @Composable
    fun 进入始终搜索栏滚动行为(
        初始偏移量: Float = 0f,
        初始偏移量限制: Float = -Float.MAX_VALUE,
        初始内容偏移量: Float = 0f,
        可以滚动: () -> Boolean = { true },
        // TODO 从组件令牌文件中加载 motionScheme 令牌。
        吸附动画规范: AnimationSpec<Float> = MaterialTheme.motionScheme.defaultEffectsSpec(),
        抛掷动画规格: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
        反向布局: Boolean = false,
    ): SearchBarScrollBehavior =
        SearchBarDefaults.enterAlwaysSearchBarScrollBehavior(
            initialOffset = 初始偏移量,
            initialOffsetLimit = 初始偏移量限制,
            initialContentOffset = 初始内容偏移量,
            canScroll = 可以滚动,
            snapAnimationSpec = 吸附动画规范,
            flingAnimationSpec = 抛掷动画规格,
            reverseLayout = 反向布局,
        )


    /**
     * 创建一个 [SearchBarColors]，用于表示搜索栏各部分使用的不同颜色。
     *
     * @param 容器颜色 搜索栏的容器颜色。
     * @param 分隔线颜色 输入框与搜索结果之间的分隔线颜色。
     * @param 输入字段颜色集 输入框的颜色。可通过 [SearchBarColors.inputFieldColors] 访问，并应传递给搜索栏的 inputField 插槽。
     */
    @Composable
    fun 颜色集(
        容器颜色: Color = MaterialTheme.colorScheme.surfaceContainerHigh,
        分隔线颜色: Color = MaterialTheme.colorScheme.outline,
        输入字段颜色集: TextFieldColors = SearchBarDefaults.inputFieldColors(),
    ): SearchBarColors =
        SearchBarDefaults.colors(
            containerColor = 容器颜色,
            dividerColor = 分隔线颜色,
            inputFieldColors = 输入字段颜色集,
        )

    /**
     * 基于 [SearchBarState] 创建一个 [SearchBarColors]，用于表示搜索栏各部分使用的不同颜色。
     *
     * 此值应与 [ExpandedFullScreenContainedSearchBar] 配合使用，并将其 [输入字段颜色集] 传递给关联的 [输入字段]。
     *
     * @param 状态 搜索栏的状态。
     */
    @Composable
    fun 容器颜色集(状态: SearchBarState): SearchBarColors =
        SearchBarDefaults.containedColors(state = 状态)

    /**
     * 创建一个 [AppBarWithSearchColors]，用于表示 [AppBarWithSearch] 各部分使用的不同颜色。
     *
     * @param 搜索栏颜色集 搜索栏颜色。
     * @param 滚动搜索栏容器颜色 内容滚动时搜索栏的容器颜色。
     * @param 应用栏容器颜色 应用栏的容器颜色。
     * @param 滚动应用栏容器颜色 内容滚动时应用栏的容器颜色。
     * @param 应用栏导航图标颜色 应用栏导航图标所使用的颜色。
     * @param 应用栏操作图标颜色 应用栏操作图标所使用的颜色。
     */
    @Composable
    fun 应用栏带搜索颜色集(
        搜索栏颜色集: SearchBarColors = SearchBarDefaults.colors(),
        // TODO 从组件令牌文件中加载颜色令牌。
        滚动搜索栏容器颜色: Color = MaterialTheme.colorScheme.surfaceContainerHighest,
        应用栏容器颜色: Color = MaterialTheme.colorScheme.surface,
        滚动应用栏容器颜色: Color = MaterialTheme.colorScheme.surfaceContainer,
        应用栏导航图标颜色: Color = MaterialTheme.colorScheme.onSurface,
        应用栏操作图标颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    ): AppBarWithSearchColors =
        SearchBarDefaults.appBarWithSearchColors(
            searchBarColors = 搜索栏颜色集,
            scrolledSearchBarContainerColor = 滚动搜索栏容器颜色,
            appBarContainerColor = 应用栏容器颜色,
            scrolledAppBarContainerColor = 滚动应用栏容器颜色,
            appBarNavigationIconColor = 应用栏导航图标颜色,
            appBarActionIconColor = 应用栏操作图标颜色,
        )

    /**
     * 创建一个 [TextFieldColors]，用于表示搜索栏输入框在不同状态下使用的不同颜色。
     *
     * 仅使用了 [TextFieldColors] 完整参数列表的一个子集。所有其他参数均无效果。
     *
     * @param 聚焦文本颜色 此输入框在获得焦点时，输入文本所使用的颜色。
     * @param 未聚焦文本颜色 此输入框在未获得焦点时，输入文本所使用的颜色。
     * @param 禁用文本颜色 此输入框在禁用时，输入文本所使用的颜色。
     * @param 光标颜色 此输入框的光标颜色。
     * @param 选择颜色集 此输入框的输入文本被选中时使用的颜色。
     * @param 聚焦前导图标颜色 此输入框在获得焦点时，前置图标所使用的颜色。
     * @param 未聚焦前导图标颜色 此输入框在未获得焦点时，前置图标所使用的颜色。
     * @param 禁用前导图标颜色 此输入框在禁用时，前置图标所使用的颜色。
     * @param 聚焦尾随图标颜色 该输入框在聚焦（获得焦点）时尾部图标的颜色
     * @param 未聚焦尾随图标颜色 该输入框在未聚焦（失去焦点）时尾部图标的颜色
     * @param 禁用尾随图标颜色 该输入框在禁用状态下尾部图标的颜色
     * @param 聚焦占位符颜色 该输入框在聚焦（获得焦点）时占位符文本的颜色
     * @param 未聚焦占位符颜色 该输入框在未聚焦（失去焦点）时占位符文本的颜色
     * @param 禁用占位符颜色 该输入框在禁用状态下占位符文本的颜色
     * @param 聚焦前缀颜色 该输入框在聚焦（获得焦点）时前缀文本的颜色
     * @param 未聚焦前缀颜色 该输入框在未聚焦（失去焦点）时前缀文本的颜色
     * @param 禁用前缀颜色 该输入框在禁用状态下前缀的颜色
     * @param 聚焦后缀颜色 此输入框聚焦状态下后缀的颜色
     * @param 未聚焦后缀颜色 此输入框非聚焦状态下后缀的颜色
     * @param 禁用后缀颜色 此输入框禁用状态下后缀的颜色
     * @param 聚焦容器颜色 此输入框聚焦状态下容器的颜色
     * @param 未聚焦容器颜色 此输入框非聚焦状态下容器的颜色
     * @param 禁用容器颜色 此输入框禁用状态下容器的颜色
     */
    @Composable
    fun 输入字段颜色集(
        聚焦文本颜色: Color = MaterialTheme.colorScheme.onSurface,
        未聚焦文本颜色: Color = MaterialTheme.colorScheme.onSurface,
        禁用文本颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        光标颜色: Color = MaterialTheme.colorScheme.primary,
        选择颜色集: TextSelectionColors = LocalTextSelectionColors.current,
        聚焦前导图标颜色: Color = MaterialTheme.colorScheme.onSurface,
        未聚焦前导图标颜色: Color = MaterialTheme.colorScheme.onSurface,
        禁用前导图标颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        聚焦尾随图标颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        未聚焦尾随图标颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        禁用尾随图标颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        聚焦占位符颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        未聚焦占位符颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        禁用占位符颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        聚焦前缀颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        未聚焦前缀颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        禁用前缀颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.38f),
        聚焦后缀颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        未聚焦后缀颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        禁用后缀颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.38f),
        聚焦容器颜色: Color = Color.Transparent,
        未聚焦容器颜色: Color = Color.Transparent,
        禁用容器颜色: Color = Color.Transparent,
    ): TextFieldColors =
        SearchBarDefaults.inputFieldColors(
            focusedTextColor = 聚焦文本颜色,
            unfocusedTextColor = 未聚焦文本颜色,
            disabledTextColor = 禁用文本颜色,
            cursorColor = 光标颜色,
            selectionColors = 选择颜色集,
            focusedLeadingIconColor = 聚焦前导图标颜色,
            unfocusedLeadingIconColor = 未聚焦前导图标颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            focusedTrailingIconColor = 聚焦尾随图标颜色,
            unfocusedTrailingIconColor = 未聚焦尾随图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
            focusedPlaceholderColor = 聚焦占位符颜色,
            unfocusedPlaceholderColor = 未聚焦占位符颜色,
            disabledPlaceholderColor = 禁用占位符颜色,
            focusedPrefixColor = 聚焦前缀颜色,
            unfocusedPrefixColor = 未聚焦前缀颜色,
            disabledPrefixColor = 禁用前缀颜色,
            focusedSuffixColor = 聚焦后缀颜色,
            unfocusedSuffixColor = 未聚焦后缀颜色,
            disabledSuffixColor = 禁用后缀颜色,
            focusedContainerColor = 聚焦容器颜色,
            unfocusedContainerColor = 未聚焦容器颜色,
            disabledContainerColor = 禁用容器颜色,
        )



    /**
     * 搜索栏中用于输入查询内容的文本框。
     *
     * 此 [输入字段] 重载使用 [TextFieldState] 来跟踪文本内容及光标或选区的位置，并使用 [SearchBarState]
     * 来跟踪搜索栏的状态。它应与同样接受 [SearchBarState] 的搜索栏 API 配合使用。
     *
     * @param 文本字段状态 [TextFieldState] 用于保存输入框的内部编辑状态。
     * @param 搜索栏状态 搜索栏的整体状态。
     * @param 搜索回调 当输入法服务触发 [ImeAction.Search] 操作时要调用的回调。回调的参数为 [文本字段状态] 中的当前查询内容。
     * @param 修饰符 要应用于此输入框的 [Modifier]。
     * @param 已启用 该输入框的启用状态。当为 false 时，此组件不会响应用户输入，并且在视觉上呈现为禁用状态，同时对无障碍服务也表现为禁用。
     * @param 只读 控制输入框的可编辑状态。当为 true 时，该字段无法被修改。但用户仍可以聚焦该字段并从中复制文本。
     * @param 文本样式 要应用于输入文本的样式。默认为 [LocalTextStyle]。
     * @param 占位符 当输入文本为空时要显示的占位符。
     * @param 前导图标 要在输入字段开头显示的引导图标。
     * @param 尾随图标 要在输入字段末尾显示的尾部图标。
     * @param 前缀 要在输入文本之前显示的可选前缀。
     * @param 后缀 要在输入文本之后显示的可选后缀。
     * @param 输入转换 可选的 [InputTransformation]，用于转换用户对 [TextFieldState] 所做的更改。
     * 该转换将应用于由硬件和软件键盘事件、粘贴或拖放文本、无障碍服务以及测试所引起的更改。当通过代码以编程方式更改 [文本字段状态]，
     * 或转换本身发生变更时，不会应用该转换。如果在现有文本字段上更改转换，它将在下一次用户编辑时生效。该转换不会立即影响当前的 [文本字段状态]。
     * @param 输出转换 可选的 [OutputTransformation]，用于转换文本字段内容的呈现方式。
     * @param 滚动状态 管理输入字段水平滚动的滚动状态。
     * @param 形状 输入字段的形状。
     * @param 颜色集 用于解析此输入字段在不同状态下所使用颜色的 [TextFieldColors]。详见 [SearchBarDefaults.inputFieldColors]。
     * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送此输入字段的 [Interaction]。
     * 您可以使用它来更改搜索栏的外观或在不同状态下预览搜索栏。请注意，如果提供 null，交互仍会在内部发生。
     * @param 键盘选项 包含 [KeyboardType] 等配置的软件键盘选项。请注意，[ImeAction] 将始终被覆盖为 [ImeAction.Search]。
     * @param 行限制 文本字段应为 [TextFieldLineLimits.SingleLine]（水平滚动并忽略换行符），
     * 还是 [TextFieldLineLimits.MultiLine]（垂直扩展并滚动）。
     */
    @Suppress("ComposableNaming")
    @ExperimentalMaterial3Api
    @Composable
    fun 输入字段(
        文本字段状态: TextFieldState,
        搜索栏状态: SearchBarState,
        搜索回调: (String) -> Unit,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        只读: Boolean = false,
        文本样式: TextStyle = LocalTextStyle.current,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        输入转换: InputTransformation? = null,
        输出转换: OutputTransformation? = null,
        滚动状态: ScrollState = rememberScrollState(),
        形状: Shape = SearchBarDefaults.inputFieldShape,
        颜色集: TextFieldColors = SearchBarDefaults.inputFieldColors(),
        交互源: MutableInteractionSource? = null,
        键盘选项: KeyboardOptions = KeyboardOptions.Default,
        行限制: TextFieldLineLimits = TextFieldLineLimits.SingleLine,
    ) =
        SearchBarDefaults.InputField(
            textFieldState = 文本字段状态,
            searchBarState = 搜索栏状态,
            onSearch = 搜索回调,
            modifier = 修饰符,
            enabled = 已启用,
            readOnly = 只读,
            textStyle = 文本样式,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            inputTransformation = 输入转换,
            outputTransformation = 输出转换,
            scrollState = 滚动状态,
            shape = 形状,
            colors = 颜色集,
            interactionSource = 交互源,
            keyboardOptions = 键盘选项,
            lineLimits = 行限制,
        )

    /**
     * 搜索栏中用于输入查询的文本字段。
     *
     * 此 [输入字段] 重载使用 [TextFieldState] 来跟踪文本内容以及光标或选区的位置，并使用 [已展开] 和 [已展开改变回调]
     * 来跟踪搜索栏的状态。它应与同样接受 [已展开] 和 [已展开改变回调] 的搜索栏 API 配合使用。
     *
     * @param 状态 [TextFieldState]，用于保存输入框的内部编辑状态。
     * @param 搜索回调 当输入法触发 [ImeAction.Search] 操作时调用的回调。[状态] 中的当前查询内容会作为该回调的参数传入。
     * @param 已展开 搜索栏是否已展开并显示搜索结果。
     * @param 已展开改变回调 当搜索栏的展开状态发生变化时调用的回调。
     * @param 修饰符 要应用于此输入框的 [Modifier]。
     * @param 已启用 此输入框的启用状态。当为 false 时，该组件不会响应用户输入，并且在视觉上呈现为禁用状态，同时对无障碍服务也表现为禁用。
     * @param 只读 控制输入框的可编辑状态。当为 true 时，该字段无法被修改。但用户仍可以聚焦该字段并从中复制文本。
     * @param 文本样式 应用于输入文本的样式。默认为 [LocalTextStyle]。
     * @param 占位符 当输入文本为空时显示的占位提示文本。
     * @param 前导图标 显示在输入框起始位置的引导图标。
     * @param 尾随图标 显示在输入框末尾位置的尾部图标。
     * @param 前缀 显示在输入文本之前的可选前缀。
     * @param 后缀 显示在输入文本之后的可选后缀。
     * @param 输入转换 可选的 [InputTransformation]，用于转换用户对 [TextFieldState] 所做的更改。
     * 该转换将应用于硬件和软件键盘事件、粘贴或拖放文本、无障碍服务以及测试所带来的更改。当通过编程方式更改 [状态] 或转换本身被更改时，
     * 该转换将 不会 被应用。如果对现有文本字段更改了转换，该转换将在下一次用户编辑时生效。该转换不会立即影响当前的 [状态]。
     * @param 输出转换 可选的 [OutputTransformation]，用于转换文本字段内容的呈现方式。
     * @param 滚动状态 管理输入框水平滚动的滚动状态。
     * @param 形状 输入框的形状。
     * @param 颜色集 用于解析此输入框在不同状态下所用颜色的 [TextFieldColors]。请参阅 [SearchBarDefaults.inputFieldColors]。
     * @param 交互源 用于观察此输入框并发送 [Interaction] 的可选提升式 [MutableInteractionSource]。
     * 你可以使用它来更改搜索栏的外观或在不同的状态下预览搜索栏。请注意，如果提供的值为 null，交互仍会在内部发生。
     */
    @Suppress("ComposableNaming")
    @ExperimentalMaterial3Api
    @Composable
    fun 输入字段(
        状态: TextFieldState,
        搜索回调: (String) -> Unit,
        已展开: Boolean,
        已展开改变回调: (Boolean) -> Unit,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        只读: Boolean = false,
        文本样式: TextStyle = LocalTextStyle.current,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        输入转换: InputTransformation? = null,
        输出转换: OutputTransformation? = null,
        滚动状态: ScrollState = rememberScrollState(),
        形状: Shape = SearchBarDefaults.inputFieldShape,
        颜色集: TextFieldColors = SearchBarDefaults.inputFieldColors(),
        交互源: MutableInteractionSource? = null,
    ) =
        SearchBarDefaults.InputField(
            state = 状态,
            onSearch = 搜索回调,
            expanded = 已展开,
            onExpandedChange = 已展开改变回调,
            modifier = 修饰符,
            enabled = 已启用,
            readOnly = 只读,
            textStyle = 文本样式,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            inputTransformation = 输入转换,
            outputTransformation = 输出转换,
            scrollState = 滚动状态,
            shape = 形状,
            colors = 颜色集,
            interactionSource = 交互源,
        )

    /**
     * 用于在搜索栏中输入查询内容的文本框。
     *
     * 此 [输入字段] 的重载接受 [查询] 和 [查询改变回调] 回调来跟踪文本内容。建议改用接受 [TextFieldState] 的重载。
     *
     * @param 查询 要显示在输入框中的查询文本。
     * @param 查询改变回调 当输入服务更新查询时调用的回调。更新后的文本将作为回调的参数传入。
     * @param 搜索回调 当输入服务触发 [ImeAction.Search] 动作时调用的回调。当前的 [查询] 将作为回调的参数传入。
     * @param 已展开 搜索栏是否已展开并显示搜索结果。
     * @param 已展开改变回调 当搜索栏的展开状态发生变化时调用的回调。
     * @param 修饰符 要应用于此输入框的 [Modifier]。
     * @param 已启用 此输入框的启用状态。当为 false 时，该组件将不会响应用户输入，并且在视觉上呈现为禁用状态，同时也会在无障碍服务中被禁用。
     * @param 占位符 当 [查询] 为空时显示的占位符。
     * @param 前导图标 显示在输入框起始位置的前置图标。
     * @param 尾随图标 显示在输入框末尾的后置图标。
     * @param 颜色集 用于解析此输入框在不同状态下所用颜色的 [TextFieldColors]。请参阅 [SearchBarDefaults.inputFieldColors]。
     * @param 交互源 用于观察此输入框并发送 [Interaction] 的可选提升式 [MutableInteractionSource]。
     * 你可以使用它来更改搜索栏的外观或在不同状态下预览搜索栏。请注意，如果提供的值为 null，交互仍会在内部发生。
     */
    @Suppress("ComposableNaming")
    @ExperimentalMaterial3Api
    @Composable
    fun 输入字段(
        查询: String,
        查询改变回调: (String) -> Unit,
        搜索回调: (String) -> Unit,
        已展开: Boolean,
        已展开改变回调: (Boolean) -> Unit,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        颜色集: TextFieldColors = SearchBarDefaults.inputFieldColors(),
        交互源: MutableInteractionSource? = null,
    ) =
        SearchBarDefaults.InputField(
            query = 查询,
            onQueryChange = 查询改变回调,
            onSearch = 搜索回调,
            expanded = 已展开,
            onExpandedChange = 已展开改变回调,
            modifier = 修饰符,
            enabled = 已启用,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            colors = 颜色集,
            interactionSource = 交互源,
        )

}


/**
 * 表示搜索栏所使用的颜色。
 *
 * 有关遵循 Material 规范的默认实现，请参阅 [SearchBarDefaults.colors]。
 */
@ExperimentalMaterial3Api
fun 搜索栏颜色集( // SearchBarColors
    容器颜色: Color,
    分隔线颜色: Color,
    输入字段颜色集: TextFieldColors,
) =
    SearchBarColors(
        containerColor = 容器颜色,
        dividerColor = 分隔线颜色,
        inputFieldColors = 输入字段颜色集,
    )


@Deprecated(
    message = "Use overload that takes `inputFieldColors`",
    replaceWith = ReplaceWith("SearchBarColors(containerColor, dividerColor, inputFieldColors)"),
)
@ExperimentalMaterial3Api
fun 搜索栏颜色集(
    容器颜色: Color,
    分隔线颜色: Color,
) =
    SearchBarColors(
        containerColor = 容器颜色,
        dividerColor = 分隔线颜色,
    )


/** 返回此 SearchBarColors 的副本，可选择性地覆盖其中部分值。 */
@ExperimentalMaterial3Api
fun SearchBarColors.复制(
    容器颜色: Color = this.containerColor,
    分隔线颜色: Color = this.dividerColor,
    输入字段颜色集: TextFieldColors = this.inputFieldColors,
) =
    this.copy(
        containerColor = 容器颜色,
        dividerColor = 分隔线颜色,
        inputFieldColors = 输入字段颜色集,
    )

//==========================================================================

@ExperimentalMaterial3Api
val SearchBarColors.容器颜色: Color
    get() = this.containerColor

@ExperimentalMaterial3Api
val SearchBarColors.分隔线颜色: Color
    get() = this.dividerColor

@ExperimentalMaterial3Api
val SearchBarColors.输入字段颜色集: TextFieldColors
    get() = this.inputFieldColors

//==========================================================================

/**
 * 表示 [AppBarWithSearch] 所使用的颜色。
 *
 * 有关遵循 Material 规范的默认实现，请参阅 [SearchBarDefaults.appBarWithSearchColors]。
 *
 * @param 搜索栏颜色集 此应用栏中 [SearchBar] 所使用的颜色。
 * @param 滚动搜索栏容器颜色 内容滚动时搜索栏的容器颜色
 * @param 应用栏容器颜色 应用栏容器颜色。使用 [Color.Transparent] 可表示无颜色。
 * @param 滚动应用栏容器颜色 内容滚动时应用栏的容器颜色。
 * @param 应用栏导航图标颜色 用于应用栏导航图标的颜色。
 * @param 应用栏操作图标颜色 用于应用栏操作图标的颜色。
 */
@ExperimentalMaterial3Api
fun 应用栏带搜索颜色集(
    搜索栏颜色集: SearchBarColors,
    滚动搜索栏容器颜色: Color,
    应用栏容器颜色: Color,
    滚动应用栏容器颜色: Color,
    应用栏导航图标颜色: Color,
    应用栏操作图标颜色: Color,
) =
    AppBarWithSearchColors(
        searchBarColors = 搜索栏颜色集,
        scrolledSearchBarContainerColor = 滚动搜索栏容器颜色,
        appBarContainerColor = 应用栏容器颜色,
        scrolledAppBarContainerColor = 滚动应用栏容器颜色,
        appBarNavigationIconColor = 应用栏导航图标颜色,
        appBarActionIconColor = 应用栏操作图标颜色,
    )


@ExperimentalMaterial3Api
fun 应用栏带搜索颜色集(
    搜索栏颜色集: SearchBarColors,
    应用栏容器颜色: Color,
    应用栏导航图标颜色: Color,
    应用栏操作图标颜色: Color,
) =
    AppBarWithSearchColors(
        searchBarColors = 搜索栏颜色集,
        appBarContainerColor = 应用栏容器颜色,
        appBarNavigationIconColor = 应用栏导航图标颜色,
        appBarActionIconColor = 应用栏操作图标颜色,
    )

//======================================================================================

@ExperimentalMaterial3Api
val AppBarWithSearchColors.搜索栏颜色集: SearchBarColors
    get() = this.searchBarColors

@ExperimentalMaterial3Api
val AppBarWithSearchColors.滚动搜索栏容器颜色: Color
    get() = this.scrolledSearchBarContainerColor

@ExperimentalMaterial3Api
val AppBarWithSearchColors.应用栏容器颜色: Color
    get() = this.appBarContainerColor

@ExperimentalMaterial3Api
val AppBarWithSearchColors.滚动应用栏容器颜色: Color
    get() = this.scrolledAppBarContainerColor

@ExperimentalMaterial3Api
val AppBarWithSearchColors.应用栏导航图标颜色: Color
    get() = this.appBarNavigationIconColor

@ExperimentalMaterial3Api
val AppBarWithSearchColors.应用栏操作图标颜色: Color
    get() = this.appBarActionIconColor


//======================================================================================



@Suppress("DEPRECATION", "ComposableNaming")
@Deprecated(
    message = "Use overload which takes inputField as a parameter",
    replaceWith =
        ReplaceWith(
            "SearchBar(\n" +
                    "    inputField = {\n" +
                    "        SearchBarDefaults.InputField(\n" +
                    "            textFieldState = textFieldState,\n" +
                    "            searchBarState = searchBarState,\n" +
                    "            onSearch = onSearch,\n" +
                    "            modifier = modifier,\n" +
                    "            enabled = enabled,\n" +
                    "            readOnly = readOnly,\n" +
                    "            textStyle = textStyle,\n" +
                    "            placeholder = placeholder,\n" +
                    "            leadingIcon = leadingIcon,\n" +
                    "            trailingIcon = trailingIcon,\n" +
                    "            prefix = prefix,\n" +
                    "            suffix = suffix,\n" +
                    "            inputTransformation = inputTransformation,\n" +
                    "            outputTransformation = outputTransformation,\n" +
                    "            scrollState = scrollState,\n" +
                    "            shape = shape,\n" +
                    "            colors = colors,\n" +
                    "            interactionSource = interactionSource,\n" +
                    "            keyboardOptions = keyboardOptions,\n" +
                    "            lineLimits = lineLimits,\n" +
                    "        )\n" +
                    "    },\n" +
                    "    expanded = active,\n" +
                    "    onExpandedChange = onActiveChange,\n" +
                    "    modifier = modifier,\n" +
                    "    shape = shape,\n" +
                    "    colors = colors,\n" +
                    "    tonalElevation = tonalElevation,\n" +
                    "    shadowElevation = shadowElevation,\n" +
                    "    windowInsets = windowInsets,\n" +
                    "    content = content,\n" +
                    ")"
        ),
)
@ExperimentalMaterial3Api
@Composable
fun 搜索栏(
    查询: String,
    查询改变回调: (String) -> Unit,
    搜索回调: (String) -> Unit,
    激活: Boolean,
    激活改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    形状: Shape = SearchBarDefaults.inputFieldShape,
    颜色集: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    窗口插入: WindowInsets = SearchBarDefaults.windowInsets,
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) =
    SearchBar(
        query = 查询,
        onQueryChange = 查询改变回调,
        onSearch = 搜索回调,
        active = 激活,
        onActiveChange = 激活改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        shape = 形状,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        windowInsets = 窗口插入,
        interactionSource = 交互源,
        content = 内容,
    )

@Suppress("DEPRECATION", "ComposableNaming")
@Deprecated(
    message = "Use overload which takes inputField as a parameter",
    replaceWith =
        ReplaceWith(
            "DockedSearchBar(\n" +
                    "    inputField = {\n" +
                    "        SearchBarDefaults.InputField(\n" +
                    "            textFieldState = textFieldState,\n" +
                    "            searchBarState = searchBarState,\n" +
                    "            onSearch = onSearch,\n" +
                    "            modifier = modifier,\n" +
                    "            enabled = enabled,\n" +
                    "            readOnly = readOnly,\n" +
                    "            textStyle = textStyle,\n" +
                    "            placeholder = placeholder,\n" +
                    "            leadingIcon = leadingIcon,\n" +
                    "            trailingIcon = trailingIcon,\n" +
                    "            prefix = prefix,\n" +
                    "            suffix = suffix,\n" +
                    "            inputTransformation = inputTransformation,\n" +
                    "            outputTransformation = outputTransformation,\n" +
                    "            keyboardOptions = keyboardOptions,\n" +
                    "            lineLimits = lineLimits,\n" +
                    "            scrollState = scrollState,\n" +
                    "            shape = shape,\n" +
                    "            colors = colors,\n" +
                    "            interactionSource = interactionSource,\n" +
                    "        )\n" +
                    "    },\n" +
                    "    expanded = active,\n" +
                    "    onExpandedChange = onActiveChange,\n" +
                    "    modifier = modifier,\n" +
                    "    shape = shape,\n" +
                    "    colors = colors,\n" +
                    "    tonalElevation = tonalElevation,\n" +
                    "    shadowElevation = shadowElevation,\n" +
                    "    content = content,\n" +
                    ")"
        ),
)
@ExperimentalMaterial3Api
@Composable
fun 固定搜索栏(
    查询: String,
    查询改变回调: (String) -> Unit,
    搜索回调: (String) -> Unit,
    激活: Boolean,
    激活改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    形状: Shape = SearchBarDefaults.dockedShape,
    颜色集: SearchBarColors = SearchBarDefaults.colors(),
    色调阴影: Dp = SearchBarDefaults.TonalElevation,
    视觉阴影: Dp = SearchBarDefaults.ShadowElevation,
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) =
    DockedSearchBar(
        query = 查询,
        onQueryChange = 查询改变回调,
        onSearch = 搜索回调,
        active = 激活,
        onActiveChange = 激活改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        shape = 形状,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        interactionSource = 交互源,
        content = 内容,
    )





private val AnimationForContentFadeInSpec: FiniteAnimationSpec<Float> =
    tween(
        durationMillis = MotionTokens.DurationShort2.toInt(),
        delayMillis = MotionTokens.DurationShort1.toInt(),
        easing = MotionTokens.EasingStandardAccelerateCubicBezier,
    )
private val AnimationForContentFadeOutSpec: FiniteAnimationSpec<Float> =
    tween(
        durationMillis = MotionTokens.DurationShort2.toInt(),
        easing = MotionTokens.EasingStandardDecelerateCubicBezier,
    )