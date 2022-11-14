package com.dorritos.market

import com.dorritos.market.remote.ApiService
import com.dorritos.market.remote.PhonesContract
import com.dorritos.market.remote.PhonesServiceImpl
import com.dorritos.market.ui.viewmodels.PhonesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL: String = "https://run.mocky.io"

val appModule = module {

    single { Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build() }

    single { get<Retrofit>().create(ApiService::class.java) }

    single {PhonesServiceImpl(get())}

    viewModel { PhonesViewModel(get<PhonesServiceImpl>() as PhonesContract ) }

}