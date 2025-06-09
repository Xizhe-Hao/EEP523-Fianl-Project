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
class JournalViewModel @Inject constructor(
    private val mealRepository: MealRepository
) : ViewModel() {
    
    private val _meals = MutableLiveData<List<Meal>>()
    val meals: LiveData<List<Meal>> = _meals
    
    private val _totalCalories = MutableLiveData<Double>()
    val totalCalories: LiveData<Double> = _totalCalories
    
    private val _nutritionalSummary = MutableLiveData<NutritionalSummary>()
    val nutritionalSummary: LiveData<NutritionalSummary> = _nutritionalSummary
    
    fun loadMealsByDateRange(startTime: Long, endTime: Long) {
        viewModelScope.launch {
            mealRepository.getMealsByDateRange(startTime, endTime).collect { mealList ->
                _meals.value = mealList
            }
        }
    }
    
    fun loadNutritionalSummary(startTime: Long, endTime: Long) {
        viewModelScope.launch {
            // Load total calories
            mealRepository.getTotalCaloriesForDateRange(startTime, endTime).collect { calories ->
                _totalCalories.value = calories ?: 0.0
            }
            
            // Load nutritional summary
            val caloriesFlow = mealRepository.getTotalCaloriesForDateRange(startTime, endTime)
            val proteinFlow = mealRepository.getTotalProteinForDateRange(startTime, endTime)
            val carbsFlow = mealRepository.getTotalCarbsForDateRange(startTime, endTime)
            val fatFlow = mealRepository.getTotalFatForDateRange(startTime, endTime)
            
            // Combine all flows to create nutritional summary
            var calories = 0.0
            var protein = 0.0
            var carbs = 0.0
            var fat = 0.0
            
            caloriesFlow.collect { cal -> calories = cal ?: 0.0 }
            proteinFlow.collect { prot -> protein = prot ?: 0.0 }
            carbsFlow.collect { carb -> carbs = carb ?: 0.0 }
            fatFlow.collect { f -> fat = f ?: 0.0 }
            
            val summary = NutritionalSummary(
                calories = calories,
                protein = protein,
                carbs = carbs,
                fat = fat,
                targetCalories = 2000.0,
                targetProtein = 150.0,
                targetCarbs = 250.0,
                targetFat = 65.0
            )
            
            _nutritionalSummary.value = summary
        }
    }
}

