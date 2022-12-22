package com.denicks21.switchlanguage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val langBtn = findViewById<Button>(R.id.btnButton)
        langBtn.setOnClickListener {
            startActivity(Intent(this, LanguageButton::class.java))
        }

        val spinnerBtn = findViewById<Button>(R.id.btnSpinner)
        spinnerBtn.setOnClickListener {
            startActivity(Intent(this, LanguageSpinner::class.java))
        }
    }
}