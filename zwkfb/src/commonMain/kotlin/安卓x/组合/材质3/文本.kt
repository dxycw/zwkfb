package 安卓x.组合.材质3

import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

/**
 * 用于显示文本并提供语义 / 无障碍信息的高级元素。
 *
 * 默认 [样式] 使用由 [MaterialTheme] / 组件提供的 [LocalTextStyle]。如果你要设置自己的样式，
 * 建议先获取 [LocalTextStyle]，然后使用 [TextStyle.copy]保留主题定义的所有属性，仅修改你想要覆盖的特定属性。
 *
 * 为便于使用，[TextStyle] 中常用的参数在此也可直接设置。优先级顺序如下：
 *  - 如果在此显式设置了参数（即 不是 null 或 [TextUnit.Unspecified]），则始终使用该参数。
 *  - 如果参数未设置（为 null 或 [TextUnit.Unspecified]），则改用 [样式] 中对应的值。
 *
 * 此外，对于 [颜色]，如果 [颜色] 未设置，且 [样式] 中也没有颜色，则将使用 [LocalContentColor]。
 *
 * @param 文本 要显示的文本
 * @param 修饰符 要应用于此布局节点的 [Modifier]
 * @param 颜色 要应用于文本的 [Color]。如果为 [Color.Unspecified]，且 [样式] 未设置颜色，
 * 则将使用 [LocalContentColor]。
 * @param 自适应大小 为此文本可组合项启用自动调整大小功能。查找适合可用空间的最大字体大小，并使用该大小进行文本布局。
 * 这会执行多次布局遍历，可能比使用固定字体大小更慢。此功能优先于通过 [字体大小] 和 [样式] 定义的大小。
 * 请参阅 [TextAutoSize]。
 * @param 字体大小 绘制文本时要使用的字形大小。请参阅 [TextStyle.fontSize]。
 * @param 字体样式 绘制字母时要使用的字体变体（例如，斜体）。请参阅 [TextStyle.fontStyle]。
 * @param 字体粗细 绘制文本时要使用的字体粗细（例如，[FontWeight.Bold]）。
 * @param 字体族 渲染文本时要使用的字体系列。请参阅 [TextStyle.fontFamily]。
 * @param 字符间距 要在每个字母之间添加的间距量。请参阅 [TextStyle.letterSpacing]。
 * @param 文本装饰 要在文本上绘制的装饰效果（例如，下划线）。请参阅 [TextStyle.textDecoration]。
 * @param 文本对齐 段落内各行的文本对齐方式。请参阅 [TextStyle.textAlign]。
 * @param 行高 [Paragraph] 的行高，使用 [TextUnit] 单位，例如 SP 或 EM。请参阅 [TextStyle.lineHeight]。
 * @param 溢出 应如何处理视觉溢出。
 * @param 软换行 文本是否应在软换行符处换行。如果为 false，文本中的字形将被定位，如同存在无限的水平空间。
 * 如果 [软换行] 为 false，[溢出] 和 TextAlign 可能产生意外效果。
 * @param 最大行数 文本可跨越的最大行数，必要时自动换行。如果文本超出给定的行数，将根据 [溢出]
 * 和 [软换行] 进行截断。要求满足 1 <= [最小行数] <= [最大行数]。
 * @param 最小行数 以最小可见行数表示的最小高度。要求满足 1 <= [最小行数] <= [最大行数]。
 * @param 文本布局回调 在计算新的文本布局时执行的回调。回调提供的 [TextLayoutResult] 对象包含段落信息、
 * 文本尺寸、基线和其他详情。该回调可用于为文本添加额外的装饰或功能。例如，在文本周围绘制选区。
 * @param 样式 文本的样式配置，例如颜色、字体、行高等。
 */
