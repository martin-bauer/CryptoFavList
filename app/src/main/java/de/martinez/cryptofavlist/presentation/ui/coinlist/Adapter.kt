package de.martinez.cryptofavlist.presentation.ui.coinlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import de.martinez.cryptofavlist.R
import de.martinez.cryptofavlist.presentation.ui.coin.DetailActivity


class Adapter(val cryptolist: ArrayList<String>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(cryptolist[position])
//        holder.itemView.setOnClickListener {
//            holder.itemView.(Color.Black)
//            holder.itemView.textView.setTextColor(Color.Black)
//        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return cryptolist.size
    }

    //the class is holding the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(coin: String) {
            val name: TextView = itemView.findViewById(R.id.textViewItem)
            val card: CardView = itemView.findViewById(R.id.card_view)
            name.text = coin
            card.setOnClickListener {
                val intent = Intent(it.context, DetailActivity::class.java)
                intent.putExtra("coin", coin)
                it.context.startActivity(intent)
            }
        }
    }
}
