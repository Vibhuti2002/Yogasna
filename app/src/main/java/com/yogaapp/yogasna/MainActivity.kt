package com.yogaapp.yogasna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Yogasna)
        setContentView(R.layout.activity_main)

        //val navController = Navigation.findNavController(this, R.id.homeFragment)

    }
}