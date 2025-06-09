package com.nutritionaljournal.repositories

import com.nutritionaljournal.database.MealDao
import com.nutritionaljournal.models.Meal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealRepository @Inject constructor(
    private val mealDao: MealDao
) {
    suspend fun insertMeal(meal: Meal): Long {
        return mealDao.insertMeal(meal)
    }
    
    suspend fun updateMeal(meal: Meal) {
        mealDao.updateMeal(meal)
    }
    
    suspend fun deleteMeal(meal: Meal) {
        mealDao.deleteMeal(meal)
    }
    
    suspend fun getMealById(id: Long): Meal? {
        return mealDao.getMealById(id)
    }
    
    fun getAllMeals(): Flow<List<Meal>> {
        return mealDao.getAllMeals()
    }
    
    fun getMealsByDateRange(startTime: Long, endTime: Long): Flow<List<Meal>> {
        return mealDao.getMealsByDateRange(startTime, endTime)
    }
    
    fun getTotalCaloriesForDateRange(startTime: Long, endTime: Long): Flow<Double?> {
        return mealDao.getTotalCaloriesForDateRange(startTime, endTime)
    }
    
    fun getTotalProteinForDateRange(startTime: Long, endTime: Long): Flow<Double?> {
        return mealDao.getTotalProteinForDateRange(startTime, endTime)
    }
    
    fun getTotalCarbsForDateRange(startTime: Long, endTime: Long): Flow<Double?> {
        return mealDao.getTotalCarbsForDateRange(startTime, endTime)
    }
    
    fun getTotalFatForDateRange(startTime: Long, endTime: Long): Flow<Double?> {
        return mealDao.getTotalFatForDateRange(startTime, endTime)
    }
}
