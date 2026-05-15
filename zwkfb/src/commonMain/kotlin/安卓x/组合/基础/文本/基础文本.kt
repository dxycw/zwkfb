package 安卓x.组合.基础.文本

import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow

/**
 * 显示文本并提供语义/无障碍信息的基础元素。通常，你会更倾向于使用 [androidx.compose.material.Text]，
 * 因为它是一个更高级的文本元素，内置了语义支持并能从主题中获取样式信息。
 *
 * @param 文本 要显示的文本。
 * @param 修饰符 要应用于此布局节点的 [Modifier]（修饰符）。
 * @param 样式 文本的样式配置，例如颜色、字体、行高等。
 * @param 文本布局回调 在计算出新的文本布局时执行的回调。该回调提供的 [TextLayoutResult] 对象包含段落信息、文本尺寸、
 * 基线以及其他细节。此回调可用于为文本添加额外的装饰或功能。例如，用于在文本周围绘制选区。
 * @param 溢出 如何处理视觉溢出。
 * @param 软换行 文本是否应在软换行处断行。如果为 false，文本中的字形将按存在无限水平空间的情况进行定位。如果 [软换行] 为 false，
 * [溢出]（溢出处理）和 TextAlign（文本对齐）可能会产生意外的效果。
 * @param 最大行数 文本跨越的可选最大行数，必要时会进行换行。如果文本超过给定的行数，它将根据 [溢出]（溢出处理方式）和
 * [软换行]（自动换行设置）进行截断。必须满足 1 <= [最小行数] <= [最大行数]。
 * @param 最小行数 根据可见的最小行数定义的最小高度。必须满足 1 <= [最小行数] <= [最大行数]。
 * @param 颜色 覆盖 [样式] 中提供的文本颜色。
 * @param 自适应大小 为此文本可组合组件启用自动调整大小功能。它会寻找能够适应可用空间的最大字体大小，并使用该大小来布局文本。
 * 此操作会执行多次布局传递，因此可能比使用固定字体大小要慢。该设置的优先级高于通过 [样式] 定义的字体大小。请参阅 [TextAutoSize] 及示例代码。
 */
@Suppress("ComposableNaming")
@Composable
fun 基础文本(
    文本: String,
    修饰符: Modifier = Modifier,
    样式: TextStyle = TextStyle.Default,
    文本布局回调: ((TextLayoutResult) -> Unit)? = null,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    颜色: ColorProducer? = null,
    自适应大小: TextAutoSize? = null,
) {
    BasicText(
        text = 文本,
        modifier = 修饰符,
        style = 样式,
        onTextLayout = 文本布局回调,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        color = 颜色,
        autoSize = 自适应大小,
    )
}

/**
 * 显示文本并提供语义/无障碍信息的基础元素。通常，你会更倾向于使用 [androidx.compose.material.Text]，
 * 因为它是一个更高级的文本元素，内置了语义支持并能从主题中获取样式信息。
 *
 * @param 文本 要显示的文本。
 * @param 修饰符 要应用于此布局节点的 [Modifier]（修饰符）。
 * @param 样式 文本的样式配置，例如颜色、字体、行高等。
 * @param 文本布局回调 在计算出新的文本布局时执行的回调。该回调提供的 [TextLayoutResult] 对象包含段落信息、文本尺寸、
 * 基线以及其他细节。此回调可用于为文本添加额外的装饰或功能。例如，用于在文本周围绘制选区。
 * @param 溢出 如何处理视觉溢出。
 * @param 软换行 文本是否应在软换行处断行。如果为 false，文本中的字形将按存在无限水平空间的情况进行定位。如果 [软换行] 为 false，
 * [溢出]（溢出处理）和 TextAlign（文本对齐）可能会产生意外的效果。
 * @param 最大行数 文本跨越的可选最大行数，必要时会进行换行。如果文本超过给定的行数，它将根据 [溢出]（溢出处理方式）和
 * [软换行]（自动换行设置）进行截断。必须满足 1 <= [最小行数] <= [最大行数]。
 * @param 最小行数 根据可见的最小行数定义的最小高度。必须满足 1 <= [最小行数] <= [最大行数]。
 * @param 内联内容 一个用于存储可组合组件的映射表，它会替换文本中的特定范围。该参数用于将可组合组件插入到文本布局中。
 * 更多信息请参见 [InlineTextContent]。
 * @param 颜色 覆盖 [样式] 中提供的文本颜色。
 * @param 自适应大小 为此文本可组合组件启用自动调整大小功能。它会寻找能够适应可用空间的最大字体大小，并使用该大小来布局文本。
 * 此操作会执行多次布局传递，因此可能比使用固定字体大小要慢。该设置的优先级高于通过 [样式] 定义的字体大小。请参阅 [TextAutoSize] 及示例代码。
 */
@Suppress("ComposableNaming")
@Composable
fun 基础文本(
    文本: AnnotatedString,
    修饰符: Modifier = Modifier,
    样式: TextStyle = TextStyle.Default,
    文本布局回调: ((TextLayoutResult) -> Unit)? = null,
    溢出: TextOverflow = TextOverflow.Clip,
    软换行: Boolean = true,
    最大行数: Int = Int.MAX_VALUE,
    最小行数: Int = 1,
    内联内容: Map<String, InlineTextContent> = mapOf(),
    颜色: ColorProducer? = null,
    自适应大小: TextAutoSize? = null,
) {
    BasicText(
        text = 文本,
        modifier = 修饰符,
        style = 样式,
        onTextLayout = 文本布局回调,
        overflow = 溢出,
        softWrap = 软换行,
        maxLines = 最大行数,
        minLines = 最小行数,
        inlineContent = 内联内容,
        color = 颜色,
        autoSize = 自适应大小,
    )
}

