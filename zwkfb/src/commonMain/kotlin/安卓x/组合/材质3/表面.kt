package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// TODO(b/197880751): 在 Material.io 规范中添加网址。
/**
 * 材质表面（Material 表面）是 Material Design 的核心隐喻。每个表面存在于特定的高度（elevation）上，
 * 这决定了该表面与其他表面的视觉关系，以及色调变化对该表面的影响方式。
 *
 * 有关可点击、可选中和可切换的表面，请参见其他重载方法。
 *
 * 表面 负责：
 * 1) 裁剪：表面 将其子项裁剪为 [形状] 指定的形状。
 * 2) 边框：如果 [形状] 带有边框，则也会绘制该边框。
 * 3) 背景：表面 使用 [颜色] 填充 [形状] 指定的形状。如果 [颜色] 为 [ColorScheme.surface]，
 *   则会应用颜色叠加层。叠加层的颜色取决于此 表面 的 [色调阴影]，以及由任何父级 表面
 *   设置的 [LocalAbsoluteTonalElevation]。通过对所有先前 表面 的高度进行累加，确保 表面 的叠加层高度永远不会低于其祖先。
 * 4) 内容颜色：表面 使用 [内容颜色] 指定此表面内容的首选颜色——[文本] 和 [Icon] 组件会将其作为默认颜色使用。
 *
 * 如果未设置 [内容颜色]，此 表面 将尝试将其背景颜色与主题 [ColorScheme] 中定义的颜色进行匹配，并返回相应的内容颜色。
 * 例如，如果此 表面 的 [颜色] 为 [ColorScheme.surface]，则 [内容颜色] 将被设置为 [ColorScheme.onSurface]。
 * 如果 [颜色] 不属于主题调色板，[内容颜色] 将保持此 表面 上方设置的相同值。
 *
 * 要手动获取 表面 内部的内容颜色，请使用 [LocalContentColor]。
 * 5) 阻止触摸事件向 表面 后方传播。
 *
 * @param 修饰符 要应用于与 表面 对应的布局的 Modifier。
 * @param 形状 定义表面的形状及其阴影。
 * @param 颜色 背景颜色。使用 [Color.Transparent] 可设为无颜色。
 * @param 内容颜色 此 表面 提供给其子项的首选内容颜色。默认为 [颜色] 对应的匹配内容颜色，如果 [颜色] 不是主题中的颜色，
 * 则将保持此 表面 上方设置的相同值。
 * @param 色调阴影 当 [颜色] 为 [ColorScheme.surface] 时，高度越高，在浅色主题下颜色越深，在深色主题下颜色越浅。
 * @param 视觉阴影 表面下方阴影的大小。为防止阴影蔓延，仅在绝对必要时才应用阴影高度，例如当表面需要与带有图案的背景进行视觉分离时。
 * 请注意，这不会影响 表面 的 z 轴索引。如需更改绘制顺序，可使用 `Modifier.zIndex`。
 * @param 边框 绘制在表面顶部的可选边框。
 * @param 内容 要显示在此 表面 上的内容。
 */
@Suppress("ComposableNaming")
@Composable
@NonRestartableComposable
fun 表面(
    修饰符: Modifier = Modifier,
    形状: Shape = RectangleShape,
    颜色: Color = MaterialTheme.colorScheme.surface,
    内容颜色: Color = contentColorFor(颜色),
    色调阴影: Dp = 0.dp,
    视觉阴影: Dp = 0.dp,
    边框: BorderStroke? = null,
    内容: @Composable () -> Unit,
) {
    Surface(
        modifier = 修饰符,
        shape = 形状,
        color = 颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        content = 内容,
    )
}

