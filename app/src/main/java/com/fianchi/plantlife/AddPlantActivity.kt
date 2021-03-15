package com.fianchi.plantlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get

class AddPlantActivity : AppCompatActivity() {

    //holds value selected in
    lateinit var selectedAddType: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plant)

        val addTypes = resources.getStringArray(R.array.Add_Types)

        val spinner: Spinner = findViewById<Spinner>(R.id.addTypeSpinner)

        if(spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, addTypes)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedAddType = getString(R.string.selected_add_type)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedAddType = "UNKNOWN"
            }
        }
    }

    fun onSavePlant(view: View) {
        val intent = Intent(this, SaveNewPlantActivity::class.java).apply{
            putExtra("plant_species", findViewById<EditText>(R.id.plantSpecies).text.toString())
            putExtra("plant_name", findViewById<EditText>(R.id.plantName).text.toString())
            putExtra("plant_origin", findViewById<Spinner>(R.id.addTypeSpinner).selectedItem.toString())
        }
        startActivity(intent)
    }




}