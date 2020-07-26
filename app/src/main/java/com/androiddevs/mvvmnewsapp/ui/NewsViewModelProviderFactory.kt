package com.androiddevs.mvvmnewsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.mvvmnewsapp.repository.NewsRepository

/**
 * By default We cannot use constructor parameter for our own view models, to use that we need this class.
 * This class is define how our view model should be created. It will inherit from ViewModelProvider, and implement create function.
 * create will return an instance of our NewsViewModel and pass newsRepository to it as T means return type  of that function.
 */
class NewsViewModelProviderFactory(
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}