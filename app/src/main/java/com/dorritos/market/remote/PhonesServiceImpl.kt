package com.dorritos.market.remote

import com.dorritos.market.remote.models.cart.Cart
import com.dorritos.market.remote.models.details.Details
import com.dorritos.market.remote.models.phones.Phones

class PhonesServiceImpl(private val api: ApiService) : PhonesContract {
    override suspend fun getPhones(): Phones = api.getPhones()
    override suspend fun getDetails(): Details = api.getDetails()
    override suspend fun getCart(): Cart = api.getCartItems()
}