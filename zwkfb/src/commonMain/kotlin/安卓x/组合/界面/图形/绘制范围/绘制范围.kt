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


/**
 * 使用提供的 [Canvas] 创建一个作用域绘图环境。这提供了一种声明式、无状态的 API，用于绘制形状和路径，而无需使用者维护底层
 * [Canvas] 状态信息。[DrawScope] 实现还提供了尺寸信息，并且变换是相对于本地平移进行的。即左侧和顶部坐标始终为原点，
 * 右侧和底部坐标始终分别为指定的宽度和高度。绘制内容不会被裁剪，因此可以在指定边界之外进行绘制。
 */
@DrawScopeMarker
interface 绘制范围 : Density { // DrawScope

    /** 包含创建绘图环境所需依赖项的当前 [DrawContext]。*/
    val 绘制上下文: DrawContext // drawContext

    /** 当前绘图环境边界的中心点 */
    val 中心: Offset // center
        get() = 绘制上下文.size.center

    /** 提供当前绘图环境的尺寸 */
    val 大小: Size // size
        get() = 绘制上下文.size

    /** 正在绘制的布局的布局方向 */
    val 布局方向: LayoutDirection // layoutDirection

    /**
     * 使用给定的画笔在给定点之间绘制一条线。该线为描边样式。
     *
     * @param 画刷 应用于线条的颜色或填充
     * @param 起始 要绘制的线条的第一个点
     * @param 结束 要绘制的线条的第二个点
     * @param 描边宽度 应用于线条的描边宽度
     * @param 端点 应用于线段端点的处理方式
     * @param 路径效果 应用于线条的可选效果或图案
     * @param 透明度 应用于 [画刷] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 颜色过滤器 绘制到目标时应用于 [画刷] 的 ColorFilter
     * @param 混合模式 应用于 [画刷] 的混合算法
     */
    fun 绘制线条(
        画刷: Brush,
        起始: Offset,
        结束: Offset,
        描边宽度: Float = Stroke.HairlineWidth,
        端点: StrokeCap = Stroke.DefaultCap,
        路径效果: PathEffect? = null,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 使用给定的画笔在给定点之间绘制一条线。该线为描边样式。
     *
     * @param 颜色 应用于线条的颜色
     * @param 起始 要绘制的线条的第一个点
     * @param 结束 要绘制的线条的第二个点
     * @param 描边宽度 应用于线条的描边宽度
     * @param 端点 应用于线段端点的处理方式
     * @param 路径效果 应用于线条的可选效果或图案
     * @param 透明度 应用于 [颜色] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 颜色过滤器 绘制到目标时应用于 [颜色] 的 ColorFilter
     * @param 混合模式 应用于 [颜色] 的混合算法
     */
    fun 绘制线条(
        颜色: Color,
        起始: Offset,
        结束: Offset,
        描边宽度: Float = Stroke.HairlineWidth,
        端点: StrokeCap = Stroke.DefaultCap,
        路径效果: PathEffect? = null,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 使用给定的偏移量和尺寸绘制矩形。如果未提供相对于左上角的偏移量，则从当前平移的原点开始绘制。如果未提供尺寸，则使用当前环境的尺寸。
     *
     * @param 画刷 应用于矩形的颜色或填充
     * @param 左上角 相对于当前平移的本地原点 (0, 0) 的偏移量
     * @param 大小 要绘制的矩形的尺寸
     * @param 透明度 应用于 [画刷] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 矩形是描边还是填充
     * @param 颜色过滤器 绘制到目标时应用于 [画刷] 的 ColorFilter
     * @param 混合模式 应用于目标的混合算法
     */
    fun 绘制矩形(
        画刷: Brush,
        左上角: Offset = Offset.Zero,
        大小: Size = this.大小.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 使用给定的偏移量和尺寸绘制矩形。如果未提供相对于左上角的偏移量，则从当前平移的原点开始绘制。如果未提供尺寸，则使用当前环境的尺寸。
     *
     * @param 颜色 应用于矩形的颜色
     * @param 左上角 相对于当前平移的本地原点 (0, 0) 的偏移量
     * @param 大小 要绘制的矩形的尺寸
     * @param 透明度 应用于 [颜色] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 矩形是描边还是填充
     * @param 颜色过滤器 应用于 [颜色] 源像素的颜色滤镜
     * @param 混合模式 应用于目标的混合算法
     */
    fun 绘制矩形(
        颜色: Color,
        左上角: Offset = Offset.Zero,
        大小: Size = this.大小.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 使用给定的 [Paint] 将 [ImageBitmap] 绘制到画布中，其左上角位于给定的 [Offset] 处。图像通过给定的 [Paint] 合成到画布上。
     *
     * @param 图像 要绘制的 [ImageBitmap]
     * @param 左上角 相对于当前平移的本地原点 (0, 0) 的偏移量
     * @param 透明度 应用于 [图像] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 指定图像是填充绘制还是作为矩形描边绘制
     * @param 颜色过滤器 绘制到目标时应用于 [图像] 的 ColorFilter
     * @param 混合模式 应用于目标的混合算法
     */
    fun 绘制图像(
        图像: ImageBitmap,
        左上角: Offset = Offset.Zero,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 将给定图像中由 `src` 参数描述的子集绘制到画布中由 `dst` 参数指定的轴对齐矩形区域内。
     *
     * 如果未提供 src 矩形，则整个图像将缩放到对应的目标边界内。
     *
     * @param 图像 要绘制的源图像
     * @param 源偏移量 表示要绘制的源图像左上角的偏移量，默认为 [图像] 的原点。
     * @param 源大小 要绘制的源图像相对于 [源偏移量] 的可选尺寸，默认为 [图像] 的宽度和高度。
     * @param 目标偏移量 表示在目标中绘制给定图像的左上角偏移量，默认为当前平移的原点。
     * @param 目标大小 要绘制的目标的可选尺寸，默认为 [源大小]。
     * @param 透明度 应用于 [图像] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 指定图像是填充绘制还是作为矩形描边绘制
     * @param 颜色过滤器 绘制到目标时应用于 [图像] 的 ColorFilter
     * @param 混合模式 应用于目标的混合算法
     * @param 过滤器质量 应用于 [图像] 缩放并绘制到目标时的采样算法。默认为 [FilterQuality.Low]，使用双线性采样算法进行缩放。
     */
    fun 绘制图像(
        图像: ImageBitmap,
        源偏移量: IntOffset = IntOffset.Zero,
        源大小: IntSize = IntSize(图像.width, 图像.height),
        目标偏移量: IntOffset = IntOffset.Zero,
        目标大小: IntSize = 源大小,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
        过滤器质量: FilterQuality = DrawScope.DefaultFilterQuality,
    )


    /**
     * 使用提供的尺寸、偏移量以及 x 轴和 y 轴的圆角半径分别绘制一个圆角矩形。该矩形使用提供的 [Brush] 参数绘制，
     * 并根据给定的 [DrawStyle] 进行填充或描边。
     *
     * @param 画刷 要应用到圆角矩形的颜色或填充
     * @param 左上角 相对于当前变换，从本地原点 (0, 0) 的偏移量
     * @param 大小 要绘制的矩形的尺寸
     * @param 圆角半径 圆角矩形的圆角半径，负值将被钳制到 0
     * @param 透明度 要应用到圆角矩形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 指定圆角矩形是描边还是填充
     * @param 颜色过滤器 绘制到目标时应用到 [画刷] 的色彩滤镜
     * @param 混合模式 要应用到画刷的混合算法
     */
    fun 绘制圆角矩形(
        画刷: Brush,
        左上角: Offset = Offset.Zero,
        大小: Size = this.大小.offsetSize(左上角),
        圆角半径: CornerRadius = CornerRadius.Zero,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 使用给定的 [Paint] 绘制一个圆角矩形。矩形是填充还是描边（或两者兼有）由 [Paint.style] 控制。
     *
     * @param 颜色 要应用到圆角矩形的颜色
     * @param 左上角 相对于当前变换，从本地原点 (0, 0) 的偏移量
     * @param 大小 要绘制的矩形的尺寸
     * @param 圆角半径 圆角矩形的圆角半径，负值将被钳制到 0
     * @param 透明度 要应用到圆角矩形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 指定圆角矩形是描边还是填充
     * @param 颜色过滤器 绘制到目标时应用到 [颜色] 的色彩滤镜
     * @param 混合模式 要应用到颜色的混合算法
     */
    fun 绘制圆角矩形(
        颜色: Color,
        左上角: Offset = Offset.Zero,
        大小: Size = this.大小.offsetSize(左上角),
        圆角半径: CornerRadius = CornerRadius.Zero,
        样式: DrawStyle = Fill,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 在提供的中心坐标和半径处绘制圆形。如果未提供中心点，则使用边界的中心。
     *
     * @param 画刷 要应用到圆形的颜色或填充
     * @param 半径 圆形的半径
     * @param 中心 要绘制圆形的中心坐标
     * @param 透明度 要应用到圆形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 指定圆形是描边还是填充
     * @param 颜色过滤器 绘制到目标时应用到 [画刷] 的色彩滤镜
     * @param 混合模式 要应用到画刷的混合算法
     */
    fun 绘制圆形(
        画刷: Brush,
        半径: Float = this.大小.minDimension / 2.0f,
        中心: Offset = this.中心,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 在提供的中心坐标和半径处绘制圆形。如果未提供中心点，则使用边界的中心。
     *
     * @param 颜色 要应用到圆形的颜色或填充
     * @param 半径 圆形的半径
     * @param 中心 要绘制圆形的中心坐标
     * @param 透明度 要应用到圆形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 指定圆形是描边还是填充
     * @param 颜色过滤器 绘制到目标时应用到 [颜色] 的色彩滤镜
     * @param 混合模式 要应用到画刷的混合算法
     */
    fun 绘制圆形(
        颜色: Color,
        半径: Float = this.大小.minDimension / 2.0f,
        中心: Offset = this.中心,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 使用给定的偏移量和尺寸绘制椭圆形。如果未提供相对于左上角的偏移量，则从当前变换的原点开始绘制。如果未提供尺寸，则使用当前环境的尺寸。
     *
     * @param 画刷 要应用到椭圆形的颜色或填充
     * @param 左上角 相对于当前变换，从本地原点 (0, 0) 的偏移量
     * @param 大小 要绘制的矩形的尺寸
     * @param 透明度 要应用到椭圆形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 指定椭圆形是描边还是填充
     * @param 颜色过滤器 绘制到目标时应用到 [画刷] 的色彩滤镜
     * @param 混合模式 要应用到画刷的混合算法
     */
    fun 绘制椭圆形(
        画刷: Brush,
        左上角: Offset = Offset.Zero,
        大小: Size = this.大小.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 使用给定的偏移量和尺寸绘制椭圆形。如果未提供相对于左上角的偏移量，则从当前变换的原点开始绘制。如果未提供尺寸，则使用当前环境的尺寸。
     *
     * @param 颜色 要应用到椭圆形的颜色
     * @param 左上角 相对于当前变换，从本地原点 (0, 0) 的偏移量
     * @param 大小 要绘制的矩形的尺寸
     * @param 透明度 要应用到椭圆形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 指定椭圆形是描边还是填充
     * @param 颜色过滤器 绘制到目标时应用到 [颜色] 的色彩滤镜
     * @param 混合模式 要应用到画刷的混合算法
     */
    fun 绘制椭圆形(
        颜色: Color,
        左上角: Offset = Offset.Zero,
        大小: Size = this.大小.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 绘制一个按比例缩放以适配给定矩形内部的圆弧。它从椭圆上 `起始角度` 度处开始，到椭圆上 `起始角度` + `扫描角度`
     * 度处结束，其中零度是椭圆右侧与穿过矩形中心的水平线相交的点，正角度沿椭圆顺时针方向增加。如果 `使用中心` 为 true，
     * 则圆弧会闭合回中心，形成一个扇形；否则圆弧不闭合，形成一个弓形。
     *
     * @param 画刷 要应用于圆弧的颜色或填充。
     * @param 左上角 相对于当前平移，从局部原点 (0, 0) 的偏移量。
     * @param 大小 要绘制的圆弧的尺寸。
     * @param 起始角度 起始角度，以度为单位。0 表示 3 点钟方向。
     * @param 扫描角度 相对于 [起始角度] 顺时针绘制的圆弧大小，以度为单位。
     * @param 使用中心 指示圆弧是否闭合回边界中心的标志。
     * @param 透明度 要应用于圆弧的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 圆弧是描边还是填充。
     * @param 颜色过滤器 绘制到目标时应用于 [画刷] 的 ColorFilter。
     * @param 混合模式 绘制圆弧时要应用的混合算法。
     */
    fun 绘制圆弧(
        画刷: Brush,
        起始角度: Float,
        扫描角度: Float,
        使用中心: Boolean,
        左上角: Offset = Offset.Zero,
        大小: Size = this.大小.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 绘制一个按比例缩放以适配给定矩形内部的圆弧。它从椭圆上 `起始角度` 度处开始，到椭圆上 `起始角度` + `扫描角度`
     * 度处结束，其中零度是椭圆右侧与穿过矩形中心的水平线相交的点，正角度沿椭圆顺时针方向增加。如果 `使用中心` 为 true，
     * 则圆弧会闭合回中心，形成一个扇形；否则圆弧不闭合，形成一个弓形。
     *
     * @param 颜色 要应用于圆弧的颜色。
     * @param 左上角 相对于当前平移，从局部原点 (0, 0) 的偏移量。
     * @param 大小 要绘制的圆弧的尺寸。
     * @param 起始角度 起始角度，以度为单位。0 表示 3 点钟方向。
     * @param 扫描角度 相对于 [起始角度] 顺时针绘制的圆弧大小，以度为单位。
     * @param 使用中心 指示圆弧是否闭合回边界中心的标志。
     * @param 透明度 要应用于圆弧的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 圆弧是描边还是填充。
     * @param 颜色过滤器 绘制到目标时应用于 [颜色] 的 ColorFilter。
     * @param 混合模式 绘制圆弧时要应用的混合算法。
     */
    fun 绘制圆弧(
        颜色: Color,
        起始角度: Float,
        扫描角度: Float,
        使用中心: Boolean,
        左上角: Offset = Offset.Zero,
        大小: Size = this.大小.offsetSize(左上角),
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 使用给定的 [Color] 绘制指定的 [Path]。该形状是填充还是描边（或两者兼有）由 [DrawStyle] 控制。如果路径被填充，
     * 则其中的子路径会被隐式闭合（请参阅 [Path.close]）。
     *
     * @param 路径 要绘制的路径
     * @param 颜色 要应用于路径的颜色
     * @param 透明度 要应用于路径的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 路径是描边还是填充
     * @param 颜色过滤器 绘制到目标时应用于 [颜色] 的 ColorFilter。
     * @param 混合模式 绘制路径时要应用的混合算法。
     */
    fun 绘制路径(
        路径: Path,
        颜色: Color,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 使用给定的 [Color] 绘制指定的 [Path]。该形状是填充还是描边（或两者兼有）由 [DrawStyle] 控制。如果路径被填充，
     * 则其中的子路径会被隐式闭合（请参阅 [Path.close]）。
     *
     * @param 路径 要绘制的路径
     * @param 画刷 要应用于路径的画刷
     * @param 透明度 要应用于路径的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 样式 路径是描边还是填充
     * @param 颜色过滤器 绘制到目标时应用于 [画刷] 的 ColorFilter。
     * @param 混合模式 绘制路径时要应用的混合算法。
     */
    fun 绘制路径(
        路径: Path,
        画刷: Brush,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        样式: DrawStyle = Fill,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 根据给定的 [PointMode] 绘制一系列点。
     *
     * `点集` 参数被解释为相对于原点的偏移量。
     *
     * @param 点集 使用指定的 [PointMode] 绘制的点列表。
     * @param 点模式 用于指示如何绘制点的 [PointMode]。
     * @param 颜色 要应用于点的颜色。
     * @param 透明度 要应用于路径的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 描边宽度 应用于线条的描边宽度。
     * @param 端点 应用于线段端点的处理方式。
     * @param 路径效果 要应用于点的可选效果或图案。
     * @param 颜色过滤器 绘制到目标时应用于 [颜色] 的 ColorFilter。
     * @param 混合模式 绘制路径时要应用的混合算法。
     */
    fun 绘制点集(
        点集: List<Offset>,
        点模式: PointMode,
        颜色: Color,
        描边宽度: Float = Stroke.HairlineWidth,
        端点: StrokeCap = StrokeCap.Butt,
        路径效果: PathEffect? = null,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     * 根据给定的 [PointMode] 绘制一系列点。
     *
     * `点集` 参数被解释为相对于原点的偏移量。
     *
     * @param 点集 使用指定的 [PointMode] 绘制的点列表。
     * @param 点模式 用于指示如何绘制点的 [PointMode]。
     * @param 画刷 要应用于点的画刷。
     * @param 描边宽度 应用于线条的描边宽度。
     * @param 端点 应用于线段端点的处理方式。
     * @param 路径效果 要应用于点的可选效果或图案。
     * @param 透明度 要应用于路径的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
     * @param 颜色过滤器 绘制到目标时应用于 [画刷] 的 ColorFilter。
     * @param 混合模式 绘制路径时要应用的混合算法。
     */
    fun 绘制点集(
        点集: List<Offset>,
        点模式: PointMode,
        画刷: Brush,
        描边宽度: Float = Stroke.HairlineWidth,
        端点: StrokeCap = StrokeCap.Butt,
        路径效果: PathEffect? = null,
        @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
        颜色过滤器: ColorFilter? = null,
        混合模式: BlendMode = DrawScope.DefaultBlendMode,
    )

    /**
     *  使用提供的 [DrawScope] 中的 [Density]、[LayoutDirection] 和 [IntSize] 作为默认值，记录此 [GraphicsLayer]
     *  实例对应的绘制命令。这会将提供的 DrawScope 的底层画布重定向到在该图层内部进行绘制，并在方法调用结束时将其重置为原始画布。
     */
    fun GraphicsLayer.记录(
        大小: IntSize = this@绘制范围.大小.toIntSize(),
        块: DrawScope.() -> Unit,
    ) =
        record(this@绘制范围, this@绘制范围.布局方向, 大小) {
            this.draw(
                // 我们可以直接使用 `this@record.drawContext`，因为 `this@DrawScope` 和 `this@record` 中的值是相同的。
                drawContext.density,
                drawContext.layoutDirection,
                drawContext.canvas,
                drawContext.size,
                drawContext.graphicsLayer,
                block = 块,
            )
        }

    /** 辅助方法，用于在框宽和框高方向上偏移所提供的尺寸。 */
    private fun Size.offsetSize(offset: Offset): Size =
        Size(this.width - offset.x, this.height - offset.y)

    companion object {

        /** 每个绘制操作使用的默认混合模式。这确保内容绘制在目标像素的上方。 */
        val 默认混合模式: BlendMode = DrawScope.DefaultBlendMode

        /** 确定缩放 [ImageBitmap] 对象时应用的过滤算法的默认 FilterQuality。对应双线性过滤的默认行为。 */
        val 默认过滤质量: FilterQuality = DrawScope.DefaultFilterQuality
    }

}


//=============================================================================================

/** 包含创建绘图环境所需依赖项的当前 [DrawContext]。*/
val DrawScope.绘制上下文: DrawContext
    get() = this.drawContext

/** 当前绘图环境边界的中心点 */
val DrawScope.中心: Offset // center
    get() = this.center

/** 提供当前绘图环境的尺寸 */
val DrawScope.大小: Size // size
    get() = this.size

/** 正在绘制的布局的布局方向 */
val DrawScope.布局方向: LayoutDirection
    get() = this.layoutDirection


/**
 * 使用给定的画笔在给定点之间绘制一条线。该线为描边样式。
 *
 * @param 画刷 应用于线条的颜色或填充
 * @param 起始 要绘制的线条的第一个点
 * @param 结束 要绘制的线条的第二个点
 * @param 描边宽度 应用于线条的描边宽度
 * @param 端点 应用于线段端点的处理方式
 * @param 路径效果 应用于线条的可选效果或图案
 * @param 透明度 应用于 [画刷] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 颜色过滤器 绘制到目标时应用于 [画刷] 的 ColorFilter
 * @param 混合模式 应用于 [画刷] 的混合算法
 */
fun DrawScope.绘制线条(
    画刷: Brush,
    起始: Offset,
    结束: Offset,
    描边宽度: Float = Stroke.HairlineWidth,
    端点: StrokeCap = Stroke.DefaultCap,
    路径效果: PathEffect? = null,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawLine(
        brush = 画刷,
        start = 起始,
        end = 结束,
        strokeWidth = 描边宽度,
        cap = 端点,
        pathEffect = 路径效果,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

/**
 * 使用给定的画笔在给定点之间绘制一条线。该线为描边样式。
 *
 * @param 颜色 应用于线条的颜色
 * @param 起始 要绘制的线条的第一个点
 * @param 结束 要绘制的线条的第二个点
 * @param 描边宽度 应用于线条的描边宽度
 * @param 端点 应用于线段端点的处理方式
 * @param 路径效果 应用于线条的可选效果或图案
 * @param 透明度 应用于 [颜色] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 颜色过滤器 绘制到目标时应用于 [颜色] 的 ColorFilter
 * @param 混合模式 应用于 [颜色] 的混合算法
 */
fun DrawScope.绘制线条(
    颜色: Color,
    起始: Offset,
    结束: Offset,
    描边宽度: Float = Stroke.HairlineWidth,
    端点: StrokeCap = Stroke.DefaultCap,
    路径效果: PathEffect? = null,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawLine(
        color = 颜色,
        start = 起始,
        end = 结束,
        strokeWidth = 描边宽度,
        cap = 端点,
        pathEffect = 路径效果,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )


/**
 * 使用给定的偏移量和尺寸绘制矩形。如果未提供相对于左上角的偏移量，则从当前平移的原点开始绘制。如果未提供尺寸，则使用当前环境的尺寸。
 *
 * @param 画刷 应用于矩形的颜色或填充
 * @param 左上角 相对于当前平移的本地原点 (0, 0) 的偏移量
 * @param 大小 要绘制的矩形的尺寸
 * @param 透明度 应用于 [画刷] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 矩形是描边还是填充
 * @param 颜色过滤器 绘制到目标时应用于 [画刷] 的 ColorFilter
 * @param 混合模式 应用于目标的混合算法
 */
fun DrawScope.绘制矩形(
    画刷: Brush,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawRect(
        brush = 画刷,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

/**
 * 使用给定的偏移量和尺寸绘制矩形。如果未提供相对于左上角的偏移量，则从当前平移的原点开始绘制。如果未提供尺寸，则使用当前环境的尺寸。
 *
 * @param 颜色 应用于矩形的颜色
 * @param 左上角 相对于当前平移的本地原点 (0, 0) 的偏移量
 * @param 大小 要绘制的矩形的尺寸
 * @param 透明度 应用于 [颜色] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 矩形是描边还是填充
 * @param 颜色过滤器 应用于 [颜色] 源像素的颜色滤镜
 * @param 混合模式 应用于目标的混合算法
 */
fun DrawScope.绘制矩形(
    颜色: Color,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawRect(
        color = 颜色,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )


/**
 * 使用给定的 [Paint] 将 [ImageBitmap] 绘制到画布中，其左上角位于给定的 [Offset] 处。图像通过给定的 [Paint] 合成到画布上。
 *
 * @param 图像 要绘制的 [ImageBitmap]
 * @param 左上角 相对于当前平移的本地原点 (0, 0) 的偏移量
 * @param 透明度 应用于 [图像] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 指定图像是填充绘制还是作为矩形描边绘制
 * @param 颜色过滤器 绘制到目标时应用于 [图像] 的 ColorFilter
 * @param 混合模式 应用于目标的混合算法
 */
fun DrawScope.绘制图像(
    图像: ImageBitmap,
    左上角: Offset = Offset.Zero,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawImage(
        image = 图像,
        topLeft = 左上角,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

/**
 * 将给定图像中由 `src` 参数描述的子集绘制到画布中由 `dst` 参数指定的轴对齐矩形区域内。
 *
 * 如果未提供 src 矩形，则整个图像将缩放到对应的目标边界内。
 *
 * @param 图像 要绘制的源图像
 * @param 源偏移量 表示要绘制的源图像左上角的偏移量，默认为 [图像] 的原点。
 * @param 源大小 要绘制的源图像相对于 [源偏移量] 的可选尺寸，默认为 [图像] 的宽度和高度。
 * @param 目标偏移量 表示在目标中绘制给定图像的左上角偏移量，默认为当前平移的原点。
 * @param 目标大小 要绘制的目标的可选尺寸，默认为 [源大小]。
 * @param 透明度 应用于 [图像] 的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 指定图像是填充绘制还是作为矩形描边绘制
 * @param 颜色过滤器 绘制到目标时应用于 [图像] 的 ColorFilter
 * @param 混合模式 应用于目标的混合算法
 * @param 过滤器质量 应用于 [图像] 缩放并绘制到目标时的采样算法。默认为 [FilterQuality.Low]，使用双线性采样算法进行缩放。
 */
fun DrawScope.绘制图像(
    图像: ImageBitmap,
    源偏移量: IntOffset = IntOffset.Zero,
    源大小: IntSize = IntSize(图像.width, 图像.height),
    目标偏移量: IntOffset = IntOffset.Zero,
    目标大小: IntSize = 源大小,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
    过滤器质量: FilterQuality = DrawScope.DefaultFilterQuality,
) =
    this.drawImage(
        image = 图像,
        srcOffset = 源偏移量,
        srcSize = 源大小,
        dstOffset = 目标偏移量,
        dstSize = 目标大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
        filterQuality = 过滤器质量,
    )


/**
 * 使用提供的尺寸、偏移量以及 x 轴和 y 轴的圆角半径分别绘制一个圆角矩形。该矩形使用提供的 [Brush] 参数绘制，
 * 并根据给定的 [DrawStyle] 进行填充或描边。
 *
 * @param 画刷 要应用到圆角矩形的颜色或填充
 * @param 左上角 相对于当前变换，从本地原点 (0, 0) 的偏移量
 * @param 大小 要绘制的矩形的尺寸
 * @param 圆角半径 圆角矩形的圆角半径，负值将被钳制到 0
 * @param 透明度 要应用到圆角矩形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 指定圆角矩形是描边还是填充
 * @param 颜色过滤器 绘制到目标时应用到 [画刷] 的色彩滤镜
 * @param 混合模式 要应用到画刷的混合算法
 */
fun DrawScope.绘制圆角矩形(
    画刷: Brush,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    圆角半径: CornerRadius = CornerRadius.Zero,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawRoundRect(
        brush = 画刷,
        topLeft = 左上角,
        size = 大小,
        cornerRadius = 圆角半径,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

/**
 * 使用给定的 [Paint] 绘制一个圆角矩形。矩形是填充还是描边（或两者兼有）由 [Paint.style] 控制。
 *
 * @param 颜色 要应用到圆角矩形的颜色
 * @param 左上角 相对于当前变换，从本地原点 (0, 0) 的偏移量
 * @param 大小 要绘制的矩形的尺寸
 * @param 圆角半径 圆角矩形的圆角半径，负值将被钳制到 0
 * @param 透明度 要应用到圆角矩形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 指定圆角矩形是描边还是填充
 * @param 颜色过滤器 绘制到目标时应用到 [颜色] 的色彩滤镜
 * @param 混合模式 要应用到颜色的混合算法
 */
fun DrawScope.绘制圆角矩形(
    颜色: Color,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    圆角半径: CornerRadius = CornerRadius.Zero,
    样式: DrawStyle = Fill,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawRoundRect(
        color = 颜色,
        topLeft = 左上角,
        size = 大小,
        cornerRadius = 圆角半径,
        style = 样式,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )


/**
 * 在提供的中心坐标和半径处绘制圆形。如果未提供中心点，则使用边界的中心。
 *
 * @param 画刷 要应用到圆形的颜色或填充
 * @param 半径 圆形的半径
 * @param 中心 要绘制圆形的中心坐标
 * @param 透明度 要应用到圆形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 指定圆形是描边还是填充
 * @param 颜色过滤器 绘制到目标时应用到 [画刷] 的色彩滤镜
 * @param 混合模式 要应用到画刷的混合算法
 */
fun DrawScope.绘制圆形(
    画刷: Brush,
    半径: Float = this.size.minDimension / 2.0f,
    中心: Offset = this.center,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawCircle(
        brush = 画刷,
        radius = 半径,
        center = 中心,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

/**
 * 在提供的中心坐标和半径处绘制圆形。如果未提供中心点，则使用边界的中心。
 *
 * @param 颜色 要应用到圆形的颜色或填充
 * @param 半径 圆形的半径
 * @param 中心 要绘制圆形的中心坐标
 * @param 透明度 要应用到圆形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 指定圆形是描边还是填充
 * @param 颜色过滤器 绘制到目标时应用到 [颜色] 的色彩滤镜
 * @param 混合模式 要应用到画刷的混合算法
 */
fun DrawScope.绘制圆形(
    颜色: Color,
    半径: Float = this.size.minDimension / 2.0f,
    中心: Offset = this.center,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawCircle(
        color = 颜色,
        radius = 半径,
        center = 中心,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )


/**
 * 使用给定的偏移量和尺寸绘制椭圆形。如果未提供相对于左上角的偏移量，则从当前变换的原点开始绘制。如果未提供尺寸，则使用当前环境的尺寸。
 *
 * @param 画刷 要应用到椭圆形的颜色或填充
 * @param 左上角 相对于当前变换，从本地原点 (0, 0) 的偏移量
 * @param 大小 要绘制的矩形的尺寸
 * @param 透明度 要应用到椭圆形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 指定椭圆形是描边还是填充
 * @param 颜色过滤器 绘制到目标时应用到 [画刷] 的色彩滤镜
 * @param 混合模式 要应用到画刷的混合算法
 */
fun DrawScope.绘制椭圆形(
    画刷: Brush,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawOval(
        brush = 画刷,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

/**
 * 使用给定的偏移量和尺寸绘制椭圆形。如果未提供相对于左上角的偏移量，则从当前变换的原点开始绘制。如果未提供尺寸，则使用当前环境的尺寸。
 *
 * @param 颜色 要应用到椭圆形的颜色
 * @param 左上角 相对于当前变换，从本地原点 (0, 0) 的偏移量
 * @param 大小 要绘制的矩形的尺寸
 * @param 透明度 要应用到椭圆形的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 指定椭圆形是描边还是填充
 * @param 颜色过滤器 绘制到目标时应用到 [颜色] 的色彩滤镜
 * @param 混合模式 要应用到画刷的混合算法
 */
fun DrawScope.绘制椭圆形(
    颜色: Color,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawOval(
        color = 颜色,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )



/**
 * 绘制一个按比例缩放以适配给定矩形内部的圆弧。它从椭圆上 `起始角度` 度处开始，到椭圆上 `起始角度` + `扫描角度`
 * 度处结束，其中零度是椭圆右侧与穿过矩形中心的水平线相交的点，正角度沿椭圆顺时针方向增加。如果 `使用中心` 为 true，
 * 则圆弧会闭合回中心，形成一个扇形；否则圆弧不闭合，形成一个弓形。
 *
 * @param 画刷 要应用于圆弧的颜色或填充。
 * @param 左上角 相对于当前平移，从局部原点 (0, 0) 的偏移量。
 * @param 大小 要绘制的圆弧的尺寸。
 * @param 起始角度 起始角度，以度为单位。0 表示 3 点钟方向。
 * @param 扫描角度 相对于 [起始角度] 顺时针绘制的圆弧大小，以度为单位。
 * @param 使用中心 指示圆弧是否闭合回边界中心的标志。
 * @param 透明度 要应用于圆弧的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 圆弧是描边还是填充。
 * @param 颜色过滤器 绘制到目标时应用于 [画刷] 的 ColorFilter。
 * @param 混合模式 绘制圆弧时要应用的混合算法。
 */
fun DrawScope.绘制圆弧(
    画刷: Brush,
    起始角度: Float,
    扫描角度: Float,
    使用中心: Boolean,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawArc(
        brush = 画刷,
        startAngle = 起始角度,
        sweepAngle = 扫描角度,
        useCenter = 使用中心,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

/**
 * 绘制一个按比例缩放以适配给定矩形内部的圆弧。它从椭圆上 `起始角度` 度处开始，到椭圆上 `起始角度` + `扫描角度`
 * 度处结束，其中零度是椭圆右侧与穿过矩形中心的水平线相交的点，正角度沿椭圆顺时针方向增加。如果 `使用中心` 为 true，
 * 则圆弧会闭合回中心，形成一个扇形；否则圆弧不闭合，形成一个弓形。
 *
 * @param 颜色 要应用于圆弧的颜色。
 * @param 左上角 相对于当前平移，从局部原点 (0, 0) 的偏移量。
 * @param 大小 要绘制的圆弧的尺寸。
 * @param 起始角度 起始角度，以度为单位。0 表示 3 点钟方向。
 * @param 扫描角度 相对于 [起始角度] 顺时针绘制的圆弧大小，以度为单位。
 * @param 使用中心 指示圆弧是否闭合回边界中心的标志。
 * @param 透明度 要应用于圆弧的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 圆弧是描边还是填充。
 * @param 颜色过滤器 绘制到目标时应用于 [颜色] 的 ColorFilter。
 * @param 混合模式 绘制圆弧时要应用的混合算法。
 */
fun DrawScope.绘制圆弧(
    颜色: Color,
    起始角度: Float,
    扫描角度: Float,
    使用中心: Boolean,
    左上角: Offset = Offset.Zero,
    大小: Size = this.size.offsetSize(左上角),
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawArc(
        color = 颜色,
        startAngle = 起始角度,
        sweepAngle = 扫描角度,
        useCenter = 使用中心,
        topLeft = 左上角,
        size = 大小,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )


/**
 * 使用给定的 [Color] 绘制指定的 [Path]。该形状是填充还是描边（或两者兼有）由 [DrawStyle] 控制。如果路径被填充，
 * 则其中的子路径会被隐式闭合（请参阅 [Path.close]）。
 *
 * @param 路径 要绘制的路径
 * @param 颜色 要应用于路径的颜色
 * @param 透明度 要应用于路径的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 路径是描边还是填充
 * @param 颜色过滤器 绘制到目标时应用于 [颜色] 的 ColorFilter。
 * @param 混合模式 绘制路径时要应用的混合算法。
 */
fun DrawScope.绘制路径(
    路径: Path,
    颜色: Color,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawPath(
        path = 路径,
        color = 颜色,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

/**
 * 使用给定的 [Color] 绘制指定的 [Path]。该形状是填充还是描边（或两者兼有）由 [DrawStyle] 控制。如果路径被填充，
 * 则其中的子路径会被隐式闭合（请参阅 [Path.close]）。
 *
 * @param 路径 要绘制的路径
 * @param 画刷 要应用于路径的画刷
 * @param 透明度 要应用于路径的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 样式 路径是描边还是填充
 * @param 颜色过滤器 绘制到目标时应用于 [画刷] 的 ColorFilter。
 * @param 混合模式 绘制路径时要应用的混合算法。
 */
fun DrawScope.绘制路径(
    路径: Path,
    画刷: Brush,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    样式: DrawStyle = Fill,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawPath(
        path = 路径,
        brush = 画刷,
        alpha = 透明度,
        style = 样式,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )


/**
 * 根据给定的 [PointMode] 绘制一系列点。
 *
 * `点集` 参数被解释为相对于原点的偏移量。
 *
 * @param 点集 使用指定的 [PointMode] 绘制的点列表。
 * @param 点模式 用于指示如何绘制点的 [PointMode]。
 * @param 颜色 要应用于点的颜色。
 * @param 透明度 要应用于路径的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 描边宽度 应用于线条的描边宽度。
 * @param 端点 应用于线段端点的处理方式。
 * @param 路径效果 要应用于点的可选效果或图案。
 * @param 颜色过滤器 绘制到目标时应用于 [颜色] 的 ColorFilter。
 * @param 混合模式 绘制路径时要应用的混合算法。
 */
fun DrawScope.绘制点集(
    点集: List<Offset>,
    点模式: PointMode,
    颜色: Color,
    描边宽度: Float = Stroke.HairlineWidth,
    端点: StrokeCap = StrokeCap.Butt,
    路径效果: PathEffect? = null,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawPoints(
        points = 点集,
        pointMode = 点模式,
        color = 颜色,
        strokeWidth = 描边宽度,
        cap = 端点,
        pathEffect = 路径效果,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

/**
 * 根据给定的 [PointMode] 绘制一系列点。
 *
 * `点集` 参数被解释为相对于原点的偏移量。
 *
 * @param 点集 使用指定的 [PointMode] 绘制的点列表。
 * @param 点模式 用于指示如何绘制点的 [PointMode]。
 * @param 画刷 要应用于点的画刷。
 * @param 描边宽度 应用于线条的描边宽度。
 * @param 端点 应用于线段端点的处理方式。
 * @param 路径效果 要应用于点的可选效果或图案。
 * @param 透明度 要应用于路径的不透明度，范围从 0.0f 到 1.0f，分别表示完全透明到完全不透明。
 * @param 颜色过滤器 绘制到目标时应用于 [画刷] 的 ColorFilter。
 * @param 混合模式 绘制路径时要应用的混合算法。
 */
fun DrawScope.绘制点集(
    点集: List<Offset>,
    点模式: PointMode,
    画刷: Brush,
    描边宽度: Float = Stroke.HairlineWidth,
    端点: StrokeCap = StrokeCap.Butt,
    路径效果: PathEffect? = null,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
    颜色过滤器: ColorFilter? = null,
    混合模式: BlendMode = DrawScope.DefaultBlendMode,
) =
    this.drawPoints(
        points = 点集,
        pointMode = 点模式,
        brush = 画刷,
        strokeWidth = 描边宽度,
        cap = 端点,
        pathEffect = 路径效果,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
        blendMode = 混合模式,
    )

//=============================================================================================

/** 辅助方法，用于在框宽和框高方向上偏移所提供的尺寸。 */
private fun Size.offsetSize(offset: Offset): Size =
    Size(this.width - offset.x, this.height - offset.y)

//=============================================================================================

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
