package com.yogaapp.yogasna.suryanamskar

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.firebase.storage.FirebaseStorage
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.databinding.FragmentSuryaStepDescriptionBinding
import com.yogaapp.yogasna.databinding.SuryaStepListIemBinding
import java.io.File

class Surya_Step_Description_Fragment : Fragment() {

    private val args by navArgs<Surya_Step_Description_FragmentArgs>()
    private lateinit var binding: FragmentSuryaStepDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSuryaStepDescriptionBinding.inflate(layoutInflater)
        super.onViewCreated(view, savedInstanceState)

//       binding..setOnClickListener{
        val stepimagename = arrayOf(
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
        val steptitle = stepimagename[args.pos].toString()
        val storageRef =
            FirebaseStorage.getInstance().reference.child("images/SuryaNamaskarSteps/${stepimagename[args.pos]}.jpg")
        //val storageRef = FirebaseStorage.getInstance().reference.child("image/${imagename[args.pos]}.txt")

        val localfile = File.createTempFile("Tempimage", "jpg")
        storageRef.getFile(localfile).addOnSuccessListener {
            if (binding.progressBarT.visibility == View.VISIBLE) {
                binding.progressBarT.visibility = View.GONE
            }
            val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
            binding.suryastepimage.setImageBitmap(bitmap)
            binding.stepheading.text = steptitle.toString()
        }.addOnFailureListener {
            Toast.makeText(activity, "Failed to load image", Toast.LENGTH_SHORT).show()
            if (binding.progressBarT.visibility == View.VISIBLE){
                binding.progressBarT.visibility = View.GONE
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.progressBarT.visibility = View.VISIBLE
        binding = FragmentSuryaStepDescriptionBinding.inflate(layoutInflater)
        return binding.root
    }
}