package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Egg
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.FlightTakeoff
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.EasterEggType
import com.example.data.model.QuizQuestion
import com.example.ui.theme.AndroidGreen
import com.example.ui.theme.GoogleBlue
import com.example.ui.theme.GoogleRed

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun TriviaAndEasterEggScreen(
    questions: List<QuizQuestion>,
    currentQuestionIndex: Int,
    selectedOptionIndex: Int?,
    isAnswered: Boolean,
    score: Int,
    isFinished: Boolean,
    onSelectAnswer: (Int) -> Unit,
    onNextQuestion: () -> Unit,
    onRestartQuiz: () -> Unit,
    onLaunchEasterEgg: (EasterEggType) -> Unit,
    modifier: Modifier = Modifier
) {
    var subTab by remember { mutableIntStateOf(0) }

    Column(modifier = modifier.fillMaxSize()) {
        PrimaryTabRow(
            selectedTabIndex = subTab,
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            Tab(
                selected = subTab == 0,
                onClick = { subTab = 0 },
                text = { Text("Easter Egg Arcade") },
                icon = { Icon(Icons.Default.Egg, contentDescription = null) }
            )
            Tab(
                selected = subTab == 1,
                onClick = { subTab = 1 },
                text = { Text("History Quiz") },
                icon = { Icon(Icons.Default.Quiz, contentDescription = null) }
            )
        }

        if (subTab == 0) {
            EasterEggArcadeView(onLaunchEasterEgg = onLaunchEasterEgg)
        } else {
            QuizView(
                questions = questions,
                currentQuestionIndex = currentQuestionIndex,
                selectedOptionIndex = selectedOptionIndex,
                isAnswered = isAnswered,
                score = score,
                isFinished = isFinished,
                onSelectAnswer = onSelectAnswer,
                onNextQuestion = onNextQuestion,
                onRestartQuiz = onRestartQuiz
            )
        }
    }
}

