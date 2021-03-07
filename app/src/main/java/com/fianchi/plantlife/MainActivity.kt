package com.fianchi.plantlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText


const val NAME_NEW_PLANT = "com.fianchi.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun saveNewPlant(view: View) {
        val savePlant = findViewById<EditText>(R.id.editTextTextPersonName)
        val message = savePlant.text.toString()
        val intent = Intent(this, SaveNewPlantActivity::class.java).apply {
            putExtra(NAME_NEW_PLANT, message)
        }
        startActivity(intent)

    }

    fun savePlantToDb(view: View) {

    }

    fun delete(view: View) {
        val intent = Intent(this, DeleteAllPlantActivity::class.java)
        startActivity(intent)
    }
}