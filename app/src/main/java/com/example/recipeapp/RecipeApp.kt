package com.example.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController) {
    val categoryViewModel : MainViewModel = viewModel()
    val viewState by categoryViewModel.categoriesState

    NavHost(navController, Screen.CategoriesScreen.route) {
        composable(Screen.CategoriesScreen.route) {
            CategoriesScreen(
                viewState = viewState,
                navigateToCategoryDetailsScreen = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("category", it)
                    navController.navigate(Screen.CategoryDetailsScreen.route)
                }
            )
        }
        composable(Screen.CategoryDetailsScreen.route) {
            val category = navController
                .previousBackStackEntry
                ?.savedStateHandle
                ?.get<Category>("category")
                ?: Category("","","","")

            CategoryDetailScreen(
                category = category
            )
        }
    }
}