package com.example.wordapp_projectca



import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Screen3(navController: NavHostController, word: String) {
    val vowelCount = countVowels(word)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Vowels count: $vowelCount")
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = {
                navController.navigate("landing") {
                    popUpTo("landing") { inclusive = true }
                }
            }) {
                Text("Back to Landing Page")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                navController.navigate("screen2/${word}")
            }) {
                Text("Go to Screen 2")
            }
        }
    }
}

// Helper function to count vowels
fun countVowels(word: String): Int {
    return word.count { it.lowercaseChar() in "aeiou" }
}
