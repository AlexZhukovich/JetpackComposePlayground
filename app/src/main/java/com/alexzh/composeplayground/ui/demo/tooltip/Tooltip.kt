package com.alexzh.composeplayground.ui.demo.tooltip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Preview
@Composable
fun Demo_TooltipBox() {
    val tooltipState = rememberTooltipState()
    val richTooltipState = rememberTooltipState()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(750.dp)
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedButton(onClick = { }) {
            Text("Button 1")
        }

        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = { PlainTooltip { Text("Demo text") } },
            state = tooltipState
        ) {
            OutlinedButton(onClick = { scope.launch { tooltipState.show() } }) {
                Text("Display tooltip")
            }
        }

        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = {
                RichTooltip(
                    title = { Text(text = "Super Important") },
                    text = { Text(text = "Demo text...") },
                    action = { Text(text = "Demo Action") }
                )
            },
            state = richTooltipState
        ) {
            OutlinedButton(onClick = { scope.launch { richTooltipState.show() } }) {
                Text("Display RichTooltip")
            }
        }
    }
}