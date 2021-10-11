package de.martinez.cryptofavlist.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.martinez.cryptofavlist.R

class Adapter(val cryptolist: ArrayList<String>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.bindItems(cryptolist[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return cryptolist.size
    }

    //the class is holding the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: String) {
            val content: TextView = itemView.findViewById(R.id.textViewItem)
            content.text = user
            itemView.setOnClickListener {
            }
        }
    }
}