@Suppress("ComposableNaming")
@Composable
fun 文本(
    文本: String,
    修饰符: Modifier = Modifier,
    颜色: Color = Color.Unspecified,
    自适应大小: TextAutoSize? = null,
    字体大小: TextUnit = TextUnit.Unspecified,
    字体样式: FontStyle? = null,
    字体粗细: FontWeight? = null,
    字体族: FontFamily? = null,
    字符间距: TextUnit = TextUnit.Unspecified,
    文本装饰: TextDecoration? = null,
    文本对齐: TextAlign? = null,
    行高: TextUnit = TextUnit.Unspecified,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    文本布局回调: ((TextLayoutResult) -> Unit)? = null,
    样式: TextStyle = LocalTextStyle.current,
) {
    Text(
        text = 文本,
        modifier = 修饰符,
        color = 颜色,
        autoSize = 自适应大小,
        fontSize = 字体大小,
        fontStyle = 字体样式,
        fontWeight = 字体粗细,
        fontFamily = 字体族,
        letterSpacing = 字符间距,
        textDecoration = 文本装饰,
        textAlign = 文本对齐,
        lineHeight = 行高,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        onTextLayout = 文本布局回调,
        style = 样式,
    )
}

/**
 * 用于显示文本并提供语义 / 无障碍信息的高级元素。
 *
 * 默认 [样式] 使用由 [MaterialTheme] / 组件提供的 [LocalTextStyle]。如果你要设置自己的样式，
 * 建议先获取 [LocalTextStyle]，然后使用 [TextStyle.copy] 保留主题定义的所有属性，仅修改你想要覆盖的特定属性。
 *
 * 为便于使用，[TextStyle] 中常用的参数在此也可直接设置。优先级顺序如下：
 *  - 如果在此显式设置了参数（即 不是 null 或 [TextUnit.Unspecified]），则始终使用该参数。
 *  - 如果参数 未 设置（为 null 或 [TextUnit.Unspecified]），则改用 [样式] 中对应的值。
 *
 * @param 文本 要显示的文本
 * @param 颜色 返回 [Color] 的 [ColorProducer]。适用于提供频繁变化的颜色值而无需重新组合的场景。
 * 会覆盖 [样式] 中提供的文本颜色。
 * @param 修饰符 要应用于此布局节点的 [Modifier]
 * @param 自适应大小 为此文本可组合项启用自动调整大小功能。查找适合可用空间的最大字体大小，并使用该大小进行文本布局。
 * 这会执行多次布局遍历，可能比使用固定字体大小更慢。此功能优先于通过 [字体大小] 和 [样式] 定义的大小。
 * 请参阅 [TextAutoSize]。
 * @param 字体大小 绘制文本时要使用的字形大小。请参阅 [TextStyle.fontSize]。
 * @param 字体样式 绘制字母时要使用的字体变体（例如，斜体）。请参阅 [TextStyle.fontStyle]。
 * @param 字体粗细 绘制文本时要使用的字体粗细（例如，[FontWeight.Bold]）。
 * @param 字体族 渲染文本时要使用的字体系列。请参阅 [TextStyle.fontFamily]。
 * @param 字符间距 要在每个字母之间添加的间距量。请参阅 [TextStyle.letterSpacing]。
 * @param 文本装饰 要在文本上绘制的装饰效果（例如，下划线）。请参阅 [TextStyle.textDecoration]。
 * @param 文本对齐 段落内各行的文本对齐方式。请参阅 [TextStyle.textAlign]。
 * @param 行高 [Paragraph] 的行高，使用 [TextUnit] 单位，例如 SP 或 EM。请参阅 [TextStyle.lineHeight]。
 * @param 溢出 应如何处理视觉溢出。
 * @param 软换行 文本是否应在软换行符处换行。如果为 false，文本中的字形将被定位，如同存在无限的水平空间。
 * 如果 [软换行] 为 false，[溢出] 和 TextAlign 可能产生意外效果。
 * @param 最大行数 文本可跨越的最大行数，必要时自动换行。如果文本超出给定的行数，将根据 [溢出]
 * 和 [软换行] 进行截断。要求满足 1 <= [最小行数] <= [最大行数]。
 * @param 最小行数 以最小可见行数表示的最小高度。要求满足 1 <= [最小行数] <= [最大行数]。
 * @param 文本布局回调 在计算新的文本布局时执行的回调。回调提供的 [TextLayoutResult] 对象包含段落信息、
 * 文本尺寸、基线和其他详情。该回调可用于为文本添加额外的装饰或功能。例如，在文本周围绘制选区。
 * @param 样式 文本的样式配置，例如颜色、字体、行高等。
 */
