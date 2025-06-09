package com.nutritionaljournal.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nutritionaljournal.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var navController: NavController
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize views
        bottomNavigation = findViewById(R.id.bottom_navigation)
        
        // Set up navigation
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        
        // Set up bottom navigation with nav controller
        setupBottomNavigation()
    }
    
    private fun setupBottomNavigation() {
        // Create NavOptions to clear the back stack when switching tabs
        val navOptions = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setPopUpTo(navController.graph.startDestinationId, false)
            .build()
        
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_camera -> {
                    // Launch camera activity
                    startActivity(Intent(this, CameraActivity::class.java))
                    false // Don't update the selected item
                }
                R.id.navigation_home, R.id.navigation_map, R.id.navigation_journal -> {
                    // Navigate to the destination with the navOptions to clear back stack
                    navController.navigate(item.itemId, null, navOptions)
                    true // Update the selected item
                }
                else -> false
            }
        }
        
        // Handle reselection to reset to the root of that tab
        bottomNavigation.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.navigation_camera -> {
                    // Launch camera activity
                    startActivity(Intent(this, CameraActivity::class.java))
                }
                R.id.navigation_home, R.id.navigation_map, R.id.navigation_journal -> {
                    // Pop back stack to the start destination of the current navigation graph
                    val selectedNavOptions = NavOptions.Builder()
                        .setLaunchSingleTop(true)
                        .setPopUpTo(item.itemId, false)
                        .build()
                    navController.navigate(item.itemId, null, selectedNavOptions)
                }
            }
        }
    }
    
    // Handle back button to update the selected menu item
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}

