package 自定义.组合.材质.图像集

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.DefaultFillType
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathBuilder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

/**
 * <a href="https://material.io/design/iconography/system-icons.html" class="external" target="_blank">Material Design system icons</a>
 * as seen on
 * <a href="https://fonts.google.com/icons" class="external" target="_blank">Google Fonts</a>.
 *
 * ![Iconography image](https://developer.android.com/images/reference/androidx/compose/material/icons/iconography.png)
 *
 * 共有五种不同的图标主题：[自定义.组合.材质.图像集.图像集.填充]、[自定义.组合.材质.图像集.图像集.轮廓]、
 * [自定义.组合.材质.图像集.图像集.圆角]、[自定义.组合.材质.图像集.图像集.双色] 和 [自定义.组合.材质.图像集.图像集.锐角]。
 * 每个主题包含相同的图标，但视觉风格各不相同。通常你应该选择一种主题，并在整个应用中保持一致使用。例如，
 * 你可以使用属性或类型别名来引用特定主题，以便在其他可组合项中以语义化的方式进行访问。
 *
 * 图标保留 Material 定义的名称，但将其 **snake_case**（蛇形命名）转换为 **PascalCase**（帕斯卡命名）。
 * 例如：`add_alarm` 变为 `AddAlarm`。
 *
 * 注意：以数字开头的图标（例如 `360`）会被添加 `_` 前缀，变为 `_360`。
 *
 * 要绘制图标，你可以使用 [androidx.compose.material.Icon]。该组件会应用着色，并提供与图标相匹配的布局尺寸。
 *
 * 请注意，默认仅提供最常用的图标。你可以添加对 `androidx.compose.material:material-icons-extended`
 * 的依赖来访问全部图标，但请注意，由于该依赖的体积非常大，你应该确保使用 R8 / ProGuard 来移除应用中未使用的图标。
 */
object 图像集 { // Icons

    /**
     * [填充图像集](https://material.io/resources/icons/?style=baseline)（此前唯一可用的主题，也称为基线主题）
     * 是默认的图标主题。你也可以使用 [自定义.组合.材质.图像集.图像集.默认] 作为这些图标的别名。
     */
    object 填充 // Filled

    /**
     * [轮廓图像集](https://material.io/resources/icons/?style=outline) 采用细描边和内部留白，呈现出更轻盈的外观。
     */
    object 轮廓 // Outlined

    /**
     * [圆角图像集](https://material.io/resources/icons/?style=round) 采用圆角半径，与使用较粗字体、曲线 Logo
     * 或圆形元素来传达其风格的品牌相得益彰。
     */
    object 圆角 // Rounded

    /**
     * [双色图像集](https://material.io/resources/icons/?style=twotone) 显示带有直角的角落，
     * 具有清晰的风格，即使在较小尺寸下也能保持可读性。这些矩形形状可以支持那些圆形无法很好体现的品牌风格。
     */
    object 双色 // TwoTone

    /**
     * [锐角图像集](https://material.io/resources/icons/?style=sharp) 显示带有直边的角，
     * 这种干净利落的风格即使在较小尺寸下也清晰可辨。这些矩形形状可以支持那些圆角形状无法很好体现的品牌风格。
     */
    object 锐角 // Sharp

    /**
     * <a href="https://material.io/design/iconography/system-icons.html" class="external" target="_blank">Material Design system icons</a>
     * as seen on
     * <a href="https://fonts.google.com/icons" class="external" target="_blank">Google Fonts</a>.
     *
     * ![Iconography image](https://developer.android.com/images/reference/androidx/compose/material/icons/iconography.png)
     *
     * 阿拉伯语和希伯来语等语言采用从右到左（RTL）的阅读方式。对于 RTL 语言，当某些图标的朝向与 RTL 模式下其他 UI
     * 元素的朝向相匹配时，应对其进行镜像处理。
     * [自动镜像] 图标是 [Icons] 的一个子集，当在 RTL 布局中显示时，它们会自动对自身进行镜像。
     *
     * See also
     * <a href="https://developers.google.com/fonts/docs/material_icons#which_icons_should_be_mirrored_for_rtl" class="external" target="_blank">Icons in RTL</a>.
     *
     * 共有五种不同的图标主题：[自定义.组合.材质.图像集.图像集.自动镜像.填充]、[自定义.组合.材质.图像集.图像集.自动镜像.轮廓]、
     * [自定义.组合.材质.图像集.图像集.自动镜像.圆角]、[自定义.组合.材质.图像集.图像集.自动镜像.双色] 和
     * [自定义.组合.材质.图像集.图像集.自动镜像.锐角]。
     * 每个主题包含相同的图标，但视觉风格各不相同。通常你应该选择一种主题，并在整个应用中保持一致使用。例如，你可以使用属性
     * 或类型别名来引用特定主题，以便在其他可组合项中以语义化的方式进行访问。
     *
     * 图标保留 Material 定义的名称，但将其 snake_case 名称转换为 PascalCase。例如：`add_alarm` 变为 `AddAlarm`。
     *
     * 注意：以数字开头的图标（例如 `360`）会被添加 `_` 前缀，变为 `_360`。
     *
     * 要绘制图标，你可以使用 [androidx.compose.material.Icon]。该组件会应用着色，并提供与图标相匹配的布局尺寸。
     *
     * N 请注意，默认仅提供最常用的图标。你可以添加对 `androidx.compose.material:material-icons-extended`
     * 的依赖来访问全部图标，但请注意，由于该依赖的体积非常大，你应该确保使用 R8 / ProGuard 来移除应用中未使用的图标。
     */
    object 自动镜像 { // AutoMirrored

