package com.example.mandirirakaminnews.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mandirirakaminnews.data.Repository
import com.example.mandirirakaminnews.data.response.ArticlesItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: Repository) : ViewModel() {
    private val _newsList = MutableStateFlow<List<ArticlesItem>>(emptyList())
    val newsList : StateFlow<List<ArticlesItem>> get() = _newsList

    init {
        viewModelScope.launch {
            _newsList.value = repository.getNews()
        }
    }
}