package com.example.reciepe_app_kt.repository

import com.example.reciepe_app_kt.domain.model.Recipe

interface RecipeRepository {

    suspend fun search(token:String, page : Int, query: String) : List<Recipe> // returns domain model to UI (not entity or Dto)

    suspend fun get(token: String,id:Int) : Recipe
}