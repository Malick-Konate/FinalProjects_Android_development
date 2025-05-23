package com.example.loginpage.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "users")
//data class User(
//    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    val fullName: String,
//    val email: String,
//    val password: String
//)

@Entity(tableName = "users") //
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, //
    val fullName: String, //
    val email: String, //
    val password: String //
)