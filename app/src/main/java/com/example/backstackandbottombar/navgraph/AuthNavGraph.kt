package com.example.backstackandbottombar.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.backstackandbottombar.screen.SignInScreen
import com.example.backstackandbottombar.screen.SignUpScreen

/*fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(
        route = AUTH,
        startDestination = AuthScreen.SignIn.route
    ){
        composable(route = AuthScreen.SignIn.route){
            SignInScreen(navController)
        }
        composable(route = AuthScreen.SignUp.route){
            SignUpScreen(navController, it.arguments?.getString("email"))
        }
    }
}*/

