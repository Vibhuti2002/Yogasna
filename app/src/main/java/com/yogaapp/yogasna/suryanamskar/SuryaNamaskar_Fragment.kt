package com.yogaapp.yogasna.suryanamskar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.databinding.FragmentHomeBinding
import com.yogaapp.yogasna.databinding.FragmentSuryaNamaskarBinding


class SuryaNamaskar_Fragment : Fragment() {
    private lateinit var binding : FragmentSuryaNamaskarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuryaNamaskarBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.steps.setOnClickListener{
            findNavController().navigate(R.id.action_suryaNamaskar_Fragment_to_steps_Suryanamskar)
        }
        binding.benefits.setOnClickListener{
            findNavController().navigate(R.id.action_suryaNamaskar_Fragment_to_benefits)
        }
    }
}