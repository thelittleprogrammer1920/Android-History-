package com.example.data.repository

import com.example.data.model.QuizQuestion

object TriviaData {
    val questions = listOf(
        QuizQuestion(
            id = 1,
            question = "Which was the first commercially released Android smartphone?",
            options = listOf("Nexus One", "HTC Dream (T-Mobile G1)", "Motorola DROID", "Samsung Galaxy S"),
            correctIndex = 1,
            explanation = "The HTC Dream (sold as the T-Mobile G1 in the US) launched on October 22, 2008 running Android 1.0. It featured a slide-out hardware keyboard and an optical trackball.",
            funFact = "The G1 had a unique angled 'chin' designed to keep your thumb steady while scrolling with the trackball!"
        ),
        QuizQuestion(
            id = 2,
            question = "What was the first Android release to be named after a sweet dessert?",
            options = listOf("Android 1.0 Apple Pie", "Android 1.5 Cupcake", "Android 1.6 Donut", "Android 2.0 Eclair"),
            correctIndex = 1,
            explanation = "Android 1.5 Cupcake (released April 2009) was the very first official release with a dessert name and initiated the iconic alphabetical naming tradition.",
            funFact = "Before Cupcake, Android 1.1 was referred to internally as 'Petit Four' or 'Banana Bread', but Cupcake was the first official public dessert!"
        ),
        QuizQuestion(
            id = 3,
            question = "What major UI feature was introduced in Android 3.0 Honeycomb that permanently changed Android phone designs?",
            options = listOf("The App Drawer", "On-screen virtual navigation buttons (Back, Home, Recents)", "Split-Screen multitasking", "Pull-down notification shade"),
            correctIndex = 1,
            explanation = "Honeycomb banished physical hardware navigation buttons in favor of software on-screen keys (Back, Home, Recents) in the System Bar, which later came to phones in Ice Cream Sandwich.",
            funFact = "Honeycomb was the only Android release exclusively engineered for tablets and was never released for smartphones!"
        ),
        QuizQuestion(
            id = 4,
            question = "What was the codename of Google's major project in Android 4.1 that synchronized UI rendering at 60 FPS using VSYNC?",
            options = listOf("Project Svelte", "Project Treble", "Project Butter", "Project Volta"),
            correctIndex = 2,
            explanation = "Project Butter introduced VSYNC timing, triple graphics buffering, and touch anticipation to lock UI animations at 60 frames per second, ending early Android lag.",
            funFact = "Project Butter was led by Romain Guy and Chet Haase, who later hosted the popular 'Android Dialogs' and 'Now in Android' podcasts."
        ),
        QuizQuestion(
            id = 5,
            question = "Which legendary Android flagship phone was sold unlocked by Google for just $299 in 2012, featuring a holographic sparkling glass back?",
            options = listOf("Nexus 4", "Nexus 5", "Nexus One", "Galaxy Nexus"),
            correctIndex = 0,
            explanation = "The LG-built Nexus 4 shocked the tech industry with its $299 price tag, Qi wireless charging, and iconic 'crystal reflection' rear glass that shimmered under light.",
            funFact = "The Nexus 4 demand was so immense that Google's servers crashed globally, and it sold out within minutes across all launch countries."
        ),
        QuizQuestion(
            id = 6,
            question = "What monumental architecture initiative in Android 8.0 Oreo decoupled the core Android OS framework from silicon chipmaker drivers?",
            options = listOf("Project Mainline", "Project Treble", "Project Volta", "Project Svelte"),
            correctIndex = 1,
            explanation = "Project Treble introduced the Vendor Interface (HIDL/VINTF), allowing Google to update the core system image without waiting for Qualcomm or MediaTek to recompile drivers.",
            funFact = "Treble enabled Generic System Images (GSIs), which can boot raw AOSP Android onto virtually any Treble-certified phone from any manufacturer!"
        ),
        QuizQuestion(
            id = 7,
            question = "Which Android version introduced the very first hidden Easter Egg (found by rapidly tapping the Android version in Settings)?",
            options = listOf("Android 1.5 Cupcake", "Android 2.2 Froyo", "Android 2.3 Gingerbread", "Android 4.0 Ice Cream Sandwich"),
            correctIndex = 2,
            explanation = "Android 2.3 Gingerbread introduced the very first Easter Egg: hand-drawn artwork by Jack Larson of the Bugdroid standing next to an undead zombie eating gingerbread.",
            funFact = "Google engineer Diane Hackborn approved the zombie Easter Egg as a lighthearted tribute to the late nights the team worked before launch."
        ),
        QuizQuestion(
            id = 8,
            question = "What was the primary design system breakthrough introduced in Android 12 alongside the Pixel 6?",
            options = listOf("Holo Theme", "Material Design", "Material You (Dynamic Color)", "Skeuomorphism"),
            correctIndex = 2,
            explanation = "Material You (Material 3) introduced dynamic color extraction ('Monet'), generating harmonious custom color palettes directly from the user's chosen wallpaper.",
            funFact = "Material You was designed around personal expression, ensuring no two users' phones looked identical even if running the exact same software."
        ),
        QuizQuestion(
            id = 9,
            question = "What ground-breaking computational photography feature debuted on the Google Pixel 3, allowing daylight-quality photos in pitch blackness with a single lens?",
            options = listOf("Magic Eraser", "Night Sight", "Cinematic Pan", "Best Take"),
            correctIndex = 1,
            explanation = "Night Sight used multi-exposure computational alignment to capture long exposures handheld without a tripod, redefining smartphone low-light photography forever.",
            funFact = "Marc Levoy's computational photography team at Google developed the algorithms originally tested on Google Glass!"
        ),
        QuizQuestion(
            id = 10,
            question = "What runtime compiler permanently replaced Dalvik as the default Android execution engine starting in Android 5.0 Lollipop?",
            options = listOf("V8", "HotSpot", "ART (Android Runtime)", "JVM 8"),
            correctIndex = 2,
            explanation = "The Android Runtime (ART) brought Ahead-of-Time (AOT) compilation and 64-bit architecture support, replacing the aging Dalvik bytecode interpreter.",
            funFact = "ART was originally included as an optional experimental developer preview in Android 4.4 KitKat before becoming mandatory in Lollipop."
        ),
        QuizQuestion(
            id = 11,
            question = "What is the internal dessert codename for Android 16?",
            options = listOf("Brownie", "Baklava", "Banana Split", "Biscotti"),
            correctIndex = 1,
            explanation = "Android 16 is codenamed 'Baklava', returning to classic dessert naming after Vanilla Ice Cream (Android 15) and Upside Down Cake (Android 14).",
            funFact = "Android 10 was internally 'Quince Tart', Android 11 was 'Red Velvet Cake', 12 was 'Snow Cone', and 13 was 'Tiramisu'!"
        ),
        QuizQuestion(
            id = 12,
            question = "Which Android flagship phone was the first to run custom-designed Google silicon (the Google Tensor chip)?",
            options = listOf("Pixel 4", "Pixel 5", "Pixel 6 & 6 Pro", "Pixel 7 Pro"),
            correctIndex = 2,
            explanation = "Google Pixel 6 & 6 Pro (launched October 2021) were the first devices powered by Google Tensor, featuring custom TPU cores optimized for speech and computational imaging.",
            funFact = "The Tensor chip enabled real-time offline speech transcription in Pixel Recorder and on-device Live Translate with zero internet connection."
        )
    )
}
