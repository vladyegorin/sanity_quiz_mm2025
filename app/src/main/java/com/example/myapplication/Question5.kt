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

class Question5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.insidequiz)


        val mainLayout: ConstraintLayout = findViewById(R.id.mainLayout)
        mainLayout.setBackgroundResource(R.drawable.blood_background)
        val questionView: TextView = findViewById(R.id.chigibam)
        questionView.setTextColor(Color.parseColor("#114b7f"))

        var questionCounter = 5


        val panicButton = findViewById<Button>(R.id.panicButton)
        panicButton.setOnClickListener {
            val intent = Intent(this, BreathingActivityCracked::class.java)
            intent.putExtra("questionCounter", questionCounter)
            startActivity(intent)
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

        // Set question and answers
        question.text = "W̸h̵a̴t̵'̵s̶ ̴y̷o̵u̷r̴ ̷b̷i̶g̴g̷e̵s̸t̷ ̸f̶e̴a̸r̵?̵"
        ans1.text = "W̸o̶m̴e̷n̶"
        ans2.text = "̶H̶e̷i̸g̴h̸t̶s̶"
        ans3.text = "S̷p̴i̴d̷e̵r̴s̴"
        ans4.text = "A̷n̶s̶w̴e̴r̵i̶n̵g̷ ̶t̷h̵i̶s̸ ̵q̴u̷e̴s̴t̵i̷o̸n̷ ̵i̸n̷c̴o̶r̴r̵e̴c̵t̷l̴y̵"

        var selectedAnswer: CardView? = null


        answer1.setOnClickListener {

            handleAnswerClick(selectedAnswer, answer4, nextButton)
            wrongAnswerDialog()
        }

        answer2.setOnClickListener {

            handleAnswerClick(selectedAnswer, answer4, nextButton)
            wrongAnswerDialog()
        }

        answer3.setOnClickListener {

            handleAnswerClick(selectedAnswer, answer4, nextButton)
            wrongAnswerDialog()
        }

        answer4.setOnClickListener {

            selectedAnswer = handleAnswerClick(selectedAnswer, answer4, nextButton)
        }


        nextButton.setOnClickListener {
            selectedAnswer = answer4;
            if (selectedAnswer == answer4) {

                rightCreepyDialogue()
            } else {
                // Force select ans4 and show wrong answer dialog
                handleAnswerClick(selectedAnswer, answer4, nextButton)
                wrongAnswerDialog()
            }
        }
    }

    private fun wrongAnswerDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.wrong_answer_dialogue_q5, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val okButton: Button = dialogView.findViewById(R.id.okButton)
        okButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun rightCreepyDialogue() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.correct_creepy_answer_q5, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val okButton: Button = dialogView.findViewById(R.id.okButton)
        okButton.setOnClickListener {
            val intent = Intent(this, Question6::class.java)
            startActivity(intent)
            finish()
        }

        dialog.show()
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
}