package com.alexzh.composeplayground.ui.demo.gradient

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Demo_GradientBackground() {
    val colors = listOf(Color(0xFFC3ED7E), Color(0xFF84DFF3))

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        BoxWithContainer(
            modifier = Modifier.background(Brush.linearGradient(colors)),
        ) { Text("Linear Gradient", fontSize = 20.sp) }

        BoxWithContainer(
            modifier = Modifier.background(Brush.horizontalGradient(colors))
        ) { Text("Horizontal Gradient", fontSize = 20.sp) }

        BoxWithContainer(
            modifier = Modifier.background(Brush.radialGradient(colors))
        ) { Text("Radial Gradient", fontSize = 20.sp) }

        BoxWithContainer(
            modifier = Modifier.background(Brush.sweepGradient(colors))
        ) { Text("Sweep Gradient", fontSize = 20.sp) }

        BoxWithContainer(
            modifier = Modifier.background(Brush.verticalGradient(colors))
        ) { Text("Vertical Gradient", fontSize = 20.sp) }
    }
}

@Composable
fun BoxWithContainer(modifier: Modifier, content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth().height(150.dp)
            .clip(RoundedCornerShape(percent = 5))
            .then(modifier),
        contentAlignment = Alignment.Center,
        content = content
    )
}