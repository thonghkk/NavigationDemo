package com.example.navigation2.RecycleViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation2.R
import kotlinx.android.synthetic.main.list_items.view.*

class CustomAdapterGrammar(private val model: ArrayList<Model>, private val customListener: CustomListener)
    :RecyclerView.Adapter<CustomAdapterGrammar.ViewHolderGrammar>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGrammar {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false)
        return ViewHolderGrammar(v)
    }

    override fun onBindViewHolder(holder: ViewHolderGrammar, position: Int) {
        holder.bindItems(model[position])
        holder.itemView.setOnClickListener {
            customListener.onCustomClick(position)
        }
    }

    override fun getItemCount() = model.size

    class ViewHolderGrammar(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(model: Model){
            itemView.txt_title.text = model.name
            itemView.txt_des.text = model.title
        }
    }
}

        interface CustomListener{
            fun onCustomClick(position: Int)
        }