package com.dxyc.zwkfb



fun formatTime(seconds: Double): String {
    val totalSeconds = seconds.toLong()
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val secs = totalSeconds % 60

    return if (hours > 0) {
        "${pad2(hours)}:${pad2(minutes)}:${pad2(secs)}"
    } else {
        "${pad2(minutes)}:${pad2(secs)}"
    }
}

private fun pad2(value: Long): String = value.toString().padStart(2, '0')