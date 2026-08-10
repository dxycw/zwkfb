package 自定义.组合.材质3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetDefaults.DragHandle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue.Hidden
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberBottomSheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ComposableNaming")
@Composable
fun 信息底部面板(
    绘制器: Painter? = null,
    标题: String = "",
    标题字体大小: TextUnit = 18.sp,
    内容: String = "",
    内容最大行数: Int = Int.MAX_VALUE,
    内容字体溢出: TextOverflow = TextOverflow.Clip,
    内容字体大小: TextUnit = TextUnit.Unspecified,
    请求关闭回调: () -> Unit = {  },
    修饰符: Modifier = Modifier,
    运行状态: SheetState = rememberBottomSheetState(initialValue = Hidden),
    运行最大宽度: Dp = BottomSheetDefaults.SheetMaxWidth,
    形状: Shape = BottomSheetDefaults.ExpandedShape,
    容器颜色: Color = BottomSheetDefaults.ContainerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    色调阴影: Dp = 0.dp,
    遮罩颜色: Color = BottomSheetDefaults.ScrimColor,
    拖动手柄: @Composable (() -> Unit)? = { DragHandle() },
    内容窗口边距: @Composable () -> WindowInsets = { BottomSheetDefaults.windowInsets},
    配置属性: ModalBottomSheetProperties = ModalBottomSheetDefaults.properties,
    忽略文本: String = "忽略",
    忽略按钮: (() -> Unit)? = null,
    取消文本: String = "取消",
    取消按钮: (() -> Unit)? = null,
    确定文本: String = "确定",
    确定按钮: (() -> Unit)? = null
){
    ModalBottomSheet(
        onDismissRequest = 请求关闭回调,
        modifier = 修饰符.statusBarsPadding(),
        sheetState = 运行状态,
        sheetMaxWidth = 运行最大宽度,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        scrimColor = 遮罩颜色,
        dragHandle = {  },
        contentWindowInsets = 内容窗口边距,
        properties = 配置属性,
    ){
        Column {
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                拖动手柄?.invoke()
            }
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                if (绘制器 != null){
                    Icon(
                        painter = 绘制器,
                        contentDescription = "图标",
                        modifier = Modifier.size(25.dp.plus(20.dp))
                            .padding(start = 10.dp,top = 10.dp,bottom = 10.dp)
                    )
                }
                Text(
                    text = 标题, modifier = Modifier.weight(1f).padding(10.dp),
                    fontSize = 标题字体大小, fontWeight = FontWeight.Bold
                )
            }
            Box(
                Modifier.verticalScroll(rememberScrollState()).weight(1f,false)
            ){
                Text(
                    text = 内容,
                    modifier = Modifier.fillMaxWidth()
                        .padding(10.dp,5.dp,10.dp,5.dp),
                    fontSize = 内容字体大小,
                    maxLines = 内容最大行数, overflow = 内容字体溢出
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                if (忽略按钮 != null){
                    OutlinedButton(
                        onClick = 忽略按钮,
                        modifier = Modifier.padding(20.dp,5.dp,bottom = 5.dp)
                    ){ Text(忽略文本) }
                }
                Spacer(Modifier.weight(1f))
                if (取消按钮 != null){
                    OutlinedButton(
                        onClick = 取消按钮, modifier = Modifier
                        .padding(top = 5.dp, end = 10.dp, bottom = 5.dp)
                    ){ Text(取消文本) }
                }
                if (确定按钮 != null){
                    Button(
                        onClick = 确定按钮, modifier = Modifier
                        .padding(20.dp,5.dp,20.dp,5.dp)
                    ){ Text(确定文本) }
                }
            }

        }
    }
}