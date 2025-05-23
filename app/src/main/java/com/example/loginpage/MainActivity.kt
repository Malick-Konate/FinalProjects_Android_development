package com.example.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginpage.data.local.PostDatabase
import com.example.loginpage.data.local.UserDatabase
import com.example.loginpage.repository.PostRepository
import com.example.loginpage.repository.UserRepository
import com.example.loginpage.ui.theme.LoginPageTheme
import com.example.loginpage.viewmodel.PostViewModel
import com.example.loginpage.viewmodel.PostViewModelFactory
import com.example.loginpage.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginPageTheme {
                val context = LocalContext.current

                val userViewModel = remember {
                    UserViewModel(
                        UserRepository(UserDatabase.getInstance(context).userDao())
                    )
                }

                val postViewModel = remember {
                    PostViewModel(
                        PostRepository(PostDatabase.getInstance(context).postDao())
                    )
                }

                Scaffold { innerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)) {
                        AppNavigation(userViewModel, postViewModel)
                    }
                }
            }
        }
    }
}

