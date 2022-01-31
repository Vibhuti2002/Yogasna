package com.yogaapp.yogasna.fragments

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yogaapp.yogasna.adapter.WarmUpAdapter
import com.yogaapp.yogasna.databinding.FragmentWarmUpBinding
import java.util.*

class WarmUpFragment : Fragment(),TextToSpeech.OnInitListener {
    private lateinit var binding : FragmentWarmUpBinding
    private lateinit var rvWarmUp: RecyclerView
    private lateinit var tts : TextToSpeech
    private var warmUpHeadArray = arrayOf("Head Turns","Head Tilt","Chin Up & Down","Shoulder Rolls","Arm Circles",
        "Elbows In & Out","Side Bends","Knee Kicks","Side Leg Lifts","Leg Swings","Point, Flex & Circles")
    private var warmUpDescArray = arrayOf(
        "look left, look right; repeat 5 times",
        "ear to left shoulder, ear to right shoulder; keep shoulders down and neck relaxed, repeat 5 times",
        "shoulders relaxed, drop chin to chest, then lift chin to ceiling, repeat 5 times",
        "roll the shoulders backwards 10 times; roll the shoulders forward 10 times",
        "arms stretched out wide; small & big circles, forward and backward",
        "hands on shoulders, neck relaxed; push elbows out to stretch the chest, bring elbows in to stretch the back; repeat 5 times",
        "stand tall, hands on hips; bend at the waist – front, side, back, side and then reverse direction",
        "stand tall, right knee up and extend the leg; repeat 10 times then switch to other leg",
        "stand tall, straight leg, lift right leg out to the side; repeat 10 times and switch to the left leg",
        "stand tall, bend right leg, heel in, swing leg forward and back, repeat 10 times, and switch legs",
        "right leg out in front, point toes, and then flex foot,repeat 10 times, rotate the ankle clockwise 10 times then counterclockwise 10 times; switch legs and repeat",
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWarmUpBinding.inflate(layoutInflater)
        rvWarmUp = binding.warmUpRecycler
        rvWarmUp.layoutManager = LinearLayoutManager(activity)
        rvWarmUp.setHasFixedSize(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tts = TextToSpeech(activity,this)
        val adapter = WarmUpAdapter(this,warmUpHeadArray)
        rvWarmUp.adapter = adapter
    }



    fun onItemClick(position: Int) {
        val desc = warmUpDescArray[position]
        speak(desc)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            val result = tts.setLanguage(Locale.US)
            tts.setSpeechRate(0.65F)
            if ( result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(activity,"language not supported", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(activity,"failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun speak(desc : String) {
        tts.speak(desc, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onDestroy() {
        tts.stop()
        tts.shutdown()
        super.onDestroy()
    }

}