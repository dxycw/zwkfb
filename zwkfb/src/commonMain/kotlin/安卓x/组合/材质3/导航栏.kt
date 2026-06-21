package 安卓x.组合.材质3

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.DefaultNavigationBarOverride.NavigationBar
import androidx.compose.material3.ExperimentalMaterial3ComponentOverrideApi
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalNavigationBarOverride
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationBarOverride
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp


/**
 * [Material Design bottom navigation bar](https://m3.material.io/components/navigation-bar/overview)
 *
 * 导航栏提供了一种持久且便捷的方式，用于在应用中的主要目的地之间进行切换。
 *
 * ![Navigation bar image](https://developer.android.com/images/reference/androidx/compose/material3/navigation-bar.png)
 *
 * [NavigationBar] 应包含三到五个 [NavigationBarItem]，每个代表一个独立的目的地。
 *
 * 有关每个项目的具体配置，请参阅 [NavigationBarItem]，而非整体的 [NavigationBar] 组件。
 *
 * @param 修饰符 要应用于此导航栏的 [Modifier]。
 * @param 容器颜色  此导航栏背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此导航栏内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主色调。
 * 较高的色调海拔值在浅色主题下会产生更深的颜色，在深色主题下则会产生更浅的颜色。另请参阅：[Surface]。
 * @param 窗口插入 导航栏的窗口边衬区。
 * @param 内容 此导航栏的内容，通常为 3-5 个 [NavigationBarItem]。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3ComponentOverrideApi::class)
@Composable
fun 导航栏(
    修饰符: Modifier = Modifier,
    容器颜色: Color = NavigationBarDefaults.containerColor,
    内容颜色: Color = MaterialTheme.colorScheme.contentColorFor(容器颜色),
    色调阴影: Dp = NavigationBarDefaults.Elevation,
    窗口插入: WindowInsets = NavigationBarDefaults.windowInsets,
    内容: @Composable RowScope.() -> Unit,
) =
    NavigationBar(
        modifier = 修饰符,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        windowInsets = 窗口插入,
        content = 内容,
    )



/**
 * Material Design 导航栏项目。
 *
 * 导航栏提供了一种持久且便捷的方式，用于在应用中的主要目的地之间进行切换。
 *
 * [NavigationBarItem] 的推荐配置取决于 [NavigationBar] 中包含的项目数量：
 * - 三个目的地：为所有目的地显示图标和文本标签。
 * - 四个目的地：活动状态的目的地显示图标和文本标签；非活动状态的目的地显示图标，建议使用文本标签。
 * - 五个目的地：活动状态的目的地显示图标和文本标签；非活动状态的目的地使用图标，如果空间允许则使用文本标签。
 *
 * [NavigationBarItem] 在被选中时始终显示文本标签（如果存在）。未选中时是否显示文本标签由 [始终显示标签] 控制。
 *
 * @param 已选择 此项目是否被选中。
 * @param 单击回调 当此项目被点击时调用。
 * @param 图标 此项目的图标，通常为 [图标]。
 * @param 修饰符 要应用于此项目的 [Modifier]。
 * @param 已启用 控制此项目的启用状态。当为 `false` 时，此组件不会响应用户输入，并且在视觉上呈现为禁用状态，
 * 同时辅助功能服务也会将其识别为禁用。
 * @param 标签 此项目的可选文本标签。
 * @param 始终显示标签 是否始终显示此项目的标签。如果为 `false`，则仅当此项目被选中时才显示标签。
 * @param 颜色集 [NavigationBarItemColors]，用于解析此项目在不同状态下所使用的颜色。请参阅 [NavigationBarItemDefaults.colors]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此项目的 [Interaction]。
 * 你可以用它来改变项目的外观或在不同状态下预览项目。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun RowScope.导航栏项(
    已选择: Boolean,
    单击回调: () -> Unit,
    图标: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    标签: @Composable (() -> Unit)? = null,
    始终显示标签: Boolean = true,
    颜色集: NavigationBarItemColors = NavigationBarItemDefaults.colors(),
    交互源: MutableInteractionSource? = null,
) {
    this.NavigationBarItem(
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
}


/** [NavigationBar] 中使用的默认值。 */
object 导航栏默认值 { // NavigationBarDefaults

    /** 导航栏的默认海拔高度。 */
    val 阴影: Dp = NavigationBarDefaults.Elevation

    /** 导航栏的默认颜色。 */
    val 容器颜色: Color
        @Composable get() = NavigationBarDefaults.containerColor

    /** 导航栏使用和消费的默认窗口边衬区。 */
    val 窗口插入: WindowInsets
        @Composable
        get() = NavigationBarDefaults.windowInsets

}


