package com.nutritionaljournal.database

import androidx.room.*
import com.nutritionaljournal.models.Meal
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface MealDao {
    @Insert
    suspend fun insertMeal(meal: Meal): Long
    
    @Update
    suspend fun updateMeal(meal: Meal)
    
    @Delete
    suspend fun deleteMeal(meal: Meal)
    
    @Query("SELECT * FROM meals WHERE id = :id")
    suspend fun getMealById(id: Long): Meal?
    
    @Query("SELECT * FROM meals ORDER BY timestamp DESC")
    fun getAllMeals(): Flow<List<Meal>>
    
    @Query("SELECT * FROM meals WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    fun getMealsByDateRange(startTime: Long, endTime: Long): Flow<List<Meal>>
    
    @Query("SELECT SUM(calories) FROM meals WHERE timestamp BETWEEN :startTime AND :endTime")
    fun getTotalCaloriesForDateRange(startTime: Long, endTime: Long): Flow<Double?>
    
    @Query("SELECT SUM(protein) FROM meals WHERE timestamp BETWEEN :startTime AND :endTime")
    fun getTotalProteinForDateRange(startTime: Long, endTime: Long): Flow<Double?>
    
    @Query("SELECT SUM(carbs) FROM meals WHERE timestamp BETWEEN :startTime AND :endTime")
    fun getTotalCarbsForDateRange(startTime: Long, endTime: Long): Flow<Double?>
    
    @Query("SELECT SUM(fat) FROM meals WHERE timestamp BETWEEN :startTime AND :endTime")
    fun getTotalFatForDateRange(startTime: Long, endTime: Long): Flow<Double?>
}