@Suppress("ComposableNaming")
@Composable
fun 文本(
    文本: String,
    颜色: ColorProducer,
    修饰符: Modifier = Modifier,
    自适应大小: TextAutoSize? = null,
    字体大小: TextUnit = TextUnit.Unspecified,
    字体样式: FontStyle? = null,
    字体粗细: FontWeight? = null,
    字体族: FontFamily? = null,
    字符间距: TextUnit = TextUnit.Unspecified,
    文本装饰: TextDecoration? = null,
    文本对齐: TextAlign? = null,
    行高: TextUnit = TextUnit.Unspecified,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    文本布局回调: ((TextLayoutResult) -> Unit)? = null,
    样式: TextStyle = LocalTextStyle.current,
) {
    Text(
        text = 文本,
        color = 颜色,
        modifier = 修饰符,
        autoSize = 自适应大小,
        fontSize = 字体大小,
        fontStyle = 字体样式,
        fontWeight = 字体粗细,
        fontFamily = 字体族,
        letterSpacing = 字符间距,
        textDecoration = 文本装饰,
        textAlign = 文本对齐,
        lineHeight = 行高,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        onTextLayout = 文本布局回调,
        style = 样式,
    )
}

/**
 * 用于显示文本并提供语义 / 无障碍信息的高级元素。
 *
 * 默认 [样式] 使用由 [MaterialTheme] / 组件提供的 [LocalTextStyle]。如果你要设置自己的样式，
 * 建议先获取 [LocalTextStyle]，然后使用 [TextStyle.copy] 保留主题定义的所有属性，仅修改你想要覆盖的特定属性。
 *
 * 为便于使用，[TextStyle] 中常用的参数在此也可直接设置。优先级顺序如下：
 *  - 如果在此显式设置了参数（即 不是 null 或 [TextUnit.Unspecified]），则始终使用该参数。
 *  - 如果参数 未 设置（为 null 或 [TextUnit.Unspecified]），则改用 [样式] 中对应的值。
 *
 * 此外，对于 [颜色]，如果 [颜色] 未设置，且 [样式] 中也没有颜色，则将使用 [LocalContentColor]。
 *
 * 查看一个显示带链接文本的示例，其中链接应用了主题中的样式：
 *
 * @param 文本 要显示的文本
 * @param 修饰符 要应用于此布局节点的 [Modifier]
 * @param 颜色 要应用于文本的 [Color]。如果为 [Color.Unspecified]，且 [样式] 未设置颜色，
 * 则将使用 [LocalContentColor]。
 * @param 自适应大小 为此文本可组合项启用自动调整大小功能。查找适合可用空间的最大字体大小，并使用该大小进行文本布局。
 * 这会执行多次布局遍历，可能比使用固定字体大小更慢。此功能优先于通过 [字体大小] 和 [样式] 定义的大小。
 * 请参阅 [TextAutoSize]。
 * @param 字体大小 绘制文本时要使用的字形大小。请参阅 [TextStyle.fontSize]。
 * @param 字体样式 绘制字母时要使用的字体变体（例如，斜体）。请参阅 [TextStyle.fontStyle]。
 * @param 字体粗细 绘制文本时要使用的字体粗细（例如，[FontWeight.Bold]）。
 * @param 字体族 渲染文本时要使用的字体系列。请参阅 [TextStyle.fontFamily]。
 * @param 字符间距 要在每个字母之间添加的间距量。请参阅 [TextStyle.letterSpacing]。
 * @param 文本装饰 要在文本上绘制的装饰效果（例如，下划线）。请参阅 [TextStyle.textDecoration]。
 * @param 文本对齐 段落内各行的文本对齐方式。请参阅 [TextStyle.textAlign]。
 * @param 行高 [Paragraph] 的行高，使用 [TextUnit] 单位，例如 SP 或 EM。请参阅 [TextStyle.lineHeight]。
 * @param 溢出 应如何处理视觉溢出。
 * @param 软换行 文本是否应在软换行符处换行。如果为 false，文本中的字形将被定位，如同存在无限的水平空间。
 * 如果 [软换行] 为 false，[溢出] 和 TextAlign 可能产生意外效果。
 * @param 最大行数 文本可跨越的最大行数，必要时自动换行。如果文本超出给定的行数，将根据 [溢出]
 * 和 [软换行] 进行截断。要求满足 1 <= [最小行数] <= [最大行数]。
 * @param 最小行数 以最小可见行数表示的最小高度。要求满足 1 <= [最小行数] <= [最大行数]。
 * @param 内联内容 存储可组合项的映射表，用于替换文本的特定范围，从而将可组合项插入到文本布局中。
 * 请参阅 [InlineTextContent]。
 * @param 文本布局回调 在计算新的文本布局时执行的回调。回调提供的 [TextLayoutResult] 对象包含段落信息、
 * 文本尺寸、基线和其他详情。该回调可用于为文本添加额外的装饰或功能。例如，在文本周围绘制选区。
 * @param 样式 文本的样式配置，例如颜色、字体、行高等。
 */
