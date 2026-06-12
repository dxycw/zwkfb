package 安卓x.组合.基础.文本

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.ImeOptions
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PlatformImeOptions
import androidx.compose.ui.text.intl.LocaleList

/**
 * 文本字段 的键盘配置选项。不保证软件键盘会遵循此处提供的选项。
 *
 * @param 首字母大写 告知键盘是否自动大写字符、单词或句子。仅适用于基于文本的 [KeyboardType]，
 * 例如 [KeyboardType.Text]、[KeyboardType.Ascii]。不适用于 [KeyboardType.Number] 等键盘类型。
 * @param 自动纠正已启用 告知键盘是否启用自动更正。仅适用于基于文本的 [KeyboardType]，
 * 例如 [KeyboardType.Email]、[KeyboardType.Uri]。不适用于 [KeyboardType.Number] 等键盘类型。
 * 大多数键盘实现会忽略 [KeyboardType.Text] 等类型的此值。null 值（默认参数值）表示启用自动更正。
 * @param 键盘类型 此文本字段要使用的键盘类型。请注意，键盘会遵循此输入类型并显示相应的键盘，但这并不保证。例如，
 * 即使你设置了 [KeyboardType.Ascii]，某些键盘仍可能发送非 ASCII 字符。
 * @param 输入法操作 IME 动作。键盘会遵循此 IME 动作，并可能在键盘上显示特定的图标。例如，如果指定了 [ImeAction.Search]，
 * 可能会显示搜索图标。当 [ImeOptions.singleLine] 为 `false` 时，键盘可能会显示回车键，而非此处请求的动作。
 * @param 平台输入法选项 定义平台特定的 IME 选项。
 * @param 显示键盘聚焦回调 当为 true 时，获取焦点后软件键盘将自动显示。当为 false 时，用户必须先进行交互（例如点击），
 * 键盘才会显示。null 值（默认参数值）表示获取焦点时键盘将自动显示。
 * @param 提示语言区域 无论当前使用何种输入法子类型，用户都应切换到的语言列表。此特殊"提示"主要用于（但不限于）
 * 希望输入法根据编辑器上下文切换语言的多语言用户。传入 null 表示不设置特定提示。
 */
