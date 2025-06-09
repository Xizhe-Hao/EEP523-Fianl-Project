package com.nutritionaljournal.api;

import com.google.gson.annotations.SerializedName;

/**
 * Food item model from Nutritionix API
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0092\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001\u00a2\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u000201H\u00d6\u0001J\t\u00102\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001f\u0010\u0014\u00a8\u00063"}, d2 = {"Lcom/nutritionaljournal/api/FoodItem;", "", "foodName", "", "nfCalories", "", "nfProtein", "nfTotalCarbohydrate", "nfTotalFat", "nfServingSizeQty", "nfServingSizeUnit", "servingQty", "servingUnit", "servingWeightGrams", "photo", "Lcom/nutritionaljournal/api/Photo;", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Lcom/nutritionaljournal/api/Photo;)V", "getFoodName", "()Ljava/lang/String;", "getNfCalories", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getNfProtein", "getNfServingSizeQty", "getNfServingSizeUnit", "getNfTotalCarbohydrate", "getNfTotalFat", "getPhoto", "()Lcom/nutritionaljournal/api/Photo;", "getServingQty", "getServingUnit", "getServingWeightGrams", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Lcom/nutritionaljournal/api/Photo;)Lcom/nutritionaljournal/api/FoodItem;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class FoodItem {
    @com.google.gson.annotations.SerializedName(value = "food_name")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String foodName = null;
    @com.google.gson.annotations.SerializedName(value = "nf_calories")
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double nfCalories = null;
    @com.google.gson.annotations.SerializedName(value = "nf_protein")
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double nfProtein = null;
    @com.google.gson.annotations.SerializedName(value = "nf_total_carbohydrate")
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double nfTotalCarbohydrate = null;
    @com.google.gson.annotations.SerializedName(value = "nf_total_fat")
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double nfTotalFat = null;
    @com.google.gson.annotations.SerializedName(value = "nf_serving_size_qty")
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double nfServingSizeQty = null;
    @com.google.gson.annotations.SerializedName(value = "nf_serving_size_unit")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String nfServingSizeUnit = null;
    @com.google.gson.annotations.SerializedName(value = "serving_qty")
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double servingQty = null;
    @com.google.gson.annotations.SerializedName(value = "serving_unit")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String servingUnit = null;
    @com.google.gson.annotations.SerializedName(value = "serving_weight_grams")
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double servingWeightGrams = null;
    @com.google.gson.annotations.SerializedName(value = "photo")
    @org.jetbrains.annotations.Nullable
    private final com.nutritionaljournal.api.Photo photo = null;
    
    public FoodItem(@org.jetbrains.annotations.Nullable
    java.lang.String foodName, @org.jetbrains.annotations.Nullable
    java.lang.Double nfCalories, @org.jetbrains.annotations.Nullable
    java.lang.Double nfProtein, @org.jetbrains.annotations.Nullable
    java.lang.Double nfTotalCarbohydrate, @org.jetbrains.annotations.Nullable
    java.lang.Double nfTotalFat, @org.jetbrains.annotations.Nullable
    java.lang.Double nfServingSizeQty, @org.jetbrains.annotations.Nullable
    java.lang.String nfServingSizeUnit, @org.jetbrains.annotations.Nullable
    java.lang.Double servingQty, @org.jetbrains.annotations.Nullable
    java.lang.String servingUnit, @org.jetbrains.annotations.Nullable
    java.lang.Double servingWeightGrams, @org.jetbrains.annotations.Nullable
    com.nutritionaljournal.api.Photo photo) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFoodName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getNfCalories() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getNfProtein() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getNfTotalCarbohydrate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getNfTotalFat() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getNfServingSizeQty() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNfServingSizeUnit() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getServingQty() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getServingUnit() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getServingWeightGrams() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.nutritionaljournal.api.Photo getPhoto() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.nutritionaljournal.api.Photo component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.nutritionaljournal.api.FoodItem copy(@org.jetbrains.annotations.Nullable
    java.lang.String foodName, @org.jetbrains.annotations.Nullable
    java.lang.Double nfCalories, @org.jetbrains.annotations.Nullable
    java.lang.Double nfProtein, @org.jetbrains.annotations.Nullable
    java.lang.Double nfTotalCarbohydrate, @org.jetbrains.annotations.Nullable
    java.lang.Double nfTotalFat, @org.jetbrains.annotations.Nullable
    java.lang.Double nfServingSizeQty, @org.jetbrains.annotations.Nullable
    java.lang.String nfServingSizeUnit, @org.jetbrains.annotations.Nullable
    java.lang.Double servingQty, @org.jetbrains.annotations.Nullable
    java.lang.String servingUnit, @org.jetbrains.annotations.Nullable
    java.lang.Double servingWeightGrams, @org.jetbrains.annotations.Nullable
    com.nutritionaljournal.api.Photo photo) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}