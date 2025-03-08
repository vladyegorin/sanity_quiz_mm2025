package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class RulesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.rules)
        val startQuizButton = findViewById<Button>(R.id.startQuizButton)

        startQuizButton.setOnClickListener {
            showConfirmationDialog()


        }


    }
    private fun showConfirmationDialog() {

        val dialogView = LayoutInflater.from(this).inflate(R.layout.confirmation_dialog, null)


        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()


        val yesButton: ImageView = dialogView.findViewById(R.id.yesButton)
        val noButton: ImageView = dialogView.findViewById(R.id.noButton)


        yesButton.setOnClickListener {

            val intent = Intent(this, InsideQuiz::class.java)
            startActivity(intent)
            finish()
            dialog.dismiss()
        }

        noButton.setOnClickListener {
            dialog.dismiss()
        }


        dialog.show()
    }

}