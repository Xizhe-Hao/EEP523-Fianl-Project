package com.nutritionaljournal.viewmodels;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.nutritionaljournal.api.NutrientsRequest;
import com.nutritionaljournal.api.NutritionixApiService;
import com.nutritionaljournal.models.Meal;
import com.nutritionaljournal.models.NutritionalInfo;
import com.nutritionaljournal.repositories.MealRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\tJ\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/nutritionaljournal/viewmodels/MealDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "nutritionixApiService", "Lcom/nutritionaljournal/api/NutritionixApiService;", "mealRepository", "Lcom/nutritionaljournal/repositories/MealRepository;", "(Lcom/nutritionaljournal/api/NutritionixApiService;Lcom/nutritionaljournal/repositories/MealRepository;)V", "_errorMessage", "Landroidx/lifecycle/MutableLiveData;", "", "_isLoading", "", "_nutritionalInfo", "Lcom/nutritionaljournal/models/NutritionalInfo;", "_saveStatus", "errorMessage", "Landroidx/lifecycle/LiveData;", "getErrorMessage", "()Landroidx/lifecycle/LiveData;", "isLoading", "nutritionalInfo", "getNutritionalInfo", "saveStatus", "getSaveStatus", "analyzeImage", "", "uri", "Landroid/net/Uri;", "foodName", "saveMeal", "meal", "Lcom/nutritionaljournal/models/Meal;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MealDetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.nutritionaljournal.api.NutritionixApiService nutritionixApiService = null;
    @org.jetbrains.annotations.NotNull
    private final com.nutritionaljournal.repositories.MealRepository mealRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.nutritionaljournal.models.NutritionalInfo> _nutritionalInfo = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.nutritionaljournal.models.NutritionalInfo> nutritionalInfo = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _saveStatus = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Boolean> saveStatus = null;
    
    @javax.inject.Inject
    public MealDetailsViewModel(@org.jetbrains.annotations.NotNull
    com.nutritionaljournal.api.NutritionixApiService nutritionixApiService, @org.jetbrains.annotations.NotNull
    com.nutritionaljournal.repositories.MealRepository mealRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.nutritionaljournal.models.NutritionalInfo> getNutritionalInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getSaveStatus() {
        return null;
    }
    
    public final void analyzeImage(@org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
    }
    
    public final void getNutritionalInfo(@org.jetbrains.annotations.NotNull
    java.lang.String foodName) {
    }
    
    public final void saveMeal(@org.jetbrains.annotations.NotNull
    com.nutritionaljournal.models.Meal meal) {
    }
}