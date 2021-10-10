package de.martinez.cryptofavlist.domain.repository

import de.martinez.cryptofavlist.data.dto.CryptoDTO

interface CryptoRepository {
    suspend fun getCoins(): List<String>
    suspend fun getCoin(id: String): CryptoDTO
}