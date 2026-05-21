package 安卓x.组合.材质3

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LocalTonalElevationEnabled
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.expressiveLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import 安卓x.组合.材质3.令牌.浅色令牌
import 安卓x.组合.材质3.令牌.深色令牌

/**
 * 配色方案包含 [材质主题] 的所有具名颜色参数。
 *
 * 配色方案旨在实现色彩和谐、确保文本可访问性，并使 UI 元素和表面层之间相互区分。内置有两种基准方案：[浅色颜色方案]
 * （浅色配色方案）和 [深色颜色方案]（深色配色方案），可以直接使用，也可以进行自定义。
 *
 * Material 颜色系统和自定义配色方案提供了颜色的默认值，作为定制的起点。
 *
 * 要了解更多关于颜色的信息，请参阅 [Material Design colors](https://m3.material.io/styles/color/system/overview).
 *
 * @property 主色 主色是在应用各个屏幕和组件中显示最频繁的颜色。
 * @property 主色上 用于显示在主色之上的文本和图标的颜色。
 * @property 主色容器 容器的首选色调颜色。
 * @property 主色容器上 用于 [主色容器] 之上内容的颜色（及其状态变体）。
 * @property 反色主色 在需要反色方案的地方用作"主色"的颜色，例如 SnackBar 上的按钮。
 * @property 次色 次色提供了更多方式来强调和区分你的产品。次色最适用于：
 * - 悬浮操作按钮
 * - 选择控件，如复选框和单选按钮
 * - 高亮选中的文本
 * - 链接和标题
 * @property 次色上 用于显示在次色之上的文本和图标的颜色。
 * @property 次色容器 用于容器的色调颜色。
 * @property 次色容器上 用于 [次色容器] 之上内容的颜色（及其状态变体）。
 * @property 第三色 第三色，可用于平衡主色和次色，或引起对某个元素（如输入框）的高度关注。
 * @property 第三色上 用于显示在第三色之上的文本和图标的颜色。
 * @property 第三色容器 用于容器的色调颜色。
 * @property 第三色容器上 用于 [第三色容器] 之上内容的颜色（及其状态变体）。
 * @property 背景色 出现在可滚动内容背后的背景色。
 * @property 背景色上 用于显示在背景色之上的文本和图标的颜色。
 * @property 表面色 影响组件表面层的颜色，例如卡片、底部面板和菜单。
 * @property 表面色上 用于显示在表面色之上的文本和图标的颜色。
 * @property 表面色变体 另一种用途与 [表面色] 相似的颜色。
 * @property 表面色变体上 可用于 [表面色] 之上内容的颜色（及其状态变体）。
 * @property 表面色色调 应用色调海拔的组件将使用此颜色，它叠加在 [表面色] 之上。海拔越高，此颜色使用得越多。
 * @property 反色表面 一种与 [表面色] 形成鲜明对比的颜色。适用于位于其他 [表面色] 颜色表面之上的表面层。
 * @property 反色表面上 一种与 [反色表面] 对比良好的颜色。适用于位于 [反色表面] 容器之上的内容。
 * @property 错误色 错误色用于指示组件中的错误状态，例如文本字段中的无效文本。
 * @property 错误色上 用于显示在错误色之上的文本和图标的颜色。
 * @property 错误色容器 错误容器的首选色调颜色。
 * @property 错误色容器上 用于 [错误色容器] 之上内容的颜色（及其状态变体）。
 * @property 轮廓色 用于边界的柔和颜色。轮廓颜色角色用于增加对比度，以提高无障碍性。
 * @property 轮廓色变体 当不需要强对比度时，用于装饰性元素边界的辅助颜色。
 * @property 遮罩色 遮挡内容的遮罩颜色。
 * @property 表面色明亮 一种 [表面色] 的变体，无论在浅色还是深色模式下，始终比 [表面色] 更亮。
 * @property 表面色暗淡 一种 [表面色] 的变体，无论在浅色还是深色模式下，始终比 [表面色] 更暗。
 * @property 表面色容器 一种影响组件容器的 [表面色] 变体，例如卡片、底部面板和菜单。
 * @property 表面色容器高亮 一种 [表面色] 容器变体，比 [表面色容器] 具有更高的强调程度。
 * 将此角色用于需要比 [表面色容器] 更多强调的内容。
 * @property 表面色容器最高 一种 [表面色] 容器变体，比 [表面色容器高亮] 具有更高的强调程度。
 * 将此角色用于需要比 [表面色容器高亮] 更多强调的内容。
 * @property 表面色容器低 一种 [表面色] 容器变体，比 [表面色容器] 具有更低的强调程度。
 * 将此角色用于需要比 [表面色容器] 更少强调的内容。
 * @property 表面色容器最低 一种 [表面色] 容器变体，比 [表面色容器低] 具有更低的强调程度。
 * 将此角色用于需要比 [表面色容器低] 更少强调的内容。
 */
