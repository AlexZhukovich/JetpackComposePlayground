package com.alexzh.composeplayground.ui.demo.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexzh.composeplayground.ui.theme.PlaygroundTheme

@OptIn(ExperimentalLayoutApi::class)
@Preview(widthDp = 380, showBackground = true)
@Composable
fun DemoFlowRowLayout() {
    val items = listOf("Item 1", "Item 1.0.1", "Item 2", "Item 3", "Item 3.0.1", "Item 4", "Item 5")
    PlaygroundTheme {
        Column {
            FlowRow(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                items.forEach {
                    AssistChip(
                        onClick = {  },
                        label = { Text(text = it) }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(widthDp = 380, showBackground = true)
@Composable
fun DemoFlowColumnLayout() {
    val items = listOf("Item 1", "Item 1.0.1", "Item 2", "Item 3", "Item 3.0.1", "Item 4", "Item 5")
    PlaygroundTheme {
        Column {
            FlowColumn(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                maxItemsInEachColumn = 3,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items.forEach {
                    AssistChip(
                        onClick = {  },
                        label = { Text(text = it) }
                    )
                }
            }
        }
    }
}