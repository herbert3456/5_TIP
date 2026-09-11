package com.example.cw1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        // Inicjowanie kontrolek UI
        val firstname = findViewById<EditText>(R.id.editTextTextfirstname)
        val lastname = findViewById<EditText>(R.id.editTextTextlastname)
        val age = findViewById<EditText>(R.id.editTextNumber)
        val resultText = findViewById<TextView>(R.id.textViewresult)
        val registerButton = findViewById<Button>(R.id.button)
        val imageView = findViewById<ImageView>(R.id.imageView)

        // Obsługa kliknięcia przycisku
        registerButton.setOnClickListener {
            val wiekTekst = age.text.toString()

            if (wiekTekst.isEmpty()) {
                resultText.text = "Proszę wpisać wiek"

                // Nie pokazuj żadnego obrazka
                imageView.visibility = ImageView.GONE

            } else {
                val wiek = wiekTekst.toInt()

                if (wiek >= 18) {
                    resultText.text = "Zarejestrowano"


                    imageView.setImageResource(R.drawable.green)
                    imageView.visibility = ImageView.VISIBLE

                } else {
                    resultText.text =
                        "Nie możesz zapisać się na prawo jazdy nie mając 18 lat"


                    imageView.setImageResource(R.drawable.red)
                    imageView.visibility = ImageView.VISIBLE
                }
            }
        }
    }
}
