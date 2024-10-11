package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    viewState : MainViewModel.CategoriesState,
    navigateToCategoryDetailsScreen: (Category) -> Unit,
) {
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
                CategoryScreen(
                    categories = viewState.categories,
                    navigateToDetailsScreen = navigateToCategoryDetailsScreen,
                )
            }
        }
    }
}

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    navigateToDetailsScreen: (Category) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(categories) { category ->
            CategoryItem(
                category = category,
                navigateToDetailsScreen = navigateToDetailsScreen,
            )
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    navigateToDetailsScreen: (Category) -> Unit,
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable { navigateToDetailsScreen(category) }
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = category.strCategoryDescription,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
            ),
        )
    }
}















