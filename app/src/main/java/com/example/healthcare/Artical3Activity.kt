package com.example.healthcare

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Artical3Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artical3)

        val buttonArtBack3: Button = findViewById(R.id.buttonArtBack3)
        buttonArtBack3.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}