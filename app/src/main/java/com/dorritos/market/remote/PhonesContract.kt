package com.dorritos.market.remote

import com.dorritos.market.remote.models.cart.Cart
import com.dorritos.market.remote.models.details.Details
import com.dorritos.market.remote.models.phones.Phones

interface PhonesContract {
    suspend fun getPhones() : Phones
    suspend fun getDetails() : Details
    suspend fun getCart() : Cart
}