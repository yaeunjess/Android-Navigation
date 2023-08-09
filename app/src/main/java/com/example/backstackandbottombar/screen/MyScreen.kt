package com.example.backstackandbottombar.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.backstackandbottombar.navgraph.MainBottomScreen

@Composable
fun MyScreen(navController: NavHostController, innerNavController: NavHostController){

    Column(){
        Text("my")
        Button(
            onClick={ innerNavController.navigate(MainBottomScreen.My_Following.route)},
            content={ Text("following") }
        )
    }
}