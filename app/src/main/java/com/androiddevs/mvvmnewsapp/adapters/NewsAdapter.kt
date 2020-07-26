package com.androiddevs.mvvmnewsapp.adapters

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.models.Article
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> (){

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    /***
     * This value is used to update the article when there is any changes made in the article.
     * The first method in this function checks if the two items are the same by checking thier url.
     * Each article has a unique url.
     * Each article has a unique id as well, but the reason we are not using that is that the id is auto generated
     * for articles in our local dat base and we get articles from Api which does not have an id.
     *
     * And the 2nd function just check if the contents of the old item are the same to the new item.
     */
    private val differCallBack = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    /**
     * the property AsyncListDiffer  is a tool used to compare the two lists,
     * and calculate the diffrence.
     */

    val differ = AsyncListDiffer(this, differCallBack)

    /**
     * In this function, we return our article view holder and inflat the layout.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview,
                parent,
                false
            )
        )
    }

    /**
     * next we need return the amount of items we have in our list.
     */

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    /**
     * Here we want to set our views accordingly.
     * First get the current article from our differ list passing an index of position.
     * and then we can holder to view them directly.
     * Glide will load the image from our article tp an image view
     * and then we just have to add a bunch of text viws.
     */
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(ivArticleImage)
            tvSource.text = article.source.name
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt
            onItemClickListener?.let { it (article) }
        }
    }

    /**
     * clickLuisteners which we can click on later no to vist article in the web page.
     */
    private var onItemClickListener : ((Article) -> Unit)? = null

    fun setOnItemClickLisetner(listener: (Article) -> Unit){
        onItemClickListener = listener
    }
}