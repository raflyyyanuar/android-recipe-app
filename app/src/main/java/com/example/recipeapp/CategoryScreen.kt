package com.example.recipeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
) {
    val categoryViewModel : MainViewModel= viewModel()
    val viewState by categoryViewModel.categoriesState

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center),
                )
            }
            viewState.error != null -> {
                Text("Error occurred when fetching data!")
            }
            else -> {
                // /*TODO display categories*/
            }
        }
    }
}