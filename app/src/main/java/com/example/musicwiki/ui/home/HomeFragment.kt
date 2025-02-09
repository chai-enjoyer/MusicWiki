package com.example.musicwiki.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.ui.ArtistAdapter
import com.example.musicwiki.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    var artistAdapter = ArtistAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Initialize the adapter with an empty list or your data source
        artistAdapter = ArtistAdapter(emptyList())

        // Set up the RecyclerView
        binding.recyclerView.adapter = artistAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        return binding.root
    }
}