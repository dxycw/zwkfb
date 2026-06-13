package 安卓x.组合.界面.图形.绘制范围

import androidx.compose.ui.graphics.drawscope.DrawContext
import androidx.compose.ui.graphics.drawscope.DrawScopeMarker
import androidx.compose.ui.graphics.drawscope.DrawTransform
import androidx.annotation.FloatRange
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.rotateRad
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.layer.GraphicsLayer
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.toIntSize
import kotlin.Float

/**
 * 同时按 [左] 和 [上] 平移 [DrawScope] 坐标空间，并修改当前绘制区域的尺寸。该方法提供了一个回调，用于在修改后的坐标
 * 空间内发出更多绘制指令。该方法会将 [DrawScope] 的宽度修改为 width - (left + right)，高度修改为 height - (top + bottom)。
 * 调用此方法后，坐标空间将恢复到应用内边距之前的状态。
 *
 * @param 左 左侧绘制边界的向内缩进像素数。
 * @param 上 顶部绘制边界的向内缩进像素数。
 * @param 右 右侧绘制边界的向内缩进像素数。
 * @param 下 底部绘制边界的向内缩进像素数。
 * @param 块 用于在内嵌坐标空间内发出绘制命令的 lambda。
 */
inline fun DrawScope.嵌入(
    左: Float,
    上: Float,
    右: Float,
    下: Float,
    块: DrawScope.() -> Unit,
) = this.inset(left = 左, top = 上, right = 右, bottom = 下, block = 块)


/**
 * 便利方法，将 [DrawScope] 的边界向内收缩，使左、上、右、下四个边界同时按 [嵌入] 值内缩。调用此方法后，坐标空间将恢复到应用此内缩之前的状态。
 *
 * @param 嵌入 将左、上、右、下四个边界的内缩像素数。
 * @param 块 在修改后的坐标空间内，用于发出额外绘制指令的 lambda 表达式。
 */
inline fun DrawScope.嵌入(嵌入: Float, 块: DrawScope.() -> Unit) =
    this.inset(inset = 嵌入, block = 块)

/**
 * 便利方法，将 [DrawScope] 的边界向内收缩，使左右边界按 [水平] 值内缩，上下边界按 [垂直] 值内缩。
 * 调用此方法后，坐标空间将恢复到应用此内缩之前的状态。
 *
 * @param 水平 左右边界内缩的像素数。默认为零。
 * @param 垂直 上下边界内缩的可选像素数。默认为零。
 * @param 块 在修改后的坐标空间内，用于发出额外绘制指令的 lambda 表达式。
 */
inline fun DrawScope.嵌入(
    水平: Float = 0.0f,
    垂直: Float = 0.0f,
    块: DrawScope.() -> Unit,
) = this.inset(horizontal = 水平, vertical = 垂直, block = 块)

/**
 * 按给定的像素增量分别在 x 和 y 坐标上平移坐标空间。
 *
 * @param 左 在 x 轴上平移坐标空间的像素数。
 * @param 上 在 y 轴上平移坐标空间的像素数。
 * @param 块 在已平移的坐标空间内，用于发出绘制指令的 lambda 表达式。
 */
inline fun DrawScope.平移(左: Float = 0.0f, 上: Float = 0.0f, 块: DrawScope.() -> Unit) =
    this.translate(left = 左, top = 上, block = 块)

/**
 * 在指定枢轴点处为当前变换添加顺时针旋转（以度为单位）。枢轴坐标不受旋转变换的影响。在提供的 lambda 调用完成后，旋转变换将被撤销。
 *
 * @param 角度 顺时针旋转
 * @param 枢轴 枢轴点的坐标，默认为坐标空间的中心。
 * @param 块 在已旋转的坐标空间内，用于发出绘制指令的 lambda 表达式。
 */
inline fun DrawScope.旋转(角度: Float, 枢轴: Offset = center, 块: DrawScope.() -> Unit) =
    this.rotate(degrees = 角度, pivot = 枢轴, block = 块)

/**
 * 在指定枢轴点处为当前变换添加顺时针旋转（以弧度为单位）。枢轴坐标不受旋转变换的影响。
 *
 * @param 弧度 顺时针旋转
 * @param 枢轴 枢轴点的坐标，默认为坐标空间的中心。
 * @param 块 在已旋转的坐标空间内，用于发出绘制指令的 lambda 表达式。
 */
