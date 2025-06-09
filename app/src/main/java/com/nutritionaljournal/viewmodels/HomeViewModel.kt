package com.nutritionaljournal.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nutritionaljournal.models.Meal
import com.nutritionaljournal.models.NutritionalSummary
import com.nutritionaljournal.repositories.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mealRepository: MealRepository
) : ViewModel() {
    
    private val _todayMeals = MutableLiveData<List<Meal>>()
    val todayMeals: LiveData<List<Meal>> = _todayMeals
    
    private val _totalCalories = MutableLiveData<Double>()
    val totalCalories: LiveData<Double> = _totalCalories
    
    private val _nutritionalSummary = MutableLiveData<NutritionalSummary>()
    val nutritionalSummary: LiveData<NutritionalSummary> = _nutritionalSummary
    
    fun loadTodayMeals(startTime: Long, endTime: Long) {
        viewModelScope.launch {
            mealRepository.getMealsByDateRange(startTime, endTime).collect { meals ->
                _todayMeals.value = meals
            }
        }
    }
    
    fun loadNutritionalSummary(startTime: Long, endTime: Long) {
        viewModelScope.launch {
            // Get total calories
            var calories = 0.0
            mealRepository.getTotalCaloriesForDateRange(startTime, endTime).collect { value ->
                calories = value ?: 0.0
                _totalCalories.value = calories
            }
            
            // Get macronutrients
            var protein = 0.0
            var carbs = 0.0
            var fat = 0.0
            
            mealRepository.getTotalProteinForDateRange(startTime, endTime).collect { value ->
                protein = value ?: 0.0
            }
            
            mealRepository.getTotalCarbsForDateRange(startTime, endTime).collect { value ->
                carbs = value ?: 0.0
            }
            
            mealRepository.getTotalFatForDateRange(startTime, endTime).collect { value ->
                fat = value ?: 0.0
                
                // Create summary after all data is collected
                _nutritionalSummary.value = NutritionalSummary(
                    calories = calories,
                    protein = protein,
                    carbs = carbs,
                    fat = fat,
                    targetCalories = 2000.0, // Default target calories
                    targetProtein = 50.0,    // Default targets
                    targetCarbs = 250.0,
                    targetFat = 70.0
                )
            }
        }
    }
}

