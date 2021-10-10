package de.martinez.cryptofavlist.domain.model

data class Crypto(
    val id: String,
    val name: String,
    val price: String,
    val rank: Int,
    val symbol: String
)
