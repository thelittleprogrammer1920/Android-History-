package com.example.data.model

enum class AndroidEra(val displayName: String, val years: String, val colorHex: Long) {
    EARLY_FOUNDATIONS("Early Foundations", "2008 – 2010", 0xFF4CAF50),
    HOLO_REVOLUTION("Holo Revolution", "2011 – 2013", 0xFF00E5FF),
    MATERIAL_DESIGN("Material Design", "2014 – 2016", 0xFFFF9800),
    TREBLE_AND_AI("Treble & On-Device ML", "2017 – 2020", 0xFFFFC107),
    MATERIAL_YOU("Material You & Modern AI", "2021 – Present", 0xFF7C4DFF)
}

data class FeatureHighlight(
    val title: String,
    val description: String,
    val category: String = "OS"
)

data class HardwareMilestoneRef(
    val name: String,
    val manufacturer: String,
    val year: Int,
    val badge: String,
    val significance: String
)

data class EasterEggInfo(
    val title: String,
    val howToTrigger: String,
    val description: String,
    val type: EasterEggType
)

enum class EasterEggType {
    ZOMBIE_ART,
    NYANDROID,
    JELLY_BEANS,
    SPINNING_K,
    LOLLIPOP_FLAPPY,
    MARSHMALLOW_FLAPPY,
    NOUGAT_CAT,
    OREO_COOKIE,
    PIE_PAINT,
    ANDROID_10_PUZZLE,
    ANDROID_11_VOLUME,
    ANDROID_12_CLOCK,
    ANDROID_13_BUBBLES,
    ANDROID_14_ROCKET,
    ANDROID_15_SPACE
}

data class AndroidRelease(
    val id: String,
    val versionName: String,
    val dessertName: String,
    val internalCodename: String,
    val apiLevel: Int,
    val releaseDate: String,
    val year: Int,
    val era: AndroidEra,
    val tagline: String,
    val whatGoogleDid: String,
    val keyFeatures: List<FeatureHighlight>,
    val majorHardware: List<HardwareMilestoneRef>,
    val architectureLeap: String,
    val easterEgg: EasterEggInfo,
    val accentColorHex: Long,
    val marketSharePeak: String = ""
)
