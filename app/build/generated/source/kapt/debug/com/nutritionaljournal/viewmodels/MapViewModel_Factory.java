package com.nutritionaljournal.viewmodels;

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
public final class MapViewModel_Factory implements Factory<MapViewModel> {
  private final Provider<MealRepository> mealRepositoryProvider;

  public MapViewModel_Factory(Provider<MealRepository> mealRepositoryProvider) {
    this.mealRepositoryProvider = mealRepositoryProvider;
  }

  @Override
  public MapViewModel get() {
    return newInstance(mealRepositoryProvider.get());
  }

  public static MapViewModel_Factory create(Provider<MealRepository> mealRepositoryProvider) {
    return new MapViewModel_Factory(mealRepositoryProvider);
  }

  public static MapViewModel newInstance(MealRepository mealRepository) {
    return new MapViewModel(mealRepository);
  }
}
