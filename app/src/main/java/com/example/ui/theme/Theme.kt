package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = AndroidGreen,
    onPrimary = Color(0xFF003914),
    primaryContainer = Color(0xFF005322),
    onPrimaryContainer = AndroidMint,
    secondary = GoogleBlue,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF1E3A8A),
    onSecondaryContainer = Color(0xFFD2E3FC),
    tertiary = GoogleYellow,
    onTertiary = Color(0xFF3E2E00),
    background = AndroidDarkSurface,
    onBackground = TextPrimaryDark,
    surface = AndroidDarkSurface,
    onSurface = TextPrimaryDark,
    surfaceVariant = AndroidDarkCard,
    onSurfaceVariant = TextSecondaryDark,
    outline = BorderSubtleDark
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00873D),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFB5F2CA),
    onPrimaryContainer = Color(0xFF00210A),
    secondary = GoogleBlue,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFD3E3FD),
    onSecondaryContainer = Color(0xFF041E49),
    tertiary = MaterialOrange,
    onTertiary = Color.White,
    background = Color(0xFFF7FBF8),
    onBackground = Color(0xFF171D1A),
    surface = Color(0xFFF7FBF8),
    onSurface = Color(0xFF171D1A),
    surfaceVariant = Color(0xFFDEE5E0),
    onSurfaceVariant = Color(0xFF414944),
    outline = Color(0xFF717973)
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
