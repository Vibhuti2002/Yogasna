package com.yogaapp.yogasna.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.yogaapp.yogasna.databinding.FragmentCategoryDescriptionBinding
import java.io.File
import java.util.*

class CategoryDescription : Fragment(), TextToSpeech.OnInitListener {
    private val args by navArgs<CategoryDescriptionArgs>()
    private lateinit var binding: FragmentCategoryDescriptionBinding
    private lateinit var desText:String
    private lateinit var storageRef : StorageReference
    private lateinit var tts : TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tts = TextToSpeech(activity,this)
        val heading = arrayOf("Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5", "Exercise 6", "Exercise 7")
        val warmupDescription = arrayOf("des ex warmup 1", "desc ex2", "des ex3", "des ex 4", "des ex5")

        val strengthDescription = arrayOf("Yoga is the perfect practice for building core strength, and Three-Legged Dog Pose might just be the ideal asana.The positioning of the pose means that you’re not only building strength through your core but you’re also on your way to stronger arms.Three-Legged Dog Pose is thought to be great for toning too, especially your hips and thighs so it would make a wonderful addition to yourregular yoga strength training.",
        "There are many different strength-building yoga routines that allow you to get the most from the Warrior III asana.This is one seriously powerful pose that enables you to build strength throughout your whole body, thanks to the backwardand forward folding motion.As well as strength building, Warrior III can also help you with your balance and posture.",
        "Enjoy stronger legs with regular practice of the Revolved Half Moon Pose.See improvements in your lower body strength and the twist in the core muscles that creates a toning effect.Yogis also feel that the pose is a great mood booster, so you can benefit from both a stronger body and a stronger mind.",
        "Another core building asana is Boat Pose. AcroYoga instructor Daniel Scott explains that not only is Boat Pose good for your core strength,but it can also help your digestion. Benefits can be seen in the strength of your lower back too making it ideal if you’re looking for yogaposes to help with back pain.",
        "We know Bridge Pose can improve your flexibility, but it’s also powerful when you’re practicing yoga for strength. Beginners mightinitially struggle with Setu Bandha Sarvangasana as it does take a lot of strength. However with regular practice you’ll soon see your power begin to build and enjoy rewards in your back strength.",
        "Mountain Pose might look like one of the most simple beginner’s yoga poses, however it offers a world of advantages if you’retrying to get a stronger body through yoga. Regular practice can help you build strength throughout your legs, from your ankles toyour thighs. Trusted yogi Travis Eliot in his book A Journey into Yin Yoga highlights the value of the Mountain Pose series, encouragingthose practicing to take each stage slowly to allow you to feel the full rewards of the pose.",
        "Revolved Single Angle Pose is another challenging asana, so perfect for experienced yogis that really want to work on building theirstrength further.Greater flexibility in the spine is one of the huge benefits of the pose. It’s thought that the twist through the coremuscles delivers a deep stretch.Plus as you enter the pose through a lunge it helps to elongate and stretch the spine.")

        val stretchImage = arrayOf("bridge pose", "cat pose", "child's pose", "downward dog", "pigeon pose", "triangle pose", "warrior II")
        val strenghImage = arrayOf("Three-Legged Dog Pose","Warrior III","Revolved Half Moon Pose","Boat Pose","Bridge Pose","Mountain Pose","Revolved Side Angle Pose")

        val stretchDescription = arrayOf("We know Bridge Pose can improve your flexibility, but it’s also powerful when you’re practicing yoga for strength.Beginners might initially struggle with Setu Bandha Sarvangasana as it does take a lot of strength.However with regular practice you’ll soon see your power begin to build and enjoy rewards in your back strength.",
            "Cat pose is an easy forward-kneeling pose, that is used as a warm-up pose to prepare the body for higher level and intense Yoga practices. In cat pose, a gentle stretch begins from the neck to the lower back that makes our core muscles work together. Thus, It mainly tones the core & spinal muscles and increases their flexibility.",
            "Child's Pose is yoga's most important resting posture and it is a nice way to gently stretch various parts of your body. It's a chance to stop what you are doing, reassess your position, reconnect with your breath, and prepare yourself to move forward. Child's Pose is a gentle stretch for the back, hips, thighs, and ankles. It can help relieve back pain.",
            "Downward Facing Dog stretches the hamstrings and calves, and it strengthens the arms and legs. The pose also helps increase the strength of the external oblique abdominal muscles. As a mild inversion, Downward Dog acts in reverse of the usual forces on your spine and brings more blood flow to your brain. When incorporated into a weekly yoga practice, it may even help relieve chronic back pain.",
            "Pigeon pose specifically works as a hip opener and forward bend, stretching your thighs, groin, back, piriformis, and psoas.The leg extended to the rear gets a stretch of the psoas and other hip flexors. On the other side, the rotators and outer hip are stretched.It is a good antidote to sitting for long periods. It prepares you for seated postures and backbends.",
            "Triangle pose engages every part of the body, strengthens the legs and stretches the groin, hamstrings, and hips, and opens the chest and shoulders.It also challenges and improves balance and stability",
            "Warrior II is a standing yoga pose that enhances strength, stability, and concentration. It’s named after the Hindu mythological warrior,Virabhadra, an incarnation of the god Shiva. Virabhadra was a tall, dark, and fierce deity, depicted with a thousand arms, flaming hair andeyes, and wearing a garland of skulls.")

        val catHeading = heading[args.pos]

        if(args.type==0){
        desText = warmupDescription[args.pos]

        }
        if(args.type==1){
            desText = strengthDescription[args.pos]
            storageRef = FirebaseStorage.getInstance().reference.child("StrengthPoses/${strenghImage[args.pos]}.PNG")
        }
        if(args.type==2){
            desText = stretchDescription[args.pos]
             storageRef = FirebaseStorage.getInstance().reference.child("StretchingPoses/${stretchImage[args.pos]}.PNG")
        }

        val localfile = File.createTempFile("Tempimage", "PNG")

        storageRef.getFile(localfile).addOnSuccessListener {
            if (binding.progressBarT.visibility == View.VISIBLE) {
                binding.progressBarT.visibility = View.GONE
            }
            val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
            binding.ivcategory.setImageBitmap(bitmap)
            speak()
        }.addOnFailureListener {
            Toast.makeText(activity, "Failed to load image", Toast.LENGTH_SHORT).show()
            if (binding.progressBarT.visibility == View.VISIBLE) {
                binding.progressBarT.visibility = View.GONE
            }
        }
        binding.tvCatDes.text = desText
        binding.tvcatHeading.text = catHeading
        binding.stopButton.setOnClickListener {
            stop()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDescriptionBinding.inflate(layoutInflater)
        return binding.root
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
        val text = desText
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