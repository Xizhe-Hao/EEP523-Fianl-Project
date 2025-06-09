package com.nutritionaljournal.viewmodels;

import com.nutritionaljournal.api.NutritionixApiService;
import com.nutritionaljournal.repositories.MealRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class MealDetailsViewModel_Factory implements Factory<MealDetailsViewModel> {
  private final Provider<NutritionixApiService> nutritionixApiServiceProvider;

  private final Provider<MealRepository> mealRepositoryProvider;

  public MealDetailsViewModel_Factory(Provider<NutritionixApiService> nutritionixApiServiceProvider,
      Provider<MealRepository> mealRepositoryProvider) {
    this.nutritionixApiServiceProvider = nutritionixApiServiceProvider;
    this.mealRepositoryProvider = mealRepositoryProvider;
  }

  @Override
  public MealDetailsViewModel get() {
    return newInstance(nutritionixApiServiceProvider.get(), mealRepositoryProvider.get());
  }

  public static MealDetailsViewModel_Factory create(
      Provider<NutritionixApiService> nutritionixApiServiceProvider,
      Provider<MealRepository> mealRepositoryProvider) {
    return new MealDetailsViewModel_Factory(nutritionixApiServiceProvider, mealRepositoryProvider);
  }

  public static MealDetailsViewModel newInstance(NutritionixApiService nutritionixApiService,
      MealRepository mealRepository) {
    return new MealDetailsViewModel(nutritionixApiService, mealRepository);
  }
}
