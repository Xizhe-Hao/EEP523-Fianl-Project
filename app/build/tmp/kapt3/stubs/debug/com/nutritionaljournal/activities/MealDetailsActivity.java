package com.nutritionaljournal.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nutritionaljournal.R;
import com.nutritionaljournal.models.Meal;
import com.nutritionaljournal.viewmodels.MealDetailsViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.*;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\'\u001a\u00020(H\u0002J\u0012\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J-\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.2\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u000201002\u0006\u00102\u001a\u000203H\u0016\u00a2\u0006\u0002\u00104J\b\u00105\u001a\u00020(H\u0002J\b\u00106\u001a\u00020(H\u0002J\b\u00107\u001a\u00020(H\u0002J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$\u00a8\u0006;"}, d2 = {"Lcom/nutritionaljournal/activities/MealDetailsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "buttonCancel", "Landroid/widget/Button;", "buttonSave", "buttonSearch", "Lcom/google/android/material/button/MaterialButton;", "contentLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "currentLocation", "Landroid/location/Location;", "editTextMealName", "Lcom/google/android/material/textfield/TextInputEditText;", "editTextNotes", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "mapThumbnail", "Landroid/widget/ImageView;", "mealImage", "photoUri", "Landroid/net/Uri;", "progressBar", "Landroid/widget/ProgressBar;", "textCalories", "Landroid/widget/TextView;", "textCarbs", "textFat", "textLocation", "textProtein", "textTimestamp", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "viewModel", "Lcom/nutritionaljournal/viewmodels/MealDetailsViewModel;", "getViewModel", "()Lcom/nutritionaljournal/viewmodels/MealDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLastLocation", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "saveMeal", "setupObservers", "setupUI", "updateMapThumbnail", "location", "Companion", "app_debug"})
public final class MealDetailsActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    private androidx.appcompat.widget.Toolbar toolbar;
    private android.widget.ProgressBar progressBar;
    private androidx.constraintlayout.widget.ConstraintLayout contentLayout;
    private android.widget.ImageView mealImage;
    private com.google.android.material.textfield.TextInputEditText editTextMealName;
    private com.google.android.material.button.MaterialButton buttonSearch;
    private android.widget.TextView textTimestamp;
    private android.widget.TextView textLocation;
    private android.widget.ImageView mapThumbnail;
    private android.widget.TextView textCalories;
    private android.widget.TextView textProtein;
    private android.widget.TextView textCarbs;
    private android.widget.TextView textFat;
    private com.google.android.material.textfield.TextInputEditText editTextNotes;
    private android.widget.Button buttonSave;
    private android.widget.Button buttonCancel;
    @org.jetbrains.annotations.Nullable
    private android.net.Uri photoUri;
    @org.jetbrains.annotations.Nullable
    private android.location.Location currentLocation;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "MealDetailsActivity";
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 100;
    @org.jetbrains.annotations.NotNull
    public static final com.nutritionaljournal.activities.MealDetailsActivity.Companion Companion = null;
    
    public MealDetailsActivity() {
        super();
    }
    
    private final com.nutritionaljournal.viewmodels.MealDetailsViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupObservers() {
    }
    
    private final void setupUI() {
    }
    
    private final void getLastLocation() {
    }
    
    private final void updateMapThumbnail(android.location.Location location) {
    }
    
    private final void saveMeal() {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/nutritionaljournal/activities/MealDetailsActivity$Companion;", "", "()V", "LOCATION_PERMISSION_REQUEST_CODE", "", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}