package com.nutritionaljournal.api;

import com.nutritionaljournal.BuildConfig;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/nutritionaljournal/api/NutritionixApiService;", "", "getNutrients", "Lretrofit2/Response;", "Lcom/nutritionaljournal/api/NutrientsResponse;", "request", "Lcom/nutritionaljournal/api/NutrientsRequest;", "(Lcom/nutritionaljournal/api/NutrientsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface NutritionixApiService {
    
    @retrofit2.http.Headers(value = {"Content-Type: application/json", "x-app-id: 7d830123", "x-app-key: 57d603454ddbab3a400b509abc6c0877"})
    @retrofit2.http.POST(value = "v2/natural/nutrients")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getNutrients(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.nutritionaljournal.api.NutrientsRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.nutritionaljournal.api.NutrientsResponse>> $completion);
}