@Immutable
class 键盘选项(
    val 首字母大写: KeyboardCapitalization = KeyboardCapitalization.Unspecified,
    @Suppress("AutoBoxing") @get:Suppress("AutoBoxing") val 自动纠正已启用: Boolean? = null,
    val 键盘类型: KeyboardType = KeyboardType.Unspecified,
    val 输入法操作: ImeAction = ImeAction.Unspecified,
    val 平台输入法选项: PlatformImeOptions? = null,
    @Suppress("AutoBoxing") @get:Suppress("AutoBoxing") val 显示键盘聚焦回调: Boolean? = null,
    @get:Suppress("NullableCollection") val 提示语言区域: LocaleList? = null,
) {

    companion object {
        /** 默认 [KeyboardOptions]。默认值请参阅参数说明。 */
        @Stable val 默认 = KeyboardOptions.Default

        /** [基础安全文本字段] 的默认 [KeyboardOptions]。 */
        @Stable
        internal val 安全文本字段 =
            KeyboardOptions(autoCorrectEnabled = false, keyboardType = KeyboardType.Password)
    }

    @Deprecated(
        "Please use the new constructor that takes optional autoCorrectEnabled parameter.",
        level = DeprecationLevel.WARNING,
        replaceWith =
            ReplaceWith(
                "KeyboardOptions(" +
                        "capitalization = capitalization, " +
                        "autoCorrectEnabled = autoCorrect, " +
                        "keyboardType = keyboardType, " +
                        "imeAction = imeAction," +
                        "platformImeOptions = platformImeOptions, " +
                        "showKeyboardOnFocus = showKeyboardOnFocus," +
                        "hintLocales = hintLocales" +
                        ")"
            ),
    )
    constructor(
        首字母大写: KeyboardCapitalization = KeyboardCapitalization.Unspecified,
        自动纠正: Boolean,
        键盘类型: KeyboardType = KeyboardType.Unspecified,
        输入法操作: ImeAction = ImeAction.Unspecified,
        平台输入法选项: PlatformImeOptions? = null,
        @Suppress("AutoBoxing") 显示键盘聚焦回调: Boolean? = null,
        @Suppress("NullableCollection") 提示语言区域: LocaleList? = null,
    ) : this() {
        KeyboardOptions(
            capitalization = 首字母大写,
            autoCorrectEnabled = 自动纠正,
            keyboardType = 键盘类型,
            imeAction = 输入法操作,
            platformImeOptions = 平台输入法选项,
            showKeyboardOnFocus = 显示键盘聚焦回调,
            hintLocales = 提示语言区域,
        )
    }

    @Deprecated("Please use the autoCorrectEnabled property.", level = DeprecationLevel.WARNING)
    val 自动纠正: Boolean
        get() = KeyboardOptions().autoCorrect

    /**
     * 返回此对象的副本，并将传入此方法的值应用到副本上。
     *
     * 请注意，如果将未指定（null）值显式传入此方法，它将替换任何实际已指定的值。这与 [合并] 的行为不同，
     * 后者永远不会用未指定的值覆盖已指定的值。
     */
    fun 复制(
        首字母大写: KeyboardCapitalization = this.首字母大写,
        @Suppress("AutoBoxing") 自动纠正已启用: Boolean? = this.自动纠正已启用,
        键盘类型: KeyboardType = this.键盘类型,
        输入法操作: ImeAction = this.输入法操作,
        平台输入法选项: PlatformImeOptions? = this.平台输入法选项,
        @Suppress("AutoBoxing") 显示键盘聚焦回调: Boolean? = null,
        提示语言区域: LocaleList? = null,
    ): KeyboardOptions {
        return KeyboardOptions().copy(
            capitalization = 首字母大写,
            autoCorrectEnabled = 自动纠正已启用,
            keyboardType = 键盘类型,
            imeAction = 输入法操作,
            platformImeOptions = 平台输入法选项,
            showKeyboardOnFocus = 显示键盘聚焦回调,
            hintLocales = 提示语言区域,
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is KeyboardOptions) return false

        if (首字母大写 != other.capitalization) return false
        if (自动纠正已启用 != other.autoCorrectEnabled) return false
        if (键盘类型 != other.keyboardType) return false
        if (输入法操作 != other.imeAction) return false
        if (平台输入法选项 != other.platformImeOptions) return false
        if (显示键盘聚焦回调 != other.showKeyboardOnFocus) return false
        if (提示语言区域 != other.hintLocales) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 首字母大写.hashCode()
        result = 31 * result + 自动纠正已启用.hashCode()
        result = 31 * result + 键盘类型.hashCode()
        result = 31 * result + 输入法操作.hashCode()
        result = 31 * result + 平台输入法选项.hashCode()
        result = 31 * result + 显示键盘聚焦回调.hashCode()
        result = 31 * result + 提示语言区域.hashCode()
        return result
    }

    override fun toString(): String {
        return "KeyboardOptions(" +
                "capitalization=$首字母大写, " +
                "autoCorrectEnabled=$自动纠正已启用, " +
                "keyboardType=$键盘类型, " +
                "imeAction=$输入法操作, " +
                "platformImeOptions=$平台输入法选项" +
                "showKeyboardOnFocus=$显示键盘聚焦回调, " +
                "hintLocales=$提示语言区域" +
                ")"
    }

    /**
     * 返回一个新的 [KeyboardOptions]，它是此选项与给定 [其他] 选项的组合。
     *
     * [其他] 的 `null` 或 `Unspecified` 属性将由此对象的非 null 属性替换。
     *
     * 如果此对象或 [其他] 为 null，则返回非 null 的那个。
     */
    // TODO(b/331222000) 重命名以更清晰地表明优先级。
    fun 合并(其他: KeyboardOptions?): KeyboardOptions = KeyboardOptions().merge(other = 其他)

}
