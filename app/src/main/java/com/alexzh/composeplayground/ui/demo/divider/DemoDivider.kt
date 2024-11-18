package com.alexzh.composeplayground.ui.demo.divider

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Demo_Material2Divider() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Item 1", fontSize = 18.sp)
        androidx.compose.material.Divider()
        Text("Item 2", fontSize = 18.sp)
    }
}

@Preview
@Composable
fun Demo_HorizontalDivider() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Item 1", fontSize = 18.sp)
        HorizontalDivider()
        Text("Item 2", fontSize = 18.sp)
    }
}

@Preview
@Composable
fun Demo_VerticalDivider() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .height(IntrinsicSize.Min)
    ) {
        Text("Item 1", fontSize = 18.sp)

        VerticalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = Color.DarkGray
        )

        Text("Item 2", fontSize = 18.sp)
    }
}

@Preview
@Composable
fun Demo_HorizontalDivider_thickness() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        for (thicknessValue in 1..10) {
            HorizontalDivider(
                thickness = thicknessValue.dp
            )
        }
    }
}

@Preview
@Composable
fun Demo_SegmentPathDivider() {
    val pathSegments = listOf("Projects", "Important project", "src")
    Row(
        modifier = Modifier
            .padding(16.dp)
            .height(IntrinsicSize.Min)
    ) {
        pathSegments.forEachIndexed { index, segment ->
            Text(text = segment, fontSize = 20.sp)
            if (index < pathSegments.size - 1) {
                SegmentPathDivider(color = Color.Black)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Demo_FileManager() {
    val pathSegments = listOf("Projects", "Important project", "src")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("File Manager") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(IntrinsicSize.Min)
            ) {
                pathSegments.forEachIndexed { index, segment ->
                    Text(
                        text = segment,
                        fontSize = 20.sp,
                        fontWeight = if (index == pathSegments.size - 1) FontWeight.Bold else FontWeight.Normal
                    )
                    if (index < pathSegments.size - 1) {
                        SegmentPathDivider(color = Color.Black)
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                for (index in 1..10) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            modifier = Modifier.size(32.dp),
                            imageVector = Icons.Default.FolderOpen,
                            contentDescription = null,
                            tint = Color.DarkGray
                        )
                        Text(
                            text = "Folder $index",
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SegmentPathDivider(
    modifier: Modifier = Modifier,
    width: Dp = 20.dp,
    thickness: Dp = DividerDefaults.Thickness,
    color: Color = DividerDefaults.color,
) = Canvas(
    modifier
        .fillMaxHeight()
        .width(width)) {
    drawLine(
        color = color,
        strokeWidth = thickness.toPx(),
        start = Offset(thickness.toPx() / 2 + width.toPx() * 0.25f, size.height),
        end = Offset(thickness.toPx() / 2 + width.toPx() * 0.75f, 0f)
    )
}