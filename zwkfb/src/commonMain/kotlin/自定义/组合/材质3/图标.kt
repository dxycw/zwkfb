package 自定义.组合.材质3

import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorProducer
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


/**
 * 列如：
 *
 *       图标(
 *           资源 = Res.drawable.compose_multiplatform,
 *           内容描述 = "图标",
 *           修饰符 = Modifier.size(40.dp)
 *       )
 */
@Suppress("ComposableNaming")
@Composable
fun 图标(
    资源: DrawableResource,
    内容描述: String? = null,
    修饰符: Modifier = Modifier,
    图标颜色: Color = LocalContentColor.current
) = Icon(
    painter = painterResource(资源),
    contentDescription = 内容描述,
    modifier = 修饰符,
    tint = 图标颜色
)

/**
 * 列如：
 *
 *       图标(
 *           资源 = Res.drawable.compose_multiplatform,
 *           内容描述 = "图标",
 *           修饰符 = Modifier.size(40.dp)
 *       )
 */
@Suppress("ComposableNaming")
@Composable
fun 图标(
    资源: DrawableResource,
    图标颜色: ColorProducer?,
    内容描述: String? = null,
    修饰符: Modifier = Modifier
) = Icon(
    painter = painterResource(资源),
    tint = 图标颜色,
    contentDescription = 内容描述,
    modifier = 修饰符
)
