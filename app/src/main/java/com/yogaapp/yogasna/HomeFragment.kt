package com.yogaapp.yogasna

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yogaapp.yogasna.adapter.HomeAdapter
import com.yogaapp.yogasna.dataClass.homedataclass
import com.yogaapp.yogasna.databinding.FragmentHomeBinding
import kotlin.math.log


class HomeFragment : Fragment() {

    private var headingArray = arrayOf("Daily warm-up", "Strength","Stretching")
    private var imageArray = arrayOf(R.drawable.one, R.drawable.strength, R.drawable.stretch)
    private lateinit var binding : FragmentHomeBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var newArrayList : ArrayList<homedataclass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val data : MutableList<homedataclass> = ArrayList()
        for (i in headingArray.indices)
            data.add(homedataclass(headingArray[i], imageArray[i]))

        val layoutManager = LinearLayoutManager(activity,  LinearLayoutManager.HORIZONTAL, false)

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.home_recycler)
        recyclerView.layoutManager = layoutManager
        recyclerView.hasFixedSize()
        newArrayList = arrayListOf<homedataclass>()
        getUserData()
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<CardView>(R.id.relax).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_relax_Fragment)
        }
        view.findViewById<CardView>(R.id.suryanamskarcard).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_suryaNamaskar_Fragment)
        }

        view.findViewById<CardView>(R.id.imageView4).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_bodyFitness)
        }

    }
    private fun getUserData(){
        for (i in headingArray.indices){
            val homelistdata = homedataclass(headingArray[i], imageArray[i])
            newArrayList.add(homelistdata)
        }
        val adapter = HomeAdapter(this, newArrayList)
        recyclerView.adapter = adapter
    }
    fun onItemClick(position: Int) {
        val pos = position
        Log.d("VIBHUTI", "Click$pos")
        Toast.makeText(activity, "Click $pos", Toast.LENGTH_SHORT).show()
        val action = HomeFragmentDirections.actionHomeFragmentToCategoriesFragment(pos)
        findNavController().navigate(action)

    }

}


