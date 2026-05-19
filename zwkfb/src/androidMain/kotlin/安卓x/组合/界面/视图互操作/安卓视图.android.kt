package 安卓x.组合.界面.视图互操作

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReusableContentHost
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.viewinterop.NoOpUpdate
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner

/**
 * 通过 [工厂] 获取一个 Android [View] 并进行组合。[工厂] 代码块只会被调用**恰好一次**来获取要组合的 [View]，并且保证在 UI 线程上调用。
 * 因此，除了创建 [View] 之外，[工厂] 代码块还可用于执行一次性初始化以及设置 [View] 的常量属性。[更新] 代码块可以运行多次（同样在 UI 线程上），
 * 这是由于重组（recomposition）导致的，它是设置新属性的正确位置。请注意，该代码块也会在 [工厂] 代码块完成后**立即运行一次**。
 *
 * [安卓视图] 通常用于那些**无法在 Compose 中重新实现**、且**没有对应 Compose API** 的 View。目前常见的例子包括 WebView、SurfaceView、AdView 等。
 *
 * 此重载版本的 [安卓视图] 不会自动对 View 进行池化或复用。如果将其放置在可复用的容器内部（包括 [LazyRow][androidx.compose.foundation.lazy.LazyRow]
 * 或 [LazyColumn][androidx.compose.foundation.lazy.LazyColumn] 内部），即使其组结构未发生变化且该 View 理论上可以被复用，
 * 只要包含该 AndroidView 的组合层级结构发生变化，View 实例也始终会被丢弃并重新创建。
 *
 * 要启用 View 复用，请调用接受 `onReset` 回调的 [安卓视图] 重载版本，并为该回调提供非空实现。由于丢弃并重新创建 View 实例的开销较大，
 * 复用 View 能够带来显著的性能提升——尤其是在构建 [AndroidViews][安卓视图] 滚动列表时。强烈建议尽可能启用 View 复用。
 *
 * [安卓视图] 不会将其内容裁剪到布局边界内。如果需要裁剪内容，请在子 View 上使用 [View.setClipToOutline]。开发者很可能希望对 SurfaceView
 * 的所有子类都执行此操作，以将其内容限制在边界范围内。
 *
 * [安卓视图] 在包含的 View 启用了嵌套滚动时，具备嵌套滚动互操作能力。这意味着如果该可组合项被放置在参与嵌套滚动的容器内部，它可以分发滚动增量。
 * 有关如何启用嵌套滚动互操作的更多信息：
 *
 * @param 工厂 用于创建要组合的 [View] 的代码块。
 * @param 修饰符 要应用于布局的修饰符。
 * @param 更新 布局膨胀完成后以及重组时调用的回调，用于更新 View 的信息和状态。
 */
@SuppressLint("ComposableNaming","ModifierParameter")
@Composable
@UiComposable
fun <T : View> 安卓视图(
    工厂: (Context) -> T,
    修饰符: Modifier = Modifier,
    更新: (T) -> Unit = NoOpUpdate,
) {
    AndroidView(
        factory = 工厂,
        modifier = 修饰符,
        update = 更新
    )
}

