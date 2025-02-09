package com.example.musicwiki.ui.artistinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.musicwiki.databinding.FragmentArtistInfoBinding

class ArtistInfoFragment : Fragment() {
    private lateinit var binding: FragmentArtistInfoBinding
    private lateinit var viewModel: ArtistInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArtistInfoBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ArtistInfoViewModel::class.java)

        val artistId = arguments?.getString("artistId")
        if (artistId != null) {
            viewModel.getArtistDetails(artistId)
        }

        viewModel.artist.observe(viewLifecycleOwner) { artist ->
            binding.artistName.text = artist.name
            binding.genres.text = artist.genres.joinToString(", ")
            Glide.with(this)
                .load(artist.images.firstOrNull()?.url)
                .into(binding.artistImage)
        }

        return binding.root
    }
}