package 自定义.组合.材质3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Stable
//@ExperimentalMaterial3Api
object 底部面板默认值 {

    @Suppress("ComposableNaming")
    @Composable
    fun 拖拽手柄(
        修饰符: Modifier = Modifier,
        宽度: Dp = 32.0.dp,
        高度: Dp = 4.0.dp,
        垂直间距: Dp = 22.dp,
        形状: Shape = MaterialTheme.shapes.extraLarge,
        颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    ) {
        Surface(
            modifier = 修饰符.padding(vertical = 垂直间距),
            shape = 形状, color = 颜色,
        ) { Box(Modifier.size(width = 宽度, height = 高度)) }
    }

}
