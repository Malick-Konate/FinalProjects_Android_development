package com.example.loginpage.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginpage.model.Post
import com.example.loginpage.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PostViewModel(private val repository: PostRepository) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    suspend fun createPost(post: Post) {
        repository.createPost(post)
        refreshPosts()
    }

    suspend fun likePost(postId: Int) {
        repository.likePost(postId)
        refreshPosts()
    }

    suspend fun refreshPosts() {
        _posts.value = repository.getAllPosts()
    }
}
