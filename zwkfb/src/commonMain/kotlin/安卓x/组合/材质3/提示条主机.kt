package 安卓x.组合.材质3

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier



/**
 * [提示条主机] 的状态，用于控制队列以及当前在 [提示条主机] 中显示的 [Snackbar]。
 *
 * 此状态通常使用 [remember] 进行记忆，并用于向 [脚手架] 提供 [提示条主机]。
 */
@Stable
fun 提示条主机状态() = SnackbarHostState()

//===================================================================================

/** 当前由 [提示条主机] 显示的 [SnackbarData]，如果没有则返回 null。 */
val SnackbarHostState.当前提示条数据
    get() = this.currentSnackbarData


/**
 * 在附加了此状态的 [脚手架] 底部显示或排队显示一个 [Snackbar]，并挂起直到提示条消失。
 *
 * [SnackbarHostState] 保证一次最多显示一个提示条。如果在另一个提示条已经可见时调用此函数，它将被挂起，直到该提示条显示并随后被处理。
 * 如果调用者被取消，提示条将从显示中移除和/或从待显示队列中移除。
 *
 * 所有这些功能允许从内部对提示条队列进行细粒度控制：
 *
 * @param 消息 要在提示条中显示的文本。
 * @param 操作标签 可选的操作标签，作为按钮显示在提示条中
 * @param 带有关闭操作 一个布尔值，用于在提示条中显示关闭操作。为了获得更好的无障碍性，当提示条设置为 [SnackbarDuration.Indefinite]
 * 时，建议将此值设置为 true。
 * @param 持续时间 用于控制提示条在 [提示条主机] 中显示时长的持续时间，可以是 [SnackbarDuration.Short]、[SnackbarDuration.Long]
 * 或 [SnackbarDuration.Indefinite]。
 * @return [SnackbarResult.ActionPerformed] 如果选项操作被点击，则返回 [SnackbarResult.ActionPerformed]；
 * 如果提示条因超时或被用户关闭，则返回 [SnackbarResult.Dismissed]。
 */
suspend fun SnackbarHostState.显示提示条(
    消息: String,
    操作标签: String? = null,
    带有关闭操作: Boolean = false,
    持续时间: SnackbarDuration = if (操作标签 == null) SnackbarDuration.Short else SnackbarDuration.Indefinite,
): SnackbarResult =
    this.showSnackbar(
        message = 消息,
        actionLabel = 操作标签,
        withDismissAction = 带有关闭操作,
        duration = 持续时间
    )


/**
 * 在附加了此状态的 [脚手架] 底部显示或排队显示一个 [Snackbar]，并挂起直到提示条消失。
 *
 * [SnackbarHostState] 保证一次最多显示一个提示条。如果在另一个提示条已经可见时调用此函数，它将被挂起，直到该提示条显示并随后被处理。
 * 如果调用者被取消，提示条将从显示中移除和/或从待显示队列中移除。
 *
 * 所有这些功能允许从内部对提示条队列进行细粒度控制：
 *
 * @param 视觉效果 用于创建提示条的 [SnackbarVisuals]。
 * @return [SnackbarResult.ActionPerformed] 如果选项操作被点击，则返回 [SnackbarResult.ActionPerformed]；
 * 如果提示条因超时或被用户关闭，则返回 [SnackbarResult.Dismissed]。
 */
suspend fun SnackbarHostState.显示提示条(视觉效果: SnackbarVisuals): SnackbarResult =
    this.showSnackbar(visuals = 视觉效果)

//===================================================================================


/**
 * 用于 [脚手架] 中 [Snackbar] 的主机，以便根据 Material Design 规范和 [主机状态] 正确地显示、隐藏和移除项目。
 *
 * 此组件使用默认参数时已内置于 [脚手架] 中，如果您需要显示默认的 [Snackbar]，请使用 [SnackbarHostState.showSnackbar]。
 *
 * @param 主机状态 此组件的状态用于读取并相应地显示 [Snackbar]。
 * @param 修饰符 要应用于此组件的 [Modifier]。
 * @param 提示条 要在适当时机显示的 [Snackbar] 实例，其外观基于作为参数提供的 [SnackbarData]。
 */
@Suppress("ComposableNaming")
@Composable
fun 提示条主机(
    主机状态: SnackbarHostState,
    修饰符: Modifier = Modifier,
    提示条: @Composable (SnackbarData) -> Unit = { Snackbar(it) },
) =
    SnackbarHost(
        hostState = 主机状态,
        modifier = 修饰符,
        snackbar = 提示条,
    )

/**
 * 表示特定 [Snackbar] 视觉效果的接口，作为 [SnackbarData] 的一部分。
 *
 * @property 消息 要在 Snackbar 中显示的文本。
 * @property 操作标签 可选的操作标签，显示为 Snackbar 中的按钮。
 * @property 带关闭操作 一个布尔值，用于在 Snackbar 中显示关闭操作。当 Snackbar 设置为
 * [SnackbarDuration.Indefinite] 时，建议将其设为 true 以获得更好的无障碍体验。
 * @property 持续时间 Snackbar 的持续时间。
 */
@Stable
interface 提示条视觉效果 { // SnackbarVisuals
    val 消息: String // message
    val 操作标签: String? // actionLabel
    val 带关闭操作: Boolean // withDismissAction
    val 持续时间: SnackbarDuration // duration
}

//===================================================================================

val SnackbarVisuals.消息: String
    get() = this.message

val SnackbarVisuals.操作标签: String?
    get() = this.actionLabel

val SnackbarVisuals.带关闭操作: Boolean
    get() = this.withDismissAction

val SnackbarVisuals.持续时间: SnackbarDuration
    get() = this.duration

//===================================================================================

/**
 * 表示特定 [Snackbar] 数据的接口，作为 [SnackbarHostState] 的一部分。
 *
 * @property 视觉效果 保存特定 [Snackbar] 的视觉表现。
 */
@Stable
interface 提示条数据 { // SnackbarData

    val 视觉效果: SnackbarVisuals

    /** 当 提示条 操作被执行时调用的函数，用于通知监听器。 */
    fun 执行操作()

    /** 当 提示条 因超时或用户操作而被关闭时调用的函数。 */
    fun 关闭()

}

//===================================================================================

val SnackbarData.视觉效果: SnackbarVisuals
    get() = this.visuals

/** 当 提示条 操作被执行时调用的函数，用于通知监听器。 */
fun SnackbarData.执行操作() = this.performAction()

/** 当 提示条 因超时或用户操作而被关闭时调用的函数。 */
fun SnackbarData.关闭() = this.dismiss()

//===================================================================================


/** [SnackbarHostState.showSnackbar] 调用的可能结果。 */
object 提示条结果 { // SnackbarResult

    /** [Snackbar] 因为超时或被用户关闭而被移除 */
    val 已关闭 = SnackbarResult.Dismissed

    /** 在超时之前点击了 [Snackbar] 上的操作按钮。*/
    val 操作已执行 = SnackbarResult.ActionPerformed

}


/** [SnackbarHost] 中 [Snackbar] 的可能持续时间。 */
object 提示条持续时间 { // SnackbarDuration

    /** 短时间显示提示条。*/
    val 短 = SnackbarDuration.Short

    /** 长时间显示提示条。 */
    val 长 = SnackbarDuration.Long

    /** 无限期显示提示条，直到显式关闭或点击操作按钮。 */
    val 无限期 = SnackbarDuration.Indefinite

}


