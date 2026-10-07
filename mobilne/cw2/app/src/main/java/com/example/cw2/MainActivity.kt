package com.example.cw2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
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
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editContact = findViewById<EditText>(R.id.editContact)
        val btnAdd = findViewById<Button>(R.id.addButton)
        val listContact = findViewById<ListView>(R.id.listViewContacts)
        //zdefiniowanie adaptera
        val adapterList = ArrayAdapter<String>(
            this,android.R.layout.simple_list_item_1,contacts
        )
        //podpiecie adaptera do list view
        listContact.adapter = adapterList
        //dodawanie do list view
        btnAdd.setOnClickListener {
            val newContact = editContact.text.trim()
            if (newContact.isEmpty()){
                Toast.makeText(this, "brak danych", Toast.LENGTH_SHORT).show()
            }else{
                //dodanie do list string
                contacts.add(newContact)
                adapterList.notifyDataSetChanged()
                editContact.text.clear()
            }
        }
        listContact.setOnClickListener { parent,view,position }

    }
}