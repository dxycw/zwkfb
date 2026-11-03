package com.dxyc.zwkfb.组件

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogWindow
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberDialogState

@Composable
fun CloseConfirmDialog(
    onDismiss: () -> Unit,
    onExitApp: () -> Unit,
    title: String = "确认关闭",
    content: String = "您想要如何操作？"
) {
    val state = rememberDialogState(
        position = WindowPosition(Alignment.Center),
        size = DpSize(360.dp, 180.dp)
    )
    DialogWindow(
        onCloseRequest = onDismiss,
        title = title,
        resizable = false,
        state = state
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = content,
                style = MaterialTheme.typography.bodyLarge
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = onDismiss
                ){ Text("取消") }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = onExitApp
                ) { Text("退出") }
            }
        }
    }
}