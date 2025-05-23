package com.example.loginpage.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.loginpage.model.Post
import com.example.loginpage.model.User

@Database(entities = [User::class, Post::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO //
    abstract fun postDao(): PostDao //

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "campus_database" //
                ).fallbackToDestructiveMigration() //
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}