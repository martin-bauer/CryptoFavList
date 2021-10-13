package de.martinez.cryptofavlist.presentation.ui.coinlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.martinez.cryptofavlist.data.common.Resource
import de.martinez.cryptofavlist.domain.use_case.GetCryptosUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val getCryptosUseCase: GetCryptosUseCase
) : ViewModel() {

    private val _state = MutableLiveData(CryptoListState())
    val state: LiveData<CryptoListState> = _state

    init {
        getCryptos()
    }

    private fun getCryptos() {
        getCryptosUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CryptoListState(cryptos = result.data ?: emptyList<String>())
                }
                is Resource.Error -> {
                    _state.value = CryptoListState(error = result.message ?: "Unexpected error")

                }
                is Resource.Loading -> {
                    _state.value = CryptoListState(isloading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}