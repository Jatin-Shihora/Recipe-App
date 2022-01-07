package com.example.reciepe_app_kt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.reciepe_app_kt.domain.model.Recipe
import com.example.reciepe_app_kt.network.model.RecipeNetworkEntity
import com.example.reciepe_app_kt.network.model.RecipeNetworkMapper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // example mapping of RecipeNetworkEntity <-> Recipe
        val mapper = RecipeNetworkMapper()
        val recipe = Recipe()

        //to the recipe
        val networkEntity : RecipeNetworkEntity = mapper.mapToEntity(recipe)

        //back to the recipe
        val r : Recipe = mapper.mapFromEntity(networkEntity)
    }
}

