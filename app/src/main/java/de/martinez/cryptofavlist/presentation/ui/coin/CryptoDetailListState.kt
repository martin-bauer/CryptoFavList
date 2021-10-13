package de.martinez.cryptofavlist.presentation.ui.coin

import de.martinez.cryptofavlist.domain.model.Crypto

data class CryptoDetailListState(
    val coinname: String = "",
    val isloading: Boolean = false,
    val cryptoinfo: Crypto? = null,
    val error: String = ""
)
