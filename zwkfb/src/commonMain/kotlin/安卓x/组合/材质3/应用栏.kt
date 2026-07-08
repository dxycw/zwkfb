package 安卓x.组合.材质3

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.BottomAppBarState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ComponentOverrideApi
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FlexibleBottomAppBar
import androidx.compose.material3.LargeFlexibleTopAppBar
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.LocalSingleRowTopAppBarOverride
import androidx.compose.material3.LocalTwoRowsTopAppBarOverride
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumFlexibleTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.SingleRowTopAppBarOverride
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.TwoRowsTopAppBar
import androidx.compose.material3.TwoRowsTopAppBarOverride
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberBottomAppBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp



/**
 * [Material Design small top app bar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏在屏幕顶部显示信息和操作。
 *
 * 这个小型 顶部应用栏 设有标题、导航图标和操作按钮的插槽。
 *
 * ![Small top app bar image](https://developer.android.com/images/reference/androidx/compose/material3/small-top-app-bar.png)
 *
 * @param 标题 要在顶部应用栏中显示的标题。
 * @param 修饰符 要应用于此顶部应用栏的 [Modifier]。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标。通常应为 [图标按钮] 或 [图标切换按钮]。
 * @param 操作集 显示在顶部应用栏末尾的操作按钮。通常应为 [图标按钮]。默认布局为 [Row]，因此内部的图标将水平排列。
 * @param 已展开高度 此应用栏的高度。当指定的 [滚动行为] 导致应用栏折叠或展开时，该值表示允许应用栏展开的最大高度。
 * 该值必须指定且为有限值，否则将被忽略并替换为 [TopAppBarDefaults.TopAppBarExpandedHeight]。
 * @param 窗口插入 应用栏将遵循的窗口内边距。
 * @param 颜色集 用于解析此顶部应用栏在不同状态下所用颜色的 [TopAppBarColors]。请参阅 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它包含各种偏移值，此顶部应用栏将应用这些偏移值来设置其高度和颜色。
 * 滚动行为旨在与滚动内容协同工作，以在内容滚动时改变顶部应用栏的外观。请参阅 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @param 内容内边距 应用于此 TopAppBar 内容的内边距。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun 顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable () -> Unit = {},
    操作集: @Composable RowScope.() -> Unit = {},
    已展开高度: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色集: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
    内容内边距: PaddingValues = TopAppBarDefaults.ContentPadding,
) =
    TopAppBar(
        title = 标题,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 操作集,
        expandedHeight = 已展开高度,
        windowInsets = 窗口插入,
        colors = 颜色集,
        scrollBehavior = 滚动行为,
        contentPadding = 内容内边距,
    )


/**
 * [Material Design center-aligned small top app bar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏在屏幕顶部显示信息和操作项。
 *
 * 这个小型的顶部应用栏有一个标题，该标题在水平方向上居中对齐。
 *
 * ![Center-aligned top app bar image](https://developer.android.com/images/reference/androidx/compose/material3/center-aligned-top-app-bar.png)
 *
 * 这个居中对齐的顶部应用栏（CenterAlignedTopAppBar）包含标题、导航图标和操作项这三个插槽。
 *
 * 一个居中对齐的顶部应用栏，它使用 [滚动行为] 来自定义嵌套滚动行为，当与可滚动内容配合使用时。
 *
 * @param 标题 要在顶部应用栏中显示的标题。
 * @param 修饰符 要应用于此顶部应用栏的 [Modifier]。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标。通常应为 [图标按钮] 或 [图标切换按钮]。
 * @param 操作集 显示在顶部应用栏末尾位置的操作项。通常应为 [图标按钮]。此处的默认布局是 [Row]，因此其中的图标将水平排列。
 * @param 已展开高度 此应用栏的高度。当指定的 [滚动行为] 导致应用栏折叠或展开时，该值表示应用栏允许展开的最大高度。
 * 此值必须明确指定且为有限值，否则将被忽略并替换为 [TopAppBarDefaults.TopAppBarExpandedHeight]。
 * @param 窗口插入 应用栏将遵循的窗口边衬区。
 * @param 颜色集 用于解析此顶部应用栏在不同状态下所使用颜色的 [TopAppBarColors]。参见 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它包含各种偏移值，此顶部应用栏将应用这些偏移值来设置其高度和颜色。
 * 滚动行为旨在与滚动内容配合使用，随着内容滚动而改变顶部应用栏的外观。参见 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @param 内容内边距 应用于此 TopAppBar 内容的内边距。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun 居中对齐顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable () -> Unit = {},
    操作集: @Composable RowScope.() -> Unit = {},
    已展开高度: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色集: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
    内容内边距: PaddingValues = TopAppBarDefaults.ContentPadding,
) =
    CenterAlignedTopAppBar(
        title = 标题,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 操作集,
        expandedHeight = 已展开高度,
        windowInsets = 窗口插入,
        colors = 颜色集,
        scrollBehavior = 滚动行为,
        contentPadding = 内容内边距,
    )

/**
 * [Material Design small top app bar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏在屏幕顶部显示信息和操作项。
 *
 * 这个小型 TopAppBar 包含标题、副标题、导航图标和操作项这四个插槽。
 *
 * ![Small top app bar image](https://developer.android.com/images/reference/androidx/compose/material3/small-top-app-bar.png)
 *
 * 一个使用 [滚动行为] 来自定义嵌套滚动行为的顶部应用栏，当与可滚动内容配合使用时。
 *
 * @param 标题 要在顶部应用栏中显示的标题
 * @param 副标题 要在顶部应用栏中显示的副标题
 * @param 修饰符 要应用于此顶部应用栏的 [Modifier]
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标。通常应为 [图标按钮] 或 [图标切换按钮]。
 * @param 操作集 显示在顶部应用栏末尾位置的操作项。通常应为 [图标按钮]。此处的默认布局是 [Row]，因此其中的图标将水平排列。
 * @param 标题水平对齐 标题和副标题的水平对齐方式
 * @param 已展开高度 此应用栏的高度。当指定的 [滚动行为] 导致应用栏折叠或展开时，该值表示应用栏允许展开的最大高度。
 * 此值必须明确指定且为有限值，否则将被忽略并替换为 [TopAppBarDefaults.TopAppBarExpandedHeight]。
 * @param 窗口插入 应用栏将遵循的窗口边衬区。
 * @param 颜色集 用于解析此顶部应用栏在不同状态下所使用颜色的 [TopAppBarColors]。参见 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它包含各种偏移值，此顶部应用栏将应用这些偏移值来设置其高度和颜色。
 * 滚动行为旨在与滚动内容配合使用，随着内容滚动而改变顶部应用栏的外观。参见 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @param 内容内边距 应用于此 TopAppBar 内容的内边距。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 顶部应用栏(
    标题: @Composable () -> Unit,
    副标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable () -> Unit = {},
    操作集: @Composable RowScope.() -> Unit = {},
    标题水平对齐: Alignment.Horizontal = Alignment.Start,
    已展开高度: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色集: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
    内容内边距: PaddingValues = TopAppBarDefaults.ContentPadding,
) =
    TopAppBar(
        title = 标题,
        subtitle = 副标题,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 操作集,
        titleHorizontalAlignment = 标题水平对齐,
        expandedHeight = 已展开高度,
        windowInsets = 窗口插入,
        colors = 颜色集,
        scrollBehavior = 滚动行为,
        contentPadding = 内容内边距,
    )

/**
 * [Material Design medium top app bar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏在屏幕顶部显示信息和操作项。
 *
 * ![Medium top app bar image](https://developer.android.com/images/reference/androidx/compose/material3/medium-top-app-bar.png)
 *
 * 这个 MediumTopAppBar 包含标题、导航图标和操作项这三个插槽。在其默认展开状态下，标题显示在导航图标和操作项下方的第二行。
 *
 * 一个中型顶部应用栏，它使用 [滚动行为] 来自定义嵌套滚动行为，当与滚动内容配合使用时。
 *
 * @param 标题 要在顶部应用栏中显示的标题。此标题将在应用栏的展开和折叠状态下使用，但在折叠状态下，它将使用较小尺寸的 [TextStyle] 进行组合。
 * @param 修饰符 要应用于此顶部应用栏的 [Modifier]。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标。通常应为 [图标按钮] 或 [图标切换按钮]。
 * @param 操作集 显示在顶部应用栏末尾位置的操作项。通常应为 [图标按钮]。此处的默认布局是 [Row]，因此其中的图标将水平排列。
 * @param 已折叠高度 当应用栏被提供的 [滚动行为] 折叠时的高度。此值必须明确指定且为有限值，
 * 否则将被忽略并替换为 [TopAppBarDefaults.MediumAppBarCollapsedHeight]。
 * @param 已展开高度 此应用栏的最大高度。当指定的 [滚动行为] 导致应用栏折叠或展开时，该值表示应用栏允许展开的最大高度。
 * 展开高度应大于或等于 [已折叠高度]，否则函数将抛出 [IllegalArgumentException]。此外，此值必须明确指定且为有限值，
 * 否则将被忽略并替换为 [TopAppBarDefaults.MediumAppBarExpandedHeight]。
 * @param 窗口插入 应用栏将遵循的窗口边衬区。
 * @param 颜色集 用于解析此顶部应用栏在不同状态下所使用的颜色的 [TopAppBarColors]。请参阅 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它持有各种偏移值，这些偏移值将由本顶部应用栏应用以设置其高度和颜色。
 * 滚动行为旨在与已滚动的内容协同工作，当内容滚动时改变顶部应用栏的外观。请参阅 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @throws IllegalArgumentException 如果提供的 [已展开高度] 小于 [已折叠高度]
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun 中等顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable () -> Unit = {},
    操作集: @Composable RowScope.() -> Unit = {},
    已折叠高度: Dp = TopAppBarDefaults.MediumAppBarCollapsedHeight,
    已展开高度: Dp = TopAppBarDefaults.MediumAppBarExpandedHeight,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色集: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
) =
    MediumTopAppBar(
        title = 标题,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 操作集,
        collapsedHeight = 已折叠高度,
        expandedHeight = 已展开高度,
        windowInsets = 窗口插入,
        colors = 颜色集,
        scrollBehavior = 滚动行为,
    )

/**
 * [Material Design medium flexible top app bar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏在屏幕顶部显示信息和操作。
 *
 * ![Medium top app bar image](https://developer.android.com/images/reference/androidx/compose/material3/medium-top-app-bar.png)
 *
 * 此 `MediumFlexibleTopAppBar` 提供了标题、副标题、导航图标和操作按钮的插槽。在其默认的展开状态下，
 * 标题和副标题显示在导航图标和操作按钮下方的第二行。
 *
 * 一个中等弹性顶部应用栏，它使用 [滚动行为] 来自定义其嵌套滚动行为，当与滚动内容协同工作时。
 *
 * @param 标题 要在顶部应用栏中显示的标题。该标题将用于应用栏的展开状态和折叠状态，但在折叠状态下，它将使用较小尺寸的 [TextStyle] 进行组合。
 * @param 修饰符 要应用于此顶部应用栏的 [Modifier]。
 * @param 副标题 可选的副标题，显示在顶部应用栏中。该副标题将用于应用栏的展开状态和折叠状态。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标。通常应为 [图标按钮] 或 [图标切换按钮]。
 * @param 操作集 显示在顶部应用栏末尾的操作按钮。通常应为 [图标按钮]。此处的默认布局是 [Row]，因此内部的图标将水平排列。
 * @param 标题水平对齐 标题和副标题的水平对齐方式。
 * @param 已折叠高度 此应用栏在由提供的 [滚动行为] 折叠时的高度。该值必须明确指定且为有限值，否则将被忽略，
 * 并替换为 [TopAppBarDefaults.MediumAppBarCollapsedHeight]。
 * @param 已展开高度 此应用栏的最大高度。当指定的 [滚动行为] 导致应用栏折叠或展开时，该值将表示应用栏允许展开到的最大高度。
 * 展开高度应大于或等于 [已折叠高度]，否则函数将抛出 [IllegalArgumentException]。此外，该值必须明确指定且为有限值，
 * 否则将被忽略，并替换为 [TopAppBarDefaults.MediumFlexibleAppBarWithSubtitleExpandedHeight] 或
 * [TopAppBarDefaults.MediumFlexibleAppBarWithoutSubtitleExpandedHeight]。
 * @param 窗口插入 应用栏将遵守的窗口内边距。
 * @param 颜色集 用于解析此顶部应用栏在不同状态下所使用的颜色的 [TopAppBarColors]。请参阅 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它持有各种偏移值，这些偏移值将由本顶部应用栏应用以设置其高度和颜色。
 * 滚动行为旨在与已滚动的内容协同工作，当内容滚动时改变顶部应用栏的外观。请参阅 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @throws IllegalArgumentException 如果提供的 [已展开高度] 小于 [已折叠高度]
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 中等折叠顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    副标题: (@Composable () -> Unit)? = null,
    导航图标: @Composable () -> Unit = {},
    操作集: @Composable RowScope.() -> Unit = {},
    标题水平对齐: Alignment.Horizontal = Alignment.Start,
    已折叠高度: Dp = TopAppBarDefaults.MediumAppBarCollapsedHeight,
    已展开高度: Dp =
        if (副标题 != null) {
            TopAppBarDefaults.MediumFlexibleAppBarWithSubtitleExpandedHeight
        } else {
            TopAppBarDefaults.MediumFlexibleAppBarWithoutSubtitleExpandedHeight
        },
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色集: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
) =
    MediumFlexibleTopAppBar(
        title = 标题,
        modifier = 修饰符,
        subtitle = 副标题,
        navigationIcon = 导航图标,
        actions = 操作集,
        titleHorizontalAlignment = 标题水平对齐,
        collapsedHeight = 已折叠高度,
        expandedHeight = 已展开高度,
        windowInsets = 窗口插入,
        colors = 颜色集,
        scrollBehavior = 滚动行为,
    )

/**
 * [Material Design large top app bar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏在屏幕顶部显示信息和操作。
 *
 * ![Large top app bar image](https://developer.android.com/images/reference/androidx/compose/material3/large-top-app-bar.png)
 *
 * 此 LargeTopAppBar 提供了标题、导航图标和操作按钮的插槽。在其默认的展开状态下，标题显示在导航图标和操作按钮下方的第二行。
 *
 * 一个大型顶部应用栏，它使用 [滚动行为] 来自定义其嵌套滚动行为，当与滚动内容协同工作时。
 *
 * @param 标题 要在顶部应用栏中显示的标题。该标题将用于应用栏的展开状态和折叠状态，但在折叠状态下，它将使用较小尺寸的 [TextStyle] 进行组合。
 * @param 修饰符 要应用于此顶部应用栏的 [Modifier]。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标。通常应为 [图标按钮] 或 [图标切换按钮]。
 * @param 操作集 显示在顶部应用栏末尾的操作按钮。通常应为 [图标按钮]。此处的默认布局是 [Row]，因此内部的图标将水平排列。
 * @param 已折叠高度 此应用栏在由提供的 [滚动行为] 折叠时的高度。该值必须明确指定且为有限值，否则将被忽略，
 * 并替换为 [TopAppBarDefaults.LargeAppBarCollapsedHeight]。
 * @param 已展开高度 此应用栏的最大高度。当指定的 [滚动行为] 导致应用栏折叠或展开时，该值将表示应用栏允许展开到的最大高度。
 * 展开高度应大于或等于 [已折叠高度]，否则函数将抛出 [IllegalArgumentException]。此外，该值必须明确指定且为有限值，
 * 否则将被忽略，并替换为 [TopAppBarDefaults.LargeAppBarExpandedHeight]。
 * @param 窗口插入 应用栏将遵守的窗口内边距。
 * @param 颜色集 用于解析此顶部应用栏在不同状态下所使用的颜色的 [TopAppBarColors]。请参阅 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它持有各种偏移值，这些偏移值将由本顶部应用栏应用以设置其高度和颜色。
 * 滚动行为旨在与已滚动的内容协同工作，当内容滚动时改变顶部应用栏的外观。请参阅 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @throws IllegalArgumentException 如果提供的 [已展开高度] 小于 [已折叠高度]
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun 大型顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    导航图标: @Composable () -> Unit = {},
    操作集: @Composable RowScope.() -> Unit = {},
    已折叠高度: Dp = TopAppBarDefaults.LargeAppBarCollapsedHeight,
    已展开高度: Dp = TopAppBarDefaults.LargeAppBarExpandedHeight,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色集: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
) =
    LargeTopAppBar(
        title = 标题,
        modifier = 修饰符,
        navigationIcon = 导航图标,
        actions = 操作集,
        collapsedHeight = 已折叠高度,
        expandedHeight = 已展开高度,
        windowInsets = 窗口插入,
        colors = 颜色集,
        scrollBehavior = 滚动行为,
    )

/**
 * [Material Design large flexible top app bar](https://m3.material.io/components/top-app-bar/overview)
 *
 * 顶部应用栏在屏幕顶部显示信息和操作。
 *
 * ![Large top app bar image](https://developer.android.com/images/reference/androidx/compose/material3/large-top-app-bar.png)
 *
 * 此 `LargeFlexibleTopAppBar` 提供了标题、副标题、导航图标和操作按钮的插槽。在其默认的展开状态下，
 * 标题和副标题显示在导航图标和操作按钮下方的第二行。
 *
 * 一个大型弹性顶部应用栏，它使用 [滚动行为] 来自定义其嵌套滚动行为，当与滚动内容协同工作时。
 *
 * @param 标题 要在顶部应用栏中显示的标题。该标题将用于应用栏的展开状态和折叠状态，但在折叠状态下，它将使用较小尺寸的 [TextStyle] 进行组合。
 * @param 修饰符 要应用于此顶部应用栏的 [Modifier]。
 * @param 副标题 可选的副标题，显示在顶部应用栏中。该副标题将用于应用栏的展开状态和折叠状态。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标。通常应为 [图标按钮] 或 [图标切换按钮]。
 * @param 操作集 显示在顶部应用栏末尾的操作按钮。通常应为 [图标按钮]。此处的默认布局是 [Row]，因此内部的图标将水平排列。
 * @param 标题水平对齐 标题和副标题的水平对齐方式。
 * @param 已折叠高度 此应用栏在由提供的 [滚动行为] 折叠时的高度。该值必须明确指定且为有限值，否则将被忽略，
 * 并替换为 [TopAppBarDefaults.LargeAppBarCollapsedHeight]。
 * @param 已展开高度 此应用栏的最大高度。当指定的 [滚动行为] 导致应用栏折叠或展开时，该值将表示应用栏允许展开到的最大高度。
 * 展开高度应大于或等于 [已折叠高度]，否则函数将抛出 [IllegalArgumentException]。此外，该值必须明确指定且为有限值，
 * 否则将被忽略，并替换为 [TopAppBarDefaults.LargeFlexibleAppBarWithSubtitleExpandedHeight] 或
 * [TopAppBarDefaults.LargeFlexibleAppBarWithoutSubtitleExpandedHeight]。
 * @param 窗口插入 应用栏将遵守的窗口内边距。
 * @param 颜色集 用于解析此顶部应用栏在不同状态下所使用的颜色的 [TopAppBarColors]。请参阅 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它持有各种偏移值，这些偏移值将由本顶部应用栏应用以设置其高度和颜色。
 * 滚动行为旨在与已滚动的内容协同工作，当内容滚动时改变顶部应用栏的外观。请参阅 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @throws IllegalArgumentException 如果提供的 [已展开高度] 小于 [已折叠高度]。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 大型折叠顶部应用栏(
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    副标题: (@Composable () -> Unit)? = null,
    导航图标: @Composable () -> Unit = {},
    操作集: @Composable RowScope.() -> Unit = {},
    标题水平对齐: Alignment.Horizontal = Alignment.Start,
    已折叠高度: Dp = TopAppBarDefaults.LargeAppBarCollapsedHeight,
    已展开高度: Dp =
        if (副标题 != null) {
            TopAppBarDefaults.LargeFlexibleAppBarWithSubtitleExpandedHeight
        } else {
            TopAppBarDefaults.LargeFlexibleAppBarWithoutSubtitleExpandedHeight
        },
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色集: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
) =
    LargeFlexibleTopAppBar(
        title = 标题,
        modifier = 修饰符,
        subtitle = 副标题,
        navigationIcon = 导航图标,
        actions = 操作集,
        titleHorizontalAlignment = 标题水平对齐,
        collapsedHeight = 已折叠高度,
        expandedHeight = 已展开高度,
        windowInsets = 窗口插入,
        colors = 颜色集,
        scrollBehavior = 滚动行为,
    )

/**
 * 一个基本的双行 Material Design 顶部应用栏。
 *
 * 顶部应用栏在屏幕顶部显示信息和操作。
 *
 * ![Two rows top app bar image](https://developer.android.com/images/reference/androidx/compose/material3/medium-top-app-bar.png)
 *
 * 此双行顶部应用栏提供了标题和副标题、导航图标以及操作按钮的插槽。在其默认的展开状态下，展开的标题和副标题显示在导航图标和操作按钮下方的第二行。
 *
 * 默认情况下，双行顶部应用栏会将 [MediumFlexibleTopAppBar] 的文本样式应用于展开和折叠的标题。你可以通过将自定义样式应用于
 * 传入这些折叠和展开标题插槽的 Composition 来覆盖该默认行为。
 *
 * 一个双行顶部应用栏，它使用 [滚动行为] 来自定义其嵌套滚动行为，当与滚动内容协同工作时。
 *
 * @param 标题 一个 lambda，用于提供在折叠和展开状态下显示在顶部应用栏中的标题。默认情况下，小型应用栏的 [TextStyle]
 * 会应用于该组合，你可以通过用组合本地值包裹你提供的组件来覆盖它。请注意，与大型或中型顶部应用栏不同，TwoRowsTopAppBar
 * 默认不会向展开标题的可组合项追加底部内边距。内边距应直接应用于提供的展开标题，或应用于其下方显示的 [副标题]。
 * @param 修饰符 要应用于此顶部应用栏的 [Modifier]。
 * @param 副标题 一个 lambda，用于提供可选的副标题，显示在顶部应用栏的折叠和展开状态中。
 * @param 导航图标 显示在顶部应用栏起始位置的导航图标。通常应为 [图标按钮] 或 [图标切换按钮]。
 * @param 操作集 显示在顶部应用栏末尾的操作按钮。通常应为 [图标按钮]。此处的默认布局是 [Row]，因此内部的图标将水平排列。
 * @param 标题水平对齐 标题和副标题的水平对齐方式。
 * @param 已折叠高度 应用栏在折叠状态下的高度。请注意，该值可能会被调整以支持显示更大的字体。如果提供的值为
 * [Dp.Unspecified] 或 [Dp.Infinity]，则高度将默认为 [TopAppBarDefaults.MediumAppBarCollapsedHeight]。
 * @param 已展开高度 此应用栏在展开状态下的高度。当指定的 [滚动行为] 导致应用栏折叠或展开时，该值将表示应用栏将展开到的总高度。
 * 展开高度应大于或等于 [已折叠高度]，否则函数将抛出 [IllegalArgumentException]。请注意，该值可能会被调整以支持显示更大的字体。
 * 如果提供的值为 [Dp.Unspecified] 或 [Dp.Infinity]，则当提供了 [已折叠高度] 时，高度将默认为
 * [TopAppBarDefaults.MediumFlexibleAppBarWithSubtitleExpandedHeight]；当未提供时，将默认为
 * [TopAppBarDefaults.MediumFlexibleAppBarWithoutSubtitleExpandedHeight]。
 * @param 窗口插入 应用栏将遵守的窗口内边距。
 * @param 颜色集 用于解析此顶部应用栏在不同状态下所使用的颜色的 [TopAppBarColors]。请参阅 [TopAppBarDefaults.topAppBarColors]。
 * @param 滚动行为 一个 [TopAppBarScrollBehavior]，它持有各种偏移值，这些偏移值将由本顶部应用栏应用以设置其高度和颜色。
 * 滚动行为旨在与已滚动的内容协同工作，当内容滚动时改变顶部应用栏的外观。请参阅 [TopAppBarScrollBehavior.nestedScrollConnection]。
 * @throws IllegalArgumentException 如果提供的 [已展开高度] 小于 [已折叠高度]
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 双行顶部应用栏(
    标题: @Composable (expanded: Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    副标题: (@Composable (expanded: Boolean) -> Unit)? = null,
    导航图标: @Composable () -> Unit = {},
    操作集: @Composable RowScope.() -> Unit = {},
    标题水平对齐: Alignment.Horizontal = Alignment.Start,
    已折叠高度: Dp = Dp.Unspecified,
    已展开高度: Dp = Dp.Unspecified,
    窗口插入: WindowInsets = TopAppBarDefaults.windowInsets,
    颜色集: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    滚动行为: TopAppBarScrollBehavior? = null,
) =
    TwoRowsTopAppBar(
        title = 标题,
        modifier = 修饰符,
        subtitle = 副标题,
        navigationIcon = 导航图标,
        actions = 操作集,
        titleHorizontalAlignment = 标题水平对齐,
        collapsedHeight = 已折叠高度,
        expandedHeight = 已展开高度,
        windowInsets = 窗口插入,
        colors = 颜色集,
        scrollBehavior = 滚动行为,
    )

/**
 * [Material Design bottom app bar](https://m3.material.io/components/bottom-app-bar/overview)
 *
 * 底部应用栏在小屏幕底部显示导航和关键操作。
 *
 * ![Bottom app bar image](https://developer.android.com/images/reference/androidx/compose/material3/bottom-app-bar.png)
 *
 * @param 操作集 此 BottomAppBar 的图标内容。此处的默认布局是 [Row]，因此内部内容将水平排列。
 * @param 修饰符 要应用于此 BottomAppBar 的 [Modifier]。
 * @param 悬浮操作按钮 此 BottomAppBar 末尾的可选浮动操作按钮。
 * @param 容器颜色 此 BottomAppBar 背景所使用的颜色。使用 [Color.Transparent] 可设为无颜色。
 * @param 内容颜色 此 BottomAppBar 内部内容的首选颜色。默认为与 [容器颜色] 匹配的内容颜色，如果 [容器颜色]
 * 不是来自主题的颜色，则默认为当前的 [LocalContentColor]。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方应用半透明的主色叠加层。
 * 较高的色调海拔值在浅色主题下会产生更深的颜色，在深色主题下会产生更浅的颜色。另请参阅：[表面]。
 * @param 内容内边距 应用于此 BottomAppBar 内容的内边距。
 * @param 窗口插入 应用栏将遵守的窗口内边距。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 底部应用栏(
    操作集: @Composable RowScope.() -> Unit,
    修饰符: Modifier = Modifier,
    悬浮操作按钮: @Composable (() -> Unit)? = null,
    容器颜色: Color = BottomAppBarDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    色调阴影: Dp = BottomAppBarDefaults.ContainerElevation,
    内容内边距: PaddingValues = BottomAppBarDefaults.ContentPadding,
    窗口插入: WindowInsets = BottomAppBarDefaults.windowInsets,
) =
    BottomAppBar(
        actions = 操作集,
        modifier = 修饰符,
        floatingActionButton = 悬浮操作按钮,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        contentPadding = 内容内边距,
        windowInsets = 窗口插入,
    )

/**
 * [Material Design bottom app bar](https://m3.material.io/components/bottom-app-bar/overview)
 *
 * 底部应用栏在小屏幕底部显示导航和关键操作。
 *
 * ![Bottom app bar image](https://developer.android.com/images/reference/androidx/compose/material3/bottom-app-bar.png)
 *
 * @param 操作集 此 BottomAppBar 的图标内容。此处的默认布局是 [Row]，因此内部内容将水平排列。
 * @param 修饰符 要应用于此 BottomAppBar 的 [Modifier]。
 * @param 悬浮操作按钮 此 BottomAppBar 末尾的可选浮动操作按钮。
 * @param 容器颜色 此 BottomAppBar 背景所使用的颜色。使用 [Color.Transparent] 可设为无颜色。
 * @param 内容颜色 此 BottomAppBar 内部内容的首选颜色。默认为与 [容器颜色] 匹配的内容颜色，如果 [容器颜色]
 * 不是来自主题的颜色，则默认为当前的 [LocalContentColor]。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方应用半透明的主色叠加层。
 * 较高的色调海拔值在浅色主题下会产生更深的颜色，在深色主题下会产生更浅的颜色。另请参阅：[表面]。
 * @param 内容内边距 应用于此 BottomAppBar 内容的内边距。
 * @param 窗口插入 应用栏将遵守的窗口内边距。
 * @param 滚动行为 一个 [BottomAppBarScrollBehavior]，它持有各种偏移值，这些偏移值将由本底部应用栏应用以设置其高度。
 * 滚动行为旨在与已滚动的内容协同工作，当内容滚动时改变底部应用栏的外观。请注意，当触摸探索服务（例如 TalkBack）处于活动状态时，
 * 底部应用栏不会对滚动做出反应。请参阅 [BottomAppBarScrollBehavior.nestedScrollConnection]。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3Api
@Composable
fun 底部应用栏(
    操作集: @Composable RowScope.() -> Unit,
    修饰符: Modifier = Modifier,
    悬浮操作按钮: @Composable (() -> Unit)? = null,
    容器颜色: Color = BottomAppBarDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    色调阴影: Dp = BottomAppBarDefaults.ContainerElevation,
    内容内边距: PaddingValues = BottomAppBarDefaults.ContentPadding,
    窗口插入: WindowInsets = BottomAppBarDefaults.windowInsets,
    滚动行为: BottomAppBarScrollBehavior? = null,
) =
    BottomAppBar(
        actions = 操作集,
        modifier = 修饰符,
        floatingActionButton = 悬浮操作按钮,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        contentPadding = 内容内边距,
        windowInsets = 窗口插入,
        scrollBehavior = 滚动行为,
    )

/**
 * [Material Design bottom app bar](https://m3.material.io/components/bottom-app-bar/overview)
 *
 * 底部应用栏在小屏幕底部显示导航和关键操作。
 *
 * ![Bottom app bar image](https://developer.android.com/images/reference/androidx/compose/material3/bottom-app-bar.png)
 *
 * @param 修饰符 要应用于此 底部应用栏 的 [Modifier]。
 * @param 容器颜色 此 底部应用栏 背景所使用的颜色。使用 [Color.Transparent] 可设为无颜色。
 * @param 内容颜色 此 底部应用栏 内部内容的首选颜色。默认为与 [容器颜色] 匹配的内容颜色，
 * 如果 [容器颜色] 不是来自主题的颜色，则默认为当前的 [LocalContentColor]。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方应用半透明的主色叠加层。
 * 较高的色调海拔值在浅色主题下会产生更深的颜色，在深色主题下会产生更浅的颜色。另请参阅：[表面]。
 * @param 内容内边距 应用于此 底部应用栏 内容的内边距。
 * @param 窗口插入 应用栏将遵守的窗口内边距。
 * @param 内容 此 底部应用栏 的内容。此处的默认布局是 [Row]，因此内部内容将水平排列。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 底部应用栏(
    修饰符: Modifier = Modifier,
    容器颜色: Color = BottomAppBarDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    色调阴影: Dp = BottomAppBarDefaults.ContainerElevation,
    内容内边距: PaddingValues = BottomAppBarDefaults.ContentPadding,
    窗口插入: WindowInsets = BottomAppBarDefaults.windowInsets,
    内容: @Composable RowScope.() -> Unit,
) =
    BottomAppBar(
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        contentPadding = 内容内边距,
        windowInsets = 窗口插入,
        content = 内容,
    )

/**
 * [Material Design bottom app bar](https://m3.material.io/components/bottom-app-bar/overview)
 *
 * 底部应用栏在小屏幕底部显示导航和关键操作。
 *
 * ![Bottom app bar image](https://developer.android.com/images/reference/androidx/compose/material3/bottom-app-bar.png)
 *
 * 如果你有兴趣显示 [FloatingActionButton]，请考虑使用另一个重载。
 *
 * @param 修饰符 要应用于此 底部应用栏 的 [Modifier]。
 * @param 容器颜色 此 底部应用栏 背景所使用的颜色。使用 [Color.Transparent] 可设为无颜色。
 * @param 内容颜色 此 底部应用栏 内部内容的首选颜色。默认为与 [容器颜色] 匹配的内容颜色，如果 [容器颜色]
 * 不是来自主题的颜色，则默认为当前的 [LocalContentColor]。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方应用半透明的主色叠加层。
 * 较高的色调海拔值在浅色主题下会产生更深的颜色，在深色主题下会产生更浅的颜色。另请参阅：[表面]。
 * @param 内容内边距 应用于此 底部应用栏 内容的内边距。
 * @param 窗口插入 应用栏将遵守的窗口内边距。
 * @param 滚动行为 一个 [BottomAppBarScrollBehavior]，它持有各种偏移值，这些偏移值将由本底部应用栏应用以设置其高度。
 * 滚动行为旨在与已滚动的内容协同工作，当内容滚动时改变底部应用栏的外观。请注意，当触摸探索服务（例如 TalkBack）处于活动状态时，
 * 底部应用栏不会对滚动做出反应。请参阅 [BottomAppBarScrollBehavior.nestedScrollConnection]。
 * @param 内容 此 底部应用栏 的内容。此处的默认布局是 [Row]，因此内部内容将水平排列。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3Api
@Composable
fun 底部应用栏(
    修饰符: Modifier = Modifier,
    容器颜色: Color = BottomAppBarDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    色调阴影: Dp = BottomAppBarDefaults.ContainerElevation,
    内容内边距: PaddingValues = BottomAppBarDefaults.ContentPadding,
    窗口插入: WindowInsets = BottomAppBarDefaults.windowInsets,
    滚动行为: BottomAppBarScrollBehavior? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    BottomAppBar(
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        contentPadding = 内容内边距,
        windowInsets = 窗口插入,
        scrollBehavior = 滚动行为,
        content = 内容,
    )

// TODO 弹性底部应用栏的缺失图片。
/**
 * [Material Design flexible bottom app bar](https://m3.material.io/components/bottom-app-bar/overview)
 *
 * 弹性底部应用栏在小屏幕底部显示导航和关键操作。
 *
 * 此底部应用栏的变体具有 [水平排列] 参数，用于控制内容的排列方式。此外，它还通过 [已展开高度]
 * 值提供了更大的灵活性来控制应用栏的展开高度。
 *
 * 如果你有兴趣显示 [FloatingActionButton]，请考虑使用另一个接受 [FloatingActionButton] 参数的重载。
 *
 * 一个指定了 [水平排列] 并使用 [滚动行为] 来自定义其嵌套滚动行为的底部应用栏，当与滚动内容协同工作时。
 *
 * @param 修饰符 要应用于此 底部应用栏 的 [Modifier]。
 * @param 容器颜色 此 底部应用栏 背景所使用的颜色。使用 [Color.Transparent] 可设为无颜色。
 * @param 内容颜色 此 底部应用栏 内部内容的首选颜色。默认为与 [容器颜色] 匹配的内容颜色，
 * 如果 [容器颜色] 不是来自主题的颜色，则默认为当前的 [LocalContentColor]。
 * @param 内容内边距 应用于此 底部应用栏 内容的内边距。
 * @param 水平排列 此 底部应用栏 内部内容的水平排列方式。
 * @param 已展开高度 此底部应用栏完全展开时可达的最大高度。如果提供了 [滚动行为]，应用栏可能会根据滚动而折叠或展开。
 * 在这种情况下，该值设置了应用栏展开时高度的上限。此 [Dp] 值必须明确指定、为有限值且大于零；否则，将使用
 * [BottomAppBarDefaults.FlexibleBottomAppBarHeight] 作为默认值。如果 [滚动行为] 为 null，
 * 此值将仅仅是底部应用栏的固定高度。
 * @param 窗口插入 应用栏将遵守的窗口内边距。
 * @param 滚动行为 一个 [BottomAppBarScrollBehavior]，它持有各种偏移值，这些偏移值将由本底部应用栏应用以设置其高度。
 * 滚动行为旨在与已滚动的内容协同工作，当内容滚动时改变底部应用栏的外观。请注意，当触摸探索服务（例如 TalkBack）处于活动状态时，
 * 底部应用栏不会对滚动做出反应。请参阅 [BottomAppBarScrollBehavior.nestedScrollConnection]。
 * @param 内容 此 底部应用栏 的内容。此处的默认布局是 [Row]，因此内部内容将水平排列。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 折叠底部应用栏(
    修饰符: Modifier = Modifier,
    容器颜色: Color = BottomAppBarDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    内容内边距: PaddingValues = BottomAppBarDefaults.FlexibleContentPadding,
    水平排列: Arrangement.Horizontal =
        BottomAppBarDefaults.FlexibleHorizontalArrangement,
    已展开高度: Dp = BottomAppBarDefaults.FlexibleBottomAppBarHeight,
    窗口插入: WindowInsets = BottomAppBarDefaults.windowInsets,
    滚动行为: BottomAppBarScrollBehavior? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    FlexibleBottomAppBar(
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        contentPadding = 内容内边距,
        horizontalArrangement = 水平排列,
        expandedHeight = 已展开高度,
        windowInsets = 窗口插入,
        scrollBehavior = 滚动行为,
        content = 内容,
    )



/**
 * 一个 TopAppBarScrollBehavior 定义了当应用栏下方的内容发生滚动时，应用栏应如何表现。
 *
 * @see [TopAppBarDefaults.pinnedScrollBehavior]
 * @see [TopAppBarDefaults.enterAlwaysScrollBehavior]
 * @see [TopAppBarDefaults.exitUntilCollapsedScrollBehavior]
 */
