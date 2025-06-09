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
public final class JournalViewModel_Factory implements Factory<JournalViewModel> {
  private final Provider<MealRepository> mealRepositoryProvider;

  public JournalViewModel_Factory(Provider<MealRepository> mealRepositoryProvider) {
    this.mealRepositoryProvider = mealRepositoryProvider;
  }

  @Override
  public JournalViewModel get() {
    return newInstance(mealRepositoryProvider.get());
  }

  public static JournalViewModel_Factory create(Provider<MealRepository> mealRepositoryProvider) {
    return new JournalViewModel_Factory(mealRepositoryProvider);
  }

  public static JournalViewModel newInstance(MealRepository mealRepository) {
    return new JournalViewModel(mealRepository);
  }
}
