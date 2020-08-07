package com.androiddevs.mvvmnewsapp.repository

import android.app.DownloadManager
import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDataBase

/**
 * This class for my news Repository, which will take our database as a parameter,
 * which we will need to access the functions of our data base.
 * This repository will also need to access newsApi, which we can get from our retofit instance class.
 *
 *
 */
class NewsRepository (
    val db : ArticleDataBase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)
}