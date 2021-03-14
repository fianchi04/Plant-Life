package com.fianchi.plantlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class AddPlantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plant)

        val addTypes = resources.getStringArray(R.array.Add_Types)

        val spinner: Spinner = findViewById<Spinner>(R.id.addTypeSpinner)

        if(spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, addTypes)
            spinner.adapter = adapter
        }
    }


}