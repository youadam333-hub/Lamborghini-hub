package com.example.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import androidx.navigation.NavHostController
import com.example.ui.screens.*
import com.example.ui.theme.LamboGold
import kotlinx.coroutines.delay

@Composable
fun MainApp(viewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()
    var showSplash by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(3000)
        showSplash = false
    }

    if (showSplash) {
        SplashScreen()
    } else {
        Scaffold(
            bottomBar = { AppBottomNavigation(navController) }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(paddingValues)
            ) {
                composable("home") { HomeScreen(viewModel, navController) }
                composable("models") { ModelsScreen(viewModel, navController) }
                composable("world") { WorldScreen(viewModel, navController) }
                composable("quiz") { QuizScreen(viewModel, navController) }
                composable("detail/{carId}") { backStackEntry ->
                    val carId = backStackEntry.arguments?.getString("carId")
                    val car = viewModel.allCars.find { it.id == carId }
                    if (car != null) {
                        ModelDetailScreen(car, viewModel, navController)
                    }
                }
            }
        }
    }
}

@Composable
fun AppBottomNavigation(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { navController.navigate("home") { launchSingleTop = true; restoreState = true } },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = LamboGold,
                selectedTextColor = LamboGold,
                indicatorColor = MaterialTheme.colorScheme.surfaceVariant
            )
        )
        NavigationBarItem(
            selected = currentRoute == "models",
            onClick = { navController.navigate("models") { launchSingleTop = true; restoreState = true } },
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Models") },
            label = { Text("Models") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = LamboGold,
                selectedTextColor = LamboGold,
                indicatorColor = MaterialTheme.colorScheme.surfaceVariant
            )
        )
        NavigationBarItem(
            selected = currentRoute == "world",
            onClick = { navController.navigate("world") { launchSingleTop = true; restoreState = true } },
            icon = { Icon(Icons.Default.Public, contentDescription = "World") },
            label = { Text("World") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = LamboGold,
                selectedTextColor = LamboGold,
                indicatorColor = MaterialTheme.colorScheme.surfaceVariant
            )
        )
        NavigationBarItem(
            selected = currentRoute == "quiz",
            onClick = { navController.navigate("quiz") { launchSingleTop = true; restoreState = true } },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = "Challenge") },
            label = { Text("Challenge") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = LamboGold,
                selectedTextColor = LamboGold,
                indicatorColor = MaterialTheme.colorScheme.surfaceVariant
            )
        )
    }
}
