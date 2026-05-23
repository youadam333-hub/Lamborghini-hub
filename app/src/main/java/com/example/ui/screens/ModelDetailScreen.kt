package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.data.models.CarModel
import com.example.ui.MainViewModel
import com.example.ui.theme.LamboGold
import com.example.ui.theme.LamboRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModelDetailScreen(car: CarModel, viewModel: MainViewModel, navController: NavController) {
    val favorites by viewModel.favoriteIds.collectAsState()
    val isFavorite = favorites.contains(car.id)
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(car.name, color = LamboGold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = LamboGold)
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.toggleFavorite(car.id) }) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (isFavorite) LamboRed else LamboGold
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            item {
                AsyncImage(
                    model = car.imageUrl,
                    contentDescription = car.name,
                    modifier = Modifier.fillMaxWidth().height(300.dp),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(car.name, style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold)
                    Text("EST. $${car.price}", color = LamboGold, style = MaterialTheme.typography.titleMedium)
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(car.description, style = MaterialTheme.typography.bodyLarge)
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    Text("SPECIFICATIONS", style = MaterialTheme.typography.titleMedium, color = LamboRed, letterSpacing = 2.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        item { SpecCard("0-60 MPH", "${car.zeroToSixty}s") }
                        item { SpecCard("TOP SPEED", "${car.topSpeed} km/h") }
                        item { SpecCard("POWER", "${car.horsepower} HP") }
                        item { SpecCard("ENGINE", car.engine) }
                        item { SpecCard("WEIGHT", "${car.weight} kg") }
                    }
                    
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = { /* Play sound */ },
                        modifier = Modifier.fillMaxWidth().height(56.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = LamboGold, contentColor = Color.Black)
                    ) {
                        Text("HEAR THE ROAR", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun SpecCard(label: String, value: String) {
    Card(
        modifier = Modifier.size(width = 120.dp, height = 100.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(value, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyLarge, color = Color.White)
            Spacer(modifier = Modifier.height(4.dp))
            Text(label, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}
