package com.yogaapp.yogasna.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.yogaapp.yogasna.HomeFragment
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.dataClass.homedataclass

class HomeAdapter(private var mListener: HomeFragment, private val data: List<homedataclass>):RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    private val item : MutableList<CardView>
    init {
        this.item = ArrayList()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val v = from(parent.context).inflate(R.layout.horizontal_list_items_cardview, parent ,false)
        val v = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_list_items_cardview,parent, false )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.image.setImageResource(data[position].image)
        item.add(holder.card)
    }

    override fun getItemCount(): Int {
        return data.size
    }
    inner class ViewHolder
    internal constructor(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val image : ImageView = itemView.findViewById(R.id.cardrecycler)
        val title : TextView = itemView.findViewById(R.id.headingHorizontal)
        val card : CardView = itemView.findViewById(R.id.card)
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


