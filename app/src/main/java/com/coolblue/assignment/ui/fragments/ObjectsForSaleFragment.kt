package com.coolblue.assignment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.coolblue.assignment.R
import com.coolblue.assignment.databinding.FragmentObjectsForSaleBinding
import com.coolblue.assignment.ui.adapter.ProductsForSaleAdapter
import com.coolblue.assignment.viewmodels.ObjectsForSaleViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ObjectsForSaleFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ObjectsForSaleViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            viewModelFactory
        )[ObjectsForSaleViewModel::class.java]
    }

    private var _binding: FragmentObjectsForSaleBinding? = null
    private val binding get() = _binding!!

    lateinit var adapter: ProductsForSaleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentObjectsForSaleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundleArgs = arguments?.let { ObjectsForSaleFragmentArgs.fromBundle(it) }
        bundleArgs?.let {
            adapter = ProductsForSaleAdapter(
                onSelected = {
                    //Call detail activity
                }
            )
            binding.recyclerView.apply {
                setHasFixedSize(true)
                adapter = this@ObjectsForSaleFragment.adapter
            }
            viewModel.setupObserver()
            viewModel.getObjectsForSale(it.query, it.page)
            setupObservers()
        }
    }

    private fun setupObservers() {
        viewModel.objectsForSaleMutableLiveData.observe(viewLifecycleOwner) {
            binding.loadingApp.isVisible = false
            adapter.updateList(it)
            binding.recyclerView.isVisible = true
        }

        viewModel.errorMutableLiveData.observe(viewLifecycleOwner) {
            binding.loadingApp.isVisible = false
            binding.errorContainer.isVisible = true
            binding.buttonBack.setOnClickListener {
                //requireActivity().OnbacK
            }
        }
    }
}