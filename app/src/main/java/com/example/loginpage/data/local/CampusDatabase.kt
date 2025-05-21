package com.example.loginpage.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.loginpage.model.User
import com.example.loginpage.model.Post


@Database(entities = [User::class, Post::class], version = 1)
abstract class CampusDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun postDao(): PostDao
}
