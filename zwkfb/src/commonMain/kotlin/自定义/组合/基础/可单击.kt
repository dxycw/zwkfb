package 自定义.组合.基础

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput


/**
 * 可单击没有波纹
 * @param 已启用 是否启用，默认启用
 * @param 单击回调 单击回调
 */
@Stable
fun Modifier.可单击没有波纹(
    已启用: Boolean = true,
    单击回调: () -> Unit
): Modifier =
    this.clickable(
        interactionSource = null, // ?: remember { MutableInteractionSource() }
        indication = null,
        enabled = 已启用,
        onClickLabel = null,
        role = null,
        onClick = 单击回调
    )

/**
 * 可单击变灰
 * @param 是否禁用变灰 是否禁用变灰，默认不禁用
 * @param 单击回调 单击回调
 */
@Stable
fun Modifier.可单击变灰(
    是否禁用变灰: Boolean = false,
    单击回调: () -> Unit = {}
): Modifier = composed {
    var 图标变灰 by remember { mutableStateOf(false) }
    this.pointerInput(是否禁用变灰) {
        awaitPointerEventScope {
            while (!是否禁用变灰) {
                val event = awaitPointerEvent()
                when (event.type) {
                    PointerEventType.Press -> 图标变灰 = true // 按下时图标变灰
                    PointerEventType.Release -> 图标变灰 = false // 松开时图标恢复
                }
            }
        }
    }
        .alpha(if (!是否禁用变灰) { if (图标变灰) 0.25f else 1f } else { 1f })
        .clickable(
            interactionSource = null, // ?: remember { MutableInteractionSource() }
            indication = null,
            enabled = !是否禁用变灰,
            onClickLabel = null,
            role = null,
            onClick = 单击回调
        )
}