@Stable
interface 顶部应用栏滚动行为 { // TopAppBarScrollBehavior

    /** 一个与此行为关联的 [TopAppBarState]，当发生滚动时会被读取和更新。*/
    val 状态: TopAppBarState // state

    /**
     * 指示顶部应用栏是否被固定。
     *
     * 被固定的应用栏在内容滚动时会保持在原位，不会响应任何拖拽手势。
     */
    val 是否已固定: Boolean // isPinned

    /**
     * 一个可选的 [AnimationSpec]，用于定义当顶部应用栏被快速滑动或拖拽到中间位置时，如何吸附到完全折叠或完全展开的状态。
     * 如果提供 `null`，应用栏将不会吸附，而是保持当前状态。
     */
    val 吸附动画规格: AnimationSpec<Float>? // snapAnimationSpec

    /**
     * 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动应用栏本身或可滚动内容时，顶部应用栏应如何惯性滑动。
     * 如果提供 `null`，应用栏将不会继续根据滚动速度来动画化其高度。
     */
    val 抛掷动画规格: DecayAnimationSpec<Float>? // flingAnimationSpec

    /**
     * 一个应附加到 [androidx.compose.ui.input.nestedscroll.nestedScroll] 的 [NestedScrollConnection]，
     * 用于跟踪滚动事件。
     */
    val 嵌套滚动连接: NestedScrollConnection // nestedScrollConnection

}

