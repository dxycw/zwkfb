package 安卓x.组合.材质3

import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.LoadingIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.graphics.shapes.RoundedPolygon

// TODO 更新文档中的图片以指向加载指示器
/**
 * 一个 Material Design 加载指示器。
 *
 * 此版本的加载指示器会根据其 [进度] 的值在其 [多边形] 形状之间进行形变。
 *
 * ![Loading indicator image](https://developer.android.com/images/reference/androidx/compose/material3/loading-indicator.png)
 *
 * @param 进度 此加载指示器的进度，其中 0.0 表示无进度，1.0 表示完成。超出此范围的值将被强制约束到该范围内。
 * 指示器将根据进度值在提供的 [多边形] 之间进行形状形变。
 * @param 修饰符 要应用于此加载指示器的 [Modifier]。
 * @param 颜色 加载指示器的颜色。
 * @param 多边形 一个 `RoundedPolygon` 列表，表示此加载指示器在从 0.0 到 1.0 的进度过程中将依次形变的形状序列。
 * 该列表中至少需要包含两个项目。
 * @throws IllegalArgumentException 如果 [多边形] 列表包含的项目少于两个。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 加载指示器(
    进度: () -> Float,
    修饰符: Modifier = Modifier,
    颜色: Color = LoadingIndicatorDefaults.indicatorColor,
    多边形: List<RoundedPolygon> = LoadingIndicatorDefaults.DeterminateIndicatorPolygons,
) =
    LoadingIndicator(
        progress = 进度,
        modifier = 修饰符,
        color = 颜色,
        polygons = 多边形,
    )

// TODO 将文档中的图片指向加载指示器。
/**
 * 一个 Material Design 加载指示器。
 *
 * 此版本的加载指示器只要可见，就会持续播放动画并在各种形状之间进行形变。
 *
 * ![Loading indicator image](https://developer.android.com/images/reference/androidx/compose/material3/loading-indicator.png)
 *
 * @param 修饰符 要应用于此加载指示器的 [Modifier]。
 * @param 颜色 加载指示器的颜色。
 * @param 多边形 一个 [RoundedPolygon] 列表，表示此加载指示器将在其间形变的形状序列。该列表中至少需要包含两个项目。
 * @throws IllegalArgumentException 如果 [多边形] 列表包含的项目少于两个。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 加载指示器(
    修饰符: Modifier = Modifier,
    颜色: Color = LoadingIndicatorDefaults.indicatorColor,
    多边形: List<RoundedPolygon> = LoadingIndicatorDefaults.IndeterminateIndicatorPolygons,
) =
    LoadingIndicator(
        modifier = 修饰符,
        color = 颜色,
        polygons = 多边形,
    )

// TODO 将文档中的图片更新为指向加载指示器。
/**
 * 一个 Material Design 容器式加载指示器。
 *
 * 此版本的加载指示器会根据其 [进度] 的值在其 [多边形] 形状之间进行形变。此变体中的形状被包含在一个带颜色的 [容器形状] 容器内。
 *
 * ![Contained loading indicator image](https://developer.android.com/images/reference/androidx/compose/material3/contained-loading-indicator.png)
 *
 * @param 进度 此加载指示器的进度，其中 0.0 表示无进度，1.0 表示完成。超出此范围的值将被强制约束到该范围内。
 * 指示器将根据进度值在提供的 [多边形] 之间进行形状形变。
 * @param 修饰符 要应用于此加载指示器的 [Modifier]。
 * @param 容器颜色 加载指示器的容器颜色。
 * @param 指示器颜色 加载指示器的颜色。
 * @param 容器形状 加载指示器的容器形状。
 * @param 多边形 一个 RoundedPolygon 列表，表示此加载指示器在从 0.0 到 1.0 的进度过程中将依次形变的形状序列。
 * 该列表中至少需要包含两个项目。
 * @throws IllegalArgumentException 如果 [多边形] 列表包含的项目少于两个。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 容器加载指示器(
    进度: () -> Float,
    修饰符: Modifier = Modifier,
    容器颜色: Color = LoadingIndicatorDefaults.containedContainerColor,
    指示器颜色: Color = LoadingIndicatorDefaults.containedIndicatorColor,
    容器形状: Shape = LoadingIndicatorDefaults.containerShape,
    多边形: List<RoundedPolygon> = LoadingIndicatorDefaults.DeterminateIndicatorPolygons,
) =
    ContainedLoadingIndicator(
        progress = 进度,
        modifier = 修饰符,
        containerColor = 容器颜色,
        indicatorColor = 指示器颜色,
        containerShape = 容器形状,
        polygons = 多边形,
    )

// TODO 将文档中的图片更新为指向加载指示器。
/**
 * 一个 Material Design 容器式加载指示器。
 *
 * 此版本的加载指示器只要可见，就会持续播放动画并在各种形状之间进行形变。此变体中的形状被包含在一个带颜色的 [容器形状] 容器内。
 *
 * ![Contained loading indicator image](https://developer.android.com/images/reference/androidx/compose/material3/contained-loading-indicator.png)
 *
 * @param 修饰符 要应用于此加载指示器的 [Modifier]。
 * @param 容器颜色 加载指示器的容器颜色。
 * @param 指示器颜色 加载指示器的颜色。
 * @param 容器形状 加载指示器的容器形状。
 * @param 多边形 一个 RoundedPolygon 列表，表示此加载指示器将在其间形变的形状序列。该列表中至少需要包含两个项目。
 * @throws IllegalArgumentException 如果 [多边形] 列表包含的项目少于两个。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 容器加载指示器(
    修饰符: Modifier = Modifier,
    容器颜色: Color = LoadingIndicatorDefaults.containedContainerColor,
    指示器颜色: Color = LoadingIndicatorDefaults.containedIndicatorColor,
    容器形状: Shape = LoadingIndicatorDefaults.containerShape,
    多边形: List<RoundedPolygon> = LoadingIndicatorDefaults.IndeterminateIndicatorPolygons,
) =
    ContainedLoadingIndicator(
        modifier = 修饰符,
        containerColor = 容器颜色,
        indicatorColor = 指示器颜色,
        containerShape = 容器形状,
        polygons = 多边形,
    )



/** 包含 [加载指示器] 的默认值。 */
@ExperimentalMaterial3ExpressiveApi
object 加载指示器默认值 { // LoadingIndicatorDefaults

