package 安卓x.组合.界面.图形

import androidx.annotation.ColorInt
import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorModel
import androidx.compose.ui.graphics.colorspace.ColorSpace
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.graphics.colorspace.connect
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.graphics.isUnspecified
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.graphics.toArgb
import 安卓x.组合.界面.图形.红
import 安卓x.组合.界面.图形.蓝

/**
 *  `Color` 类包含在 [Canvas] 中绘制时使用的颜色信息。`Color` 支持具有 3 个[分量][ColorSpace.componentCount]的
 *  [ColorSpace]，外加一个用于 [alpha] 的分量。
 *
 * ### Creating
 *
 * `Color` 可通过以下方法之一创建：
 *
 *     // 从 4 个独立的 [Float] 分量创建。Alpha 和 ColorSpace 是可选的。
 *     val rgbaWhiteFloat = Color(red = 1f, green = 1f, blue = 1f, alpha = 1f,
 *         ColorSpace.get(ColorSpaces.Srgb))
 *     // 从一个 32 位 SRGB 颜色整数创建。
 *     val fromIntWhite = Color(android.graphics.Color.WHITE)
 *     val fromLongBlue = Color(0xFF0000FF)
 *     // 从 SRGB 整数分量值创建。Alpha 是可选的。
 *     val rgbaWhiteInt = Color(red = 0xFF, green = 0xFF, blue = 0xFF, alpha = 0xFF)
 *
 * ### Representation
 *
 * `Color` 始终使用单个 64 位长整型值中打包的 4 个分量来定义一种颜色。其中一个分量始终是 alpha，其余三个分量则取决于颜色
 * 空间的[颜色模型][ColorModel]。最常见的颜色模型是 [RGB][ColorModel.Rgb] 模型，在该模型中，分量分别代表红、绿、蓝值。
 *
 * **分量范围：** 下表中所定义的范围表示可在颜色长整型中编码的范围。它们并不代表实际范围，因为实际范围可能因颜色空间而异。
 * 例如，[Display P3][ColorSpaces.DisplayP3] 颜色空间中颜色的 RGB 分量使用 `[0..1]` 范围。请参阅各[颜色空间][ColorSpaces]
 * 的文档以了解其各自的范围。
 *
 * **Alpha 范围：** alpha 在颜色长整型中使用 10 位整数进行编码（因此范围为 `[0..1023]`），但在解码和编码颜色长整型时，
 * 会转换为 `[0..1]` 的浮点值或从该浮点值转换回来。
 *
 * **sRGB 颜色空间：** 出于兼容性原因和使用便利，`Color` 编码的 [sRGB][ColorSpaces.Srgb] 颜色不使用与其他颜色长整型相同的编码方式。
 *
 * ```
 * | Component | Name        | Size    | Range                 |
 * |-----------|-------------|---------|-----------------------|
 * | [RGB][ColorSpace.Model.Rgb] color model                   |
 * | R         | Red         | 16 bits | `[-65504.0, 65504.0]` |
 * | G         | Green       | 16 bits | `[-65504.0, 65504.0]` |
 * | B         | Blue        | 16 bits | `[-65504.0, 65504.0]` |
 * | A         | Alpha       | 10 bits | `[0..1023]`           |
 * |           | Color space | 6 bits  | `[0..63]`             |
 * | [SRGB][ColorSpaces.Srgb] color space                      |
 * | A         | Alpha       | 8 bits  | `[0..255]`            |
 * | R         | Red         | 8 bits  | `[0..255]`            |
 * | G         | Green       | 8 bits  | `[0..255]`            |
 * | B         | Blue        | 8 bits  | `[0..255]`            |
 * | X         | Unused      | 32 bits | `[0]`                 |
 * | [XYZ][ColorSpace.Model.Xyz] color model                   |
 * | X         | X           | 16 bits | `[-65504.0, 65504.0]` |
 * | Y         | Y           | 16 bits | `[-65504.0, 65504.0]` |
 * | Z         | Z           | 16 bits | `[-65504.0, 65504.0]` |
 * | A         | Alpha       | 10 bits | `[0..1023]`           |
 * |           | Color space | 6 bits  | `[0..63]`             |
 * | [Lab][ColorSpace.Model.Lab] color model                   |
 * | L         | L           | 16 bits | `[-65504.0, 65504.0]` |
 * | a         | a           | 16 bits | `[-65504.0, 65504.0]` |
 * | b         | b           | 16 bits | `[-65504.0, 65504.0]` |
 * | A         | Alpha       | 10 bits | `[0..1023]`           |
 * |           | Color space | 6 bits  | `[0..63]`             |
 * ```
 *
 * 此表中的分量按编码顺序列出，这就是为什么 RGB 模型中的颜色长整型被称为 RGBA 颜色（尽管对于 sRGB 颜色的特殊情况并不完全适用）。
 *
 * 颜色编码依赖于半精度浮点值（fp16）。如需了解半精度浮点值限制的更多信息，请参阅 [Float16] 类的文档。
 *
 * 这些方法返回的值取决于颜色长整型中编码的颜色空间。然而，对于 RGB 颜色，这些值通常位于 `[0..1]` 范围内。请参阅各
 * [颜色空间][ColorSpaces]的文档以了解确切的范围。
 */
