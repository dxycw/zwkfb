package 安卓x.组合.材质3

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.MotionScheme.Companion.standard
import androidx.compose.material3.Typography
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable

/**
 * Material 主题化（Material Theming）是指对您的 Material Design 应用进行自定义，以便更好地体现您产品的品牌形象。
 *
 * Material 组件（例如 [按钮] 和 [Checkbox]）在获取默认值时，会使用此处提供的值。
 *
 * 所有值都可以通过为该组件提供 [颜色方案][ColorScheme]、[排版][Typography] 和 [形状集][Shapes] 属性来设置。
 * 使用此方法可以配置此 材质主题 内元素的整体主题。
 *
 * 任何未设置的值都将从当前主题中继承，如果没有父级 材质主题，则回退到默认值。这允许您在应用程序顶层使用一个 材质主题，
 * 然后为不同的屏幕或 UI 部分使用独立的 材质主题，仅覆盖需要更改的主题定义部分。
 *
 * @param 颜色方案 此层级结构的 Material 颜色主题的完整定义
 * @param 形状集 一组用作此层级结构形状系统的圆角形状
 * @param 排版 一组用作此层级结构排版系统的文本样式
 * @param 内容 继承此主题的内容
 */
@Suppress("ComposableNaming")
@Composable
fun 材质主题(
    颜色方案: ColorScheme = MaterialTheme.colorScheme,
    形状集: Shapes = MaterialTheme.shapes,
    排版: Typography = MaterialTheme.typography,
    内容: @Composable () -> Unit,
) =
    MaterialTheme(
        colorScheme = 颜色方案,
        shapes = 形状集,
        typography = 排版,
        content = 内容,
    )

/**
 * Material 主题化（Material Theming）是指对您的 Material Design 应用进行自定义，以便更好地体现您产品的品牌形象。
 *
 * Material 组件（例如 [按钮] 和 [Checkbox]）在获取默认值时，会使用此处提供的值。
 *
 * 所有值都可以通过为该组件提供 [颜色方案][ColorScheme] 和 [排版][Typography] 属性来设置。
 * 使用此方法可以配置此 材质主题 内元素的整体主题。
 *
 * 任何未设置的值都将从当前主题中继承，如果没有父级 材质主题，则回退到默认值。这允许您在应用程序顶层使用一个 材质主题，
 * 然后为不同的屏幕或 UI 部分使用独立的 材质主题，仅覆盖需要更改的主题定义部分。
 *
 * @param 颜色方案 此层级结构的 Material 颜色主题的完整定义
 * @param 动画方案 此层级结构的 Material 动效方案（Motion Scheme）的完整定义
 * @param 形状集 一组用作此层级结构形状系统的圆角形状
 * @param 排版 一组用作此层级结构排版系统的文本样式
 * @param 内容 继承此主题的内容
 */
@Suppress("ComposableNaming")
@Composable
fun 材质主题(
    颜色方案: ColorScheme = MaterialTheme.colorScheme,
    动画方案: MotionScheme = MaterialTheme.motionScheme,
    形状集: Shapes = MaterialTheme.shapes,
    排版: Typography = MaterialTheme.typography,
    内容: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = 颜色方案,
        motionScheme = 动画方案,
        shapes = 形状集,
        typography = 排版,
        content = 内容,
    )
}

/** 包含用于访问在调用位置所处的层级结构中提供的当前主题值的函数。*/
object 材质主题 { // MaterialTheme

    /** 检索调用位置在层级结构中当前的 [颜色方案][颜色方案]。*/
    val 颜色方案: ColorScheme
        @Composable @ReadOnlyComposable get() = MaterialTheme.colorScheme

    /** 检索调用位置在层级结构中当前的 [排版][排版]。*/
    val 排版: Typography
        @Composable @ReadOnlyComposable get() = MaterialTheme.typography

    /** 检索调用位置在层级结构中当前的 [形状集][形状集]。*/
    val 形状集: Shapes
        @Composable @ReadOnlyComposable get() = MaterialTheme.shapes

    /** 检索调用位置在层级结构中当前的 [动画方案][动画方案]。 */
    @OptIn(ExperimentalMaterial3ExpressiveApi::class)
    val 动画方案: MotionScheme
        @Composable @ReadOnlyComposable get() = MaterialTheme.motionScheme

