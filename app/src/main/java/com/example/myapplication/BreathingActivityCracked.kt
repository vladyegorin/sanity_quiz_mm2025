package com.example.myapplication

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class BreathingActivityCracked : AppCompatActivity() {

    private lateinit var breathingCircle: ImageView
    private lateinit var instructionText: TextView
    private lateinit var breathingCircleAnimator: ValueAnimator
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.breathing)

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
            }, 1000)

            handler.postDelayed({
                instructionText.text = "Hold Until You Suffocate"
            }, 1000)

            handler.postDelayed({
                val intent = Intent(this, ScreamerActivity::class.java)
                startActivity(intent)
            }, 6000)

            handler.postDelayed({
                val intent = Intent(this, Question3::class.java)
                startActivity(intent)
                finish()
            }, 7000)
        }, 5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
        breathingCircleAnimator.cancel()
    }
}