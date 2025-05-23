package com.example.loginpage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginpage.model.User
import com.example.loginpage.repository.UserRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _loggedInUser = MutableStateFlow<User?>(null)
    val loggedInUser: StateFlow<User?> = _loggedInUser

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = repository.loginUser(email, password)
            _loggedInUser.value = user
        }
    }

    fun register(fullName: String, email: String, password: String) {
        viewModelScope.launch {
            val user = User(fullName = fullName, email = email, password = password)
            repository.registerUser(user)
        }
    }
}
