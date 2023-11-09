package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.healthcare.databinding.ActivityFindDoctorBinding

class FindDoctorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFindDoctorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardFDBack.setOnClickListener {
            val signupIntent = Intent(this, HomeActivity::class.java)
            startActivity(signupIntent)
        }
    }
}