/**
 * 材质表面（Material 表面）是 Material Design 的核心隐喻。每个表面存在于特定的高度（elevation）上，
 * 这决定了该表面与其他表面的视觉关系，以及色调变化对该表面的影响方式。
 *
 * 此版本的 表面 除了负责常规 表面 的所有功能外，还负责点击处理：
 *
 * 此可点击 表面 负责：
 * 1) **裁剪**：表面 将其子项裁剪为 [形状] 指定的形状。
 * 2) **边框**：如果 [形状] 带有边框，则也会绘制该边框。
 * 3) **背景**：表面 使用 [颜色] 填充 [形状] 指定的形状。如果 [颜色] 为 [ColorScheme.surface]，可能会应用颜色叠加层。
 * 叠加层的颜色取决于此 表面 的 [色调阴影]，以及由任何父级 表面 设置的 [LocalAbsoluteTonalElevation]。
 * 通过对所有先前 表面 的高度进行累加，确保 表面 的叠加层高度永远不会低于其祖先。
 * 4) **内容颜色**：表面 使用 [内容颜色] 指定此表面内容的首选颜色——[文本] 和 [Icon] 组件会将其作为默认颜色使用。
 * 如果未设置 [内容颜色]，此 表面 将尝试将其背景颜色与主题 [ColorScheme] 中定义的颜色进行匹配，并返回相应的内容颜色。例如，
 * 如果此 表面 的 [颜色] 为 [ColorScheme.surface]，则 [内容颜色] 将被设置为 [ColorScheme.onSurface]。如果 [颜色]
 * 不属于主题调色板，[内容颜色] 将保持此 表面 上方设置的相同值。
 * 5) **点击处理**。此版本的 表面 会响应点击，调用 [单击回调] lambda，在发生 [androidx.compose.foundation.interaction.PressInteraction]
 * 时更新 [交互源]，并显示涟漪效果以响应按下事件。如果不需要点击处理，请考虑使用不需要 [单击回调] 参数的 表面 函数。
 * 如果需要为 [单击回调] 设置自定义标签，请对 表面 应用 `Modifier.semantics { onClick(label = "YOUR_LABEL", action = null) }`。
 * 6) **点击语义**。与 [Modifier.clickable] 一样，可点击版本的 表面 将生成语义以表明它可被点击。默认不设置语义角色，
 * 您可以通过 [Modifier.semantics] 传递所需的 [androidx.compose.ui.semantics.Role] 来指定。
 *
 * 要手动获取 表面 内部的内容颜色，请使用 [LocalContentColor]。
 *
 * @param 单击回调 表面 被点击时要调用的回调。
 * @param 修饰符 要应用于与 表面 对应的布局的 Modifier。
 * @param 已启用 控制 表面 的启用状态。当为 `false` 时，此 Surface 将不可点击。
 * @param 形状 定义表面的形状及其阴影。仅当 [色调阴影] 大于零时才会显示阴影。
 * @param 颜色 背景颜色。使用 [Color.Transparent] 可设为无颜色。
 * @param 内容颜色 此 表面 提供给其子项的首选内容颜色。默认为 [颜色] 对应的匹配内容颜色，如果 [颜色] 不是主题中的颜色，
 * 则将保持此 表面 上方设置的相同值。
 * @param 边框 绘制在表面顶部的可选边框。
 * @param 色调阴影 当 [颜色] 为 [ColorScheme.surface] 时，高度越高，在浅色主题下颜色越深，在深色主题下颜色越浅。
 * @param 视觉阴影 表面下方阴影的大小。请注意，这不会影响 表面 的 z 轴索引。如需更改绘制顺序，可使用 `Modifier.zIndex`。
 * @param 交互源 用于观察和发送此 表面 的 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改 表面 的外观或在不同状态下预览 表面。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 要显示在此 表面 上的内容。
 */
