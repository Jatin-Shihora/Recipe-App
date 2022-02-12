package com.example.reciepe_app_kt.presentation.components

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.reciepe_app_kt.R
import com.example.reciepe_app_kt.domain.model.Recipe
import com.example.reciepe_app_kt.presentation.ui.recipe_list.PAGE_SIZE

@Composable
fun RecipeList(
    loading:Boolean,
    recipes:List<Recipe>,
    onChangeRecipeScrollPosition:(Int)->Unit,
    page:Int,
    nextPage:()->Unit,
    scaffoldState:ScaffoldState,
    //snackbarController: SnackbarController,
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {

        if (loading && recipes.isEmpty()) {
            ShimmerRecipeCardItem(
                imageHeight = 250.dp, padding = 8.dp
            )
        } else {
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                itemsIndexed(
                    items = recipes
                ) { index, recipe ->
                    onChangeRecipeScrollPosition(index)
                    if((index + 1)>= (page * PAGE_SIZE) && !loading){
                        nextPage()
                    }
                    RecipeCard(recipe = recipe,
                        onClick = {
                            if(recipe.id != null){
                                val bundle = Bundle()
                                bundle.putInt("recipeId",recipe.id)
                                navController.navigate(R.id.viewRecipe,bundle)
                            }
                            else{
//                                snackbarController.getScope().launch{
//                                    snackbarController.showSnackbar(
//                                        scaffoldState = scaffoldState,
//                                        message = "Recipe Error",
//                                        actionLabel = "Ok"
//                                    )
//                                }
                            }
                        })
                }
            }
        }
        CircularIndeterminateProgressBar(isDisplayed = loading)
        DefaultSnackbar(snackbarHostState =scaffoldState.snackbarHostState,
            onDismiss = {
                scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}