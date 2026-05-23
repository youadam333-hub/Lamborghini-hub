package com.example.data.repository

import com.example.data.models.Achievement
import com.example.data.models.CarModel
import com.example.data.models.Dealer
import com.example.data.models.QuizQuestion
import com.example.data.models.Video

object MockDataRepository {
    val models = listOf(
        CarModel(
            id = "m1",
            name = "Revuelto",
            year = 2023,
            era = "current",
            horsepower = 1015,
            topSpeed = 350,
            zeroToSixty = 2.5,
            price = 608000,
            engine = "6.5L V12 PHEV",
            weight = 1772,
            imageUrl = "https://images.unsplash.com/photo-1621007947382-bb3c3994e3fd?q=80&w=2000&auto=format&fit=crop", // placeholder
            description = "The first High Performance Electrified Vehicle (HPEV) hybrid super sports car.",
            quarterMile = 9.9,
            production = 1000
        ),
        CarModel(
            id = "m2",
            name = "Aventador SVJ",
            year = 2018,
            era = "modern",
            horsepower = 770,
            topSpeed = 352,
            zeroToSixty = 2.8,
            price = 517770,
            engine = "6.5L V12",
            weight = 1525,
            imageUrl = "https://images.unsplash.com/photo-1544829099-b152342c8d20?q=80&w=2000&auto=format&fit=crop",
            description = "The pinnacle of the Aventador lineup with Aerodinamica Lamborghini Attiva (ALA).",
            quarterMile = 10.5,
            production = 900
        ),
        CarModel(
            id = "m3",
            name = "Huracán STO",
            year = 2020,
            era = "current",
            horsepower = 640,
            topSpeed = 310,
            zeroToSixty = 3.0,
            price = 327838,
            engine = "5.2L V10",
            weight = 1339,
            imageUrl = "https://images.unsplash.com/photo-1614200179396-2bdb77ebf81b?q=80&w=2000&auto=format&fit=crop",
            description = "Super Trofeo Omologata: a road-homologated super sports car inspired by the racing heritage.",
            quarterMile = 10.9,
            production = 0
        ),
        CarModel(
            id = "m4",
            name = "Countach LP400",
            year = 1974,
            era = "classic",
            horsepower = 375,
            topSpeed = 309,
            zeroToSixty = 5.4,
            price = 52000,
            engine = "3.9L V12",
            weight = 1065,
            imageUrl = "https://images.unsplash.com/photo-1554522855-f761fc59be43?q=80&w=2000&auto=format&fit=crop",
            description = "The icon that defined the wedge-shape era of supercars.",
            quarterMile = 13.5,
            production = 157
        ),
        CarModel(
            id = "m5",
            name = "Miura P400",
            year = 1966,
            era = "classic",
            horsepower = 350,
            topSpeed = 276,
            zeroToSixty = 6.7,
            price = 20000,
            engine = "3.9L V12",
            weight = 1125,
            imageUrl = "https://images.unsplash.com/photo-1601004183497-e81816eac1d4?q=80&w=2000&auto=format&fit=crop",
            description = "The first true supercar with a mid-engine, two-seat layout.",
            quarterMile = 14.5,
            production = 275
        ),
        CarModel(
            id = "m6",
            name = "Urus Performante",
            year = 2022,
            era = "current",
            horsepower = 666,
            topSpeed = 306,
            zeroToSixty = 3.3,
            price = 260676,
            engine = "4.0L V8 Twin-Turbo",
            weight = 2150,
            imageUrl = "https://images.unsplash.com/photo-1606152421802-db97b9c7a11b?q=80&w=2000&auto=format&fit=crop",
            description = "The definitive Super Sport Utility Vehicle.",
            quarterMile = 11.5,
            production = 0
        ),
        CarModel(
            id = "m7",
            name = "Veneno",
            year = 2013,
            era = "special",
            horsepower = 750,
            topSpeed = 355,
            zeroToSixty = 2.8,
            price = 4500000,
            engine = "6.5L V12",
            weight = 1450,
            imageUrl = "https://images.unsplash.com/photo-1519245659620-e859806a8d3b?q=80&w=2000&auto=format&fit=crop",
            description = "A racing prototype built for the road, extremely limited.",
            quarterMile = 10.6,
            production = 4
        ),
        CarModel(
            id = "m8",
            name = "Sesto Elemento",
            year = 2010,
            era = "special",
            horsepower = 570,
            topSpeed = 352,
            zeroToSixty = 2.5,
            price = 2200000,
            engine = "5.2L V10",
            weight = 999,
            imageUrl = "https://images.unsplash.com/photo-1566473965934-297eb0981dfc?q=80&w=2000&auto=format&fit=crop",
            description = "An ultra-lightweight track-only car focused on carbon fiber innovation.",
            quarterMile = 10.2,
            production = 20
        ),
        CarModel(
            id = "m9",
            name = "Diablo SV",
            year = 1995,
            era = "classic",
            horsepower = 510,
            topSpeed = 328,
            zeroToSixty = 3.8,
            price = 210000,
            engine = "5.7L V12",
            weight = 1530,
            imageUrl = "https://images.unsplash.com/photo-1549419149-c12e8eb063b2?q=80&w=2000&auto=format&fit=crop",
            description = "The devilish successor to the Countach.",
            quarterMile = 11.8,
            production = 346
        ),
        CarModel(
            id = "m10",
            name = "Murciélago LP 670-4 SV",
            year = 2009,
            era = "modern",
            horsepower = 670,
            topSpeed = 342,
            zeroToSixty = 3.2,
            price = 450000,
            engine = "6.5L V12",
            weight = 1565,
            imageUrl = "https://images.unsplash.com/photo-1520050735087-1ed65d9b0273?q=80&w=2000&auto=format&fit=crop",
            description = "The ultimate and final version of the Murciélago.",
            quarterMile = 11.0,
            production = 186
        )
    )

