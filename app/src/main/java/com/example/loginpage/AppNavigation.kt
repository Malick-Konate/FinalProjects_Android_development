package com.example.loginpage

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.loginpage.ui.screen.LoginScreen
import com.example.loginpage.ui.screen.SignUpScreen
import com.example.loginpage.ui.screen.HomeScreen
import com.example.loginpage.ui.theme.screen.CreatePostScreen
import com.example.loginpage.ui.theme.screen.PostScreen
import com.example.loginpage.viewmodel.PostViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import com.example.loginpage.ui.theme.screen.ProfileScreen
import com.example.loginpage.viewmodel.UserViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import com.example.loginpage.model.Post

//import com.example.loginpage.ui.theme.screen.PostScreen

@Composable
fun AppNavigation(
    userViewModel: UserViewModel,
    postViewModel: PostViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(navController = navController, userViewModel = userViewModel)
        }

        composable("signup") {
            SignUpScreen(navController = navController)
        }

        composable("home") {
            HomeScreen(navController = navController, userViewModel = userViewModel)
        }

        composable("feed") {
            PostScreen(
                postViewModel = postViewModel,
                navController = navController,
                onPostCreated = {
                    val user = userViewModel.loggedInUser.value
                    if (user != null) {
                        navController.navigate("createPost/${user.id}/${user.fullName}")
                    }
                }
            )
        }

        composable(
            "createPost/{userId}/{userName}",
            arguments = listOf(
                navArgument("userId") { type = NavType.IntType },
                navArgument("userName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("userId") ?: -1
            val userName = backStackEntry.arguments?.getString("userName") ?: "Unknown"
            if (userId != -1) {
                CreatePostScreen(
                    navController = navController,
                    postViewModel = postViewModel,
                    userId = userId,
                    userName = userName
                )
            } else {
                Text("Invalid user.")
            }
        }
        composable("profile") {
            val user = userViewModel.loggedInUser.collectAsState().value

            if (user != null) {
                val userPosts by produceState(initialValue = emptyList<Post>()) {
                    value = postViewModel.getPostsByUser(user.id)
                }

                ProfileScreen(
                    user = user,
                    userPosts = userPosts,
                    onLogoutClick = {
                        navController.navigate("login") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
                )
            } else {
                Text("User not logged in.")
            }
        }


//        composable("profile") {
//            val user by userViewModel.loggedInUser.collectAsState()
//            ProfileScreen(
//                userName = user?.fullName ?: "Guest",
//                bio = "Write your bio here!",
//                posts = listOf()
//            )
//
//        }
    }
}
