package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.data.models.Video
import com.example.ui.MainViewModel
import com.example.ui.theme.LamboGold
import com.example.ui.theme.LamboRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorldScreen(viewModel: MainViewModel, navController: NavController) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Reels \uD83D\uDD25", "Top Videos \uD83C\uDFAC", "Events \uD83C\uDF0D")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lamborghini World", color = LamboGold) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = LamboGold
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(title, fontWeight = FontWeight.Bold, maxLines = 1) }
                    )
                }
            }

            Box(modifier = Modifier.fillMaxSize()) {
                when (selectedTab) {
                    0 -> ReelsTab(viewModel.allVideos.filter { it.type == "reel" })
                    1 -> VideosTab(viewModel.allVideos.filter { it.type == "video" })
                    2 -> EventsTab(viewModel.allVideos.filter { it.type == "event" })
                }
            }
        }
    }
}

@Composable
fun ReelsTab(reels: List<Video>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(reels) { reel ->
            ReelCard(reel)
        }
    }
}

@Composable
fun ReelCard(reel: Video) {
    Card(
        modifier = Modifier.fillMaxWidth().height(400.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = reel.thumbnail,
                contentDescription = reel.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
            )
            Icon(
                Icons.Default.PlayArrow,
                contentDescription = "Play",
                tint = Color.White.copy(alpha = 0.8f),
                modifier = Modifier.size(64.dp).align(Alignment.Center)
            )
            Column(
                modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)
            ) {
                Text(reel.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(reel.country, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(reel.location, color = Color.White, fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("${reel.views} views", color = LamboGold, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun VideosTab(videos: List<Video>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(videos) { video ->
            Card(
                modifier = Modifier.fillMaxWidth().height(250.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column {
                    Box(modifier = Modifier.fillMaxWidth().height(150.dp)) {
                        AsyncImage(
                            model = video.thumbnail,
                            contentDescription = video.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Box(
                            modifier = Modifier.align(Alignment.BottomEnd).padding(8.dp)
                                .background(Color.Black.copy(alpha = 0.7f), MaterialTheme.shapes.small)
                                .padding(horizontal = 4.dp, vertical = 2.dp)
                        ) {
                            Text(video.duration, color = Color.White, fontSize = 12.sp)
                        }
                    }
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(video.title, fontWeight = FontWeight.Bold, maxLines = 2, color = Color.White)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "${video.category} • ${video.views} views",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EventsTab(events: List<Video>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(events) { event ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column {
                    AsyncImage(
                        model = event.thumbnail,
                        contentDescription = event.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth().height(180.dp)
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(event.country, fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(event.location, color = LamboGold, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(event.date, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(event.title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.White)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(event.description, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = LamboRed)
                        ) {
                            Text("I'M INTERESTED", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}