@Suppress("ComposableNaming")
@Composable
fun 文本(
    文本: AnnotatedString,
    修饰符: Modifier = Modifier,
    颜色: Color = Color.Unspecified,
    自适应大小: TextAutoSize? = null,
    字体大小: TextUnit = TextUnit.Unspecified,
    字体样式: FontStyle? = null,
    字体粗细: FontWeight? = null,
    字体族: FontFamily? = null,
    字符间距: TextUnit = TextUnit.Unspecified,
    文本装饰: TextDecoration? = null,
    文本对齐: TextAlign? = null,
    行高: TextUnit = TextUnit.Unspecified,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    内联内容: Map<String, InlineTextContent> = mapOf(),
    文本布局回调: (TextLayoutResult) -> Unit = {},
    样式: TextStyle = LocalTextStyle.current,
) {
    Text(
        text = 文本,
        modifier = 修饰符,
        color = 颜色,
        autoSize = 自适应大小,
        fontSize = 字体大小,
        fontStyle = 字体样式,
        fontWeight = 字体粗细,
        fontFamily = 字体族,
        letterSpacing = 字符间距,
        textDecoration = 文本装饰,
        textAlign = 文本对齐,
        lineHeight = 行高,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        inlineContent = 内联内容,
        onTextLayout = 文本布局回调,
        style = 样式,
    )
}

/**
 * 用于显示文本并提供语义 / 无障碍信息的高级元素。
 *
 * 默认 [样式] 使用由 [MaterialTheme] / 组件提供的 [LocalTextStyle]。如果你要设置自己的样式，
 * 建议先获取 [LocalTextStyle]，然后使用 [TextStyle.copy] 保留主题定义的所有属性，仅修改你想要覆盖的特定属性。
 *
 * 为便于使用，[TextStyle] 中常用的参数在此也可直接设置。优先级顺序如下：
 *  - 如果在此显式设置了参数（即 不是 null 或 [TextUnit.Unspecified]），则始终使用该参数。
 *  - 如果参数 未 设置（为 null 或 [TextUnit.Unspecified]），则改用 [样式] 中对应的值。
 *
 * 查看一个显示带链接文本的示例，其中链接应用了主题中的样式：
 *
 * @param 文本 要显示的文本
 * @param 颜色 返回 [Color] 的 [ColorProducer]。适用于提供频繁变化的颜色值而无需重新组合的场景。
 *  会覆盖 [样式] 中提供的文本颜色。
 * @param 修饰符 要应用于此布局节点的 [Modifier]
 * @param 自适应大小 为此文本可组合项启用自动调整大小功能。查找适合可用空间的最大字体大小，并使用该大小进行文本布局。
 * 这会执行多次布局遍历，可能比使用固定字体大小更慢。此功能优先于通过 [字体大小] 和 [样式] 定义的大小。
 * 请参阅 [TextAutoSize]。
 * @param 字体大小 绘制文本时要使用的字形大小。请参阅 [TextStyle.fontSize]。
 * @param 字体样式 绘制字母时要使用的字体变体（例如，斜体）。请参阅 [TextStyle.fontStyle]。
 * @param 字体粗细 绘制文本时要使用的字体粗细（例如，[FontWeight.Bold]）。
 * @param 字体族 渲染文本时要使用的字体系列。请参阅 [TextStyle.fontFamily]。
 * @param 文本装饰 要在每个字母之间添加的间距量。请参阅 [TextStyle.letterSpacing]。
 * @param 文本装饰 要在文本上绘制的装饰效果（例如，下划线）。请参阅 [TextStyle.textDecoration]。
 * @param 文本对齐 段落内各行的文本对齐方式。请参阅 [TextStyle.textAlign]。
 * @param 行高 [Paragraph] 的行高，使用 [TextUnit] 单位，例如 SP 或 EM。请参阅 [TextStyle.lineHeight]。
 * @param 溢出 应如何处理视觉溢出。
 * @param 软换行 文本是否应在软换行符处换行。如果为 false，文本中的字形将被定位，如同存在无限的水平空间。
 * 如果 [软换行] 为 false，[溢出] 和 TextAlign 可能产生意外效果。
 * @param 最大行数 文本可跨越的最大行数，必要时自动换行。如果文本超出给定的行数，将根据 [溢出]
 * 和 [软换行] 进行截断。要求满足 1 <= [最小行数] <= [最大行数]。
 * @param 最小行数 以最小可见行数表示的最小高度。要求满足 1 <= [最小行数] <= [最大行数]。
 * @param 内联内容 存储可组合项的映射表，用于替换文本的特定范围，从而将可组合项插入到文本布局中。
 * 请参阅 [InlineTextContent]。
 * @param 文本布局回调 在计算新的文本布局时执行的回调。回调提供的 [TextLayoutResult] 对象包含段落信息、
 * 文本尺寸、基线和其他详情。该回调可用于为文本添加额外的装饰或功能。例如，在文本周围绘制选区。
 * @param 样式 文本的样式配置，例如颜色、字体、行高等。
 */
