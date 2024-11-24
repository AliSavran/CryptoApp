package com.alisavran.cryptoapp

data class CryptoResponse(
    val data: List<CryptoItem>
)

data class CryptoItem(
    val name: String,
    val symbol: String,
    val quote: Quote
)

data class Quote(
    val USD: Currency
)

data class Currency(
    val price: Double
)