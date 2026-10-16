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
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CompareArrows
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material.icons.filled.Egg
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.EasterEggSimulatorDialog
import com.example.ui.screens.ArchitectureScreen
import com.example.ui.screens.CounterpartsScreen
import com.example.ui.screens.GeminiAssistantScreen
import com.example.ui.screens.GradleScreen
import com.example.ui.screens.GraveyardScreen
import com.example.ui.screens.HardwareScreen
import com.example.ui.screens.ReleaseDetailScreen
import com.example.ui.screens.TimelineScreen
import com.example.ui.screens.TriviaAndEasterEggScreen
import com.example.ui.theme.AndroidGreen
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.AppTab
import com.example.ui.viewmodel.HistoryViewModel

enum class MainNavHub {
    RELEASES,
    HARDWARE,
    ENGINEERING,
    COUNTERPARTS_GRAVEYARD,
    AI_ARCADE
}

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
    var activeHub by remember { mutableStateOf(MainNavHub.RELEASES) }

    // Subtab indices for multi-view hubs
    var engineeringSubTab by remember { mutableIntStateOf(0) } // 0 = Architecture, 1 = Gradle
    var comparisonSubTab by remember { mutableIntStateOf(0) } // 0 = Counterparts, 1 = Graveyard
    var aiArcadeSubTab by remember { mutableIntStateOf(0) } // 0 = Gemini AI, 1 = Arcade & Quiz

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
                            text = when (activeHub) {
                                MainNavHub.RELEASES -> "Android Chronicle"
                                MainNavHub.HARDWARE -> "Hardware Hall of Fame"
                                MainNavHub.ENGINEERING -> if (engineeringSubTab == 0) "Under The Hood" else "Gradle Build Engine"
                                MainNavHub.COUNTERPARTS_GRAVEYARD -> if (comparisonSubTab == 0) "Android Counterparts" else "The Android Graveyard"
                                MainNavHub.AI_ARCADE -> if (aiArcadeSubTab == 0) "Ask Gemini AI" else "Easter Eggs & Quiz"
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
                            Box(contentAlignment = Alignment.Center) {
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
                        selected = activeHub == MainNavHub.RELEASES,
                        onClick = { activeHub = MainNavHub.RELEASES },
                        icon = { Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = "Releases") },
                        label = { Text("Releases", fontSize = 10.sp) },
                        modifier = Modifier.testTag("nav_tab_releases"),
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                    NavigationBarItem(
                        selected = activeHub == MainNavHub.HARDWARE,
                        onClick = { activeHub = MainNavHub.HARDWARE },
                        icon = { Icon(Icons.Default.PhoneAndroid, contentDescription = "Hardware") },
                        label = { Text("Hardware", fontSize = 10.sp) },
                        modifier = Modifier.testTag("nav_tab_hardware"),
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                    NavigationBarItem(
                        selected = activeHub == MainNavHub.ENGINEERING,
                        onClick = { activeHub = MainNavHub.ENGINEERING },
                        icon = { Icon(Icons.Default.Architecture, contentDescription = "Engineering") },
                        label = { Text("Engineering", fontSize = 10.sp) },
                        modifier = Modifier.testTag("nav_tab_engineering"),
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                    NavigationBarItem(
                        selected = activeHub == MainNavHub.COUNTERPARTS_GRAVEYARD,
                        onClick = { activeHub = MainNavHub.COUNTERPARTS_GRAVEYARD },
                        icon = { Icon(Icons.Default.CompareArrows, contentDescription = "Rivals") },
                        label = { Text("Rivals & Vault", fontSize = 10.sp) },
                        modifier = Modifier.testTag("nav_tab_rivals"),
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                    NavigationBarItem(
                        selected = activeHub == MainNavHub.AI_ARCADE,
                        onClick = { activeHub = MainNavHub.AI_ARCADE },
                        icon = { Icon(Icons.Default.AutoAwesome, contentDescription = "AI & Fun") },
                        label = { Text("Gemini AI", fontSize = 10.sp) },
                        modifier = Modifier.testTag("nav_tab_ai"),
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            AnimatedContent(
                targetState = activeHub,
                transitionSpec = { fadeIn() togetherWith fadeOut() },
                label = "hub_transition",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) { hub ->
                when (hub) {
                    MainNavHub.RELEASES -> {
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
                    MainNavHub.HARDWARE -> {
                        HardwareScreen(
                            devices = uiState.hardwareDevices
                        )
                    }
                    MainNavHub.ENGINEERING -> {
                        Column(modifier = Modifier.fillMaxSize()) {
                            PrimaryTabRow(
                                selectedTabIndex = engineeringSubTab,
                                containerColor = MaterialTheme.colorScheme.surface
                            ) {
                                Tab(
                                    selected = engineeringSubTab == 0,
                                    onClick = { engineeringSubTab = 0 },
                                    text = { Text("OS Architecture") },
                                    icon = { Icon(Icons.Default.Architecture, contentDescription = null) }
                                )
                                Tab(
                                    selected = engineeringSubTab == 1,
                                    onClick = { engineeringSubTab = 1 },
                                    text = { Text("Gradle & Build System") },
                                    icon = { Icon(Icons.Default.Build, contentDescription = null) }
                                )
                            }
                            if (engineeringSubTab == 0) {
                                ArchitectureScreen(topics = uiState.architectureTopics)
                            } else {
                                GradleScreen(
                                    milestones = uiState.gradleMilestones,
                                    topics = uiState.gradleTopics
                                )
                            }
                        }
                    }
                    MainNavHub.COUNTERPARTS_GRAVEYARD -> {
                        Column(modifier = Modifier.fillMaxSize()) {
                            PrimaryTabRow(
                                selectedTabIndex = comparisonSubTab,
                                containerColor = MaterialTheme.colorScheme.surface
                            ) {
                                Tab(
                                    selected = comparisonSubTab == 0,
                                    onClick = { comparisonSubTab = 0 },
                                    text = { Text("Android vs iOS") },
                                    icon = { Icon(Icons.Default.CompareArrows, contentDescription = null) }
                                )
                                Tab(
                                    selected = comparisonSubTab == 1,
                                    onClick = { comparisonSubTab = 1 },
                                    text = { Text("Killed Features Graveyard") },
                                    icon = { Icon(Icons.Default.DeleteSweep, contentDescription = null) }
                                )
                            }
                            if (comparisonSubTab == 0) {
                                CounterpartsScreen(comparisons = uiState.counterpartComparisons)
                            } else {
                                GraveyardScreen(features = uiState.graveyardFeatures)
                            }
                        }
                    }
                    MainNavHub.AI_ARCADE -> {
                        Column(modifier = Modifier.fillMaxSize()) {
                            PrimaryTabRow(
                                selectedTabIndex = aiArcadeSubTab,
                                containerColor = MaterialTheme.colorScheme.surface
                            ) {
                                Tab(
                                    selected = aiArcadeSubTab == 0,
                                    onClick = { aiArcadeSubTab = 0 },
                                    text = { Text("Ask Gemini AI") },
                                    icon = { Icon(Icons.Default.SmartToy, contentDescription = null) }
                                )
                                Tab(
                                    selected = aiArcadeSubTab == 1,
                                    onClick = { aiArcadeSubTab = 1 },
                                    text = { Text("Easter Eggs & Quiz") },
                                    icon = { Icon(Icons.Default.Egg, contentDescription = null) }
                                )
                            }
                            if (aiArcadeSubTab == 0) {
                                GeminiAssistantScreen(
                                    messages = uiState.geminiChatMessages,
                                    isLoading = uiState.isGeminiLoading,
                                    onSendMessage = { viewModel.sendGeminiMessage(it) }
                                )
                            } else {
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
