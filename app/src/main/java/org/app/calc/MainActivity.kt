package org.app.calc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import arith.calculate
import arith.utils.fold
import org.app.calc.components.Prompt
import org.app.calc.components.RoundedButton
import org.app.calc.components.SearchBar
import org.app.calc.components.functions
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

                    var prompt by remember {
                        mutableStateOf("")
                    }

                    var result by remember {
                        mutableStateOf("")
                    }

                    var hadError by remember {
                        mutableStateOf(false)
                    }

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
                            Prompt(
                                resultText = result,
                                prompt = prompt,
                                hadError = hadError
                            )

                            SearchBar(
                                values = functions,
                                onClick = { prompt += "$it(" }
                            )

                            Spacer(modifier = Modifier.padding(15.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                            ) {
                                RoundedButton(
                                    text = "AC",
                                    onClick = {
                                        prompt = ""
                                        result = ""
                                    },
                                    modifier = Modifier
                                        .aspectRatio(2f)
                                        .weight(2f)
                                )
                                RoundedButton(
                                    text = "(",
                                    onClick = {
                                        prompt += "("
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = ")",
                                    onClick = {
                                        prompt += ")"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "\u03C0",
                                    onClick = {
                                        prompt += "pi"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "e",
                                    onClick = {
                                        prompt += "e"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "!",
                                    onClick = {
                                        prompt += "!"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "<|",
                                    onClick = {
                                        if (prompt.isNotEmpty()) {
                                            prompt = prompt.substring(0..<prompt.length - 1)
                                        }
                                    },
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
                                    onClick = {
                                        prompt += "7"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "8",
                                    onClick = {
                                        prompt += "8"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "9",
                                    onClick = {
                                        prompt += "9"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "*",
                                    onClick = {
                                        prompt += "*"
                                    },
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
                                    onClick = {
                                        prompt += "4"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "5",
                                    onClick = {
                                        prompt += "5"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "6",
                                    onClick = {
                                        prompt += "6"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "-",
                                    onClick = {
                                        prompt += "-"
                                    },
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
                                    onClick = {
                                        prompt += "1"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "2",
                                    onClick = {
                                        prompt += "2"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "3",
                                    onClick = {
                                        prompt += "3"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "+",
                                    onClick = {
                                        prompt += "+"
                                    },
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
                                    onClick = {
                                        prompt += "0"
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = ".",
                                    onClick = {
                                        prompt += "."
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "=",
                                    onClick = {
                                        calculate(prompt).fold({
                                            hadError = true
                                            result = it.split(":")[1]
                                            result = result.substring(1..<result.length)
                                        }) {
                                            result = it.toString()
                                            prompt = ""
                                            hadError = false
                                        }
                                    },
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                RoundedButton(
                                    text = "/",
                                    onClick = {
                                        prompt += "/"
                                    },
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
