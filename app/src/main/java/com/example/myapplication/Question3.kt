package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class Question3: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.insidequiz)

        var questionCounter = intent.getIntExtra("questionCounter", 0)

        val panicButton = findViewById<Button>(R.id.panicButton)
        panicButton.setOnClickListener {
            val intent = Intent(this, BreathingActivity::class.java)
            startActivity(intent)
        }
        val pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.pulsation_animation)
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
        nextButton.visibility = Button.INVISIBLE;

        question.setText("What animal says 'meow'?")
        ans1.setText("Dog")
        ans2.setText("Snail")
        ans3.setText("Cat")
        ans4.setText("Aardvark")
        var selectedAnswer: CardView? = null
        answer1.setOnClickListener {
            selectedAnswer = handleAnswerClick(selectedAnswer, answer1, nextButton)
        }

        answer2.setOnClickListener {
            selectedAnswer = handleAnswerClick(selectedAnswer, answer2, nextButton)
        }

        answer3.setOnClickListener {
            selectedAnswer = handleAnswerClick(selectedAnswer, answer3, nextButton)
        }

        answer4.setOnClickListener {
            selectedAnswer = handleAnswerClick(selectedAnswer, answer4, nextButton)
        }
        nextButton.setOnClickListener {
            questionCounter++//add counter to intent
            if (selectedAnswer != null && selectedAnswer == answer3) {
                val intent = Intent(this, Question3::class.java)
                intent.putExtra("questionCounter", questionCounter)
                startActivity(intent)

            } else {
                wrongAnswerDialog()
//                val intent = Intent(this, ScreamerActivity::class.java)
//
//                startActivity(intent)


            }
        }
    }

    private fun wrongAnswerDialog() {

        val dialogView = LayoutInflater.from(this).inflate(R.layout.wrong_answer_dialogue_q3, null)


        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()


        val okButton: Button = dialogView.findViewById(R.id.okButton)


        okButton.setOnClickListener {
            dialog.dismiss()
        }


        dialog.show()
    }

    private fun handleAnswerClick(selectedAnswer: CardView?, newAnswer: CardView, nextButton: Button): CardView {
        // Deselect the previously selected answer
        selectedAnswer?.background = ContextCompat.getDrawable(this, R.drawable.default_answer_background)

        // Select the new answer
        newAnswer.background = ContextCompat.getDrawable(this, R.drawable.glow_effect)

        // Update next button visibility
        nextButton.visibility = Button.VISIBLE

        // Return the newly selected answer
        return newAnswer
    }


}