package com.nutritionaljournal.models

data class NutritionalSummary(
    val calories: Double,
    val protein: Double,
    val carbs: Double,
    val fat: Double,
    val targetCalories: Double,
    val targetProtein: Double,
    val targetCarbs: Double,
    val targetFat: Double
) {
    val caloriesPercentage: Double
        get() = if (targetCalories > 0) (calories / targetCalories) * 100 else 0.0
    
    val proteinPercentage: Double
        get() = if (targetProtein > 0) (protein / targetProtein) * 100 else 0.0
    
    val carbsPercentage: Double
        get() = if (targetCarbs > 0) (carbs / targetCarbs) * 100 else 0.0
    
    val fatPercentage: Double
        get() = if (targetFat > 0) (fat / targetFat) * 100 else 0.0
}

