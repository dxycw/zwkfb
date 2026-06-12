package 安卓x.组合.基础.文本.输入

import androidx.compose.foundation.text.input.TextObfuscationMode
import kotlin.jvm.JvmInline

/**
 * 定义安全文本输入框中的文本隐藏方式。
 *
 * 文本隐藏是指通过各种方法将原始文本内容替换为掩码。这在密码输入框中最为常见。
 *
 * 用户通常习惯于在不同平台上获得不同的安全文本输入默认体验。在桌面端，惯例是将输入内容完全隐藏。相反，
 * 移动平台通常会在短时间内显示最后输入的字符。这种显示会持续一段较短的时间，或直到输入下一个字符为止，
 * 帮助用户跟踪他们的输入，同时通过不暴露过多信息来保持隐私。
 */
object 文本混淆模式{
    /**
     * 不隐藏任何内容，使所有内容可见。
     *
     * 当你想要通过切换显示图标来短暂显示内容时，这会很有用。
     */
    val 可见 = TextObfuscationMode.Visible

    /**
     * 在短时间内显示最后输入的字符。
     *
     * 注意：在 Android 上，此功能还取决于名为 `Settings.System.TEXT_SHOW_PASSWORD` 的系统设置。
     * 如果该系统设置被禁用，此选项的行为将与 [可见] 完全相同。
     */
    val 显示最后输入字符 = TextObfuscationMode.RevealLastTyped

    /** 所有字符均被隐藏。 */
    val 隐藏 = TextObfuscationMode.Hidden
}


/**
 * 平台相关的安全文本输入框默认隐藏模式。
 *
 *  在 Android 上，此值设置为 [TextObfuscationMode.RevealLastTyped]。
 */
// TODO(b/425658491); 即将其设为公开（public）。
internal expect val TextObfuscationMode.Companion.默认: TextObfuscationMode
