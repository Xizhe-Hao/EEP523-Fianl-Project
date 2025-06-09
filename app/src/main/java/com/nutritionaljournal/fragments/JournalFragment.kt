package com.nutritionaljournal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nutritionaljournal.R
import com.nutritionaljournal.adapters.JournalMealAdapter
import com.nutritionaljournal.viewmodels.JournalViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class JournalFragment : Fragment() {
    
    private val viewModel: JournalViewModel by viewModels()
    private lateinit var journalMealAdapter: JournalMealAdapter
    
    // Views
    private lateinit var calendarView: CalendarView
    private lateinit var textTotalCalories: TextView
    private lateinit var textFatValue: TextView
    private lateinit var textProteinValue: TextView
    private lateinit var textSugarValue: TextView
    private lateinit var recyclerViewJournalMeals: RecyclerView
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_journal, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Initialize views
        calendarView = view.findViewById(R.id.calendarView)
        textTotalCalories = view.findViewById(R.id.textTotalCaloriesJournal)
        textFatValue = view.findViewById(R.id.textFatValueJournal)
        textProteinValue = view.findViewById(R.id.textProteinValueJournal)
        textSugarValue = view.findViewById(R.id.textSugarValueJournal)
        recyclerViewJournalMeals = view.findViewById(R.id.recyclerViewJournalMeals)
        
        setupRecyclerView()
        setupCalendarView()
        setupObservers()
        
        // Load today's data by default
        loadDataForDate(System.currentTimeMillis())
    }
    
    private fun setupRecyclerView() {
        journalMealAdapter = JournalMealAdapter { meal ->
            // Handle meal item click
            // Navigate to meal details
        }
        
        recyclerViewJournalMeals.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = journalMealAdapter
        }
    }
    
    private fun setupCalendarView() {
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            loadDataForDate(calendar.timeInMillis)
        }
    }
    
    private fun setupObservers() {
        viewModel.meals.observe(viewLifecycleOwner) { meals ->
            journalMealAdapter.submitList(meals)
        }
        
        viewModel.totalCalories.observe(viewLifecycleOwner) { calories ->
            textTotalCalories.text = String.format("%.0f Cal", calories ?: 0.0)
        }
        
        viewModel.nutritionalSummary.observe(viewLifecycleOwner) { summary ->
            if (summary != null) {
                textFatValue.text = String.format("%.0f g", summary.fat)
                textProteinValue.text = String.format("%.0f g", summary.protein)
                // For sugar, we'll use carbs as an approximation since we don't have sugar directly
                textSugarValue.text = String.format("%.0f g", summary.carbs * 0.3) // Approximation
            }
        }
    }
    
    private fun loadDataForDate(timestamp: Long) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp
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
        
        viewModel.loadMealsByDateRange(startOfDay, endOfDay)
        viewModel.loadNutritionalSummary(startOfDay, endOfDay)
    }
}

