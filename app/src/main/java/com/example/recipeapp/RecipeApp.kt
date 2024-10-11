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
                    // Save to the CURRENT backstack a "category" key-value pair
                    navController
                        .currentBackStackEntry  // get the CURRENT backstack
                        ?.savedStateHandle      // through the saved state
                        ?.set("category", it)   // set a key-value pair
                    navController.navigate(Screen.CategoryDetailsScreen.route)
                }
            )
        }
        composable(Screen.CategoryDetailsScreen.route) {
            // Get from the PREVIOUS backstack the value of "category" key
            val category = navController
                .previousBackStackEntry         // get the PREVIOUS backstack
                ?.savedStateHandle              // through the saved state
                ?.get<Category>("category")     // get the value
                ?: Category("","","","")

            CategoryDetailScreen(
                category = category
            )
        }
    }
}