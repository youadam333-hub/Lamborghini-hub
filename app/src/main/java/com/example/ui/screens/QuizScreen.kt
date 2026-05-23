package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ui.MainViewModel
import com.example.ui.theme.LamboGold
import com.example.ui.theme.LamboRed
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(viewModel: MainViewModel, navController: NavController) {
    var isStarted by remember { mutableStateOf(false) }
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var showResults by remember { mutableStateOf(false) }
    
    val questions = viewModel.quizQuestions

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Challenge", color = LamboGold) })
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
            when {
                !isStarted -> {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("LAMBORGHINI EXPERT QUIZ", color = LamboRed, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("Test your knowledge. 5 questions.", color = Color.White)
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = { isStarted = true },
                            colors = ButtonDefaults.buttonColors(containerColor = LamboGold, contentColor = Color.Black)
                        ) {
                            Text("START", fontWeight = FontWeight.Bold)
                        }
                    }
                }
                showResults -> {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("CHALLENGE COMPLETE", color = LamboGold, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("Score: ${score * 20}%", color = Color.White, fontSize = 32.sp)
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = {
                                currentQuestionIndex = 0
                                score = 0
                                isStarted = false
                                showResults = false
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = LamboRed)
                        ) {
                            Text("PLAY AGAIN", color = Color.White)
                        }
                    }
                }
                else -> {
                    val q = questions[currentQuestionIndex]
                    Column(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Question ${currentQuestionIndex + 1}/${questions.size}", color = LamboGold)
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(q.question, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.padding(horizontal = 16.dp))
                        
                        Spacer(modifier = Modifier.height(32.dp))
                        
                        q.options.forEachIndexed { index, option ->
                            OutlinedButton(
                                onClick = {
                                    if (index == q.correctAnswerIndex) {
                                        score++
                                    }
                                    if (currentQuestionIndex < questions.size - 1) {
                                        currentQuestionIndex++
                                    } else {
                                        showResults = true
                                    }
                                },
                                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                            ) {
                                Text(option, fontSize = 18.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}
