package 安卓x.组合.材质3

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CancellationException


/** [DrawerState] 的可能值。 */
object 抽屉值 { // DrawerValue

    /** 抽屉关闭时的状态。 */
    val 关闭 = DrawerValue.Closed

    /** 抽屉打开时的状态。 */
    val 打开 = DrawerValue.Open

}

/**
 * [ModalNavigationDrawer] 和 [DismissibleNavigationDrawer] 可组合项的状态。
 *
 * @param 初始值 初始状态值。
 * @param 确认状态改变 可选的回调函数，用于确认或取消待处理的状态更改。
 */
@Stable
fun 抽屉状态(
    初始值: DrawerValue,
    确认状态改变: (DrawerValue) -> Boolean = { true },
) =
    DrawerState(
        initialValue = 初始值,
        confirmStateChange = 确认状态改变,
    )

//==============================================================================

/** 抽屉是否开着。 */
val DrawerState.是否打开: Boolean
    get() = this.isOpen

/** 抽屉是否关上了。 */
val DrawerState.是否关闭: Boolean
    get() = this.isClosed

/**
 * 当前状态的值。
 *
 * 如果当前没有进行中的滑动或动画，这对应于抽屉当前所处的状态。如果滑动或动画正在进行中，这对应于滑动或动画开始之前抽屉所处的状态。
 */
val DrawerState.当前值: DrawerValue
    get() = this.currentValue

/** 这个状态是否正在动画化。 */
val DrawerState.是否动画在运行: Boolean
    get() = this.isAnimationRunning

/**
 * 用动画打开抽屉，并挂起直到它完全打开或动画被取消。如果动画被打断，这个方法会抛出 [CancellationException]
 *
 * @return 开启动画结束的原因
 */
suspend fun DrawerState.打开() = this.open()

/**
 * 用动画打开抽屉，并挂起直到它完全打开或动画被取消。如果动画被打断，这个方法会抛出 [CancellationException]
 *
 * @return 关闭动画结束的原因
 */
suspend fun DrawerState.关闭() = this.close()

/**
 * 用特定动画设置抽屉的状态
 *
 * @param 目标值 要动画到的新值。
 * @param 动画 将用来动画到新值的动画效果。
 */
@Deprecated(
    message =
        "This method has been replaced by the open and close methods. The animation " +
                "spec is now an implementation detail of ModalDrawer."
)
suspend fun DrawerState.动画到(目标值: DrawerValue, 动画: AnimationSpec<Float>) =
    this.animateTo(targetValue = 目标值, anim = 动画)


/**
 * 在不使用任何动画的情况下设置状态，并暂停直到设置完成。
 *
 * @param 目标值 要设置的新值。
 */
suspend fun DrawerState.吸附到(目标值: DrawerValue) =
    this.snapTo(targetValue = 目标值)


/**
 * 抽屉状态的目标值。
 *
 * 如果滑动正在进行中，这是滑动结束时抽屉将要动画过渡到的值。如果动画正在运行中，这是该动画的目标值。最后，
 * 如果没有进行中的滑动或动画，则与 [目标值] 相同。
 */
val DrawerState.目标值: DrawerValue
    get() = this.targetValue

/**
 * 抽屉面板当前的位置（以像素为单位），在偏移量初始化之前为 Float.NaN。
 *
 * @see [AnchoredDraggableState.offset] 了解更多信息。
 */
@Deprecated(
    message =
        "Please access the offset through currentOffset, which returns the value " +
                "directly instead of wrapping it in a state object.",
    replaceWith = ReplaceWith("currentOffset"),
)
val DrawerState.偏移量: State<Float>
    get() = this.offset

/**
 * 抽屉面板当前的位置（以像素为单位），在偏移量初始化之前为 Float.NaN。
 *
 * @see [AnchoredDraggableState.offset] 了解更多信息。
 */
val DrawerState.当前偏移量: Float
    get() = this.currentOffset

//==============================================================================

object 抽屉状态 {

    /** [DrawerState] 的默认 [保存器] 实现。 */
    fun 保存器(确认状态改变: (DrawerValue) -> Boolean) =
        DrawerState.Saver(confirmStateChange = 确认状态改变)

}

//==============================================================================

/**
 * 创建并[remember]一个[DrawerState]。
 *
 * @param 初始值 状态的初始值。
 * @param 确认状态改变 可选回调用于确认或否决待处理的状态变化。
 */
