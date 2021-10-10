package de.martinez.cryptofavlist.data.dto

import de.martinez.cryptofavlist.domain.model.Crypto

data class CryptoDTO(
    val id: String,
    val name: String,
    val price: String,
    val rank: Int,
    val symbol: String
)

fun CryptoDTO.toCrypto(): Crypto {
    return Crypto(
        id, name, price, rank, symbol
    )
}