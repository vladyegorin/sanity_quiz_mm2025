package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class Question7 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.insidequiz)

        val panicButton = findViewById<Button>(R.id.panicButton)
        panicButton.visibility = Button.INVISIBLE

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
        question.text = "How many colors are in a rainbow?"
        ans1.text = "6" // Empty
        ans2.text = "4" // Empty
        ans3.text = "8" // Empty
        ans4.text = "7" // Initially shows "4"

        // Set click listener for the 4th CardView
        answer4.setOnClickListener {
            answer1.visibility = CardView.INVISIBLE
            answer2.visibility = CardView.INVISIBLE
            answer3.visibility = CardView.INVISIBLE
            answer4.visibility = CardView.INVISIBLE
            goNuts()
        }
    }




    private fun goNuts() {

        val mainLayout: androidx.constraintlayout.widget.ConstraintLayout = findViewById(R.id.mainLayout)
        mainLayout.setBackgroundResource(R.drawable.too_late)


        var toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Ḿ̵̬͔̂̏͠y̵̢̡̨̫͔̻͖͕͊̍͋̍̂̍̈͝ ̴̮̹͇̬͉͍͎̪͐̈́̈́̾̏̇́͝l̶͙̳̤̦̟̝̔͗̍̽́̑̄̃͘͜͜ą̸͔̲͐̊̔͛̉̕̕s̶̟̖̪̿͂̀t̸̨̉̂̊̄́̕ ̵͇̊̽̾̎͑̅̾̍q̴̧̡̼̜͆̒͐̒͂͌̌͛͗u̵̘̱͍͚̙͈͎̥͒̍̏͌̍̾̅̀̎͜͠ͅi̵̢̛̺͉͔̬̒̓̓͂̀ź̶̢̳̘͈̬̥̙̬͙͘͜͝!̵̢̛̘͓̳̠͇͊̈́̽̿̑͌̾͜"

        val question = findViewById<TextView>(R.id.chigibam)
        question.visibility = TextView.INVISIBLE

        android.os.Handler(Looper.getMainLooper()).postDelayed({//crashes the app
            finishAffinity()
            System.exit(0)
        }, 3000)
    }
}