@Composable
fun 记住抽屉状态(
    初始值: DrawerValue,
    确认状态改变: (DrawerValue) -> Boolean = { true },
): DrawerState =
    rememberDrawerState(
        initialValue = 初始值,
        confirmStateChange = 确认状态改变,
    )


/**
 * [Material Design navigation drawer](https://m3.material.io/components/navigation-drawer/overview)
 *
 * 导航抽屉让你更轻松地访问应用里的各个目的地。
 *
 * 模态导航抽屉会用遮罩阻止与应用其余内容的交互。它们高于大部分应用的 UI，并且不会影响屏幕的布局网格。
 *
 * ![Navigation drawer image](https://developer.android.com/images/reference/androidx/compose/material3/navigation-drawer.png)
 *
 * @param 抽屉内容 这个抽屉里的东西。
 * @param 修饰符 应用于该抽屉的 [Modifier]。
 * @param 抽屉状态 抽屉的状态
 * @param 手势已启用 抽屉是否可以通过手势进行交互。
 * @param 遮罩颜色 抽屉打开时遮挡内容的遮罩颜色。
 * @param 内容 用户界面其余部分的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 模态导航抽屉(
    抽屉内容: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    抽屉状态: DrawerState = rememberDrawerState(DrawerValue.Closed),
    手势已启用: Boolean = true,
    遮罩颜色: Color = DrawerDefaults.scrimColor,
    内容: @Composable () -> Unit,
) =
    ModalNavigationDrawer(
        drawerContent = 抽屉内容,
        modifier = 修饰符,
        drawerState = 抽屉状态,
        gesturesEnabled = 手势已启用,
        scrimColor = 遮罩颜色,
        content = 内容,
    )


/**
 * [Material Design navigation drawer](https://m3.material.io/components/navigation-drawer/overview)
 *
 * 导航抽屉为应用中的目的地提供了符合人体工程学的访问方式。它们通常位于应用内容旁边，并影响屏幕的布局网格。
 *
 * ![Navigation drawer image](https://developer.android.com/images/reference/androidx/compose/material3/navigation-drawer.png)
 *
 * 可关闭的标准抽屉适用于以内容为优先的布局（例如照片画廊），或者用户不太可能频繁切换目的地的应用。它们应使用可见的导航菜单图标来打开和关闭抽屉。
 *
 * @param 抽屉内容 该抽屉内部的内容
 * @param 修饰符 应用于该抽屉的 [Modifier]。
 * @param 抽屉状态 抽屉的状态
 * @param 手势已启用 抽屉是否可以通过手势进行交互。
 * @param 内容 用户界面其余部分的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 可关闭导航抽屉(
    抽屉内容: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    抽屉状态: DrawerState = rememberDrawerState(DrawerValue.Closed),
    手势已启用: Boolean = true,
    内容: @Composable () -> Unit,
) =
    DismissibleNavigationDrawer(
        drawerContent = 抽屉内容,
        modifier = 修饰符,
        drawerState = 抽屉状态,
        gesturesEnabled = 手势已启用,
        content = 内容,
    )


/**
 * [Material Design navigation permanent drawer](https://m3.material.io/components/navigation-drawer/overview)
 *
 * 导航抽屉为应用中的目的地提供了符合人体工程学的访问方式。它们通常位于应用内容旁边，并影响屏幕的布局网格。
 *
 * ![Navigation drawer image](https://developer.android.com/images/reference/androidx/compose/material3/navigation-drawer.png)
 *
 * 永久性导航抽屉始终可见，通常用于频繁切换目的地。在移动设备屏幕上，请改用 [ModalNavigationDrawer]。
 *
 * @param 抽屉内容 该抽屉内部的内容。
 * @param 修饰符 应用于该抽屉的 [Modifier]。
 * @param 内容 用户界面其余部分的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 永久导航抽屉(
    抽屉内容: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    内容: @Composable () -> Unit,
) =
    PermanentNavigationDrawer(
        drawerContent = 抽屉内容,
        modifier = 修饰符,
        content = 内容,
    )


/**
 * 模态导航抽屉内部的内容。
 *
 * 此版本的 [ModalDrawerSheet] 默认不处理返回操作。如需在 Android 14+ 上实现自动返回处理和预测性返回动画，请使用接受
 * `drawerState` 作为参数的 [ModalDrawerSheet]。
 *
 * @param 修饰符 应用于该抽屉内容的 [Modifier]。
 * @param 抽屉形状 定义该抽屉容器的形状。
 * @param 抽屉容器颜色 用于该抽屉背景的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 抽屉内容颜色 该抽屉内部内容的首选颜色。默认为 [抽屉容器颜色] 对应的匹配内容颜色，
 * 或者如果 [抽屉容器颜色] 不是来自主题的颜色，则使用当前的 [LocalContentColor]。
 * @param 抽屉色调阴影 当 [抽屉容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主色调。
 * 较高的色调高度值在浅色主题下会产生更深的颜色，在深色主题下会产生更浅的颜色。另请参阅：[Surface]。
 * @param 窗口插入 面板的窗口内边距。
 * @param 内容 模态导航抽屉内部的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 模态抽屉面板(
    修饰符: Modifier = Modifier,
    抽屉形状: Shape = DrawerDefaults.shape,
    抽屉容器颜色: Color = DrawerDefaults.modalContainerColor,
    抽屉内容颜色: Color = contentColorFor(抽屉容器颜色),
    抽屉色调阴影: Dp = DrawerDefaults.ModalDrawerElevation,
    窗口插入: WindowInsets = DrawerDefaults.windowInsets,
    内容: @Composable ColumnScope.() -> Unit,
) =
    ModalDrawerSheet(
        modifier = 修饰符,
        drawerShape = 抽屉形状,
        drawerContainerColor = 抽屉容器颜色,
        drawerContentColor = 抽屉内容颜色,
        drawerTonalElevation = 抽屉色调阴影,
        windowInsets = 窗口插入,
        content = 内容,
    )


/**
 * 模态导航抽屉内部的内容。
 *
 * 此版本的 [ModalDrawerSheet] 需要提供 [抽屉状态]，默认会在所有 Android 版本上处理返回操作，并在 Android 14+
 * 的预测性返回期间播放动画。
 *
 * @param 抽屉状态 抽屉的状态
 * @param 修饰符 应用于该抽屉内容的 [Modifier]。
 * @param 抽屉形状 定义该抽屉容器的形状。
 * @param 抽屉容器颜色 用于该抽屉背景的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 抽屉内容颜色 该抽屉内部内容的首选颜色。默认为 [抽屉容器颜色] 对应的匹配内容颜色，
 * 或者如果 [抽屉容器颜色] 不是来自主题的颜色，则使用当前的 [LocalContentColor]。
 * @param 抽屉色调阴影 当 [抽屉容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主色调。
 * 较高的色调高度值在浅色主题下会产生更深的颜色，在深色主题下会产生更浅的颜色。另请参阅：[Surface]。
 * @param 窗口插入 面板的窗口内边距。
 * @param 内容 模态导航抽屉内部的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 模态抽屉面板(
    抽屉状态: DrawerState,
    修饰符: Modifier = Modifier,
    抽屉形状: Shape = DrawerDefaults.shape,
    抽屉容器颜色: Color = DrawerDefaults.modalContainerColor,
    抽屉内容颜色: Color = contentColorFor(抽屉容器颜色),
    抽屉色调阴影: Dp = DrawerDefaults.ModalDrawerElevation,
    窗口插入: WindowInsets = DrawerDefaults.windowInsets,
    内容: @Composable ColumnScope.() -> Unit,
) =
    ModalDrawerSheet(
        drawerState = 抽屉状态,
        modifier = 修饰符,
        drawerShape = 抽屉形状,
        drawerContainerColor = 抽屉容器颜色,
        drawerContentColor = 抽屉内容颜色,
        drawerTonalElevation = 抽屉色调阴影,
        windowInsets = 窗口插入,
        content = 内容,
    )



/**
 * 可关闭导航抽屉内部的内容。
 *
 * 此版本的 [DismissibleDrawerSheet] 默认不处理返回操作。如需在 Android 14+ 上实现自动返回处理和预测性返回动画，
 * 请使用接受 `drawerState` 作为参数的 [DismissibleDrawerSheet]。
 *
 * @param 修饰符 应用于该抽屉内容的 [Modifier]。
 * @param 抽屉形状 定义该抽屉容器的形状。
 * @param 抽屉容器颜色 用于该抽屉背景的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 抽屉内容颜色 该抽屉内部内容的首选颜色。默认为 [抽屉容器颜色] 对应的匹配内容颜色，或者如果
 * [抽屉容器颜色] 不是来自主题的颜色，则使用当前的 [LocalContentColor]。
 * @param 抽屉色调阴影 当 [抽屉容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主色调。
 * 较高的色调高度值在浅色主题下会产生更深的颜色，在深色主题下会产生更浅的颜色。另请参阅：[Surface]。
 * @param 窗口插入 面板的窗口内边距。
 * @param 内容 可关闭导航抽屉内部的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 可关闭抽屉面板(
    修饰符: Modifier = Modifier,
    抽屉形状: Shape = RectangleShape,
    抽屉容器颜色: Color = DrawerDefaults.standardContainerColor,
    抽屉内容颜色: Color = contentColorFor(抽屉容器颜色),
    抽屉色调阴影: Dp = DrawerDefaults.DismissibleDrawerElevation,
    窗口插入: WindowInsets = DrawerDefaults.windowInsets,
    内容: @Composable ColumnScope.() -> Unit,
) =
    DismissibleDrawerSheet(
        modifier = 修饰符,
        drawerShape = 抽屉形状,
        drawerContainerColor = 抽屉容器颜色,
        drawerContentColor = 抽屉内容颜色,
        drawerTonalElevation = 抽屉色调阴影,
        windowInsets = 窗口插入,
        content = 内容,
    )


/**
 * 可关闭导航抽屉内部的内容。
 *
 * 此版本的 [DismissibleDrawerSheet] 需要提供 [抽屉状态]，默认会在所有 Android 版本上处理返回操作，并在 Android 14+
 * 的预测性返回期间播放动画。
 *
 * @param 抽屉状态 抽屉的状态。
 * @param 修饰符 应用于该抽屉内容的 [Modifier]。
 * @param 抽屉形状 定义该抽屉容器的形状。
 * @param 抽屉容器颜色 用于该抽屉背景的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 抽屉内容颜色 该抽屉内部内容的首选颜色。默认为 [抽屉容器颜色] 对应的匹配内容颜色，或者如果 [抽屉容器颜色]
 * 不是来自主题的颜色，则使用当前的 [LocalContentColor]。
 * @param 抽屉色调阴影 当 [抽屉容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主色调。
 * 较高的色调高度值在浅色主题下会产生更深的颜色，在深色主题下会产生更浅的颜色。另请参阅：[Surface]。
 * @param 窗口插入 面板的窗口内边距。
 * @param 内容 可关闭导航抽屉内部的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 可关闭抽屉面板(
    抽屉状态: DrawerState,
    修饰符: Modifier = Modifier,
    抽屉形状: Shape = RectangleShape,
    抽屉容器颜色: Color = DrawerDefaults.standardContainerColor,
    抽屉内容颜色: Color = contentColorFor(抽屉容器颜色),
    抽屉色调阴影: Dp = DrawerDefaults.DismissibleDrawerElevation,
    窗口插入: WindowInsets = DrawerDefaults.windowInsets,
    内容: @Composable ColumnScope.() -> Unit,
) =
    DismissibleDrawerSheet(
        drawerState = 抽屉状态,
        modifier = 修饰符,
        drawerShape = 抽屉形状,
        drawerContainerColor = 抽屉容器颜色,
        drawerContentColor = 抽屉内容颜色,
        drawerTonalElevation = 抽屉色调阴影,
        windowInsets = 窗口插入,
        content = 内容,
    )


/**
 * 永久性导航抽屉内部的内容。
 *
 * @param 修饰符 应用于该抽屉内容的 [Modifier]。
 * @param 抽屉形状 定义该抽屉容器的形状。
 * @param 抽屉容器颜色 用于该抽屉背景的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 抽屉内容颜色 该抽屉内部内容的首选颜色。默认为 [抽屉容器颜色] 对应的匹配内容颜色，或者如果 [抽屉容器颜色]
 * 不是来自主题的颜色，则使用当前的 [LocalContentColor]。
 * @param 抽屉色调阴影 当 [抽屉容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主色调。
 * 较高的色调高度值在浅色主题下会产生更深的颜色，在深色主题下会产生更浅的颜色。另请参阅：[Surface]。
 * @param 窗口插入 面板的窗口内边距。
 * @param 内容 永久性导航抽屉内部的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 永久抽屉面板(
    修饰符: Modifier = Modifier,
    抽屉形状: Shape = RectangleShape,
    抽屉容器颜色: Color = DrawerDefaults.standardContainerColor,
    抽屉内容颜色: Color = contentColorFor(抽屉容器颜色),
    抽屉色调阴影: Dp = DrawerDefaults.PermanentDrawerElevation,
    窗口插入: WindowInsets = DrawerDefaults.windowInsets,
    内容: @Composable ColumnScope.() -> Unit,
) =
    PermanentDrawerSheet(
        modifier = 修饰符,
        drawerShape = 抽屉形状,
        drawerContainerColor = 抽屉容器颜色,
        drawerContentColor = 抽屉内容颜色,
        drawerTonalElevation = 抽屉色调阴影,
        windowInsets = 窗口插入,
        content = 内容,
    )



/** 用于保存 [ModalNavigationDrawer] 默认值的对象。*/
object 抽屉默认值 { // DrawerDefaults

