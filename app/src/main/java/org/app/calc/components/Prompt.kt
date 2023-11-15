package org.app.calc.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.app.calc.ui.theme.CalcTheme

@Composable
fun Prompt(resultText: String, prompt: String, hadError: Boolean) {
    Column(
        modifier = Modifier
            .padding(20.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = resultText,
            color = if (hadError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
            style = if (hadError) MaterialTheme.typography.displaySmall else MaterialTheme.typography.displayLarge,
            maxLines = 1
        )
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .clip(CircleShape)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
        )
        Text(
            text = prompt, color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.displaySmall,
            maxLines = 1
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
fun PreviewPrompt() {
    CalcTheme {
        Surface {
            Prompt("10", "5 + 5", false)
        }
    }
}
