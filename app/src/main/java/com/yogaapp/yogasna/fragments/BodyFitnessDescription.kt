package com.yogaapp.yogasna.fragments

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.yogaapp.yogasna.R
import com.yogaapp.yogasna.databinding.FragmentBodyFitnessDescriptionBinding
import java.util.*

class BodyFitnessDescription : Fragment(), TextToSpeech.OnInitListener {

    lateinit var binding : FragmentBodyFitnessDescriptionBinding
    private val args by navArgs<BodyFitnessDescriptionArgs>()
    private lateinit var desText:String
    private lateinit var desHead : String
    private lateinit var tts : TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tts = TextToSpeech(activity,this)
        val absWorkoutArrayHeading = arrayOf("Plank", "Mountain Climber", "Reverse Crunch", "Russian twist","Dead Bug", "Leg Raise", "Bird Dog")
        val shoulderWorkoutArrayHeading = arrayOf("Push-ups", "Decline push-ups", "Car driver", "Lateral Raise", "inchworm", "Side plank", "Plank to Down Dog" )
        val armWorkoutArrayHeading = arrayOf("Push-ups","Lateral Raise","Triceps", "Superman with arm extension", "Biceps Curl", "Hammer Curl","Diamond Pushups")
        val chestWorkoutArrayHeading = arrayOf("Push-ups","decline push-up","push-up hold","Mountain Climber","walking plank","Star Jump","Incline push-ups")

