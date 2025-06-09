package com.nutritionaljournal.activities

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.nutritionaljournal.R
import com.nutritionaljournal.models.Meal
import com.nutritionaljournal.viewmodels.MealDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MealDetailsActivity : AppCompatActivity() {
    
    private val viewModel: MealDetailsViewModel by viewModels()
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    
    // Views
    private lateinit var toolbar: Toolbar
    private lateinit var progressBar: ProgressBar
    private lateinit var contentLayout: ConstraintLayout
    private lateinit var mealImage: ImageView
    private lateinit var editTextMealName: TextInputEditText
    private lateinit var buttonSearch: MaterialButton
    private lateinit var textTimestamp: TextView
    private lateinit var textLocation: TextView
    private lateinit var mapThumbnail: ImageView
    private lateinit var textCalories: TextView
    private lateinit var textProtein: TextView
    private lateinit var textCarbs: TextView
    private lateinit var textFat: TextView
    private lateinit var editTextNotes: TextInputEditText
    private lateinit var buttonSave: Button
    private lateinit var buttonCancel: Button
    
    private var photoUri: Uri? = null
    private var currentLocation: Location? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_details)
        
        // Initialize views
        toolbar = findViewById(R.id.toolbar)
        progressBar = findViewById(R.id.progressBar)
        contentLayout = findViewById(R.id.contentLayout)
        mealImage = findViewById(R.id.mealImage)
        editTextMealName = findViewById(R.id.editTextMealName)
        buttonSearch = findViewById(R.id.buttonSearch)
        textTimestamp = findViewById(R.id.textTimestamp)
        textLocation = findViewById(R.id.textLocation)
        mapThumbnail = findViewById(R.id.mapThumbnail)
        textCalories = findViewById(R.id.textCalories)
        textProtein = findViewById(R.id.textProtein)
        textCarbs = findViewById(R.id.textCarbs)
        textFat = findViewById(R.id.textFat)
        editTextNotes = findViewById(R.id.editTextNotes)
        buttonSave = findViewById(R.id.buttonSave)
        buttonCancel = findViewById(R.id.buttonCancel)
        
        // Set up toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        // Get photo URI from intent
        val photoUriString = intent.getStringExtra(CameraActivity.EXTRA_PHOTO_URI)
        if (photoUriString != null) {
            photoUri = Uri.parse(photoUriString)
            mealImage.setImageURI(photoUri)
            
            // Set default values
            viewModel.analyzeImage(photoUri!!)
        }
        
        // Initialize location services
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getLastLocation()
        
        // Set up observers
        setupObservers()
        
        // Set up UI interactions
        setupUI()
    }
    
    private fun setupObservers() {
        // Observe nutritional analysis results
        viewModel.nutritionalInfo.observe(this) { nutritionalInfo ->
            if (nutritionalInfo != null) {
                progressBar.visibility = View.GONE
                contentLayout.visibility = View.VISIBLE
                
                // Populate UI with nutritional info
                if (nutritionalInfo.foodName != "Enter food name") {
                    editTextMealName.setText(nutritionalInfo.foodName)
                }
                textCalories.text = getString(R.string.calories_value, nutritionalInfo.calories)
                textProtein.text = getString(R.string.protein_value, nutritionalInfo.protein)
                textCarbs.text = getString(R.string.carbs_value, nutritionalInfo.carbs)
                textFat.text = getString(R.string.fat_value, nutritionalInfo.fat)
            }
        }
        
        // Observe loading state
        viewModel.isLoading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            buttonSearch.isEnabled = !isLoading
            buttonSave.isEnabled = !isLoading
        }
        
        // Observe error messages
        viewModel.errorMessage.observe(this) { errorMessage ->
            if (errorMessage != null) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
                progressBar.visibility = View.GONE
                contentLayout.visibility = View.VISIBLE
            }
        }
        
        // Observe save status
        viewModel.saveStatus.observe(this) { saved ->
            if (saved) {
                Toast.makeText(this, R.string.meal_saved, Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
    
    private fun setupUI() {
        // Set current timestamp
        val currentTime = Calendar.getInstance().time
        textTimestamp.text = android.text.format.DateFormat.format("yyyy-MM-dd HH:mm", currentTime)
        
        // Set up search button
        buttonSearch.setOnClickListener {
            val foodName = editTextMealName.text.toString()
            if (foodName.isNotBlank()) {
                viewModel.getNutritionalInfo(foodName)
            } else {
                Toast.makeText(this, "Please enter a food name", Toast.LENGTH_SHORT).show()
            }
        }
        
        // Set up save button
        buttonSave.setOnClickListener {
            saveMeal()
        }
        
        // Set up cancel button
        buttonCancel.setOnClickListener {
            finish()
        }
        
        // Set up location display
        mapThumbnail.setOnClickListener {
            // Open full map view (to be implemented)
        }
    }
    
    private fun getLastLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }
        
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    currentLocation = location
                    textLocation.text = getString(
                        R.string.location_coordinates,
                        location.latitude,
                        location.longitude
                    )
                    
                    // Update map thumbnail with location
                    updateMapThumbnail(location)
                }
            }
    }
    
    private fun updateMapThumbnail(location: Location) {
        // In a real app, this would load a static map image
        // For this MVP, we'll just set a placeholder
        mapThumbnail.setImageResource(R.drawable.map_placeholder)
    }
    
    private fun saveMeal() {
        val mealName = editTextMealName.text.toString()
        if (mealName.isBlank()) {
            Toast.makeText(this, R.string.error_meal_name_required, Toast.LENGTH_SHORT).show()
            return
        }
        
        val nutritionalInfo = viewModel.nutritionalInfo.value
        if (nutritionalInfo == null) {
            Toast.makeText(this, R.string.error_nutritional_info_required, Toast.LENGTH_SHORT).show()
            return
        }
        
        val meal = Meal(
            id = 0, // Room will auto-generate
            name = mealName,
            photoUri = photoUri.toString(),
            calories = nutritionalInfo.calories,
            protein = nutritionalInfo.protein,
            carbs = nutritionalInfo.carbs,
            fat = nutritionalInfo.fat,
            timestamp = System.currentTimeMillis(),
            latitude = currentLocation?.latitude ?: 0.0,
            longitude = currentLocation?.longitude ?: 0.0,
            notes = editTextNotes.text.toString()
        )
        
        viewModel.saveMeal(meal)
    }
    
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation()
            } else {
                Toast.makeText(
                    this,
                    R.string.location_permission_denied,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    
    companion object {
        private const val TAG = "MealDetailsActivity"
        private const val LOCATION_PERMISSION_REQUEST_CODE = 100
    }
}

