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


@Composable
fun HomeScreen(postViewModel: PostViewModel) {
    val posts by postViewModel.posts.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text("Campus Connect", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(posts) { post ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = post.userName, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = post.content)
                        Spacer(modifier = Modifier.height(8.dp))
                        Row {
                            IconButton(onClick = { /* Like logic */ }) {
                                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Like")
                            }
                            Text(text = "${post.likeCount} Likes")
                        }
                    }
                }
            }
        }
    }
}
