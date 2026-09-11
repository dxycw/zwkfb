package 自定义.组合.界面.窗口

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties



@Suppress("ComposableNaming")
@Preview
@Composable
fun 加载对话框(
    请求关闭回调: () -> Unit = {},
    对话框属性: DialogProperties = DialogProperties(),
    修饰符: Modifier = Modifier,
    形状: Shape = CardDefaults.shape,
    颜色集: CardColors = CardDefaults.cardColors(),
    阴影: CardElevation = CardDefaults.cardElevation(),
    边框: BorderStroke? = null,
) =
    Dialog(
        onDismissRequest = 请求关闭回调,
        properties = 对话框属性
    ){
        Card(
            modifier = 修饰符,
            shape = 形状,
            colors = 颜色集,
            elevation = 阴影,
            border = 边框
        ) {
            Column(
                modifier = 修饰符.padding(20.dp, 10.dp, 20.dp, 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp),
                    strokeWidth = 4.dp
                )
                Text(
                    text = "加载中...",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }


@Suppress("ComposableNaming")
@Preview
@Composable
fun 自定义加载对话框(
    修饰符: Modifier = Modifier,
    是否可视: Boolean = true,
    标题: String? = null,
    内容: String? = null,
    是否自动旋转: Boolean = false,
    进度: Float = 0.5f,
    请求关闭回调: () -> Unit = {}
) {
    if (是否可视) {
        Dialog(onDismissRequest = 请求关闭回调) {
            Card(
                modifier = 修饰符.width(250.dp).padding(16.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (是否自动旋转) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(50.dp),
                            strokeWidth = 4.dp
                        )
                    } else {
                        CircularProgressIndicator(
                            progress = { 进度 },
                            modifier = Modifier.size(50.dp),
                            strokeWidth = 4.dp
                        )
                    }

                    标题?.let { titleText ->
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = titleText,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    内容?.let { messageText ->
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = messageText,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center
                        )
                    }

                    if (!是否自动旋转 && 内容 == null) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "${(进度 * 100).toInt()}%",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}
