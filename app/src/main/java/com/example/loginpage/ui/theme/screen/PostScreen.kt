package com.example.loginpage.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loginpage.viewmodel.PostViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PostScreen(
//    postViewModel: PostViewModel,
//    navController: NavController,
//    onPostCreated: () -> Unit
//) {
//    val posts by postViewModel.posts.collectAsState()
//    val coroutineScope = rememberCoroutineScope()
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Campus Feed") },
//                actions = {
//                    IconButton(onClick = { onPostCreated() }) {
//                        Icon(Icons.Default.Add, contentDescription = "Create Post")
//                    }
//                }
//            )
//        }
//    ) { padding ->
//        LazyColumn(
//            contentPadding = padding,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            items(posts) { post ->
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp)
//                ) {
//                    Column(modifier = Modifier.padding(16.dp)) {
//                        Text(text = post.userName, style = MaterialTheme.typography.titleMedium)
//                        Spacer(modifier = Modifier.height(4.dp))
//                        Text(text = post.content)
//                        Spacer(modifier = Modifier.height(8.dp))
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            IconButton(onClick = {
//                                coroutineScope.launch {
//                                    postViewModel.likePost(post.id)
//                                }
//                            }) {
//                                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Like")
//                            }
//                            Text("${post.likeCount} likes")
//                        }
//                    }
//                }
//            }
//        }
//    }
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostScreen(
    postViewModel: PostViewModel,
    navController: NavController,
    onPostCreated: () -> Unit
) {
    val posts by postViewModel.posts.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Campus Feed") },
                actions = {
                    IconButton(onClick = onPostCreated) {
                        Icon(Icons.Default.Add, contentDescription = "New Post")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(posts) { post ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(post.userName, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(post.content)
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = {
                                coroutineScope.launch { postViewModel.likePost(post.id) }
                            }) {
                                Icon(Icons.Default.Favorite, contentDescription = "Like")
                            }
                            Text("${post.likeCount} likes")
                        }
                    }
                }
            }
        }
    }
}
