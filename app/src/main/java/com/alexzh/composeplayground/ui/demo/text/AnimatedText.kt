package com.alexzh.composeplayground.ui.demo.text

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun Demo_MarqueeText() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(120.dp) // Do I need it?
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello World 1! Hello World 2! Hello World 3!",
            fontSize = 24.sp,
            modifier = Modifier.basicMarquee()
        )
    }
}