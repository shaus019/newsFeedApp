package com.androiddevs.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.ui.NewsActivity
import kotlinx.android.synthetic.main.fragment_breaking_news.view.*

/**
 * This fragment class is for breaking news,
 * it inherits Fragment and takes the layout as a constructor paraemeter.
 */
class SearchNewsFragment:Fragment(R.layout.fragment_search_news) {

    lateinit var viewModel : ViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }

}