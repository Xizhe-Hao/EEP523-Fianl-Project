package com.nutritionaljournal.di;

import com.nutritionaljournal.api.NutritionixApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class AppModule_ProvideNutritionixApiServiceFactory implements Factory<NutritionixApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideNutritionixApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public NutritionixApiService get() {
    return provideNutritionixApiService(retrofitProvider.get());
  }

  public static AppModule_ProvideNutritionixApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideNutritionixApiServiceFactory(retrofitProvider);
  }

  public static NutritionixApiService provideNutritionixApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideNutritionixApiService(retrofit));
  }
}