@Deprecated(
    level = DeprecationLevel.WARNING,
    message = "Use constructor with additional 'fixed' container roles.",
    replaceWith =
        ReplaceWith(
            "ColorScheme(primary,\n" +
                    "onPrimary,\n" +
                    "primaryContainer,\n" +
                    "onPrimaryContainer,\n" +
                    "inversePrimary,\n" +
                    "secondary,\n" +
                    "onSecondary,\n" +
                    "secondaryContainer,\n" +
                    "onSecondaryContainer,\n" +
                    "tertiary,\n" +
                    "onTertiary,\n" +
                    "tertiaryContainer,\n" +
                    "onTertiaryContainer,\n" +
                    "background,\n" +
                    "onBackground,\n" +
                    "surface,\n" +
                    "onSurface,\n" +
                    "surfaceVariant,\n" +
                    "onSurfaceVariant,\n" +
                    "surfaceTint,\n" +
                    "inverseSurface,\n" +
                    "inverseOnSurface,\n" +
                    "error,\n" +
                    "onError,\n" +
                    "errorContainer,\n" +
                    "onErrorContainer,\n" +
                    "outline,\n" +
                    "outlineVariant,\n" +
                    "scrim,\n" +
                    "surfaceBright,\n" +
                    "surfaceDim,\n" +
                    "surfaceContainer,\n" +
                    "surfaceContainerHigh,\n" +
                    "surfaceContainerHighest,\n" +
                    "surfaceContainerLow,\n" +
                    "surfaceContainerLowest,)"
        ),
)
fun 颜色方案(
    主色: Color,
    主色上: Color,
    主色容器: Color,
    主色容器上: Color,
    反色主色: Color,
    次色: Color,
    次色上: Color,
    次色容器: Color,
    次色容器上: Color,
    第三色: Color,
    第三色上: Color,
    第三色容器: Color,
    第三色容器上: Color,
    背景色: Color,
    背景色上: Color,
    表面色: Color,
    表面色上: Color,
    表面色变体: Color,
    表面色变体上: Color,
    表面色色调: Color,
    反色表面: Color,
    反色表面上: Color,
    错误色: Color,
    错误色上: Color,
    错误色容器: Color,
    错误色容器上: Color,
    轮廓色: Color,
    轮廓色变体: Color,
    遮罩色: Color,
    表面色明亮: Color,
    表面色暗淡: Color,
    表面色容器: Color,
    表面色容器高亮: Color,
    表面色容器最高: Color,
    表面色容器低: Color,
    表面色容器最低: Color,
):ColorScheme =
     ColorScheme(
        primary = 主色,
        onPrimary = 主色上,
        primaryContainer = 主色容器,
        onPrimaryContainer = 主色容器上,
        inversePrimary = 反色主色,
        secondary = 次色,
        onSecondary = 次色上,
        secondaryContainer = 次色容器,
        onSecondaryContainer = 次色容器上,
        tertiary = 第三色,
        onTertiary = 第三色上,
        tertiaryContainer = 第三色容器,
        onTertiaryContainer = 第三色容器上,
        background = 背景色,
        onBackground = 背景色上,
        surface = 表面色,
        onSurface = 表面色上,
        surfaceVariant = 表面色变体,
        onSurfaceVariant = 表面色变体上,
        surfaceTint = 表面色色调,
        inverseSurface = 反色表面,
        inverseOnSurface = 反色表面上,
        error = 错误色,
        onError = 错误色上,
        errorContainer = 错误色容器,
        onErrorContainer = 错误色容器上,
        outline = 轮廓色,
        outlineVariant = 轮廓色变体,
        scrim = 遮罩色,
        surfaceBright = 表面色明亮,
        surfaceDim = 表面色暗淡,
        surfaceContainer = 表面色容器,
        surfaceContainerHigh = 表面色容器高亮,
        surfaceContainerHighest = 表面色容器最高,
        surfaceContainerLow = 表面色容器低,
        surfaceContainerLowest = 表面色容器最低,
        primaryFixed = Color.Unspecified,
        primaryFixedDim = Color.Unspecified,
        onPrimaryFixed = Color.Unspecified,
        onPrimaryFixedVariant = Color.Unspecified,
        secondaryFixed = Color.Unspecified,
        secondaryFixedDim = Color.Unspecified,
        onSecondaryFixed = Color.Unspecified,
        onSecondaryFixedVariant = Color.Unspecified,
        tertiaryFixed = Color.Unspecified,
        tertiaryFixedDim = Color.Unspecified,
        onTertiaryFixed = Color.Unspecified,
        onTertiaryFixedVariant = Color.Unspecified,
    )

/**
 * 配色方案包含 [材质主题] 的所有具名颜色参数。
 *
 * 配色方案旨在实现色彩和谐、确保文本可访问性，并使 UI 元素和表面层之间相互区分。内置有两种基准方案：[浅色颜色方案]
 * （浅色配色方案）和 [深色颜色方案]（深色配色方案），可以直接使用，也可以进行自定义。
 *
 * Material 颜色系统和自定义配色方案提供了颜色的默认值，作为定制的起点。
 *
 * 要了解更多关于颜色的信息，请参阅 [Material Design colors](https://m3.material.io/styles/color/system/overview).
 *
 * @property 主色 主色是在应用各个屏幕和组件中显示最频繁的颜色。
 * @property 主色上 用于显示在主色之上的文本和图标的颜色。
 * @property 主色容器 容器的首选色调颜色。
 * @property 主色容器上 用于 [主色容器] 之上内容的颜色（及其状态变体）。
 * @property 反色主色 在需要反色方案的地方用作"主色"的颜色，例如 SnackBar 上的按钮。
 * @property 次色 次色提供了更多方式来强调和区分你的产品。次色最适用于：
 * - 悬浮操作按钮
 * - 选择控件，如复选框和单选按钮
 * - 高亮选中的文本
 * - 链接和标题
 * @property 次色上 用于显示在次色之上的文本和图标的颜色。
 * @property 次色容器 用于容器的色调颜色。
 * @property 次色容器上 用于 [次色容器] 之上内容的颜色（及其状态变体）。
 * @property 第三色 第三色，可用于平衡主色和次色，或引起对某个元素（如输入框）的高度关注。
 * @property 第三色上 用于显示在第三色之上的文本和图标的颜色。
 * @property 第三色容器 用于容器的色调颜色。
 * @property 第三色容器上 用于 [第三色容器] 之上内容的颜色（及其状态变体）。
 * @property 背景色 出现在可滚动内容背后的背景色。
 * @property 背景色上 用于显示在背景色之上的文本和图标的颜色。
 * @property 表面色 影响组件表面层的颜色，例如卡片、底部面板和菜单。
 * @property 表面色上 用于显示在表面色之上的文本和图标的颜色。
 * @property 表面色变体 另一种用途与 [表面色] 相似的颜色。
 * @property 表面色变体上 可用于 [表面色] 之上内容的颜色（及其状态变体）。
 * @property 表面色色调 应用色调海拔的组件将使用此颜色，它叠加在 [表面色] 之上。海拔越高，此颜色使用得越多。
 * @property 反色表面 一种与 [表面色] 形成鲜明对比的颜色。适用于位于其他 [表面色] 颜色表面之上的表面层。
 * @property 反色表面上 一种与 [反色表面] 对比良好的颜色。适用于位于 [反色表面] 容器之上的内容。
 * @property 错误色 错误色用于指示组件中的错误状态，例如文本字段中的无效文本。
 * @property 错误色上 用于显示在错误色之上的文本和图标的颜色。
 * @property 错误色容器 错误容器的首选色调颜色。
 * @property 错误色容器上 用于 [错误色容器] 之上内容的颜色（及其状态变体）。
 * @property 轮廓色 用于边界的柔和颜色。轮廓颜色角色用于增加对比度，以提高无障碍性。
 * @property 轮廓色变体 当不需要强对比度时，用于装饰性元素边界的辅助颜色。
 * @property 遮罩色 遮挡内容的遮罩颜色。
 * @property 表面色明亮 一种 [表面色] 的变体，无论在浅色还是深色模式下，始终比 [表面色] 更亮。
 * @property 表面色暗淡 一种 [表面色] 的变体，无论在浅色还是深色模式下，始终比 [表面色] 更暗。
 * @property 表面色容器 一种影响组件容器的 [表面色] 变体，例如卡片、底部面板和菜单。
 * @property 表面色容器高亮 一种 [表面色] 容器变体，比 [表面色容器] 具有更高的强调程度。
 * 将此角色用于需要比 [表面色容器] 更多强调的内容。
 * @property 表面色容器最高 一种 [表面色] 容器变体，比 [表面色容器高亮] 具有更高的强调程度。
 * 将此角色用于需要比 [表面色容器高亮] 更多强调的内容。
 * @property 表面色容器低 一种 [表面色] 容器变体，比 [表面色容器] 具有更低的强调程度。
 * 将此角色用于需要比 [表面色容器] 更少强调的内容。
 * @property 表面色容器最低 一种 [表面色] 容器变体，比 [表面色容器低] 具有更低的强调程度。
 * 将此角色用于需要比 [表面色容器低] 更少强调的内容。
 * @property 主色固定 一种 [主色] 变体，在浅色和深色主题中保持相同的色调。在需要这种固定行为的场景中，可以使用固定颜色角色替代等效的容器角色。
 * @property 主色固定暗淡 一种 [主色] 变体，在浅色和深色主题中保持相同的色调。Dim 角色相对于等效的固定颜色提供更强、更强调的色调。
 * @property 主色固定上 用于显示在 [主色固定] 或 [主色固定暗淡] 之上的文本和图标的颜色。在浅色和深色主题中保持相同的色调。
 * @property 主色固定变体上 一种 [主色固定上] 的变体，提供较低的强调程度。适用于不需要强对比度的场景。
 * @property 次色固定 一种 [次色] 变体，在浅色和深色主题中保持相同的色调。在需要这种固定行为的场景中，可以使用固定颜色角色替代等效的容器角色。
 * @property 次色固定暗淡 一种 [次色] 变体，在浅色和深色主题中保持相同的色调。Dim 角色相对于等效的固定颜色提供更强、更强调的色调。
 * @property 次色固定上 用于显示在 [次色固定] 或 [次色固定暗淡] 之上的文本和图标的颜色。在浅色和深色主题中保持相同的色调。
 * @property 次色固定变体上 一种 [次色固定上] 的变体，提供较低的强调程度。适用于不需要强对比度的场景。
 * @property 第三色固定 一种 [第三色] 变体，在浅色和深色主题中保持相同的色调。在需要这种固定行为的场景中，可以使用固定颜色角色替代等效的容器角色。
 * @property 第三色固定暗淡 一种 [第三色] 变体，在浅色和深色主题中保持相同的色调。Dim 角色相对于等效的固定颜色提供更强、更强调的色调。
 * @property 第三色固定上 用于显示在 [第三色固定] 或 [第三色固定暗淡] 之上的文本和图标的颜色。在浅色和深色主题中保持相同的色调。
 * @property 第三色固定变体上 一种 [第三色固定上] 的变体，提供较低的强调程度。适用于不需要强对比度的场景。
 */
