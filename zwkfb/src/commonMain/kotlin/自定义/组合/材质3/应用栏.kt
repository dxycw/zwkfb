package 自定义.组合.材质3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier



@Suppress("ComposableNaming")
@Composable
fun 顶部应用栏(
    修饰符: Modifier = Modifier,
    水平排列: Arrangement.Horizontal = Arrangement.Start,
    垂直对齐: Alignment.Vertical = Alignment.Top,
    内容: @Composable RowScope.() -> Unit = {}
) =
    Row(
        modifier = 修饰符.fillMaxWidth().statusBarsPadding(),
        verticalAlignment = 垂直对齐,
        horizontalArrangement = 水平排列,
        content = 内容
    )