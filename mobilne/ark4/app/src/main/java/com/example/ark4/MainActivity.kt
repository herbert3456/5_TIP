package com.example.ark4

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.graphics.Typeface


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rozmiar = findViewById<TextView>(R.id.rozmiar)
        val suwak = findViewById<SeekBar>(R.id.suwak)
        val cytat = findViewById<TextView>(R.id.cytat)
        val przycisk = findViewById<Button>(R.id.przycisk)
        val spinner = findViewById<Spinner>(R.id.spinner)

        val teksty = arrayOf("Dzień dobry", "Good morning", "Buenos dias")
        val style = arrayOf("Normalny", "Pogrubiony", "Kursywa")

        var indeks = 0

        suwak.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    rozmiar.text = "Rozmiar: $progress"
                    cytat.textSize = progress.toFloat()
                }

                override fun onStartTrackingTouch(
                    seekBar: SeekBar?
                ) {}

                override fun onStopTrackingTouch(
                    seekBar: SeekBar?
                ) {}
            }
        )

        przycisk.setOnClickListener {
            indeks++

            if (indeks == 3) {
                indeks = 0
            }

            cytat.text = teksty[indeks]
        }
        spinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            style
        )
        spinner.onItemSelectedListener =
            object : android.widget.AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: android.widget.AdapterView<*>?,
                    view: android.view.View?,
                    position: Int,
                    id: Long
                ) {
                    when (position) {
                        0 -> cytat.setTypeface(null, Typeface.NORMAL)
                        1 -> cytat.setTypeface(null, Typeface.BOLD)
                        2 -> cytat.setTypeface(null, Typeface.ITALIC)
                    }
                }

                override fun onNothingSelected(
                    parent: android.widget.AdapterView<*>?
                ) {}
            }
    }
}
