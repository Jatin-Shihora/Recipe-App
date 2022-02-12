package com.example.reciepe_app_kt.presentation.ui.recipe_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.reciepe_app_kt.presentation.BaseApplication
import com.example.reciepe_app_kt.presentation.components.RecipeList
import com.example.reciepe_app_kt.presentation.components.SearchAppBar
import com.example.reciepe_app_kt.ui.theme.Reciepe_appktTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
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

                            val page = viewModel.page.value

                            val scaffoldState = rememberScaffoldState()

                            Scaffold(
                                topBar = {
                                    SearchAppBar(
                                        query = query,
                                        onQueryChanged = viewModel::onQueryChanged, // method references to delegate
                                        onExecuteSearch = //viewModel::onExecuteSearch,
                                         {
                                            if (viewModel.selectedCategory.value?.value == "Milk") {
                                                lifecycleScope.launch {
                                                    scaffoldState.snackbarHostState.showSnackbar(
                                                        message = "Invalid category: MILK!",
                                                        actionLabel = "Hide",
                                                    )
                                                }
                                            } else run {
                                                viewModel.onExecuteSearch()
                                            }
                                        },
                                        scrollPosition = viewModel.categoryScrollPosition,
                                        selectedCategory = selectedCategory,
                                        onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                                        onChangedCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition,
                                        onToggleTheme = {
                                            application.toggleLightTheme()
                                        }
                                    )
                                },
                                scaffoldState = scaffoldState,
                                snackbarHost = {
                                    scaffoldState.snackbarHostState
                                }
                            ) {
                                RecipeList(
                                    loading = loading,
                                    recipes = recipes,
                                    onChangeRecipeScrollPosition = viewModel::onChangeRecipeScrollPosition,
                                    page = page,
                                    nextPage = { viewModel.nextPage() },
                                    scaffoldState = scaffoldState,
                                    //snackbarController = SnackbarControler,
                                    navController = findNavController()
                                )
                            }
                        }
                        }
                    }
                }
            }