    /**  [ModalNavigationDrawer] 中抽屉容器的默认高度。 */
    val 模态抽屉阴影 = DrawerDefaults.ModalDrawerElevation

    /**  [PermanentNavigationDrawer] 中抽屉容器的默认高度。 */
    val 永久抽屉阴影 = DrawerDefaults.PermanentDrawerElevation

    /**  [DismissibleNavigationDrawer] 中抽屉容器的默认高度。 */
    val 可关闭抽屉阴影 = DrawerDefaults.DismissibleDrawerElevation

    /**  导航抽屉的默认形状。 */
    val 形状: Shape
        @Composable get() = DrawerDefaults.shape

    /**  抽屉打开时遮挡内容的遮罩默认颜色。 */
    val 遮罩颜色: Color
        @Composable get() = DrawerDefaults.scrimColor

    /**  导航抽屉的默认容器颜色。 */
    @Deprecated(
        message = "Please use standardContainerColor or modalContainerColor instead.",
        replaceWith = ReplaceWith("standardContainerColor"),
        level = DeprecationLevel.WARNING,
    )
    val 容器颜色: Color
        @Composable get() = DrawerDefaults.containerColor

    /** [DismissibleNavigationDrawer] 和 [PermanentNavigationDrawer] 的默认容器颜色。*/
    val 标准容器颜色: Color
        @Composable get() = DrawerDefaults.standardContainerColor

