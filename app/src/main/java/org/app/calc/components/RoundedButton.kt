package org.app.calc.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.app.calc.ui.theme.CalcTheme

@Composable
fun RoundedButton(label: String, padding: Int, onClick: () -> Unit = {}) {
    CalcTheme {
        Surface(modifier = Modifier.padding(padding.dp)) {
            Button(
                onClick = onClick,
                shape = CircleShape,
            ) {
                Text(
                    text = label,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .padding(12.dp)
                )
            }
        }
    }
}

@Preview(name = "Light mode")
@Preview(
    name = "Dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun RoundedButtonPreview() {
    RoundedButton("=", 10)
}
