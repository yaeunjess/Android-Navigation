package com.example.backstackandbottombar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.backstackandbottombar.navgraph.RootNavigationGraph
import com.example.backstackandbottombar.ui.theme.BackStackAndBottomBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackStackAndBottomBarTheme {
                val outNavController = rememberNavController()
                RootNavigationGraph(navController = outNavController)
            }
        }
    }
}