@Composable
private fun EasterEggArcadeView(
    onLaunchEasterEgg: (EasterEggType) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .testTag("easter_egg_arcade")
    ) {
        Text(
            text = "EASTER EGG MUSEUM & ARCADE",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 1.2.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Interactive Secret Minigames",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Every major Android release hides an iconic secret easter egg in Settings. Tap any card below to launch its interactive playable simulator!",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(16.dp))

        ArcadeLauncherCard(
            title = "Android 12/13: Material You Clock",
            versionLabel = "Android 12 & 13",
            description = "Interactive analog clock widget. Rotate the hands to 12:00 to trigger a colorful dynamic color burst!",
            icon = Icons.Default.Schedule,
            color = GoogleBlue,
            onClick = { onLaunchEasterEgg(EasterEggType.ANDROID_12_CLOCK) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        ArcadeLauncherCard(
            title = "Android 7/11: Neko Cat Feeder",
            versionLabel = "Android 7.0 & 11",
            description = "Leave food on the secret Quick Settings dish to lure and collect quirky Bugdroid felines!",
            icon = Icons.Default.Pets,
            color = AndroidGreen,
            onClick = { onLaunchEasterEgg(EasterEggType.NOUGAT_CAT) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        ArcadeLauncherCard(
            title = "Android 5/6: Flappy Droid",
            versionLabel = "Android 5.0 Lollipop",
            description = "The notorious Flappy Bird clone where you tap to guide Bugdroid through spinning candy lollipops!",
            icon = Icons.Default.FlightTakeoff,
            color = Color(0xFFFF5722),
            onClick = { onLaunchEasterEgg(EasterEggType.LOLLIPOP_FLAPPY) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        ArcadeLauncherCard(
            title = "Android 14/15: Deep Space Lander",
            versionLabel = "Android 14 & 15",
            description = "Control retro rockets and thrusters to navigate deep space and touch down safely on planetary landing pads!",
            icon = Icons.Default.RocketLaunch,
            color = Color(0xFF7C4DFF),
            onClick = { onLaunchEasterEgg(EasterEggType.ANDROID_14_ROCKET) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        ArcadeLauncherCard(
            title = "Android 2.3: The Zombie Art Classic",
            versionLabel = "Android 2.3 Gingerbread",
            description = "The historic painting by Jack Larson that initiated Android's Easter Egg tradition 16 years ago.",
            icon = Icons.Default.Android,
            color = Color(0xFF8D6E63),
            onClick = { onLaunchEasterEgg(EasterEggType.ZOMBIE_ART) }
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
private fun ArcadeLauncherCard(
    title: String,
    versionLabel: String,
    description: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                color = color.copy(alpha = 0.2f),
                modifier = Modifier.size(48.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = color,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = color.copy(alpha = 0.15f)
                ) {
                    Text(
                        text = versionLabel,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = color,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
private fun QuizView(
    questions: List<QuizQuestion>,
    currentQuestionIndex: Int,
    selectedOptionIndex: Int?,
    isAnswered: Boolean,
    score: Int,
    isFinished: Boolean,
    onSelectAnswer: (Int) -> Unit,
    onNextQuestion: () -> Unit,
    onRestartQuiz: () -> Unit
) {
    if (isFinished) {
        // Quiz Finished Scorecard
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.EmojiEvents,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Quiz Completed!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "You scored $score out of ${questions.size} questions correct!",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = when {
                        score >= 10 -> "🏆 Android Master Architect: You know your Bugdroid lore inside out!"
                        score >= 7 -> "📱 Android Power User: Excellent grasp of Android releases and Google milestones!"
                        else -> "🌱 Android Enthusiast: Great effort! Re-explore the timeline and try again!"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onRestartQuiz,
                modifier = Modifier.testTag("restart_quiz_button")
            ) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Play Again")
            }
        }
        return
    }

    val currentQ = questions[currentQuestionIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .testTag("quiz_view")
    ) {
        // Progress header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "QUESTION ${currentQuestionIndex + 1} OF ${questions.size}",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary,
                letterSpacing = 1.1.sp
            )
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                Text(
                    text = "Score: $score",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Question Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Text(
                text = currentQ.question,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                modifier = Modifier.padding(18.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Options
        currentQ.options.forEachIndexed { index, option ->
            val isSelected = selectedOptionIndex == index
            val isCorrect = index == currentQ.correctIndex

            val optionColor by animateColorAsState(
                targetValue = when {
                    !isAnswered && isSelected -> MaterialTheme.colorScheme.primary
                    isAnswered && isCorrect -> AndroidGreen
                    isAnswered && isSelected && !isCorrect -> GoogleRed
                    else -> MaterialTheme.colorScheme.surfaceVariant
                },
                label = "optionColor"
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
                    .clickable(enabled = !isAnswered) { onSelectAnswer(index) }
                    .testTag("quiz_option_$index"),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isAnswered && (isCorrect || isSelected)) optionColor.copy(alpha = 0.2f)
                                     else MaterialTheme.colorScheme.surfaceVariant
                ),
                border = if (isAnswered && (isCorrect || isSelected)) borderStroke(2.dp, optionColor) else null
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = CircleShape,
                        color = optionColor,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "${('A'.code + index).toChar()}",
                                fontWeight = FontWeight.Bold,
                                color = if (isAnswered && (isCorrect || isSelected)) Color.Black else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = option,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = if (isSelected || (isAnswered && isCorrect)) FontWeight.Bold else FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        // Explanation & Fun Fact card when answered
        AnimatedVisibility(visible = isAnswered) {
            Column(modifier = Modifier.padding(top = 14.dp)) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
                    )
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "HISTORICAL CONTEXT",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = currentQ.explanation,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Lightbulb,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.tertiary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Fun Fact: ${currentQ.funFact}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Button(
                    onClick = onNextQuestion,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("next_quiz_question_button")
                ) {
                    Text(
                        text = if (currentQuestionIndex + 1 == questions.size) "Finish Quiz" else "Next Question"
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

private fun borderStroke(width: androidx.compose.ui.unit.Dp, color: Color) =
    androidx.compose.foundation.BorderStroke(width, color)