//===================================================================================

/** 一个与此行为关联的 [TopAppBarState]，当发生滚动时会被读取和更新。*/
val TopAppBarScrollBehavior.状态: TopAppBarState
    get() = this.state

/**
 * 指示顶部应用栏是否被固定。
 *
 * 被固定的应用栏在内容滚动时会保持在原位，不会响应任何拖拽手势。
 */
val TopAppBarScrollBehavior.是否已固定: Boolean
    get() = this.isPinned

/**
 * 一个可选的 [AnimationSpec]，用于定义当顶部应用栏被快速滑动或拖拽到中间位置时，如何吸附到完全折叠或完全展开的状态。
 * 如果提供 `null`，应用栏将不会吸附，而是保持当前状态。
 */
val TopAppBarScrollBehavior.吸附动画规格: AnimationSpec<Float>?
    get() = this.snapAnimationSpec

/**
 * 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动应用栏本身或可滚动内容时，顶部应用栏应如何惯性滑动。
 * 如果提供 `null`，应用栏将不会继续根据滚动速度来动画化其高度。
 */
val TopAppBarScrollBehavior.抛掷动画规格: DecayAnimationSpec<Float>?
    get() = this.flingAnimationSpec

/**
 * 一个应附加到 [androidx.compose.ui.input.nestedscroll.nestedScroll] 的 [NestedScrollConnection]，
 * 用于跟踪滚动事件。
 */