fun 颜色方案(
    主色: Color,
    主色上: Color,
    主色容器: Color,
    主色容器上: Color,
    反色主色: Color,
    次色: Color,
    次色上: Color,
    次色容器: Color,
    次色容器上: Color,
    第三色: Color,
    第三色上: Color,
    第三色容器: Color,
    第三色容器上: Color,
    背景色: Color,
    背景色上: Color,
    表面色: Color,
    表面色上: Color,
    表面色变体: Color,
    表面色变体上: Color,
    表面色色调: Color,
    反色表面: Color,
    反色表面上: Color,
    错误色: Color,
    错误色上: Color,
    错误色容器: Color,
    错误色容器上: Color,
    轮廓色: Color,
    轮廓色变体: Color,
    遮罩色: Color,
    表面色明亮: Color,
    表面色暗淡: Color,
    表面色容器: Color,
    表面色容器高亮: Color,
    表面色容器最高: Color,
    表面色容器低: Color,
    表面色容器最低: Color,
    主色固定: Color,
    主色固定暗淡: Color,
    主色固定上: Color,
    主色固定变体上: Color,
    次色固定: Color,
    次色固定暗淡: Color,
    次色固定上: Color,
    次色固定变体上: Color,
    第三色固定: Color,
    第三色固定暗淡: Color,
    第三色固定上: Color,
    第三色固定变体上: Color,
): ColorScheme =
    ColorScheme(
        primary = 主色,
        onPrimary = 主色上,
        primaryContainer = 主色容器,
        onPrimaryContainer = 主色容器上,
        inversePrimary = 反色主色,
        secondary = 次色,
        onSecondary = 次色上,
        secondaryContainer = 次色容器,
        onSecondaryContainer = 次色容器上,
        tertiary = 第三色,
        onTertiary = 第三色上,
        tertiaryContainer = 第三色容器,
        onTertiaryContainer = 第三色容器上,
        background = 背景色,
        onBackground = 背景色上,
        surface = 表面色,
        onSurface = 表面色上,
        surfaceVariant = 表面色变体,
        onSurfaceVariant = 表面色变体上,
        surfaceTint = 表面色色调,
        inverseSurface = 反色表面,
        inverseOnSurface = 反色表面上,
        error = 错误色,
        onError = 错误色上,
        errorContainer = 错误色容器,
        onErrorContainer = 错误色容器上,
        outline = 轮廓色,
        outlineVariant = 轮廓色变体,
        scrim = 遮罩色,
        surfaceBright = 表面色明亮,
        surfaceDim = 表面色暗淡,
        surfaceContainer = 表面色容器,
        surfaceContainerHigh = 表面色容器高亮,
        surfaceContainerHighest = 表面色容器最高,
        surfaceContainerLow = 表面色容器低,
        surfaceContainerLowest = 表面色容器最低,
        primaryFixed = 主色固定,
        primaryFixedDim = 主色固定暗淡,
        onPrimaryFixed = 主色固定上,
        onPrimaryFixedVariant = 主色固定变体上,
        secondaryFixed = 次色固定,
        secondaryFixedDim = 次色固定暗淡,
        onSecondaryFixed = 次色固定上,
        onSecondaryFixedVariant = 次色固定变体上,
        tertiaryFixed = 第三色固定,
        tertiaryFixedDim = 第三色固定暗淡,
        onTertiaryFixed = 第三色固定上,
        onTertiaryFixedVariant = 第三色固定变体上,
    )

