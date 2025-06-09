# Nutritional Photo Journal Android App

This Android application allows users to track their dietary habits by taking photos of meals, analyzing nutritional content via the Nutritionix API, logging timestamps and locations, and providing daily summaries and map visualizations.

## Project Structure

The project follows a modern Android architecture with MVVM pattern:

- **app**: Main application module
  - **src/main**: Source code
    - **java/com/nutritionaljournal**: Java/Kotlin code
      - **activities**: Main activities (MainActivity, CameraActivity, etc.)
      - **fragments**: UI fragments for different screens
      - **viewmodels**: ViewModels for each screen
      - **models**: Data models
      - **repositories**: Data access layer
      - **api**: API service interfaces and implementations
      - **database**: Room database and DAOs
      - **utils**: Utility classes
    - **res**: Resources
      - **layout**: XML layouts
      - **drawable**: Images and icons
      - **values**: Strings, colors, styles
      - **navigation**: Navigation graphs
  - **build.gradle**: App-level build configuration

## Features

- Camera integration for meal photo capture
- Nutritional analysis via Nutritionix API
- Geolocation and timestamp logging
- Daily nutritional summary
- Map visualization of meal locations
- Local data storage

## Setup Instructions

1. Clone the repository
2. Open the project in Android Studio
3. Add your Nutritionix API key in `local.properties`:
   ```
   nutritionix.api.key=YOUR_API_KEY
   nutritionix.app.id=YOUR_APP_ID
   ```
4. Build and run the application on your device

## Dependencies

- AndroidX Core and AppCompat
- Material Components
- CameraX for camera functionality
- Retrofit for API communication
- Room for local database
- Glide for image loading
- MapBox for map visualization
- Hilt for dependency injection
- LiveData and ViewModel for MVVM architecture
- Coroutines for asynchronous operations

## Permissions Required

- Camera: For taking meal photos
- Internet: For API communication
- Location: For logging meal locations
- Storage: For saving meal photos locally
