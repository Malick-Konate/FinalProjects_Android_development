package com.example.loginpage.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.loginpage.model.User

//@Dao
//interface UserDAO {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertUser(user: User)
//
//    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
//    suspend fun login(email: String, password: String): User?
//
//    @Query("SELECT * FROM users WHERE email = :email")
//    suspend fun getUserByEmail(email: String): User?
//}
@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //
    suspend fun insertUser(user: User) //

    @Query("SELECT * FROM users WHERE email = :email AND password = :password") //
    suspend fun login(email: String, password: String): User? //

    @Query("SELECT * FROM users WHERE email = :email") //
    suspend fun getUserByEmail(email: String): User? //
}
