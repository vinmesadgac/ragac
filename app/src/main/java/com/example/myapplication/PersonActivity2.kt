package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class PersonActivity2 : AppCompatActivity() {

    private lateinit var personInfoTextView: TextView
    private lateinit var passwordChangeButton: Button
    private lateinit var logoutButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person2)

        mAuth = FirebaseAuth.getInstance()

        personInfoTextView = findViewById(R.id.personInfoTextView)
        passwordChangeButton = findViewById(R.id.gotoPasswordChangeButton)
        logoutButton = findViewById(R.id.logoutButton)

        personInfoTextView.text = mAuth.currentUser?.uid

        logoutButton.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }

        passwordChangeButton.setOnClickListener {
            startActivity(Intent(this, PasswordChangeActivity2::class.java))
        }

    }
}