package com.alexzh.composeplayground.ui.demo.preview

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alexzh.composeplayground.R
import com.alexzh.composeplayground.ui.theme.PlaygroundTheme

@Preview(fontScale = 0.85f)
@Preview(fontScale = 1.0f)
@Preview(fontScale = 1.15f)
annotation class FontScalePreviews

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
annotation class ColorSchemePreviews

@FontScalePreviews
@Composable
fun Preview_CoffeeDrinkItem_FontScales() {
    PlaygroundTheme {
        CoffeeDrinkItem(
            title = "Espresso",
            ingredients = "Ground coffee, Water",
            icon = R.drawable.espresso_small
        )
    }
}

@ColorSchemePreviews
@Composable
fun Preview_CoffeeDrinkItem_ColorSchemes() {
    PlaygroundTheme {
        CoffeeDrinkItem(
            title = "Espresso",
            ingredients = "Ground coffee, Water",
            icon = R.drawable.espresso_small
        )
    }
}