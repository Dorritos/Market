package com.dorritos.market.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dorritos.market.databinding.FragmentHomeBinding
import com.dorritos.market.ui.adapters.BannerAdapter
import com.dorritos.market.ui.adapters.PhoneAdapter
import com.dorritos.market.ui.viewmodels.PhonesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val bannerAdapter: BannerAdapter by lazy { BannerAdapter(lifecycleScope) }
    private val phoneAdapter: PhoneAdapter by lazy { PhoneAdapter(lifecycleScope) }
    private val viewModel: PhonesViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bannerRecycler = binding.recyclerViewBanners
        bannerRecycler.layoutManager = LinearLayoutManager(requireContext())
        bannerRecycler.adapter = bannerAdapter
        val phoneRecycler = binding.recyclerViewPhones
        phoneRecycler.layoutManager = LinearLayoutManager(requireContext())
        phoneRecycler.adapter = phoneAdapter
        viewModel.getPhones()
    }

    /*private fun applyData() {
        lifecycleScope.launchWhenStarted {
            viewModel.phonesFlow.onEach {
                viewModel.getPhones().let { phoneAdapter.setItems(BestSeller) }
            }
        }
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}