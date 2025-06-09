package com.nutritionaljournal.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nutritionaljournal.R
import com.nutritionaljournal.activities.CameraActivity
import com.nutritionaljournal.adapters.MealAdapter
import com.nutritionaljournal.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var mealAdapter: MealAdapter
    
    // Views
    private lateinit var recyclerViewRecentMeals: RecyclerView
    private lateinit var emptyStateLayout: LinearLayout
    private lateinit var textTotalCalories: TextView
    private lateinit var textProteinValue: TextView
    private lateinit var textFatValue: TextView
    private lateinit var textSugarValue: TextView
    private lateinit var fabCamera: FloatingActionButton
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Initialize views
        recyclerViewRecentMeals = view.findViewById(R.id.recyclerViewRecentMeals)
        emptyStateLayout = view.findViewById(R.id.emptyStateLayout)
        textTotalCalories = view.findViewById(R.id.textTotalCalories)
        textProteinValue = view.findViewById(R.id.textProteinValue)
        textFatValue = view.findViewById(R.id.textFatValue)
        textSugarValue = view.findViewById(R.id.textSugarValue)
        fabCamera = view.findViewById(R.id.fabCamera)
        
        setupRecyclerView()
        setupObservers()
        setupClickListeners()
        
        // Set today's date range for summary
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val startOfDay = calendar.timeInMillis
        
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        calendar.set(Calendar.MILLISECOND, 999)
        val endOfDay = calendar.timeInMillis
        
        viewModel.loadTodayMeals(startOfDay, endOfDay)
        viewModel.loadNutritionalSummary(startOfDay, endOfDay)
    }
    
    private fun setupRecyclerView() {
        mealAdapter = MealAdapter { meal ->
            // Handle meal item click
            // Navigate to meal details
        }
        
        recyclerViewRecentMeals.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mealAdapter
        }
    }
    
    private fun setupClickListeners() {
        fabCamera.setOnClickListener {
            startActivity(Intent(requireContext(), CameraActivity::class.java))
        }
    }
    
    private fun setupObservers() {
        viewModel.todayMeals.observe(viewLifecycleOwner) { meals ->
            mealAdapter.submitList(meals)
            emptyStateLayout.visibility = if (meals.isEmpty()) View.VISIBLE else View.GONE
        }
        
        viewModel.totalCalories.observe(viewLifecycleOwner) { calories ->
            textTotalCalories.text = String.format("%.0f Cal", calories ?: 0.0)
        }
        
        viewModel.nutritionalSummary.observe(viewLifecycleOwner) { summary ->
            if (summary != null) {
                textProteinValue.text = String.format("%.0f g", summary.protein)
                textFatValue.text = String.format("%.0f g", summary.fat)
                // For sugar, we'll use carbs as an approximation since we don't have sugar directly
                textSugarValue.text = String.format("%.0f g", summary.carbs * 0.3) // Approximation
            }
        }
    }
}

