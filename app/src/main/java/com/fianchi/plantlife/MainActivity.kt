package com.fianchi.plantlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


const val NAME_NEW_PLANT = "com.fianchi.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    //add new plant
    fun addNewPlant(view: View) {
        val intent = Intent(this, AddPlantActivity::class.java)
        startActivity(intent)
    }
    fun savePlantToDb(view: View) {

    }

    fun delete(view: View) {
        val intent = Intent(this, DeleteAllPlantActivity::class.java)
        startActivity(intent)
    }
}