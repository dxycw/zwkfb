@file:JvmName("Android图标Kt")
package 自定义.组合.材质3

import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.res.painterResource


@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 图标(
    绘制id: Int,
    内容描述: String? = null,
    修饰符: Modifier = Modifier,
    图标颜色: Color = LocalContentColor.current
) = Icon(
    painter = painterResource(绘制id),
    contentDescription = 内容描述,
    modifier = 修饰符,
    tint = 图标颜色
)


@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 图标(
    绘制id: Int,
    图标颜色: ColorProducer?,
    内容描述: String? = null,
    修饰符: Modifier = Modifier
) = Icon(
    painter = painterResource(绘制id),
    tint = 图标颜色,
    contentDescription = 内容描述,
    modifier = 修饰符
)

