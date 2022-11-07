package com.dorritos.market.remote

import com.dorritos.market.remote.models.cart.Cart
import com.dorritos.market.remote.models.details.Details
import com.dorritos.market.remote.models.phones.Phones
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val PHONES = "/v3/654bd15e-b121-49ba-a588-960956b15175"
        const val DETAILS = "/v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5"
        const val CART = "/v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149"
    }

    @GET(PHONES)
    suspend fun getPhones(): Phones

    @GET(DETAILS)
    suspend fun getDetails(): Details

    @GET(CART)
    suspend fun getCartItems(): Cart
}