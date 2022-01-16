package com.yogaapp.yogasna.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.yogaapp.yogasna.R

class Relax_Fragment : Fragment() {
        private var  mediaPlayer : MediaPlayer?= null
    private var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = FragmentRelaxBinding.inflate(layoutInflater)
        val view = inflater.inflate(R.layout.fragment_relax_, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<ImageView>(R.id.playbutton).setOnClickListener{
            count = 0
            playAudio(count)
        }
        view.findViewById<ImageView>(R.id.playbutton2).setOnClickListener{
            count = 1
            playAudio(count)
        }
        view.findViewById<ImageView>(R.id.playbutton3).setOnClickListener{
            count = 2
            playAudio(count)
        }
        view.findViewById<ImageView>(R.id.playbutton4).setOnClickListener{
            count = 3
            playAudio(count)
        }
        view.findViewById<View>(R.id.bpause).setOnClickListener{
            pauseAudio()
        }

    }

    private fun pauseAudio() {
        if(mediaPlayer != null) {
           mediaPlayer?.pause()
            mediaPlayer = null
        }
        else{
            Toast.makeText(activity, "Audio is not Playing", Toast.LENGTH_SHORT).show()
        }
    }

    private fun playAudio(count : Int) {
        if(mediaPlayer == null){
            if (count==0){
            mediaPlayer = MediaPlayer.create(activity, R.raw.om)}
            if (count==1){
                mediaPlayer = MediaPlayer.create(activity, R.raw.songofsadhana)}
            if (count==2){
                mediaPlayer = MediaPlayer.create(activity, R.raw.yogastyle)}
        if(count==3){
            mediaPlayer = MediaPlayer.create(activity, R.raw.pianomoment)
        }
        }
        mediaPlayer?.start()

        Toast.makeText(activity, "Audio Started Playing", Toast.LENGTH_SHORT).show()
    }

    }
