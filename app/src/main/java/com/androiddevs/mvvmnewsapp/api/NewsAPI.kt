package com.androiddevs.mvvmnewsapp.api

import com.androiddevs.mvvmnewsapp.models.NewsResponse
import com.androiddevs.mvvmnewsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * This interface will be used to define our single request that we can execute from code.
 */
interface NewsAPI {

    /**
     * * First function is used to get all the breaking news from that api.
     * Specify the type of the request and url where you want to get the data from.
     * we are doing a newtwork call function and it should be asynchronously, by using coroutine
     * and that is why we use suspend function.
     * specify which country we want to get the news from set by default to pk.
     * To limit the news we get we one request a page.
     * Include our api key so the newsAPI knows who is making the request.
     * @return response which is of type NewsResponse
     */
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "nz",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String ,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}