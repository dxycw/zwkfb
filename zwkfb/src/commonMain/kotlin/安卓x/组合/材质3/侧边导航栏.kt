package 安卓x.组合.材质3

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.DefaultNavigationRailOverride.NavigationRail
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


/**
 * [Material Design bottom navigation rail](https://m3.material.io/components/navigation-rail/overview)
 *
 * 导航栏在平板和桌面屏幕上为应用提供对主要目标位置的访问。
 *
 * ![Navigation rail image](https://developer.android.com/images/reference/androidx/compose/material3/navigation-rail.png)
 *
 * 导航栏应用于显示三至七个应用目标位置，并可选择性地显示一个 [FloatingActionButton] 或徽标标题。每个目标位置通常由一个
 * 图标和一个可选的文本标签表示。
 *
 * [NavigationRail] 应包含多个 [NavigationRailItem]，每个条目代表一个独立的目标位置。
 *
 * 有关每个条目的具体配置，请参阅 [NavigationRailItem]，而非整体的 NavigationRail 组件。
 *
 * @param 修饰符 要应用于此导航栏的 [Modifier]。
 * @param 容器颜色 此导航栏背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此导航栏内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容颜色，或者当 [容器颜色]不是主题中的颜色时，
 * 默认为当前的 [LocalContentColor]。
 * @param 头部 可选的头部区域，可用于放置 [FloatingActionButton] 或徽标（logo）
 * @param 窗口插入 导航栏的窗口嵌入
 * @param 内容 此导航轨道（Navigation Rail）的内容，通常包含 3 到 7 个 [NavigationRailItem]。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3ComponentOverrideApi::class)
@Composable
fun 侧边导航栏(
    修饰符: Modifier = Modifier,
    容器颜色: Color = NavigationRailDefaults.ContainerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    头部: @Composable (ColumnScope.() -> Unit)? = null,
    窗口插入: WindowInsets = NavigationRailDefaults.windowInsets,
    内容: @Composable ColumnScope.() -> Unit,
) =
    NavigationRail(
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        header = 头部,
        windowInsets = 窗口插入,
        content = 内容,
    )


/**
 * Material Design 导航轨道项（Navigation Rail Item）
 *
 * [NavigationRailItem] 表示 [NavigationRail] 中的一个目的地。
 *
 * 导航轨道（Navigation Rails）在平板和桌面设备屏幕上为应用提供对主要目的地的访问。
 *
 * 文本标签在选中时始终显示（如果存在）。未选中时是否显示文本标签由 [始终显示标签] 控制。
 *
 * @param 已选择 此条目是否被选中
 * @param 单击回调 此条目被点击时调用
 * @param 图标 此条目的图标，通常为 [Icon]
 * @param 修饰符 要应用于此条目的 [Modifier]
 * @param 已启用 控制此条目的启用状态。当为 `false` 时，该组件不会响应用户输入，并且在视觉上显示为禁用状态，
 * 同时对无障碍服务也呈现为禁用状态。
 * @param 标签 此条目的可选文本标签
 * @param 始终显示标签 是否始终显示此条目的标签。如果为 false，则仅当此条目被选中时才显示标签。
 * @param 颜色集 [NavigationRailItemColors]，用于解析此条目在不同状态下所使用的颜色。参见 [NavigationRailItemDefaults.colors]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发送此条目的 [Interaction]。
 * 你可以使用它来更改条目的外观或在不同状态下预览条目。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 侧边导航栏项(
    已选择: Boolean,
    单击回调: () -> Unit,
    图标: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    标签: @Composable (() -> Unit)? = null,
    始终显示标签: Boolean = true,
    颜色集: NavigationRailItemColors = NavigationRailItemDefaults.colors(),
    交互源: MutableInteractionSource? = null,
) =
    NavigationRailItem(
        selected = 已选择,
        onClick = 单击回调,
        icon = 图标,
        modifier = 修饰符,
        enabled = 已启用,
        label = 标签,
        alwaysShowLabel = 始终显示标签,
        colors = 颜色集,
        interactionSource = 交互源,
    )


/** [NavigationRail] 中使用的默认值 */
object 侧边导航栏默认值 { // NavigationRailDefaults

    /** 导航轨道的默认容器颜色。 */
    val 容器颜色: Color
        @Composable get() = NavigationRailDefaults.ContainerColor

    /** 导航轨道的默认窗口边衬（Window Insets）。 */
    val 窗口插入: WindowInsets
        @Composable
        get() = NavigationRailDefaults.windowInsets

}


/** [NavigationRailItem] 中使用的默认值. */
object 侧边导航栏项默认值 { // NavigationRailItemDefaults

