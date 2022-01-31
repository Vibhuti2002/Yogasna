package com.yogaapp.yogasna.suryanamskar

import android.content.ContentValues.TAG
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.VoicemailContract
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.databinding.FragmentSuryaStepDescriptionBinding
import com.yogaapp.yogasna.databinding.SuryaStepListIemBinding
import java.io.File
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import androidx.annotation.NonNull
import androidx.navigation.fragment.findNavController

import com.google.android.gms.tasks.OnFailureListener

import com.google.firebase.auth.AuthResult

import com.google.android.gms.tasks.OnSuccessListener
import com.yogaapp.yogasna.HomeFragmentDirections
import com.yogaapp.yogasna.adapter.Surya_Adapter
import java.util.*
import javax.net.ssl.SSLEngineResult

class Surya_Step_Description_Fragment : Fragment(), TextToSpeech.OnInitListener {
    private var buttonSpeak: Button? =  null
    private val args by navArgs<Surya_Step_Description_FragmentArgs>()
    private lateinit var binding: FragmentSuryaStepDescriptionBinding
    private lateinit var tts : TextToSpeech

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
    val head = arrayOf(
        "Step 1 (Prayer Pose)",
        "Step 2 (Raised Arms pose)",
        "Step 3 (Hand to Foot pose)",
        "Step 4 (Equestrian pose)",
        "Step 5 (Stick pose)",
        "Step 6 (Saluting with eight points or parts)",
        "Step 7 (Cobra pose)",
        "Step 8 (Mountain pose)",
        "Step 9 (Equestrian pose)",
        "Step 10 (Hand to foot pose)",
        "Step 11 (Raised Arms pose)",
        "Step 12"
    )

    val stepdescription = arrayOf(
        "Stand at the end of your mat, keep your feet together and distribute your weight on both feet equally. Open your chest and just relax your shoulders. Breathe in and lift both your arms up from the sides. Exhale and bring your palms together in a prayer position in front of your chest.",
        "Breathing in, lift the arms up and back, keeping the biceps close to the ears. In this pose, the objective is to stretch the whole body up from the heels to the tips of the fingers. ",
        "going backwards. Breathing out, bend forward from the waist, keeping the spine erect. As you exhale completely, bring the hands down to the floor, beside the feet.",
        "Breathing in, push your right leg back, as far back as possible. Bring the right knee to the floor and look up.",
        "As you breathe in, take the left leg back and bring the whole body in a straight line and keep your arms perpendicular to the floor.",
        "Gently bring your knees down to the floor and exhale. Take the hips back slightly, slide forward, rest your chest and chin on the floor. Raise your posterior a little bit .The two hands, two feet, two knees, chest and chin (eight parts of the body) should touch the floor",
        "Slide forward and raise the chest up into the cobra posture. You may keep your elbows bent in this pose, the shoulders away from the ears. Look up. As you inhale, make a gentle effort to push the chest forward; as you exhale, make a gentle effort to push the navel down. Tuck the toes under. Ensure you're stretching just as much as you can; do not force.",
        "Breathing out, lift the hips and the tail bone up, chest downwards in an 'inverted V' (/\\) posture. If possible, try and keep the heels on the ground and make a gentle effort to lift the tailbone up, going deeper into the stretch.",
        "Breathing in, bring the right foot forward in between the two hands, left knee down to the floor, press the hips down and look up and place the right foot exactly between the two hands and the right calf perpendicular to the floor.In this position, make a gentle effort to push the hips down towards the floor, to deepen the stretch.",
        "Breathing out, bring the left foot forward. Keep the palms on the floor. You may bend the knees, if necessary. Gently straighten the knees and if you can, try and touch your nose to the knees. Keep breathing.",
        "Breathing in, roll the spine up, hands go up and bend backwards a little bit, pushing the hips slightly outward. Ensure that your biceps are beside your ears. The idea is to stretch up more rather than stretching backwards.",
        "As you exhale, first straighten the body, and then bring the arms down. Relax in this position; observe the sensations in your body."
    )
    val mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuryaStepDescriptionBinding.inflate(layoutInflater)
        binding.progressBarT.visibility = View.VISIBLE
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val steptitle = head[args.pos].toString()
        binding.stepheading.text = steptitle.toString()
        binding.stepdescription.text = stepdescription[args.pos].toString()
        tts = TextToSpeech(activity,this)

        binding.stopButton.setOnClickListener {
            stop()
        }
        val storageRef = FirebaseStorage.getInstance().reference.child("SuryaNamaskarSteps/${stepimagename[args.pos]}.PNG")
//        val localfile = File.createTempFile("Tempimage", "jpg")
        val localfile = File.createTempFile("Tempimage", "PNG")

        storageRef.getFile(localfile).addOnSuccessListener {
            if (binding.progressBarT.visibility == View.VISIBLE) {
                binding.progressBarT.visibility = View.GONE
            }
            val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
            binding.suryastepimage.setImageBitmap(bitmap)
            speak()
        }.addOnFailureListener {
            Toast.makeText(activity, "Failed to load image", Toast.LENGTH_SHORT).show()
            if (binding.progressBarT.visibility == View.VISIBLE) {
                binding.progressBarT.visibility = View.GONE
            }
        }

        binding.previousbtn.setOnClickListener {
            if(args.pos!=0) {
                stop()
                val pos = args.pos - 1
                val action =
                    Surya_Step_Description_FragmentDirections.actionSuryaStepDescriptionFragmentSelf(pos)
                findNavController().navigate(action)
            }
            else{
                Toast.makeText(activity, "This is the first step", Toast.LENGTH_SHORT).show()
            }
        }

        binding.Nextbtn.setOnClickListener {
            if(args.pos!=11){
                stop()
            val pos = args.pos + 1
            val action = Surya_Step_Description_FragmentDirections.actionSuryaStepDescriptionFragmentSelf(pos)
            findNavController().navigate(action)
        }
        else{
            Toast.makeText(activity, "This is the last step", Toast.LENGTH_SHORT).show()
        }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            val result = tts.setLanguage(Locale.US)
            if ( result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(activity,"language not supported",Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(activity,"failed",Toast.LENGTH_SHORT).show()
        }
    }
    private fun speak() {
        val text =  stepdescription[args.pos].toString()
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onDestroy() {
        tts.stop()
        tts.shutdown()
        super.onDestroy()
    }
    fun stop(){
        tts.stop()
    }
}

