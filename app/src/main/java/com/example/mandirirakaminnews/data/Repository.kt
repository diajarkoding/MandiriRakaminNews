package com.example.mandirirakaminnews.data

import com.example.mandirirakaminnews.BuildConfig
import com.example.mandirirakaminnews.data.network.APIService
import com.example.mandirirakaminnews.data.response.ArticlesItem

class Repository private constructor(
    private val apiService: APIService
){

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(
            apiService: APIService
        ) : Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(apiService)
            }.also { instance = it }
    }

    suspend fun getNews() : List<ArticlesItem> {
        val response = apiService.getNews("us", BuildConfig.API_KEY)
        return response.articles
    }
}