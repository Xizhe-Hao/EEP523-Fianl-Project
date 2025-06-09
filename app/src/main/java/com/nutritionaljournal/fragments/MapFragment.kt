package com.nutritionaljournal.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.OnPointAnnotationClickListener
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import com.nutritionaljournal.R
import com.nutritionaljournal.models.Meal
import com.nutritionaljournal.viewmodels.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapFragment : Fragment() {
    
    private val viewModel: MapViewModel by viewModels()
    
    // Views
    private lateinit var mapView: MapView
    private lateinit var textSelectedLocation: TextView
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Initialize views
        mapView = view.findViewById(R.id.mapView)
        textSelectedLocation = view.findViewById(R.id.textSelectedLocation)
        
        mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS)
        
        setupObservers()
        
        // Load meals for the last week by default
        val endTime = System.currentTimeMillis()
        val startTime = endTime - (7 * 24 * 60 * 60 * 1000) // 7 days ago
        viewModel.loadMealsByDateRange(startTime, endTime)
    }
    
    private fun setupObservers() {
        viewModel.meals.observe(viewLifecycleOwner) { meals ->
            if (meals.isNotEmpty()) {
                addMealMarkersToMap(meals)
                
                // Center map on the most recent meal
                val mostRecent = meals.maxByOrNull { it.timestamp }
                if (mostRecent != null) {
                    centerMapOn(mostRecent.latitude, mostRecent.longitude)
                }
            }
        }
    }
    
    private fun addMealMarkersToMap(meals: List<Meal>) {
        val annotationApi = mapView.annotations
        val pointAnnotationManager = annotationApi.createPointAnnotationManager()
        
        // Clear existing annotations
        pointAnnotationManager.deleteAll()
        
        // Add markers for each meal
        val markerOptions = mutableListOf<PointAnnotationOptions>()
        
        for (meal in meals) {
            val point = Point.fromLngLat(meal.longitude, meal.latitude)
            
            // Create marker options
            val pointAnnotationOptions = PointAnnotationOptions()
                .withPoint(point)
                .withIconImage(getMarkerIconBitmap())
                .withIconSize(1.5)
                .withTextField(meal.name)
                .withTextOffset(listOf(0.0, 1.5))
                .withTextColor("#000000")
                .withTextSize(12.0)
            
            markerOptions.add(pointAnnotationOptions)
        }
        
        // Add all markers to the map at once
        val annotations = pointAnnotationManager.create(markerOptions)
        
        // Set up click listener for markers
        pointAnnotationManager.addClickListener(OnPointAnnotationClickListener { annotation ->
            val clickedMeal = meals.find { meal ->
                val mealPoint = Point.fromLngLat(meal.longitude, meal.latitude)
                mealPoint.longitude() == annotation.point.longitude() &&
                mealPoint.latitude() == annotation.point.latitude()
            }
            
            if (clickedMeal != null) {
                showSelectedLocation(clickedMeal)
            }
            
            true
        })
    }
    
    private fun showSelectedLocation(meal: Meal) {
        textSelectedLocation.text = "${meal.name}\n${meal.calories.toInt()} Cal"
        textSelectedLocation.visibility = View.VISIBLE
    }
    
    private fun getMarkerIconBitmap(): Bitmap {
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.map_marker)
        return if (drawable != null) {
            drawableToBitmap(drawable)
        } else {
            BitmapFactory.decodeResource(resources, R.drawable.map_marker)
        }
    }
    
    private fun drawableToBitmap(drawable: Drawable): Bitmap {
        if (drawable is BitmapDrawable) {
            return drawable.bitmap
        }
        
        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }
    
    private fun centerMapOn(latitude: Double, longitude: Double) {
        val cameraPosition = CameraOptions.Builder()
            .center(Point.fromLngLat(longitude, latitude))
            .zoom(12.0)
            .build()
        
        mapView.getMapboxMap().setCamera(cameraPosition)
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        // No need to clean up binding since we're not using ViewBinding
    }
}