fun 颜色(值: ULong) = Color(value = 值)

val Color.值: ULong get() = this.value

/**
 * 返回此颜色的颜色空间。
 *
 * @return [ColorSpace] 的非空实例
 */
@Stable
val Color.颜色间隔: ColorSpace
    get() = this.colorSpace

/**
 * 将此颜色从其颜色空间转换到指定的颜色空间。转换使用 [ColorSpace.connect] 指定的默认渲染意图进行。
 *
 * @param 颜色间隔 目标颜色空间，不能为 null
 * @return 指定颜色空间中的非空颜色实例
 */
fun Color.转换(颜色间隔: ColorSpace): Color =
    this.convert(colorSpace = 颜色间隔)

/**
 * 返回红色分量的值，其范围由此颜色的颜色空间定义（参见 [ColorSpace.getMinValue] 和 [ColorSpace.getMaxValue]）。
 *
 * 如果此颜色的颜色模型不是 [RGB][ColorModel.Rgb]，则调用此方法返回的是该 ColorSpace 的第一个分量。
 *
 * @see 透明度
 * @see 蓝
 * @see 绿
 */
@Stable
val Color.红: Float
    get() = this.red

/**
 * 返回绿色分量的值，其范围由此颜色的颜色空间定义（参见 [ColorSpace.getMinValue] 和 [ColorSpace.getMaxValue]）。
 *
 * 如果此颜色的颜色模型不是 [RGB][ColorModel.Rgb]，则调用此方法返回的是该 ColorSpace 的第二个分量。
 *
 * @see 透明度
 * @see 红
 * @see 蓝
 */
@Stable
val Color.绿: Float
    get() = this.green

/**
 * 返回蓝色分量的值，其范围由此颜色的颜色空间定义（参见 [ColorSpace.getMinValue] 和 [ColorSpace.getMaxValue]）。
 *
 * 如果此颜色的颜色模型不是 [RGB][ColorModel.Rgb]，则调用此方法返回的是该 ColorSpace 的第三个分量。
 *
 * @see 透明度
 * @see 红
 * @see 绿
 */
@Stable
val Color.蓝: Float
    get() = this.blue

/**
 * 返回 alpha 分量的值，范围为 `[0..1]`。
 *
 * @see 红
 * @see 绿
 * @see 蓝
 */
@Stable
val Color.透明度: Float
    get() = this.alpha

@Suppress("NOTHING_TO_INLINE")
@Stable
inline fun Color.组件1(): Float = this.component1()

@Suppress("NOTHING_TO_INLINE")
@Stable
inline fun Color.组件2(): Float = this.component2()

@Suppress("NOTHING_TO_INLINE")
@Stable
inline fun Color.组件3(): Float = this.component3()

@Suppress("NOTHING_TO_INLINE")
@Stable
inline fun Color.组件4(): Float = this.component4()

@Suppress("NOTHING_TO_INLINE")
@Stable
inline fun Color.组件5(): ColorSpace = this.component5()

/** 复制现有颜色，仅更改提供的值。返回的 [Color] 的 [ColorSpace][colorSpace] 与此 [colorSpace] 相同。*/
@Stable
fun Color.复制(
    透明度: Float = this.alpha,
    红: Float = this.red,
    绿: Float = this.green,
    蓝: Float = this.blue,
): Color = this.copy(alpha = 透明度, red = 红, green = 绿, blue = 蓝)


//=====================================================================

object 颜色{

    @Stable val 黑色 = Color.Black

    @Stable val 深灰色 = Color.DarkGray

    @Stable val 灰色 = Color.Gray

    @Stable val 浅灰色 = Color.LightGray

    @Stable val 白色 = Color.White

