package com.example.loginpage.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginpage.viewmodel.PostViewModel
import androidx.compose.foundation.lazy.items
import com.example.loginpage.viewmodel.UserViewModel


@Composable
fun HomeScreen(navController: NavController, userViewModel: UserViewModel) {
    val user by userViewModel.loggedInUser.collectAsState()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Welcome, ${user?.fullName ?: "Guest"}!")
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate("feed") }) {
                Text("View Feed")
            }
            Button(onClick = { navController.navigate("profile") }) {
                Text("View Profile")
            }
        }
    }
}