    /** [加载指示器] 的默认容器宽度。*/
    val 容器宽度: Dp = LoadingIndicatorDefaults.ContainerWidth

    /** [加载指示器] 的默认容器高度。*/
    val 容器高度: Dp = LoadingIndicatorDefaults.ContainerHeight

    /** [加载指示器] 的默认活动指示器尺寸。*/
    val 指示器大小 = LoadingIndicatorDefaults.IndicatorSize

    /** [加载指示器] 的默认容器 [Shape]。 */
    val 容器形状: Shape
        @Composable get() = LoadingIndicatorDefaults.containerShape

    /** 使用非容器式 [加载指示器] 时的默认活动指示器 [Color]。*/
    val 指示器颜色: Color
        @Composable get() = LoadingIndicatorDefaults.indicatorColor

    /** 使用 [容器加载指示器] 时的默认活动指示器 [Color]。*/
    val 容器指示器颜色: Color
        @Composable get() = LoadingIndicatorDefaults.containedIndicatorColor

    /** 使用 [容器加载指示器] 时的默认容器 [Color]。 */
    val 容器容器颜色: Color
        @Composable get() = LoadingIndicatorDefaults.containedContainerColor

    /**
     * 不确定性 [加载指示器] 在动画时将在其间形变的 [RoundedPolygon] 序列。
     *
     * 默认情况下，不确定性加载指示器将在七个形状之间进行形变，但您在调用 API 时可以提供自己的形状序列。
     */
    val 不确定性指示器多边形 = LoadingIndicatorDefaults.IndeterminateIndicatorPolygons

    /**
     * 确定性 [加载指示器] 在动画时将在其间形变的 [RoundedPolygon] 序列。当进度从零移动到一时，
     * 加载指示器将在这些形状之间进行形变。
     *
     * 默认情况下，确定性加载指示器将在两个形状之间进行形变，但您在调用 API 时可以提供自己的形状序列。
     */
    val 确定性指示器多边形 = LoadingIndicatorDefaults.DeterminateIndicatorPolygons

}


