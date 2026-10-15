package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Architecture
import androidx.compose.material.icons.filled.Egg
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.EasterEggSimulatorDialog
import com.example.ui.screens.ArchitectureScreen
import com.example.ui.screens.HardwareScreen
import com.example.ui.screens.ReleaseDetailScreen
import com.example.ui.screens.TimelineScreen
import com.example.ui.screens.TriviaAndEasterEggScreen
import com.example.ui.theme.AndroidGreen
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.AppTab
import com.example.ui.viewmodel.HistoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                AndroidHistoryApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndroidHistoryApp(
    viewModel: HistoryViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // If a specific release detail is opened, show full-bleed detail screen
    if (uiState.selectedRelease != null) {
        val release = uiState.selectedRelease!!
        ReleaseDetailScreen(
            release = release,
            isBookmarked = uiState.bookmarkedReleaseIds.contains(release.id),
            onToggleBookmark = { viewModel.toggleBookmark(release.id) },
            onBack = { viewModel.closeReleaseDetail() },
            onLaunchEasterEgg = { viewModel.launchEasterEgg(release.easterEgg.type) }
        )
    } else {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = when (uiState.currentTab) {
                                AppTab.CHRONICLE -> "Android Chronicle"
                                AppTab.HARDWARE -> "Hardware Hall of Fame"
                                AppTab.ARCHITECTURE -> "Under The Hood"
                                AppTab.TRIVIA_MUSEUM -> "Easter Eggs & Quiz"
                            },
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 19.sp
                        )
                    },
                    navigationIcon = {
                        Surface(
                            shape = androidx.compose.foundation.shape.CircleShape,
                            color = AndroidGreen.copy(alpha = 0.2f),
                            modifier = Modifier
                                .padding(start = 12.dp, end = 8.dp)
                                .size(34.dp)
                        ) {
                            Box(contentAlignment = androidx.compose.ui.Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Android,
                                    contentDescription = "Android Robot",
                                    tint = AndroidGreen,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            },
            bottomBar = {
                NavigationBar(
                    modifier = Modifier
                        .testTag("bottom_nav_bar")
                        .windowInsetsPadding(WindowInsets.navigationBars),
                    containerColor = MaterialTheme.colorScheme.surface
                ) {
                    NavigationBarItem(
                        selected = uiState.currentTab == AppTab.CHRONICLE,
                        onClick = { viewModel.selectTab(AppTab.CHRONICLE) },
                        icon = { Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = "Chronicle") },
                        label = { Text("Releases", fontSize = 11.sp) },
                        modifier = Modifier.testTag("nav_tab_releases"),
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                    NavigationBarItem(
                        selected = uiState.currentTab == AppTab.HARDWARE,
                        onClick = { viewModel.selectTab(AppTab.HARDWARE) },
                        icon = { Icon(Icons.Default.PhoneAndroid, contentDescription = "Hardware") },
                        label = { Text("Hardware", fontSize = 11.sp) },
                        modifier = Modifier.testTag("nav_tab_hardware"),
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                    NavigationBarItem(
                        selected = uiState.currentTab == AppTab.ARCHITECTURE,
                        onClick = { viewModel.selectTab(AppTab.ARCHITECTURE) },
                        icon = { Icon(Icons.Default.Architecture, contentDescription = "Architecture") },
                        label = { Text("Engineering", fontSize = 11.sp) },
                        modifier = Modifier.testTag("nav_tab_architecture"),
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                    NavigationBarItem(
                        selected = uiState.currentTab == AppTab.TRIVIA_MUSEUM,
                        onClick = { viewModel.selectTab(AppTab.TRIVIA_MUSEUM) },
                        icon = { Icon(Icons.Default.Egg, contentDescription = "Arcade") },
                        label = { Text("Museum", fontSize = 11.sp) },
                        modifier = Modifier.testTag("nav_tab_trivia"),
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            AnimatedContent(
                targetState = uiState.currentTab,
                transitionSpec = { fadeIn() togetherWith fadeOut() },
                label = "tab_transition",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) { tab ->
                when (tab) {
                    AppTab.CHRONICLE -> {
                        TimelineScreen(
                            releases = uiState.releases,
                            totalHardwareCount = uiState.hardwareDevices.size,
                            totalArchitectureCount = uiState.architectureTopics.size,
                            searchQuery = uiState.searchQuery,
                            selectedEra = uiState.selectedEra,
                            bookmarkedIds = uiState.bookmarkedReleaseIds,
                            showOnlyBookmarked = uiState.showOnlyBookmarked,
                            onSearchQueryChange = { viewModel.updateSearchQuery(it) },
                            onSelectEra = { viewModel.selectEra(it) },
                            onToggleBookmark = { viewModel.toggleBookmark(it) },
                            onToggleShowOnlyBookmarked = { viewModel.toggleShowOnlyBookmarked() },
                            onSelectRelease = { viewModel.openReleaseDetail(it) },
                            onLaunchEasterEgg = { viewModel.launchEasterEgg(it) }
                        )
                    }
                    AppTab.HARDWARE -> {
                        HardwareScreen(
                            devices = uiState.hardwareDevices
                        )
                    }
                    AppTab.ARCHITECTURE -> {
                        ArchitectureScreen(
                            topics = uiState.architectureTopics
                        )
                    }
                    AppTab.TRIVIA_MUSEUM -> {
                        TriviaAndEasterEggScreen(
                            questions = uiState.quizQuestions,
                            currentQuestionIndex = uiState.currentQuizIndex,
                            selectedOptionIndex = uiState.selectedOptionIndex,
                            isAnswered = uiState.isQuestionAnswered,
                            score = uiState.quizScore,
                            isFinished = uiState.isQuizFinished,
                            onSelectAnswer = { viewModel.selectQuizAnswer(it) },
                            onNextQuestion = { viewModel.nextQuizQuestion() },
                            onRestartQuiz = { viewModel.restartQuiz() },
                            onLaunchEasterEgg = { viewModel.launchEasterEgg(it) }
                        )
                    }
                }
            }
        }
    }

    // Easter Egg Dialog
    if (uiState.activeEasterEgg != null) {
        EasterEggSimulatorDialog(
            type = uiState.activeEasterEgg!!,
            onDismiss = { viewModel.dismissEasterEgg() }
        )
    }
}
