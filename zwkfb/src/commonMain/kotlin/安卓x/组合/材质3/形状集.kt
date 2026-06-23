package 安卓x.组合.材质3

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.RectangleShape

/**
 * Material 表面可以以不同的形状显示。形状能够引导注意力、标识组件、传达状态，并表达品牌个性。
 *
 * 形状比例尺定义了容器圆角的样式，提供从方形到完全圆形的多种圆度选择。
 *
 * 形状有不同的尺寸：
 * - 超小
 * - 小
 * - 中
 * - 大、大（增大版）
 * - 超大、超大（增大版）
 * - 超超大
 *
 * 你可以在 [MaterialTheme] 中为所有组件自定义形状系统，也可以针对单个组件进行设置。
 *
 * 你可以通过覆盖组件的 shape 参数来更改组件的形状。例如，默认情况下，按钮使用"完全"形状样式。如果你的产品需要较小的圆角程度，
 * 你可以使用 [MaterialTheme.shapes] 中不同的形状值（如 [Shapes.small]）来覆盖 shape 参数。
 *
 * To learn more about shapes, see [Material Design shapes](https://m3.material.io/styles/shape/overview).
 *
 * @param 超小 一种四个角大小相同的形状样式，其圆角尺寸大于 [RectangleShape] 且小于 [Shapes.small]。默认情况下，
 * 自动补全菜单、选择菜单、Snackbar、标准菜单和文本字段均使用此形状。
 * @param 小 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.extraSmall] 且小于 [Shapes.medium]。默认情况下，Chip 使用此形状。
 * @param 中 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.small] 且小于 [Shapes.large]。默认情况下，
 * 卡片和小型浮动操作按钮（Small FAB）使用此形状。
 * @param 大 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.medium] 且小于 [Shapes.extraLarge]。默认情况下，
 * 扩展浮动操作按钮（Extended FAB）、浮动操作按钮（FAB）和导航抽屉（Navigation Drawers）使用此形状。
 * @param 超大 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.large] 且小于 [CircleShape]。默认情况下，
 * 大型浮动操作按钮（Large FAB）使用此形状。
 * @param 大增加 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.medium] 且小于 [Shapes.extraLarge]。
 * [Shapes.large] 的稍大变体。
 * @param 超大增加 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.large] 且小于 [Shapes.extraExtraLarge]。
 * [Shapes.extraLarge] 的稍大变体。
 * @param 超超大 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.extraLarge] 且小于 [CircleShape]。
 */
// TODO: 更新新的形状描述，列出默认使用它们的组件。
// TODO(b/368578382): 更新 increased 变体的 KDoc，使其引用设计文档。
@ExperimentalMaterial3ExpressiveApi
fun 形状集(
    // None 和 Full 两种形状已被省略，因为 None 等同于 RectangleShape，而 Full 等同于 CircleShape。
    超小: CornerBasedShape = ShapeDefaults.ExtraSmall,
    小: CornerBasedShape = ShapeDefaults.Small,
    中: CornerBasedShape = ShapeDefaults.Medium,
    大: CornerBasedShape = ShapeDefaults.Large,
    超大: CornerBasedShape = ShapeDefaults.ExtraLarge,
    大增加: CornerBasedShape = ShapeDefaults.LargeIncreased,
    超大增加: CornerBasedShape = ShapeDefaults.ExtraLargeIncreased,
    超超大: CornerBasedShape = ShapeDefaults.ExtraExtraLarge,
) =
    Shapes(
        extraSmall = 超小,
        small = 小,
        medium = 中,
        large = 大,
        extraLarge = 超大,
        largeIncreased = 大增加,
        extraLargeIncreased = 超大增加,
        extraExtraLarge = 超超大,
    )


/** 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.medium] 且小于 [Shapes.extraLarge]。[Shapes.large] 的稍大变体。*/
@ExperimentalMaterial3ExpressiveApi
val Shapes.大增加
    get() = this.largeIncreased

/** 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.large] 且小于 [Shapes.extraExtraLarge]。[Shapes.extraLarge] 的稍大变体。*/
@ExperimentalMaterial3ExpressiveApi
val Shapes.超大增加
    get() = this.extraLargeIncreased

/** 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.extraLarge] 且小于 [CircleShape]。*/
@ExperimentalMaterial3ExpressiveApi
val Shapes.超超大
    get() = this.extraExtraLarge



