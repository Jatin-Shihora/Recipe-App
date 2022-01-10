package com.example.reciepe_app_kt.presentation.ui.recipe_list

import com.example.reciepe_app_kt.presentation.ui.recipe_list.FoodCategory.*

enum class FoodCategory(val value: String){
    MILK("Milk"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    CHICKEN("Chicken"),
    VEGETARIAN("Vegetarian"),
    BEEF("Beef"),
    VEGAN("Vegan"),
    PIZZA("Pizza"),
    DONUT("Donut"),
}

fun getAllFoodCategories(): List<FoodCategory>{
    return listOf(
        DESSERT, VEGETARIAN, MILK,VEGAN, PIZZA, DONUT, CHICKEN, BEEF, SOUP,
        )
}

fun getFoodCategory(value: String): FoodCategory? {
    val map = values().associateBy(FoodCategory::value)
    return map[value]
}