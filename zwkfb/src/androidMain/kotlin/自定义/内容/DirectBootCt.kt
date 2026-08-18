package 自定义.内容

import android.content.Context

/**
 * Lazily creates a device protected storage Context on Android N+ devices,
 * or initializes itself to [appCtx] if the device runs Android M or an older version.
 * See [Direct Boot documentation](https://developer.android.com/training/articles/direct-boot.html)
 * to learn more.
 */
inline val directBootCtx: Context get() = deviceProtectedStorageCtx.value

@PublishedApi
internal val deviceProtectedStorageCtx = lazy { appCtx.createDeviceProtectedStorageContext() }