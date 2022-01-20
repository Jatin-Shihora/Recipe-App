package com.example.reciepe_app_kt.presentation.ui.recipe_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.reciepe_app_kt.presentation.components.SearchAppBar
import dagger.hilt.android.AndroidEntryPoint

/*
NOTE: whenever a fragment is marked with entrypoint for dependency injection
the activity i.e hosting the fragment must also be annotated with @AndroidEntryPoint
* */
@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    /*NOTE:If we want to share a ViewModel between multiple fragment than
    instead of 'by viewModels() write activityViewModels()
    and copy that same instantiation to that other fragment'*/

    // Instantiate ViewModel inside a single fragment
    val viewModel : RecipeListViewModel by viewModels()

    @SuppressLint("CoroutineCreationDuringComposition")
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply { 
            setContent {
                //Live data reflection
                val recipes = viewModel.recipes.value

                // Mutable data structure that will be passed to the TextField
                val query = viewModel.query.value // from viewModel to persist configuration change
                // another way of persisting data is with savedInstanceState
                //val _query = savedInstanceState{ "Beef" }

                val selectedCategory = viewModel.selectedCategory.value

                val loading  = viewModel.loading.value

                Column{

                    SearchAppBar(
                        query = query,
                        onQueryChanged = viewModel::onQueryChanged, // method references to delegate
                        onExecuteSearch = viewModel::onExecuteSearch,
                        scrollPosition = viewModel.categoryScrollPosition,
                        selectedCategory = selectedCategory,
                        onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                        onChangedCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition
                    )

//                    Box(modifier = Modifier.fillMaxSize()){
//
//                        //LazyColumn is the equivalent compose.ui of RecyclerView
//                        LazyColumn{
//                            itemsIndexed(
//                                items=recipes
//                            ){
//                                    index, recipe-> RecipeCard(recipe = recipe, onClick = {})
//                            }
//                        }
//                        CircularIndeterminateProgressBar(isDisplayed = loading)
//                    }

                }
            }
        }
    }
}