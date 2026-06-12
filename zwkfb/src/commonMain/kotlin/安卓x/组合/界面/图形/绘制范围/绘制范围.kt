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
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.rotateRad
import androidx.compose.ui.graphics.drawscope.translate
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

///**
// * Add an axis-aligned scale to the current transform, scaling by the first argument in the
// * horizontal direction and the second in the vertical direction at the given pivot coordinate. The
// * pivot coordinate remains unchanged by the scale transformation. After this method is invoked, the
// * coordinate space is returned to the state before the scale was applied.
// *
// * @param scaleX The amount to scale in X
// * @param scaleY The amount to scale in Y
// * @param pivot The coordinate for the pivot point, defaults to the center of the coordinate space
// * @param block lambda used to issue drawing commands within the scaled coordinate space
// */
//inline fun DrawScope.scale(
//    scaleX: Float,
//    scaleY: Float,
//    pivot: Offset = center,
//    block: DrawScope.() -> Unit,
//) = withTransform({ scale(scaleX, scaleY, pivot) }, block)
//
///**
// * Add an axis-aligned scale to the current transform, scaling both the horizontal direction and the
// * vertical direction at the given pivot coordinate. The pivot coordinate remains unchanged by the
// * scale transformation. After this method is invoked, the coordinate space is returned to the state
// * before the scale was applied.
// *
// * @param scale The amount to scale uniformly in both directions
// * @param pivot The coordinate for the pivot point, defaults to the center of the coordinate space
// * @param block lambda used to issue drawing commands within the scaled coordinate space
// */
//inline fun DrawScope.scale(scale: Float, pivot: Offset = center, block: DrawScope.() -> Unit) =
//    withTransform({ scale(scale, scale, pivot) }, block)
//
///**
// * Reduces the clip region to the intersection of the current clip and the given rectangle indicated
// * by the given left, top, right and bottom bounds. This provides a callback to issue drawing
// * commands within the clipped region. After this method is invoked, this clip is no longer applied.
// *
// * Use [ClipOp.Difference] to subtract the provided rectangle from the current clip.
// *
// * @param left Left bound of the rectangle to clip
// * @param top Top bound of the rectangle to clip
// * @param right Right bound of the rectangle to clip
// * @param bottom Bottom bound of the rectangle to clip
// * @param clipOp Clipping operation to conduct on the given bounds, defaults to [ClipOp.Intersect]
// * @param block Lambda callback with this CanvasScope as a receiver scope to issue drawing commands
// *   within the provided clip
// */
//inline fun DrawScope.clipRect(
//    left: Float = 0.0f,
//    top: Float = 0.0f,
//    right: Float = size.width,
//    bottom: Float = size.height,
//    clipOp: ClipOp = ClipOp.Intersect,
//    block: DrawScope.() -> Unit,
//) = withTransform({ clipRect(left, top, right, bottom, clipOp) }, block)
//
///**
// * Reduces the clip region to the intersection of the current clip and the given path. This method
// * provides a callback to issue drawing commands within the region defined by the clipped path.
// * After this method is invoked, this clip is no longer applied.
// *
// * @param path Shape to clip drawing content within
// * @param clipOp Clipping operation to conduct on the given bounds, defaults to [ClipOp.Intersect]
// * @param block Lambda callback with this CanvasScope as a receiver scope to issue drawing commands
// *   within the provided clip
// */
//inline fun DrawScope.clipPath(
//    path: Path,
//    clipOp: ClipOp = ClipOp.Intersect,
//    block: DrawScope.() -> Unit,
//) = withTransform({ clipPath(path, clipOp) }, block)
//
///**
// * Provides access to draw directly with the underlying [Canvas]. This is helpful for situations to
// * re-use alternative drawing logic in combination with [DrawScope]
// *
// * @param block Lambda callback to issue drawing commands on the provided [Canvas]
// */
//inline fun DrawScope.drawIntoCanvas(block: (Canvas) -> Unit) = block(drawContext.canvas)
//
///**
// * Perform 1 or more transformations and execute drawing commands with the specified transformations
// * applied. After this call is complete, the transformation before this call was made is restored
// *
// * @param transformBlock Callback invoked to issue transformations to be made before the drawing
// *   operations are issued
// * @param drawBlock Callback invoked to issue drawing operations after the transformations are
// *   applied
// */
//inline fun DrawScope.withTransform(
//    transformBlock: DrawTransform.() -> Unit,
//    drawBlock: DrawScope.() -> Unit,
//) =
//    with(drawContext) {
//        // Transformation can include inset calls which change the drawing area
//        // so cache the previous size before the transformation is done
//        // and reset it afterwards
//        val previousSize = size
//        canvas.save()
//        try {
//            transformBlock(transform)
//            drawBlock()
//        } finally {
//            canvas.restore()
//            size = previousSize
//        }
//    }
//
//
///**
// * Draws into the provided [Canvas] with the commands specified in the lambda with this [DrawScope]
// * as a receiver
// *
// * @param density [Density] used to assist in conversions of density independent pixels to raw
// *   pixels to draw
// * @param layoutDirection [LayoutDirection] of the layout being drawn in.
// * @param canvas target canvas to render into
// * @param size bounds relative to the current canvas translation in which the [DrawScope] should
// *   draw within
// * @param graphicsLayer Current [GraphicsLayer] we are drawing into. Might be null if the [canvas]
// *   is not provided by a [GraphicsLayer], for example in the case of a software-accelerated drawing
// * @param block lambda that is called to issue drawing commands on this [DrawScope]
// */
//inline fun DrawScope.draw(
//    density: Density,
//    layoutDirection: LayoutDirection,
//    canvas: Canvas,
//    size: Size,
//    graphicsLayer: GraphicsLayer? = null,
//    block: DrawScope.() -> Unit,
//) {
//    // Remember the previous drawing parameters in case we are temporarily re-directing our
//    // drawing to a separate Layer/RenderNode only to draw that content back into the original
//    // Canvas. If there is no previous canvas that was being drawing into, this ends up
//    // resetting these parameters back to defaults defensively
//    val prevDensity = drawContext.density
//    val prevLayoutDirection = drawContext.layoutDirection
//    val prevCanvas = drawContext.canvas
//    val prevSize = drawContext.size
//    val prevLayer = drawContext.graphicsLayer
//    drawContext.apply {
//        this.density = density
//        this.layoutDirection = layoutDirection
//        this.canvas = canvas
//        this.size = size
//        this.graphicsLayer = graphicsLayer
//    }
//    canvas.save()
//    try {
//        this.block()
//    } finally {
//        canvas.restore()
//        drawContext.apply {
//            this.density = prevDensity
//            this.layoutDirection = prevLayoutDirection
//            this.canvas = prevCanvas
//            this.size = prevSize
//            this.graphicsLayer = prevLayer
//        }
//    }
//}
//
//
///**
// * Draws into the provided [Canvas] with the commands specified in the lambda with this [DrawScope]
// * as a receiver
// *
// * @param density [Density] used to assist in conversions of density independent pixels to raw
// *   pixels to draw
// * @param layoutDirection [LayoutDirection] of the layout being drawn in.
// * @param canvas target canvas to render into
// * @param size bounds relative to the current canvas translation in which the [DrawScope] should
// *   draw within
// * @param graphicsLayer Current [GraphicsLayer] we are drawing into. Might be null if the [canvas]
// *   is not provided by a [GraphicsLayer], for example in the case of a software-accelerated drawing
// * @param block lambda that is called to issue drawing commands on this [DrawScope]
// */
//inline fun 绘制范围.draw(
//    density: Density,
//    layoutDirection: LayoutDirection,
//    canvas: Canvas,
//    size: Size,
//    graphicsLayer: GraphicsLayer? = null,
//    block: 绘制范围.() -> Unit,
//) {
//    // Remember the previous drawing parameters in case we are temporarily re-directing our
//    // drawing to a separate Layer/RenderNode only to draw that content back into the original
//    // Canvas. If there is no previous canvas that was being drawing into, this ends up
//    // resetting these parameters back to defaults defensively
//    val prevDensity = drawContext.density
//    val prevLayoutDirection = drawContext.layoutDirection
//    val prevCanvas = drawContext.canvas
//    val prevSize = drawContext.size
//    val prevLayer = drawContext.graphicsLayer
//    drawContext.apply {
//        this.density = density
//        this.layoutDirection = layoutDirection
//        this.canvas = canvas
//        this.size = size
//        this.graphicsLayer = graphicsLayer
//    }
//    canvas.save()
//    try {
//        this.block()
//    } finally {
//        canvas.restore()
//        drawContext.apply {
//            this.density = prevDensity
//            this.layoutDirection = prevLayoutDirection
//            this.canvas = prevCanvas
//            this.size = prevSize
//            this.graphicsLayer = prevLayer
//        }
//    }
//}
//
//
//fun GraphicsLayer.记录(
//    size: IntSize = this.size.toIntSize(),
//    block: DrawScope.() -> Unit,
//) =
//    record(this, this.layoutDirection, size) {
//        this.draw(
//            // we can use this@record.drawContext directly as the values in this@DrawScope
//            // and this@record are the same
//            drawContext.density,
//            drawContext.layoutDirection,
//            drawContext.canvas,
//            drawContext.size,
//            drawContext.graphicsLayer,
//            block,
//        )
//    }
//
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
//
///**
// * [DrawStyle] that provides information for drawing content with a stroke
// *
// * @param width Configure the width of the stroke in pixels
// * @param miter Set the stroke miter value. This is used to control the behavior of miter joins when
// *   the joins angle is sharp. This value must be >= 0
// * @param cap Return the paint's Cap, controlling how the start and end of stroked lines and paths
// *   are treated. The default is [StrokeCap.Butt]
// * @param join Set's the treatment where lines and curve segments join on a stroked path. The
// *   default is [StrokeJoin.Miter]
// * @param pathEffect Effect to apply to the stroke, null indicates a solid stroke line is to be
// *   drawn
// */
//fun 描边(
//    width: Float = 0.0f,
//    miter: Float = Stroke.DefaultMiter,
//    cap: StrokeCap = Stroke.DefaultCap,
//    join: StrokeJoin = Stroke.DefaultJoin,
//    pathEffect: PathEffect? = null,
//) =
//    Stroke(
//        width = width,
//        miter = miter,
//        cap = cap,
//        join = join,
//        pathEffect = pathEffect,
//    )
//
//
//object 描边{
//
//    /** Width to indicate a hairline stroke of 1 pixel */
//    const val HairlineWidth = Stroke.HairlineWidth
//
//    /** Default miter length used in combination with joins */
//    const val DefaultMiter: Float = Stroke.DefaultMiter
//
//    /** Default cap used for line endings */
//    val DefaultCap = Stroke.DefaultCap
//
//    /** Default join style used for connections between line and curve segments */
//    val DefaultJoin = Stroke.DefaultJoin
//
//}