package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class Question6 : AppCompatActivity() {
    private var wrongAnswerCounter = 0 // Counter for wrong answers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.insidequiz)

        val mainLayout: ConstraintLayout = findViewById(R.id.mainLayout)
        mainLayout.setBackgroundResource(R.drawable.blood_background)
        val questionView: TextView = findViewById(R.id.chigibam)
        questionView.setTextColor(Color.parseColor("#114b7f"))

        val panicButton = findViewById<Button>(R.id.panicButton)
        panicButton.setOnClickListener {
            rightThingToPanicDialogue()
        }
        val pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.pulsation_animation_extra)
        panicButton.startAnimation(pulseAnimation)

        val ans1 = findViewById<TextView>(R.id.answerText1)
        val ans2 = findViewById<TextView>(R.id.answerText2)
        val ans3 = findViewById<TextView>(R.id.answerText3)
        val ans4 = findViewById<TextView>(R.id.answerText4)
        val answer1: CardView = findViewById(R.id.answer1)
        val answer2: CardView = findViewById(R.id.answer2)
        val answer3: CardView = findViewById(R.id.answer3)
        val answer4: CardView = findViewById(R.id.answer4)
        val question = findViewById<TextView>(R.id.chigibam)
        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.visibility = Button.INVISIBLE
        nextButton.isEnabled = false // Disable nextButton initially

        // Set question and answers
        question.text = "WW̷h̵a̵t̸'̵s̸ ̶y̶o̴u̵r̸ ̶g̷o̵-̶t̸o̸ ̴d̴r̴i̷n̸k̷?̸"
        ans1.text = "T̴h̸e̶ ̵t̵h̸i̵c̴k̸ ̵b̵l̴a̵c̴k̵ ̶l̶i̸q̸u̸i̵d̷ ̸t̷h̵a̵t̶ ̷s̶e̶e̷p̴s̸ ̸t̷h̵r̵o̶u̶g̶h̷ ̵m̶y̵ ̸w̵a̵l̸l̵s̶ ̷w̴h̸e̶n̸ ̷I̸ ̴a̸n̶s̴w̵e̷r̴ ̶q̵u̵e̷s̶t̸i̶o̵n̴s̴ ̸i̷n̶c̴o̸r̷r̸e̶c̶t̴l̶y̸"
        ans2.text = "C̴o̵f̷f̴e̷e̶"
        ans3.text = "W̶a̶t̴e̵r̷"
        ans4.text = "W̸h̴a̵t̸'̴s̸ ̷t̷h̶i̶s̵?̶ ̸I̴ ̴d̸o̴n̴'̵t̸ ̶r̶e̷m̴e̴m̷b̵e̷r̶ ̴p̸u̶t̴t̵i̵n̷g̵ ̷t̴h̵e̷ ̴c̵u̴p̵ ̶h̸e̵r̸e̸.̴.̵.̵"

        var selectedAnswer: CardView? = null

        // Set click listeners for answers
        answer1.setOnClickListener {
            selectedAnswer = handleAnswerClick(selectedAnswer, answer1, nextButton)

                handleWrongAnswerClick()

        }

        answer2.setOnClickListener {
            selectedAnswer = handleAnswerClick(selectedAnswer, answer2, nextButton)

                handleWrongAnswerClick()

        }

        answer3.setOnClickListener {
            selectedAnswer = handleAnswerClick(selectedAnswer, answer3, nextButton)

            handleWrongAnswerClick()

        }

        answer4.setOnClickListener {
            selectedAnswer = handleAnswerClick(selectedAnswer, answer4, nextButton)
            handleWrongAnswerClick()
        }

        // Next button click listener
        nextButton.setOnClickListener {
            val intent = Intent(this, Question7::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun handleWrongAnswerClick() {
        // Increment the wrong answer counter
        wrongAnswerCounter++

        // Show wrong answer dialog
        wrongAnswerDialog()

        // Enable nextButton if counter reaches 3
        if (wrongAnswerCounter >= 3) {
            findViewById<Button>(R.id.nextButton).isEnabled = true
        }
    }

    private fun handleAnswerClick(selectedAnswer: CardView?, newAnswer: CardView, nextButton: Button): CardView {
        // Deselect the previously selected answer
        selectedAnswer?.background = ContextCompat.getDrawable(this, R.drawable.default_answer_background)

        // Select the new answer
        newAnswer.background = ContextCompat.getDrawable(this, R.drawable.evil_glow_effect)

        // Update next button visibility
        nextButton.visibility = Button.VISIBLE

        // Return the newly selected answer
        return newAnswer
    }

    private fun wrongAnswerDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.it_doesnt_even_matter, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val okButton: Button = dialogView.findViewById(R.id.okButton)
        okButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun rightThingToPanicDialogue() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.right_thing_to_panic_dialogue, null)
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