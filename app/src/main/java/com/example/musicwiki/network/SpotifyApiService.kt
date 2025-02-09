package com.example.musicwiki.network

import com.example.musicwiki.data.Artist
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyApiService {
    @GET("search")
    suspend fun searchArtists(
        @Query("q") query: String,
        @Query("type") type: String = "artist",
        @Query("limit") limit: Int = 10
    ): ArtistsResponse

    @GET("artists/{id}")
    suspend fun getArtistDetails(@Path("id") artistId: String): Artist
}

data class ArtistsResponse(
    val artists: Artists
)

data class Artists(
    val items: List<Artist>
)