package com.androiddevs.mvvmnewsapp.ui

import androidx.lifecycle.ViewModel
import com.androiddevs.mvvmnewsapp.repository.NewsRepository

/**
 * This class is our viewModel class, which will take newsRepository as parameter in its constructor
 *  and which will inherit from ViewModel.
 */
class NewsViewModel (
    val newsRepository : NewsRepository
) : ViewModel() {
}