inline fun DrawScope.旋转弧度(
    弧度: Float,
    枢轴: Offset = center,
    块: DrawScope.() -> Unit,
) = this.rotateRad(radians = 弧度, pivot = 枢轴, block = 块)

/**
 * 在当前变换中添加一个轴对齐的缩放，以第一个参数在水平方向、第二个参数在垂直方向进行缩放，并以给定的枢轴坐标为基准。
 * 枢轴坐标在缩放变换中保持不变。调用此方法后，坐标空间将恢复到应用缩放之前的状态。
 *
 * @param 缩放X X 轴方向的缩放比例。
 * @param 缩放Y Y 轴方向的缩放比例。
 * @param 枢轴 枢轴点的坐标，默认为坐标空间的中心。
 * @param 块 用于在缩放后的坐标空间内发出绘制命令的 lambda。
 */
inline fun DrawScope.缩放(
    缩放X: Float,
    缩放Y: Float,
    枢轴: Offset = center,
    块: DrawScope.() -> Unit,
) = this.scale(scaleX = 缩放X, scaleY = 缩放Y, pivot = 枢轴, block = 块)

/**
 * 在当前变换中添加一个轴对齐的缩放，以给定的枢轴坐标为基准，同时在水平方向和垂直方向进行缩放。枢轴坐标在缩放变换中保持不变。
 * 调用此方法后，坐标空间将恢复到应用缩放之前的状态。
 *
 * @param 缩放 在两个方向上均匀缩放的量。
 * @param 枢轴 枢轴点的坐标，默认为坐标空间的中心。
 * @param 块 用于在缩放后的坐标空间内发出绘制命令的 lambda。
 */
inline fun DrawScope.缩放(缩放: Float, 枢轴: Offset = center, 块: DrawScope.() -> Unit) =
    this.scale(scale = 缩放, pivot = 枢轴, block = 块)

/**
 * 将裁剪区域缩减为当前裁剪区域与由给定的左、上、右、下边界所指定的矩形的交集。此方法提供一个回调，用于在裁剪区域内发出绘制命令。
 * 调用此方法后，此裁剪不再生效。
 *
 * 使用 [ClipOp.Difference] 从当前裁剪区域中减去所提供的矩形。
 *
 * @param 左 要裁剪的矩形的左边界。
 * @param 上 要裁剪的矩形的上边界。
 * @param 右 要裁剪的矩形的右边界。
 * @param 下 要裁剪的矩形的下边界。
 * @param 裁剪操作 对给定边界执行的裁剪操作，默认为 [ClipOp.Intersect]。
 * @param 块 以当前 CanvasScope 作为接收器上下文的 Lambda 回调，用于在提供的裁剪区域内发出绘制命令。
 */
inline fun DrawScope.裁剪矩形(
    左: Float = 0.0f,
    上: Float = 0.0f,
    右: Float = size.width,
    下: Float = size.height,
    裁剪操作: ClipOp = ClipOp.Intersect,
    块: DrawScope.() -> Unit,
) = this.clipRect(left = 左, top = 上, right = 右, bottom = 下, clipOp = 裁剪操作, block = 块)

/**
 * 将裁剪区域缩减为当前裁剪区域与给定路径的交集。此方法提供一个回调，用于在由裁剪路径定义的区域内发出绘制命令。调用此方法后，此裁剪不再生效。
 *
 * @param 路径 用于裁剪绘制内容的形状。
 * @param 裁剪操作 对给定边界执行的裁剪操作，默认为 [ClipOp.Intersect]。
 * @param 块 以当前 CanvasScope 作为接收器上下文的 Lambda 回调，用于在提供的裁剪区域内发出绘制命令。
 */
inline fun DrawScope.裁剪路径(
    路径: Path,
    裁剪操作: ClipOp = ClipOp.Intersect,
    块: DrawScope.() -> Unit,
) = this.clipPath(path = 路径, clipOp = 裁剪操作, block = 块)

/**
 * 提供直接使用底层 [Canvas] 进行绘制的访问权限。这对于需要结合 [DrawScope] 复用其他绘制逻辑的场景很有帮助。
 *
 * @param 块 用于在提供的 [Canvas] 上发出绘制命令的 Lambda 回调。
 */
inline fun DrawScope.绘制到画布(块: (Canvas) -> Unit) = this.drawIntoCanvas(block = 块)

