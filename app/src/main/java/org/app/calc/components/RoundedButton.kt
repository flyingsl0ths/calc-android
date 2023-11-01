package org.app.calc.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.app.calc.ui.theme.CalcTheme

@Composable
fun RoundedButton(text: String, onClick: () -> Unit = {}, modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(MaterialTheme.colorScheme.background)
            .clickable {
                onClick()
            }
            .then(modifier)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
            fontSize = 36.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewRoundedButton() {
    CalcTheme {
        Surface {
            RoundedButton(text = "+", modifier = Modifier.aspectRatio(1.0f))
        }
    }
}
