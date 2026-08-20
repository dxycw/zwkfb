package 自定义.组合.材质3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import 自定义.组合.材质.图像集.图像集
import 自定义.组合.材质.图像集.轮廓.空盒子


@Suppress("ComposableNaming")
@Composable
fun 箱子空(
    文本: String? = null,
    修饰符: Modifier = Modifier
){
    Column(
        modifier = 修饰符.fillMaxSize().padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            imageVector = 图像集.轮廓.空盒子,
            contentDescription = null,
        )
        if (文本 != null){
            Text(
                text = 文本,
                modifier = Modifier.padding(10.dp),
                color = Color.Gray
            )
        }
    }
}