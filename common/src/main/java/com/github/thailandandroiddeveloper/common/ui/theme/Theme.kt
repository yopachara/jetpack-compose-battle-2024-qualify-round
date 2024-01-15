package com.github.thailandandroiddeveloper.common.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = DarkColors.Primary,
    onPrimary = DarkColors.OnPrimary,
    primaryContainer = DarkColors.PrimaryContainer,
    onPrimaryContainer = DarkColors.OnPrimaryContainer,
    inversePrimary = DarkColors.InversePrimary,
    secondary = DarkColors.Secondary,
    onSecondary = DarkColors.OnSecondary,
    secondaryContainer = DarkColors.SecondaryContainer,
    onSecondaryContainer = DarkColors.OnSecondaryContainer,
    tertiary = DarkColors.Tertiary,
    onTertiary = DarkColors.OnTertiary,
    tertiaryContainer = DarkColors.TertiaryContainer,
    onTertiaryContainer = DarkColors.OnTertiaryContainer,
    background = DarkColors.Background,
    onBackground = DarkColors.OnBackground,
    surface = DarkColors.Surface,
    onSurface = DarkColors.OnSurface,
    surfaceVariant = DarkColors.SurfaceVariant,
    onSurfaceVariant = DarkColors.OnSurfaceVariant,
    surfaceTint = DarkColors.SurfaceTint,
    inverseSurface = DarkColors.InverseSurface,
    inverseOnSurface = DarkColors.InverseOnSurface,
    error = DarkColors.Error,
    onError = DarkColors.OnError,
    errorContainer = DarkColors.ErrorContainer,
    onErrorContainer = DarkColors.OnErrorContainer,
    outline = DarkColors.Outline,
    outlineVariant = DarkColors.OutlineVariant,
    scrim = DarkColors.Scrim,
)

private val LightColorScheme = lightColorScheme(
    primary = LightColors.Primary,
    onPrimary = LightColors.OnPrimary,
    primaryContainer = LightColors.PrimaryContainer,
    onPrimaryContainer = LightColors.OnPrimaryContainer,
    inversePrimary = LightColors.InversePrimary,
    secondary = LightColors.Secondary,
    onSecondary = LightColors.OnSecondary,
    secondaryContainer = LightColors.SecondaryContainer,
    onSecondaryContainer = LightColors.OnSecondaryContainer,
    tertiary = LightColors.Tertiary,
    onTertiary = LightColors.OnTertiary,
    tertiaryContainer = LightColors.TertiaryContainer,
    onTertiaryContainer = LightColors.OnTertiaryContainer,
    background = LightColors.Background,
    onBackground = LightColors.OnBackground,
    surface = LightColors.Surface,
    onSurface = LightColors.OnSurface,
    surfaceVariant = LightColors.SurfaceVariant,
    onSurfaceVariant = LightColors.OnSurfaceVariant,
    surfaceTint = LightColors.SurfaceTint,
    inverseSurface = LightColors.InverseSurface,
    inverseOnSurface = LightColors.InverseOnSurface,
    error = LightColors.Error,
    onError = LightColors.OnError,
    errorContainer = LightColors.ErrorContainer,
    onErrorContainer = LightColors.OnErrorContainer,
    outline = LightColors.Outline,
    outlineVariant = LightColors.OutlineVariant,
    scrim = LightColors.Scrim,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window ?: return@SideEffect

            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}