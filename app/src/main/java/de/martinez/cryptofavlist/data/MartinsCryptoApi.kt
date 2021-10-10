package de.martinez.cryptofavlist.data

import de.martinez.cryptofavlist.data.dto.CryptoDTO
import de.martinez.cryptofavlist.domain.model.Crypto
import retrofit2.http.GET
import retrofit2.http.Path

interface MartinsCryptoApi {
    @GET("v1/getcoins")
    suspend fun getCoins(): List<String>

    @GET("v1/getcoin/{id}")
    suspend fun getCoin(@Path("id") id: String): CryptoDTO
}