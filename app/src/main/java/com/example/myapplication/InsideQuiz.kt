package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class InsideQuiz: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.insidequiz)
        val panicButton = findViewById<Button>(R.id.panicButton)
        var questionCounter = 0;

        //30+
        val pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.pulsation_animation)

        //60+
        val pulseAnimationExtra = AnimationUtils.loadAnimation(this, R.anim.pulsation_animation_extra)

        //100
        val pulseAnimation100 = AnimationUtils.loadAnimation(this, R.anim.pulsation_animation_100)

        panicButton.visibility = Button.VISIBLE;
        //panicButton.startAnimation(pulseAnimation)
        panicButton.setOnClickListener {
            noNeedToPanicDialog()
        }



    }

    private fun noNeedToPanicDialog() {

        val dialogView = LayoutInflater.from(this).inflate(R.layout.no_need_to_panic_dialogue, null)


        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()


        val okButton: Button = dialogView.findViewById(R.id.okButton)


        okButton.setOnClickListener {
            dialog.dismiss()
        }


        dialog.show()
    }
}