    /**  [ModalNavigationDrawer] 的默认容器颜色。 */
    val 模态容器颜色: Color
        @Composable get() = DrawerDefaults.modalContainerColor

    /**  导航抽屉的默认和最大宽度。 */
    val 最大抽屉宽度 = DrawerDefaults.MaximumDrawerWidth

    /**  抽屉面板的默认窗口内边距。 */
    val 窗口插入: WindowInsets
        @Composable
        get() = DrawerDefaults.windowInsets

}


/**
 * Material Design 导航抽屉项。
 *
 * [NavigationDrawerItem] 表示抽屉中的一个目的地，可以是 [ModalNavigationDrawer]、[PermanentNavigationDrawer]
 * 或 [DismissibleNavigationDrawer] 中的任意一种。
 *
 * @param 标签 此项目的文本标签。
 * @param 已选择 是否选中。
 * @param 单击回调 当此项目被点击时调用。
 * @param 修饰符 应用于该项目的 [Modifier]。
 * @param 图标 此项目的可选图标，通常为 [Icon]。
 * @param 徽章 可选的徽标，显示在此项目的末端一侧。
 * @param 形状 活动指示器的可选形状。
 * @param 颜色集 [NavigationDrawerItemColors]，用于解析该项目在不同状态下使用的颜色。请参阅 [NavigationDrawerItemDefaults.colors]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此项目的 [Interaction]。
 * 您可以使用它来更改项目的外观或在不同状态下预览项目。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 导航抽屉项(
    标签: @Composable () -> Unit,
    已选择: Boolean,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    图标: (@Composable () -> Unit)? = null,
    徽章: (@Composable () -> Unit)? = null,
    形状: Shape = RoundedCornerShape(50),
    颜色集: NavigationDrawerItemColors = NavigationDrawerItemDefaults.colors(),
    交互源: MutableInteractionSource? = null,
) =
    NavigationDrawerItem(
        label = 标签,
        selected = 已选择,
        onClick = 单击回调,
        modifier = 修饰符,
        icon = 图标,
        badge = 徽章,
        shape = 形状,
        colors = 颜色集,
        interactionSource = 交互源,
    )


/** 表示抽屉项各元素的颜色。 */
@Stable
interface 导航抽屉项颜色集 { // NavigationDrawerItemColors
    /**
     * 表示此项目的图标颜色，取决于它是否被 [已选择]。
     *
     * @param 已选择 该项目是否被选中。
     */
    @Composable fun 图标颜色(已选择: Boolean): State<Color>

