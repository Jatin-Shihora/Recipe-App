package com.example.reciepe_app_kt.presentation.ui.recipe_list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel
// constructor needed to inject dependencies into ViewModel
//    @ViewModelInject //deprecated; use @HiltViewModel and @Inject instead
@Inject
constructor(private val randomString:String) : ViewModel()
{
    init {
        println("VIEWMODEL:${randomString} ")
    }
}