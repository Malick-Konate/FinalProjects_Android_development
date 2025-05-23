package com.example.loginpage.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.loginpage.model.Post

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // Modified: Added OnConflictStrategy
    suspend fun insertPost(post: Post)

    @Query("SELECT * FROM posts ORDER BY timestamp DESC") //
    suspend fun getAllPosts(): List<Post> //

    @Query("UPDATE posts SET likeCount = likeCount + 1 WHERE id = :postId") //
    suspend fun likePost(postId: Int) //

    @Query("SELECT * FROM posts WHERE userId = :userId")
    suspend fun getPostsByUser(userId: Int): List<Post>
}

//@Dao
//interface PostDao {
//    @Insert
//    suspend fun insertPost(post: Post)
//
//    @Query("SELECT * FROM posts ORDER BY timestamp DESC")
//    suspend fun getAllPosts(): List<Post>
//
//    @Query("UPDATE posts SET likeCount = likeCount + 1 WHERE id = :postId")
//    suspend fun likePost(postId: Int)
//}