@Suppress("ComposableNaming")
@Composable
@NonRestartableComposable
fun 表面(
    单击回调: () -> Unit,
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
    Surface(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        color = 颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * 材质表面（Material 表面）是 Material Design 的核心隐喻。每个表面存在于特定的高度（elevation）上，
 * 这决定了该表面与其他表面的视觉关系，以及色调变化对该表面的影响方式。
 *
 * 此版本的 表面 除了负责常规 表面 的所有功能外，还负责选择处理：
 *
 * 此可选中 表面 负责：
 * 1) **裁剪**：表面 将其子项裁剪为 [形状] 指定的形状。
 * 2) **边框**：如果 [形状] 带有边框，则也会绘制该边框。
 * 3) **背景**：表面 使用 [颜色] 填充 [形状] 指定的形状。如果 [颜色] 为 [ColorScheme.surface]，可能会应用颜色叠加层。
 * 叠加层的颜色取决于此 表面 的 [色调阴影]，以及由任何父级 表面 设置的 [LocalAbsoluteTonalElevation]。
 * 通过对所有先前 表面 的高度进行累加，确保 表面 的叠加层高度永远不会低于其祖先。
 * 4) **内容颜色**：表面 使用 [内容颜色] 指定此表面内容的首选颜色——[文本] 和 [Icon] 组件会将其作为默认颜色使用。如果未设置
 * [内容颜色]，此 表面 将尝试将其背景颜色与主题 [ColorScheme] 中定义的颜色进行匹配，并返回相应的内容颜色。例如，如果此 表面
 * 的 [颜色] 为 [ColorScheme.surface]，则 [内容颜色] 将被设置为 [ColorScheme.onSurface]。如果 [颜色] 不属于主题调色板，
 * [内容颜色] 将保持此 表面 上方设置的相同值。
 * 5) **点击处理**。此版本的 表面 会响应点击，调用 [单击回调] lambda，在发生 [androidx.compose.foundation.interaction.PressInteraction]
 * 时更新 [交互源]，并显示涟漪效果以响应按下事件。如果不需要点击处理，请考虑使用不需要 [单击回调] 参数的 表面 函数。
 * 6) **选择语义**。与 [Modifier.selectable] 一样，可选中版本的 表面 将生成语义以表明它已被选中。默认不设置语义角色，您可以通过
 * [Modifier.semantics] 传递所需的 [androidx.compose.ui.semantics.Role] 来指定。
 *
 * 要手动获取 表面 内部的内容颜色，请使用 [LocalContentColor]。
 *
 * @param 已选择 此 表面 是否被选中。
 * @param 单击回调 表面 被点击时要调用的回调。
 * @param 修饰符 要应用于与 表面 对应的布局的 Modifier。
 * @param 已启用 定义表面的形状及其阴影。当为 `false` 时，此 表面 将不可点击。
 * @param 形状 定义表面的形状及其阴影。仅当 [色调阴影] 大于零时才会显示阴影。
 * @param 颜色 背景颜色。使用 [Color.Transparent] 可设为无颜色。
 * @param 内容颜色 此 表面 提供给其子项的首选内容颜色。默认为 [颜色] 对应的匹配内容颜色，如果 [颜色] 不是主题中的颜色，
 * 则将保持此 表面 上方设置的相同值。
 * @param 边框 绘制在表面顶部的可选边框。
 * @param 色调阴影 当 [颜色] 为 [ColorScheme.surface] 时，高度越高，在浅色主题下颜色越深，在深色主题下颜色越浅。
 * @param 视觉阴影 表面下方阴影的大小。请注意，这不会影响 表面 的 z 轴索引。如需更改绘制顺序，可使用 `Modifier.zIndex`。
 * @param 交互源 用于观察和发送此 表面 的 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改 表面 的外观或在不同状态下预览 表面。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 要显示在此 表面 上的内容。
 */