    /**
     * 表示此项目的文本颜色，取决于它是否被 [已选择]。
     *
     * @param 已选择 该项目是否被选中。
     */
    @Composable fun 文本颜色(已选择: Boolean): State<Color>

    /**
     *  表示此项目的徽标颜色，取决于它是否被 [已选择]。
     *
     * @param 已选择 该项目是否被选中。
     */
    @Composable fun 徽章颜色(已选择: Boolean): State<Color>

    /**
     * 表示此项目的容器颜色，取决于它是否被 [已选择]。
     *
     * @param 已选择 该项目是否被选中。
     */
    @Composable fun 容器颜色(已选择: Boolean): State<Color>
}

//=======================================================================

/**
 * 表示此项目的图标颜色，取决于它是否被 [已选择]。
 *
 * @param 已选择 该项目是否被选中。
 */
@Composable
fun NavigationDrawerItemColors.图标颜色(已选择: Boolean): State<Color> =
    this.iconColor(已选择)

/**
 * 表示此项目的文本颜色，取决于它是否被 [已选择]。
 *
 * @param 已选择 该项目是否被选中。
 */
@Composable
fun NavigationDrawerItemColors.文本颜色(已选择: Boolean): State<Color> =
    this.textColor(已选择)

/**
 *  表示此项目的徽标颜色，取决于它是否被 [已选择]。
 *
 * @param 已选择 该项目是否被选中。
 */
