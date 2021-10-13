package de.martinez.cryptofavlist.domain.use_case

import de.martinez.cryptofavlist.data.common.Resource
import de.martinez.cryptofavlist.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCryptosUseCase @Inject constructor(private val repository: CryptoRepository) {
    operator fun invoke(): Flow<Resource<List<String>>> = flow {
        try {
            emit(Resource.Loading<List<String>>())
            val coins = repository.getCoins()
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<String>>(e.localizedMessage ?: "error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<String>>(e.localizedMessage ?: "couldnt reach server"))
        }
    }
}