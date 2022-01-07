package com.example.reciepe_app_kt.network.responses

import com.example.reciepe_app_kt.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(
    @SerializedName("count")
    var count : Int,

    @SerializedName("results")
    var recipes : List<RecipeDto>

)