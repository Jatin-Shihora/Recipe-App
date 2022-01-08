package com.example.reciepe_app_kt.repository

import com.example.reciepe_app_kt.domain.model.Recipe
import com.example.reciepe_app_kt.network.RecipeService
import com.example.reciepe_app_kt.network.model.RecipeDtoMapper

class RecipeRepository_impl(
    // [RetrofitService] <- [Repository] <- [ViewModel]
    // retrofit service passed as repository constructor arg
    private val recipeService: RecipeService,
    private val mapper : RecipeDtoMapper
) : RecipeRepository{

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token, page, query).recipes)
        /*
        //can also be written as
        val result = recipeService.search(token, page, query).recipes
        return mapper.toDomainList(result)
         */
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token,id))
    }

}