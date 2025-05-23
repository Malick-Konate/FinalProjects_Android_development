package com.example.loginpage.repository

import com.example.loginpage.data.local.PostDao
import com.example.loginpage.model.Post

class PostRepository(private val postDao: PostDao) {
//    suspend fun createPost(post: Post) {
//        postDao.insertPost(post)
//    }
//
//    suspend fun getAllPosts(): List<Post> {
//        return postDao.getAllPosts()
//    }
//
//    suspend fun likePost(postId: Int) {
//        postDao.likePost(postId)
//    }

    suspend fun createPost(post: Post) {
        postDao.insertPost(post) //
    }

    suspend fun getAllPosts(): List<Post> {
        return postDao.getAllPosts() //
    }

    suspend fun likePost(postId: Int) {
        postDao.likePost(postId) //
    }
    suspend fun getPostsByUserId(userId: Int): List<Post> {
        return postDao.getPostsByUser(userId)
    }
}
