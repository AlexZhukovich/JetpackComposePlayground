package com.alexzh.composeplayground.ui.demo.badge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexzh.composeplayground.ui.theme.PlaygroundTheme

val iconWithTextNavigationItems = listOf(
    Pair(Icons.Default.Home, "Home"),
    Pair(Icons.Default.AccountCircle, "Profile"),
    Pair(Icons.Default.Settings, "Settings")
)

@Preview
@Composable
fun Demo_ScaffoldWithBadges() {
    PlaygroundTheme {
        var navigationSelectedItem by remember { mutableIntStateOf(0) }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Home", style = MaterialTheme.typography.titleLarge) },
                    actions = {
                        BadgedBox(
                            badge = {
                                Badge(modifier = Modifier.size(16.dp)) {
                                    Text(text = "9")
                                }
                            }
                        ) {
                            Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar {
                    iconWithTextNavigationItems.forEachIndexed { index, navItem ->
                        NavigationBarItem(
                            selected = navigationSelectedItem == index,
                            onClick = { /*TODO*/ },
                            icon = {
                                if (index == 2) {
                                    BadgedBox(
                                        badge = {
                                            Badge {
                                                Text(text = "NEW")
                                            }
                                        }
                                    ) {
                                        Icon(navItem.first, navItem.second)
                                    }
                                } else {
                                    Icon(navItem.first, navItem.second)
                                }
                            },
                            label = { Text(text = navItem.second) }
                        )
                    }
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

            }
        }
    }
}

@Preview
@Composable
fun Demo_IconWithBadge() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BadgedBox(
            badge = {
                Badge(
                    content = { Text(text = "123") }
                )
            }
        ) {
            Icon(
                modifier = Modifier.size(42.dp),
                imageVector = Icons.Filled.Email,
                contentDescription = "Messages"
            )
        }

        BadgedBox(
            badge = {
                Badge(
                    content = { Text(text = "42") }
                )
            }
        ) {
            Text(text = "Test message")
        }

        BadgedBox(
            badge = {
                Badge(
                    modifier = Modifier
                        .size(20.dp)
                        .padding(0.dp),
                    content = {
                        Icon(Icons.Filled.Notifications, contentDescription = "notifications")
                    },
                    containerColor = Color.Blue
                )
            }
        ) {
            Icon(
                modifier = Modifier.size(42.dp),
                imageVector = Icons.Filled.Email,
                contentDescription = "Messages"
            )
        }
    }
}