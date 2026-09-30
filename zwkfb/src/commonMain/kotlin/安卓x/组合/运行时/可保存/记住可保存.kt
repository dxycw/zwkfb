package 安卓x.组合.运行时.可保存

import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.autoSaver
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.saveable.rememberSaveable
import 安卓x.组合.运行时.记住

/**
 * 记住由 [初始化] 产生的值。
 *
 * 它的行为与 [记住] 类似，但存储的值会通过 saved instance state 机制在 Activity 或进程重建后得以保留
 * （例如在 Android 应用中屏幕旋转时就会发生这种情况）。
 *
 * @param 输入集 一组输入，当其中任一输入发生变化时，都会导致状态重置并重新执行 [初始化]。请注意，
 * 状态恢复不会针对值保存之前所提供的输入进行校验。
 * @param 保存器 定义状态如何保存与恢复的 [Saver] 对象。
 * @param 键 一个可选的键，用作保存值的标识键。如果未提供，则使用 Compose 运行时自动生成的键，
 * 该键在组合树中的每个确切代码位置都是唯一的。
 * @param 初始化 用于创建此状态初始值的工厂函数。
 */
@Deprecated(
    message =
        " 'rememberSaveable' with a custom 'key' is no longer supported. It bypasses " +
                "positional scoping, leading to state bugs and inconsistent behavior (e.g., " +
                "unintentional state sharing or loss, issues in nested LazyLayouts). Please remove the " +
                "'key' parameter to use positional scoping for consistent, locally-scoped state. " +
                "See https://r.android.com/3610053 for details."
)
@Composable
public fun <T : Any> 记住可保存(
    vararg 输入集: Any?,
    保存器: Saver<T, out Any> = autoSaver(),
    键: String? = null,
    初始化: () -> T,
): T = rememberSaveable(inputs = 输入集, saver = 保存器, key = 键,init = 初始化)

/**
 * 记住由 [初始化] 产生的值。
 *
 * 它的行为与 [记住] 类似，但存储的值会通过 saved instance state 机制在 Activity 或进程重建后得以保留
 * （例如在 Android 应用中屏幕旋转时就会发生这种情况）。
 *
 * @param 输入集 一组输入，当其中任一输入发生变化时，都会导致状态重置并重新执行 [初始化]。请注意，
 * 状态恢复不会针对值保存之前所提供的输入进行校验。
 * @param 初始化 用于创建此状态初始值的工厂函数。
 */
@Composable
public fun <T : Any> 记住可保存(vararg 输入集: Any?, 初始化: () -> T): T =
    rememberSaveable(inputs = 输入集, init = 初始化)

/**
 * 记住由 [初始化] 产生的值。
 *
 * 它的行为与 [记住] 类似，但存储的值会通过 saved instance state 机制在 Activity 或进程重建后得以保留
 * （例如在 Android 应用中屏幕旋转时就会发生这种情况）。
 *
 * @param 输入集 一组输入，当其中任一输入发生变化时，都会导致状态重置并重新执行 [初始化]。请注意，
 *  状态恢复不会针对值保存之前所提供的输入进行校验。
 * @param 保存器 定义状态如何保存与恢复的 [Saver] 对象。
 * @param 初始化 用于创建此状态初始值的工厂函数。
 */
@Composable
public fun <T : Any> 记住可保存(
    vararg 输入集: Any?,
    保存器: Saver<T, out Any>,
    初始化: () -> T,
): T = rememberSaveable(inputs = 输入集, saver = 保存器,init = 初始化)


/**
 * 记住由 [初始化] 产生的值。
 *
 * 它的行为与 [记住] 类似，但存储的值会通过 saved instance state 机制在 Activity 或进程重建后得以保留
 * （例如在 Android 应用中屏幕旋转时就会发生这种情况）。
 *
 * 如果你需要记住一个无法存入 Bundle 的类型的可变状态，从而必须提供自定义的 saver 对象，请使用此重载。
 *
 * @param 输入集 一组输入，当其中任一输入发生变化时，都会导致状态重置并重新执行 [初始化]。请注意，
 *  状态恢复不会针对值保存之前所提供的输入进行校验。
 * @param 状态保存器 定义 MutableState 内部值如何保存与恢复的 [Saver] 对象。
 * @param 初始化 用于创建此状态初始值的工厂函数。
 */
@Composable
public fun <T> 记住可保存(
    vararg 输入集: Any?,
    状态保存器: Saver<T, out Any>,
    初始化: () -> MutableState<T>,
): MutableState<T> = rememberSaveable(inputs = 输入集, stateSaver = 状态保存器,init = 初始化)

/**
 * 记住由 [初始化] 产生的值。
 *
 * 它的行为与 [记住] 类似，但存储的值会通过 saved instance state 机制在 Activity 或进程重建后得以保留
 * （例如在 Android 应用中屏幕旋转时就会发生这种情况）。
 *
 * 如果你需要记住一个无法存入 Bundle 的类型的可变状态，从而必须提供自定义的 saver 对象，请使用此重载。
 *
 * @param 输入集 一组输入，当其中任一输入发生变化时，都会导致状态重置并重新执行 [初始化]。请注意，
 *  状态恢复不会针对值保存之前所提供的输入进行校验。
 * @param 状态保存器 定义 MutableState 内部值如何保存与恢复的 [Saver] 对象。
 * @param 键 一个可选的键，用作保存值的标识键。如果未提供，则使用 Compose 运行时自动生成的键，
 * 该键在组合树中的每个确切代码位置都是唯一的。
 * @param 初始化 用于创建此状态初始值的工厂函数。
 */
@Deprecated(
    message =
        " 'rememberSaveable' with a custom 'key' is no longer supported. It bypasses " +
                "positional scoping, leading to state bugs and inconsistent behavior (e.g., " +
                "unintentional state sharing or loss, issues in nested LazyLayouts). Please remove the " +
                "'key' parameter to use positional scoping for consistent, locally-scoped state. " +
                "See https://r.android.com/3610053 for details."
)
@Composable
public fun <T> 记住可保存(
    vararg 输入集: Any?,
    状态保存器: Saver<T, out Any>,
    键: String? = null,
    初始化: () -> MutableState<T>,
): MutableState<T> = rememberSaveable(inputs = 输入集, stateSaver = 状态保存器,key = 键,init = 初始化)



