package com.fianchi.plantlife

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DeleteAllPlantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val plantDatabaseHandler: PlantDatabaseHandler = PlantDatabaseHandler(this)
        plantDatabaseHandler.deleteAllPlants()
    }
}