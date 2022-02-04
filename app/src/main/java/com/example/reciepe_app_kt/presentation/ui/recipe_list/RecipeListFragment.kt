package com.example.reciepe_app_kt.presentation.ui.recipe_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.reciepe_app_kt.presentation.BaseApplication
import com.example.reciepe_app_kt.presentation.components.CircularIndeterminateProgressBar
import com.example.reciepe_app_kt.presentation.components.RecipeCard
import com.example.reciepe_app_kt.presentation.components.SearchAppBar
import com.example.reciepe_app_kt.presentation.components.ShimmerRecipeCardItem
import com.example.reciepe_app_kt.ui.theme.Reciepe_appktTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*
NOTE: whenever a fragment is marked with entrypoint for dependency injection
the activity i.e hosting the fragment must also be annotated with @AndroidEntryPoint
* */
@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication

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
                //Theming
                Reciepe_appktTheme(
                    darkTheme = application.isDark.value,
                        ) {
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
                                    onChangedCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition,
                                    onToggleTheme = {
                                        application.toggleLightTheme()
                                    }
                                )
                                Box(
                                    modifier = Modifier.fillMaxSize()
                                        .background(color = MaterialTheme.colors.background)
                                ) {

                                    if (loading) {
                                        ShimmerRecipeCardItem(
                                            imageHeight = 250.dp, padding = 8.dp
                                        )
                                    } else {
                                        LazyColumn(modifier = Modifier.padding(8.dp)) {
                                            itemsIndexed(
                                                items = recipes
                                            ) { index, recipe ->
                                                RecipeCard(recipe = recipe, onClick = {})
                                            }
                                        }
                                    }
                                    CircularIndeterminateProgressBar(isDisplayed = loading)
                                }
                            }
                        }
                        }
                    }
                }
            }