        val absWorkoutArray = arrayOf("Start in plank position. Carefully shift your weight to your right forearm (or palm). Extend your left arm straight out in front of you. Hold for three seconds while keeping your core tight. Slowly bring your arm back to starting position. Switch arms and repeat. Do two to three sets of 10 reps.",
             "Pull your right knee into your chest as far as you can. Switch legs, pulling one knee out and bringing the other knee in. Keep your hips down and run your knees in and out as far and as fast as you can. Alternate inhaling and exhaling with each leg change.",
             "Lie down on your back. Plant your feet on the floor, hip-width apart. Bend your knees and place your arms across your chest. Contract your abs and inhale. Exhale and lift your upper body, keeping your head and neck relaxed. Inhale and return to the starting position.",
             "Lie down with your legs bent at the knees. Elevate your upper body so that it creates a V shape with your thighs. Twist your torso to the right, and then reverse the motion, twisting it to the left. Repeat this movement until the set is complete. Proper Form And Breathing Pattern.",
             "Lie on your back and extend your arms and legs toward the ceiling. Lower your right leg and extend your left arm behind your head. Return to the starting position and repeat with the opposite arm and leg. Keep switching sides until the set is complete.",
             "Lie on your back, legs straight and together. Keep your legs straight and lift them all the way up to the ceiling until your butt comes off the floor. Slowly lower your legs back down till they're just above the floor. Hold for a moment. Raise your legs back up. Repeat.",
             "Start on your hands and knees with the hands under the shoulders and the knees under the hips. Extend one leg and the opposite arm at the same time.Pause for 3 to 5 seconds, return to the starting position, and switch sides. Continue alternating sides until set is complete.")
         val shoulderWorkoutArray = arrayOf("Lie face down, with your palms on the floor, next to your shoulders. You can also use a bench. Keeping your back straight, push your hands into the ground so that your torso lifts upwards off the floor. Make sure your hands, wrists, and elbows stay in a straight line throughout the movement. At the top, hold this position for a second and then lower yourself back down to your starting position. Hold this for a second and then repeat the above steps. Keep your core locked as tight as possible throughout. Aim to complete 10 reps.",
             "Get into a push-up position and raise your feet onto a table or chair.  Keep your body and arms straight, palms on the floor, just wider than the shoulders. 3. Slowly lower yourself down to the floor whilst keeping your feet elevated. Hold at the bottom for a second, then push back up. Repeat the sequence. Start with 3 sets of as many reps as possible. Try build up the number of repetitions each week.",
             " Stand with feet shoulder-width apart. Hold a circular heavy object with both hands and extend your arms straight in front of you. As you would turn a steering wheel, turn the weight to the left as far as you can, and then to the right. Make sure to keep your shoulders down. Continue for 1 minute.",
             "Stand with feet shoulder-width apart. Hold a heavy object ( eg - dumbbell) in each hand, with arms by your sides and palms facing in (or hold a band between your hands). Lift your arms out to the sides (forming a T shape) until they’re parallel with the floor.Hold for a second or so, then lower back to the starting position for a count of three. Do 10 reps per set.",
             "Stand with feet hip-width apart and arms by your sides. Keeping core engaged and back straight, hinge at your hips and put your palms on the floor (bend knees if needed).Slowly and carefully walk hands forward into a high plank position, with wrists under shoulders and body in a straight line.Hold for a moment, then walk hands back to feet to complete 1 rep. Do 10 reps per set.",
             "Lie on your right side, with legs stacked. Prop yourself up on your elbow or hand, keeping feet and legs stacked.Hold for up to 1 minute, or as long as you can hold good form. Repeat on the other side.",
             "Start in plank position, with feet hip-width apart. Hinge at hips while keeping your back flat, pushing into Downward Dog. Hold for a breath, then return to plank. That’s 1 rep. Do 10 reps per set.")
         val armWorkoutArray = arrayOf("1. Lie face down, with your palms on the floor, next to your shoulders. You can also use a bench.2. Keeping your back straight, push your hands into the ground so that your torso lifts upwards off the floor. Make sure your hands, wrists, and elbows stay in a straight line throughout the movement.3. At the top, hold this position for a second and then lower yourself back down to your starting position. Hold this for a second and then repeat the above steps.4. Keep your core locked as tight as possible throughout.5. Aim to complete 10 reps.",
             "Stand with feet shoulder-width apart. Hold a heavy object ( eg - dumbbell) in each hand, with arms by your sides and palms facing in (or hold a band between your hands). Lift your arms out to the sides (forming a T shape) until they’re parallel with the floor.Hold for a second or so, then lower back to the starting position for a count of three. Do 10 reps per set.",
             " Triceps dips can be done with a couch, chair, or bench (really any stable surface you’d sit on). Place your hands shoulder-width apart on the chair and move your pelvis and booty forward, giving yourself enough space to dip down. Step your feet forward slightly so your legs are almost straight (but don’t lock those knees!). Slowly lower your body down and then press back up, concentrating on engaging your triceps to lower and lift.",
             " Lie facedown with legs extended and arms bent so elbows are by your sides. Engage shoulders and glutes while lifting arms, chest, and legs off the floor (this is the Superman part). Straighten arms in front of you, then bring them back into the bent position. Lower back down to the starting position.",
             " While standing or sitting, hold a weight in each hand with arms extended toward the floor. Slowly bend your elbows, bringing the weights toward your shoulders. Lower the weights back down to the starting position, making sure elbows and wrists are aligned throughout the movement.",
             "Stand tall with a dumbbell in each hand. Let your arms hang so they’re fully extended, elbows tucked in, palms facing your sides. Keeping your upper arms still, curl the dumbbells up at the same time (only your forearms should move). Contract your biceps, pause, then lower and repeat.","Get down on all fours. Extend your legs so you’re on the balls of your feet. Position your hands closer than shoulder-width apart. Lower your body as far as you can. It’s best if your chest nearly touches the floor. Exhale, then use your triceps to drive yourself up.")
         val chestWorkoutArray = arrayOf("Get down on all fours, placing your hands slightly wider than your shoulders. Straighten your arms and legs. Lower your body until your chest nearly touches the floor. Pause, then push yourself back up. Repeat.",
             "Kneel down with your back to the bench. Put your hands on the floor, shoulders over your wrists and elbows at 45 degrees. Place your feet on top of the bench. Brace your core, glutes, and quads. Bend your elbows and lower your chest to the floor, keeping your back and neck straight. Push into the floor to return to starting position, extending your elbows. Complete 2 to 4 sets of 8 to 20 repetitions.",
             "Assume a push-up position, with hands shoulder-width apart, back straight, and legs locked. Set the shoulders and engage the core. From here, lower yourself under control to the bottom position, and hold the body just a few inches off the ground. Keep the elbows tucked in by the sides and maintain a tight body. Hold for 5-10 seconds and continue.",
             "Pull your right knee into your chest as far as you can. Switch legs, pulling one knee out and bringing the other knee in. Keep your hips down and run your knees in and out as far and as fast as you can. Alternate inhaling and exhaling with each leg change.",
             "Place band around your wrists, get into high plank position with hands directly under the shoulders. Walk right hand forward as far as possible,then bring left hand to meet it, keeping band tense and hands shoulder-width apart. Step left hand back to start, then right hand",
             "Start in a quarter squat position with your back flat, feet together, and palms touching the sides of your lower legs. Jump up, raising your arms and legs out to your sides (your body should form an “X” in mid-air). Land softly with your feet together and immediately lower yourself back into the starting position.",
             "Stand facing the bench, table, or the edge of a bed. Place your hands on the edge of the bench just slightly wider than shoulder width. Your arms are straight but elbows are not locked. Align your feet so that your arms and body are completely straight. Bend your elbows to slowly lower your chest to the edge of the bench while inhaling. Keep your body straight and rigid throughout the movement. Push your body away from the bench until your elbows are extended, but not locked. Exhale as you push up. Keep going with slow, steady repetitions.")

        if (args.headPos==0){
            desText = absWorkoutArray[args.pos]
            desHead = absWorkoutArrayHeading[args.pos]
        }
        if (args.headPos==1){
            desText = shoulderWorkoutArray[args.pos]
            desHead = shoulderWorkoutArrayHeading[args.pos]
        }
        if (args.headPos==2){
            desText = armWorkoutArray[args.pos]
            desHead = armWorkoutArrayHeading[args.pos]
        }
        if (args.headPos==3){
            desText = chestWorkoutArray[args.pos]
            desHead = chestWorkoutArrayHeading[args.pos]
        }
        binding.tvBodyFitnessDes.text = desText
        binding.tvfitnessDesHeading.text = desHead
        binding.speak.setOnClickListener { speak() }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBodyFitnessDescriptionBinding.inflate(layoutInflater)
//        return inflater.inflate(R.layout.fragment_body_fitness_description, container, false)
        return binding.root
    }
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            val result = tts.setLanguage(Locale.US)
            if ( result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(activity,"language not supported", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(activity,"failed", Toast.LENGTH_SHORT).show()
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