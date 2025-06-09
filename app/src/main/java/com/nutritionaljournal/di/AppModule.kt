package com.nutritionaljournal.di

import android.content.Context
import androidx.room.Room
import com.nutritionaljournal.BuildConfig
import com.nutritionaljournal.api.NutritionixApiService
import com.nutritionaljournal.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "nutritional_journal_db"
        ).build()
    }
    
    @Provides
    @Singleton
    fun provideMealDao(database: AppDatabase) = database.mealDao()
    
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("x-app-id", BuildConfig.NUTRITIONIX_APP_ID)
                    .header("x-app-key", BuildConfig.NUTRITIONIX_API_KEY)
                    .method(original.method, original.body)
                
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()
    }
    
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://trackapi.nutritionix.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
    
    @Provides
    @Singleton
    fun provideNutritionixApiService(retrofit: Retrofit): NutritionixApiService {
        return retrofit.create(NutritionixApiService::class.java)
    }
}
