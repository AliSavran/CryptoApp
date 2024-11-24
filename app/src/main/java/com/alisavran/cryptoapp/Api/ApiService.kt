package com.alisavran.cryptoapp.Api

import com.alisavran.cryptoapp.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getCryptoList(
        @Query("limit") limit: Int,
        @Query("convert") convert: String = "USD"
    ): Response<CryptoResponse>
}