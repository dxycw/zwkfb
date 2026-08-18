package 自定义.内容


import android.app.Application
import android.content.ContentProvider
import android.content.Context
import androidx.startup.InitializationProvider
import androidx.annotation.Keep
import androidx.startup.Initializer

/**
 * Initializes [appCtx] so it can be used where any [Context] can be used.
 *
 * If you use [appCtx] in an AndroidX App Startup [Initializer], directly or not,
 * make sure to add this class among its list of [dependencies].
 *
 * If you use [appCtx] in another process than the default one this will not be invoked.
 *
 * If you use [appCtx] in a [ContentProvider] that is initialized before
 * the one from AndroidX App Startup ([androidx.startup.InitializationProvider][InitializationProvider]),
 * this will not be invoked in time.
 *
 * The easiest way to fix that is, in your properly declared custom [Application], to call [injectAsAppCtx],
 * passing `this` reference from the constructor or the [Application.onCreate] method.
 *
 * In the case of a [ContentProvider], calling [injectAsAppCtx] in its [ContentProvider.onCreate] function
 * will also work, but we strongly recommend you to use
 * [AndroidX App Startup instead](https://developer.android.com/topic/libraries/app-startup),
 * for performance reasons since each [ContentProvider] delays app startup, and these add-up,
 * resulting in a poor UX.
 */
@Keep // Needed because there's no default R8/proguard rules for App Startup Initializers.
@Suppress("unused") // False positive. Used in the manifest, but tooling analysis is incomplete.
@ExperimentalSplittiesApi
class AppCtxInitializer : Initializer<AppCtxInitializer> {
    override fun create(context: Context): AppCtxInitializer {
        context.injectAsAppCtx()
        return this
    }

    override fun dependencies() = emptyList<Nothing>()
}

//=============================================================

@MustBeDocumented
@Retention(value = AnnotationRetention.BINARY)
@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
annotation class ExperimentalSplittiesApi
