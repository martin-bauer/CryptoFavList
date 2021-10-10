package de.martinez.cryptofavlist.data.repository

import de.martinez.cryptofavlist.data.MartinsCryptoApi
import de.martinez.cryptofavlist.data.dto.CryptoDTO
import de.martinez.cryptofavlist.domain.model.Crypto
import de.martinez.cryptofavlist.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(private val api: MartinsCryptoApi) : CryptoRepository {
    override suspend fun getCoins(): List<String> {
        return api.getCoins()
    }

    override suspend fun getCoin(id: String): CryptoDTO {
        return api.getCoin(id)
    }
}