@Suppress("ComposableNaming")
@Composable
fun 文本(
    文本: AnnotatedString,
    颜色: ColorProducer,
    修饰符: Modifier = Modifier,
    自适应大小: TextAutoSize? = null,
    字体大小: TextUnit = TextUnit.Unspecified,
    字体样式: FontStyle? = null,
    字体粗细: FontWeight? = null,
    字体族: FontFamily? = null,
    字符间距: TextUnit = TextUnit.Unspecified,
    文本装饰: TextDecoration? = null,
    文本对齐: TextAlign? = null,
    行高: TextUnit = TextUnit.Unspecified,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    内联内容: Map<String, InlineTextContent> = mapOf(),
    文本布局回调: (TextLayoutResult) -> Unit = {},
    样式: TextStyle = LocalTextStyle.current,
) {
    Text(
        text = 文本,
        color = 颜色,
        modifier = 修饰符,
        autoSize = 自适应大小,
        fontSize = 字体大小,
        fontStyle = 字体样式,
        fontWeight = 字体粗细,
        fontFamily = 字体族,
        letterSpacing = 字符间距,
        textDecoration = 文本装饰,
        textAlign = 文本对齐,
        lineHeight = 行高,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        inlineContent = 内联内容,
        onTextLayout = 文本布局回调,
        style = 样式,
    )
}


/**
 * 包含首选 [TextStyle] 的 CompositionLocal，默认情况下供 [文本] 组件使用。
 * 若要设置此 CompositionLocal 的值，请参阅 [提供文本样式]，它会将任何缺失的 [TextStyle]
 * 属性与在此 CompositionLocal 中设置的现有 [TextStyle] 进行合并。
 *
 * @see 提供文本样式
 */
val 本地文本样式 = LocalTextStyle

// TODO(b/156598010): 删除这个并用背衬 CompositionLocal 上的 fold 定义替换
/**
 * 此函数用于设置 [本地文本样式] 的当前值，将给定样式与当前样式值合并，以填充所有缺失的属性。
 * 此组件 [内容] 中包含的任何 [文本] 组件都将应用此样式，除非显式指定了其他样式。
 *
 * @see 本地文本样式
 */
@Suppress("ComposableNaming")
@Composable
fun 提供文本样式(值: TextStyle, 内容: @Composable () -> Unit) {
    ProvideTextStyle(value = 值, content = 内容)
}

