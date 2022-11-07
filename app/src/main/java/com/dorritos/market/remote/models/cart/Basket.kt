package com.dorritos.market.remote.models.cart

data class Basket(
    val id: Int,
    val images: String,
    val price: Int,
    val title: String
)