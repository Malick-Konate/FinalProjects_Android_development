package com.example.loginpage.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items


@Composable
fun FollowScreen(followingList: List<String>, onFollowClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text("Follow Users", style = MaterialTheme.typography.headlineMedium)

        LazyColumn {
            items(followingList) { userName ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(userName, modifier = Modifier.weight(1f))
                    Button(onClick = { onFollowClick(userName) }) {
                        Text("Follow")
                    }
                }
            }
        }
    }
}
