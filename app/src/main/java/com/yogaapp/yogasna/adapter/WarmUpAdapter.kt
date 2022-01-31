package com.yogaapp.yogasna.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.fragments.WarmUpFragment

class WarmUpAdapter(private var mListener: WarmUpFragment, private var data: Array<String>): RecyclerView.Adapter<WarmUpAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_list, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: WarmUpAdapter.ViewHolder, position: Int) {
        val currentItem = data[position]
        holder.tvhead.text = currentItem
    }

    override fun getItemCount(): Int {
        return data.size
    }
    inner class ViewHolder
    internal constructor(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val tvhead : TextView = itemView.findViewById(R.id.tvcategoryhead)
        init {
            itemView.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {
            val position = bindingAdapterPosition
            if(position!= RecyclerView.NO_POSITION){
                mListener.onItemClick(position)
            }
        }
    }

}