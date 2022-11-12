package com.dorritos.market.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dorritos.market.databinding.FragmentHomeBinding
import com.dorritos.market.ui.adapters.BannerAdapter
import com.dorritos.market.ui.viewmodels.BannerViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter: BannerAdapter by lazy { BannerAdapter(lifecycleScope) }
    private val bannerViewModel: BannerViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = binding.recyclerViewBanners
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
        bannerViewModel.getPhones()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}