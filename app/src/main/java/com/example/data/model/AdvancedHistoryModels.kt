package com.example.data.model

data class CounterpartComparison(
    val id: String,
    val title: String,
    val category: String,
    val androidFeature: String,
    val androidIntroduced: String,
    val androidPioneered: Boolean,
    val rivalFeature: String,
    val rivalPlatform: String,
    val rivalIntroduced: String,
    val whoDidItFirstSummary: String,
    val androidAdvantage: String,
    val philosophicalContrast: String,
    val accentColorHex: Long = 0xFF3DDC84
)

data class GraveyardFeature(
    val id: String,
    val name: String,
    val introducedVersion: String,
    val introducedYear: Int,
    val killedVersion: String,
    val killedYear: Int,
    val whatItDid: String,
    val whyGoogleBuiltIt: String,
    val whyGoogleKilledIt: String,
    val whatReplacedIt: String,
    val iconEmoji: String,
    val tag: String
)

data class GradleMilestone(
    val year: String,
    val title: String,
    val description: String,
    val codeSnippet: String? = null
)

data class GradleTopic(
    val id: String,
    val title: String,
    val subtitle: String,
    val summary: String,
    val detailedExplanation: String,
    val keyPoints: List<String>,
    val codeExample: String? = null,
    val category: String = "Core"
)

data class ChatMessage(
    val id: String,
    val text: String,
    val isUser: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)
