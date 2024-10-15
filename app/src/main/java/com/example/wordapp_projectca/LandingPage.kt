package com.example.wordapp_projectca

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LandingPage(navController: NavHostController) {
    var inputWord by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = inputWord,
            onValueChange = { inputWord = it },
            label = { Text("Enter a word") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (inputWord.isNotEmpty()) {
                navController.navigate("screen2/${inputWord}")
            }
        }) {
            Text("Go to Screen 2")
        }
    }
}

