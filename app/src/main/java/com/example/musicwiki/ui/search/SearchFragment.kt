package com.example.musicwiki.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.databinding.FragmentSearchBinding
import com.example.musicwiki.ui.ArtistAdapter
import com.example.musicwiki.data.Artist

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var artistAdapter: ArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        // Initialize the adapter with an empty list or your data source
        artistAdapter = ArtistAdapter(emptyList())

        // Set up the RecyclerView
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = artistAdapter
        }

        return binding.root
    }
}