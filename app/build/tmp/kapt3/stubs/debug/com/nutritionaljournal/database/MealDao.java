package com.nutritionaljournal.database;

import androidx.room.*;
import com.nutritionaljournal.models.Meal;
import kotlinx.coroutines.flow.Flow;
import java.util.*;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\'J \u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\'J \u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\'J \u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\'J \u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\'J\u0019\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/nutritionaljournal/database/MealDao;", "", "deleteMeal", "", "meal", "Lcom/nutritionaljournal/models/Meal;", "(Lcom/nutritionaljournal/models/Meal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMeals", "Lkotlinx/coroutines/flow/Flow;", "", "getMealById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMealsByDateRange", "startTime", "endTime", "getTotalCaloriesForDateRange", "", "getTotalCarbsForDateRange", "getTotalFatForDateRange", "getTotalProteinForDateRange", "insertMeal", "updateMeal", "app_debug"})
@androidx.room.Dao
public abstract interface MealDao {
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertMeal(@org.jetbrains.annotations.NotNull
    com.nutritionaljournal.models.Meal meal, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateMeal(@org.jetbrains.annotations.NotNull
    com.nutritionaljournal.models.Meal meal, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteMeal(@org.jetbrains.annotations.NotNull
    com.nutritionaljournal.models.Meal meal, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM meals WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMealById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.nutritionaljournal.models.Meal> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM meals ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nutritionaljournal.models.Meal>> getAllMeals();
    
    @androidx.room.Query(value = "SELECT * FROM meals WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nutritionaljournal.models.Meal>> getMealsByDateRange(long startTime, long endTime);
    
    @androidx.room.Query(value = "SELECT SUM(calories) FROM meals WHERE timestamp BETWEEN :startTime AND :endTime")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalCaloriesForDateRange(long startTime, long endTime);
    
    @androidx.room.Query(value = "SELECT SUM(protein) FROM meals WHERE timestamp BETWEEN :startTime AND :endTime")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalProteinForDateRange(long startTime, long endTime);
    
    @androidx.room.Query(value = "SELECT SUM(carbs) FROM meals WHERE timestamp BETWEEN :startTime AND :endTime")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalCarbsForDateRange(long startTime, long endTime);
    
    @androidx.room.Query(value = "SELECT SUM(fat) FROM meals WHERE timestamp BETWEEN :startTime AND :endTime")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalFatForDateRange(long startTime, long endTime);
}