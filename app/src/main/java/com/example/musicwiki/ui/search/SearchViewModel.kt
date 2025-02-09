package com.example.musicwiki.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.data.Artist
import com.example.musicwiki.network.RetrofitInstance
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val _searchResults = MutableLiveData<List<Artist>>()
    val searchResults: LiveData<List<Artist>> get() = _searchResults

    fun searchArtists(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.searchArtists(query, "artist")
                _searchResults.value = response.artists.items
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}