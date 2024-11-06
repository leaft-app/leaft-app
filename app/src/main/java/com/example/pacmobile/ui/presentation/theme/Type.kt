package com.example.pacmobile.ui.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.example.pacmobile.R

// Definindo o Provider para Google Fonts
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

// Definindo a família de fontes Inter com várias variantes de peso
val interFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Inter"),
        weight = FontWeight.Normal,
        fontProvider = provider
    ),
    Font(
        googleFont = GoogleFont("Inter"),
        weight = FontWeight.Bold,
        fontProvider = provider
    ),
    Font(
        googleFont = GoogleFont("Inter"),
        weight = FontWeight.Light,
        fontProvider = provider
    ),
    Font(
        googleFont = GoogleFont("Inter"),
        weight = FontWeight.Medium,
        fontProvider = provider
    ),
    Font(
        googleFont = GoogleFont("Inter"),
        weight = FontWeight.SemiBold,
        fontProvider = provider
    )
)

// Default Material 3 typography values
val baseline = Typography()

// Custom Typography usando as variantes da fonte Inter
val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = interFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = interFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = interFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = interFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = interFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = interFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = interFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = interFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = interFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = interFontFamily, fontWeight = FontWeight.Normal), // Usando Inter Normal
    bodyMedium = baseline.bodyMedium.copy(fontFamily = interFontFamily, fontWeight = FontWeight.Light), // Usando Inter Light
    bodySmall = baseline.bodySmall.copy(fontFamily = interFontFamily, fontWeight = FontWeight.Light), // Usando Inter Light
    labelLarge = baseline.labelLarge.copy(fontFamily = interFontFamily, fontWeight = FontWeight.Bold), // Usando Inter Bold
    labelMedium = baseline.labelMedium.copy(fontFamily = interFontFamily, fontWeight = FontWeight.Bold), // Usando Inter Bold
    labelSmall = baseline.labelSmall.copy(fontFamily = interFontFamily, fontWeight = FontWeight.Bold) // Usando Inter Bold
)
