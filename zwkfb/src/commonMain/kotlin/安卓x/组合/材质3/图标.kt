package 安卓x.组合.材质3

import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * 一个 Material Design 图标组件，用于使用 [色调]（默认值为 [LocalContentColor]）绘制 [图像矢量]。如果 [图像矢量] 没有固有尺寸，
 * 此组件将使用推荐的默认尺寸。Icon 是一个具有特定设计意图的组件，专为单色图标设计，以便它们可以根据所在组件正确着色。对于多色图标或不应着色的图标，
 * 请为 [色调] 使用 [Color.Unspecified]。对于不应着色且不遵循推荐图标尺寸的通用图像，请改用通用的 [androidx.compose.foundation.Image]。
 * 对于可点击的图标，请参阅 [图标按钮]。
 *
 * 如需了解更多关于图标的信息，请参阅[Material Design icons](https://m3.material.io/styles/icons/overview)
 *
 * @param 图像矢量 在此图标内绘制的 [ImageVector]
 * @param 内容描述 用于无障碍服务描述此图标含义的文本。除非此图标仅用于装饰目的且不表示用户可执行的有效操作，否则应始终提供此文本。
 * 此文本应进行本地化处理，例如使用 [androidx.compose.ui.res.stringResource] 或类似方法。
 * @param 修饰符 应用于此图标的 [Modifier]
 * @param 色调 应用于 [图像矢量] 的着色颜色。如果提供 [Color.Unspecified]，则不着色。
 */
@Suppress("ComposableNaming")
@Composable
fun 图标(
    图像矢量: ImageVector,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    色调: Color = LocalContentColor.current,
) {
    Icon(
        imageVector = 图像矢量,
        contentDescription = 内容描述,
        modifier = 修饰符,
        tint = 色调,
    )
}

/**
 * 一个 Material Design 图标组件，用于使用 [色调]（默认值为 [LocalContentColor]）绘制 [位图]。如果 [位图] 没有固有尺寸，
 * 此组件将使用推荐的默认尺寸。Icon 是一个具有特定设计意图的组件，专为单色图标设计，以便它们可以根据所在组件正确着色。对于多色图标或不应着色的图标，
 * 请为 [色调] 使用 [Color.Unspecified]。对于不应着色且不遵循推荐图标尺寸的通用图像，请改用通用的 [androidx.compose.foundation.Image]。
 * 对于可点击的图标，请参阅 [图标按钮]。
 *
 * 如需了解更多关于图标的信息，请参阅[Material Design icons](https://m3.material.io/styles/icons/overview)
 *
 * @param 位图 在此图标内绘制的 [ImageBitmap]
 * @param 内容描述 用于无障碍服务描述此图标含义的文本。除非此图标仅用于装饰目的且不表示用户可执行的有效操作，否则应始终提供此文本。
 * 此文本应进行本地化处理，例如使用 [androidx.compose.ui.res.stringResource] 或类似方法。
 * @param 修饰符 应用于此图标的 [Modifier]
 * @param 色调 应用于 [位图] 的着色颜色。如果提供 [Color.Unspecified]，则不着色。
 */
@Suppress("ComposableNaming")
@Composable
fun 图标(
    位图: ImageBitmap,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    色调: Color = LocalContentColor.current,
) {
    Icon(
        bitmap = 位图,
        contentDescription = 内容描述,
        modifier = 修饰符,
        tint = 色调,
    )
}

/**
 * 一个 Material Design 图标组件，用于使用 [色调]（默认值为 [LocalContentColor]）绘制 [绘制器]。如果 [绘制器] 没有固有尺寸，
 * 此组件将使用推荐的默认尺寸。Icon 是一个具有特定设计意图的组件，专为单色图标设计，以便它们可以根据所在组件正确着色。对于多色图标或不应着色的图标，
 * 请为 [色调] 使用 [Color.Unspecified]。对于不应着色且不遵循推荐图标尺寸的通用图像，请改用通用的 [androidx.compose.foundation.Image]。
 * 对于可点击的图标，请参阅 [图标按钮]。
 *
 * 如需了解更多关于图标的信息，请参阅[Material Design icons](https://m3.material.io/styles/icons/overview)
 *
 * @param 绘制器 在此图标内绘制的 [Painter]
 * @param 内容描述 用于无障碍服务描述此图标含义的文本。除非此图标仅用于装饰目的且不表示用户可执行的有效操作，否则应始终提供此文本。
 * 此文本应进行本地化处理，例如使用 [androidx.compose.ui.res.stringResource] 或类似方法。
 * @param 修饰符 应用于此图标的 [Modifier]
 * @param 色调 应用于 [绘制器] 的着色颜色。如果提供 [Color.Unspecified]，则不着色。
 */
@Suppress("ComposableNaming")
@Composable
fun 图标(
    绘制器: Painter,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    色调: Color = LocalContentColor.current,
) {
    Icon(
        painter = 绘制器,
        contentDescription = 内容描述,
        modifier = 修饰符,
        tint = 色调,
    )
}

/**
 * 一个 Material Design 图标组件，用于使用 [色调] 绘制 [绘制器]。如果 [绘制器] 没有固有尺寸，此组件将使用推荐的默认尺寸。
 * Icon 是一个具有特定设计意图的组件，专为单色图标设计，以便它们可以根据所在组件正确着色。对于多色图标或不应着色的图标，请为 [色调] 使用 null。
 * 对于不应着色且不遵循推荐图标尺寸的通用图像，请改用通用的 [androidx.compose.foundation.Image]。对于可点击的图标，请参阅 [图标按钮]。
 *
 * 如需了解更多关于图标的信息，请参阅[Material Design icons](https://m3.material.io/styles/icons/overview)
 *
 * @param 绘制器 在此图标内绘制的 [Painter]
 * @param 色调 应用于 [绘制器] 的着色颜色。如果为 null，则不着色。
 * @param 内容描述 用于无障碍服务描述此图标含义的文本。除非此图标仅用于装饰目的且不表示用户可执行的有效操作，否则应始终提供此文本。
 * 此文本应进行本地化处理，例如使用 [androidx.compose.ui.res.stringResource] 或类似方法。
 * @param 修饰符 应用于此图标的 [Modifier]
 */
@Suppress("ComposableNaming")
@Composable
fun 图标(
    绘制器: Painter,
    色调: ColorProducer?,
    内容描述: String?,
    修饰符: Modifier = Modifier,
) {
    Icon(
        painter = 绘制器,
        tint = 色调,
        contentDescription = 内容描述,
        modifier = 修饰符,
    )
}

