package org.app.calc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.app.calc.components.ResizeableText
import org.app.calc.components.RoundedButton
import org.app.calc.ui.theme.CalcTheme


class MainActivity : ComponentActivity() {

    companion object {
        const val ROW_PADDING: Int = 5
        const val COLUMN_PADDING: Int = 5
        const val BUTTON_PADDING: Int = 2

        private fun isOp(char: Char): Boolean = "+-*/%.".find { it == char } != null
        fun addIfNot(cs: String, char: Char): String =
            if (isOp(cs.last())) {
                cs.take(
                    if (cs.length == 1) {
                        1
                    } else {
                        cs.length - 1
                    }
                ) + char
            } else {
                cs + char
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var expr by remember { mutableStateOf("") }
            var isInNumber by remember { mutableStateOf(true) }
            var addedDot by remember {
                mutableStateOf(false)
            }

            CalcTheme {
                Column {
                    ResizeableText(
                        text = expr,
                        style = MaterialTheme.typography.displayLarge,
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 1,
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                            .padding(start = 25.dp, end = 25.dp, top = 50.dp, bottom = 25.dp)
                            .width(200.dp)
                            .height(100.dp)
                    )

                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                            .fillMaxWidth()
                            .background(color = MaterialTheme.colorScheme.background)
                    )

                    Surface(modifier = Modifier.fillMaxSize()) {
                        Column(modifier = Modifier.padding(COLUMN_PADDING.dp)) {
                            Row(modifier = Modifier.padding(ROW_PADDING.dp)) {
                                RoundedButton(label = "AC", BUTTON_PADDING) { expr = "" }
                                RoundedButton(
                                    label = "%",
                                    BUTTON_PADDING
                                ) {
                                    expr = addIfNot(expr, '%')
                                    isInNumber = false
                                    addedDot = false
                                }
                                RoundedButton(
                                    label = "/", BUTTON_PADDING
                                ) {
                                    expr = addIfNot(expr, '/')
                                    isInNumber = false
                                    addedDot = false
                                }
                            }

                            Row(modifier = Modifier.padding(ROW_PADDING.dp)) {
                                RoundedButton(
                                    label = "1",
                                    BUTTON_PADDING + 2
                                ) {
                                    expr += "1"
                                    isInNumber = true
                                }
                                RoundedButton(label = "2", BUTTON_PADDING + 2) {
                                    expr += "2"
                                    isInNumber = true
                                }
                                RoundedButton(label = "3", BUTTON_PADDING + 2) {
                                    expr += "3"
                                    isInNumber = true
                                }
                                RoundedButton(
                                    label = "+", BUTTON_PADDING + 2
                                ) {
                                    expr =
                                        addIfNot(expr, '+')

                                    isInNumber = false
                                    addedDot = false
                                }
                            }

                            Row(modifier = Modifier.padding(ROW_PADDING.dp)) {
                                RoundedButton(label = "4", BUTTON_PADDING + 2) {
                                    expr += "4"

                                    isInNumber = true
                                }
                                RoundedButton(label = "5", BUTTON_PADDING + 2) {
                                    expr += "5"
                                    isInNumber = true
                                }
                                RoundedButton(label = "6", BUTTON_PADDING + 2) {
                                    expr += "6"
                                    isInNumber = true
                                }
                                RoundedButton(
                                    label = "-", BUTTON_PADDING + 2
                                ) {
                                    expr =
                                        addIfNot(expr, '-')

                                    isInNumber = false
                                    addedDot = false
                                }
                            }

                            Row(modifier = Modifier.padding(ROW_PADDING.dp)) {
                                RoundedButton(label = "7", BUTTON_PADDING + 2) {
                                    expr += "7"
                                    isInNumber = true
                                }
                                RoundedButton(label = "8", BUTTON_PADDING + 2) {
                                    expr += "8"
                                    isInNumber = true
                                }
                                RoundedButton(label = "9", BUTTON_PADDING + 2) {
                                    expr += "9"
                                    isInNumber = true
                                }
                                RoundedButton(
                                    label = "*", BUTTON_PADDING + 2
                                ) {

                                    expr =
                                        addIfNot(expr, '*')

                                    isInNumber = false

                                    addedDot = false
                                }
                            }

                            Row(modifier = Modifier.padding(ROW_PADDING.dp)) {
                                RoundedButton(label = "0", BUTTON_PADDING + 2) {
                                    expr += "0"
                                    isInNumber = true
                                }
                                RoundedButton(
                                    label = ".", BUTTON_PADDING + 2
                                ) {
                                    if (isInNumber && !addedDot) {
                                        expr =
                                            addIfNot(expr, '.')

                                        addedDot = true
                                    }
                                }
                                RoundedButton(label = "<=", BUTTON_PADDING + 2) {
                                    if (expr.isNotEmpty()) {
                                        expr = expr.take(expr.length - 1)
                                    }
                                }
                                RoundedButton(label = "=", BUTTON_PADDING + 2)
                            }
                        }
                    }
                }

            }
        }
    }
}