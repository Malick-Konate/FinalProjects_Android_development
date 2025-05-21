package com.example.loginpage.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val userName: String,
    val content: String,
    val timestamp: Long,
    val likeCount: Int = 0
)
