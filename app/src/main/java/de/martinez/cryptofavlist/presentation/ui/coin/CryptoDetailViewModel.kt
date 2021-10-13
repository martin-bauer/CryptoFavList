package de.martinez.cryptofavlist.presentation.ui.coin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.martinez.cryptofavlist.data.common.Resource
import de.martinez.cryptofavlist.domain.use_case.GetCryptoUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CryptoDetailViewModel @Inject constructor(
    private val getCryptoUseCase: GetCryptoUseCase,
    private var coin: String,
) : ViewModel() {

    private val _state = MutableLiveData(CryptoDetailListState())
    val state: LiveData<CryptoDetailListState> = _state

    init {
        getCrypto(coin)
    }

    private fun getCrypto(id: String) {
        getCryptoUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        CryptoDetailListState(coinname = id, cryptoinfo = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        CryptoDetailListState(
                            coinname = id,
                            error = result.message ?: "Unexpected error"
                        )

                }
                is Resource.Loading -> {
                    _state.value = CryptoDetailListState(coinname = id, isloading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}