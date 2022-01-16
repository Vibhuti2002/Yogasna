package com.yogaapp.yogasna.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.dataClass.BodyFitnessListDataClass
import com.yogaapp.yogasna.fragments.BodyFitnessListFragment
import org.w3c.dom.Text

class BodyFitnessListAdapter(private var mListener : BodyFitnessListFragment, private var data : List<BodyFitnessListDataClass>): RecyclerView.Adapter<BodyFitnessListAdapter.ViewHolder>(){
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BodyFitnessListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bodyfitnesslist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BodyFitnessListAdapter.ViewHolder, position: Int) {
        val currentItem = data[position]
        holder.recyclerHeading.text = currentItem.heading
    }

    override fun getItemCount(): Int {
        return data.size
    }
    inner class ViewHolder
    internal constructor(itemView : View): RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val recyclerHeading : TextView = itemView.findViewById(R.id.bodyListHead)
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