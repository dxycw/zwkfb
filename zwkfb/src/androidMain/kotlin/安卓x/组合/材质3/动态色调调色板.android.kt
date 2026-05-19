package 安卓x.组合.材质3

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme

/**
 * 创建一个明亮的动态配色方案。
 *
 * 使用此函数可以基于系统壁纸创建配色方案。如果开发者更改了壁纸，该配色方案会相应地改变。这种动态配色方案是浅色主题变体。
 *
 * @param 上下文 获取系统资源数据所需的上下文。
 */
@RequiresApi(Build.VERSION_CODES.S)
fun 动态浅色颜色方案(上下文: Context): ColorScheme {
    return dynamicLightColorScheme(上下文)
}

/**
 * 创建一个深色的动态配色方案。
 *
 * 使用此函数可以基于系统壁纸创建配色方案。如果开发者更改了壁纸，该配色方案会相应地改变。这种动态配色方案是深色主题变体。
 *
 * @param 上下文 获取系统资源数据所需的上下文。
 */
@RequiresApi(Build.VERSION_CODES.S)
fun 动态深色颜色方案(上下文: Context): ColorScheme {
    return dynamicDarkColorScheme(上下文)
}




