package com.example.backstackandbottombar.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.backstackandbottombar.component.AppBarDefault
import com.example.backstackandbottombar.navgraph.MainBottomScreen
import com.example.backstackandbottombar.navgraph.MainNavigationGraph

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {

    // inner nav controller needed
    // https://stackoverflow.com/questions/69738397/jetpackcompose-navigation-nested-graphs-cause-viewmodelstore-should-be-set-befo
    val mainNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController = mainNavController)
        },
        topBar = {
            AppBarDefault(
                text = "집다방",
                onClick = {
                    //navController.navigate(SharedScreen.Search.passQuery("커피"))
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier.padding(it)
        ){
            MainNavigationGraph(navController = navController, innerNavController = mainNavController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val bottoms = listOf<MainBottomScreen>(
        MainBottomScreen.Home,
        MainBottomScreen.My,
        MainBottomScreen.Basket,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    //Log.e("entry",navBackStackEntry.value?.destination?.route.toString())


    BottomNavigation(
        backgroundColor = Color.White,
    ){
        //실제 라우트명
        val currentDestination = navBackStackEntry?.destination
        Log.e("entry", currentDestination?.route.toString())
        //조작
        val currentBackStackEntry = currentDestination?.route?.split("/")?.get(0)
        Log.d("currentBackstackentry", "${currentBackStackEntry}")

        //실제 라우트명 배열
        val backStackEntries = navController.backQueue.toList().map {
            it.destination.route
        }
        Log.d("backstacklist", "$backStackEntries")


        bottoms.forEach{ screen ->
            val selected = currentBackStackEntry == screen.route

            BottomNavigationItem(
                selected = selected,
                onClick = {
                    if (backStackEntries.any{ it!!.startsWith(screen.route) }) {
                        Log.e("backstacklist1","바텀에서선택한거랑 backStackEntries에니가선택한걸로시작한게 일치o")
                        val matchingRoute = backStackEntries.find{ it!!.startsWith(screen.route + "/") } //부분적으로 일치하는거 찾아줌 ex)home/~

                        //이건 [main, home, home/detail]일때 바탐네비게이션 뷰의 home을 눌렀을때 [main, home]으로 변하기 위한 조건문
                        if(currentBackStackEntry == screen.route){ //조작한애(home/detail에서의 home) == 바텀에 있는 애(home)
                            //여기서 [main, home]으로 변경
                            Log.e("backstacklist2","바텀에서선택한거랑 현재route랑 일치o")
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                            }
                        }else{
                            Log.e("backstacklist2","바텀에서선택한거랑 현재route랑 일치x")
                            navController.navigate(matchingRoute ?: screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                            }
                        }

                    } else { // screen.route랑 backstackentries에 일치하는게 없으면
                        Log.e("backstacklist1","바텀에서선택한거랑 backStackEntries에니가선택한걸로시작한게 일치x -> 바텀에서선택한거 추가됨")
                        navController.navigate(screen.route)
                    }

                },
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        if (selected) {
                            screen.activeIcon?.let {
                                Icon(
                                    imageVector = it,
                                    contentDescription = null
                                )
                            }
                            Text(
                                text = screen.title,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        } else {
                            screen.inactiveIcon?.let {
                                Icon(
                                    imageVector = it,
                                    contentDescription = null
                                )
                            }
                            Text(
                                text = screen.title,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                },
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.Black,
            )
        }
    }
}