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
import com.yogaapp.yogasna.databinding.FragmentStepsSuryanamskarBinding

class Steps_Suryanamskar : Fragment() {
    private lateinit var newrecyclerview: RecyclerView
    private lateinit var newArraylist: ArrayList<steplistdata>
    lateinit var suryastepArray: Array<String>
    lateinit var suryadurationArray: Array<String>
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
            "1 minutes",
            "2 minutes",
            "3 minutes",
            "4 minutes",
            "5 minutes",
            "6 minutes",
            "7 minutes",
            "8 minutes",
            "9 minutes",
            "10 minutes",
            "11 minutes",
            "12 minutes"
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


        val adapter = Surya_Adapter(newArraylist)
        newrecyclerview.adapter = adapter
        adapter.setOnItemClickListener(
            object : Surya_Adapter.onItemClickListener {

                override fun onItemClick(position: Int) {
                    // findNavController().navigate(R.id.action_steps_Suryanamskar_to_surya_Step_Description_Fragment)
                    val pos = position
                    val action =
                        Steps_SuryanamskarDirections.actionStepsSuryanamskarToSuryaStepDescriptionFragment(
                            pos
                        )
                    findNavController().navigate(action)
                }

                override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                    binding.suryaStepsRecycler.setOnClickListener {

                    }

                }
            })

    }



//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.recycler.setOnClickListener{
//            val storageRef = FirebaseStorage.getInstance().reference.child("images/pexels-elina-fairytale-3822114(1)-min.jpg")
//
//            val localfile = File.createTempFile("Tempimage", "jpg")
//            storageRef.getFile(localfile).addOnSuccessListener {
//                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
//                binding.image.setImageBitmap(bitmap)
//            }
//            }.addOnFailureListener{
//                Toast.makeText(this,"Failed to load image",Toast.LENGTH_SHORT).show()
//            }
//    }


}