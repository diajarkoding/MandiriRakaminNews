package com.example.mandirirakaminnews.data.network

import com.example.mandirirakaminnews.data.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country : String,
        @Query("apiKey") apiKey : String
    ) : NewsResponse
}