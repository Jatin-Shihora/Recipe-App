package com.example.reciepe_app_kt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.reciepe_app_kt.domain.model.Recipe
import com.example.reciepe_app_kt.network.RecipeService
import com.example.reciepe_app_kt.network.model.RecipeNetworkEntity
import com.example.reciepe_app_kt.network.model.RecipeNetworkMapper
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // build a recipe retrofit service object to access network data
        val service = Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeService::class.java)

        // example request on background thread with IO (instead of Main)
        CoroutineScope(IO).launch {
            val recipe = service.get(
                token = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48",
                id = 583
            )
            Log.d("MainActivity", "onCreate: ${recipe.title}")
        }

        // example mapping of RecipeNetworkEntity <-> Recipe
        val mapper = RecipeNetworkMapper()
        val recipe = Recipe()

        //to the recipe
        val networkEntity : RecipeNetworkEntity = mapper.mapToEntity(recipe)

        //back to the recipe
        val r : Recipe = mapper.mapFromEntity(networkEntity)
    }
}

