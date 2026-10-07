package com.example.cw3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
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

        val editNote = findViewById<EditText>(R.id.editNote)
        val btnAdd = findViewById<Button>(R.id.addButton)
        val listNotes = findViewById<ListView>(R.id.listViewNotes)

        // zdefiniowanie adaptera
        val adapterList = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            notes
        )

        // podpiecie adaptera do ListView
        listNotes.adapter = adapterList

        // dodawanie notatki
        btnAdd.setOnClickListener {

            val newNote = editNote.text.toString()

            // dodanie do listy
            notes.add(newNote)

            // odswiezenie ListView
            adapterList.notifyDataSetChanged()

            // wyczyszczenie pola
            editNote.text.clear()
        }
    }
}