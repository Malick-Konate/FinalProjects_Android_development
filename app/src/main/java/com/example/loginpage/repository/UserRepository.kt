package com.example.loginpage.repository

import com.example.loginpage.data.local.UserDAO
import com.example.loginpage.model.User

class UserRepository(private val userDao: UserDAO) {

//    suspend fun registerUser(user: User) {
//        userDao.insertUser(user)
//    }
//
//    suspend fun loginUser(email: String, password: String): User? {
//        return userDao.login(email, password)
//    }
//
//    suspend fun checkUserExists(email: String): Boolean {
//        return userDao.getUserByEmail(email) != null
//    }


    suspend fun registerUser(user: User) {
        userDao.insertUser(user) //
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.login(email, password) //
    }

    suspend fun checkUserExists(email: String): Boolean {
        return userDao.getUserByEmail(email) != null //
    }
}
