package com.dorritos.market.remote.models.phones

import com.dorritos.market.remote.models.phones.BestSeller
import com.dorritos.market.remote.models.phones.HomeStore

data class Phones(
    val best_seller: List<BestSeller>,
    val home_store: List<HomeStore>
)