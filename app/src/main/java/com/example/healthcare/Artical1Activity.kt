package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Artical1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artical1) // Make sure you have a layout file named activity_artical1.xml

        val buttonArtBack: Button = findViewById(R.id.buttonArtBack)
        buttonArtBack.setOnClickListener {
            startActivity(Intent(this, Artical2Activity::class.java))
        }
    }
}
