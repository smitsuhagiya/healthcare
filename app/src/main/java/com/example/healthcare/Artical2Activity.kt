package com.example.healthcare

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Artical2Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artical2)

        val buttonArtBack2: Button = findViewById(R.id.buttonArtBack2)
        buttonArtBack2.setOnClickListener {
            startActivity(Intent(this, Artical3Activity::class.java))
        }
    }
}