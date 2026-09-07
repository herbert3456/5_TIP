package com.example.cw1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cw1.R.id.editTextTextPasswordRepeat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //inicjowanie zmiennych kontrolek UI
        val emailText = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val passwordText = findViewById<EditText>(R.id.editTextTextPassword)
        val passwordRepeatText = findViewById<EditText>(R.id.editTextTextPasswordRepeat)
        val resultText = findViewById<TextView>(R.id.textViewresult)
        val registerButton = findViewById<Button>(R.id.button)

        //obsługa kliknięcia przycisku
        registerButton.setOnClickListener {
            val email = emailText.text.toString()
            val result = ""
            //walidacja adresu
            if(!email.contains("@")){
                resultText.text = "Nieprawidłowy email";
                return@setOnClickListener
            }
            resultText.text = "Witaj $email"
        }
    }
}