/**
 * 执行一个或多个变换，并使用所应用的指定变换执行绘制命令。此调用完成后，将恢复此调用之前的变换。
 *
 * @param 转换块 在绘制操作发出之前，调用此回调来执行要应用的变换。
 * @param 绘制块 在变换应用之后，调用此回调来发出绘制操作。
 */
inline fun DrawScope.带转换(
    转换块: DrawTransform.() -> Unit,
    绘制块: DrawScope.() -> Unit,
) = this.withTransform(transformBlock = 转换块, drawBlock = 绘制块)


/**
 * 使用以当前 [DrawScope] 作为接收器的 lambda 中指定的命令，在提供的 [Canvas] 上进行绘制。
 *
 * @param 密度 用于辅助将密度无关像素转换为原始像素以进行绘制的 [Density]。
 * @param 布局方向 所绘制布局的 [LayoutDirection]。
 * @param 画布 标画布，用于渲染输出。
 * @param 大小 [DrawScope] 应在其中绘制的边界，相对于当前画布的平移坐标。
 * @param 图形图层 我们正在绘制到的当前 [GraphicsLayer]。如果 [画布] 不是由 [GraphicsLayer] 提供的，
 * 则可能为 null，例如在软件加速绘制的情况下。
 * @param 块 在此 [DrawScope] 上发出绘制命令时调用的 lambda。
 */
inline fun DrawScope.绘制(
    密度: Density,
    布局方向: LayoutDirection,
    画布: Canvas,
    大小: Size,
    图形图层: GraphicsLayer? = null,
    块: DrawScope.() -> Unit,
) = this.draw(
    density = 密度,
    layoutDirection = 布局方向,
    canvas = 画布,
    size = 大小,
    graphicsLayer = 图形图层,
    block = 块,
)


