package 安卓x.组合.基础

import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.semantics.Role


/**
 * 配置组件以通过输入或无障碍“点击”事件接收点击。
 *
 * 将此修饰符添加到元素上，使其在其边界内可点击，并在被按下时显示默认的按下指示效果。
 *
 * 此重载将使用来自 [LocalIndication] 的 [Indication]。如需显式提供 [Indication] 实例，请使用另一个重载。请注意，
 * 此重载仅支持通过 [LocalIndication] 提供的 [IndicationNodeFactory] 实例——强烈建议迁移到 [IndicationNodeFactory]，
 * 但如果仍需支持非 [IndicationNodeFactory] 的 [Indication] 实例，可以使用另一个重载。
 *
 * 如果 [交互源] 为 null，则仅在需要时惰性创建内部的 [MutableInteractionSource]。这降低了组合期间 clickable
 * 的性能开销，因为 [indication] 的创建可以延迟到有新的 [androidx.compose.foundation.interaction.Interaction]
 * 传入时再进行。如果你只是传入一个记住的 [MutableInteractionSource] 且从未在 clickable 外部使用它，建议改为提供 null
 * 以启用惰性创建。如果你需要 [Indication] 被立即创建，请提供一个记住的 [MutableInteractionSource]。
 *
 * 如果你需要同时支持双击或长按与单击，请考虑使用 [combinedClickable]。
 *
 * 注意：从 clickable 中对 Android View 执行任何移除操作时，应将 `单击回调` 包装在 post { } 代码块中，以确保事件分发在
 * 移除操作执行前完成。（移除可组合项时无需这样做，因为 Compose 会通过快照状态系统保证其完成。）
 *
 * @param 已启用 控制启用状态。当为 `false` 时，[单击回调] 将被禁用，且此修饰符对无障碍服务将呈现为禁用状态。
 * @param 单击标签回调 [单击回调] 操作的语义 / 无障碍标签
 * @param 角色 用户界面元素的类型。无障碍服务可能会使用此信息来描述该元素或进行自定义处理。
 * @param 交互源 用于在此可点击项被按下时分发 [PressInteraction.Press] 的 [MutableInteractionSource]。
 * 如果为 `null`，则在需要时内部会创建一个 [MutableInteractionSource]。
 * @param 单击回调 当用户点击该元素时将被调用。
 */
fun Modifier.可单击(
    已启用: Boolean = true,
    单击标签回调: String? = null,
    角色: Role? = null,
    交互源: MutableInteractionSource? = null,
    单击回调: () -> Unit,
): Modifier =
    this.clickable(
        enabled = 已启用,
        onClickLabel = 单击标签回调,
        role = 角色,
        interactionSource = 交互源,
        onClick = 单击回调,
    )


/**
 * 配置组件以通过输入或无障碍"点击"事件接收点击。
 *
 * 将此修饰符添加到元素上，使其在其边界内可点击，并按 [indication] 参数指定的效果显示按下指示。
 *
 * 如果 [交互源] 为 `null`，且 [indication] 是 [IndicationNodeFactory]，则仅在需要时惰性创建内部的
 * [MutableInteractionSource] 和 [indication]。这降低了组合期间 `可单击` 的性能开销，因为 [indication]
 * 的创建可以延迟到有新的 [androidx.compose.foundation.interaction.Interaction] 传入时再进行。如果你只是传入一个记住的
 * [MutableInteractionSource] 且从未在 `可单击` 外部使用它，建议改为提供 `null` 以启用惰性创建。如果你需要
 * [indication] 被立即创建，请提供一个记住的 [MutableInteractionSource]。
 *
 * 如果 [indication] **不是** [IndicationNodeFactory]，而是实现了已弃用的 [Indication.rememberUpdatedInstance]
 * 方法，则应显式传入一个记住的 [MutableInteractionSource] 作为 [交互源] 的参数，而不是传入 `null`，
 * 因为这种情况无法在 `可单击` 内部惰性创建。
 *
 * 如果你需要同时支持双击或长按与单击，请考虑使用 [组合可单击]。
 *
 * **注意**：从 `可单击` 中对 Android View 执行任何移除操作时，应将 `单击回调` 包装在 `post { }` 代码块中，
 * 以确保事件分发在移除操作执行前完成。（移除可组合项时无需这样做，因为 Compose 会通过快照状态系统保证其完成。）
 *
 * @param 交互源 用于在此可点击项被按下时分发 [PressInteraction.Press] 的 [MutableInteractionSource]。
 * 如果为 `null`，则在需要时内部会创建一个 [MutableInteractionSource]。
 * @param 指示效果 在修改后的元素被按下时显示的指示效果。默认情况下，将使用来自 [LocalIndication] 的指示效果。
 * 传入 `null` 表示不显示任何指示效果，或传入 [LocalIndication] 的当前值以显示主题默认效果。
 * @param 已启用 控制启用状态。当为 `false` 时，[单击回调] 将被禁用，且此修饰符对无障碍服务将呈现为禁用状态。
 * @param 单击标签回调 [单击回调] 操作的语义 / 无障碍标签
 * @param 角色 用户界面元素的类型。无障碍服务可能会使用此信息来描述该元素或进行自定义处理。
 * @param 单击回调 当用户点击该元素时将被调用。
 */
