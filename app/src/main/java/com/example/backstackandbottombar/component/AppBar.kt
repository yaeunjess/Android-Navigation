package com.example.backstackandbottombar.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarDefault(
    text: String,
    onClick: () -> Unit
) {
    TopAppBar(title = {
        Text(
            text = text,
            modifier = Modifier
                .clickable {
                    onClick()
                }
        )
    })
}