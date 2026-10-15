package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FlightTakeoff
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.model.EasterEggType
import com.example.ui.theme.AndroidGreen
import com.example.ui.theme.GoogleBlue
import com.example.ui.theme.GoogleGreen
import com.example.ui.theme.GoogleRed
import com.example.ui.theme.GoogleYellow

@Composable
fun EasterEggSimulatorDialog(
    type: EasterEggType,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .testTag("easter_egg_dialog"),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Top Header Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Easter Egg Simulator",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.size(32.dp).testTag("close_easter_egg")
                    ) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                when (type) {
                    EasterEggType.ANDROID_12_CLOCK,
                    EasterEggType.ANDROID_13_BUBBLES -> {
                        ClockEasterEggSimulator()
                    }
                    EasterEggType.NOUGAT_CAT,
                    EasterEggType.ANDROID_11_VOLUME -> {
                        NekoCatSimulator()
                    }
                    EasterEggType.LOLLIPOP_FLAPPY,
                    EasterEggType.MARSHMALLOW_FLAPPY -> {
                        FlappyDroidSimulator()
                    }
                    EasterEggType.ANDROID_14_ROCKET,
                    EasterEggType.ANDROID_15_SPACE -> {
                        SpaceLanderSimulator()
                    }
                    else -> {
                        ClassicArtSimulator(type)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Text("Close Simulator", color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
    }
}

@Composable
private fun ClockEasterEggSimulator() {
    var hourAngle by remember { mutableFloatStateOf(60f) }
    val isTwelve = (hourAngle in 350f..360f) || (hourAngle in 0f..10f)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Material You Clock",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Drag the slider to turn the clock hands to 12:00!",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(160.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape)
                .border(4.dp, MaterialTheme.colorScheme.primary, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            // Minute hand (fixed pointing up to 12)
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(60.dp)
                    .align(Alignment.TopCenter)
                    .padding(top = 20.dp)
                    .background(MaterialTheme.colorScheme.onSurface, RoundedCornerShape(2.dp))
            )

            // Hour hand (rotatable)
            val animatedAngle by animateFloatAsState(targetValue = hourAngle, label = "hourHand")
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .rotate(animatedAngle)
            ) {
                Box(
                    modifier = Modifier
                        .width(6.dp)
                        .height(44.dp)
                        .align(Alignment.TopCenter)
                        .padding(top = 36.dp)
                        .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(3.dp))
                )
            }

            // Center Pin
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .background(Color.White, CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Slider(
            value = hourAngle,
            onValueChange = { hourAngle = it },
            valueRange = 0f..360f,
            modifier = Modifier.fillMaxWidth().testTag("clock_slider")
        )

        AnimatedVisibility(visible = isTwelve, enter = fadeIn() + scaleIn()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "🎉 IT'S 12:00! DYNAMIC COLOR BURST!",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = AndroidGreen
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(GoogleBlue, GoogleRed, GoogleYellow, GoogleGreen, AndroidGreen).forEach { bubbleColor ->
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(bubbleColor, CircleShape)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun NekoCatSimulator() {
    var treatCount by remember { mutableIntStateOf(0) }
    var currentCat by remember { mutableStateOf<String?>(null) }
    val catNames = listOf("Pixel", "Jelly", "Marshmallow", "KitKat", "Oreo", "Nougat", "Cupcake", "Bugdroid")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Android Neko Cat Collector",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Tap to place treats on the Quick Settings dish to lure cats!",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.size(130.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                if (currentCat != null) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "🐱", fontSize = 48.sp)
                        Text(
                            text = currentCat ?: "",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                } else {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.Pets,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(36.dp)
                        )
                        Text(
                            text = "Dish is Empty",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Cats Rescued: $treatCount",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                treatCount += 1
                currentCat = "${catNames.random()} #${treatCount}"
            },
            modifier = Modifier.testTag("feed_cat_button")
        ) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text("Leave Chicken Treat")
        }
    }
}

@Composable
private fun FlappyDroidSimulator() {
    var score by remember { mutableIntStateOf(0) }
    var altitude by remember { mutableIntStateOf(50) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Flappy Bugdroid",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Tap 'Jump' to guide Bugdroid through candy obstacles!",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(Color(0xFF0C2417), RoundedCornerShape(16.dp))
                .border(1.dp, AndroidGreen.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                .padding(12.dp)
        ) {
            // Obstacles
            Box(
                modifier = Modifier
                    .width(16.dp)
                    .height(60.dp)
                    .background(GoogleRed, RoundedCornerShape(4.dp))
                    .align(Alignment.TopEnd)
            )
            Box(
                modifier = Modifier
                    .width(16.dp)
                    .height(40.dp)
                    .background(GoogleYellow, RoundedCornerShape(4.dp))
                    .align(Alignment.BottomEnd)
            )

            // Bugdroid position
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .align(if (altitude > 50) Alignment.TopCenter else Alignment.BottomCenter)
                    .background(AndroidGreen, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Android,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = "Score: $score",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.align(Alignment.TopStart)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(
                onClick = {
                    altitude = if (altitude > 50) 20 else 80
                    score += 1
                },
                modifier = Modifier.testTag("flappy_jump_button")
            ) {
                Icon(imageVector = Icons.Default.FlightTakeoff, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("Tap to Flap!")
            }

            Button(
                onClick = { score = 0; altitude = 50 },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Composable
private fun SpaceLanderSimulator() {
    var fuel by remember { mutableIntStateOf(100) }
    var landerStatus by remember { mutableStateOf("In Deep Orbit...") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Deep Space Lander (Android 14/15)",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Fire retrorockets to safely land the Android spacecraft on planetary terrain!",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color(0xFF030712), RoundedCornerShape(16.dp))
                .border(1.dp, GoogleBlue.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Default.RocketLaunch,
                    contentDescription = null,
                    tint = GoogleBlue,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = landerStatus,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Fuel Remaining: $fuel%",
                    style = MaterialTheme.typography.labelSmall,
                    color = if (fuel > 20) GoogleGreen else GoogleRed
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(
                onClick = {
                    if (fuel > 0) {
                        fuel -= 15
                        landerStatus = if (fuel <= 10) "🚀 Touchdown on Mars!" else "🔥 Retrorockets Firing!"
                    }
                },
                enabled = fuel > 0,
                modifier = Modifier.testTag("rocket_thruster_button")
            ) {
                Text("Fire Retrorockets!")
            }

            Button(
                onClick = { fuel = 100; landerStatus = "In Deep Orbit..." },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Text("Reset")
            }
        }
    }
}

@Composable
private fun ClassicArtSimulator(type: EasterEggType) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(12.dp)
    ) {
        Text(
            text = "Classic Easter Egg Vault",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Rapidly tapping the Android version in Settings has been an iconic rite of passage for millions of Android users worldwide since Android 2.3 Gingerbread.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(16.dp))
        Surface(
            shape = CircleShape,
            color = AndroidGreen.copy(alpha = 0.2f),
            modifier = Modifier.size(90.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.Android,
                    contentDescription = null,
                    tint = AndroidGreen,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "“Bugdroid Easter Egg Activated!”",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
