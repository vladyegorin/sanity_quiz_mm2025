package com.example.myapplication

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class InsideQuiz: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.insidequiz)
        val panicButton = findViewById<Button>(R.id.panicButton)
        //30+
        val pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.pulsation_animation)
        //60+
        val pulseAnimationExtra = AnimationUtils.loadAnimation(this, R.anim.pulsation_animation_extra)
        //100
        val pulseAnimation100 = AnimationUtils.loadAnimation(this, R.anim.pulsation_animation_100)
        panicButton.startAnimation(pulseAnimation)
        panicButton.setOnClickListener {
            panicButton.startAnimation(pulseAnimation100)
        }



    }
}