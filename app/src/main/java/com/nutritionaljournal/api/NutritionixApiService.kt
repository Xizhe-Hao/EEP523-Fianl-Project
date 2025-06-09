package com.nutritionaljournal.api

import com.nutritionaljournal.BuildConfig
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface NutritionixApiService {
    
    @Headers(
        "Content-Type: application/json",
        "x-app-id: ${BuildConfig.NUTRITIONIX_APP_ID}",
        "x-app-key: ${BuildConfig.NUTRITIONIX_API_KEY}"
    )
    @POST("v2/natural/nutrients")
    suspend fun getNutrients(@Body request: NutrientsRequest): Response<NutrientsResponse>
}

data class NutrientsRequest(
    val query: String,
    val num_servings: Int = 1,
    val aggregate: String = "serving"
)

data class NutrientsResponse(
    val foods: List<FoodItem>
)

