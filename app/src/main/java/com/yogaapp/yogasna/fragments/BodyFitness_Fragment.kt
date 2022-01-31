package com.yogaapp.yogasna.fragments

import android.icu.text.Transliterator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.databinding.FragmentBodyFitnessBinding

class BodyFitness_Fragment() : Fragment() {
    private lateinit var binding: FragmentBodyFitnessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBodyFitnessBinding.inflate(layoutInflater)
        binding.bAbsWorkout.setOnClickListener {
            onItemClick(0)
        }
        binding.bShouldersWorkout.setOnClickListener {
            onItemClick(1)
        }
        binding.bArmWorkout.setOnClickListener {
            onItemClick(2)
        }
        binding.bChestWorkout.setOnClickListener {
            onItemClick(3)
        }
       return binding.root
    }
   fun onItemClick(position: Int){
       val pos = position
       val action = BodyFitness_FragmentDirections.actionBodyFitnessToBodyFitnessListFragment(pos)
       findNavController().navigate(action)
   }
}