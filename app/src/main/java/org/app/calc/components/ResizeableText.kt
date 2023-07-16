package org.app.calc.components

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun ResizeableText(
    modifier: Modifier,
    textAlign: TextAlign,
    text: String,
    color: Color = Color.White,
    style: TextStyle,
    maxLines: Int = Int.MAX_VALUE
) {
    var multiplier by remember {
        mutableStateOf(1.0F)
    }

    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = style.fontSize * multiplier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = { textLayoutResult ->
            val lineIndex = textLayoutResult.lineCount - 1

            if  (textLayoutResult.isLineEllipsized(lineIndex)) {
                multiplier *= 0.9f
            }
        }
    )
}