@Suppress("ComposableNaming")
@Composable
@NonRestartableComposable
fun 表面(
    已选择: Boolean,
    单击回调: () -> Unit,
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
    Surface(
        selected = 已选择,
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        color = 颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * 材质表面（Material surface）是 Material Design 的核心隐喻。每个表面存在于特定的高度（elevation）上，
 * 这决定了该表面与其他表面的视觉关系，以及色调变化对该表面的影响方式。
 *
 * 此版本的 表面 除了负责常规 表面 的所有功能外，还负责切换其选中状态：
 *
 * 此可切换 表面 负责：
 * 1) 裁剪：表面 将其子项裁剪为 [形状] 指定的形状。
 * 2) 边框：如果 [形状] 带有边框，则也会绘制该边框。
 * 3) 背景：表面 使用 [颜色] 填充 [形状] 指定的形状。如果 [颜色] 为 [ColorScheme.surface]，可能会应用颜色叠加层。
 * 叠加层的颜色取决于此 表面 的 [色调阴影]，以及由任何父级 表面 设置的 [LocalAbsoluteTonalElevation]。
 * 通过对所有先前 表面 的高度进行累加，确保 表面 的叠加层高度永远不会低于其祖先。
 * 4) 内容颜色：表面 使用 [内容颜色] 指定此表面内容的首选颜色——[文本] 和 [Icon] 组件会将其作为默认颜色使用。如果未设置
 * [内容颜色]，此 表面 将尝试将其背景颜色与主题 [ColorScheme] 中定义的颜色进行匹配，并返回相应的内容颜色。例如，如果此 表面
 * 的 [颜色] 为 [ColorScheme.surface]，则 [内容颜色] 将被设置为 [ColorScheme.onSurface]。如果 [颜色] 不属于主题调色板，
 * [内容颜色] 将保持此 表面 上方设置的相同值。
 * 5) 点击处理。此版本的 表面 会响应选中状态切换，调用 [已选中改变回调] lambda，在发生 [androidx.compose.foundation.interaction.PressInteraction]
 * 时更新 [交互源]，并显示涟漪效果以响应按下事件。如果不需要选中状态处理，请考虑使用不需要 [已选中改变回调] 参数的 表面 函数。
 * 6) 切换语义。与 [Modifier.toggleable] 一样，可切换版本的 表面 将生成语义以表明它已被选中。默认不设置语义角色，您可以通过 [Modifier.semantics]
 * 传递所需的 [androidx.compose.ui.semantics.Role] 来指定。
 *
 * 要手动获取 表面 内部的内容颜色，请使用 [LocalContentColor]。
 *
 * @param 已选中 此 表面 是否已开启或关闭。
 * @param 已选中改变回调 可切换 表面 被点击时要调用的回调。
 * @param 修饰符 要应用于与 表面 对应的布局的 Modifier。
 * @param 已启用 控制 表面 的启用状态。当为 `false` 时，此 表面 将不可点击。
 * @param 形状 定义表面的形状及其阴影。仅当 [色调阴影] 大于零时才会显示阴影。
 * @param 颜色 背景颜色。使用 [Color.Transparent] 可设为无颜色。
 * @param 内容颜色 此 表面 提供给其子项的首选内容颜色。默认为 [颜色] 对应的匹配内容颜色，如果 [颜色] 不是主题中的颜色，
 * 则将保持此 表面 上方设置的相同值。
 * @param 边框 绘制在表面顶部的可选边框。
 * @param 色调阴影 当 [颜色] 为 [ColorScheme.surface] 时，高度越高，在浅色主题下颜色越深，在深色主题下颜色越浅。
 * @param 视觉阴影 表面下方阴影的大小。请注意，这不会影响 表面 的 z 轴索引。如需更改绘制顺序，可使用 `Modifier.zIndex`。
 * @param 交互源 用于观察和发送此 表面 的 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改 表面 的外观或在不同状态下预览 表面。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 要显示在此 表面 上的内容。
 */
@Suppress("ComposableNaming")
@Composable
@NonRestartableComposable
fun 表面(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
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
    Surface(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        color = 颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )
}


/** 包含由 [表面] 组件提供的当前绝对高度的 CompositionLocal。该绝对高度是所有先前高度的总和。绝对高度仅用于计算表面色调颜色，*不*用于在 [表面] 中绘制阴影。*/
// TODO(b/179787782): 在 AOSP 中收录目录应用后添加示例。
val 本地绝对色调阴影 = LocalAbsoluteTonalElevation
