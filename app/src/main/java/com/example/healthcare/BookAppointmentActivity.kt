package com.example.healthcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class BookAppointmentActivity : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etAddress: EditText
    private lateinit var etContactNumber: EditText
    private lateinit var etDate: EditText
    private lateinit var btnBook: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)

        etFullName = findViewById(R.id.etFullName)
        etAddress = findViewById(R.id.etAddress)
        etContactNumber = findViewById(R.id.etContactNumber)
        etDate = findViewById(R.id.etDate)
        btnBook = findViewById(R.id.btnBook)

        dbRef = FirebaseDatabase.getInstance().getReference("patient")

        btnBook.setOnClickListener {
            savePatientData()
        }

        val buttonAppBack: Button = findViewById(R.id.buttonAppBack)
        buttonAppBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun savePatientData() {
        val fullName = etFullName.text.toString()
        val address = etAddress.text.toString()
        val contactNumber = etContactNumber.text.toString()
        val date = etDate.text.toString()

        if (fullName.isEmpty()) {
            etFullName.error = "Please Enter Name"
        }
        if (address.isEmpty()) {
            etAddress.error = "Please Enter Address"
        }
        if (contactNumber.isEmpty()) {
            etContactNumber.error = "Please Enter Contact Number"
        }
        if (date.isEmpty()) {
            etDate.error = "Please Enter Date"
        }

        val patientId = dbRef.push().key!!

        val patient = PatientModel(fullName, address, contactNumber, date)

        dbRef.child(patientId).setValue(patient)
            .addOnCompleteListener {
                Toast.makeText(this,"Book Appointment Successfully",Toast.LENGTH_LONG).show()

                etFullName.text.clear()
                etAddress.text.clear()
                etContactNumber.text.clear()
                etDate.text.clear()

            }.addOnFailureListener{err ->
                Toast.makeText(this,"Error ${err.message}",Toast.LENGTH_LONG).show()

            }
    }
}
