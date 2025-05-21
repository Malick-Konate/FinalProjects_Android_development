package com.example.loginpage.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loginpage.model.Post
import com.example.loginpage.viewmodel.PostViewModel
import kotlinx.coroutines.launch

@Composable
fun CreatePostScreen(
    postViewModel: PostViewModel,
    userId: Int,
    userName: String,
    onPostCreated: () -> Unit
) {
    var content by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("What's on your mind?") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(


            onClick = {

                if (content.isNotBlank()) {
                    coroutineScope.launch {
                        try {

                            postViewModel.createPost(
                                Post(
                                    userId = userId,
                                    userName = userName,
                                    content = content,
                                    timestamp = System.currentTimeMillis()
                                )
                            )
                            content = ""
                            onPostCreated()
                        } catch (e: Exception) {


                        }
                    }
                } else {
                    // Show a message to the user (e.g., Toast) if content is blank
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Post")
        }
    }
}