/**
 * 配色方案包含 [材质主题] 的所有具名颜色参数。
 *
 * 配色方案旨在实现色彩和谐、确保文本可访问性，并使 UI 元素和表面层之间相互区分。内置有两种基准方案：[浅色颜色方案]
 * （浅色配色方案）和 [深色颜色方案]（深色配色方案），可以直接使用，也可以进行自定义。
 *
 * Material 颜色系统和自定义配色方案提供了颜色的默认值，作为定制的起点。
 *
 * 要了解更多关于颜色的信息，请参阅 [Material Design colors](https://m3.material.io/styles/color/system/overview).
 *
 * @property 主色 主色是在应用各个屏幕和组件中显示最频繁的颜色。
 * @property 主色上 用于显示在主色之上的文本和图标的颜色。
 * @property 主色容器 容器的首选色调颜色。
 * @property 主色容器上 用于 [主色容器] 之上内容的颜色（及其状态变体）。
 * @property 反色主色 在需要反色方案的地方用作"主色"的颜色，例如 SnackBar 上的按钮。
 * @property 次色 次色提供了更多方式来强调和区分你的产品。次色最适用于：
 * - 悬浮操作按钮
 * - 选择控件，如复选框和单选按钮
 * - 高亮选中的文本
 * - 链接和标题
 * @property 次色上 用于显示在次色之上的文本和图标的颜色。
 * @property 次色容器 用于容器的色调颜色。
 * @property 次色容器上 用于 [次色容器] 之上内容的颜色（及其状态变体）。
 * @property 第三色 第三色，可用于平衡主色和次色，或引起对某个元素（如输入框）的高度关注。
 * @property 第三色上 用于显示在第三色之上的文本和图标的颜色。
 * @property 第三色容器 用于容器的色调颜色。
 * @property 第三色容器上 用于 [第三色容器] 之上内容的颜色（及其状态变体）。
 * @property 背景色 出现在可滚动内容背后的背景色。
 * @property 背景色上 用于显示在背景色之上的文本和图标的颜色。
 * @property 表面色 影响组件表面层的颜色，例如卡片、底部面板和菜单。
 * @property 表面色上 用于显示在表面色之上的文本和图标的颜色。
 * @property 表面色变体 另一种用途与 [表面色] 相似的颜色。
 * @property 表面色变体上 可用于 [表面色] 之上内容的颜色（及其状态变体）。
 * @property 表面色色调 应用色调海拔的组件将使用此颜色，它叠加在 [表面色] 之上。海拔越高，此颜色使用得越多。
 * @property 反色表面 一种与 [表面色] 形成鲜明对比的颜色。适用于位于其他 [表面色] 颜色表面之上的表面层。
 * @property 反色表面上 一种与 [反色表面] 对比良好的颜色。适用于位于 [反色表面] 容器之上的内容。
 * @property 错误色 错误色用于指示组件中的错误状态，例如文本字段中的无效文本。
 * @property 错误色上 用于显示在错误色之上的文本和图标的颜色。
 * @property 错误色容器 错误容器的首选色调颜色。
 * @property 错误色容器上 用于 [错误色容器] 之上内容的颜色（及其状态变体）。
 * @property 轮廓色 用于边界的柔和颜色。轮廓颜色角色用于增加对比度，以提高无障碍性。
 * @property 轮廓色变体 当不需要强对比度时，用于装饰性元素边界的辅助颜色。
 * @property 遮罩色 遮挡内容的遮罩颜色。
 * @property 表面色明亮 一种 [表面色] 的变体，无论在浅色还是深色模式下，始终比 [表面色] 更亮。
 * @property 表面色暗淡 一种 [表面色] 的变体，无论在浅色还是深色模式下，始终比 [表面色] 更暗。
 * @property 表面色容器 一种影响组件容器的 [表面色] 变体，例如卡片、底部面板和菜单。
 * @property 表面色容器高亮 一种 [表面色] 容器变体，比 [表面色容器] 具有更高的强调程度。
 * 将此角色用于需要比 [表面色容器] 更多强调的内容。
 * @property 表面色容器最高 一种 [表面色] 容器变体，比 [表面色容器高亮] 具有更高的强调程度。
 * 将此角色用于需要比 [表面色容器高亮] 更多强调的内容。
 * @property 表面色容器低 一种 [表面色] 容器变体，比 [表面色容器] 具有更低的强调程度。
 * 将此角色用于需要比 [表面色容器] 更少强调的内容。
 * @property 表面色容器最低 一种 [表面色] 容器变体，比 [表面色容器低] 具有更低的强调程度。
 * 将此角色用于需要比 [表面色容器低] 更少强调的内容。
 * @property 主色固定 一种 [主色] 变体，在浅色和深色主题中保持相同的色调。在需要这种固定行为的场景中，可以使用固定颜色角色替代等效的容器角色。
 * @property 主色固定暗淡 一种 [主色] 变体，在浅色和深色主题中保持相同的色调。Dim 角色相对于等效的固定颜色提供更强、更强调的色调。
 * @property 主色固定上 用于显示在 [主色固定] 或 [主色固定暗淡] 之上的文本和图标的颜色。在浅色和深色主题中保持相同的色调。
 * @property 主色固定变体上 一种 [主色固定上] 的变体，提供较低的强调程度。适用于不需要强对比度的场景。
 * @property 次色固定 一种 [次色] 变体，在浅色和深色主题中保持相同的色调。在需要这种固定行为的场景中，可以使用固定颜色角色替代等效的容器角色。
 * @property 次色固定暗淡 一种 [次色] 变体，在浅色和深色主题中保持相同的色调。Dim 角色相对于等效的固定颜色提供更强、更强调的色调。
 * @property 次色固定上 用于显示在 [次色固定] 或 [次色固定暗淡] 之上的文本和图标的颜色。在浅色和深色主题中保持相同的色调。
 * @property 次色固定变体上 一种 [次色固定上] 的变体，提供较低的强调程度。适用于不需要强对比度的场景。
 * @property 第三色固定 一种 [第三色] 变体，在浅色和深色主题中保持相同的色调。在需要这种固定行为的场景中，可以使用固定颜色角色替代等效的容器角色。
 * @property 第三色固定暗淡 一种 [第三色] 变体，在浅色和深色主题中保持相同的色调。Dim 角色相对于等效的固定颜色提供更强、更强调的色调。
 * @property 第三色固定上 用于显示在 [第三色固定] 或 [第三色固定暗淡] 之上的文本和图标的颜色。在浅色和深色主题中保持相同的色调。
 * @property 第三色固定变体上 一种 [第三色固定上] 的变体，提供较低的强调程度。适用于不需要强对比度的场景。
 * @return 返回此 ColorScheme 的副本，可选择性地覆盖部分值。
 */
