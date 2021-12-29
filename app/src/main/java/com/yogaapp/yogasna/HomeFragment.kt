package com.yogaapp.yogasna

import android.os.Build
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yogaapp.yogasna.databinding.FragmentHomeBinding
import java.io.File


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rectangle1.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_thoughts_Fragment)
        }
        binding.rectangle2.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_relax_Fragment)
        }
        binding.rectangle3.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_suryaNamaskar_Fragment)
        }
        binding.imageView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_beginner3)
        }
        binding.imageView2.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_intermediate)
        }
        binding.imageView3.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_advanced)
        }
        binding.imageView4.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_bodyFitness)
        }
    }
}