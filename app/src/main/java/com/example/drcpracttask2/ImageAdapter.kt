package com.example.drcpracttask2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.drcpracttask2.databinding.RowviewUserLayoutBinding
import com.example.drcpracttask2.model.Data


class ImageAdapter internal constructor(
    private var arrayList: ArrayList<Data>,
    var context: Context,

) : RecyclerView.Adapter<ImageAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        MyViewHolder(
            RowviewUserLayoutBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        try {
            val item = arrayList[position]

            Glide.with(context)
                .asGif()
                .load(item.images!!.downsizedLarge!!.url)
                .placeholder(R.color.black)
                .into(holder.binding.image);

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    inner class MyViewHolder(val binding: RowviewUserLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

}


