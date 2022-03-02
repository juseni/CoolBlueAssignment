package com.coolblue.assignment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.coolblue.assignment.R
import com.coolblue.assignment.databinding.FragmentSearchBinding
import dagger.android.support.DaggerFragment

class SearchFragment : DaggerFragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            buttonSearch.setOnClickListener {
                if (editTextSearch.text.toString().isNotEmpty()) {
                    val directions = SearchFragmentDirections.actionProductsForSale(
                        editTextSearch.text.toString(), 1
                    )
                    findNavController().navigate(directions)
                }
            }
        }
    }
}