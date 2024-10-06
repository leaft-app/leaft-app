package com.example.pacmobile.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import com.example.pacmobile.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

// Definindo as variantes de fonte
val interBoldFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Inter"),
        weight = FontWeight.Bold,
        fontProvider = provider,
    )
)

val interLightFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Inter"),
        weight = FontWeight.Light,
        fontProvider = provider,
    )
)

val bodyFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Inter"),
        fontProvider = provider,
    )
)

val displayFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Inter"),
        fontProvider = provider,
    )
)

// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = displayFontFamily ), // Use Inter Regular aqui
    bodyMedium = baseline.bodyMedium.copy(fontFamily = interLightFontFamily), // Usando Inter Light
    bodySmall = baseline.bodySmall.copy(fontFamily = interLightFontFamily), // Usando Inter Light
    labelLarge = baseline.labelLarge.copy(fontFamily = interBoldFontFamily), // Usando Inter Bold
    labelMedium = baseline.labelMedium.copy(fontFamily = interBoldFontFamily), // Usando Inter Bold
    labelSmall = baseline.labelSmall.copy(fontFamily = interBoldFontFamily), // Usando Inter Bold
)
