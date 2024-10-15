package com.example.threescreenapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") {
            LandingPage(navController)
        }
        composable("screen2/{word}") { backStackEntry ->
            val word = backStackEntry.arguments?.getString("word")
            Screen2(navController, word ?: "")
        }
        composable("screen3/{word}") { backStackEntry ->
            val word = backStackEntry.arguments?.getString("word")
            Screen3(navController, word ?: "")
        }
    }
}
