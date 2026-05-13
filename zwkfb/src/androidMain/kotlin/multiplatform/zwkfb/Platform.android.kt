package multiplatform.zwkfb

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val platform: String = "Android"
}

actual fun getPlatform(): Platform = AndroidPlatform()