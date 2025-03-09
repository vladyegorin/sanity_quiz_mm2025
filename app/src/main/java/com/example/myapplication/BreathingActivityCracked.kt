package com.example.myapplication

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class BreathingActivityCracked : AppCompatActivity() {

    private lateinit var breathingCircle: ImageView
    private lateinit var instructionText: TextView
    private lateinit var breathingCircleAnimator: ValueAnimator
    private val handler = Handler(Looper.getMainLooper())
    private var questionCounter: Int = 0 // Variable to store the question counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.breathing)

        // Retrieve the questionCounter from the Intent
        questionCounter = intent.getIntExtra("questionCounter", 0)
        Log.d("BreathingActivityCracked", "questionCounter: $questionCounter")

        breathingCircle = findViewById(R.id.breathingCircle)
        instructionText = findViewById(R.id.instructionText)

        startBreathingAnimation()
    }

    private fun startBreathingAnimation() {
        breathingCircleAnimator = ValueAnimator.ofFloat(1f, 2f).apply {
            duration = 5000
            addUpdateListener { animation ->
                val scale = animation.animatedValue as Float
                breathingCircle.scaleX = scale
                breathingCircle.scaleY = scale
            }
            start()
        }

        instructionText.text = "Breathe In"

        handler.postDelayed({
            instructionText.text = "Hold"
            breathingCircleAnimator.pause()

            handler.postDelayed({
                instructionText.text = "Keep Holding"

                handler.postDelayed({
                    instructionText.text = "Hold Until You Suffocate"

                    handler.postDelayed({
                        // Navigate to ScreamerActivity and pass questionCounter
                        val screamerIntent = Intent(this, ScreamerActivity::class.java)
                        screamerIntent.putExtra("questionCounter", questionCounter)
                        startActivity(screamerIntent)
                        finish() // Finish BreathingActivityCracked to prevent going back
                    }, 2000) // Delay for "Hold Until You Suffocate"
                }, 1000) // Delay for "Keep Holding"
            }, 1000) // Delay for "Hold"
        }, 5000) // Delay for "Breathe In"
    }

    override fun onPause() {
        super.onPause()
        // Cancel all pending Handler tasks when the activity is paused
        handler.removeCallbacksAndMessages(null)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancel all pending Handler tasks when the activity is destroyed
        handler.removeCallbacksAndMessages(null)
        breathingCircleAnimator.cancel()
    }
}