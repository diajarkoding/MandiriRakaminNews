package com.example.mandirirakaminnews.data

import com.example.mandirirakaminnews.data.network.APIConfig

object Injection {
    fun provideRepository() : Repository {
        val apiService = APIConfig.getAPIService()
        return Repository.getInstance(apiService)
    }
}