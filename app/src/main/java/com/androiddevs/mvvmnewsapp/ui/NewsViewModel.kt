package com.androiddevs.mvvmnewsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.models.NewsResponse
import com.androiddevs.mvvmnewsapp.repository.NewsRepository
import com.androiddevs.mvvmnewsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * This class is our viewModel class, which will take newsRepository as parameter in its constructor
 *  and which will inherit from ViewModel.
 */
class NewsViewModel (
    val newsRepository : NewsRepository
) : ViewModel() {

    //create the live data object here.
    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    //variable for breakingNewsPage here so the viewModel does not get destroyed when we rotate it
    val breakingNewsPage = 1

    init {
        getBreakingNews("nz")
    }

    fun getBreakingNews(countryCode:String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}