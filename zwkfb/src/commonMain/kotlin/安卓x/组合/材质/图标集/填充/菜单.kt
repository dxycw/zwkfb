package 安卓x.组合.材质.图标集.填充

import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import 安卓x.组合.材质.图标集.图标集

public val 图标集.填充.菜单: ImageVector             // 定义公共只读属性"菜单"，类型为 ImageVector，属于"图标集.填充"的扩展属性
    get() {                                       // 自定义 getter 访问器
        if (_菜单 != null) {                       // 检查内部缓存变量是否已存在图标实例（不为空表示已构建过）
            return _菜单!!                         // 若已缓存，则直接返回该非空实例，避免重复构建
        }                                         // if 条件判断结束
        _菜单 = materialIcon(name = "填充.菜单") {  // 调用 materialIcon 构建器创建图标，指定名称为 "填充.菜单"，并传入配置 lambda
            materialPath {                        // 在图标构建器内定义矢量路径，使用 Material 默认路径参数
                moveTo(3.0f, 18.0f)        // 将路径画笔移动到绝对坐标 (3.0, 18.0)，即第一条横线的左下角起点
                horizontalLineToRelative(18.0f)  // 从当前点向右绘制水平线，长度 18.0，到达第一条横线右下角
                verticalLineToRelative(-2.0f)    // 从当前点向上绘制垂直线，长度 2.0（负值表示向上），到达第一条横线右上角
                lineTo(3.0f, 16.0f)           // 从当前点绘制直线到绝对坐标 (3.0, 16.0)，即第一条横线左上角
                verticalLineToRelative(2.0f)     // 从当前点向下绘制垂直线，长度 2.0，回到起点，完成第一条横线轮廓
                close()                               // 闭合当前子路径，形成完整的封闭图形（第一条横线）

                moveTo(3.0f, 13.0f)           // 将路径画笔移动到绝对坐标 (3.0, 13.0)，即第二条横线（中间）的左下角起点
                horizontalLineToRelative(18.0f)  // 从当前点向右绘制水平线，长度 18.0，到达第二条横线右下角
                verticalLineToRelative(-2.0f)    // 从当前点向上绘制垂直线，长度 2.0，到达第二条横线右上角
                lineTo(3.0f, 11.0f)           // 从当前点绘制直线到绝对坐标 (3.0, 11.0)，即第二条横线左上角
                verticalLineToRelative(2.0f)     // 从当前点向下绘制垂直线，长度 2.0，回到起点，完成第二条横线轮廓
                close()                               // 闭合当前子路径，形成完整的封闭图形（第二条横线）

                moveTo(3.0f, 6.0f)           // 将路径画笔移动到绝对坐标 (3.0, 6.0)，即第三条横线（最上方）的左上角起点
                verticalLineToRelative(2.0f)    // 从当前点向下绘制垂直线，长度 2.0，到达第三条横线左下角
                horizontalLineToRelative(18.0f) // 从当前点向右绘制水平线，长度 18.0，到达第三条横线右下角
                lineTo(21.0f, 6.0f)         // 从当前点绘制直线到绝对坐标 (21.0, 6.0)，即第三条横线右上角
                lineTo(3.0f, 6.0f)          // 从当前点绘制直线到绝对坐标 (3.0, 6.0)，即第三条横线左上角，回到起点
                close()                             // 闭合当前子路径，形成完整的封闭图形（第三条横线）
            }                                       // materialPath 路径定义 lambda 结束
        }                                           // materialIcon 图标构建 lambda 结束
        return _菜单!!                               // 返回刚刚构建并缓存的图标实例
    }                                               // getter 访问器结束

private var _菜单: ImageVector? = null             // 声明私有可空变量 _菜单，类型为 ImageVector?，初始值为 null，用于延迟缓存图标实例