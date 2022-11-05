package com.dorritos.market.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dorritos.market.databinding.FragmentBannerBinding

class BannerFragment : Fragment() {
    private var _binding: FragmentBannerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBannerBinding.inflate(inflater, container, false)
        return binding.root
    }
}