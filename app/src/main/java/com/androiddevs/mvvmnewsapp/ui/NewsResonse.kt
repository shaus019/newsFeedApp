package com.androiddevs.mvvmnewsapp.ui

data class NewsResonse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)