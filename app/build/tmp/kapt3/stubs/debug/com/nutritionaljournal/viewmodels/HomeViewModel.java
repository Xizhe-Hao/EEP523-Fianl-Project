package com.nutritionaljournal.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.nutritionaljournal.models.Meal;
import com.nutritionaljournal.models.NutritionalSummary;
import com.nutritionaljournal.repositories.MealRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/nutritionaljournal/viewmodels/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "mealRepository", "Lcom/nutritionaljournal/repositories/MealRepository;", "(Lcom/nutritionaljournal/repositories/MealRepository;)V", "_nutritionalSummary", "Landroidx/lifecycle/MutableLiveData;", "Lcom/nutritionaljournal/models/NutritionalSummary;", "_todayMeals", "", "Lcom/nutritionaljournal/models/Meal;", "_totalCalories", "", "nutritionalSummary", "Landroidx/lifecycle/LiveData;", "getNutritionalSummary", "()Landroidx/lifecycle/LiveData;", "todayMeals", "getTodayMeals", "totalCalories", "getTotalCalories", "loadNutritionalSummary", "", "startTime", "", "endTime", "loadTodayMeals", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.nutritionaljournal.repositories.MealRepository mealRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.nutritionaljournal.models.Meal>> _todayMeals = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.nutritionaljournal.models.Meal>> todayMeals = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Double> _totalCalories = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Double> totalCalories = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.nutritionaljournal.models.NutritionalSummary> _nutritionalSummary = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.nutritionaljournal.models.NutritionalSummary> nutritionalSummary = null;
    
    @javax.inject.Inject
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    com.nutritionaljournal.repositories.MealRepository mealRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.nutritionaljournal.models.Meal>> getTodayMeals() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Double> getTotalCalories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.nutritionaljournal.models.NutritionalSummary> getNutritionalSummary() {
        return null;
    }
    
    public final void loadTodayMeals(long startTime, long endTime) {
    }
    
    public final void loadNutritionalSummary(long startTime, long endTime) {
    }
}