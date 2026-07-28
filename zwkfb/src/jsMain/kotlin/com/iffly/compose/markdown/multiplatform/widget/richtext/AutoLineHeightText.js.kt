package com.iffly.compose.markdown.multiplatform.widget.richtext

import androidx.compose.material3.Text

@androidx.compose.runtime.Composable
actual fun AutoLineHeightText(
    text: androidx.compose.ui.text.AnnotatedString,
    style: androidx.compose.ui.text.TextStyle,
    modifier: androidx.compose.ui.Modifier,
    color: androidx.compose.ui.graphics.Color,
    fontSize: androidx.compose.ui.unit.TextUnit,
    fontStyle: androidx.compose.ui.text.font.FontStyle?,
    fontWeight: androidx.compose.ui.text.font.FontWeight?,
    fontFamily: androidx.compose.ui.text.font.FontFamily?,
    letterSpacing: androidx.compose.ui.unit.TextUnit,
    textDecoration: androidx.compose.ui.text.style.TextDecoration?,
    textAlign: androidx.compose.ui.text.style.TextAlign?,
    lineHeight: androidx.compose.ui.unit.TextUnit,
    overflow: androidx.compose.ui.text.style.TextOverflow,
    softWrap: Boolean,
    maxLines: Int,
    minLines: Int,
    onTextLayout: (androidx.compose.ui.text.TextLayoutResult) -> Unit,
    inlineContent: kotlinx.collections.immutable.ImmutableMap<String, androidx.compose.foundation.text.InlineTextContent>
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        inlineContent = inlineContent,
        onTextLayout = onTextLayout,
        style = style,
    )
}