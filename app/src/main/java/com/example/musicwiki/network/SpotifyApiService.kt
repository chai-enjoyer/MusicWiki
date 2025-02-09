package com.example.musicwiki.network

import android.app.appsearch.SearchResult
import com.example.musicwiki.data.Artist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyApiService {
    @GET("artists/{id}")
    suspend fun getArtist(@Path("id") id: String): Response<Artist>

    @GET("search")
    suspend fun searchArtists(@Query("q") query: String, @Query("type") type: String): Response<SearchResult>
}

data class ArtistsResponse(
    val artists: Artists
)

data class Artists(
    val items: List<Artist>
)