fun ColorScheme.复制(
    主色: Color = this.primary,
    主色上: Color = this.onPrimary,
    主色容器: Color = this.primaryContainer,
    主色容器上: Color = this.onPrimaryContainer,
    反色主色: Color = this.inversePrimary,
    次色: Color = this.secondary,
    次色上: Color = this.onSecondary,
    次色容器: Color = this.secondaryContainer,
    次色容器上: Color = this.onSecondaryContainer,
    第三色: Color = this.tertiary,
    第三色上: Color = this.onTertiary,
    第三色容器: Color = this.tertiaryContainer,
    第三色容器上: Color = this.onTertiaryContainer,
    背景色: Color = this.background,
    背景色上: Color = this.onBackground,
    表面色: Color = this.surface,
    表面色上: Color = this.onSurface,
    表面色变体: Color = this.surfaceVariant,
    表面色变体上: Color = this.onSurfaceVariant,
    表面色色调: Color = this.surfaceTint,
    反色表面: Color = this.inverseSurface,
    反色表面上: Color = this.inverseOnSurface,
    错误色: Color = this.error,
    错误色上: Color = this.onError,
    错误色容器: Color = this.errorContainer,
    错误色容器上: Color = this.onErrorContainer,
    轮廓色: Color = this.outline,
    轮廓色变体: Color = this.outlineVariant,
    遮罩色: Color = this.scrim,
    表面色明亮: Color = this.surfaceBright,
    表面色暗淡: Color = this.surfaceDim,
    表面色容器: Color = this.surfaceContainer,
    表面色容器高亮: Color = this.surfaceContainerHigh,
    表面色容器最高: Color = this.surfaceContainerHighest,
    表面色容器低: Color = this.surfaceContainerLow,
    表面色容器最低: Color = this.surfaceContainerLowest,
    主色固定: Color = this.primaryFixed,
    主色固定暗淡: Color = this.primaryFixedDim,
    主色固定上: Color = this.onPrimaryFixed,
    主色固定变体上: Color = this.onPrimaryFixedVariant,
    次色固定: Color = this.secondaryFixed,
    次色固定暗淡: Color = this.secondaryFixedDim,
    次色固定上: Color = this.onSecondaryFixed,
    次色固定变体上: Color = this.onSecondaryFixedVariant,
    第三色固定: Color = this.tertiaryFixed,
    第三色固定暗淡: Color = this.tertiaryFixedDim,
    第三色固定上: Color = this.onTertiaryFixed,
    第三色固定变体上: Color = this.onTertiaryFixedVariant,
): ColorScheme =
    this.copy(
        primary = 主色,
        onPrimary = 主色上,
        primaryContainer = 主色容器,
        onPrimaryContainer = 主色容器上,
        inversePrimary = 反色主色,
        secondary = 次色,
        onSecondary = 次色上,
        secondaryContainer = 次色容器,
        onSecondaryContainer = 次色容器上,
        tertiary = 第三色,
        onTertiary = 第三色上,
        tertiaryContainer = 第三色容器,
        onTertiaryContainer = 第三色容器上,
        background = 背景色,
        onBackground = 背景色上,
        surface = 表面色,
        onSurface = 表面色上,
        surfaceVariant = 表面色变体,
        onSurfaceVariant = 表面色变体上,
        surfaceTint = 表面色色调,
        inverseSurface = 反色表面,
        inverseOnSurface = 反色表面上,
        error = 错误色,
        onError = 错误色上,
        errorContainer = 错误色容器,
        onErrorContainer = 错误色容器上,
        outline = 轮廓色,
        outlineVariant = 轮廓色变体,
        scrim = 遮罩色,
        surfaceBright = 表面色明亮,
        surfaceDim = 表面色暗淡,
        surfaceContainer = 表面色容器,
        surfaceContainerHigh = 表面色容器高亮,
        surfaceContainerHighest = 表面色容器最高,
        surfaceContainerLow = 表面色容器低,
        surfaceContainerLowest = 表面色容器最低,
        primaryFixed = 主色固定,
        primaryFixedDim = 主色固定暗淡,
        onPrimaryFixed = 主色固定上,
        onPrimaryFixedVariant = 主色固定变体上,
        secondaryFixed = 次色固定,
        secondaryFixedDim = 次色固定暗淡,
        onSecondaryFixed = 次色固定上,
        onSecondaryFixedVariant = 次色固定变体上,
        tertiaryFixed = 第三色固定,
        tertiaryFixedDim = 第三色固定暗淡,
        onTertiaryFixed = 第三色固定上,
        onTertiaryFixedVariant = 第三色固定变体上,
    )

/**
 * 配色方案包含 [材质主题] 的所有具名颜色参数。
 *
 * 配色方案旨在实现色彩和谐、确保文本可访问性，并使 UI 元素和表面层之间相互区分。内置有两种基准方案：[浅色颜色方案]
 * （浅色配色方案）和 [深色颜色方案]（深色配色方案），可以直接使用，也可以进行自定义。
 *
 * Material 颜色系统和自定义配色方案提供了颜色的默认值，作为定制的起点。
 *
 * 要了解更多关于颜色的信息，请参阅 [Material Design colors](https://m3.material.io/styles/color/system/overview).
 *
 * @property 主色 主色是在应用各个屏幕和组件中显示最频繁的颜色。
 * @property 主色上 用于显示在主色之上的文本和图标的颜色。
 * @property 主色容器 容器的首选色调颜色。
 * @property 主色容器上 用于 [主色容器] 之上内容的颜色（及其状态变体）。
 * @property 反色主色 在需要反色方案的地方用作"主色"的颜色，例如 SnackBar 上的按钮。
 * @property 次色 次色提供了更多方式来强调和区分你的产品。次色最适用于：
 * - 悬浮操作按钮
 * - 选择控件，如复选框和单选按钮
 * - 高亮选中的文本
 * - 链接和标题
 * @property 次色上 用于显示在次色之上的文本和图标的颜色。
 * @property 次色容器 用于容器的色调颜色。
 * @property 次色容器上 用于 [次色容器] 之上内容的颜色（及其状态变体）。
 * @property 第三色 第三色，可用于平衡主色和次色，或引起对某个元素（如输入框）的高度关注。
 * @property 第三色上 用于显示在第三色之上的文本和图标的颜色。
 * @property 第三色容器 用于容器的色调颜色。
 * @property 第三色容器上 用于 [第三色容器] 之上内容的颜色（及其状态变体）。
 * @property 背景色 出现在可滚动内容背后的背景色。
 * @property 背景色上 用于显示在背景色之上的文本和图标的颜色。
 * @property 表面色 影响组件表面层的颜色，例如卡片、底部面板和菜单。
 * @property 表面色上 用于显示在表面色之上的文本和图标的颜色。
 * @property 表面色变体 另一种用途与 [表面色] 相似的颜色。
 * @property 表面色变体上 可用于 [表面色] 之上内容的颜色（及其状态变体）。
 * @property 表面色色调 应用色调海拔的组件将使用此颜色，它叠加在 [表面色] 之上。海拔越高，此颜色使用得越多。
 * @property 反色表面 一种与 [表面色] 形成鲜明对比的颜色。适用于位于其他 [表面色] 颜色表面之上的表面层。
 * @property 反色表面上 一种与 [反色表面] 对比良好的颜色。适用于位于 [反色表面] 容器之上的内容。
 * @property 错误色 错误色用于指示组件中的错误状态，例如文本字段中的无效文本。
 * @property 错误色上 用于显示在错误色之上的文本和图标的颜色。
 * @property 错误色容器 错误容器的首选色调颜色。
 * @property 错误色容器上 用于 [错误色容器] 之上内容的颜色（及其状态变体）。
 * @property 轮廓色 用于边界的柔和颜色。轮廓颜色角色用于增加对比度，以提高无障碍性。
 * @property 轮廓色变体 当不需要强对比度时，用于装饰性元素边界的辅助颜色。
 * @property 遮罩色 遮挡内容的遮罩颜色。
 */