    val achievements = listOf(
        Achievement("a1", "First Ignition", "Launch the app for the first time.", "dedication", 1, 1),
        Achievement("a2", "V12 Enthusiast", "View 3 V12 models.", "explorer", 3, 0),
        Achievement("a3", "Quiz Master", "Score 100% on the quiz.", "expert", 1, 0),
        Achievement("a4", "Collector", "Add 5 models to your favorites.", "collector", 5, 0)
    )

    val quizQuestions = listOf(
        QuizQuestion("q1", "trivia", "In what year was Lamborghini Automobili founded?", listOf("1959", "1963", "1966", "1971"), 1),
        QuizQuestion("q2", "trivia", "Which animal is on the Lamborghini crest?", listOf("Horse", "Cheetah", "Bull", "Lion"), 2),
        QuizQuestion("q3", "trivia", "What was Lamborghini's first production model?", listOf("Miura", "Countach", "350 GT", "Urraco"), 2),
        QuizQuestion("q4", "trivia", "The Sesto Elemento is named after the sixth element in the periodic table. What is it?", listOf("Iron", "Titanium", "Carbon", "Neon"), 2),
        QuizQuestion("q5", "trivia", "Which model replaced the Aventador as the flagship V12?", listOf("Huracán", "Veneno", "Centenario", "Revuelto"), 3)
    )

    val videos = listOf(
        Video("v1", "SVJ Twin Turbo destroys the street", "reel", "https://example.com/video1.mp4", "https://images.unsplash.com/photo-1544829099-b152342c8d20", "0:45", "1.2M", "Dubai", "🇦🇪", "Custom Builds", "2023-10-12", "Crazy SVJ build taking over the streets of Dubai."),
        Video("v2", "382 Lamborghinis gather at Silverstone", "event", "https://example.com/video2.mp4", "https://images.unsplash.com/photo-1621007947382-bb3c3994e3fd", "1:20", "850K", "Silverstone", "🇬🇧", "Events", "2023-05-20", "World record 382 cars gather."),
        Video("v3", "Aventador Ultimae sunset launch", "video", "https://example.com/video3.mp4", "https://images.unsplash.com/photo-1544829099-b152342c8d20", "3:15", "2M", "Monaco", "🇲🇨", "Cinematic", "2022-07-08", "The final naturally aspirated V12 Aventador."),
        Video("v4", "Huracan STO on the Nürburgring", "reel", "https://example.com/video4.mp4", "https://images.unsplash.com/photo-1614200179396-2bdb77ebf81b", "0:59", "3.4M", "Nürburgring", "🇩🇪", "Track", "2021-08-30", "Pushing the STO to the absolute limit."),
        Video("v5", "Lamborghini Arena 2024", "event", "https://example.com/video5.mp4", "https://images.unsplash.com/photo-1621007947382-bb3c3994e3fd", "2:05", "500K", "Imola", "🇮🇹", "Events", "2024-04-15", "6,000+ attendees, 380 cars. A massive celebration."),
        Video("v6", "Pure V12 Sound Compilation", "video", "https://example.com/video6.mp4", "https://images.unsplash.com/photo-1519245659620-e859806a8d3b", "10:30", "5.1M", "Various", "🌍", "Sounds", "2023-01-01", "No music, just pure Lamborghini V12 engine sounds.")
    )

    fun getCarById(id: String): CarModel? {
        return models.find { it.id == id }
    }
}
