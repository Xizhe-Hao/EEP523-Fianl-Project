package com.nutritionaljournal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nutritionaljournal.R
import com.nutritionaljournal.models.Meal
import java.text.SimpleDateFormat
import java.util.*

class JournalMealAdapter(private val onItemClick: (Meal) -> Unit) : 
    ListAdapter<Meal, JournalMealAdapter.JournalMealViewHolder>(MealDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalMealViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_journal_meal, parent, false)
        return JournalMealViewHolder(view)
    }

    override fun onBindViewHolder(holder: JournalMealViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class JournalMealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textMealType: TextView = itemView.findViewById(R.id.textMealTypeJournal)
        private val textMealLocation: TextView = itemView.findViewById(R.id.textMealLocationJournal)
        private val textMealCalories: TextView = itemView.findViewById(R.id.textMealCaloriesJournal)
        private val imageMeal: ImageView = itemView.findViewById(R.id.imageMealJournal)
        
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(getItem(position))
                }
            }
        }
        
        fun bind(meal: Meal) {
            // Determine meal type based on time
            val mealType = getMealTypeFromTime(meal.timestamp)
            textMealType.text = mealType
            
            // Use meal name as location for now
            textMealLocation.text = meal.name
            
            // Format calories
            textMealCalories.text = String.format("%d Cal", meal.calories.toInt())
            
            // Load image
            Glide.with(itemView.context)
                .load(meal.photoUri)
                .placeholder(R.drawable.placeholder_meal)
                .error(R.drawable.placeholder_meal)
                .centerCrop()
                .into(imageMeal)
        }
        
        private fun getMealTypeFromTime(timestamp: Long): String {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timestamp
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            
            return when {
                hour < 11 -> "Breakfast"
                hour < 16 -> "Lunch"
                else -> "Dinner"
            }
        }
    }
}

