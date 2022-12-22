package com.example.viewpagerdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerdemo.databinding.IntroItemsBinding


class ItemAdapter(private val introList: List<ItemModel>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: IntroItemsBinding): RecyclerView.ViewHolder(binding.root){

        fun bindItem(model: ItemModel){
            binding.descTv.text = model.desc
            binding.titleTv.text= model.title
            binding.iconIv.setImageResource(model.photo)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            IntroItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindItem(introList[position])
    }

    override fun getItemCount(): Int {
        return introList.size
    }
}
