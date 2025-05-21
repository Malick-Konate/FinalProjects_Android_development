package com.example.loginpage.ui.theme.screen
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
import com.example.loginpage.model.Post
import androidx.compose.foundation.lazy.items


@Composable
fun ProfileScreen(userName: String, bio: String, posts: List<Post>) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text("Profile", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Name: $userName")
        Text(text = "Bio: $bio")

        Spacer(modifier = Modifier.height(24.dp))

        Text("Your Posts:", style = MaterialTheme.typography.titleMedium)

        LazyColumn {
            items(posts) { post ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(post.content)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("${post.likeCount} likes")
                    }
                }
            }
        }
    }
}
