package com.alisavran.cryptoapp

import com.alisavran.cryptoapp.Api.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://pro-api.coinmarketcap.com"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor{ chain->
            val request = chain.request().newBuilder()
                .addHeader("X-CMC_PRO_API_KEY","b5393c10-b1f4-47d3-887d-d655a818140c")
                .addHeader("Accept","application/json")
                .build()
            chain.proceed(request)

        }.build()

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}