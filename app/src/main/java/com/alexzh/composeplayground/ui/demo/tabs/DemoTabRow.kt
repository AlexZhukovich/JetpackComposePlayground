package com.alexzh.composeplayground.ui.demo.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCard
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TabContent(
    val title: String,
    val icon: ImageVector
)

@Preview
@Composable
fun DemoTabRow() {
    var state by remember { mutableIntStateOf(0) }
    val tabs = listOf(
        TabContent("Tab #1", Icons.Default.FavoriteBorder),
        TabContent("Tab #2", Icons.Default.Verified),
        TabContent("Tab #3", Icons.Default.AddCard),
    )
    Column {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ) {
            Text(
                text = "Demo: Tab",
                modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center
                )
            )
            TabRow(
                selectedTabIndex = state, indicator = @Composable { tabPositions ->
                    if (state < tabPositions.size) {
                        TabRowDefaults.PrimaryIndicator(
                            modifier = Modifier.tabIndicatorOffset(tabPositions[state]),
                            width = tabPositions[state].contentWidth
                        )
                    }
                }) {
                tabs.forEachIndexed { index, tabContent ->
                    Tab(
                        selected = state == index,
                        onClick = { state = index },
                        text = { Text(text = tabContent.title) },
                        icon = { Icon(tabContent.icon, contentDescription = "...") }
                    )
                }
            }
        }


        Spacer(modifier = Modifier.height(50.dp))

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ) {
            Text(
                text = "Demo: LeadingIconTab",
                modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp),
                style = TextStyle(fontSize = 18.sp, color = Color.DarkGray, textAlign = TextAlign.Center)
            )
            TabRow(selectedTabIndex = state, indicator = @Composable { tabPositions ->
                if (state < tabPositions.size) {
                    TabRowDefaults.PrimaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[state]),
                        width = tabPositions[state].contentWidth
                    )
                }
            }) {
                tabs.forEachIndexed { index, tabContent ->
                    LeadingIconTab(
    //                Tab(
                        selected = state == index,
                        onClick = { state = index },
                        text = { Text(text = tabContent.title) },
                        icon = { Icon(tabContent.icon, contentDescription = "...") }
                    )
                }
            }
        }
    }
}