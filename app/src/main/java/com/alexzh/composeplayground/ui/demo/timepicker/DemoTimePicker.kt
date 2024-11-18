package com.alexzh.composeplayground.ui.demo.timepicker

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview(device = Devices.NEXUS_7)
@Composable
fun Demo_TimePicker_HorizontalLayout() {
    val timePickerState = rememberTimePickerState()

    TimePicker(
        state = timePickerState,
        layoutType = TimePickerLayoutType.Horizontal
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(device = Devices.NEXUS_7)
@Composable
fun Demo_TimePicker_VerticalLayout() {
    val timePickerState = rememberTimePickerState()

    TimePicker(
        state = timePickerState,
        layoutType = TimePickerLayoutType.Vertical
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Demo_TimePicker() {
    val timePickerState = rememberTimePickerState()

    TimePicker(
        state = timePickerState,
        layoutType = TimePickerLayoutType.Vertical
    )
}