    @Stable val 红色 = Color.Red

    @Stable val 绿色 = Color.Green

    @Stable val 蓝色 = Color.Blue

    @Stable val 黄色 = Color.Yellow

    @Stable val 青色 = Color.Cyan

    @Stable val 品红色 = Color.Magenta

    @Stable val 透明 = Color.Transparent

    /**
     * 由于 `Color` 是一个内联类，这表示一种**未设置的值**，而无需对 `Color` 进行装箱。绘制时它将被视为 [透明]。
     * `Color` 可以与 [未指定] 进行相等性比较，或使用 [isUnspecified] 检查是否为未设置的值，或使用 [isSpecified]
     * 检查任何不是 [未指定] 的颜色。
     */
    @Stable
    val 未指定 = Color.Unspecified

    /**
     * 从 [色相]、[饱和度] 和 [值]（HSV 表示法）返回一个 [Color]。
     *
     * @param 色相 颜色值，范围为 (0..360)，其中 0 为红色，120 为绿色，240 为蓝色
     * @param 饱和度 颜色中 [色相] 的量，范围为 (0..1)，其中 0 表示无色彩，1 表示完全饱和。
     * @param 透明度 要应用于计算颜色的 Alpha 通道。
     * @param 值 颜色的强度，其中 0 为黑色。
     * @param 颜色间隔 用于从 HSV 值计算 Color 的 RGB 颜色空间。
     */
    fun hsv(
        色相: Float,
        饱和度: Float,
        值: Float,
        透明度: Float = 1f,
        颜色间隔: Rgb = ColorSpaces.Srgb,
    ): Color = Color.hsv(
        hue = 色相, saturation = 饱和度, value = 值, alpha = 透明度, colorSpace = 颜色间隔
    )


    /**
     * 从 [色相]、[饱和度] 和 [亮度]（HSL 表示法）返回一个 [Color]。
     *
     * @param 色相 颜色值，范围为 (0..360)，其中 0 为红色，120 为绿色，240 为蓝色
     * @param 饱和度 颜色中 [色相] 的量，范围为 (0..1)，其中 0 表示无色彩，1 表示完全饱和。
     * @param 亮度 范围为 (0..1)，其中 0 为黑色，0.5 为完全着色，1 为白色。
     * @param 透明度 要应用于计算颜色的 Alpha 通道。
     * @param 颜色间隔 用于从 HSL 值计算 Color 的 RGB 颜色空间。
     */
    fun hsl(
        色相: Float,
        饱和度: Float,
        亮度: Float,
        透明度: Float = 1f,
        颜色间隔: Rgb = ColorSpaces.Srgb,
    ): Color = Color.hsl(
        hue = 色相, saturation = 饱和度, lightness = 亮度, alpha = 透明度, colorSpace = 颜色间隔
    )

}

/**
 * 通过传入独立的 [红]、[绿]、[蓝]、[透明度] 和 [颜色间隔] 分量创建一个 [Color]。默认的[颜色空间][ColorSpace]
 * 为 [sRGB][ColorSpaces.Srgb]，默认的 [透明度] 为 `1.0`（不透明）。
 *
 * 如果 [红]、[绿] 或 [蓝] 的值超出 [颜色间隔] 定义的范围（参见 [ColorSpace.getMinValue] 和
 * [ColorSpace.getMaxValue]），这些值将被适当地**钳制**到范围内。
 *
 * @throws IllegalArgumentException 如果 [颜色间隔] 的 [ColorSpace.componentCount] 不等于 3。
 * @throws IllegalArgumentException 如果 [颜色间隔] 的 [ColorSpace.id] 设置为 [ColorSpace.MinId]。
 */
@Stable
fun 颜色(
    红: Float,
    绿: Float,
    蓝: Float,
    透明度: Float = 1f,
    颜色间隔: ColorSpace = ColorSpaces.Srgb,
): Color =
    Color(
        red = 红,
        green = 绿,
        blue = 蓝,
        alpha = 透明度,
        colorSpace = 颜色间隔,
    )


/**
 * 从 ARGB 颜色整数创建一个新的 [Color] 实例。结果颜色位于 [sRGB][ColorSpaces.Srgb] 颜色空间中。
 *
 * @param 颜色 用于创建 `Color` 的 ARGB 颜色整数。
 * @return {@link Color} 的非空实例
 */
@Stable
fun 颜色(@ColorInt 颜色: Int): Color = Color(color = 颜色)