        /**
         * [填充图像集](https://material.io/resources/icons/?style=baseline)是默认的图像主题。
         * 你也可以使用 [默认] 作为这些图像的别名。
         */
        object 填充 // Filled

        /**
         * [轮廓图像集](https://material.io/resources/icons/?style=outline) 采用细描边和内部留白，
         * 呈现出更轻盈的外观。
         */
        object 轮廓 // Outlined

        /**
         * [圆角图像集](https://material.io/resources/icons/?style=round) 采用圆角半径，与使用较粗字体、
         * 曲线 Logo 或圆形元素来传达其风格的品牌相得益彰。
         */
        object 圆角 // Rounded

        /**
         * [双色图像集](https://material.io/resources/icons/?style=twotone) 显示带有
         * 直边的角落，风格干净，即使在较小尺寸下也清晰可辨。这些矩形形状可以支持那些圆形无法很好体现的品牌风格。
         */
        object 双色 // TwoTone

        /**
         * [锐角图像集](https://material.io/resources/icons/?style=sharp) 显示的是带有直边角的设计，
         * 拥有干净利落的风格，即使在较小尺寸下也清晰可辨。这些矩形形状可以支持那些圆角形状无法很好体现的品牌风格。
         */
        object 锐角 //Sharp

        /** [自定义.组合.材质.图像集.图像集.自动镜像.填充] 的别名，基础图标主题。*/
        val 默认 = 填充

    }

    /** [自定义.组合.材质.图像集.图像集.填充] 的别名，基础图标主题。*/
    val 默认 = 填充

}



/**
 * 用于构建带有默认尺寸信息的 Material 图标的工具委托。
 * 此委托供生成的图标使用，不应手动调用。
 *
 * @param 名 生成图标的完整名称
 * @param 自动镜像 确定该矢量资源是否应在从右到左（RTL）语言环境下自动镜像。
 * @param 块 用于向此矢量资源添加路径的构建器 lambda。
 */
inline fun 材质图像(
    名: String,
    自动镜像: Boolean = false,
    块: ImageVector.Builder.() -> ImageVector.Builder
): ImageVector = ImageVector.Builder(
        name = 名,
        defaultWidth = MaterialIconDimension.dp,
        defaultHeight = MaterialIconDimension.dp,
        viewportWidth = MaterialIconDimension,
        viewportHeight = MaterialIconDimension,
        autoMirror = 自动镜像
    ).块().build()


/**
 * 使用 Material 默认值向此图标添加矢量路径。
 *
 * @param 填充透明度 此路径的填充不透明度
 * @param 描边透明度 此路径的描边不透明度
 * @param 路径填充类型 此路径的 [PathFillType]（填充类型）
 * @param 路径构建器 用于向此路径添加命令的构建器 lambda。
 */
inline fun ImageVector.Builder.材质路径(
    填充透明度: Float = 1f,
    描边透明度: Float = 1f,
    路径填充类型: PathFillType = DefaultFillType,
    路径构建器: PathBuilder.() -> Unit
) =
// TODO: b/146213225
// 其中一些默认值在通过 XML 解析时已被设置，但在以编程方式添加时目前尚不存在。我们应该统一这些默认值，并在可能的情况下简化它们。
    path(
        fill = SolidColor(Color.Black),
        fillAlpha = 填充透明度,
        stroke = null,
        strokeAlpha = 描边透明度,
        strokeLineWidth = 1f,
        strokeLineCap = StrokeCap.Butt,
        strokeLineJoin = StrokeJoin.Bevel,
        strokeLineMiter = 1f,
        pathFillType = 路径填充类型,
        pathBuilder = 路径构建器
    )


// 所有 Material 图标（目前）均为 24dp × 24dp，视口大小为 24 × 24。
@PublishedApi
internal const val MaterialIconDimension = 24f
