package 安卓x.活动.组合

import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.platform.LocalContext


/**
 * 提供属于当前 [LocalContext] 的 [Activity]。
 *
 * 请注意，在可能的情况下，应始终优先使用粒度更细的组合局部变量（如果可用）。当所需 API 仅通过 [Activity] 提供时，才应将此 API 用作后备方案。
 *
 * See [androidx.compose.ui.platform.LocalConfiguration]
 * [androidx.compose.ui.platform.LocalLifecycleOwner] [androidx.compose.ui.platform.LocalView]
 */
@SuppressLint("CompositionLocalNaming")
val 本地活动: ProvidableCompositionLocal<Activity?> = LocalActivity
