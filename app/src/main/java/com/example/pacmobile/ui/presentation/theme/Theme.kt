package com.example.pacmobile.ui.presentation.theme


import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


val lightScheme = lightColorScheme(
    primary = DarkGreen,
    onPrimary = White,
    primaryContainer = BrightGreen,
    onPrimaryContainer = FullBlack,
    secondary = MediumGreen,
    onSecondary = PetroGrey,
    secondaryContainer = OtherWhite,
    onSecondaryContainer = FullBlack,
    tertiary = BrightGreen,
    onTertiary = White,
    tertiaryContainer = MediumGreen,
    onTertiaryContainer = FullBlack,
    background = White,
    onBackground = PetroGrey,
    surface = OtherWhite,
    onSurface = PetroGrey,
    surfaceVariant = OtherWhite2,
    onSurfaceVariant = PetroGrey,
    outline = DarkGreen,
    inverseOnSurface = White,
    inverseSurface = PetroGrey,
)

val darkScheme = darkColorScheme(
    primary = DarkGreen,
    onPrimary = OtherWhite2,
    primaryContainer = PetroGrey,
    onPrimaryContainer = BrightGreen,
    secondary = MediumGreen,
    onSecondary = FullBlack,
    secondaryContainer = DarkGreen,
    onSecondaryContainer = White,
    tertiary = BrightGreen,
    onTertiary = FullBlack,
    tertiaryContainer = MediumGreen,
    onTertiaryContainer = White,
    background = FullBlack,
    onBackground = OtherWhite,
    surface = PetroGrey,
    onSurface = OtherWhite2,
    surfaceVariant = DarkGreen,
    onSurfaceVariant = OtherWhite,
    outline = BrightGreen,
    inverseOnSurface = FullBlack,
    inverseSurface = OtherWhite2,
)

@Immutable
data class ExtendedColorScheme(
    val customColor1: ColorFamily,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
