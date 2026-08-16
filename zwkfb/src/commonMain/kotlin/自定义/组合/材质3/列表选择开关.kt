package 自定义.组合.材质3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Suppress("ComposableNaming")
@Preview
@Composable
fun 列表选择开关(
    修饰符: Modifier = Modifier,
    颜色集: CardColors = CardDefaults.cardColors(),
    阴影: CardElevation = CardDefaults.cardElevation(0.dp),
    形状: Shape = CardDefaults.shape,
    列表图标: ImageVector? = null,
    列表标题: String = "标题",
    列表副标题: String = "副标题",
    开关状态: Boolean = false,
    轨道内容: @Composable () -> Unit = {},
    单击回调: (Boolean) -> Unit = {},
) {
    val 图标主题颜色 = if (isSystemInDarkTheme()) Color.White else Color.Black

    Card(
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .clickable { 单击回调(开关状态) },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        content = {
                            if (列表图标 != null) {
                                Icon(
                                    imageVector = 列表图标,
                                    modifier = Modifier
                                        .padding(20.dp, 20.dp, 10.dp, 20.dp)
                                        .size(25.dp),
                                    contentDescription = "图标",
                                    tint = 图标主题颜色
                                )
                            }
                            Column (
                                modifier = Modifier.weight(1f)
                                    .padding(start = 15.dp),
                                content = {
                                    if (列表副标题 != "副标题") {
                                        Text(
                                            text = 列表标题,
                                            modifier = Modifier.padding(top = 10.dp),
                                            fontSize = 17.sp
                                        )
                                        Text(
                                            text = 列表副标题,
                                            modifier = Modifier.padding(bottom = 10.dp),
                                            color = Color.Gray,
                                            fontSize = 14.sp
                                        )
                                    } else {
                                        Text(
                                            text = 列表标题,
                                            fontSize = 17.sp
                                        )
                                    }
                                }
                            )
                            Switch(
                                checked = 开关状态,
                                onCheckedChange = { 状态 ->
                                    单击回调(开关状态)
                                },
                                modifier = Modifier
                                    .padding(start = 10.dp, 8.dp, end = 20.dp, 8.dp),
                                thumbContent = 轨道内容,
                            )
                        }
                    )
                }
            )
        }
    )
}




data class 开关列表数据(
    val 列表图标: ImageVector? = null,
    val 列表标题: String = "标题",
    val 列表副标题: String = "副标题",
    val 开关状态: Boolean = false,
    val 轨道内容: @Composable () -> Unit = {}
)


/**
 * 案例：
 *
 *             val 列表数据 = listOf(
 *                 开关列表数据(),
 *                 开关列表数据(),
 *                 开关列表数据()
 *             )
 *
 *
 *             列表多选择开关(
 *                 修饰符 = Modifier.padding(10.dp),
 *                 列表数据 = 列表数据
 *             ){ 索引, 开关状态 ->
 *
 *             }
 */
@Suppress("ComposableNaming")
@Composable
fun 列表多选择开关(
    修饰符: Modifier = Modifier,
    颜色集: CardColors = CardDefaults.cardColors(),
    阴影: CardElevation = CardDefaults.cardElevation(0.dp),
    形状: Shape = CardDefaults.shape,
    列表数据: List<开关列表数据> = emptyList(),
    单击回调: (Int, Boolean) -> Unit,
) {
    列表数据.forEachIndexed { 项目索引, 导航栏项目数据 ->
        列表选择开关(
            修饰符 = 修饰符,
            颜色集 = 颜色集,
            阴影 = 阴影,
            形状 = 形状,
            列表图标 = 导航栏项目数据.列表图标,
            列表标题 = 导航栏项目数据.列表标题,
            列表副标题 = 导航栏项目数据.列表副标题,
            开关状态 = 导航栏项目数据.开关状态,
            轨道内容 = 导航栏项目数据.轨道内容,
            单击回调 = { 单击回调(项目索引, 导航栏项目数据.开关状态) },
        )
    }
}