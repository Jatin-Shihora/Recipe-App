package com.example.reciepe_app_kt.di

import com.example.reciepe_app_kt.network.RecipeService
import com.example.reciepe_app_kt.network.model.RecipeDtoMapper
import com.example.reciepe_app_kt.repository.RecipeRepository
import com.example.reciepe_app_kt.repository.RecipeRepository_impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule{

    @Singleton
    @Provides
    fun provideRecipeRepository(
         recipeService: RecipeService,
         recipeDtoMapper: RecipeDtoMapper
    ):RecipeRepository{
        return RecipeRepository_impl(recipeService,recipeDtoMapper)
    }
}