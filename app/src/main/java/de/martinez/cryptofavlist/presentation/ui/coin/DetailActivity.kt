package de.martinez.cryptofavlist.presentation.ui.coin

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import de.martinez.cryptofavlist.R
import de.martinez.cryptofavlist.domain.repository.CryptoRepository
import javax.inject.Inject

@AndroidEntryPoint

class DetailActivity : AppCompatActivity() {
    @Inject
    lateinit var cryptoRepository: CryptoRepository
    lateinit var viewmodelCryptoDetail: CryptoDetailViewModel
    lateinit var coin: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val progressBar: ProgressBar? = findViewById(R.id.progressBarDetail)
        val textView = findViewById<TextView>(R.id.textViewDetail)
        val textView2 = findViewById<TextView>(R.id.textViewDetail2)
        val textView3 = findViewById<TextView>(R.id.textViewDetail3)
        val textView4 = findViewById<TextView>(R.id.textViewDetail4)

        val extras = intent.extras
        if (extras != null) {
            coin = extras.getString("coin").toString()
        }

        viewmodelCryptoDetail = ViewModelProvider(
            this,
            CryptoDetailViewModelFactory(cryptoRepository, coin)
        ).get(CryptoDetailViewModel::class.java)

        viewmodelCryptoDetail.state.observe(this, {
            if (it.isloading) {
                progressBar!!.visibility = View.VISIBLE
                textView.visibility = View.GONE
                textView2.visibility = View.GONE
                textView3.visibility = View.GONE
                textView4.visibility = View.GONE
            } else {
                progressBar!!.visibility = View.GONE
                textView.visibility = View.VISIBLE
                textView2.visibility = View.VISIBLE

            }
            if (it.cryptoinfo !== null) {
                textView3.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE

                textView.text = it.cryptoinfo.name
                textView2.text = "Price: " + it.cryptoinfo.price
                textView3.text = "Rank: " + it.cryptoinfo.rank.toString()
                textView4.text = "Symbol: " + it.cryptoinfo.symbol

            }
            if (it.cryptoinfo == null && it.error != null) {
                textView.text = it.error
                textView2.text = "for " + it.coinname
            }
        })
    }
}