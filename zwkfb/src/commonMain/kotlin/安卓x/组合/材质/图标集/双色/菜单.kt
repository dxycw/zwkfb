package 安卓x.组合.材质.图标集.双色

import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector
import 安卓x.组合.材质.图标集.图标集

public val 图标集.双色.菜单: ImageVector
    get() {
        if (_菜单 != null) {
            return _菜单!!
        }
        _菜单 = materialIcon(name = "双色.菜单") {
            materialPath {
                moveTo(3.0f, 18.0f)
                horizontalLineToRelative(18.0f)
                verticalLineToRelative(-2.0f)
                lineTo(3.0f, 16.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(3.0f, 13.0f)
                horizontalLineToRelative(18.0f)
                verticalLineToRelative(-2.0f)
                lineTo(3.0f, 11.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(3.0f, 6.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(18.0f)
                lineTo(21.0f, 6.0f)
                lineTo(3.0f, 6.0f)
                close()
            }
        }
        return _菜单!!
    }

private var _菜单: ImageVector? = null
