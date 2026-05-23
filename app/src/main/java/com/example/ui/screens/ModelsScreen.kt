package com.example.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.data.models.CarModel
import com.example.ui.MainViewModel
import com.example.ui.theme.LamboGold
import com.example.ui.theme.LamboRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModelsScreen(viewModel: MainViewModel, navController: NavController) {
    val favorites by viewModel.favoriteIds.collectAsState()
    var selectedEra by remember { mutableStateOf("All") }
    val eras = listOf("All", "classic", "modern", "current", "special")
    
    val filteredCars = remember(selectedEra) {
        if (selectedEra == "All") viewModel.allCars else viewModel.allCars.filter { it.era == selectedEra }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Models", color = LamboGold) },
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            ScrollableTabRow(
                selectedTabIndex = eras.indexOf(selectedEra),
                edgePadding = 16.dp,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = LamboGold
            ) {
                eras.forEachIndexed { index, era ->
                    Tab(
                        selected = eras.indexOf(selectedEra) == index,
                        onClick = { selectedEra = era },
                        text = { Text(era.uppercase(), fontWeight = FontWeight.Bold) }
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(filteredCars) { car ->
                    CarCard(
                        car = car,
                        isFavorite = favorites.contains(car.id),
                        onFavoriteClick = { viewModel.toggleFavorite(car.id) },
                        onClick = { navController.navigate("detail/${car.id}") }
                    )
                }
            }
        }
    }
}

@Composable
fun CarCard(car: CarModel, isFavorite: Boolean, onFavoriteClick: () -> Unit, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth().height(120.dp)) {
                AsyncImage(
                    model = car.imageUrl,
                    contentDescription = car.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (isFavorite) LamboRed else Color.White
                    )
                }
            }
            Column(modifier = Modifier.padding(8.dp)) {
                Text(car.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, maxLines = 1)
                Spacer(modifier = Modifier.height(4.dp))
                Text("${car.year} | ${car.horsepower} HP", style = MaterialTheme.typography.bodySmall, color = LamboGold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$${car.price}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
