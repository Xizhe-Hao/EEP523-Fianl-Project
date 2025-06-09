package com.nutritionaljournal.activities

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.DecelerateInterpolator
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.nutritionaljournal.R

class SplashActivity : AppCompatActivity() {
    
    private lateinit var progressBar: ProgressBar
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        
        // Initialize views
        progressBar = findViewById(R.id.progressBar)
        
        // Animate the progress bar
        ObjectAnimator.ofInt(progressBar, "progress", 0, 100).apply {
            duration = 1500
            interpolator = DecelerateInterpolator()
            start()
        }
        
        // Navigate to MainActivity after delay
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }
}

