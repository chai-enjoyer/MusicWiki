package com.example.musicwiki.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.data.Artist
import com.example.musicwiki.network.RetrofitInstance
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _topArtists = MutableLiveData<List<Artist>>()
    val topArtists: LiveData<List<Artist>> get() = _topArtists

    init {
        fetchTopArtists()
    }

    private fun fetchTopArtists() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.searchArtists("top", "artist")
                _topArtists.value = response.artists.items
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}