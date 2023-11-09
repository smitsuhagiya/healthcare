package com.example.healthcare

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.healthcare.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences: SharedPreferences =
            getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
        val username: String = sharedPreferences.getString("username", "").toString()
        Toast.makeText(this@HomeActivity, "Welcome to Healthcare", Toast.LENGTH_SHORT).show()

        val exit: CardView = binding.cardExit
        exit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()
                startActivity(Intent(this@HomeActivity, LoginActivity::class.java))
            }
        })

        val findDoctor: CardView = binding.cardFindDoctor
        findDoctor.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@HomeActivity, FindDoctorActivity::class.java))
            }
        })

        val cardOrderDetails: CardView = findViewById(R.id.cardOrderDetails)
        cardOrderDetails.setOnClickListener {
            startActivity(Intent(this, BookAppointmentActivity::class.java))
        }

        binding.cardHealthDoctor.setOnClickListener {
            val intent = Intent(this, Artical1Activity::class.java)
            startActivity(intent)
        }
    }
}
