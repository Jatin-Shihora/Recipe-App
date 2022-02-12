package com.example.reciepe_app_kt.presentation.ui.recipe_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reciepe_app_kt.domain.model.Recipe
import com.example.reciepe_app_kt.repository.RecipeRepository
import com.example.reciepe_app_kt.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


const val PAGE_SIZE = 30


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

        //observer of loading circular bar
        val loading  = mutableStateOf(false)

        //for tracking the page
        val page = mutableStateOf(1)

        private var recipeListScrollPosition = 0 //for scroll position

        init {
            onExecuteSearch()
        }

        //get data from repository
        fun onExecuteSearch(){
            viewModelScope.launch {
                loading.value = true

                resetSearchState()

                delay(1000)

                val result = repository.search(
                    token = token,
                    page = 1,
                    query = query.value,
                )
                recipes.value = result

                loading.value = false
            }
        }

        fun nextPage(){
            viewModelScope.launch {
                //prevent duplicate events due to recompose happening to quickly
                if((recipeListScrollPosition+1) >= (page.value * PAGE_SIZE)){
                    loading.value = true
                    incrementPage()
                    Log.d(TAG, "next page : triggered: ${page.value}")

                    //just to show that pagination api is fast
                    delay(1000)

                    if(page.value>1){
                        val result = repository.search(
                            token = token ,
                            page = page.value,
                            query = query.value
                        )
                        Log.d(TAG ,"nextPage${result}")
                        appendRecipes(result)
                    }
                    loading.value = false
                }
            }
        }

        //Append  new recipes to the current list of recipes
        private fun appendRecipes(recipes: List<Recipe>){
            val current = ArrayList(this.recipes.value)
            current.addAll(recipes)
            this.recipes.value = current
        }

        private fun incrementPage(){
            page.value = page.value+1
        }

        fun onChangeRecipeScrollPosition(position: Int){
            recipeListScrollPosition = position
        }

        private fun resetSearchState() {
            recipes.value = emptyList()
            page.value = 1
            onChangeRecipeScrollPosition(0)
            if (selectedCategory.value?.value != query.value) clearSelectedCategory()
        }

        private fun clearSelectedCategory() {
            selectedCategory.value = null
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