    /** 根据 Material 规范，使用提供的颜色创建 [NavigationRailItemColors]。*/
    @Composable
    fun 颜色集() = NavigationRailItemDefaults.colors()

    /**
     * 根据 Material 规范，使用提供的颜色创建 [NavigationRailItemColors]。
     *
     * @param 已选择图标颜色 选中时的图标颜色。
     * @param 已选择文本颜色 选中时的文本标签颜色。
     * @param 指示器颜色 条目被选中时指示器所使用的颜色。
     * @param 未已选择图标颜色 条目未选中时图标所使用的颜色。
     * @param 为已选择文本颜色 条目未选中时文本标签所使用的颜色。
     * @param 禁用图标颜色 条目禁用时图标所使用的颜色。
     * @param 禁用文本颜色 条目禁用时文本标签所使用的颜色。
     * @return 用于 [NavigationRailItem] 的生成的 [NavigationRailItemColors]。
     */
    @Composable
    fun 颜色集(
        已选择图标颜色: Color = MaterialTheme.colorScheme.onSecondaryContainer,
        已选择文本颜色: Color = MaterialTheme.colorScheme.secondary,
        指示器颜色: Color = MaterialTheme.colorScheme.secondaryContainer,
        未已选择图标颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        为已选择文本颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        禁用图标颜色: Color = 未已选择图标颜色.copy(alpha = 0.38f),
        禁用文本颜色: Color = 为已选择文本颜色.copy(alpha = 0.38f),
    ): NavigationRailItemColors =
        NavigationRailItemDefaults.colors(
            selectedIconColor = 已选择图标颜色,
            selectedTextColor = 已选择文本颜色,
            indicatorColor = 指示器颜色,
            unselectedIconColor = 未已选择图标颜色,
            unselectedTextColor = 为已选择文本颜色,
            disabledIconColor = 禁用图标颜色,
            disabledTextColor = 禁用文本颜色,
        )

}


/**
 * 表示导航条目各元素的颜色。
 *
 * @param 已选择图标颜色 条目被选中时图标所使用的颜色。
 * @param 已选择文本颜色 条目被选中时文本标签所使用的颜色。
 * @param 已选择指示器颜色 条目被选中时指示器所使用的颜色。
 * @param 未已选择图标颜色 条目未选中时图标所使用的颜色。
 * @param 为已选择文本颜色 条目未选中时文本标签所使用的颜色。
 * @param 禁用图标颜色 条目禁用时图标所使用的颜色。
 * @param 禁用文本颜色 条目禁用时文本标签所使用的颜色。
 * @constructor  使用任意颜色创建一个实例。
 */
fun 侧边导航栏项颜色集(
    已选择图标颜色: Color,
    已选择文本颜色: Color,
    已选择指示器颜色: Color,
    未已选择图标颜色: Color,
    为已选择文本颜色: Color,
    禁用图标颜色: Color,
    禁用文本颜色: Color,
) =
    NavigationRailItemColors(
        selectedIconColor = 已选择图标颜色,
        selectedTextColor = 已选择文本颜色,
        selectedIndicatorColor = 已选择指示器颜色,
        unselectedIconColor = 未已选择图标颜色,
        unselectedTextColor = 为已选择文本颜色,
        disabledIconColor = 禁用图标颜色,
        disabledTextColor = 禁用文本颜色,
    )

/** 返回此 NavigationRailItemColors 的副本，可选择性地覆盖其中某些值。使用 Color.Unspecified 表示"使用源中的值"。*/
fun NavigationRailItemColors.复制(
    已选择图标颜色: Color = this.selectedIconColor,
    已选择文本颜色: Color = this.selectedTextColor,
    已选择指示器颜色: Color = this.selectedIndicatorColor,
    未已选择图标颜色: Color = this.unselectedIconColor,
    为已选择文本颜色: Color = this.unselectedTextColor,
    禁用图标颜色: Color = this.disabledIconColor,
    禁用文本颜色: Color = this.disabledTextColor,
) =
    this.copy(
        selectedIconColor = 已选择图标颜色,
        selectedTextColor = 已选择文本颜色,
        selectedIndicatorColor = 已选择指示器颜色,
        unselectedIconColor = 未已选择图标颜色,
        unselectedTextColor = 为已选择文本颜色,
        disabledIconColor = 禁用图标颜色,
        disabledTextColor = 禁用文本颜色,
    )



/**  包含当前选中的 [NavigationRailOverride] 的 CompositionLocal。 */
@ExperimentalMaterial3ComponentOverrideApi
val 本地侧边导航栏覆盖: ProvidableCompositionLocal<NavigationRailOverride> = LocalNavigationRailOverride

