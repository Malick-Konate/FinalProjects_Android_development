package com.example.loginpage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginpage.model.User
import com.example.loginpage.repository.UserRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _loginState = MutableStateFlow<User?>(null)
    val loginState: StateFlow<User?> = _loginState

    fun register(fullName: String, email: String, password: String) {
        viewModelScope.launch {
            val newUser = User(fullName = fullName, email = email, password = password)
            repository.registerUser(newUser)
        }
    }

    suspend fun login(email: String, password: String): User? {
        return repository.loginUser(email, password)
    }

    suspend fun checkUserExists(email: String): Boolean {
        return repository.checkUserExists(email)
    }
}
