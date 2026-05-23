package com.example.data.models

data class CarModel(
    val id: String,
    val name: String,
    val year: Int,
    val era: String, // 'classic' | 'modern' | 'current' | 'special'
    val horsepower: Int,
    val topSpeed: Int, // km/h
    val zeroToSixty: Double, // seconds
    val price: Int, // USD
    val engine: String,
    val weight: Int, // kg
    val imageUrl: String,
    val description: String,
    val quarterMile: Double, // seconds
    val production: Int
)

data class Achievement(
    val id: String,
    val name: String,
    val description: String,
    val category: String, // 'explorer' | 'collector' | 'expert' | 'social' | 'dedication'
    val maxProgress: Int,
    var currentProgress: Int = 0
)

data class Dealer(
    val id: String,
    val name: String,
    val country: String,
    val city: String,
    val address: String,
    val phone: String,
    val website: String,
    val lat: Double,
    val lng: Double
)

data class QuizQuestion(
    val id: String,
    val type: String, // 'image' | 'sound' | 'compare' | 'trivia' | 'engine'
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

data class Video(
    val id: String,
    val title: String,
    val type: String, // 'reel' | 'video' | 'event'
    val url: String,
    val thumbnail: String,
    val duration: String,
    val views: String,
    val location: String,
    val country: String, // flag emoji or country name
    val category: String,
    val date: String,
    val description: String
)