/**
 * 通过 [工厂] 获取一个 Android [View] 并进行组合。[工厂] 代码块只会被调用恰好一次来获取要组合的 [View]，并且保证在 UI 线程上调用。
 * 因此，除了创建 [View] 之外，[工厂] 代码块还可用于执行一次性初始化以及设置 [View] 的常量属性。[更新] 代码块可以运行多次
 * （同样在 UI 线程上），这是由于重组（recomposition）导致的，它是设置新属性的正确位置。请注意，该代码块也会在 [工厂] 代码块完成后立即运行一次。
 *
 * [安卓视图] 通常用于那些无法在 Compose 中重新实现、且没有对应 Compose API 的 View。目前常见的例子包括 WebView、SurfaceView、AdView 等。
 *
 * 默认情况下，[安卓视图] 不会自动对 View 进行池化或复用。如果将其放置在可复用的容器内部（包括 [LazyRow][androidx.compose.foundation.lazy.LazyRow]
 * 或 [LazyColumn][androidx.compose.foundation.lazy.LazyColumn] 内部），即使其组结构未发生变化且该 View 理论上可以被复用，
 * 只要包含该 安卓视图 的组合层级结构发生变化，View 实例也始终会被丢弃并重新创建。
 *
 * 如果为 [安卓视图] 提供了非空的 [重置回调] 回调，则 View 可以被复用。由于丢弃并重新创建 View 实例的开销较大，复用 View
 * 能够带来显著的性能提升——尤其是在构建 [AndroidViews][安卓视图] 滚动列表时。强烈建议尽可能提供 [重置回调] 实现并启用 View 复用。
 *
 * 当指定了 [重置回调] 时，如果宿主容器支持元素复用，则 [View] 实例可能会被复用。复用发生在重组过程中兼容的 [安卓视图] 实例被插入和移除时。
 * 如果两个 `安卓视图` 实例是以相同的可组合组结构调用的，则它们被视为兼容。这种情况最常见的场景是在 `LazyRow` 和 `LazyColumn` 等
 * 惰性布局 API 中，它们在滚动时可以在列表项之间复用布局节点（在本场景下即 View）。
 *
 * [重置回调] 在 View 将被复用时于 UI 线程上调用，表示该 View 应准备好出现在组合层级结构中的新上下文中。此回调在 [更新] 之前调用，
 * 可用于重置任何临时的 View 状态，如动画或用户输入。
 *
 * 请注意，[重置回调] 调用之后可能不会立即调用 [更新]。如果 View 被停用但尚未从组合中释放，Compose 可能会暂时将其从组合层级结构中分离。
 * 这种情况可能发生在 View 位于当前未激活的 [ReusableContentHost] 中，或位于正在移动的 [movable content][androidx.compose.runtime.movableContentOf]
 * 块内部时。如果发生这种情况，View 将从其父容器中移除，但由 Compose 保留，以便在其内容宿主再次激活时可以复用。如果该 View 始终未能再次激活而是被完全丢弃，
 * 则 [重置回调] 回调将在 Compose 释放该 View 时直接从这种停用状态调用。
 *
 * 如果需要观察 View 当前是否正在组合层级结构中使用，可以通过 [View.addOnAttachStateChangeListener] 监听其附着状态变化。View 还可以通过
 * [findViewTreeLifecycleOwner] 观察其宿主的生命周期。此函数返回的生命周期将与 [LocalLifecycleOwner] 一致。请注意，在 View 完成附着之前，
 * 生命周期尚未设置且无法使用。
 *
 * 当 View 被永久从组合中移除时，[释放回调] 将被调用（同样在 UI 线程上）。一旦此回调返回，无论是否提供了 [重置回调] 实现，Compose
 * 都不会再尝试复用之前的 View 实例。如果将来再次需要该 View，将会创建一个新实例，其生命周期从调用 [工厂] 开始全新启动。
 *
 * [安卓视图] 不会将其内容裁剪到布局边界内。如果需要裁剪内容，请在子 View 上使用 [View.setClipToOutline]。开发者很可能希望对 SurfaceView
 * 的所有子类都执行此操作，以将其内容限制在边界范围内。
 *
 * [安卓视图] 在包含的 View 启用了嵌套滚动时，具备嵌套滚动互操作能力。这意味着如果该可组合项被放置在参与嵌套滚动的容器内部，它可以分发滚动增量。
 * 有关如何启用嵌套滚动互操作的更多信息：
 *
 * @param 工厂 用于创建要组合的 [View] 的代码块。
 * @param 修饰符 要应用于布局的修饰符。
 * @param 重置回调 当 View 即将被附着到与其原始创建不同的上下文中的组合层级结构时，会调用此回调。此回调在 [更新] 之前调用，应将 View
 * 准备为可通用复用。如果为 `null` 或未指定，则该 `安卓视图` 实例将不支持复用，且每当 安卓视图 被移动或从组合层级结构中移除时，
 * View 实例都将被丢弃。
 * @param 释放回调 当此 View 实例已完全退出组合层级结构且不会再被复用时，会调用此回调。此时应释放该 View 所使用的任何额外资源。
 * @param 更新 布局膨胀完成后以及重组时调用的回调，用于更新 View 的信息和状态。
 */
@SuppressLint("ComposableNaming","ModifierParameter")
@Composable
@UiComposable
fun <T : View> 安卓视图(
    工厂: (Context) -> T,
    修饰符: Modifier = Modifier,
    重置回调: ((T) -> Unit)? = null,
    释放回调: (T) -> Unit = NoOpUpdate,
    更新: (T) -> Unit = NoOpUpdate,
) {
    AndroidView(
        factory = 工厂,
        modifier = 修饰符,
        onReset = 重置回调,
        onRelease = 释放回调,
        update = 更新
    )
}

/** [安卓视图] 使用的空更新块。 */
val 无操作更新: View.() -> Unit = {}
