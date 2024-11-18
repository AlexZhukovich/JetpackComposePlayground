package com.alexzh.composeplayground.ui.demo.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Demo_SingleChoiceSegmentedButtonRow() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val buttons = listOf("Daily", "Weekly", "Monthly", "Yearly")
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        SingleChoiceSegmentedButtonRow {
            buttons.forEachIndexed { index, label ->
                SegmentedButton(
                    selected = index == selectedIndex,
                    onClick = { selectedIndex = index },
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = buttons.size)
                ) {
                    Text(text = label)
                }
            }
        }
    }
}

@Preview
@Composable
fun Demo_MultiChoiceSegmentedButtonRow() {
    val checkedList = remember { mutableStateListOf<Int>() }
    val buttons = listOf("Career", "Review", "Goals", "Projects")
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        MultiChoiceSegmentedButtonRow {
            buttons.forEachIndexed { index, label ->
                SegmentedButton(
                    checked = index in checkedList,
                    onCheckedChange = {
                        if (index in checkedList) {
                            checkedList.remove(index)
                        } else {
                            checkedList.add(index)
                        }
                    },
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = buttons.size)
                ) {
                    Text(text = label)
                }
            }
        }
    }
}