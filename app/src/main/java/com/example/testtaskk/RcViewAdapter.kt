package com.example.testtaskk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskk.databinding.ListItemBinding


class RcViewAdapter(val content: ArrayList<Item>): RecyclerView.Adapter<RcViewAdapter.Holder>(){

    class Holder(item:ListItemBinding): RecyclerView.ViewHolder(item.root){
        val title = item.title
        val description = item.desc
        val imageView = item.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val newsItem = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(newsItem)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = content[position].title
        holder.description.text = content[position].description
        holder.imageView.setImageResource(content[position].imageId)
    }

    override fun getItemCount(): Int {
        return content.size
    }

}