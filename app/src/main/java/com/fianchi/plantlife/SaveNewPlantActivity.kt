package com.fianchi.plantlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class SaveNewPlantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val name = intent.getStringExtra("plant_name")
        val plantDatabaseHandler: PlantDatabaseHandler = PlantDatabaseHandler(this)
        val status = plantDatabaseHandler.addPlant(Plant(
            id = UUID.randomUUID().toString(),
            name!!,
            intent.getStringExtra("plant_species")!!,
            intent.getStringExtra("plant_origin")!!
        ))

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text =
                    if (status.equals(-1)) "Failed to save $name to the db"
                    else {
                        """Saved $name to DB
                    All DB entries:
                    ${plantDatabaseHandler.viewPlant().toString()}
                """.trimMargin()
                    }
        }
    }

}