package com.example.reciepe_app_kt.presentation.ui.recipe

sealed class RecipeEvent {
    data class GetRecipeEvent(
        val id:Int
    ):RecipeEvent()
}