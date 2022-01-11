package com.example.reciepe_app_kt.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reciepe_app_kt.domain.model.Recipe
import com.example.reciepe_app_kt.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
// constructor needed to inject dependencies into ViewModel
//    @ViewModelInject //deprecated; use @HiltViewModel and @Inject instead
@Inject
constructor(
    // [RetrofitService] <- [Repository] <- [ViewModel]
    // repository passed as view model constructor arg
    private val repository: RecipeRepository,
    private @Named("auth_token") val token:String,
    ) : ViewModel() {

        // observe data from repository
        val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())

        //For data persistence we need to declare it in viewModel
        val query = mutableStateOf("")

        val selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)

        var categoryScrollPosition: Int = 0

        init {
            newSearch()
        }

        //get data from repository
        fun newSearch(){
            viewModelScope.launch {
                val result = repository.search(
                    token = token,
                    page = 1,
                    query = query.value,
                )
                recipes.value = result
            }
        }
        //change the value of query here to pass it to RecipeListFragment
        fun onQueryChanged(query:String){
            this.query.value = query
        }

        fun onSelectedCategoryChanged(category: String){
            val newCategory = getFoodCategory(category)
            selectedCategory.value = newCategory
            onQueryChanged(category)
        }

        fun onChangeCategoryScrollPosition(position: Int){
            categoryScrollPosition = position
        }

}