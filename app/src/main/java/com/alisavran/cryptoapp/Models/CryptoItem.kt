package com.alisavran.cryptoapp.Models


data class CryptoItem(
    val id: Long,
    val name: String,
    val symbol: String,
    val quote: Quote,
    var isFavorite: Boolean = false
)

data class Quote(
    val USD: Currency
)

data class Currency(
    val price: Double,
    val percent_change_1h: Double,
    val percent_change_24h: Double,
    val percent_change_7d: Double
)