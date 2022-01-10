package com.example.reciepe_app_kt.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.reciepe_app_kt.presentation.components.RecipeCard
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

                Column{
                    TextField(value = query,
                        //value = _query.value,
                        onValueChange = { newValue ->
                            viewModel.onQueryChanged(newValue)
                            //_query.value = newValue
                        },
                    )
                    Spacer(modifier = Modifier.padding(10.dp))


                    //LazyColumn is the equivalent compose.ui of RecyclerView
                    LazyColumn{
                        itemsIndexed(
                            items=recipes
                        ){
                                index, recipe-> RecipeCard(recipe = recipe, onClick = {})
                        }
                    }

                }
            }
        }
    }
}