fun Modifier.可单击(
    交互源: MutableInteractionSource?,
    指示效果: Indication?,
    已启用: Boolean = true,
    单击标签回调: String? = null,
    角色: Role? = null,
    单击回调: () -> Unit,
) =
    this.clickable(
        interactionSource = 交互源,
        indication = 指示效果,
        enabled = 已启用,
        onClickLabel = 单击标签回调,
        role = 角色,
        onClick = 单击回调,
    )



/**
 * 配置组件以通过输入或无障碍"点击"事件接收单击、双击和长按。
 *
 * 将此修饰符添加到元素上，使其在其边界内可点击。
 *
 * 如果你只需要处理单击，而不需要双击或长按，请考虑使用 [可单击]。
 *
 * 此重载将使用来自 [LocalIndication] 的 [Indication]。如需显式提供 [Indication] 实例，请使用另一个重载。请注意，
 * 此重载仅支持通过 [LocalIndication] 提供的 [IndicationNodeFactory] 实例——强烈建议迁移到 [IndicationNodeFactory]，
 * 但如果仍需支持非 [IndicationNodeFactory] 的 [Indication] 实例，可以使用另一个重载。
 *
 * 如果 [交互源] 为 null，则仅在需要时惰性创建内部的 [MutableInteractionSource]。这降低了组合期间 组合可单击
 * 的性能开销，因为 [indication] 的创建可以延迟到有新的 [androidx.compose.foundation.interaction.Interaction]
 * 传入时再进行。如果你只是传入一个记住的 [MutableInteractionSource] 且从未在 组合可单击 外部使用它，
 * 建议改为提供 null 以启用惰性创建。如果你需要 [Indication] 被立即创建，请提供一个记住的 [MutableInteractionSource]。
 *
 * 注意，如果修饰符实例在按键按下和按键释放事件之间被复用，则正在进行的输入将被中断。
 *
 * **注意**：从 `可单击` 中对 Android View 执行任何移除操作时，应将 `单击回调` 包装在 `post { }` 代码块中，
 * 以确保事件分发在移除操作执行前完成。（移除可组合项时无需这样做，因为 Compose 会通过快照状态系统保证其完成。）
 *
 * @param 已启用 控制启用状态。当为 false 时，[单击回调]、[长按单击回调] 和 [双击单击回调] 将不会被调用。
 * @param 单击标签回调 [单击回调] 操作的语义 / 无障碍标签
 * @param 角色 用户界面元素的类型。无障碍服务可能会使用此信息来描述该元素或进行自定义处理。
 * @param 长按单击标签回调 [长按单击回调] 操作的语义 / 无障碍标签
 * @param 长按单击回调 当用户长按该元素时将被调用。
 * @param 双击单击回调 当用户双击该元素时将被调用。
 * @param 触觉反馈已启用 是否使用默认的 [HapticFeedback] 行为
 * @param 交互源 用于在此可点击项被按下时分发 [PressInteraction.Press] 的 [MutableInteractionSource]。
 * 如果为 null，则在需要时内部会创建一个 [MutableInteractionSource]。
 * @param 单击回调 当用户点击该元素时将被调用。
 */
