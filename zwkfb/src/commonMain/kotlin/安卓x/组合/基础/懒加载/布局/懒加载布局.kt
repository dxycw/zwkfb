package 安卓x.组合.基础.懒加载.布局

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.layout.LazyLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


/**
 * 一种仅组合和布局当前所需项目的布局。可用于构建高效复杂的布局。当前所需的项目取决于 LazyLayout 的实现，即 [LazyLayoutMeasurePolicy]
 * 的实现方式。在测量阶段组合项目是表示哪些项目"当前需要"的信号。一般来说，只有可见项目被视为需要的，但可以通过调用
 * [LazyLayoutMeasureScope.compose] 来请求额外的项目。
 *
 * 这是用于构建高效复杂布局的低级 API，如需可直接使用的线性可滚动惰性布局实现，请参阅
 * [androidx.compose.foundation.lazy.LazyColumn] 和 [androidx.compose.foundation.lazy.LazyRow]。
 * 如需网格状可滚动惰性布局，请参阅  [androidx.compose.foundation.lazy.grid.LazyVerticalGrid] 和
 * [androidx.compose.foundation.lazy.grid.LazyHorizontalGrid]。如需分页器式惰性布局，请参阅
 * [androidx.compose.foundation.pager.VerticalPager] 和 [androidx.compose.foundation.pager.HorizontalPager]。
 *
 * @param 项提供器 一个 lambda，用于生成包含所有必要信息的项目提供器，这些信息可用于在 [测量策略] 中组合和测量项目。
 * 这是您的项目数据源与 LazyLayout 之间的桥梁，以 lambda 形式实现以促进高性能实现。支持 [LazyLayoutItemProvider]
 * 的状态支持实现，但建议将其实现为不可变实体，在数据集更新时返回新实例。
 * @param 修饰符 应用于布局
 * @param 预取状态 允许调度项目进行预取。有关如何控制预取，请参阅 [LazyLayoutPrefetchState]。传递 null 将禁用预取。
 * @param 测量策略 测量策略，允许仅组合和测量所需的项目。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun 懒加载布局(
    项提供器: () -> LazyLayoutItemProvider,
    修饰符: Modifier = Modifier,
    预取状态: LazyLayoutPrefetchState? = null,
    测量策略: LazyLayoutMeasurePolicy,
) =
    LazyLayout(
        itemProvider = 项提供器,
        modifier = 修饰符,
        prefetchState = 预取状态,
        measurePolicy = 测量策略,
    )



