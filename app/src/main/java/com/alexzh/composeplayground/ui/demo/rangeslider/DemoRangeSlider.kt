package com.alexzh.composeplayground.ui.demo.rangeslider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun DemoSlider() {
    var sliderValue by remember { mutableFloatStateOf(0.7f) }

    Column(
        modifier = Modifier.fillMaxWidth().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it }
        )
        Text("$sliderValue", color = MaterialTheme.colorScheme.onPrimary)
    }
}

@Preview
@Composable
fun DemoStepSlider() {
    var sliderValue by remember { mutableFloatStateOf(4f) }

    Column(
        modifier = Modifier.fillMaxWidth().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            steps = 10,
            valueRange = 0f..10f
        )
        Text("$sliderValue", color = MaterialTheme.colorScheme.onPrimary)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DemoRangeSlider() {
    val sliderState = remember {
        RangeSliderState(
            activeRangeStart = 3f,
            activeRangeEnd = 8f,
            valueRange = 1f..10f,
            steps = 10
        )
    }
    Column(
        modifier = Modifier.fillMaxWidth().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RangeSlider(state = sliderState)
        Text("${sliderState.activeRangeStart}..${sliderState.activeRangeEnd}", color = MaterialTheme.colorScheme.onPrimary)
    }
}