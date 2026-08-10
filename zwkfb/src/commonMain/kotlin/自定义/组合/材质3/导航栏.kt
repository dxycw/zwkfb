package 自定义.组合.材质3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier



@Suppress("ComposableNaming")
@Composable
fun 底部导航栏(
    修饰符: Modifier = Modifier,
    水平排列: Arrangement.Horizontal = Arrangement.Center,
    垂直对齐: Alignment.Vertical = Alignment.CenterVertically,
    内容: @Composable RowScope.() -> Unit = {}
) =
    Row(
        modifier = 修饰符.fillMaxWidth().navigationBarsPadding(),
        verticalAlignment = 垂直对齐,
        horizontalArrangement = 水平排列,
        content = 内容
    )


//@SuppressLint("ComposableNaming","ModifierParameter")
//@Preview
//@Composable
//fun 底部导航栏(
//    修饰符: Modifier = Modifier,
//    水平排列: Arrangement.Horizontal = Arrangement.Center,
//    垂直对齐: Alignment.Vertical = Alignment.CenterVertically,
//    导航数据: ArrayList<自定义加载垂直网格数据> = arrayListOf(
//        自定义加载垂直网格数据(图标 = R.drawable.z_zytb, 标题 = "首页"),
//        自定义加载垂直网格数据(图标 = R.drawable.z_zytb, 标题 = "首页"),
//        自定义加载垂直网格数据(图标 = R.drawable.z_zytb, 标题 = "首页"),
//        自定义加载垂直网格数据(图标 = R.drawable.z_zytb, 标题 = "首页"),
//        自定义加载垂直网格数据(图标 = R.drawable.z_zytb, 标题 = "首页"),
//    ),
//    图标大小: Dp = 30.dp, 字体大小: TextUnit = 12.sp, 单击回调: ((序号: Int) -> Unit) = {},
//) = 水平线性布局(修饰符 = 修饰符.填充最大宽度().导航栏内边距(),水平排列 = 水平排列, 垂直对齐 = 垂直对齐){
//        自定义加载垂直网格(网格数据 = 导航数据, 图标大小 = 图标大小, 字体大小 = 字体大小, 单击回调 = 单击回调) }



//@Composable
//fun 底部导航栏(
//    修饰符: Modifier = Modifier,
//    导航数据: ArrayList<自定义加载垂直网格数据> = arrayListOf(
//        自定义加载垂直网格数据(图标 = R.drawable.z_zytb, 标题 = "首页"),
//        自定义加载垂直网格数据(图标 = R.drawable.z_zytb, 标题 = "首页"),
//        自定义加载垂直网格数据(图标 = R.drawable.z_zytb, 标题 = "首页"),
//        自定义加载垂直网格数据(图标 = R.drawable.z_zytb, 标题 = "首页"),
//        自定义加载垂直网格数据(图标 = R.drawable.z_zytb, 标题 = "首页"),
//    ),
//    图标大小: Dp = 30.dp, 字体大小: TextUnit = 12.sp, 单击回调: ((序号: Int) -> Unit) = {},
//) = 自定义加载垂直网格(修饰符 = 修饰符.填充最大宽度().导航栏内边距(),网格数据 = 导航数据, 图标大小 = 图标大小,
//    字体大小 = 字体大小, 单击回调 = 单击回调)