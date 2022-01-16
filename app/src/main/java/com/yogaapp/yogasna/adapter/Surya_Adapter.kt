package com.yogaapp.yogasna.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.dataClass.steplistdata

class Surya_Adapter(private var mListener : onItemClickListener , private val suryastepslist : ArrayList<steplistdata> ) : RecyclerView.Adapter<Surya_Adapter.MyViewHolder>() {

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.surya_step_list_iem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = suryastepslist[position]
        holder.stepheading.text = currentitem.step
        holder.durationheading.text = currentitem.duration
    }

    override fun getItemCount(): Int {
        return suryastepslist.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val stepheading : TextView = itemView.findViewById(R.id.step_head)
        val durationheading : TextView = itemView.findViewById(R.id.duration)
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