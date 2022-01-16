package com.yogaapp.yogasna.fragments

import android.icu.text.Transliterator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.adapter.BodyFitnessListAdapter
import com.yogaapp.yogasna.adapter.CategoriesAdapter
import com.yogaapp.yogasna.dataClass.BodyFitnessListDataClass
import com.yogaapp.yogasna.dataClass.CategoriesDataClass
import com.yogaapp.yogasna.databinding.FragmentBodyFitnessListBinding

class BodyFitnessListFragment : Fragment() {
    private val args by navArgs<BodyFitnessListFragmentArgs>()
    private val bodyFitnessButton = arrayOf("Neck Workout description", "Shoulders Workout description", "Arm Workout description", "Chest Workout description")
    private val neckWorkoutArray = arrayOf("Neck Workout ex1", "Neck Workout ex2", "Neck Workout ex3", "Neck Workout ex4")
    private val shoulderWorkoutArray = arrayOf("Shoulders Workout ex1", "Shoulders Workout ex2", "Shoulders Workout ex3", "Shoulders Workout ex4")
    private val armWorkoutArray = arrayOf("Arms Workout ex1", "Arms Workout ex2", "Arms Workout ex3", "Arms Workout ex4")
    private val chestWorkoutArray = arrayOf("Chest Workout ex1", "Chest Workout ex2", "Chest Workout ex3", "Chest Workout ex4")

    private lateinit var newrecyclerview: RecyclerView
    private lateinit var newArraylist: ArrayList<BodyFitnessListDataClass>
    lateinit var binding: FragmentBodyFitnessListBinding
    var headPos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBodyFitnessListBinding.inflate(layoutInflater)
        val view = inflater.inflate(R.layout.fragment_body_fitness_list, container, false)
        newrecyclerview = view.findViewById(R.id.bodyFitnessRecycler)
        newrecyclerview.layoutManager = LinearLayoutManager(activity)
        newrecyclerview.setHasFixedSize(true)
        newArraylist = arrayListOf<BodyFitnessListDataClass>()
        getUserData()
        return view
    }
    private fun getUserData(){
        if (args.pos==0){
            headPos =0
            for (i in neckWorkoutArray.indices){
                val fitnessData = BodyFitnessListDataClass(neckWorkoutArray[i])
                newArraylist.add(fitnessData)
            }
        }

        if (args.pos==1){
            headPos=1
            for (i in shoulderWorkoutArray.indices){
                val fitnessData = BodyFitnessListDataClass(shoulderWorkoutArray[i])
                newArraylist.add(fitnessData)
            }
        }
        if (args.pos==2){
            headPos=2
            for (i in armWorkoutArray.indices){
                val fitnessData = BodyFitnessListDataClass(armWorkoutArray[i])
                newArraylist.add(fitnessData)
            }
        }

        if (args.pos==3){
            headPos =3
            for (i in chestWorkoutArray.indices){
                val fitnessData = BodyFitnessListDataClass(chestWorkoutArray[i])
                newArraylist.add(fitnessData)
            }
        }
        val adapter = BodyFitnessListAdapter(this,newArraylist)
        newrecyclerview.adapter = adapter
    }

    fun onItemClick(position: Int){
        val pos = position
        val action = BodyFitnessListFragmentDirections.actionBodyFitnessListFragmentToBodyFitnessDescription(headPos,pos)
        findNavController().navigate(action)
    }
}