fun Modifier.组合可单击(
    已启用: Boolean = true,
    单击标签回调: String? = null,
    角色: Role? = null,
    长按单击标签回调: String? = null,
    长按单击回调: (() -> Unit)? = null,
    双击单击回调: (() -> Unit)? = null,
    触觉反馈已启用: Boolean = true,
    交互源: MutableInteractionSource? = null,
    单击回调: () -> Unit,
): Modifier =
    this.combinedClickable(
        enabled = 已启用,
        onClickLabel = 单击标签回调,
        role = 角色,
        onLongClickLabel = 长按单击标签回调,
        onLongClick = 长按单击回调,
        onDoubleClick = 双击单击回调,
        hapticFeedbackEnabled = 触觉反馈已启用,
        interactionSource = 交互源,
        onClick = 单击回调,
    )


/**
 * 配置组件以通过输入或无障碍"点击"事件接收单击、双击和长按。
 *
 * 将此修饰符添加到元素上，使其在其边界内可点击。
 *
 * 如果你只需要处理单击，而不需要双击或长按，请考虑使用 [可单击]。
 *
 * 将此修饰符添加到元素上，使其在其边界内可点击。
 *
 * 如果 [交互源] 为 `null`，且 [indication] 是 [IndicationNodeFactory]，则仅在需要时惰性创建内部的
 * [MutableInteractionSource] 和 [indication]。这降低了组合期间 `可单击` 的性能开销，因为 [indication]
 * 的创建可以延迟到有新的 [androidx.compose.foundation.interaction.Interaction] 传入时再进行。如果你只是传入一个
 * 记住的 [MutableInteractionSource] 且从未在 `可单击` 外部使用它，建议改为提供 `null` 以启用惰性创建。如果你需要
 * [indication] 被立即创建，请提供一个记住的 [MutableInteractionSource]。
 *
 * 如果 [indication] **不是** [IndicationNodeFactory]，而是实现了已弃用的 [Indication.rememberUpdatedInstance]
 * 方法，则应显式传入一个记住的 [MutableInteractionSource] 作为 [交互源] 的参数，而不是传入 `null`，
 * 因为这种情况无法在 `可单击` 内部惰性创建。
 *
 * 注意，如果修饰符实例在按键按下和按键释放事件之间被复用，则正在进行的输入将被中断。
 *
 * **注意**：从 `可单击` 中对 Android View 执行任何移除操作时，应将 `单击回调` 包装在 `post { }` 代码块中，
 * 以确保事件分发在移除操作执行前完成。（移除可组合项时无需这样做，因为 Compose 会通过快照状态系统保证其完成。）
 *
 * @param 交互源 用于在此可点击项被按下时发出 [PressInteraction.Press] 的 [MutableInteractionSource]。
 * 如果为 `null`，则在需要时内部会创建一个 [MutableInteractionSource]。
 * @param 指示效果 在修改后的元素被按下时显示的指示效果。默认情况下，将使用来自 [LocalIndication] 的指示效果。
 * 传入 `null` 表示不显示任何指示效果，或传入 [LocalIndication] 的当前值以显示主题默认效果。
 * @param 已启用 控制启用状态。当为 `false` 时，[单击回调]、[长按单击回调] 和 [双击单击回调] 将不会被调用。
 * @param 单击标签回调 [单击回调] 操作的语义 / 无障碍标签
 * @param 角色 用户界面元素的类型。无障碍服务可能会使用此信息来描述该元素或进行自定义处理。
 * @param 长按单击标签回调 [长按单击回调] 操作的语义 / 无障碍标签
 * @param 长按单击回调 当用户长按该元素时将被调用。
 * @param 双击单击回调 当用户双击该元素时将被调用。
 * @param 触觉反馈已启用 是否使用默认的 [HapticFeedback] 行为
 * @param 单击回调 当用户点击该元素时将被调用。
 */
fun Modifier.组合可单击(
    交互源: MutableInteractionSource?,
    指示效果: Indication?,
    已启用: Boolean = true,
    单击标签回调: String? = null,
    角色: Role? = null,
    长按单击标签回调: String? = null,
    长按单击回调: (() -> Unit)? = null,
    双击单击回调: (() -> Unit)? = null,
    触觉反馈已启用: Boolean = true,
    单击回调: () -> Unit,
) =
    this.combinedClickable(
        interactionSource = 交互源,
        indication = 指示效果,
        enabled = 已启用,
        onClickLabel = 单击标签回调,
        role = 角色,
        onLongClickLabel = 长按单击标签回调,
        onLongClick = 长按单击回调,
        onDoubleClick = 双击单击回调,
        hapticFeedbackEnabled = 触觉反馈已启用,
        onClick = 单击回调,
    )


