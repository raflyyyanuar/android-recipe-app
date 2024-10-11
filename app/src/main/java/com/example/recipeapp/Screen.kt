package com.example.recipeapp

sealed class Screen(val route: String) {
    object CategoriesScreen: Screen("CategoriesScreen")
    object CategoryDetailsScreen: Screen("CategoryDetailsScreen")
}