///**
// * Creates a scoped drawing environment with the provided [Canvas]. This provides a declarative,
// * stateless API to draw shapes and paths without requiring consumers to maintain underlying
// * [Canvas] state information. [DrawScope] implementations are also provided sizing information and
// * transformations are done relative to the local translation. That is left and top coordinates are
// * always the origin and the right and bottom coordinates are always the specified width and height
// * respectively. Drawing content is not clipped, so it is possible to draw outside of the specified
// * bounds.
// */
//@DrawScopeMarker
//interface 绘制范围 : Density { // DrawScope
//
//    /**
//     * The current [DrawContext] that contains the dependencies needed to create the drawing
//     * environment
//     */
//    val drawContext: DrawContext
//
//    /** Center of the current bounds of the drawing environment */
//    val center: Offset
//        get() = drawContext.size.center
//
//    /** Provides the dimensions of the current drawing environment */
//    val size: Size
//        get() = drawContext.size
//
//    /** The layout direction of the layout being drawn in. */
//    val layoutDirection: LayoutDirection
//
//    /**
//     * Draws a line between the given points using the given paint. The line is stroked.
//     *
//     * @param brush the color or fill to be applied to the line
//     * @param start first point of the line to be drawn
//     * @param end second point of the line to be drawn
//     * @param strokeWidth stroke width to apply to the line
//     * @param cap treatment applied to the ends of the line segment
//     * @param pathEffect optional effect or pattern to apply to the line
//     * @param alpha opacity to be applied to the [brush] from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param colorFilter ColorFilter to apply to the [brush] when drawn into the destination
//     * @param blendMode the blending algorithm to apply to the [brush]
//     */
//    fun drawLine(
//        brush: Brush,
//        start: Offset,
//        end: Offset,
//        strokeWidth: Float = Stroke.HairlineWidth,
//        cap: StrokeCap = Stroke.DefaultCap,
//        pathEffect: PathEffect? = null,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws a line between the given points using the given paint. The line is stroked.
//     *
//     * @param color the color to be applied to the line
//     * @param start first point of the line to be drawn
//     * @param end second point of the line to be drawn
//     * @param strokeWidth The stroke width to apply to the line
//     * @param cap treatment applied to the ends of the line segment
//     * @param pathEffect optional effect or pattern to apply to the line
//     * @param alpha opacity to be applied to the [color] from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param colorFilter ColorFilter to apply to the [color] when drawn into the destination
//     * @param blendMode the blending algorithm to apply to the [color]
//     */
//    fun drawLine(
//        color: Color,
//        start: Offset,
//        end: Offset,
//        strokeWidth: Float = Stroke.HairlineWidth,
//        cap: StrokeCap = Stroke.DefaultCap,
//        pathEffect: PathEffect? = null,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws a rectangle with the given offset and size. If no offset from the top left is provided,
//     * it is drawn starting from the origin of the current translation. If no size is provided, the
//     * size of the current environment is used.
//     *
//     * @param brush The color or fill to be applied to the rectangle
//     * @param topLeft Offset from the local origin of 0, 0 relative to the current translation
//     * @param size Dimensions of the rectangle to draw
//     * @param alpha Opacity to be applied to the [brush] from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Whether or not the rectangle is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [brush] when drawn into the destination
//     * @param blendMode Blending algorithm to apply to destination
//     */
//    fun drawRect(
//        brush: Brush,
//        topLeft: Offset = Offset.Zero,
//        size: Size = this.size.offsetSize(topLeft),
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws a rectangle with the given offset and size. If no offset from the top left is provided,
//     * it is drawn starting from the origin of the current translation. If no size is provided, the
//     * size of the current environment is used.
//     *
//     * @param color The color to be applied to the rectangle
//     * @param topLeft Offset from the local origin of 0, 0 relative to the current translation
//     * @param size Dimensions of the rectangle to draw
//     * @param alpha Opacity to be applied to the [color] from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Whether or not the rectangle is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [color] source pixels
//     * @param blendMode Blending algorithm to apply to destination
//     */
//    fun drawRect(
//        color: Color,
//        topLeft: Offset = Offset.Zero,
//        size: Size = this.size.offsetSize(topLeft),
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws the given [ImageBitmap] into the canvas with its top-left corner at the given [Offset].
//     * The image is composited into the canvas using the given [Paint].
//     *
//     * @param image The [ImageBitmap] to draw
//     * @param topLeft Offset from the local origin of 0, 0 relative to the current translation
//     * @param alpha Opacity to be applied to [image] from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Specifies whether the image is to be drawn filled in or as a rectangular stroke
//     * @param colorFilter ColorFilter to apply to the [image] when drawn into the destination
//     * @param blendMode Blending algorithm to apply to destination
//     */
//    fun drawImage(
//        image: ImageBitmap,
//        topLeft: Offset = Offset.Zero,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//
//    /**
//     * Draws the subset of the given image described by the `src` argument into the canvas in the
//     * axis-aligned rectangle given by the `dst` argument.
//     *
//     * If no src rect is provided, the entire image is scaled into the corresponding destination
//     * bounds
//     *
//     * @param image The source image to draw
//     * @param srcOffset Optional offset representing the top left offset of the source image to
//     *   draw, this defaults to the origin of [image]
//     * @param srcSize Optional dimensions of the source image to draw relative to [srcOffset], this
//     *   defaults the width and height of [image]
//     * @param dstOffset Optional offset representing the top left offset of the destination to draw
//     *   the given image, this defaults to the origin of the current translation tarting top left
//     *   offset in the destination to draw the image
//     * @param dstSize Optional dimensions of the destination to draw, this defaults to [srcSize]
//     * @param alpha Opacity to be applied to [image] from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Specifies whether the image is to be drawn filled in or as a rectangular stroke
//     * @param colorFilter ColorFilter to apply to the [image] when drawn into the destination
//     * @param blendMode Blending algorithm to apply to destination
//     * @param filterQuality Sampling algorithm applied to the [image] when it is scaled and drawn
//     *   into the destination. The default is [FilterQuality.Low] which scales using a bilinear
//     *   sampling algorithm
//     */
//    fun drawImage(
//        image: ImageBitmap,
//        srcOffset: IntOffset = IntOffset.Zero,
//        srcSize: IntSize = IntSize(image.width, image.height),
//        dstOffset: IntOffset = IntOffset.Zero,
//        dstSize: IntSize = srcSize,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//        filterQuality: FilterQuality = DefaultFilterQuality,
//    ) {
//        drawImage(
//            image = image,
//            srcOffset = srcOffset,
//            srcSize = srcSize,
//            dstOffset = dstOffset,
//            dstSize = dstSize,
//            alpha = alpha,
//            style = style,
//            colorFilter = colorFilter,
//            blendMode = blendMode,
//        )
//    }
//
//    /**
//     * Draws a rounded rectangle with the provided size, offset and radii for the x and y axis
//     * respectively. This rectangle is drawn with the provided [Brush] parameter and is filled or
//     * stroked based on the given [DrawStyle]
//     *
//     * @param brush The color or fill to be applied to the rounded rectangle
//     * @param topLeft Offset from the local origin of 0, 0 relative to the current translation
//     * @param size Dimensions of the rectangle to draw
//     * @param cornerRadius Corner radius of the rounded rectangle, negative radii values are clamped
//     *   to 0
//     * @param alpha Opacity to be applied to rounded rectangle from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Specifies whether the rounded rectangle is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [brush] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the brush
//     */
//    fun drawRoundRect(
//        brush: Brush,
//        topLeft: Offset = Offset.Zero,
//        size: Size = this.size.offsetSize(topLeft),
//        cornerRadius: CornerRadius = CornerRadius.Zero,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws a rounded rectangle with the given [Paint]. Whether the rectangle is filled or stroked
//     * (or both) is controlled by [Paint.style].
//     *
//     * @param color The color to be applied to the rounded rectangle
//     * @param topLeft Offset from the local origin of 0, 0 relative to the current translation
//     * @param size Dimensions of the rectangle to draw
//     * @param cornerRadius Corner radius of the rounded rectangle, negative radii values are clamped
//     *   to 0
//     * @param alpha Opacity to be applied to rounded rectangle from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Specifies whether the rounded rectangle is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [color] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the color
//     */
//    fun drawRoundRect(
//        color: Color,
//        topLeft: Offset = Offset.Zero,
//        size: Size = this.size.offsetSize(topLeft),
//        cornerRadius: CornerRadius = CornerRadius.Zero,
//        style: DrawStyle = Fill,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws a circle at the provided center coordinate and radius. If no center point is provided
//     * the center of the bounds is used.
//     *
//     * @param brush The color or fill to be applied to the circle
//     * @param radius The radius of the circle
//     * @param center The center coordinate where the circle is to be drawn
//     * @param alpha Opacity to be applied to the circle from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Whether or not the circle is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [brush] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the brush
//     */
//    fun drawCircle(
//        brush: Brush,
//        radius: Float = size.minDimension / 2.0f,
//        center: Offset = this.center,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws a circle at the provided center coordinate and radius. If no center point is provided
//     * the center of the bounds is used.
//     *
//     * @param color The color or fill to be applied to the circle
//     * @param radius The radius of the circle
//     * @param center The center coordinate where the circle is to be drawn
//     * @param alpha Opacity to be applied to the circle from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Whether or not the circle is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [color] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the brush
//     */
//    fun drawCircle(
//        color: Color,
//        radius: Float = size.minDimension / 2.0f,
//        center: Offset = this.center,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws an oval with the given offset and size. If no offset from the top left is provided, it
//     * is drawn starting from the origin of the current translation. If no size is provided, the
//     * size of the current environment is used.
//     *
//     * @param brush Color or fill to be applied to the oval
//     * @param topLeft Offset from the local origin of 0, 0 relative to the current translation
//     * @param size Dimensions of the rectangle to draw
//     * @param alpha Opacity to be applied to the oval from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Whether or not the oval is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [brush] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the brush
//     */
//    fun drawOval(
//        brush: Brush,
//        topLeft: Offset = Offset.Zero,
//        size: Size = this.size.offsetSize(topLeft),
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws an oval with the given offset and size. If no offset from the top left is provided, it
//     * is drawn starting from the origin of the current translation. If no size is provided, the
//     * size of the current environment is used.
//     *
//     * @param color Color to be applied to the oval
//     * @param topLeft Offset from the local origin of 0, 0 relative to the current translation
//     * @param size Dimensions of the rectangle to draw
//     * @param alpha Opacity to be applied to the oval from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Whether or not the oval is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [color] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the brush
//     */
//    fun drawOval(
//        color: Color,
//        topLeft: Offset = Offset.Zero,
//        size: Size = this.size.offsetSize(topLeft),
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draw an arc scaled to fit inside the given rectangle. It starts from startAngle degrees
//     * around the oval up to startAngle + sweepAngle degrees around the oval, with zero degrees
//     * being the point on the right hand side of the oval that crosses the horizontal line that
//     * intersects the center of the rectangle and with positive angles going clockwise around the
//     * oval. If useCenter is true, the arc is closed back to the center, forming a circle sector.
//     * Otherwise, the arc is not closed, forming a circle segment.
//     *
//     * @param brush Color or fill to be applied to the arc
//     * @param topLeft Offset from the local origin of 0, 0 relative to the current translation
//     * @param size Dimensions of the arc to draw
//     * @param startAngle Starting angle in degrees. 0 represents 3 o'clock
//     * @param sweepAngle Size of the arc in degrees that is drawn clockwise relative to [startAngle]
//     * @param useCenter Flag indicating if the arc is to close the center of the bounds
//     * @param alpha Opacity to be applied to the arc from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Whether or not the arc is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [brush] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the arc when it is drawn
//     */
//    fun drawArc(
//        brush: Brush,
//        startAngle: Float,
//        sweepAngle: Float,
//        useCenter: Boolean,
//        topLeft: Offset = Offset.Zero,
//        size: Size = this.size.offsetSize(topLeft),
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draw an arc scaled to fit inside the given rectangle. It starts from startAngle degrees
//     * around the oval up to startAngle + sweepAngle degrees around the oval, with zero degrees
//     * being the point on the right hand side of the oval that crosses the horizontal line that
//     * intersects the center of the rectangle and with positive angles going clockwise around the
//     * oval. If useCenter is true, the arc is closed back to the center, forming a circle sector.
//     * Otherwise, the arc is not closed, forming a circle segment.
//     *
//     * @param color Color to be applied to the arc
//     * @param topLeft Offset from the local origin of 0, 0 relative to the current translation
//     * @param size Dimensions of the arc to draw
//     * @param startAngle Starting angle in degrees. 0 represents 3 o'clock
//     * @param sweepAngle Size of the arc in degrees that is drawn clockwise relative to [startAngle]
//     * @param useCenter Flag indicating if the arc is to close the center of the bounds
//     * @param alpha Opacity to be applied to the arc from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Whether or not the arc is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [color] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the arc when it is drawn
//     */
//    fun drawArc(
//        color: Color,
//        startAngle: Float,
//        sweepAngle: Float,
//        useCenter: Boolean,
//        topLeft: Offset = Offset.Zero,
//        size: Size = this.size.offsetSize(topLeft),
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws the given [Path] with the given [Color]. Whether this shape is filled or stroked (or
//     * both) is controlled by [DrawStyle]. If the path is filled, then subpaths within it are
//     * implicitly closed (see [Path.close]).
//     *
//     * @param path Path to draw
//     * @param color Color to be applied to the path
//     * @param alpha Opacity to be applied to the path from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Whether or not the path is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [color] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the path when it is drawn
//     */
//    fun drawPath(
//        path: Path,
//        color: Color,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws the given [Path] with the given [Color]. Whether this shape is filled or stroked (or
//     * both) is controlled by [DrawStyle]. If the path is filled, then subpaths within it are
//     * implicitly closed (see [Path.close]).
//     *
//     * @param path Path to draw
//     * @param brush Brush to be applied to the path
//     * @param alpha Opacity to be applied to the path from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param style Whether or not the path is stroked or filled in
//     * @param colorFilter ColorFilter to apply to the [brush] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the path when it is drawn
//     */
//    fun drawPath(
//        path: Path,
//        brush: Brush,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        style: DrawStyle = Fill,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws a sequence of points according to the given [PointMode].
//     *
//     * The `points` argument is interpreted as offsets from the origin.
//     *
//     * @param points List of points to draw with the specified [PointMode]
//     * @param pointMode [PointMode] used to indicate how the points are to be drawn
//     * @param color Color to be applied to the points
//     * @param alpha Opacity to be applied to the path from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively
//     * @param strokeWidth The stroke width to apply to the line
//     * @param cap Treatment applied to the ends of the line segment
//     * @param pathEffect optional effect or pattern to apply to the point
//     * @param colorFilter ColorFilter to apply to the [color] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the path when it is drawn
//     */
//    fun drawPoints(
//        points: List<Offset>,
//        pointMode: PointMode,
//        color: Color,
//        strokeWidth: Float = Stroke.HairlineWidth,
//        cap: StrokeCap = StrokeCap.Butt,
//        pathEffect: PathEffect? = null,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Draws a sequence of points according to the given [PointMode].
//     *
//     * The `points` argument is interpreted as offsets from the origin.
//     *
//     * @param points List of points to draw with the specified [PointMode]
//     * @param pointMode [PointMode] used to indicate how the points are to be drawn
//     * @param brush Brush to be applied to the points
//     * @param strokeWidth The stroke width to apply to the line
//     * @param cap Treatment applied to the ends of the line segment
//     * @param pathEffect optional effect or pattern to apply to the points
//     * @param alpha Opacity to be applied to the path from 0.0f to 1.0f representing fully
//     *   transparent to fully opaque respectively.
//     * @param colorFilter ColorFilter to apply to the [brush] when drawn into the destination
//     * @param blendMode Blending algorithm to be applied to the path when it is drawn
//     */
//    fun drawPoints(
//        points: List<Offset>,
//        pointMode: PointMode,
//        brush: Brush,
//        strokeWidth: Float = Stroke.HairlineWidth,
//        cap: StrokeCap = StrokeCap.Butt,
//        pathEffect: PathEffect? = null,
//        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0f,
//        colorFilter: ColorFilter? = null,
//        blendMode: BlendMode = DefaultBlendMode,
//    )
//
//    /**
//     * Record the corresponding drawing commands for this [GraphicsLayer] instance using the
//     * [Density], [LayoutDirection] and [IntSize] from the provided [DrawScope] as defaults. This
//     * will retarget the underlying canvas of the provided DrawScope to draw within the layer itself
//     * and reset it to the original canvas on the conclusion of this method call.
//     */
//    fun GraphicsLayer.记录(
//        size: IntSize = this@绘制范围.size.toIntSize(),
//        block: 绘制范围.() -> Unit,
//    ) =
//        record(this@绘制范围, this@绘制范围.layoutDirection, size) {
//            this@绘制范围.draw(
//                // we can use this@record.drawContext directly as the values in this@DrawScope
//                // and this@record are the same
//                drawContext.density,
//                drawContext.layoutDirection,
//                drawContext.canvas,
//                drawContext.size,
//                drawContext.graphicsLayer,
//                block,
//            )
//        }
//
//
//    /** Helper method to offset the provided size with the offset in box width and height */
//    private fun Size.offsetSize(offset: Offset): Size =
//        Size(this.width - offset.x, this.height - offset.y)
//
//    companion object {
//
//        /**
//         * Default blending mode used for each drawing operation. This ensures that content is drawn
//         * on top of the pixels in the destination
//         */
//        val DefaultBlendMode: BlendMode = BlendMode.SrcOver
//
//        /**
//         * Default FilterQuality used for determining the filtering algorithm to apply when scaling
//         * [ImageBitmap] objects. Maps to the default behavior of bilinear filtering
//         */
//        val DefaultFilterQuality: FilterQuality = FilterQuality.Low
//    }
//}

/**
 * 提供用于以描边方式绘制内容的信息的 [DrawStyle]。
 *
 * @param 宽度 以像素为单位配置描边的宽度。
 * @param 斜接 设置描边斜接值。用于控制当连接角度较尖锐时斜接连接的行为。此值必须 >= 0。
 * @param 端点 返回画笔的 Cap，控制描边线条和路径的起点和终点的处理方式。默认为 [StrokeCap.Butt]。
 * @param 连接 设置描边路径中线条和曲线段连接处的处理方式。默认为 [StrokeJoin.Miter]。
 * @param 路径效果 应用于描边的效果，null 表示绘制实心描边线条。
 */
fun 描边(
    宽度: Float = 0.0f,
    斜接: Float = Stroke.DefaultMiter,
    端点: StrokeCap = Stroke.DefaultCap,
    连接: StrokeJoin = Stroke.DefaultJoin,
    路径效果: PathEffect? = null,
) =
    Stroke(
        width = 宽度,
        miter = 斜接,
        cap = 端点,
        join = 连接,
        pathEffect = 路径效果,
    )


object 描边{

    /** 表示 1 像素细线描边的宽度。*/
    const val 细线宽度 = Stroke.HairlineWidth

    /** 与连接方式配合使用的默认斜接长度。 */
    const val 默认斜接: Float = Stroke.DefaultMiter

    /** 用于线条末端的默认端帽。 */
    val 默认端点 = Stroke.DefaultCap

    /** 用于线条和曲线段之间连接的默认连接样式。 */
    val 默认连接 = Stroke.DefaultJoin

}
