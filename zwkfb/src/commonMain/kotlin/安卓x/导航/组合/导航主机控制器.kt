@file:JvmName("导航主机控制器Kt")
@file:JvmMultifileClass

package 安卓x.导航.组合

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.DialogNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * 获取当前导航返回栈条目作为 [MutableState]。当给定的 navController 因 [NavController.navigate] 或
 * [NavController.popBackStack] 而更改返回栈时，这将触发重组，并返回返回栈顶部的条目。
 *
 * @return 当前返回栈条目的可变状态
 */
@Composable
public fun NavController.当前返回栈条目状态(): State<NavBackStackEntry?> =
    this.currentBackStackEntryAsState()

/**
 * 创建一个 NavHostController，它会自动添加 [ComposeNavigator] 和 [DialogNavigator]。额外的 [Navigator]
 * 实例可以通过 [导航器集] 参数传入，以应用到返回的 NavController 中。注意，每个 [Navigator] 在传入之前必须单独
 * 使用 remember 进行记忆：这些输入的任何更改都会导致 NavController 被重新创建。
 *
 * @see NavHost
 */
@Composable
public fun 记住导航控制器(
    vararg 导航器集: Navigator<out NavDestination>
): NavHostController = rememberNavController(navigators = 导航器集)