    /**
     * [CompositionLocal] 用于在整个层级结构中提供 [材质主题][材质主题] 的各个子系统。你可以使用伴生对象中的属性来访问特定的子系统，
     * 例如 [颜色方案][颜色方案]。若要为此提供新值，请使用 [材质主题][材质主题]。暴露此 API 是为了允许从
     * CompositionLocalConsumerModifierNode 实现内部检索值——在大多数情况下，你应该直接使用 [颜色方案][颜色方案] 和其他属性。
     */
    val 本地材质主题: CompositionLocal<MaterialTheme.Values>
        get() = MaterialTheme.LocalMaterialTheme

    /**
     * 一个只读的 `CompositionLocal`，用于向 Material 3 组件提供当前的 [动效方案][动画方案]。
     *
     * 动效方案通常由 [材质主题.动效方案][MaterialTheme.motionScheme] 提供，并且可以通过用另一个 [材质主题][材质主题]
     * 包装特定的 UI 子树来覆盖它。
     *
     * 暴露此 API 是为了允许从 CompositionLocalConsumerModifierNode 实现内部检索动效值，但在大多数情况下，建议从
     * [材质主题.动效方案][MaterialTheme.motionScheme] 中读取动效值。
     */
    @Suppress("ExperimentalPropertyAnnotation")
    @ExperimentalMaterial3ExpressiveApi
    @Deprecated(
        level = DeprecationLevel.WARNING,
        message = "Use [LocalMaterialTheme.current.motionScheme] instead",
    )
    val 本地动画方案: CompositionLocal<MotionScheme>
        get() = MaterialTheme.LocalMotionScheme

    /**
     * Material 3 包含不同的主题子系统，以允许在整个 UI 层级结构中进行视觉自定义。
     *
     * 组件在获取默认值时，会使用此处提供的属性。
     *
     * @property 颜色方案 Material 组件使用的 [颜色方案][ColorScheme]
     * @property 排版 Material 组件使用的 [排版][Typography]
     * @property 形状集 Material 组件使用的 [形状集][Shapes]
     * @property 动画方案 Material 组件使用的 [动画方案][MotionScheme]
     */
    @Immutable
    class 值集(
        val 颜色方案: ColorScheme = lightColorScheme(),
        val 排版: Typography = Typography(),
        val 形状集: Shapes = Shapes(),
        val 动画方案: MotionScheme = standard(),
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as 值集

            if (颜色方案 != other.颜色方案) return false
            if (排版 != other.排版) return false
            if (形状集 != other.形状集) return false
            if (动画方案 != other.动画方案) return false

            return true
        }

        override fun hashCode(): Int {
            var result = 颜色方案.hashCode()
            result = 31 * result + 排版.hashCode()
            result = 31 * result + 形状集.hashCode()
            result = 31 * result + 动画方案.hashCode()
            return result
        }

        override fun toString(): String {
            return "值集(颜色方案=$颜色方案, 排版=$排版, 形状集=$形状集, 动画方案=$动画方案)"
        }
    }
}

/**
 * Material 表现力主题化（Material Expressive Theming）是指对您的 Material Design 应用进行自定义，以便更好地体现您产品的品牌形象。
 *
 * Material 组件（例如 [按钮] 和 [Checkbox]）在获取默认值时，会使用此处提供的值。
 *
 * 所有值都可以通过为该组件提供 [颜色方案][ColorScheme]、[排版][Typography] 和 [形状][Shapes] 属性来设置。
 * 使用此方法可以配置此 材质主题 内元素的整体主题。
 *
 * 任何未设置的值都将回退到默认值。若要继承主题的当前值，请将其传入后续调用中，并仅覆盖需要更改的主题定义部分。
 *
 * 或者，仅在应用程序顶层调用此函数，然后调用 [材质主题] 为不同的屏幕或 UI 部分指定独立的 材质主题，仅覆盖需要更改的主题定义部分。
 *
 * @param 颜色方案 此层级结构的 Material 颜色主题的完整定义
 * @param 动画方案 此层级结构的 Material 动效主题的完整定义
 * @param 形状集 一组用作此层级结构形状系统的圆角形状
 * @param 排版 一组用作此层级结构排版系统的文本样式
 * @param 内容 继承此主题的内容
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 材质表现主题(
    颜色方案: ColorScheme? = null,
    动画方案: MotionScheme? = null,
    形状集: Shapes? = null,
    排版: Typography? = null,
    内容: @Composable () -> Unit,
) {
    MaterialExpressiveTheme(
        colorScheme = 颜色方案,
        motionScheme = 动画方案,
        shapes = 形状集,
        typography = 排版,
        content = 内容,
    )
}

