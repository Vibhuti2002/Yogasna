package com.yogaapp.yogasna.suryanamskar

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yogaapp.yogasna.R

class Surya_Adapter(private val suryastepslist : ArrayList<steplistdata>) : RecyclerView.Adapter<Surya_Adapter.MyViewHolder>() {
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
        abstract fun onViewCreated(view: View, savedInstanceState: Bundle?)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

//    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.surya_step_list_iem, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = suryastepslist[position]
        holder.stepheading.text = currentitem.step
        holder.durationheading.text = currentitem.duration
    }

    override fun getItemCount(): Int {
        return suryastepslist.size
    }
    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val stepheading : TextView = itemView.findViewById(R.id.step_head)
        val durationheading : TextView = itemView.findViewById(R.id.duration)
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }
}