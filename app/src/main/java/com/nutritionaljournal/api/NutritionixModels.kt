package com.nutritionaljournal.api

import com.google.gson.annotations.SerializedName

/**
 * Response model for Nutritionix API image analysis
 */
data class NutritionixAnalysisResponse(
    @SerializedName("foods")
    val foods: List<FoodItem>
)

/**
 * Food item model from Nutritionix API
 */
data class FoodItem(
    @SerializedName("food_name")
    val foodName: String?,
    
    @SerializedName("nf_calories")
    val nfCalories: Double?,
    
    @SerializedName("nf_protein")
    val nfProtein: Double?,
    
    @SerializedName("nf_total_carbohydrate")
    val nfTotalCarbohydrate: Double?,
    
    @SerializedName("nf_total_fat")
    val nfTotalFat: Double?,
    
    @SerializedName("nf_serving_size_qty")
    val nfServingSizeQty: Double?,
    
    @SerializedName("nf_serving_size_unit")
    val nfServingSizeUnit: String?,
    
    @SerializedName("serving_qty")
    val servingQty: Double?,
    
    @SerializedName("serving_unit")
    val servingUnit: String?,
    
    @SerializedName("serving_weight_grams")
    val servingWeightGrams: Double?,
    
    @SerializedName("photo")
    val photo: Photo?
)

/**
 * Photo model from Nutritionix API
 */
data class Photo(
    @SerializedName("thumb")
    val thumb: String?,
    
    @SerializedName("highres")
    val highres: String?,
    
    @SerializedName("is_user_uploaded")
    val isUserUploaded: Boolean?
)

