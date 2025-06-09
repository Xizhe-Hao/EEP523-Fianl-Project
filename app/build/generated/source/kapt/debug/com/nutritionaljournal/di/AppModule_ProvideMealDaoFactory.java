package com.nutritionaljournal.di;

import com.nutritionaljournal.database.AppDatabase;
import com.nutritionaljournal.database.MealDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideMealDaoFactory implements Factory<MealDao> {
  private final Provider<AppDatabase> databaseProvider;

  public AppModule_ProvideMealDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public MealDao get() {
    return provideMealDao(databaseProvider.get());
  }

  public static AppModule_ProvideMealDaoFactory create(Provider<AppDatabase> databaseProvider) {
    return new AppModule_ProvideMealDaoFactory(databaseProvider);
  }

  public static MealDao provideMealDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMealDao(database));
  }
}
