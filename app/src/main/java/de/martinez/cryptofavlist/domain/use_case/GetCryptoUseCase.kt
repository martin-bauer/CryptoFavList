package de.martinez.cryptofavlist.domain.use_case

import de.martinez.cryptofavlist.data.common.Resource
import de.martinez.cryptofavlist.data.dto.toCrypto
import de.martinez.cryptofavlist.domain.model.Crypto
import de.martinez.cryptofavlist.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCryptoUseCase @Inject constructor(private val repository: CryptoRepository) {
    operator fun invoke(id: String): Flow<Resource<Crypto>> = flow {
        try {
            emit(Resource.Loading<Crypto>())
            val coins = repository.getCoin(id).toCrypto()
            val x = 0
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error<Crypto>(e.localizedMessage ?: "error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<Crypto>(e.localizedMessage ?: "couldnt reach server"))
        }
    }
}