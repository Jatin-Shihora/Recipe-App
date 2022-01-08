package com.example.reciepe_app_kt.presentation.ui.recipe_list

import androidx.lifecycle.ViewModel
import com.example.reciepe_app_kt.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
// constructor needed to inject dependencies into ViewModel
//    @ViewModelInject //deprecated; use @HiltViewModel and @Inject instead
@Inject
constructor(
    private val repository: RecipeRepository,
    private @Named("auth_token") val token:String,
    ) : ViewModel() {
    init {
        println("VIEWMODEL:${repository} ")
        println("VIEWMODEL:${token} ")
    }

    fun getRepo() = repository

    fun getToken() = token
}