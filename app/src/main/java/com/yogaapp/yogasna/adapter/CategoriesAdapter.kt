package com.yogaapp.yogasna.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.dataClass.CategoriesDataClass
import com.yogaapp.yogasna.fragments.CategoriesFragment

class CategoriesAdapter(private var mListener : CategoriesFragment, private var data : List<CategoriesDataClass>): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

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



    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        val currentItem = data[position]
        holder.tvhead.text = currentItem.heading
    }

    override fun getItemCount(): Int {
       return data.size
    }
 inner class ViewHolder
    internal constructor(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val tvhead : TextView = itemView.findViewById(R.id.tvcategoryhead)
        val card : View = itemView.findViewById(R.id.categorycard)
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
