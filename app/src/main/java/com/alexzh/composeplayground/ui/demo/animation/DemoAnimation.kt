package com.alexzh.composeplayground.ui.demo.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Demo_VisibilityAnimation() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var isVisible by remember { mutableStateOf(false) }

        Button(
            onClick = {
                isVisible = !isVisible
            }
        ) {
            Text(text = "Toggle")
        }

        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally() + fadeIn(),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(modifier = Modifier.background(Color.Red))
        }
    }
}

@Preview
@Composable
fun Demo_CornerRadiusChangesAnimation() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var isRound by remember { mutableStateOf(false) }

        Button(
            onClick = {
                isRound = !isRound
            }
        ) {
            Text(text = "Toggle")
        }

        val borderRadius by animateIntAsState(
            targetValue = if (isRound) 40 else 20,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy,
                stiffness = Spring.StiffnessLow
            )
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(borderRadius))
                .background(Color.Red)
        )
    }
}

@Preview
@Composable
fun Demo_CornerRadiusChangesAndColorAnimation() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var isRound by remember { mutableStateOf(false) }

        Button(
            onClick = {
                isRound = !isRound
            }
        ) {
            Text(text = "Toggle")
        }

        val transition = updateTransition(
            targetState = isRound,
            label = null
        )

        val borderRadius by transition.animateInt(
            transitionSpec = { tween(2_000) },
            label = "borderRadius",
            targetValueByState = {
                if (it) 100 else 0
            }
        )
        val color by transition.animateColor(
            transitionSpec = { tween(1_000) },
            label = "color",
            targetValueByState = {
                if (it) Color.Green else Color.Red
            }
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(borderRadius))
                .background(color)
        )
    }
}

@Preview
@Composable
fun Demo_infiniteAnimation() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var isRound by remember { mutableStateOf(false) }

        Button(
            onClick = {
                isRound = !isRound
            }
        ) {
            Text(text = "Toggle")
        }

        val transition = rememberInfiniteTransition()
        val color by transition.animateColor(
            initialValue = Color.Red,
            targetValue = Color.Green,
            animationSpec = infiniteRepeatable(
                animation = tween(2_000),
                repeatMode = RepeatMode.Reverse
            )
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color)
        )
    }
}

@Preview
@Composable
fun Demo_ContentChangesAnimation() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var isVisible by remember { mutableStateOf(false) }

        Button(
            onClick = {
                isVisible = !isVisible
            }
        ) {
            Text(text = "Toggle")
        }

        AnimatedContent(
            targetState = isVisible,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            content = {
                if (it) {
                    Box(modifier = Modifier.background(Color.Green))
                } else {
                    Box(modifier = Modifier.background(Color.Red))
                }
            },
            transitionSpec = {
                slideInHorizontally(
                    initialOffsetX = {
                        if (isVisible) it else -it
                    }
                ) togetherWith slideOutHorizontally(
                    targetOffsetX = {
                        if (isVisible) -it else it
                    }
                )
            }
        )
    }
}
