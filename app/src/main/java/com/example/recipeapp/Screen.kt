package com.example.recipeapp

sealed class Screen(val route: String) {
    data object CategoriesScreen: Screen("CategoriesScreen")
    data object CategoryDetailsScreen: Screen("CategoryDetailsScreen")
}