package com.nutritionaljournal.utils

import com.nutritionaljournal.api.FoodItem
import com.nutritionaljournal.models.NutritionalInfo

fun FoodItem.toNutritionalInfo(): NutritionalInfo {
    return NutritionalInfo(
        foodName = this.foodName ?: "Unknown Food",
        calories = this.nfCalories ?: 0.0,
        protein = this.nfProtein ?: 0.0,
        carbs = this.nfTotalCarbohydrate ?: 0.0,
        fat = this.nfTotalFat ?: 0.0
    )
}