/** [NavigationBarItem] 中使用的默认值。 */
object 导航栏项默认值 { // NavigationBarItemDefaults

    /** 根据 Material 规范，使用所提供的颜色创建一个 [NavigationBarItemColors]。*/
    @Composable
    fun 颜色集() = NavigationBarItemDefaults.colors()

    /**
     * 根据 Material 规范，使用所提供的颜色创建一个 [NavigationBarItemColors]。
     *
     * @param 已选择图标颜色 项目被选中时图标的颜色。
     * @param 已选择文本颜色 项目被选中时文本标签的颜色。
     * @param 指示器颜色 项目被选中时指示器的颜色。
     * @param 未已选择图标颜色 项目未选中时图标的颜色。
     * @param 未已选择文本颜色 项目未选中时文本标签的颜色。
     * @param 禁用图标颜色 项目禁用时图标的颜色。
     * @param 禁用文本颜色 项目禁用时文本标签的颜色。
     * @return 用于 [NavigationBarItem] 的生成的 [NavigationBarItemColors]。
     */
    @Composable
    fun 颜色集(
        已选择图标颜色: Color = Color.Unspecified,
        已选择文本颜色: Color = Color.Unspecified,
        指示器颜色: Color = Color.Unspecified,
        未已选择图标颜色: Color = Color.Unspecified,
        未已选择文本颜色: Color = Color.Unspecified,
        禁用图标颜色: Color = Color.Unspecified,
        禁用文本颜色: Color = Color.Unspecified,
    ): NavigationBarItemColors =
        NavigationBarItemDefaults.colors(
            selectedIconColor = 已选择图标颜色,
            selectedTextColor = 已选择文本颜色,
            indicatorColor = 指示器颜色,
            unselectedIconColor = 未已选择图标颜色,
            unselectedTextColor = 未已选择文本颜色,
            disabledIconColor = 禁用图标颜色,
            disabledTextColor = 禁用文本颜色,
        )

}


/**
 * 表示导航项各元素的颜色。
 *
 * @param 已选择图标颜色 项目被选中时图标的颜色。
 * @param 已选择文本颜色 项目被选中时文本标签的颜色。
 * @param 已选择指示器颜色 项目被选中时指示器的颜色。
 * @param 未已选择图标颜色 项目未选中时图标的颜色。
 * @param 未已选择文本颜色 项目未选中时文本标签的颜色。
 * @param 禁用图标颜色 项目禁用时图标的颜色。
 * @param 禁用文本颜色 项目禁用时文本标签的颜色。
 * @constructor 使用任意颜色创建一个实例。
 */
fun 导航栏项颜色集(
    已选择图标颜色: Color,
    已选择文本颜色: Color,
    已选择指示器颜色: Color,
    未已选择图标颜色: Color,
    未已选择文本颜色: Color,
    禁用图标颜色: Color,
    禁用文本颜色: Color,
) =
    NavigationBarItemColors(
        selectedIconColor = 已选择图标颜色,
        selectedTextColor = 已选择文本颜色,
        selectedIndicatorColor = 已选择指示器颜色,
        unselectedIconColor = 未已选择图标颜色,
        unselectedTextColor = 未已选择文本颜色,
        disabledIconColor = 禁用图标颜色,
        disabledTextColor = 禁用文本颜色,
    )

/** 返回此 NavigationBarItemColors 的副本，可选择性地覆盖部分值。这里使用 Color.Unspecified 表示"使用源对象中的值"。*/
fun NavigationBarItemColors.复制(
    已选择图标颜色: Color = this.selectedIconColor,
    已选择文本颜色: Color = this.selectedTextColor,
    已选择指示器颜色: Color = this.selectedIndicatorColor,
    未已选择图标颜色: Color = this.unselectedIconColor,
    未已选择文本颜色: Color = this.unselectedTextColor,
    禁用图标颜色: Color = this.disabledIconColor,
    禁用文本颜色: Color = this.disabledTextColor,
) =
    this.copy(
        selectedIconColor = 已选择图标颜色,
        selectedTextColor = 已选择文本颜色,
        selectedIndicatorColor = 已选择指示器颜色,
        unselectedIconColor = 未已选择图标颜色,
        unselectedTextColor = 未已选择文本颜色,
        disabledIconColor = 禁用图标颜色,
        disabledTextColor = 禁用文本颜色,
    )


/** 包含当前选中的 [NavigationBarOverride] 的 CompositionLocal。 */
@ExperimentalMaterial3ComponentOverrideApi
val 本地导航栏覆盖: ProvidableCompositionLocal<NavigationBarOverride> = LocalNavigationBarOverride
