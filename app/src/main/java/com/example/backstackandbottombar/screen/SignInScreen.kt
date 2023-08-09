package com.example.backstackandbottombar.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.backstackandbottombar.navgraph.AuthScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    navController : NavHostController
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email by remember {
            mutableStateOf("")
        }

        Text(
            text = "sign in",
            modifier = Modifier
                .clickable {
                    navController.navigate(AuthScreen.SignUp.route.replace("{email}", email))
                }
        )

        TextField(value = email, onValueChange = { email = it })
    }
}