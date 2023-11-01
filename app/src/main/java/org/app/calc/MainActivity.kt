package org.app.calc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.app.calc.components.Prompt
import org.app.calc.components.RoundedButton
import org.app.calc.ui.theme.CalcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val buttonSpacing = 4.dp

        setContent {
            CalcTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter),
                            verticalArrangement = Arrangement.spacedBy(buttonSpacing),
                        ) {
                            Prompt(resultText = "10", prompt = "5 + 5")

                            Spacer(modifier = Modifier.padding(15.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                            ) {
                                RoundedButton(
                                    text = "AC",
                                    modifier = Modifier
                                        .aspectRatio(2f)
                                        .weight(2f)
                                )
                                RoundedButton(
                                    text = "(",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = ")",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "<|",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                            ) {
                                RoundedButton(
                                    text = "7",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "8",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "9",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "x",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                            ) {
                                RoundedButton(
                                    text = "4",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "5",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "6",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "-",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                            ) {
                                RoundedButton(
                                    text = "1",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "2",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "3",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "+",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                            ) {
                                RoundedButton(
                                    text = "0",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = ".",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "=",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "/",
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}
