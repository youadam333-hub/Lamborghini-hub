package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.CarModel
import com.example.data.repository.MockDataRepository
import com.example.data.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val prefsRepo = UserPreferencesRepository(application)
    
    val allCars = MockDataRepository.models
    val quizQuestions = MockDataRepository.quizQuestions
    val allVideos = MockDataRepository.videos

    val favoriteIds: StateFlow<Set<String>> = prefsRepo.favoritesFlow.map { it.toSet() }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptySet()
    )

    fun toggleFavorite(carId: String) {
        viewModelScope.launch {
            prefsRepo.toggleFavorite(carId)
        }
    }
}
