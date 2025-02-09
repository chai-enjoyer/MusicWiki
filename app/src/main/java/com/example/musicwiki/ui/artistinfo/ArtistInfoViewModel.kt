package com.example.musicwiki.ui.artistinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.data.Artist
import com.example.musicwiki.network.RetrofitInstance
import kotlinx.coroutines.launch

class ArtistInfoViewModel : ViewModel() {
    private val _artist = MutableLiveData<Artist>()
    val artist: LiveData<Artist> get() = _artist

    fun getArtistDetails(artistId: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getArtistDetails(artistId)
                _artist.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}