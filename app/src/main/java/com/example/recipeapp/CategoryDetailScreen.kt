package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoryDetailScreen(
    modifier: Modifier = Modifier,
    category : Category
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            category.strCategory,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
        Text(
            category.strCategoryDescription,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        )
    }
}