package com.nutritionaljournal.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nutritionaljournal.models.Meal
import com.nutritionaljournal.repositories.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val mealRepository: MealRepository
) : ViewModel() {
    
    private val _meals = MutableLiveData<List<Meal>>()
    val meals: LiveData<List<Meal>> = _meals
    
    fun loadMealsByDateRange(startTime: Long, endTime: Long) {
        viewModelScope.launch {
            mealRepository.getMealsByDateRange(startTime, endTime).collect { mealList ->
                _meals.value = mealList
            }
        }
    }
}
