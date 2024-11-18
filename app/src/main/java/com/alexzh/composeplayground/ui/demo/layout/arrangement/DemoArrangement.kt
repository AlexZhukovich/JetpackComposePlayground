package com.alexzh.composeplayground.ui.demo.layout.arrangement

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Jetpack Compose: Arrangement
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#arrangement
 */
@Preview(name = "arrangements")
@Composable
fun DemoArrangement() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(320.dp)
            .border(border = BorderStroke(1.dp, SolidColor(Color.White)))
    ) {
        Text(
            text = "Test 0",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .border(border = BorderStroke(1.dp, color = Color.White))
                .padding(8.dp)
        )
        Text(
            text = "Test 1",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .border(border = BorderStroke(1.dp, color = Color.White))
                .padding(8.dp)
        )
        Text(
            text = "Test 2",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .border(border = BorderStroke(1.dp, color = Color.White))
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
fun Demo_Arrangement_1() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.Cyan)
        )

        Spacer(modifier = Modifier.height(64.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.Magenta)
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp)
            .height(200.dp)
            .background(Color.Blue)
        )
    }
}

@Preview
@Composable
fun Demo_Arrangement_2() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(64.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Cyan)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Magenta)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Blue)
                .padding(bottom = 64.dp)
        )
    }
}
