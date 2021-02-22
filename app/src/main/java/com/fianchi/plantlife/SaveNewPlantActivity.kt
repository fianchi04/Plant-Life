package com.fianchi.plantlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class SaveNewPlantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(NAME_NEW_PLANT)

        val plantDatabaseHandler: PlantDatabaseHandler = PlantDatabaseHandler(this)
        val status = plantDatabaseHandler.addPlant(Plant(id = UUID.randomUUID().toString(), message!!, "UNKNOWN SPECIES"))

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text =
                    if (status.equals(-1)) "Failed to save $message to the db"
                    else {
                        """Saved $message to DB
                    All DB entries:
                    ${plantDatabaseHandler.viewPlant().toString()}
                """.trimMargin()
                    }
        }
    }

}