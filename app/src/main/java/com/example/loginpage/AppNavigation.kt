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

//import com.example.loginpage.ui.theme.screen.PostScreen

@Composable
fun AppNavigation(postViewModel: PostViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(navController = navController)
        }

        composable("signup") {
            SignUpScreen(navController = navController)
        }

        composable(
            route = "home/{fullName}",
            arguments = listOf(navArgument("fullName") { type = NavType.StringType })
        ) { backStackEntry ->
            val fullName = backStackEntry.arguments?.getString("fullName") ?: "User"
            HomeScreen(postViewModel = postViewModel)
        }

        composable("feed") {
            PostScreen(postViewModel = postViewModel) {
                navController.navigate("createPost")
            }
        }

        composable(

            route = "createPost/{userId}/{userName}",
            arguments = listOf(
                navArgument("userId") { type = NavType.IntType },
                navArgument("userName") { type = NavType.StringType }
            )) { backStackEntry ->
            val userId =
                backStackEntry.arguments?.getInt("userId") ?: -1
            val userName =
                backStackEntry.arguments?.getString("userName") ?: "DefaultUser"
            if (userId != -1 ) {

                CreatePostScreen(
                    postViewModel = postViewModel,
                    userId = userId,
                    userName = userName,
                    onPostCreated = {
                        navController.popBackStack("feed", inclusive = false)
                    }
                )
            } else {


                Text("Error: Could not load user details for posting.")


            }
        }
    }
}
