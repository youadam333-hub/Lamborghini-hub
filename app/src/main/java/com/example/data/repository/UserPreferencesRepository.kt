package com.example.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.json.JSONArray

val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferencesRepository(private val context: Context) {
    
    private val FAVORITES_KEY = stringPreferencesKey("lambo_favorites")
    
    val favoritesFlow: Flow<List<String>> = context.dataStore.data.map { prefs ->
        val jsonString = prefs[FAVORITES_KEY] ?: "[]"
        try {
            val jsonArray = JSONArray(jsonString)
            val list = mutableListOf<String>()
            for (i in 0 until jsonArray.length()) {
                list.add(jsonArray.getString(i))
            }
            list
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    suspend fun toggleFavorite(carId: String) {
        context.dataStore.edit { prefs ->
            val jsonString = prefs[FAVORITES_KEY] ?: "[]"
            val jsonArray = JSONArray(jsonString)
            val list = mutableListOf<String>()
            for (i in 0 until jsonArray.length()) {
                list.add(jsonArray.getString(i))
            }
            if (list.contains(carId)) {
                // remove
                list.remove(carId)
            } else {
                list.add(carId)
            }
            prefs[FAVORITES_KEY] = JSONArray(list).toString()
        }
    }
}
