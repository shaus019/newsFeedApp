package com.androiddevs.mvvmnewsapp.repository

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
}