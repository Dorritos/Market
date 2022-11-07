package com.dorritos.market.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dorritos.market.remote.PhonesContract
import com.dorritos.market.remote.models.phones.Phones
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BannerViewModel(private val contract: PhonesContract) : ViewModel() {

    private val phonesFlow = MutableStateFlow<Phones?>(null)

    fun getPhones() {
        viewModelScope.launch(Dispatchers.IO) {
            phonesFlow.emit(contract.getPhones())
        }
    }
}