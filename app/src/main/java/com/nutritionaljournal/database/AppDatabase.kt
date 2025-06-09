package com.nutritionaljournal.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nutritionaljournal.models.Meal

@Database(entities = [Meal::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDao
}
