package com.nutritionaljournal

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NutritionalJournalApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize any app-wide components here
    }
}
