package com.example.backstackandbottombar.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.backstackandbottombar.screen.HomeScreen
import com.example.backstackandbottombar.screen.MainScreen
import com.example.backstackandbottombar.screen.MyScreen
import com.example.backstackandbottombar.screen.SignInScreen
import com.example.backstackandbottombar.screen.SignUpScreen
import com.example.backstackandbottombar.screen.SplashScreen


@Composable
fun RootNavigationGraph(navController: NavHostController){
    //NavHost에서는 route명과 screen을 명시해준다.
    NavHost(
        navController = navController,
        startDestination = SPLASH,
        route = ROOT,
    ){
        composable(route = SPLASH){
            SplashScreen(navController)
        }
        navigation(route = AUTH, startDestination = AuthScreen.SignIn.route){
            composable(route = AuthScreen.SignIn.route){
                SignInScreen(navController)
            }
            composable(route = AuthScreen.SignUp.route){
                SignUpScreen(navController, it.arguments?.getString("email"))
            }
        }
        composable(route = MAIN){
            MainScreen(navController = navController)
        }
    }
}

