package com.androiddevs.mvvmnewsapp.util


/**
 * Generic Class to wrapp around newtwork responses. Useful for susscessful and error response,
 * and also help us to handle the loading state (to show a progress bar when a response in processing)
 * and when the loading is finished and we get a response we can use this class to tell us whether that
 * response was successful or unsuccessful(an error) and handle it.
 *
 * This class will be a sealed class (kinda abstract class but we can define which classes can inherit from it).
 * take a nullable data(response body) as parameter in its constructor
 * a property for message which can be an error incase of unsuccessful response.
 *
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
){
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}