val TopAppBarScrollBehavior.嵌套滚动连接: NestedScrollConnection
    get() = this.nestedScrollConnection

//===================================================================================

/** 包含顶部应用栏实现所使用的默认值。 */
object 顶部应用栏默认值 { // TopAppBarDefaults

    /** 为小型 [TopAppBar] 创建 [TopAppBarColors]。默认实现会根据 Material Design 规范在提供的颜色之间进行动画过渡。*/
    @Composable fun 顶部应用栏颜色集() = TopAppBarDefaults.topAppBarColors()

    /**
     * 为小型 [TopAppBar] 创建 [TopAppBarColors]。默认实现会根据 Material Design 规范在提供的颜色之间进行动画过渡。
     *
     * @param 容器颜色 容器颜色
     * @param 滚动容器颜色 当内容在其后方滚动时的容器颜色。
     * @param 导航图标内容颜色 用于导航图标的内容颜色
     * @param 标题内容颜色 用于标题的内容颜色
     * @param 操作图标内容颜色 用于操作按钮的内容颜色
     * @param 副标题内容颜色 用于副标题的内容颜色
     * @return 用于顶部应用栏的生成的 [TopAppBarColors]
     */
    @Composable
    fun 顶部应用栏颜色集(
        容器颜色: Color = Color.Unspecified,
        滚动容器颜色: Color = Color.Unspecified,
        导航图标内容颜色: Color = Color.Unspecified,
        标题内容颜色: Color = Color.Unspecified,
        操作图标内容颜色: Color = Color.Unspecified,
        副标题内容颜色: Color = Color.Unspecified,
    ): TopAppBarColors =
        TopAppBarDefaults.topAppBarColors(
            containerColor = 容器颜色,
            scrolledContainerColor = 滚动容器颜色,
            navigationIconContentColor = 导航图标内容颜色,
            titleContentColor = 标题内容颜色,
            actionIconContentColor = 操作图标内容颜色,
            subtitleContentColor = 副标题内容颜色,
        )


    /** 用于 [TopAppBar] 内容的默认内边距。 */
    val 内容内边距 = TopAppBarDefaults.ContentPadding

    /** 顶部应用栏使用和消费的默认内边距。*/
    val 窗口插入: WindowInsets
        @Composable
        get() = TopAppBarDefaults.windowInsets

    /**
     * 默认的 [AnimationSpec]，定义了当顶部应用栏因快速滑动或拖拽滚动而处于中间位置时，如何快速吸附到完全折叠或完全展开的状态。
     */
    val 吸附动画规格: AnimationSpec<Float>
        @Composable get() = TopAppBarDefaults.snapAnimationSpec

    /** 为 [CenterAlignedTopAppBar] 创建 [TopAppBarColors]。默认实现会根据 Material Design 规范在提供的颜色之间进行动画过渡。*/
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith = ReplaceWith("topAppBarColors()"),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 居中对齐顶部应用栏颜色集() = TopAppBarDefaults.centerAlignedTopAppBarColors()

