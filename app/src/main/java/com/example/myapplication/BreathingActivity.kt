package com.example.myapplication

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class BreathingActivity : AppCompatActivity() {

    private lateinit var breathingCircle: ImageView
    private lateinit var instructionText: TextView
    private lateinit var breathingCircleAnimator: ValueAnimator
    private val handler = Handler(Looper.getMainLooper())
    private var cycleCount = 0

    var questionCounter = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.breathing)
        questionCounter = intent.getIntExtra("questionCounter", 0)
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
                instructionText.text = "Breathe Out"
                breathingCircleAnimator = ValueAnimator.ofFloat(2f, 1f).apply {
                    duration = 5000
                    addUpdateListener { animation ->
                        val scale = animation.animatedValue as Float
                        breathingCircle.scaleX = scale
                        breathingCircle.scaleY = scale
                    }
                    start()
                }

                handler.postDelayed({
                    cycleCount++
                    if (cycleCount < 3) {
                        startBreathingAnimation()
                    } else {
                        if(questionCounter == 3){
                        val intent = Intent(this@BreathingActivity, Question3::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        val intent = Intent(this@BreathingActivity, Question4::class.java)
                        startActivity(intent)
                        finish()
                    }}
                }, 5000)
            }, 3000)
        }, 5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
        breathingCircleAnimator.cancel()
    }
}