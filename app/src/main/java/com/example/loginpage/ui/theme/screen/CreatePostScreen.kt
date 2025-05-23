package com.example.loginpage.ui.theme.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginpage.model.Post
import com.example.loginpage.viewmodel.PostViewModel
import kotlinx.coroutines.launch
import java.util.*

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CreatePostScreen(
//    navController: NavController,
//    postViewModel: PostViewModel,
//    userId: Int,
//    userName: String
//) {
//    var content by remember { mutableStateOf("") }
//    val context = LocalContext.current
//    val scope = rememberCoroutineScope()
//
//    Scaffold(
//        topBar = {
//            TopAppBar(title = { Text("New Post") })
//        }
//    ) { padding ->
//        Column(
//            modifier = Modifier
//                .padding(padding)
//                .padding(24.dp)
//                .fillMaxSize(),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            OutlinedTextField(
//                value = content,
//                onValueChange = { content = it },
//                label = { Text("What's on your mind?") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(150.dp),
//                singleLine = false,
//                maxLines = 6
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Button(onClick = {
//                if (content.isNotBlank()) {
//                    val post = Post(
//                        userId = userId,
//                        userName = userName,
//                        content = content.trim(),
//                        timestamp = System.currentTimeMillis()
//                    )
//                    scope.launch {
//                        postViewModel.createPost(post)
//                        Toast.makeText(context, "Post shared!", Toast.LENGTH_SHORT).show()
//                        navController.popBackStack() // go back to previous screen
//                    }
//                } else {
//                    Toast.makeText(context, "Post cannot be empty", Toast.LENGTH_SHORT).show()
//                }
//            }) {
//                Text("Share")
//            }
//        }
//    }
//}


@Composable
fun CreatePostScreen(
    navController: NavController,
    postViewModel: PostViewModel,
    userId: Int,
    userName: String
) {
    var content by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Create Post", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("What's on your mind?") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                    postViewModel.createPost(
                        Post(
                            userId = userId,
                            userName = userName,
                            content = content,
                            timestamp = System.currentTimeMillis()
                        )
                    )
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Post")
        }
    }
}
