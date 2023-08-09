package com.example.backstackandbottombar.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.backstackandbottombar.navgraph.AuthScreen
import com.example.backstackandbottombar.navgraph.MAIN

@Composable
fun SignUpScreen(
    navController: NavHostController,
    email : String?,
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "sign up",
            modifier = Modifier
                .clickable {
                    navController.navigate(MAIN) {
                        popUpTo(AuthScreen.SignIn.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
        )

        Text(text = "email : $email")
    }
}