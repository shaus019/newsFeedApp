package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.ui.Article

@Dao
interface ArticleDao {
    /**
     * First function is to insert or update an article.
     * @param determines what happens if the article already exists, in which case we want to replace it.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    /**
     * This function should return all the articles
     * and its not gonna be a suspend function becuase it return live data.
     * which means that whenver an article inside that list changes live data will notify all its observers.
     */
    @Query("SELECt * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    /**
     * function to delete an article.
     */
    @Delete
    suspend fun deleteArticle(article: Article)
}