package de.martinez.cryptofavlist.presentation.ui

data class CryptoListState(
    val isloading: Boolean = false,
    val cryptos: List<String> = emptyList(),
    val error: String = ""
)
