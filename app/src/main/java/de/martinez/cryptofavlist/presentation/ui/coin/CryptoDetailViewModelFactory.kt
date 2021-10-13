package de.martinez.cryptofavlist.presentation.ui.coin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import de.martinez.cryptofavlist.domain.repository.CryptoRepository
import de.martinez.cryptofavlist.domain.use_case.GetCryptoUseCase

//@AndroidEntryPoint
class CryptoDetailViewModelFactory(cryptoRepository: CryptoRepository, coin: String) :
    ViewModelProvider.Factory {

//    @Inject
//    lateinit var cryptoRepository: CryptoRepository
    private var mRepo: CryptoRepository? = cryptoRepository
    private var mParam: String? = coin

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CryptoDetailViewModel(GetCryptoUseCase(mRepo!!), mParam!!) as T
    }


//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return CryptoDetailViewModel(GetCryptoUseCase(CryptoRepository()), mParam!!) as T
//    }
}
