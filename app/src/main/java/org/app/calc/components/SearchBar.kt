package org.app.calc.components

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.app.calc.R
import org.app.calc.ui.theme.CalcTheme

val functions =
    listOf(
        "abs",
        "acos",
        "acot",
        "acsc",
        "asec",
        "asin",
        "atan",
        "ceil",
        "cos",
        "cosh",
        "cot",
        "csc",
        "exp",
        "exp2",
        "ln",
        "log",
        "rad",
        "round",
        "sec",
        "sin",
        "sinh",
        "sqrt",
        "tan",
        "tanh",
        "deg",
        "floor",
        "nroot",
    )

@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(values: List<String>, onClick: (String) -> Unit = {}) {
    var searching by remember {
        mutableStateOf(false)
    }
    var resultCount by remember {
        mutableStateOf(0)
    }

    val results by remember {
        mutableStateOf(mutableListOf<String>())
    }

    var textState by remember { mutableStateOf(TextFieldValue()) }

    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxHeight(0.12f)
            .padding(1.dp)
    ) {
        Button(
            onClick = {
                searching = !searching
            },
        ) {
            if (searching) {
                Text(resultCount.toString())
            } else {

                Image(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "Search"
                )
            }
        }

        AnimatedVisibility(!searching) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .fillMaxWidth()
            ) {

                (results.ifEmpty { values }).forEach {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(100.dp))
                            .background(MaterialTheme.colorScheme.inversePrimary)
                    ) {
                        Text(
                            it,
                            modifier = Modifier
                                .padding(horizontal = 15.dp, vertical = 10.dp)
                                .clickable {
                                    onClick(it)
                                },
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }

        AnimatedVisibility(searching) {
            TextField(
                maxLines = 1,
                value = textState,
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                onValueChange = {
                    results.clear()

                    resultCount =
                        if (it.text.isEmpty()) 0 else it.text.let {
                            values.count { elem ->
                                val matched = elem.contains(it)
                                if (matched) {
                                    results.add(elem)
                                }
                                matched
                            }
                        }

                    textState = it
                },
                label = { Text("Search for a function...") }
            )
        }
    }
}

@Preview
@Composable
fun PreviewSearchBar() {
    CalcTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                SearchBar(functions)
            }
        }
    }

}