@Deprecated(
    level = DeprecationLevel.WARNING,
    message = "Use constructor with additional 'surfaceContainer' roles.",
    replaceWith =
        ReplaceWith(
            "ColorScheme(primary,\n" +
                    "onPrimary,\n" +
                    "primaryContainer,\n" +
                    "onPrimaryContainer,\n" +
                    "inversePrimary,\n" +
                    "secondary,\n" +
                    "onSecondary,\n" +
                    "secondaryContainer,\n" +
                    "onSecondaryContainer,\n" +
                    "tertiary,\n" +
                    "onTertiary,\n" +
                    "tertiaryContainer,\n" +
                    "onTertiaryContainer,\n" +
                    "background,\n" +
                    "onBackground,\n" +
                    "surface,\n" +
                    "onSurface,\n" +
                    "surfaceVariant,\n" +
                    "onSurfaceVariant,\n" +
                    "surfaceTint,\n" +
                    "inverseSurface,\n" +
                    "inverseOnSurface,\n" +
                    "error,\n" +
                    "onError,\n" +
                    "errorContainer,\n" +
                    "onErrorContainer,\n" +
                    "outline,\n" +
                    "outlineVariant,\n" +
                    "scrim,\n" +
                    "surfaceBright,\n" +
                    "surfaceDim,\n" +
                    "surfaceContainer,\n" +
                    "surfaceContainerHigh,\n" +
                    "surfaceContainerHighest,\n" +
                    "surfaceContainerLow,\n" +
                    "surfaceContainerLowest,\n" +
                    "primaryFixed,\n" +
                    "primaryFixedDim,\n" +
                    "onPrimaryFixed,\n" +
                    "onPrimaryFixedVariant,\n" +
                    "secondaryFixed,\n" +
                    "secondaryFixedDim,\n" +
                    "onSecondaryFixed,\n" +
                    "onSecondaryFixedVariant,\n" +
                    "tertiaryFixed,\n" +
                    "tertiaryFixedDim,\n" +
                    "onTertiaryFixed,\n" +
                    "onTertiaryFixedVariant" +
                    ")"
        ),
)
fun 颜色方案(
    主色: Color,
    主色上: Color,
    主色容器: Color,
    主色容器上: Color,
    反色主色: Color,
    次色: Color,
    次色上: Color,
    次色容器: Color,
    次色容器上: Color,
    第三色: Color,
    第三色上: Color,
    第三色容器: Color,
    第三色容器上: Color,
    背景色: Color,
    背景色上: Color,
    表面色: Color,
    表面色上: Color,
    表面色变体: Color,
    表面色变体上: Color,
    表面色色调: Color,
    反色表面: Color,
    反色表面上: Color,
    错误色: Color,
    错误色上: Color,
    错误色容器: Color,
    错误色容器上: Color,
    轮廓色: Color,
    轮廓色变体: Color,
    遮罩色: Color,
):ColorScheme =
    ColorScheme(
        primary = 主色,
        onPrimary = 主色上,
        primaryContainer = 主色容器,
        onPrimaryContainer = 主色容器上,
        inversePrimary = 反色主色,
        secondary = 次色,
        onSecondary = 次色上,
        secondaryContainer = 次色容器,
        onSecondaryContainer = 次色容器上,
        tertiary = 第三色,
        onTertiary = 第三色上,
        tertiaryContainer = 第三色容器,
        onTertiaryContainer = 第三色容器上,
        background = 背景色,
        onBackground = 背景色上,
        surface = 表面色,
        onSurface = 表面色上,
        surfaceVariant = 表面色变体,
        onSurfaceVariant = 表面色变体上,
        surfaceTint = 表面色色调,
        inverseSurface = 反色表面,
        inverseOnSurface = 反色表面上,
        error = 错误色,
        onError = 错误色上,
        errorContainer = 错误色容器,
        onErrorContainer = 错误色容器上,
        outline = 轮廓色,
        outlineVariant = 轮廓色变体,
        scrim = 遮罩色,
        surfaceBright = Color.Unspecified,
        surfaceDim = Color.Unspecified,
        surfaceContainer = Color.Unspecified,
        surfaceContainerHigh = Color.Unspecified,
        surfaceContainerHighest = Color.Unspecified,
        surfaceContainerLow = Color.Unspecified,
        surfaceContainerLowest = Color.Unspecified,
        primaryFixed = Color.Unspecified,
        primaryFixedDim = Color.Unspecified,
        onPrimaryFixed = Color.Unspecified,
        onPrimaryFixedVariant = Color.Unspecified,
        secondaryFixed = Color.Unspecified,
        secondaryFixedDim = Color.Unspecified,
        onSecondaryFixed = Color.Unspecified,
        onSecondaryFixedVariant = Color.Unspecified,
        tertiaryFixed = Color.Unspecified,
        tertiaryFixedDim = Color.Unspecified,
        onTertiaryFixed = Color.Unspecified,
        onTertiaryFixedVariant = Color.Unspecified,
    )


