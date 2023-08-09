package com.example.backstackandbottombar.navgraph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

const val ROOT = "root"
const val SPLASH = "splash"
const val AUTH = "auth"
const val MAIN = "main"
const val HOME = "home"
const val MY = "my"

sealed class AuthScreen(val route: String){
    object SignIn : AuthScreen(route="signin")
    object SignUp : AuthScreen(route="signup")
}


sealed class MainBottomScreen(
    val route: String,
    val title: String,
    val inactiveIcon: ImageVector?,
    val activeIcon: ImageVector?
) {
    object Home: MainBottomScreen(
        route = "home",
        title = "home",
        inactiveIcon = Icons.Default.Home,
        activeIcon = Icons.Default.Home
    )
    object My: MainBottomScreen(
        route = "my",
        title = "my",
        inactiveIcon = Icons.Default.Settings,
        activeIcon= Icons.Default.Settings
    )
    object Basket: MainBottomScreen(
        route = "basket",
        title = "basket",
        inactiveIcon = Icons.Default.Settings,
        activeIcon= Icons.Default.Settings
    )


    object My_Following : MainBottomScreen(
        route = "my/following",
        title ="my/following",
        inactiveIcon = null,
        activeIcon=null,
    )
    object Home_DetailGoods : MainBottomScreen(
        route = "home/detailgoods",
        title ="home/detailgoods",
        inactiveIcon = null,
        activeIcon=null,
    )
    object Home_DetailRecipe : MainBottomScreen(
        route = "home/detailrecipe",
        title ="home/detailrecipe",
        inactiveIcon = null,
        activeIcon=null,
    )

}