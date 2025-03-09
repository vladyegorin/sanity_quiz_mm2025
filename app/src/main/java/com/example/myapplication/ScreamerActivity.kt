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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.dog_screamer)

        // Find the ImageView using findViewById
        val screamerImageView = findViewById<ImageView>(R.id.screamerImageView)

        // Load the GIF using Glide
        Glide.with(this)
            .asGif()
            .load(R.drawable.download) // Replace with your GIF file name
            .into(screamerImageView)

        // Delay for 8 seconds (8000 milliseconds)
        Handler(Looper.getMainLooper()).postDelayed({
            // Navigate back to Question2
            val intent = Intent(this, Question2::class.java)
            startActivity(intent)
            finish() // Finish ScreamerActivity so the user can't go back
        }, 4000)
    }
}