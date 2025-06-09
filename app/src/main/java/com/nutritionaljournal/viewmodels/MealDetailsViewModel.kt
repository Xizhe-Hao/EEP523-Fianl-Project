package com.nutritionaljournal.viewmodels

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nutritionaljournal.api.NutrientsRequest
import com.nutritionaljournal.api.NutritionixApiService
import com.nutritionaljournal.models.Meal
import com.nutritionaljournal.models.NutritionalInfo
import com.nutritionaljournal.repositories.MealRepository
import com.nutritionaljournal.utils.toNutritionalInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val nutritionixApiService: NutritionixApiService,
    private val mealRepository: MealRepository
) : ViewModel() {
    
    private val _nutritionalInfo = MutableLiveData<NutritionalInfo>()
    val nutritionalInfo: LiveData<NutritionalInfo> = _nutritionalInfo
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage
    
    private val _saveStatus = MutableLiveData<Boolean>()
    val saveStatus: LiveData<Boolean> = _saveStatus
    
    // This is a placeholder method since we're not using image analysis
    fun analyzeImage(uri: Uri) {
        // Instead of analyzing the image, we'll just set default values
        // The user will enter the food name and we'll get nutritional info when they search
        _nutritionalInfo.value = NutritionalInfo(
            foodName = "Enter food name",
            calories = 0.0,
            protein = 0.0,
            carbs = 0.0,
            fat = 0.0
        )
        _isLoading.value = false
    }
    
    // New method to get nutritional info based on food name
    fun getNutritionalInfo(foodName: String) {
        _isLoading.value = true
        _errorMessage.value = null
        
        viewModelScope.launch {
            try {
                val request = NutrientsRequest(query = foodName)
                val response = nutritionixApiService.getNutrients(request)
                
                if (response.isSuccessful && response.body() != null) {
                    val nutrientsResponse = response.body()!!
                    if (nutrientsResponse.foods.isNotEmpty()) {
                        val foodItem = nutrientsResponse.foods[0]
                        _nutritionalInfo.value = foodItem.toNutritionalInfo()
                    } else {
                        _errorMessage.value = "No nutritional information found for '$foodName'"
                    }
                } else {
                    _errorMessage.value = "Error getting nutritional info: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun saveMeal(meal: Meal) {
        viewModelScope.launch {
            try {
                mealRepository.insertMeal(meal)
                _saveStatus.value = true
            } catch (e: Exception) {
                _errorMessage.value = "Error saving meal: ${e.message}"
                _saveStatus.value = false
            }
        }
    }
}