    /**
     * 为 [CenterAlignedTopAppBar] 创建 [TopAppBarColors]。默认实现会根据 Material Design 规范在提供的颜色之间进行动画过渡。
     *
     * @param 容器颜色 容器颜色
     * @param 滚动容器颜色 当内容在其后方滚动时的容器颜色
     * @param 导航图标内容颜色 用于导航图标的内容颜色
     * @param 标题内容颜色 用于标题的内容颜色
     * @param 操作图标内容颜色 用于操作按钮的内容颜色
     * @return 用于顶部应用栏的 [TopAppBarColors] 结果
     */
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith =
            ReplaceWith(
                "topAppBarColors(containerColor, scrolledContainerColor, " +
                        "navigationIconContentColor, titleContentColor, actionIconContentColor)"
            ),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 居中对齐顶部应用栏颜色集(
        容器颜色: Color = Color.Unspecified,
        滚动容器颜色: Color = Color.Unspecified,
        导航图标内容颜色: Color = Color.Unspecified,
        标题内容颜色: Color = Color.Unspecified,
        操作图标内容颜色: Color = Color.Unspecified,
    ): TopAppBarColors =
        TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = 容器颜色,
            scrolledContainerColor = 滚动容器颜色,
            navigationIconContentColor = 导航图标内容颜色,
            titleContentColor = 标题内容颜色,
            actionIconContentColor = 操作图标内容颜色,
        )

    /**
     * 为 [MediumTopAppBar] 创建 [TopAppBarColors]。默认实现会根据 Material Design 规范，在顶部应用栏滚动时，
     * 在提供的颜色之间进行插值。
     */
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith = ReplaceWith("topAppBarColors()"),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 中等顶部应用栏颜色集() = TopAppBarDefaults.mediumTopAppBarColors()

    /**
     * 为 [MediumTopAppBar] 创建 [TopAppBarColors]。默认实现会根据 Material Design 规范，在顶部应用栏滚动时，
     * 在提供的颜色之间进行插值。
     *
     * @param 容器颜色 容器颜色
     * @param 滚动容器颜色 当内容在其后方滚动时的容器颜色
     * @param 导航图标内容颜色 用于导航图标的内容颜色
     * @param 标题内容颜色 用于标题的内容颜色
     * @param 操作图标内容颜色 用于操作按钮的内容颜色
     * @return 用于顶部应用栏的 [TopAppBarColors]
     */
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith =
            ReplaceWith(
                "topAppBarColors(containerColor, scrolledContainerColor, " +
                        "navigationIconContentColor, titleContentColor, actionIconContentColor)"
            ),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 中等顶部应用栏颜色集(
        容器颜色: Color = Color.Unspecified,
        滚动容器颜色: Color = Color.Unspecified,
        导航图标内容颜色: Color = Color.Unspecified,
        标题内容颜色: Color = Color.Unspecified,
        操作图标内容颜色: Color = Color.Unspecified,
    ): TopAppBarColors =
        TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = 容器颜色,
            scrolledContainerColor = 滚动容器颜色,
            navigationIconContentColor = 导航图标内容颜色,
            titleContentColor = 标题内容颜色,
            actionIconContentColor = 操作图标内容颜色,
        )

    /**
     * 为 [LargeTopAppBar] 创建 [TopAppBarColors]。默认实现遵循 Material Design 规范，在顶部应用栏滚动时，
     * 在提供的颜色之间进行插值。
     */
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith = ReplaceWith("topAppBarColors()"),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 大型顶部应用栏颜色集() = TopAppBarDefaults.largeTopAppBarColors()

    /**
     * 为 [LargeTopAppBar] 创建 [TopAppBarColors]。默认实现遵循 Material Design 规范，在顶部应用栏滚动时，
     * 在提供的颜色之间进行插值。
     *
     * @param 容器颜色 容器颜色
     * @param 滚动容器颜色 当内容在其后方滚动时的容器颜色
     * @param 导航图标内容颜色 用于导航图标的内容颜色
     * @param 标题内容颜色 用于标题的内容颜色
     * @param 操作图标内容颜色 用于操作按钮的内容颜色
     * @return 用于顶部应用栏的 [TopAppBarColors]
     */
    @Deprecated(
        "Use topAppBarColors instead",
        replaceWith =
            ReplaceWith(
                "topAppBarColors(containerColor, scrolledContainerColor, " +
                        "navigationIconContentColor, titleContentColor, actionIconContentColor)"
            ),
        DeprecationLevel.WARNING,
    )
    @Composable
    fun 大型顶部应用栏颜色集(
        容器颜色: Color = Color.Unspecified,
        滚动容器颜色: Color = Color.Unspecified,
        导航图标内容颜色: Color = Color.Unspecified,
        标题内容颜色: Color = Color.Unspecified,
        操作图标内容颜色: Color = Color.Unspecified,
    ): TopAppBarColors =
        TopAppBarDefaults.largeTopAppBarColors(
            containerColor = 容器颜色,
            scrolledContainerColor = 滚动容器颜色,
            navigationIconContentColor = 导航图标内容颜色,
            titleContentColor = 标题内容颜色,
            actionIconContentColor = 操作图标内容颜色,
        )

    /**
     * 返回一个固定的 [TopAppBarScrollBehavior]，该行为会跟踪嵌套滚动回调，并相应地更新其 [TopAppBarState.contentOffset]。
     * 注意：如果你的布局使用了 [LazyListState] 的 reverseLayout，或者涉及 [ScrollState] 的 reverseScrolling，
     * 请考虑使用专门为这些场景设计的其他重载方法。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组过程中被记忆。
     *
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需一个在重组过程中保持记忆的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 用于确定滚动事件是否由该固定的 [TopAppBarScrollBehavior] 处理的回调。
     */
    @Composable
    fun 固定滚动行为(
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.pinnedScrollBehavior(
            state = 状态,
            canScroll = 可以滚动
        )

    /**
     * 返回一个固定的 [TopAppBarScrollBehavior]，该行为会跟踪嵌套滚动回调，并相应地更新其 [TopAppBarState.contentOffset]。
     *
     * 此重载适用于内容已预滚动或使用 reverseLayout 的 [LazyColumn] 场景，因为它能正确处理这些特定滚动状态下 [TopAppBar] 的颜色过渡。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组过程中被记忆。
     *
     * @param 懒加载列表状态 观察列表滚动位置的 [LazyListState] 对象，用于判断列表是否已滚动至起始位置。
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需一个在重组过程中保持记忆的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 用于确定滚动事件是否由该固定的 [TopAppBarScrollBehavior] 处理的回调。
     */
    @Deprecated(
        message =
            "Please use the pinnedScrollBehavior function that takes a ScrollableState parameter.",
        replaceWith =
            ReplaceWith(
                "pinnedScrollBehavior(scrollableState = lazyListState, state = state, canScroll = canScroll)"
            ),
        level = DeprecationLevel.WARNING,
    )
    @ExperimentalMaterial3Api
    @Composable
    fun 固定滚动行为(
        懒加载列表状态: LazyListState,
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.pinnedScrollBehavior(
            lazyListState = 懒加载列表状态,
            state = 状态,
            canScroll = 可以滚动
        )

    /**
     * 返回一个固定的 [TopAppBarScrollBehavior]，该行为会跟踪嵌套滚动回调，并相应地更新其 [TopAppBarState.contentOffset]。
     *
     * 此重载适用于使用 [ScrollState] 的可组合项场景，例如带有 verticalScroll 的 [Column]，特别是当内容已预滚动或使用
     * reverseScrolling 时。它能正确处理这些特定滚动状态下 [TopAppBar] 的颜色过渡。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组（recomposition）过程中被记住（remembered）。
     *
     * @param 滚动状态 滚动状态
     * @param 反向滚动 反转滚动方向，当为 true 时，0 [ScrollState.value] 表示底部；当为 false 时，
     * 0 [ScrollState.value] 表示顶部。
     * @param 状态 用于控制或监听顶部应用栏滚动状态的状态对象。如需一个在重组过程中被记住的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 一个回调，用于判断滚动事件是否应由该固定的 [TopAppBarScrollBehavior] 处理。
     */
    @Deprecated(
        message =
            "Please use the pinnedScrollBehavior function that takes a ScrollableState parameter.",
        replaceWith =
            ReplaceWith(
                "pinnedScrollBehavior(scrollableState = scrollState, state = state, canScroll = canScroll)"
            ),
        level = DeprecationLevel.WARNING,
    )
    @ExperimentalMaterial3Api
    @Composable
    fun 固定滚动行为(
        滚动状态: ScrollState,
        反向滚动: Boolean = false,
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.pinnedScrollBehavior(
            scrollState = 滚动状态,
            reverseScrolling = 反向滚动,
            state = 状态,
            canScroll = 可以滚动
        )

    /**
     * 返回一个固定的 [TopAppBarScrollBehavior]，该行为跟踪嵌套滚动回调，并相应地更新其 [TopAppBarState.contentOffset]。
     *
     * 此重载适用于标准重载无法覆盖的用例，例如当需要为自定义或复杂布局（如 reverseLayout = true 的 LazyVerticalGrid）
     * 确定自定义的 是否滚动内容在开始 状态时。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组过程中被记住。
     *
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需一个在重组过程中被记住的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 一个回调，用于判断滚动事件是否应由该固定的 [TopAppBarScrollBehavior] 处理。
     * @param 是否滚动内容在开始 当可滚动组件位于其内容的原点时返回 true 的回调。处理反向布局，确保"起始"始终指代第一个逻辑项。
     */
    @Deprecated(
        message =
            "Please use the pinnedScrollBehavior function that takes a ScrollableState parameter.",
        level = DeprecationLevel.WARNING,
    )
    @ExperimentalMaterial3Api
    @Composable
    fun 固定滚动行为(
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
        是否滚动内容在开始: () -> Boolean = { true },
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.pinnedScrollBehavior(
            state = 状态,
            canScroll = 可以滚动,
            isScrollingContentAtStart = 是否滚动内容在开始
        )

    /**
     * 返回一个固定的 [TopAppBarScrollBehavior]，它会跟踪嵌套滚动回调并相应地更新其 [TopAppBarState.contentOffset]。
     *
     * 此重载适用于滚动状态由 [ScrollableState] 表示的用例（例如 `LazyVerticalGrid`）。它通过观察所提供的 [ScrollableState] 的滚动位置来自动判断内容是否位于起始位置。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组过程中被记住（保持状态）。
     *
     * @param 可滚动状态 可滚动容器的 [ScrollableState]，用于判断内容是否位于起始位置。
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需一个在重组过程中被记住的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 用于确定滚动事件是否应由该固定的 [TopAppBarScrollBehavior] 处理的回调。
     */
    @Composable
    fun 固定滚动行为(
        可滚动状态: ScrollableState,
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.pinnedScrollBehavior(
            scrollableState = 可滚动状态,
            state = 状态,
            canScroll = 可以滚动,
        )

    /**
     * 返回一个 [TopAppBarScrollBehavior]。配置了此 [TopAppBarScrollBehavior] 的顶部应用栏会在内容向上拉动时立即折叠，
     * 并在内容向下拉动时立即出现。注意：如果您的布局对 [LazyListState] 使用了 reverseLayout，或对 [ScrollState]
     * 使用了 reverseScrolling，请考虑使用专门为这些用例设计的其他重载。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组过程中被记住。
     *
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需一个在重组过程中被记住的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 一个回调，用于判断滚动事件是否应由该 [TopAppBarScrollBehavior] 处理。
     * @param 吸附动画规格 一个可选的 [AnimationSpec]，用于定义当顶部应用栏被快速滑动或拖拽滚动到中间位置时，
     * 如何快速吸附（snap）到完全折叠或完全展开的状态。
     * @param 抛掷动画规格 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动顶部应用栏本身或其下方内容时，如何执行衰减抛掷动画。
     */
    @Composable
    fun 进入始终滚动行为(
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
        吸附动画规格: AnimationSpec<Float>? = TopAppBarDefaults.snapAnimationSpec,
        抛掷动画规格: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(
            state = 状态,
            canScroll = 可以滚动,
            snapAnimationSpec = 吸附动画规格,
            flingAnimationSpec = 抛掷动画规格,
        )

    /**
     * 返回一个 [TopAppBarScrollBehavior]。配置了此 [TopAppBarScrollBehavior] 的顶部应用栏会在内容向上拉动时立即折叠，
     * 并在内容向下拉动时立即出现。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组过程中被记住。
     *
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需一个在重组过程中被记住的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 一个回调，用于判断滚动事件是否应由该 [EnterAlwaysScrollBehavior] 处理。
     * @param 吸附动画规格 一个可选的 [AnimationSpec]，用于定义当顶部应用栏被快速滑动或拖拽滚动到中间位置时，
     * 如何快速吸附到完全折叠或完全展开的状态。
     * @param 抛掷动画规格 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动顶部应用栏本身或其下方内容时，
     * 如何执行衰减抛掷动画。
     * @param 反向布局 表示此行为应用于滚动方向和布局均为反向的可滚动内容。
     */
    @Deprecated(
        message =
            "Please use the enterAlwaysScrollBehavior() function that takes a scrollableState parameter.",
        replaceWith =
            ReplaceWith(
                "enterAlwaysScrollBehavior(scrollableState, state, canScroll, snapAnimationSpec, flingAnimationSpec)"
            ),
        level = DeprecationLevel.WARNING,
    )
    @ExperimentalMaterial3Api
    @Composable
    fun 进入始终滚动行为(
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
        吸附动画规格: AnimationSpec<Float>? = TopAppBarDefaults.snapAnimationSpec,
        抛掷动画规格: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
        反向布局: Boolean = false,
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(
            state = 状态,
            canScroll = 可以滚动,
            snapAnimationSpec = 吸附动画规格,
            flingAnimationSpec = 抛掷动画规格,
            reverseLayout = 反向布局,
        )

    /**
     * 返回一个 [TopAppBarScrollBehavior]。配置了此 [TopAppBarScrollBehavior] 的顶部应用栏会在内容向上拉动时立即折叠，
     * 并在内容向下拉动时立即出现。
     *
     * 此重载适用于内容已预滚动或使用 reverseLayout 的 [LazyColumn] 用例，因为它能正确处理这些特定滚动状态下 [TopAppBar] 的颜色过渡。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组过程中被记住。
     *
     * @param 懒加载列表状态 观察列表滚动位置的 [LazyListState] 对象，用于判断列表是否滚动到了起始位置。
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需一个在重组过程中被记住的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 一个回调，用于判断滚动事件是否应由该 [TopAppBarScrollBehavior] 处理。
     * @param 吸附动画规格 一个可选的 [AnimationSpec]，用于定义当顶部应用栏被快速滑动或拖拽滚动到中间位置时，
     * 如何快速吸附到完全折叠或完全展开的状态。
     * @param 抛掷动画规格 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动顶部应用栏本身或其下方内容时，
     * 如何执行衰减抛掷动画。
     */
    @Deprecated(
        message =
            "Please use the enterAlwaysScrollBehavior function that takes a ScrollableState parameter.",
        replaceWith =
            ReplaceWith(
                "enterAlwaysScrollBehavior(scrollableState = lazyListState, state = state, canScroll = canScroll, snapAnimationSpec = snapAnimationSpec, flingAnimationSpec = flingAnimationSpec)"
            ),
        level = DeprecationLevel.WARNING,
    )
    @ExperimentalMaterial3Api
    @Composable
    fun 进入始终滚动行为(
        懒加载列表状态: LazyListState,
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
        吸附动画规格: AnimationSpec<Float>? = TopAppBarDefaults.snapAnimationSpec,
        抛掷动画规格: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(
            lazyListState = 懒加载列表状态,
            state = 状态,
            canScroll = 可以滚动,
            snapAnimationSpec = 吸附动画规格,
            flingAnimationSpec = 抛掷动画规格,
        )

    /**
     * 返回一个 [TopAppBarScrollBehavior]。配置了此 [TopAppBarScrollBehavior] 的顶部应用栏会在内容向上拉动时立即折叠，
     * 并在内容向下拉动时立即出现。
     *
     * 此重载适用于使用 [ScrollState] 的 Composable 用例，例如带有 verticalScroll 的 [Column]，特别是在内容已预滚动或使用
     * reverseScrolling 时。它能正确处理这些特定滚动状态下 [TopAppBar] 的颜色过渡。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组过程中被记住。
     *
     * 一个小型 [TopAppBar] 的示例，该应用栏在内容向上滚动时折叠，在内容向下滚动时出现，使用带有反向滚动的 [Column]。
     *
     * @param 滚动状态 滚动状态
     * @param 反向滚动 反转滚动方向，当为 true 时，0 [ScrollState.value] 表示底部；当为 false 时，
     * 0 [ScrollState.value] 表示顶部。
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需一个在重组过程中被记住的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 一个回调，用于判断滚动事件是否应由该 [TopAppBarScrollBehavior] 处理。
     * @param 吸附动画规格 一个可选的 [AnimationSpec]，用于定义当顶部应用栏被快速滑动或拖拽滚动到中间位置时，
     * 如何快速吸附到完全折叠或完全展开的状态。
     * @param 抛掷动画规格 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动顶部应用栏本身或其下方内容时，
     * 如何执行衰减抛掷动画。
     */
    @Deprecated(
        message =
            "Please use the enterAlwaysScrollBehavior function that takes a ScrollableState parameter.",
        replaceWith =
            ReplaceWith(
                "enterAlwaysScrollBehavior(scrollableState = scrollState, state = state, canScroll = canScroll, snapAnimationSpec = snapAnimationSpec, flingAnimationSpec = flingAnimationSpec)"
            ),
        level = DeprecationLevel.WARNING,
    )
    @ExperimentalMaterial3Api
    @Composable
    fun 进入始终滚动行为(
        滚动状态: ScrollState,
        反向滚动: Boolean = false,
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
        吸附动画规格: AnimationSpec<Float>? = TopAppBarDefaults.snapAnimationSpec,
        抛掷动画规格: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(
            scrollState = 滚动状态,
            reverseScrolling = 反向滚动,
            state = 状态,
            canScroll = 可以滚动,
            snapAnimationSpec = 吸附动画规格,
            flingAnimationSpec = 抛掷动画规格,
        )

    /**
     * 返回一个 [TopAppBarScrollBehavior]。配置了此 [TopAppBarScrollBehavior] 的顶部应用栏会在内容向上拉动时立即折叠，
     * 并在内容向下拉动时立即出现。
     *
     * 此重载适用于标准重载无法覆盖的用例，例如当需要为自定义或复杂布局（如 reverseLayout = true 的 LazyVerticalGrid）
     * 确定自定义的 isScrollingContentAtStart 状态时。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组过程中被记住。
     *
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需一个在重组过程中被记住的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 一个回调，用于判断滚动事件是否应由该 [TopAppBarScrollBehavior] 处理。
     * @param 吸附动画规格 一个可选的 [AnimationSpec]，用于定义当顶部应用栏被快速滑动或拖拽滚动到中间位置时，
     * 如何快速吸附到完全折叠或完全展开的状态。
     * @param 抛掷动画规格 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动顶部应用栏本身或其下方内容时，
     * 如何执行衰减抛掷动画。
     * @param 是否滚动内容在开始 当可滚动组件位于其内容的原点时返回 true 的回调。处理反向布局，确保"起始"始终指代第一个逻辑项。
     */
    @Deprecated(
        message =
            "Please use the enterAlwaysScrollBehavior function that takes a ScrollableState parameter.",
        level = DeprecationLevel.WARNING,
    )
    @Composable
    fun 进入始终滚动行为(
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
        吸附动画规格: AnimationSpec<Float>? = TopAppBarDefaults.snapAnimationSpec,
        抛掷动画规格: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
        是否滚动内容在开始: () -> Boolean = { true },
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(
            state = 状态,
            canScroll = 可以滚动,
            snapAnimationSpec = 吸附动画规格,
            flingAnimationSpec = 抛掷动画规格,
            isScrollingContentAtStart = 是否滚动内容在开始,
        )

    /**
     * 返回一个 [TopAppBarScrollBehavior]。配置了此 [TopAppBarScrollBehavior] 的顶部应用栏会在内容上拉时立即折叠，并在内容下拉时立即显示。
     *
     * 此重载适用于包含可滚动容器的用例（例如 [LazyColumn]、带有 `verticalScroll` 的 [Column]，或任何其他实现了
     * [ScrollableState] 的容器），特别是当内容已预先滚动或使用 `reverseLayout`/`reverseScrolling` 时，因为它能正确处理这些特定滚动状态下 [TopAppBar] 的颜色过渡。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组过程中被记住（保持状态）。
     *
     * @param 可滚动状态 可滚动容器的 [ScrollableState]，用于判断内容是否位于起始位置。
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需一个在重组过程中被记住的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 用于确定滚动事件是否应由该 [TopAppBarScrollBehavior] 处理的回调。
     * @param 吸附动画规格 一个可选的 [AnimationSpec]，用于定义当顶部应用栏因快速滑动或拖拽滚动而处于中间位置时，
     * 如何快速吸附到完全折叠或完全展开的状态。如果提供 `null`，则应用栏不会吸附，而是保持其当前状态。
     * @param 抛掷动画规格 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动应用栏本身或可滚动内容时，
     * 如何对顶部应用栏执行惯性滑动动画。如果提供 `null`，则应用栏不会根据滚动速度继续动画其高度。
     */
    @Composable
    fun 进入始终滚动行为(
        可滚动状态: ScrollableState,
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
        吸附动画规格: AnimationSpec<Float>? = TopAppBarDefaults.snapAnimationSpec,
        抛掷动画规格: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(
            scrollableState = 可滚动状态,
            state = 状态,
            canScroll = 可以滚动,
            snapAnimationSpec = 吸附动画规格,
            flingAnimationSpec = 抛掷动画规格,
        )

    /**
     * 返回一个 [TopAppBarScrollBehavior]，该行为调整其属性以影响顶部应用栏的颜色和高度。
     *
     * 配置了此 [TopAppBarScrollBehavior] 的顶部应用栏会在嵌套内容向上拉动时立即折叠，并在内容完全向下拉动时重新展开已折叠的区域。
     *
     * 返回的 [TopAppBarScrollBehavior] 会在重组过程中被记住。
     *
     * @param 状态 用于控制或观察顶部应用栏滚动状态的状态对象。如需一个在重组过程中被记住的状态，请参阅 [rememberTopAppBarState]。
     * @param 可以滚动 一个回调，用于判断滚动事件是否应由该 [ExitUntilCollapsedScrollBehavior] 处理。
     * @param 吸附动画规格 一个可选的 [AnimationSpec]，用于定义当顶部应用栏被快速滑动或拖拽滚动到中间位置时，
     * 如何快速吸附到完全折叠或完全展开的状态。
     * @param 抛掷动画规格 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动顶部应用栏本身或其下方内容时，
     * 如何执行衰减抛掷动画。
     */
    @Composable
    fun 退出直到折叠滚动行为(
        状态: TopAppBarState = rememberTopAppBarState(),
        可以滚动: () -> Boolean = { true },
        吸附动画规格: AnimationSpec<Float>? = TopAppBarDefaults.snapAnimationSpec,
        抛掷动画规格: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
    ): TopAppBarScrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
            state = 状态,
            canScroll = 可以滚动,
            snapAnimationSpec = 吸附动画规格,
            flingAnimationSpec = 抛掷动画规格,
        )

    /** [TopAppBar] 和 [CenterAlignedTopAppBar] 的默认展开高度。 */
    val 顶部应用栏已展开高度: Dp = TopAppBarDefaults.TopAppBarExpandedHeight

    /** [MediumTopAppBar] 被 [TopAppBarScrollBehavior] 折叠后的默认高度。 */
    val 中型应用栏已折叠高度: Dp = TopAppBarDefaults.MediumAppBarCollapsedHeight

    /** [MediumTopAppBar] 的默认展开高度。 */
    val 中型应用栏已展开高度: Dp = TopAppBarDefaults.MediumAppBarExpandedHeight

    /** 无副标题的 [MediumFlexibleTopAppBar] 的默认展开高度。 */
    val 中型折叠应用栏无副标题已展开高度: Dp =
        TopAppBarDefaults.MediumFlexibleAppBarWithoutSubtitleExpandedHeight

    /** 带副标题的 [MediumFlexibleTopAppBar] 的默认展开高度。 */
    val 中型折叠应用栏带副标题已展开高度: Dp =
        TopAppBarDefaults.MediumFlexibleAppBarWithSubtitleExpandedHeight

    /** [LargeTopAppBar] 被 [TopAppBarScrollBehavior] 折叠后的默认高度。 */
    val 大型应用栏已折叠高度: Dp = TopAppBarDefaults.LargeAppBarCollapsedHeight

    /** [LargeTopAppBar] 的默认展开高度。 */
    val 大型应用栏已展开高度: Dp = TopAppBarDefaults.LargeAppBarExpandedHeight

    /** 无副标题的 [LargeFlexibleTopAppBar] 的默认展开高度。 */
    val 大型折叠应用栏无副标题已展开高度: Dp =
        TopAppBarDefaults.LargeFlexibleAppBarWithoutSubtitleExpandedHeight

    /** 带副标题的 [LargeFlexibleTopAppBar] 的默认展开高度。*/
    val 大型折叠应用栏带副标题已展开高度: Dp =
        TopAppBarDefaults.LargeFlexibleAppBarWithSubtitleExpandedHeight

}


/**
 * 创建一个在重组过程中被记住的 [TopAppBarState]。
 *
 * @param 初始高度偏移量限制 [TopAppBarState.heightOffsetLimit] 的初始值，表示当可滚动内容发生滚动时，顶部应用栏允许折叠的像素上限。
 * @param 初始高度偏移量 [TopAppBarState.heightOffset] 的初始值。初始偏移高度应在 0 和 [初始高度偏移量限制] 之间。
 * @param 初始内容偏移量 [TopAppBarState.contentOffset] 的初始值。
 */
@Composable
fun 记住顶部应用栏状态(
    初始高度偏移量限制: Float = -Float.MAX_VALUE,
    初始高度偏移量: Float = 0f,
    初始内容偏移量: Float = 0f,
): TopAppBarState =
    rememberTopAppBarState(
        initialHeightOffsetLimit = 初始高度偏移量限制,
        initialHeightOffset = 初始高度偏移量,
        initialContentOffset = 初始内容偏移量
    )

/**
 * 一个可提升的状态对象，用于控制和观察顶部应用栏的状态。该状态由 [TopAppBarScrollBehavior] 实现读取和更新。
 *
 * 在大多数情况下，此状态将通过 [rememberTopAppBarState] 创建。
 *
 * @param 初始高度偏移量限制 [TopAppBarState.heightOffsetLimit] 的初始值
 * @param 初始高度偏移量 [TopAppBarState.heightOffset] 的初始值
 * @param 初始内容偏移量 [TopAppBarState.contentOffset] 的初始值
 */
@Stable
fun 顶部应用栏状态(
    初始高度偏移量限制: Float,
    初始高度偏移量: Float,
    初始内容偏移量: Float,
) =
    TopAppBarState(
        initialHeightOffsetLimit = 初始高度偏移量限制,
        initialHeightOffset = 初始高度偏移量,
        initialContentOffset = 初始内容偏移量
    )

//=======================================================================

/**
 * 顶部应用栏的高度偏移限制（以像素为单位），表示顶部应用栏允许折叠到的极限。
 *
 * 使用此限制在更新 [高度偏移量] 值时对其进行强制约束。
 */
var TopAppBarState.高度偏移量限制
    get() = this.heightOffsetLimit
    set(newLimit) {
        this.heightOffsetLimit = newLimit
    }

/**
 * 顶部应用栏当前的高度偏移量（以像素为单位）。此高度偏移量应用于应用栏的固定高度，以在内容滚动时控制显示高度。
 *
 * 对 [高度偏移量] 值的更新会被强制约束在 0 和 [高度偏移量限制] 之间。
 */
var TopAppBarState.高度偏移量: Float
    get() = this.heightOffset
    set(newOffset) {
        this.heightOffset = newOffset
    }


/**
 * 在顶部应用栏下方滚动的内容的总偏移量。
 *
 * 内容偏移量用于计算 [重叠比例]，随后可由具体实现读取。
 *
 * 此值由 [TopAppBarScrollBehavior] 在嵌套滚动连接消费滚动事件时更新。常见的实现会将此值更新为所有
 * [NestedScrollConnection.onPostScroll] 中 consumed.y 值的总和。
 */
var TopAppBarState.内容偏移量
    get() = this.contentOffset
    set(newOffset) {
        this.contentOffset = newOffset
    }

/**
 * 表示应用栏折叠高度百分比的值。
 *
 * 0.0 表示完全展开的应用栏，1.0 表示完全折叠的应用栏（计算方式为 [高度偏移量] / [高度偏移量限制]）。
 */
val TopAppBarState.折叠比例: Float
    get() = this.collapsedFraction

/**
 * 表示应用栏区域与其后方滚动内容重叠部分所占百分比的值。
 *
 * 0.0 表示应用栏未与任何内容重叠，1.0 表示应用栏整个可见区域均与滚动内容重叠。
 */
val TopAppBarState.重叠比例: Float
    get() = this.overlappedFraction

//=======================================================================

object 顶部应用栏状态{

    /** [TopAppBarState] 的默认 [保存器] 实现。 */
    val 保存器: Saver<TopAppBarState, *> = TopAppBarState.Saver

}

//=======================================================================

/**
 * 代表顶部应用栏在不同状态下使用的颜色。此实现会根据顶部应用栏的滚动状态对容器颜色进行动画处理。它不会对前导图标、
 * 标题或尾部图标的颜色进行动画处理。
 *
 * @param 容器颜色 用于此 TopAppBar 背景的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 滚动容器颜色 当内容滚动到其背后时的容器颜色。
 * @param 导航图标内容颜色 用于导航图标的内容颜色。
 * @param 标题内容颜色 用于标题的内容颜色。
 * @param 操作图标内容颜色 用于操作按钮的内容颜色。
 * @param 副标题内容颜色 用于副标题的内容颜色。
 * @constructor 要使用任意颜色创建实例，请参阅 [TopAppBarColors]，其中提供了使用默认 Material3 规范的工厂方法。
 */
fun 顶部应用栏颜色集(
    容器颜色: Color,
    滚动容器颜色: Color,
    导航图标内容颜色: Color,
    标题内容颜色: Color,
    操作图标内容颜色: Color,
    副标题内容颜色: Color,
) =
    TopAppBarColors(
        containerColor = 容器颜色,
        scrolledContainerColor = 滚动容器颜色,
        navigationIconContentColor = 导航图标内容颜色,
        titleContentColor = 标题内容颜色,
        actionIconContentColor = 操作图标内容颜色,
        subtitleContentColor = 副标题内容颜色,
    )

@Deprecated(
    "Use the TopAppBarColors constructor with subtitleContentColor",
    replaceWith =
        ReplaceWith(
            "TopAppBarColors(containerColor, scrolledContainerColor," +
                    "navigationIconContentColor, titleContentColor, actionIconContentColor, " +
                    "subtitleContentColor)"
        ),
    DeprecationLevel.WARNING,
)
fun 顶部应用栏颜色集(
    容器颜色: Color,
    滚动容器颜色: Color,
    导航图标内容颜色: Color,
    标题内容颜色: Color,
    操作图标内容颜色: Color,
) =
    TopAppBarColors(
        containerColor = 容器颜色,
        scrolledContainerColor = 滚动容器颜色,
        navigationIconContentColor = 导航图标内容颜色,
        titleContentColor = 标题内容颜色,
        actionIconContentColor = 操作图标内容颜色,
    )

/** 返回此 TopAppBarColors 的副本，可选择性地覆盖其中某些值。这里使用 Color.Unspecified 表示"使用源对象中的值"。*/
fun TopAppBarColors.复制(
    容器颜色: Color = this.containerColor,
    滚动容器颜色: Color = this.scrolledContainerColor,
    导航图标内容颜色: Color = this.navigationIconContentColor,
    标题内容颜色: Color = this.titleContentColor,
    操作图标内容颜色: Color = this.actionIconContentColor,
    副标题内容颜色: Color = this.subtitleContentColor,
) =
    this.copy(
        containerColor = 容器颜色,
        scrolledContainerColor = 滚动容器颜色,
        navigationIconContentColor = 导航图标内容颜色,
        titleContentColor = 标题内容颜色,
        actionIconContentColor = 操作图标内容颜色,
        subtitleContentColor = 副标题内容颜色,
    )

val TopAppBarColors.容器颜色: Color
    get() = this.containerColor

val TopAppBarColors.滚动容器颜色: Color
    get() = this.scrolledContainerColor

val TopAppBarColors.导航图标内容颜色: Color
    get() = this.navigationIconContentColor

val TopAppBarColors.标题内容颜色: Color
    get() = this.titleContentColor

val TopAppBarColors.操作图标内容颜色: Color
    get() = this.actionIconContentColor

val TopAppBarColors.副标题内容颜色: Color
    get() = this.subtitleContentColor

//=======================================================================


/**
 **BottomAppBarScrollBehavior 定义了当底部应用栏上方的内容发生滚动时，底部应用栏应如何表现。**
 *
 * @see [BottomAppBarDefaults.exitAlwaysScrollBehavior]
 */
@ExperimentalMaterial3Api
@Stable
interface 底部应用栏滚动行为 { // BottomAppBarScrollBehavior

    /** 一个与此行为关联的 [BottomAppBarState]，当发生滚动时会被读取和更新。*/
    val 状态: BottomAppBarState

    /**
     * 指示底部应用栏是否被固定。
     *
     * 被固定的应用栏在内容滚动时会保持在原位，不会响应任何拖拽手势。
     */
    val 是否已固定: Boolean

    /** 一个可选的 [AnimationSpec]，用于定义当底部应用栏被快速滑动或拖拽到中间位置时，如何吸附到完全折叠或完全展开的状态。*/
    val 吸附动画规格: AnimationSpec<Float>?

    /** 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动应用栏本身或可滚动内容时，底部应用栏应如何惯性滑动。*/
    val 抛掷动画规格: DecayAnimationSpec<Float>?

    /**
     * 一个应附加到 [androidx.compose.ui.input.nestedscroll.nestedScroll] 的 [NestedScrollConnection]，
     * 用于跟踪滚动事件。
     */
    val 嵌套滚动连接: NestedScrollConnection

}

//=======================================================================

/** 一个与此行为关联的 [BottomAppBarState]，当发生滚动时会被读取和更新。*/
@ExperimentalMaterial3Api
val BottomAppBarScrollBehavior.状态: BottomAppBarState
    get() = this.state

/**
 * 指示底部应用栏是否被固定。
 *
 * 被固定的应用栏在内容滚动时会保持在原位，不会响应任何拖拽手势。
 */
@ExperimentalMaterial3Api
val BottomAppBarScrollBehavior.是否已固定: Boolean
    get() = this.isPinned

/** 一个可选的 [AnimationSpec]，用于定义当底部应用栏被快速滑动或拖拽到中间位置时，如何吸附到完全折叠或完全展开的状态。*/
@ExperimentalMaterial3Api
val BottomAppBarScrollBehavior.吸附动画规格: AnimationSpec<Float>?
    get() = this.snapAnimationSpec

/** 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动应用栏本身或可滚动内容时，底部应用栏应如何惯性滑动。*/
@ExperimentalMaterial3Api
val BottomAppBarScrollBehavior.抛掷动画规格: DecayAnimationSpec<Float>?
    get() = this.flingAnimationSpec

/**
 * 一个应附加到 [androidx.compose.ui.input.nestedscroll.nestedScroll] 的 [NestedScrollConnection]，
 * 用于跟踪滚动事件。
 */
@ExperimentalMaterial3Api
val BottomAppBarScrollBehavior.嵌套滚动连接: NestedScrollConnection
    get() = this.nestedScrollConnection

//=======================================================================


/** 包含底部应用栏实现所使用的默认值。 */
object 底部应用栏默认值 { // BottomAppBarDefaults

    /** 用于 [BottomAppBar] 容器的默认颜色。 */
    val 容器颜色: Color
        @Composable get() = BottomAppBarDefaults.containerColor

    /** 用于 [BottomAppBar] 的默认海拔高度。 */
    val 容器阴影: Dp = BottomAppBarDefaults.ContainerElevation

    /** 当内容物为默认尺寸（24dp）的图标且位于满足最小触摸目标（48.dp）的 [图标按钮] 中时，用于 [BottomAppBar] 的默认内边距。*/
    val 内容内边距 = BottomAppBarDefaults.ContentPadding

    /** [BottomAppBar] 所使用并消费的默认内边距。 */
    val 窗口插入: WindowInsets
        @Composable
        get() = BottomAppBarDefaults.windowInsets

    /** [BottomAppBar] 的 [FloatingActionButton] 的颜色。 */
    val 底部应用栏悬浮颜色: Color
        @Composable get() = BottomAppBarDefaults.bottomAppBarFabColor

    /** 用于 [FlexibleBottomAppBar] 的默认内边距。 */
    @ExperimentalMaterial3ExpressiveApi
    val 折叠内容内边距 = BottomAppBarDefaults.FlexibleContentPadding

    /** 柔性 [FlexibleBottomAppBar] 的默认高度。此高度表示底部应用栏在展开状态下的高度。*/
    @ExperimentalMaterial3ExpressiveApi
    val 折叠底部应用栏高度 = BottomAppBarDefaults.FlexibleBottomAppBarHeight

    /** 用于排列 [FlexibleBottomAppBar] 内容的默认 [Arrangement]。 */
    @ExperimentalMaterial3ExpressiveApi
    val 折叠水平排列: Arrangement.Horizontal = BottomAppBarDefaults.FlexibleHorizontalArrangement

    /** 用于以固定间距排列 [FlexibleBottomAppBar] 内容的 [Arrangement]。*/
    @ExperimentalMaterial3ExpressiveApi
    val 折叠固定间距水平排列: Arrangement.Horizontal =
        BottomAppBarDefaults.FlexibleFixedHorizontalArrangement

    // TODO: 请注意，此滚动行为可能会影响辅助技术，导致该组件无法访问。有关如何在启用触摸探索时禁用滚动的示例，
    //  请参阅 @sample androidx.compose.material3.samples.ExitAlwaysBottomAppBar。
    /**
     * 返回一个 [BottomAppBarScrollBehavior]。使用此 [BottomAppBarScrollBehavior] 配置的底部应用栏将在内容向上
     * 拉动时立即收起，并在内容向下拉动时立即出现。
     *
     * 返回的 [BottomAppBarScrollBehavior] 会在重组过程中被记忆（remember）保存。
     *
     * @param 状态 用于控制或观察底部应用栏滚动状态的状态对象。如需一个在重组过程中被记忆保存的状态，请参阅 [rememberBottomAppBarState]。
     * @param 可以滚动 用于确定滚动事件是否由该 [ExitAlwaysScrollBehavior] 处理的回调。
     * @param 吸附动画规格 一个可选的 [AnimationSpec]，用于定义当底部应用栏被快速滑动或拖拽滚动到中间位置时，
     * 如何吸附到完全收起或完全展开的状态。
     * @param 抛掷动画规格 一个可选的 [DecayAnimationSpec]，用于定义当用户快速滑动应用栏本身或其下方内容时，
     * 如何使底部应用栏产生惯性滑动效果。
     */
    @ExperimentalMaterial3Api
    @Composable
    fun 退出始终滚动行为(
        状态: BottomAppBarState = rememberBottomAppBarState(),
        可以滚动: () -> Boolean = { true },
        吸附动画规格: AnimationSpec<Float>? = MaterialTheme.motionScheme.fastSpatialSpec(),
        抛掷动画规格: DecayAnimationSpec<Float>? = rememberSplineBasedDecay(),
    ): BottomAppBarScrollBehavior =
        BottomAppBarDefaults.exitAlwaysScrollBehavior(
            state = 状态,
            canScroll = 可以滚动,
            snapAnimationSpec = 吸附动画规格,
            flingAnimationSpec = 抛掷动画规格,
        )

}


/**
 * 创建一个在重组过程中被记忆保存的 [BottomAppBarState]。
 *
 * @param 初始高度偏移量限制 [BottomAppBarState.heightOffsetLimit] 的初始值，表示当可滚动内容发生滚动时，
 * 底部应用栏允许收起的高度偏移像素限制。
 * @param 初始高度偏移量 [BottomAppBarState.heightOffset] 的初始值。初始高度偏移应介于 0 与 [初始高度偏移量限制] 之间。
 * @param 初始内容偏移 [BottomAppBarState.contentOffset] 的初始值。
 */
@ExperimentalMaterial3Api
@Composable
fun 记住底部应用栏状态(
    初始高度偏移量限制: Float = -Float.MAX_VALUE,
    初始高度偏移量: Float = 0f,
    初始内容偏移: Float = 0f,
): BottomAppBarState =
    rememberBottomAppBarState(
        initialHeightOffsetLimit = 初始高度偏移量限制,
        initialHeightOffset = 初始高度偏移量,
        initialContentOffset = 初始内容偏移
    )

/**
 * 一个可被提升的状态对象，用于控制和观察底部应用栏的状态。该状态由 [BottomAppBarScrollBehavior] 实现来读取和更新。
 *
 * 在大多数情况下，此状态将通过 [rememberBottomAppBarState] 创建。
 */
@ExperimentalMaterial3Api
interface 底部应用栏状态 { // BottomAppBarState

    /**
     * 底部应用栏的高度偏移限制（以像素为单位），表示底部应用栏允许收起到的极限位置。
     *
     * 使用此限制来约束 [高度偏移量] 更新时的取值。
     */
    var 高度偏移量限制: Float // heightOffsetLimit

    /**
     * 底部应用栏当前的高度偏移（以像素为单位）。此高度偏移应用于应用栏的固定高度，以在内容滚动时控制其显示高度。
     *
     * 对 [高度偏移量] 值的更新被限制在 0 与 [高度偏移量限制] 之间。
     */
    var 高度偏移量: Float // heightOffset

    /**
     * 在底部应用栏下方滚动的内容的总偏移量。
     *
     * 此值由 [BottomAppBarScrollBehavior] 在嵌套滚动连接消费滚动事件时更新。常见的实现方式是将该值更新为所有
     * [NestedScrollConnection.onPostScroll] 中 consumed.y 值的总和。
     */
    var 内容偏移量: Float // contentOffset

    /**
     * 表示应用栏收起高度百分比的值。
     *
     * `0.0` 表示完全展开的应用栏，`1.0` 表示完全收起的应用栏（计算方式为 [高度偏移量] / [高度偏移量限制]）。
     */
    val 折叠比例: Float // collapsedFraction

    companion object {

        /** [BottomAppBarState] 的默认保存器实现。 */
        val 保存器: Saver<BottomAppBarState, *> = BottomAppBarState.Saver

    }

}

//======================================================================

/**
 * 底部应用栏的高度偏移限制（以像素为单位），表示底部应用栏允许收起到的极限位置。
 *
 * 使用此限制来约束 [高度偏移量] 更新时的取值。
 */
@ExperimentalMaterial3Api
var BottomAppBarState.高度偏移量限制: Float
    get() = this.heightOffsetLimit
    set(newLimit) {
        this.heightOffsetLimit = newLimit
    }

/**
 * 底部应用栏当前的高度偏移（以像素为单位）。此高度偏移应用于应用栏的固定高度，以在内容滚动时控制其显示高度。
 *
 * 对 [高度偏移量] 值的更新被限制在 0 与 [高度偏移量限制] 之间。
 */
@ExperimentalMaterial3Api
var BottomAppBarState.高度偏移量: Float
    get() = this.heightOffset
    set(newOffset) {
        this.heightOffset = newOffset
    }

/**
 * 在底部应用栏下方滚动的内容的总偏移量。
 *
 * 此值由 [BottomAppBarScrollBehavior] 在嵌套滚动连接消费滚动事件时更新。常见的实现方式是将该值更新为所有
 * [NestedScrollConnection.onPostScroll] 中 consumed.y 值的总和。
 */
@ExperimentalMaterial3Api
var BottomAppBarState.内容偏移量: Float
    get() = this.contentOffset
    set(newOffset) {
        this.contentOffset = newOffset
    }

/**
 * 表示应用栏收起高度百分比的值。
 *
 * `0.0` 表示完全展开的应用栏，`1.0` 表示完全收起的应用栏（计算方式为 [高度偏移量] / [高度偏移量限制]）。
 */
@ExperimentalMaterial3Api
val BottomAppBarState.折叠比例: Float
    get() = this.collapsedFraction

//======================================================================

/**
 * 创建一个 [BottomAppBarState]。
 *
 * @param 初始高度偏移量限制 [BottomAppBarState.heightOffsetLimit] 的初始值，它表示当可滚动内容发生滚动时，
 * 底部应用栏允许折叠的像素上限。
 * @param 初始高度偏移量 [BottomAppBarState.heightOffset] 的初始值。初始高度偏移量应介于 0 和 [初始高度偏移量限制] 之间。
 * @param 初始内容偏移量 [BottomAppBarState.contentOffset] 的初始值。
 */
@ExperimentalMaterial3Api
fun 底部应用栏状态(
    初始高度偏移量限制: Float,
    初始高度偏移量: Float,
    初始内容偏移量: Float,
): BottomAppBarState =
    BottomAppBarState(
        initialHeightOffsetLimit = 初始高度偏移量限制,
        initialHeightOffset = 初始高度偏移量,
        initialContentOffset = 初始内容偏移量
    )


/** 包含当前选中的 [SingleRowTopAppBarOverride] 的 CompositionLocal。 */
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ComponentOverrideApi
val 本地单行顶部应用栏覆盖: ProvidableCompositionLocal<SingleRowTopAppBarOverride> =
    LocalSingleRowTopAppBarOverride


/** 包含当前选中的 [TwoRowsTopAppBarOverride] 的 CompositionLocal。 */
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ComponentOverrideApi
val 本地双行顶部应用栏覆盖: ProvidableCompositionLocal<TwoRowsTopAppBarOverride> =
    LocalTwoRowsTopAppBarOverride


