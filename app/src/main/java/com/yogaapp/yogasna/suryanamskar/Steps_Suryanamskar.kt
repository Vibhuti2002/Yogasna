package com.yogaapp.yogasna.suryanamskar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.adapter.Surya_Adapter
import com.yogaapp.yogasna.dataClass.steplistdata
import com.yogaapp.yogasna.databinding.FragmentStepsSuryanamskarBinding

class Steps_Suryanamskar : Fragment(), Surya_Adapter.onItemClickListener {

    private lateinit var newrecyclerview: RecyclerView
    private lateinit var newArraylist: ArrayList<steplistdata>
    private lateinit var suryastepArray: Array<String>
    private lateinit var suryadurationArray: Array<String>
    private lateinit var binding: FragmentStepsSuryanamskarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStepsSuryanamskarBinding.inflate(layoutInflater)
        suryastepArray = arrayOf(
            "Step 01",
            "Step 02",
            "Step 03",
            "Step 04",
            "Step 05",
            "Step 06",
            "Step 07",
            "Step 08",
            "Step 09",
            "Step 10",
            "Step 11",
            "Step 12"
        )

        suryadurationArray = arrayOf(
            "30 Seconds",
            "30 Seconds",
            "30 Seconds",
            "30 Seconds",
            "30 Seconds",
            "30 Seconds",
            "30 Seconds",
            "30 Seconds",
            "30 Seconds",
            "30 Seconds",
            "30 Seconds",
            "30 Seconds"
        )

        val view = inflater.inflate(R.layout.fragment_steps__suryanamskar, container, false)
        newrecyclerview = view.findViewById(R.id.surya_steps_recycler)
        newrecyclerview.layoutManager = LinearLayoutManager(activity)
        newrecyclerview.setHasFixedSize(true)
        newArraylist = arrayListOf<steplistdata>()
        getUserData()
        return view
    }

    private fun getUserData() {
        for (i in suryastepArray.indices) {
            val steplistdata = steplistdata(suryastepArray[i], suryadurationArray[i])
            newArraylist.add(steplistdata)
        }
        val adapter = Surya_Adapter(this,newArraylist)
        newrecyclerview.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        val pos = position
        val action = Steps_SuryanamskarDirections.actionStepsSuryanamskarToSuryaStepDescriptionFragment(pos)
        findNavController().navigate(action)
    }
}