package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.AndroidEra
import com.example.data.model.AndroidRelease
import com.example.data.model.ArchitectureTopic
import com.example.data.model.EasterEggType
import com.example.data.model.HardwareMilestone
import com.example.data.model.QuizQuestion
import com.example.data.repository.AndroidReleasesData
import com.example.data.repository.ArchitectureData
import com.example.data.repository.HardwareData
import com.example.data.repository.TriviaData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class AppTab(val title: String) {
    CHRONICLE("Chronicle"),
    HARDWARE("Hardware"),
    ARCHITECTURE("Architecture"),
    TRIVIA_MUSEUM("Easter Eggs & Quiz")
}

data class HistoryUiState(
    val currentTab: AppTab = AppTab.CHRONICLE,
    val releases: List<AndroidRelease> = AndroidReleasesData.releases,
    val hardwareDevices: List<HardwareMilestone> = HardwareData.devices,
    val architectureTopics: List<ArchitectureTopic> = ArchitectureData.topics,
    val searchQuery: String = "",
    val selectedEra: AndroidEra? = null,
    val bookmarkedReleaseIds: Set<String> = emptySet(),
    val showOnlyBookmarked: Boolean = false,
    val selectedRelease: AndroidRelease? = null,
    val selectedHardware: HardwareMilestone? = null,
    val selectedArchitecture: ArchitectureTopic? = null,
    val activeEasterEgg: EasterEggType? = null,
    // Quiz state
    val quizQuestions: List<QuizQuestion> = TriviaData.questions,
    val currentQuizIndex: Int = 0,
    val selectedOptionIndex: Int? = null,
    val isQuestionAnswered: Boolean = false,
    val quizScore: Int = 0,
    val isQuizFinished: Boolean = false,
    // Interactive Easter Egg simulation toy states
    val clockAngle: Float = 0f,
    val isClockUnlocked: Boolean = false,
    val nekoCatsCollected: Int = 0,
    val flappyScore: Int = 0,
    val flappyGameOver: Boolean = false
)

class HistoryViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HistoryUiState())
    val uiState: StateFlow<HistoryUiState> = _uiState.asStateFlow()

    fun selectTab(tab: AppTab) {
        _uiState.update { it.copy(currentTab = tab) }
    }

    fun updateSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun selectEra(era: AndroidEra?) {
        _uiState.update { current ->
            current.copy(selectedEra = if (current.selectedEra == era) null else era)
        }
    }

    fun toggleBookmark(releaseId: String) {
        _uiState.update { current ->
            val updated = if (current.bookmarkedReleaseIds.contains(releaseId)) {
                current.bookmarkedReleaseIds - releaseId
            } else {
                current.bookmarkedReleaseIds + releaseId
            }
            current.copy(bookmarkedReleaseIds = updated)
        }
    }

    fun toggleShowOnlyBookmarked() {
        _uiState.update { it.copy(showOnlyBookmarked = !it.showOnlyBookmarked) }
    }

    fun openReleaseDetail(release: AndroidRelease) {
        _uiState.update { it.copy(selectedRelease = release) }
    }

    fun closeReleaseDetail() {
        _uiState.update { it.copy(selectedRelease = null) }
    }

    fun openHardwareDetail(hardware: HardwareMilestone) {
        _uiState.update { it.copy(selectedHardware = hardware) }
    }

    fun closeHardwareDetail() {
        _uiState.update { it.copy(selectedHardware = null) }
    }

    fun openArchitectureDetail(topic: ArchitectureTopic) {
        _uiState.update { it.copy(selectedArchitecture = topic) }
    }

    fun closeArchitectureDetail() {
        _uiState.update { it.copy(selectedArchitecture = null) }
    }

    fun launchEasterEgg(type: EasterEggType) {
        _uiState.update {
            it.copy(
                activeEasterEgg = type,
                clockAngle = 0f,
                isClockUnlocked = false,
                flappyScore = 0,
                flappyGameOver = false
            )
        }
    }

    fun dismissEasterEgg() {
        _uiState.update { it.copy(activeEasterEgg = null) }
    }

    // Interactive toy helpers
    fun rotateClockHand(degrees: Float) {
        val newAngle = (degrees % 360f + 360f) % 360f
        val unlocked = newAngle in 350f..360f || newAngle in 0f..10f
        _uiState.update { it.copy(clockAngle = newAngle, isClockUnlocked = unlocked) }
    }

    fun feedNekoCat() {
        _uiState.update { it.copy(nekoCatsCollected = it.nekoCatsCollected + 1) }
    }

    fun tapFlappyDroid() {
        _uiState.update { current ->
            if (current.flappyGameOver) {
                current.copy(flappyScore = 1, flappyGameOver = false)
            } else {
                current.copy(flappyScore = current.flappyScore + 1)
            }
        }
    }

    // Trivia methods
    fun selectQuizAnswer(index: Int) {
        if (_uiState.value.isQuestionAnswered) return
        val currentQ = _uiState.value.quizQuestions[_uiState.value.currentQuizIndex]
        val isCorrect = index == currentQ.correctIndex
        _uiState.update {
            it.copy(
                selectedOptionIndex = index,
                isQuestionAnswered = true,
                quizScore = if (isCorrect) it.quizScore + 1 else it.quizScore
            )
        }
    }

    fun nextQuizQuestion() {
        val current = _uiState.value
        if (current.currentQuizIndex + 1 < current.quizQuestions.size) {
            _uiState.update {
                it.copy(
                    currentQuizIndex = it.currentQuizIndex + 1,
                    selectedOptionIndex = null,
                    isQuestionAnswered = false
                )
            }
        } else {
            _uiState.update { it.copy(isQuizFinished = true) }
        }
    }

    fun restartQuiz() {
        _uiState.update {
            it.copy(
                currentQuizIndex = 0,
                selectedOptionIndex = null,
                isQuestionAnswered = false,
                quizScore = 0,
                isQuizFinished = false
            )
        }
    }
}
