package 自定义.组合.材质3

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import 安卓x.组合.基础.布局.流式行


@Suppress("ComposableNaming")
@Composable
fun 流式列表多芯片(
    修饰符: Modifier = Modifier,
    标签列表数据: Array<String> = emptyArray(),
    单击回调: (String) -> Unit = {},
    长按回调: (String) -> Unit = {}
) {
    流式行(修饰符 = 修饰符.fillMaxSize().padding(10.dp)) {
        列表多芯片(
            标签列表数据 = 标签列表数据,
            单击回调 = { 单击回调(it) },
            长按回调 = { 长按回调(it) }
        )
    }
}


@Suppress("ComposableNaming")
@Composable
fun 列表多芯片(
    修饰符: Modifier = Modifier,
    标签列表数据: Array<String> = emptyArray(),
    单击回调: (String) -> Unit = {},
    长按回调: (String) -> Unit = {}
) {
    标签列表数据.forEach { 标签 ->
        建议芯片(
            单击回调 = { 单击回调(标签) },
            长按回调 = { 长按回调(标签) },
            标签 = { Text(标签) },
            修饰符 = 修饰符.padding(5.dp, 0.dp, 5.dp, 0.dp)
        )
    }
}