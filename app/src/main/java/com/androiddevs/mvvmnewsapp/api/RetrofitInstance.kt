package com.androiddevs.mvvmnewsapp.api

import com.androiddevs.mvvmnewsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Enable us to make request in everywhere in our code
 */
class RetrofitInstance {
    companion object{
        /***
         * lazy means here that we only initialize this once
         * The logging interceptor For logging responses of retrofit which is very useful for debugging.
         * We can see what requests we are making and what the responses are.
         *
         */
        private val retrofit by lazy{
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(logging).build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        /***
         * get your api instance.
         * return a retrofit and pass the class of our interface.
         * This is the actual api object that we will bea ble to use from every where to make our actual network requests.
         */
        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}