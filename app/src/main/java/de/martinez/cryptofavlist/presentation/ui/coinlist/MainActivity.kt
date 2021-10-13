package de.martinez.cryptofavlist.presentation.ui.coinlist

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import de.martinez.cryptofavlist.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var viewmodelCryptolist: CryptoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar: ProgressBar? = findViewById(R.id.progressBar)

        viewmodelCryptolist = ViewModelProvider(this).get(CryptoListViewModel::class.java)

        viewmodelCryptolist.state.observe(this, {
            if (it.isloading) {
                progressBar!!.visibility = View.VISIBLE

            } else {
                progressBar!!.visibility = View.GONE
            }
            if (it.cryptos.isNotEmpty()) {
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
                recyclerView.layoutManager = LinearLayoutManager(this)
                val adapter = Adapter(ArrayList(it.cryptos))
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        })
    }
}