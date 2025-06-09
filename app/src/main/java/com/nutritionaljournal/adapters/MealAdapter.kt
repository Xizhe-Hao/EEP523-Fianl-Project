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

class MealAdapter(private val onItemClick: (Meal) -> Unit) : 
    ListAdapter<Meal, MealAdapter.MealViewHolder>(MealDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_meal, parent, false)
        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textCalories: TextView = itemView.findViewById(R.id.textCalories)
        private val textTime: TextView = itemView.findViewById(R.id.textTime)
        private val imageMeal: ImageView = itemView.findViewById(R.id.imageMeal)
        
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(getItem(position))
                }
            }
        }
        
        fun bind(meal: Meal) {
            // Format calories
            textCalories.text = String.format("%d Cal", meal.calories.toInt())
            
            // Format timestamp
            val dateFormat = SimpleDateFormat("h:mma", Locale.getDefault())
            val date = Date(meal.timestamp)
            textTime.text = dateFormat.format(date)
            
            // Load image
            Glide.with(itemView.context)
                .load(meal.photoUri)
                .placeholder(R.drawable.placeholder_meal)
                .error(R.drawable.placeholder_meal)
                .centerCrop()
                .into(imageMeal)
        }
    }
}

class MealDiffCallback : DiffUtil.ItemCallback<Meal>() {
    override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem == newItem
    }
}

