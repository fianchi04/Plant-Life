package com.fianchi.plantlife

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.time.Instant

class PlantDatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "PlantDatabase"
        private val TABLE_PLANT = "PLANT"
        private val KEY_ID = "ID"
        private val KEY_NAME = "NAME"
        private val KEY_SPECIES = "SPECIES"
        //private val KEY_CREATE_TS = "CREATED_TIMESTAMP"
        //private val KEY_UPDATE_TS = "UPDATED_TIMESTAMP"
    }


    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_PLANT_TABLE = "CREATE TABLE $TABLE_PLANT($KEY_ID TEXT PRIMARY KEY, $KEY_NAME TEXT, $KEY_SPECIES TEXT)" //, $KEY_CREATE_TS INSTANT, $KEY_UPDATE_TS INSTANT
        db.execSQL(CREATE_PLANT_TABLE)


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PLANT")
        onCreate(db)

    }

    //https://www.javatpoint.com/kotlin-android-sqlite-tutorial
    fun addPlant(plant: Plant): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.apply {
            this.put(KEY_ID, plant.id)
            this.put(KEY_NAME, plant.name)
            this.put(KEY_SPECIES, plant.species)
            //todo: this.put(KEY_CREATE_TS, Instant.now()) figure out timestamps later, can't do instant.now, what do
        }
        val success = db.insert(TABLE_PLANT, null, contentValues)
        db.close()
        return success
    }

    fun viewPlant(): List<Plant> {
        val plantList :ArrayList<Plant> = ArrayList<Plant>()
        val selectAllQuery = "SELECT * FROM $TABLE_PLANT"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        kotlin.runCatching {
            cursor = db.rawQuery(selectAllQuery, null)
        }
                .onFailure {
                    db.execSQL(selectAllQuery)
                    return ArrayList()
                }

        var id: String
        var name: String
        var species: String
        if(cursor!!.moveToFirst()) {
            do {
                id = cursor!!.getString(cursor!!.getColumnIndex("ID"))
                name = cursor!!.getString(cursor!!.getColumnIndex("NAME"))
                species = cursor!!.getString(cursor!!.getColumnIndex("SPECIES"))
                plantList.add(Plant(id, name, species))
            } while (cursor!!.moveToNext())
        }
        cursor!!.close()
        db.close()
        return plantList
    }

    fun deleteAllPlants() {
        val db = this.writableDatabase
        db.delete(TABLE_PLANT, null, null)
        db.close()
    }


    //fun loadHandler(): String {}
//    fun addHandler(plant: Plant) {}
//    fun findHandler(plantName: String) {}
//    fun deleteHandler(id: String): Boolean = false
//    fun updateHandler(id: String, plantName: String): Boolean = false

}