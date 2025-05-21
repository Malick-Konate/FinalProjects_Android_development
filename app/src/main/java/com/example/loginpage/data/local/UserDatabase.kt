package com.example.loginpage.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.loginpage.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object {
        // Volatile annotation ensures visibility across threads
        @Volatile
        private var INSTANCE: UserDatabase? = null

        // This is the getInstance method the error refers to
        fun getInstance(context: Context): UserDatabase {
            // Return instance if it exists, otherwise create it synchronized
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, // Use application context
                    UserDatabase::class.java,
                    "user_database" // Choose a name for your database file
                )
                    // Add database migrations here if needed using .addMigrations()
                    .build()
                INSTANCE = instance // Assign the created instance
                // Return instance
                instance
            }
        }
    }

}
