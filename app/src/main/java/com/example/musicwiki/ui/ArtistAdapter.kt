package com.example.musicwiki.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicwiki.R
import com.example.musicwiki.data.Artist

class ArtistAdapter(private val artists: List<Artist>) :
    RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    // ViewHolder class
    inner class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val artistImage: ImageView = itemView.findViewById(R.id.artist_image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_artist, parent, false)
        return ArtistViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val artist = artists[position]
        // Load the artist image using a library like Glide or Coil
        Glide.with(holder.itemView.context)
            .load(artist.imageUrl)
            .into(holder.artistImage)

        val bundle = Bundle()
        bundle.putString("artistId", artist.id)

        // Set click listener for navigation
        holder.itemView.findNavController().navigate(
            R.id.action_homeFragment_to_artistInfoFragment, // Replace with your action ID
            bundle
        )
    }

    override fun getItemCount(): Int = artists.size
}