/** 返回浅色 Material 配色方案。 */
fun 浅色颜色方案(
    主色: Color = 浅色令牌.Primary,
    主色上: Color = 浅色令牌.OnPrimary,
    主色容器: Color = 浅色令牌.PrimaryContainer,
    主色容器上: Color = 浅色令牌.OnPrimaryContainer,
    反色主色: Color = 浅色令牌.InversePrimary,
    次色: Color = 浅色令牌.Secondary,
    次色上: Color = 浅色令牌.OnSecondary,
    次色容器: Color = 浅色令牌.SecondaryContainer,
    次色容器上: Color = 浅色令牌.OnSecondaryContainer,
    第三色: Color = 浅色令牌.Tertiary,
    第三色上: Color = 浅色令牌.OnTertiary,
    第三色容器: Color = 浅色令牌.TertiaryContainer,
    第三色容器上: Color = 浅色令牌.OnTertiaryContainer,
    背景色: Color = 浅色令牌.Background,
    背景色上: Color = 浅色令牌.OnBackground,
    表面色: Color = 浅色令牌.Surface,
    表面色上: Color = 浅色令牌.OnSurface,
    表面色变体: Color = 浅色令牌.SurfaceVariant,
    表面色变体上: Color = 浅色令牌.OnSurfaceVariant,
    表面色色调: Color = 主色,
    反色表面: Color = 浅色令牌.InverseSurface,
    反色表面上: Color = 浅色令牌.InverseOnSurface,
    错误色: Color = 浅色令牌.Error,
    错误色上: Color = 浅色令牌.OnError,
    错误色容器: Color = 浅色令牌.ErrorContainer,
    错误色容器上: Color = 浅色令牌.OnErrorContainer,
    轮廓色: Color = 浅色令牌.Outline,
    轮廓色变体: Color = 浅色令牌.OutlineVariant,
    遮罩色: Color = 浅色令牌.Scrim,
    表面色明亮: Color = 浅色令牌.SurfaceBright,
    表面色容器: Color = 浅色令牌.SurfaceContainer,
    表面色容器高亮: Color = 浅色令牌.SurfaceContainerHigh,
    表面色容器最高: Color = 浅色令牌.SurfaceContainerHighest,
    表面色容器低: Color = 浅色令牌.SurfaceContainerLow,
    表面色容器最低: Color = 浅色令牌.SurfaceContainerLowest,
    表面色暗淡: Color = 浅色令牌.SurfaceDim,
    主色固定: Color = 浅色令牌.PrimaryFixed,
    主色固定暗淡: Color = 浅色令牌.PrimaryFixedDim,
    主色固定上: Color = 浅色令牌.OnPrimaryFixed,
    主色固定变体上: Color = 浅色令牌.OnPrimaryFixedVariant,
    次色固定: Color = 浅色令牌.SecondaryFixed,
    次色固定暗淡: Color = 浅色令牌.SecondaryFixedDim,
    次色固定上: Color = 浅色令牌.OnSecondaryFixed,
    次色固定变体上: Color = 浅色令牌.OnSecondaryFixedVariant,
    第三色固定: Color = 浅色令牌.TertiaryFixed,
    第三色固定暗淡: Color = 浅色令牌.TertiaryFixedDim,
    第三色固定上: Color = 浅色令牌.OnTertiaryFixed,
    第三色固定变体上: Color = 浅色令牌.OnTertiaryFixedVariant,
): ColorScheme =
    lightColorScheme(
        primary = 主色,
        onPrimary = 主色上,
        primaryContainer = 主色容器,
        onPrimaryContainer = 主色容器上,
        inversePrimary = 反色主色,
        secondary = 次色,
        onSecondary = 次色上,
        secondaryContainer = 次色容器,
        onSecondaryContainer = 次色容器上,
        tertiary = 第三色,
        onTertiary = 第三色上,
        tertiaryContainer = 第三色容器,
        onTertiaryContainer = 第三色容器上,
        background = 背景色,
        onBackground = 背景色上,
        surface = 表面色,
        onSurface = 表面色上,
        surfaceVariant = 表面色变体,
        onSurfaceVariant = 表面色变体上,
        surfaceTint = 表面色色调,
        inverseSurface = 反色表面,
        inverseOnSurface = 反色表面上,
        error = 错误色,
        onError = 错误色上,
        errorContainer = 错误色容器,
        onErrorContainer = 错误色容器上,
        outline = 轮廓色,
        outlineVariant = 轮廓色变体,
        scrim = 遮罩色,
        surfaceBright = 表面色明亮,
        surfaceContainer = 表面色容器,
        surfaceContainerHigh = 表面色容器高亮,
        surfaceContainerHighest = 表面色容器最高,
        surfaceContainerLow = 表面色容器低,
        surfaceContainerLowest = 表面色容器最低,
        surfaceDim = 表面色暗淡,
        primaryFixed = 主色固定,
        primaryFixedDim = 主色固定暗淡,
        onPrimaryFixed = 主色固定上,
        onPrimaryFixedVariant = 主色固定变体上,
        secondaryFixed = 次色固定,
        secondaryFixedDim = 次色固定暗淡,
        onSecondaryFixed = 次色固定上,
        onSecondaryFixedVariant = 次色固定变体上,
        tertiaryFixed = 第三色固定,
        tertiaryFixedDim = 第三色固定暗淡,
        onTertiaryFixed = 第三色固定上,
        onTertiaryFixedVariant = 第三色固定变体上,
    )

