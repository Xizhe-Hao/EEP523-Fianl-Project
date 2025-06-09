package com.nutritionaljournal.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class Meal(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val photoUri: String,
    val calories: Double,
    val protein: Double,
    val carbs: Double,
    val fat: Double,
    val timestamp: Long,
    val latitude: Double,
    val longitude: Double,
    val notes: String = ""
)
