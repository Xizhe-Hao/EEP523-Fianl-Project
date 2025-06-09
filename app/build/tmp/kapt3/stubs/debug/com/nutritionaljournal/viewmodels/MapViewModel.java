package com.nutritionaljournal.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.nutritionaljournal.models.Meal;
import com.nutritionaljournal.repositories.MealRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/nutritionaljournal/viewmodels/MapViewModel;", "Landroidx/lifecycle/ViewModel;", "mealRepository", "Lcom/nutritionaljournal/repositories/MealRepository;", "(Lcom/nutritionaljournal/repositories/MealRepository;)V", "_meals", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/nutritionaljournal/models/Meal;", "meals", "Landroidx/lifecycle/LiveData;", "getMeals", "()Landroidx/lifecycle/LiveData;", "loadMealsByDateRange", "", "startTime", "", "endTime", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MapViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.nutritionaljournal.repositories.MealRepository mealRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.nutritionaljournal.models.Meal>> _meals = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.nutritionaljournal.models.Meal>> meals = null;
    
    @javax.inject.Inject
    public MapViewModel(@org.jetbrains.annotations.NotNull
    com.nutritionaljournal.repositories.MealRepository mealRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.nutritionaljournal.models.Meal>> getMeals() {
        return null;
    }
    
    public final void loadMealsByDateRange(long startTime, long endTime) {
    }
}