package com.example.reciepe_app_kt.presentation.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.reciepe_app_kt.presentation.BaseApplication
import com.example.reciepe_app_kt.presentation.components.CircularIndeterminateProgressBar
import com.example.reciepe_app_kt.presentation.components.DefaultSnackbar
import com.example.reciepe_app_kt.presentation.components.RecipeView
import com.example.reciepe_app_kt.presentation.ui.recipe.RecipeEvent.GetRecipeEvent
import com.example.reciepe_app_kt.ui.theme.Reciepe_appktTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RecipeFragment : Fragment(){

    @Inject
    lateinit var application: BaseApplication

    //private val  snackbarControlller: SnackbarController(lifecycleScope)


    private val viewModel:RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt("recipeId")?.let { recipeId->
            viewModel.onTriggerEvent(GetRecipeEvent(recipeId))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {

                val loading = viewModel.loading.value

                val recipe = viewModel.recipe.value

                val scaffoldState = rememberScaffoldState()

                Reciepe_appktTheme(darkTheme = application.isDark.value) {
                    Scaffold(
                        scaffoldState = scaffoldState,
                        snackbarHost = {
                            scaffoldState.snackbarHostState
                        }
                    ) {
                        Box(modifier = Modifier.fillMaxSize()){
                            if (loading && recipe == null){
                                Text("loading....")
                            }
                            else{
                                recipe?.let {
                                    if (it.id==1){
//                                        snackbarControlller.showSnackbar(
//                                            scaffoldState=scaffoldState,
//                                            message="An error occured with the recipe",
//                                            actionLabel = "OK"
//                                        )
                                    }else{
                                        RecipeView(recipe = it)
                                    }
                                }
                            }
                            CircularIndeterminateProgressBar(isDisplayed = loading)
                            DefaultSnackbar(
                                snackbarHostState = scaffoldState
                                    .snackbarHostState,
                                onDismiss = {
                                    scaffoldState.snackbarHostState
                                        .currentSnackbarData?.dismiss()
                                },
                                modifier = Modifier.align(Alignment.BottomCenter)
                            )
                        }
                    }
                }
            }
        }
    }
}