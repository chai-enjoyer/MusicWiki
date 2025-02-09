package com.example.musicwiki.ui.artistinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.data.Artist
import com.example.musicwiki.network.ArtistsResponse
import com.example.musicwiki.network.RetrofitInstance
import kotlinx.coroutines.launch

class ArtistInfoViewModel : ViewModel() {
    private val _artist = MutableLiveData<Artist>()
    val artist: LiveData<Artist> get() = _artist

    fun getArtistDetails(artistId: String) {
        viewModelScope.launch {
            try {
                val response = ArtistsResponse.Artists(artistId)
                if (response.isSuccessful) {
                    // Process the response body
                    val artistDetails = response.body()
                    // Update LiveData or StateFlow with the result
                } else {
                    // Handle API error
                }
            } catch (e: Exception) {
                // Handle network or other exceptions
            }
        }
    }
}