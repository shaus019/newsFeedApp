package com.androiddevs.mvvmnewsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androiddevs.mvvmnewsapp.models.Article

/**
 * Actual database
 * Database classes for room always need to be abstract.
 * and we need to tell room that this is our database class.
 * with first parameter as list of entities. we only have one entity Article.
 * Also define a version for our database to update our database later on.
 * Companion object to create our actual databse by creating an instance of that article databse,
 * initially set to null. Volatile means other thread can immediately see when it changes
 * lock to make sure there is only single instance at once.
 * invoke function is called whenever we create an instance of database.
 *
 */
@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class ArticleDataBase : RoomDatabase() {
    abstract fun getArticleDao() : ArticleDao

    companion object {
        @Volatile
        private var instance: ArticleDataBase? = null
        private val Lock = Any()

        operator fun invoke (context: Context) = instance ?: synchronized(Lock){
            instance ?: createDatabase(context).also { instance = it}
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDataBase::class.java,
                "article_db.db"
            ).build()
    }
}