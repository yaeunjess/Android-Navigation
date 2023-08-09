package com.example.backstackandbottombar.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.backstackandbottombar.screen.BasketScreen
import com.example.backstackandbottombar.screen.DetailGoodsScreen
import com.example.backstackandbottombar.screen.DetailRecipeScreen
import com.example.backstackandbottombar.screen.FollowingScreen
import com.example.backstackandbottombar.screen.HomeScreen
import com.example.backstackandbottombar.screen.MyScreen
import com.example.backstackandbottombar.screen.SignInScreen
import com.example.backstackandbottombar.screen.SignUpScreen

@Composable
fun MainNavigationGraph(navController: NavHostController, innerNavController: NavHostController){
    NavHost(
        navController = innerNavController,
        startDestination = MainBottomScreen.Home.route,
        route = MAIN
    ){
        /*navigation(route = HOME, startDestination =  HomeInnerScreen.Home.route){
            composable(route = MainScreen.Home.route) {
                HomeScreen(navController=navController, innerNavController= innerNavController)
            }
            composable(route = HomeInnerScreen.DetailGoods.route) {
                DetailGoodsScreen()
            }
            composable(route = HomeInnerScreen.DetailRecipe.route) {
                DetailRecipeScreen()
            }
        }*/
        composable(route = MainBottomScreen.Home.route) {
            HomeScreen(navController = navController, innerNavController=innerNavController)
        }
        composable(route = MainBottomScreen.My.route) {
            MyScreen(navController = navController, innerNavController=innerNavController)
        }
        composable(route = MainBottomScreen.Basket.route){
            BasketScreen()
        }

        composable(route = MainBottomScreen.My_Following.route){
            FollowingScreen()
        }
        composable(route = MainBottomScreen.Home_DetailGoods.route){
            DetailGoodsScreen()
        }
        composable(route = MainBottomScreen.Home_DetailRecipe.route){
            DetailRecipeScreen()
        }
    }
}

/*
sealed class MainScreen(val route: String){
    object Market : MainScreen(route="MARKET")
    object Basket : MainScreen(route="BASKET")
    object Home : MainScreen(route="HOME")
    object Recipes : MainScreen(route="RECIPIS")
    object My : MainScreen(route="MY")
}*/
