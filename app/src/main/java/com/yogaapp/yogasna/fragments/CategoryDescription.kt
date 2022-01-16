package com.yogaapp.yogasna.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.yogaapp.yogasna.databinding.FragmentCategoryDescriptionBinding

class CategoryDescription : Fragment() {
    private val args by navArgs<CategoryDescriptionArgs>()
    private lateinit var binding: FragmentCategoryDescriptionBinding
    private lateinit var desText:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val heading = arrayOf("Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5")
        val warmupDescription = arrayOf("des ex warmup 1", "desc ex2", "des ex3", "des ex 4", "des ex5")
        val strengthDescription = arrayOf("des ex strength 1", "desc ex2", "des ex3", "des ex 4", "des ex5")
        val stretchDescription = arrayOf("des ex stretch 1", "desc ex2", "des ex3", "des ex 4", "des ex5")
        val catHeading = heading[args.pos]
        if(args.type==0){
        desText = warmupDescription[args.pos]
        }
        if(args.type==1){
            desText = strengthDescription[args.pos]
        }
        if(args.type==2){
            desText = stretchDescription[args.pos]
        }

        binding.tvCatDes.text = desText
        binding.tvcatHeading.text = catHeading
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDescriptionBinding.inflate(layoutInflater)

//        return inflater.inflate(R.layout.fragment_category_description, container, false)
        return binding.root
    }
}