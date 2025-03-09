package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ScreamerActivity : AppCompatActivity() {

    private var questionCounter: Int = 0 // Variable to store the question counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.dog_screamer)

        // Retrieve the questionCounter from the Intent
        questionCounter = intent.getIntExtra("questionCounter", 0)

        // Find the ImageView using findViewById
        val screamerImageView = findViewById<ImageView>(R.id.screamerImageView)

        // Load the GIF using Glide
        Glide.with(this)
            .asGif()
            .load(R.drawable.download) // Replace with your GIF file name
            .into(screamerImageView)

        // Delay for 2 seconds (2000 milliseconds)
        Handler(Looper.getMainLooper()).postDelayed({
            // Determine which activity to navigate to based on questionCounter
            val nextIntent = when (questionCounter) {
                5 -> Intent(this, Question5::class.java)
                6 -> Intent(this, Question6::class.java)
                else -> null // Default case, do nothing
            }

            // Start the next activity if the intent is not null
            nextIntent?.let {
                startActivity(it)
                finish() // Finish ScreamerActivity so the user can't go back
            }
        }, 2000) // 2-second delay
    }
}