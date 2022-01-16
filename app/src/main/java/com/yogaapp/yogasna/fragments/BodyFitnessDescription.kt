package com.yogaapp.yogasna.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.databinding.FragmentBodyFitnessDescriptionBinding

class BodyFitnessDescription : Fragment() {

    lateinit var binding : FragmentBodyFitnessDescriptionBinding
    private val args by navArgs<BodyFitnessDescriptionArgs>()
    private lateinit var desText:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         val neckWorkoutArray = arrayOf("Neck Workout ex1 DES", "Neck Workout ex2 DES", "Neck Workout ex3 DES", "Neck Workout ex4 DES")
         val shoulderWorkoutArray = arrayOf("Shoulders Workout ex1 DES", "Shoulders Workout ex2 DES", "Shoulders Workout ex3 DES", "Shoulders Workout ex4 DES")
         val armWorkoutArray = arrayOf("Arms Workout ex1 DES", "Arms Workout ex2 DES", "Arms Workout ex3 DES", "Arms Workout ex4 DES")
         val chestWorkoutArray = arrayOf("Chest Workout ex1 DES", "Chest Workout ex2 DES", "Chest Workout ex3 DES", "Chest Workout ex4 DES")

        if (args.headPos==0){
            desText = neckWorkoutArray[args.pos]
        }
        if (args.headPos==1){
            desText = shoulderWorkoutArray[args.pos]
        }
        if (args.headPos==2){
            desText = armWorkoutArray[args.pos]
        }
        if (args.headPos==3){
            desText = chestWorkoutArray[args.pos]
        }
        binding.tvBodyFitnessDes.text = desText
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBodyFitnessDescriptionBinding.inflate(layoutInflater)
//        return inflater.inflate(R.layout.fragment_body_fitness_description, container, false)
        return binding.root
    }


}