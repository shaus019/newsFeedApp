package com.androiddevs.mvvmnewsapp.ui

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * entity will tell android studio that article class is a table in our database.
 * inside there we will need to give our table a name and the pirimary key to uniquely identify articles.
 * The primary key will be generated automatically and nullable.
 */
@Entity(
    tableName = "articles"

)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: Any,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)