/**
 * Material 表面可以以不同的形状显示。形状能够引导注意力、标识组件、传达状态，并表达品牌个性。
 *
 * 形状比例尺定义了容器圆角的样式，提供从方形到完全圆形的多种圆度选择。
 *
 * 形状有不同的尺寸：
 * - 超小
 * - 小
 * - 中
 * - 大、大（增大版）
 * - 超大、超大（增大版）
 * - 超超大
 *
 * 你可以在 [MaterialTheme] 中为所有组件自定义形状系统，也可以针对单个组件进行设置。
 *
 * 你可以通过覆盖组件的 shape 参数来更改组件的形状。例如，默认情况下，按钮使用"完全"形状样式。如果你的产品需要较小的圆角程度，
 * 你可以使用 [MaterialTheme.shapes] 中不同的形状值（如 [Shapes.small]）来覆盖 shape 参数。
 *
 * To learn more about shapes, see [Material Design shapes](https://m3.material.io/styles/shape/overview).
 *
 * @param 超小 一种四个角大小相同的形状样式，其圆角尺寸大于 [RectangleShape] 且小于 [Shapes.small]。默认情况下，
 * 自动补全菜单、选择菜单、Snackbar、标准菜单和文本字段均使用此形状。
 * @param 小 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.extraSmall] 且小于 [Shapes.medium]。默认情况下，Chip 使用此形状。
 * @param 中 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.small] 且小于 [Shapes.large]。默认情况下，
 * 卡片和小型浮动操作按钮（Small FAB）使用此形状。
 * @param 大 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.medium] 且小于 [Shapes.extraLarge]。默认情况下，
 * 扩展浮动操作按钮（Extended FAB）、浮动操作按钮（FAB）和导航抽屉（Navigation Drawers）使用此形状。
 * @param 超大 一种四个角大小相同的形状样式，其圆角尺寸大于 [Shapes.large] 且小于 [CircleShape]。默认情况下，
 * 大型浮动操作按钮（Large FAB）使用此形状。
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
fun 形状集(
    超小: CornerBasedShape = ShapeDefaults.ExtraSmall,
    小: CornerBasedShape = ShapeDefaults.Small,
    中: CornerBasedShape = ShapeDefaults.Medium,
    大: CornerBasedShape = ShapeDefaults.Large,
    超大: CornerBasedShape = ShapeDefaults.ExtraLarge,
) =
    Shapes(
        extraSmall = 超小,
        small = 小,
        medium = 中,
        large = 大,
        extraLarge = 超大,
    )


/** 返回此 Shapes 的副本，可选择性地覆盖其中某些值。 */
@ExperimentalMaterial3ExpressiveApi
fun Shapes.复制(
    超小: CornerBasedShape = this.extraSmall,
    小: CornerBasedShape = this.small,
    中: CornerBasedShape = this.medium,
    大: CornerBasedShape = this.large,
    超大: CornerBasedShape = this.extraLarge,
    大增加: CornerBasedShape = this.largeIncreased,
    超大增加: CornerBasedShape = this.extraLargeIncreased,
    超超大: CornerBasedShape = this.extraExtraLarge,
): Shapes =
    this.copy(
        extraSmall = 超小,
        small = 小,
        medium = 中,
        large = 大,
        extraLarge = 超大,
        largeIncreased = 大增加,
        extraLargeIncreased = 超大增加,
        extraExtraLarge = 超超大,
    )


/** 返回此 Shapes 的副本，可选择性地覆盖其中某些值。 */
fun Shapes.复制(
    超小: CornerBasedShape = this.extraSmall,
    小: CornerBasedShape = this.small,
    中: CornerBasedShape = this.medium,
    大: CornerBasedShape = this.large,
    超大: CornerBasedShape = this.extraLarge,
): Shapes =
    this.copy(
        extraSmall = 超小,
        small = 小,
        medium = 中,
        large = 大,
        extraLarge = 超大,
    )




/** 包含 [Shapes] 使用的默认值。 */
object 形状默认值 { // ShapeDefaults

    /** 超小尺寸圆角形状 */
    val 超小: CornerBasedShape = ShapeDefaults.ExtraSmall

    /** 小尺寸圆角形状 */
    val 小: CornerBasedShape = ShapeDefaults.Small

    /** 中尺寸圆角形状 */
    val 中: CornerBasedShape = ShapeDefaults.Medium

    /** 大尺寸圆角形状 */
    val 大: CornerBasedShape = ShapeDefaults.Large

    /** 大尺寸圆角形状，比 [大] 稍大 */
    @ExperimentalMaterial3ExpressiveApi
    val 大增加: CornerBasedShape = ShapeDefaults.LargeIncreased

    /** 超大尺寸圆角形状 */
    val 超大: CornerBasedShape = ShapeDefaults.ExtraLarge

    /** 超大尺寸圆角形状，比 [超大] 稍大 */
    @ExperimentalMaterial3ExpressiveApi
    val 超大增加: CornerBasedShape = ShapeDefaults.ExtraLargeIncreased

    /** 超超大（XXL）尺寸圆角形状 */
    @ExperimentalMaterial3ExpressiveApi
    val 超超大: CornerBasedShape = ShapeDefaults.ExtraExtraLarge

}

