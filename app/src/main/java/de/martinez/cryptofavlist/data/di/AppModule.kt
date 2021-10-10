package de.martinez.cryptofavlist.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.martinez.cryptofavlist.data.MartinsCryptoApi
import de.martinez.cryptofavlist.data.common.Constants
import de.martinez.cryptofavlist.data.repository.CryptoRepositoryImpl
import de.martinez.cryptofavlist.domain.repository.CryptoRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMartinsApi(): MartinsCryptoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MartinsCryptoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCryptoRepository(api: MartinsCryptoApi): CryptoRepository {
        return CryptoRepositoryImpl(api)
    }
}