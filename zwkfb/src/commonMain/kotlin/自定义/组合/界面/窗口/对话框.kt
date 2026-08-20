package 自定义.组合.界面.窗口

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Suppress("ComposableNaming")
@Preview
@Composable
fun 信息对话框(
    关闭请求回调: () -> Unit = {},
    属性集: DialogProperties = DialogProperties(),
    修饰符: Modifier = Modifier,
    形状: Shape = CardDefaults.shape,
    颜色集: CardColors = CardDefaults.cardColors(),
    阴影: CardElevation = CardDefaults.cardElevation(),
    边框: BorderStroke? = null,
    标题对齐: Arrangement.Horizontal = Arrangement.Start,
    内容对齐: Alignment.Horizontal = Alignment.Start,
    标题: String = "标题",
    内容: String = "内容",
    忽略按钮文本: String = "忽略",
    取消按钮文本: String = "取消",
    确定按钮文本: String = "确定",
    忽略文本颜色: Color = Color.Black,
    取消文本颜色: Color = Color.Black,
    确定文本颜色: Color = Color.Black,
    忽略按钮单击回调: (() -> Unit)? = null,
    取消按钮单击回调: (() -> Unit)? = null,
    确定按钮单击回调: (() -> Unit)? = null,
){
    Dialog(
        onDismissRequest = 关闭请求回调,
        properties = 属性集
    ){
        Card(
            modifier = 修饰符,
            shape = 形状,
            colors = 颜色集,
            elevation = 阴影,
            border = 边框
        ) {
            Column{
                Column(modifier = Modifier){
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = 标题对齐,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = 标题,
                            modifier = Modifier.padding(10.dp),
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = 内容,
                        modifier = Modifier.padding(10.dp).align(内容对齐),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                if (确定按钮单击回调 != null || 取消按钮单击回调 != null || 忽略按钮单击回调 != null){
                    HorizontalDivider(thickness = 0.5.dp)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    if (忽略按钮单击回调 != null){
                        Column(
                            modifier = Modifier.weight(1f).height(48.dp)
                                .clickable { 忽略按钮单击回调() },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                text = 忽略按钮文本,
                                modifier = Modifier,
                                textAlign = TextAlign.Center,
                                color = 忽略文本颜色
                            )
                        }
                        VerticalDivider(modifier = Modifier.height(48.dp),thickness = 0.5.dp)
                    }
                    if (取消按钮单击回调 != null){
                        Column(
                            modifier = Modifier.weight(1f).height(48.dp)
                                .clickable { 取消按钮单击回调() },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                text = 取消按钮文本,
                                modifier = Modifier,
                                textAlign = TextAlign.Center,
                                color = 取消文本颜色
                            )
                        }
                        VerticalDivider(modifier = Modifier.height(48.dp),thickness = 0.5.dp)
                    }
                    if (确定按钮单击回调 != null){
                        Column(
                            modifier = Modifier.weight(1f).height(48.dp)
                                .clickable { 确定按钮单击回调() },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                text = 确定按钮文本,
                                modifier = Modifier,
                                textAlign = TextAlign.Center,
                                color = 确定文本颜色
                            )
                        }
                    }
                }
            }
        }
    }
}