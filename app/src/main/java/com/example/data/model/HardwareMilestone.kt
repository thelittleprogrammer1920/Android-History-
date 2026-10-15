package com.example.data.model

data class HardwareMilestone(
    val id: String,
    val name: String,
    val manufacturer: String,
    val releaseYear: Int,
    val androidVersion: String,
    val headline: String,
    val significance: String,
    val keySpecs: List<String>,
    val standoutInnovations: List<String>,
    val heroQuote: String,
    val accentColorHex: Long = 0xFF4285F4
)

data class ArchitectureTopic(
    val id: String,
    val title: String,
    val subtitle: String,
    val introducedEra: String,
    val problemStatement: String,
    val googleSolution: String,
    val technicalImpact: List<String>,
    val diagramBefore: String,
    val diagramAfter: String,
    val accentColorHex: Long
)

data class QuizQuestion(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String,
    val funFact: String
)
