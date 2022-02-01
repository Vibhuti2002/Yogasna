package com.yogaapp.yogasna.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.adapter.CategoriesAdapter
import com.yogaapp.yogasna.dataClass.CategoriesDataClass
import com.yogaapp.yogasna.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {
    private val args by navArgs<CategoriesFragmentArgs>()
    lateinit var binding: FragmentCategoriesBinding
    private lateinit var newrecyclerview: RecyclerView
    private lateinit var newArraylist: ArrayList<CategoriesDataClass>
//    private var warmUpHeadArray = arrayOf("Head to Toe Warm-up Exercises")
    private var stretchArray = arrayOf("Bridge Pose","Cat pose","Child's Pose","Downward Dog","Pigeon pose","Triangle pose","Warrior II")
    private var strengthArray = arrayOf("Three-Legged Dog Pose","Warrior III","Revolved Half Moon Pose","Boat Pose","Bridge Pose","Mountain Pose","Revolved Side Angle Pose")
    var type = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        val view = inflater.inflate(R.layout.fragment_categories, container, false)
        newrecyclerview = view.findViewById(R.id.categoryRecycler)
        newrecyclerview.layoutManager = LinearLayoutManager(activity)
        newrecyclerview.setHasFixedSize(true)
        newArraylist = arrayListOf<CategoriesDataClass>()
        getUserData()
        return view
    }

    private fun getUserData() {
//        if(args.pos == 0) {
//            type=0
//            for (i in warmUpHeadArray.indices) {
//                val categoryData = CategoriesDataClass(warmUpHeadArray[i])
//                newArraylist.add(categoryData)
//            }
//        }
        if(args.pos == 1) {
            type=1
            for (i in strengthArray.indices) {
                val categoryData = CategoriesDataClass(strengthArray[i])
                newArraylist.add(categoryData)
            }
        }
        if(args.pos == 2) {
            type =2
            for (i in stretchArray.indices) {
                val categoryData = CategoriesDataClass(stretchArray[i])
                newArraylist.add(categoryData)
            }
        }
        val adapter = CategoriesAdapter(this,newArraylist)
        newrecyclerview.adapter = adapter
    }

    fun onItemClick(position: Int) {
        val pos = position
        val action = CategoriesFragmentDirections.actionCategoriesFragmentToCategoryDescription(pos, type)
        findNavController().navigate(action)
    }
}