/**
 * 从 ARGB 颜色整数创建一个新的 [Color] 实例。结果颜色位于 [sRGB][ColorSpaces.Srgb] 颜色空间中。这对于以数字形式指定
 * alpha 大于 0x80 的颜色而不使用 [Long.toInt] 非常有用：
 *
 *     val color = Color(0xFF000080)
 *
 * @param 颜色 用于创建 `Color` 的 32 位 ARGB 颜色整数。
 * @return {@link Color} 的非空实例
 */
@Stable
fun 颜色(颜色: Long): Color = Color(color = 颜色)

/**
 * 从 ARGB 颜色分量创建一个新的 [Color] 实例。结果颜色位于 [sRGB][ColorSpaces.Srgb] 颜色空间中。
 * 默认的 alpha 值为 `0xFF`（不透明）。
 *
 * @param 红 颜色的红色分量，范围为 0 到 255。
 * @param 绿 颜色的绿色分量，范围为 0 到 255。
 * @param 蓝 颜色的蓝色分量，范围为 0 到 255。
 * @param 透明度 颜色的 alpha 分量，范围为 0 到 255。
 * @return {@link Color} 的非空实例
 */
@Stable
fun 颜色(
    @IntRange(from = 0, to = 0xFF) 红: Int,
    @IntRange(from = 0, to = 0xFF) 绿: Int,
    @IntRange(from = 0, to = 0xFF) 蓝: Int,
    @IntRange(from = 0, to = 0xFF) 透明度: Int = 0xFF,
): Color =
    Color(
        red = 红,
        green = 绿,
        blue = 蓝,
        alpha = 透明度,
    )

/**
 * 在两种 [颜色][Color]（[起始] 和 [停止]）之间按 [分数] 比例进行线性插值。结果颜色的 [ColorSpace] 始终为
 * [停止] 的 [ColorSpace][Color.colorSpace]。[分数] 应在 0 到 1 之间（含边界）。插值在 [ColorSpaces.Oklab]
 * 颜色空间中进行。
 */
@Stable
fun 线性插值(起始: Color, 停止: Color, @FloatRange(from = 0.0, to = 1.0) 分数: Float): Color =
    lerp(start = 起始, stop = 停止, fraction = 分数)

/**
 * 使用 Porter-Duff "source over" 模式将 [this] 颜色合成到 [背景] 之上。
 *
 * [this] 和 [背景] 都**不得**是预乘的，结果颜色也将**不是**预乘的。
 *
 * 结果的 [ColorSpace] 始终为 [背景] 的 [ColorSpace][Color.colorSpace]。
 *
 * @return 表示 [this] 在 [背景] 上方合成的 [Color]，已转换为 [背景] 的颜色空间。
 */
@Stable
fun Color.合成覆盖(背景: Color): Color = this.compositeOver(background = 背景)


/**
 * 返回此颜色的相对亮度。
 *
 * 基于 WCAG 2.0、W3C 2008 年 12 月 11 日建议书中定义的相对亮度公式。
 *
 * @return 0（最暗的黑色）到 1（最亮的白色）之间的值。
 * @throws IllegalArgumentException 如果此颜色的颜色空间不使用 [RGB][ColorModel.Rgb] 颜色模型
 */
@Stable
fun Color.亮度(): Float = this.luminance()


/**
 * 将此颜色转换为 ARGB 颜色整数。颜色整数始终位于 [sRGB][ColorSpaces.Srgb] 颜色空间中。这意味着如果需要，将应用颜色空间转换。
 *
 * @return sRGB 颜色空间中的 ARGB 颜色。
 */
@Stable
@ColorInt
fun Color.转为Argb(): Int = this.toArgb()


/** 当此颜色为 [Color.Unspecified] 时为 `false`。 */
@Stable
inline val Color.是否已指定: Boolean
    get() = this.isSpecified


/** 当此颜色为 [Color.Unspecified] 时为 `true`。 */
@Stable
inline val Color.是否未指定: Boolean
    get() = this.isUnspecified


/** 如果此颜色 [isSpecified]（已指定），则返回此颜色本身；否则执行 [块] 并返回其结果。*/
inline fun Color.取或否则(块: () -> Color): Color = this.takeOrElse(block = 块)


/**
 * 可以用来避免装箱的 `() -> Color` 替代方案。
 *
 * 可以用作：
 *
 *        fun nonBoxedArgs(color: ColorProducer?)
 */
fun interface 颜色提供器 {

    /** 返回颜色 */
    operator fun invoke(): Color

}
