package 安卓x.组合.材质3

import android.view.WindowManager
import android.view.WindowManager.LayoutParams
import android.view.WindowManager.LayoutParams.FLAG_SECURE
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.runtime.Immutable
import androidx.compose.ui.window.SecureFlagPolicy


/**
 * 用于自定义 [模态底部面板] 行为的属性。
 *
 * 此构造函数为 [模态底部面板] 提供默认行为。如需自定义选项，请参阅其他构造函数。
 */
@ExperimentalMaterial3Api
fun 模态底部面板属性集() = ModalBottomSheetProperties()

/**
 * 用于自定义 [模态底部面板] 行为的属性。
 *
 * @param 安全策略 在底部弹窗的窗口上设置 [WindowManager.LayoutParams.FLAG_SECURE] 的策略。
 * @param 是否应关闭按返回键回调 模态底部面板是否可以通过按返回键关闭。如果为 true，按返回键将调用 onDismissRequest。
 * @param 是否应关闭单击外部回调 模态底部面板是否可以通过点击遮罩来关闭。
 */
@ExperimentalMaterial3Api
fun 模态底部面板属性集( // ModalBottomSheetProperties
    安全策略: SecureFlagPolicy,
    是否应关闭按返回键回调: Boolean = true,
    是否应关闭单击外部回调: Boolean = true,
) =
    ModalBottomSheetProperties(
        securePolicy = 安全策略,
        shouldDismissOnBackPress = 是否应关闭按返回键回调,
        shouldDismissOnClickOutside = 是否应关闭单击外部回调,
    )

/**
 * 用于自定义 [模态底部面板] 行为的属性。
 *
 * 使用此构造函数来自定义 [模态底部面板] 窗口上状态栏和导航栏的行为。
 *
 * @param 是否显示浅色状态栏 如果为 true，将状态栏的前景色变为浅色，以便栏上的项目可以清晰阅读。如果为 false，则恢复默认外观。
 * @param 是否显示浅色导航栏 如果为 true，将导航栏的前景色变为浅色，以便栏上的项目可以清晰阅读。如果为 false，则恢复默认外观。
 * @param 安全策略 在底部弹窗的窗口上设置 [WindowManager.LayoutParams.FLAG_SECURE] 的策略。
 * @param 是否应关闭按返回键回调 模态底部弹窗是否可通过按下返回键关闭。若为 true，按下返回键将调用 onDismissRequest。
 * @param 是否应关闭单击外部回调 模态底部弹窗是否可通过点击遮罩层关闭。
 */
@ExperimentalMaterial3Api
fun 模态底部面板属性集(
    是否显示浅色状态栏: Boolean,
    是否显示浅色导航栏: Boolean,
    安全策略: SecureFlagPolicy = SecureFlagPolicy.Inherit,
    是否应关闭按返回键回调: Boolean = true,
    是否应关闭单击外部回调: Boolean = true,
) =
    ModalBottomSheetProperties(
        isAppearanceLightStatusBars = 是否显示浅色状态栏,
        isAppearanceLightNavigationBars = 是否显示浅色导航栏,
        securePolicy = 安全策略,
        shouldDismissOnBackPress = 是否应关闭按返回键回调,
        shouldDismissOnClickOutside = 是否应关闭单击外部回调,
    )


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
@Immutable
@ExperimentalMaterial3Api
actual object 模态底部面板默认值 {

    /** 用于自定义 [ModalBottomSheet] 行为的属性。 */
    actual val 属性集: ModalBottomSheetProperties = ModalBottomSheetDefaults.properties

    /**
     * 用于自定义 [ModalBottomSheet] 行为的属性。
     *
     * @param 安全策略 在底部弹窗的窗口上设置 [WindowManager.LayoutParams.FLAG_SECURE] 的策略。
     * @param 是否可聚焦 模态底部弹窗是否可聚焦。当为 true 时，模态底部弹窗将接收输入法事件和按键操作，例如当按下返回键时。
     * @param 是否应关闭按返回键回调 模态底部弹窗是否可通过按下返回键关闭。若为 true，按下返回键将调用 onDismissRequest。
     * 注意：[是否可聚焦] 必须设为 true 才能接收返回键等按键事件——如果模态底部弹窗不可聚焦，则此属性无效。
     */
    @Deprecated(
        level = DeprecationLevel.WARNING,
        message = "'isFocusable' param is no longer used. Use value without this parameter.",
        replaceWith = ReplaceWith("properties"),
    )
    @Suppress("UNUSED_PARAMETER")
    fun 属性集(
        安全策略: SecureFlagPolicy = SecureFlagPolicy.Inherit,
        是否可聚焦: Boolean = true,
        是否应关闭按返回键回调: Boolean = true,
    ) =
        ModalBottomSheetDefaults.properties(
            securePolicy = 安全策略,
            isFocusable = 是否可聚焦,
            shouldDismissOnBackPress = 是否应关闭按返回键回调,
        )

}