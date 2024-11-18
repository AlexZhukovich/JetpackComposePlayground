package com.alexzh.composeplayground.ui.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.AddToHomeScreen
import androidx.compose.material.icons.automirrored.filled.AirplaneTicket
import androidx.compose.material.icons.automirrored.filled.AltRoute
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AddIcCall
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.AddToHomeScreen
import androidx.compose.material.icons.filled.AirplaneTicket
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Help
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun Demo_Icons() {
    Column(modifier = Modifier.width(220.dp)) {
        Text(text = "Default icons")
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Icon(imageVector = Icons.Default.AirplaneTicket, contentDescription = null)
            Icon(imageVector = Icons.Default.AddToHomeScreen, contentDescription = null)
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            Icon(imageVector = Icons.Default.Help, contentDescription = null)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "AutoMirrored icons - Left to Right")
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Icon(imageVector = Icons.AutoMirrored.Default.AirplaneTicket, contentDescription = null)
                Icon(imageVector = Icons.AutoMirrored.Default.AddToHomeScreen, contentDescription = null)
                Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = null)
                Icon(imageVector = Icons.AutoMirrored.Default.Help, contentDescription = null)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "AutoMirrored icons - Right to Left")
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Icon(imageVector = Icons.AutoMirrored.Default.AirplaneTicket, contentDescription = null)
                Icon(imageVector = Icons.AutoMirrored.Default.AddToHomeScreen, contentDescription = null)
                Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = null)
                Icon(imageVector = Icons.AutoMirrored.Default.Help, contentDescription = null)
            }
        }
    }
}