@Composable
fun NavigationDrawerItemColors.徽章颜色(已选择: Boolean): State<Color> =
    this.badgeColor(已选择)

/**
 * 表示此项目的容器颜色，取决于它是否被 [已选择]。
 *
 * @param 已选择 该项目是否被选中。
 */
@Composable
fun NavigationDrawerItemColors.容器颜色(已选择: Boolean): State<Color> =
    this.containerColor(已选择)

//=======================================================================

/** [NavigationDrawerItem] 中使用的默认值。 */
object 导航抽屉项默认值 { // NavigationDrawerItemDefaults

    /**
     * 根据 Material 规范，使用提供的颜色创建 [NavigationDrawerItemColors]。
     *
     * @param 已选择容器颜色 项目被选中时背景使用的颜色。
     * @param 未已选择容器颜色 项目未被选中时背景使用的颜色。
     * @param 已选择图标颜色 项目被选中时图标使用的颜色。
     * @param 未已选择图标颜色 项目未被选中时图标使用的颜色。
     * @param 已选择文本颜色 项目被选中时文本标签使用的颜色。
     * @param 未已选择文本颜色 项目未被选中时文本标签使用的颜色。
     * @param 已选择徽章颜色 项目被选中时徽标使用的颜色。
     * @param 未已选择徽章颜色 项目未被选中时徽标使用的颜色。
     * @return  用于 [NavigationDrawerItem] 的生成的 [NavigationDrawerItemColors]。
     */
    @Composable
    fun 颜色集(
        已选择容器颜色: Color = MaterialTheme.colorScheme.secondaryContainer,
        未已选择容器颜色: Color = Color.Transparent,
        已选择图标颜色: Color = MaterialTheme.colorScheme.onSecondaryContainer,
        未已选择图标颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        已选择文本颜色: Color = MaterialTheme.colorScheme.onSecondaryContainer,
        未已选择文本颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        已选择徽章颜色: Color = 已选择文本颜色,
        未已选择徽章颜色: Color = 未已选择文本颜色,
    ): NavigationDrawerItemColors =
        NavigationDrawerItemDefaults.colors(
            selectedContainerColor = 已选择容器颜色,
            unselectedContainerColor = 未已选择容器颜色,
            selectedIconColor = 已选择图标颜色,
            unselectedIconColor = 未已选择图标颜色,
            selectedTextColor = 已选择文本颜色,
            unselectedTextColor = 未已选择文本颜色,
            selectedBadgeColor = 已选择徽章颜色,
            unselectedBadgeColor = 未已选择徽章颜色,
        )

    /** 根据 Material 规范，[NavigationDrawerItem] 的默认外部内边距。*/
    val 项内边距 = NavigationDrawerItemDefaults.ItemPadding

}


