package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var signInButton: Button
    private lateinit var registrationButton: Button
    private lateinit var passwordResetButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser != null) {
            startActivity(Intent(this, PersonActivity2::class.java))
            finish()
        }

        setContentView(R.layout.activity_main)



        inputEmail = findViewById(R.id.singInEmailEditText)
        inputPassword = findViewById(R.id.signInPasswordEditText)
        signInButton = findViewById(R.id.singInButton)
        registrationButton = findViewById(R.id.gotoRegistrationButton)
        passwordResetButton = findViewById(R.id.gotoPasswordResetButton)

        signInButton.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, PersonActivity2::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        registrationButton.setOnClickListener {
            startActivity(Intent(this, RegistrerActivity2::class.java))
        }

        passwordResetButton.setOnClickListener {
            startActivity(Intent(this, ResetActivity2::class.java))
        }

    }
}