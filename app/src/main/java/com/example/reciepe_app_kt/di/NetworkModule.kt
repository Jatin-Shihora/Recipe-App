package com.example.reciepe_app_kt.di

import com.example.reciepe_app_kt.network.RecipeService
import com.example.reciepe_app_kt.network.model.RecipeDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeMapper() : RecipeDtoMapper{
        return RecipeDtoMapper()
    }

    // recipe service as top level object (singleton) that lives as long as the app
    // no need to build this object again and can be injected anywhere needed
    @Singleton
    @Provides
    fun provideRecipeService():RecipeService{
        return Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeService::class.java)
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken():String {
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }


}