/** 返回深色 Material 配色方案。 */
fun 深色颜色方案(
    主色: Color = 深色令牌.Primary,
    主色上: Color = 深色令牌.OnPrimary,
    主色容器: Color = 深色令牌.PrimaryContainer,
    主色容器上: Color = 深色令牌.OnPrimaryContainer,
    反色主色: Color = 深色令牌.InversePrimary,
    次色: Color = 深色令牌.Secondary,
    次色上: Color = 深色令牌.OnSecondary,
    次色容器: Color = 深色令牌.SecondaryContainer,
    次色容器上: Color = 深色令牌.OnSecondaryContainer,
    第三色: Color = 深色令牌.Tertiary,
    第三色上: Color = 深色令牌.OnTertiary,
    第三色容器: Color = 深色令牌.TertiaryContainer,
    第三色容器上: Color = 深色令牌.OnTertiaryContainer,
    背景色: Color = 深色令牌.Background,
    背景色上: Color = 深色令牌.OnBackground,
    表面色: Color = 深色令牌.Surface,
    表面色上: Color = 深色令牌.OnSurface,
    表面色变体: Color = 深色令牌.SurfaceVariant,
    表面色变体上: Color = 深色令牌.OnSurfaceVariant,
    表面色色调: Color = 主色,
    反色表面: Color = 深色令牌.InverseSurface,
    反色表面上: Color = 深色令牌.InverseOnSurface,
    错误色: Color = 深色令牌.Error,
    错误色上: Color = 深色令牌.OnError,
    错误色容器: Color = 深色令牌.ErrorContainer,
    错误色容器上: Color = 深色令牌.OnErrorContainer,
    轮廓色: Color = 深色令牌.Outline,
    轮廓色变体: Color = 深色令牌.OutlineVariant,
    遮罩色: Color = 深色令牌.Scrim,
    表面色明亮: Color = 深色令牌.SurfaceBright,
    表面色容器: Color = 深色令牌.SurfaceContainer,
    表面色容器高亮: Color = 深色令牌.SurfaceContainerHigh,
    表面色容器最高: Color = 深色令牌.SurfaceContainerHighest,
    表面色容器低: Color = 深色令牌.SurfaceContainerLow,
    表面色容器最低: Color = 深色令牌.SurfaceContainerLowest,
    表面色暗淡: Color = 深色令牌.SurfaceDim,
    主色固定: Color = 深色令牌.PrimaryFixed,
    主色固定暗淡: Color = 深色令牌.PrimaryFixedDim,
    主色固定上: Color = 深色令牌.OnPrimaryFixed,
    主色固定变体上: Color = 深色令牌.OnPrimaryFixedVariant,
    次色固定: Color = 深色令牌.SecondaryFixed,
    次色固定暗淡: Color = 深色令牌.SecondaryFixedDim,
    次色固定上: Color = 深色令牌.OnSecondaryFixed,
    次色固定变体上: Color = 深色令牌.OnSecondaryFixedVariant,
    第三色固定: Color = 深色令牌.TertiaryFixed,
    第三色固定暗淡: Color = 深色令牌.TertiaryFixedDim,
    第三色固定上: Color = 深色令牌.OnTertiaryFixed,
    第三色固定变体上: Color = 深色令牌.OnTertiaryFixedVariant,
): ColorScheme =
    darkColorScheme(
        primary = 主色,
        onPrimary = 主色上,
        primaryContainer = 主色容器,
        onPrimaryContainer = 主色容器上,
        inversePrimary = 反色主色,
        secondary = 次色,
        onSecondary = 次色上,
        secondaryContainer = 次色容器,
        onSecondaryContainer = 次色容器上,
        tertiary = 第三色,
        onTertiary = 第三色上,
        tertiaryContainer = 第三色容器,
        onTertiaryContainer = 第三色容器上,
        background = 背景色,
        onBackground = 背景色上,
        surface = 表面色,
        onSurface = 表面色上,
        surfaceVariant = 表面色变体,
        onSurfaceVariant = 表面色变体上,
        surfaceTint = 表面色色调,
        inverseSurface = 反色表面,
        inverseOnSurface = 反色表面上,
        error = 错误色,
        onError = 错误色上,
        errorContainer = 错误色容器,
        onErrorContainer = 错误色容器上,
        outline = 轮廓色,
        outlineVariant = 轮廓色变体,
        scrim = 遮罩色,
        surfaceBright = 表面色明亮,
        surfaceContainer = 表面色容器,
        surfaceContainerHigh = 表面色容器高亮,
        surfaceContainerHighest = 表面色容器最高,
        surfaceContainerLow = 表面色容器低,
        surfaceContainerLowest = 表面色容器最低,
        surfaceDim = 表面色暗淡,
        primaryFixed = 主色固定,
        primaryFixedDim = 主色固定暗淡,
        onPrimaryFixed = 主色固定上,
        onPrimaryFixedVariant = 主色固定变体上,
        secondaryFixed = 次色固定,
        secondaryFixedDim = 次色固定暗淡,
        onSecondaryFixed = 次色固定上,
        onSecondaryFixedVariant = 次色固定变体上,
        tertiaryFixed = 第三色固定,
        tertiaryFixedDim = 第三色固定暗淡,
        onTertiaryFixed = 第三色固定上,
        onTertiaryFixedVariant = 第三色固定变体上,
    )

/**
 * Material 颜色系统包含成对的颜色，通常用于组件内部的背景色和内容色。例如，[按钮] 通常使用 primary 作为背景色，
 * 使用 onPrimary 作为其内容（通常是文字或图标）的颜色。
 *
 * 此函数尝试将提供的 [背景颜色] 与此 [ColorScheme] 中的"背景"颜色进行匹配，然后返回用于内容的对应颜色。
 * 例如，当 [背景颜色] 为 [ColorScheme.primary] 时，将返回 [ColorScheme.onPrimary]。
 *
 * 如果 [背景颜色] 与主题中的背景色不匹配，则将返回 [Color.Unspecified]。
 *
 * @return [背景颜色] 对应的内容颜色。如果 [背景颜色] 不在主题的 [ColorScheme] 中，则返回 [Color.Unspecified]。
 * @see 内容颜色为
 */
@Stable
fun ColorScheme.内容颜色为(背景颜色: Color): Color =
    this.contentColorFor(背景颜色)

/**
 * Material 颜色系统包含成对的颜色，通常用于组件内部的背景色和内容色。例如，[按钮] 通常使用 primary 作为背景色，
 * 使用 onPrimary 作为其内容（通常是文字或图标）的颜色。
 *
 * 此函数尝试将提供的 [背景颜色] 与此 [ColorScheme] 中的"背景"颜色进行匹配，然后返回用于内容的对应颜色。例如，
 * 当 [背景颜色] 为 [ColorScheme.primary] 时，将返回 [ColorScheme.onPrimary]。
 *
 * 如果 [背景颜色] 与主题中的背景色不匹配，此方法将尽力返回 [LocalContentColor] 的当前值作为最佳近似颜色。
 *
 * @return [背景颜色] 对应的内容颜色。如果 [背景颜色] 不在主题的 [ColorScheme] 中，则返回 [LocalContentColor] 的当前值。
 * @see ColorScheme.内容颜色为
 */
@Composable
@ReadOnlyComposable
fun 内容颜色为(背景颜色: Color) = contentColorFor(背景颜色)

/**
 * 计算不同海拔级别的表面色调颜色，例如 surface1 到 surface5。
 *
 * @param 阴影 用于计算颜色叠加层透明度的海拔值。
 * @return 将 [ColorScheme.surfaceTint] 颜色以一定透明度叠加在 [ColorScheme.surface] 颜色之上所得到的颜色。
 */
@Stable
fun ColorScheme.表面颜色在阴影(阴影: Dp): Color =
    this.surfaceColorAtElevation(elevation = 阴影)


/**
 * 返回浅色 Material 配色方案。
 *
 * [材质表现主题] 的默认配色方案。深色模式请使用 [深色颜色方案]。
 *
 * `MaterialExpressiveTheme` 切换 `expressiveLightColorScheme` 和 `darkTheme` 的示例。
 */
@ExperimentalMaterial3ExpressiveApi
fun 表现性浅色颜色方案() = expressiveLightColorScheme()

/**
 * 用于检查 [ColorScheme.applyTonalElevation] 是否将应用于组合树下游的 Composition Local。
 *
 * 将此值设置为 `false` 将导致组合树中所有后续 `Surface` 不应用色调海拔效果。
 */
val 本地色调阴影已启用 = LocalTonalElevationEnabled
