package com.dxyc.zwkfb.组件

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FullscreenExit
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.dxyc.zwkfb.formatTime
import io.github.kdroidfilter.composemediaplayer.VideoPlayerSurface
import io.github.kdroidfilter.composemediaplayer.rememberVideoPlayerState

@Composable
fun 视频播放器() {

    val playerState = rememberVideoPlayerState()

    // 用于驱动界面刷新的状态
    var progress by remember { mutableStateOf(0f) }

    progress = playerState.currentTime.toFloat() / playerState.duration.toFloat()

    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        Box(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            VideoPlayerSurface(
                playerState = playerState,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 进度条
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth().height(8.dp),
        )

        Spacer(modifier = Modifier.height(4.dp))

        // 时间显示文本：00:00/00:00
        Text(
            text = "${formatTime(playerState.currentTime)}/${formatTime(playerState.duration)}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 播放控制按钮（示例）
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = {
                if (playerState.isPlaying) playerState.pause() else playerState.play()
            }) {
                Icon(
                    imageVector = if (playerState.isPlaying)
                        Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = "播放/暂停",
                )
            }
            Button(onClick = { playerState.stop() }) { Text("停止") }
        }

        // 打开视频
        Button(
            onClick = {
                val url = "https://www.w3schools.com/html/movie.mp4"
                playerState.openUri(url)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("打开视频")
        }
    }
}

@Composable
fun 视频播放器Preview() {
    val playerState = rememberVideoPlayerState()
    playerState.openUri("https://www.w3schools.com/html/movie.mp4")
    VideoPlayerSurface(
        playerState = playerState,
        contentScale = ContentScale.Fit,
        modifier = Modifier//.aspectRatio(16f / 9f)
    ) {
        // This overlay will always be visible
        Box(modifier = Modifier.fillMaxSize()) {
            // You can customize the UI based on fullscreen state
            if (playerState.isFullscreen) {
                // Fullscreen UI
                IconButton(
                    onClick = { playerState.toggleFullscreen() },
                    modifier = Modifier.align(Alignment.TopEnd).padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FullscreenExit,
                        contentDescription = "Exit Fullscreen",
                        tint = Color.White
                    )
                }
            } else {
                // Regular UI
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .background(Color.Black.copy(alpha = 0.5f))
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Your custom controls here
                    IconButton(onClick = {
                        if (playerState.isPlaying) playerState.pause() else playerState.play()
                    }) {
                        Icon(
                            imageVector = if (playerState.isPlaying)
                                Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = "播放/暂停",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}
