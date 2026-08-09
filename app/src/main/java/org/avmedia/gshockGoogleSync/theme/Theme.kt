package org.avmedia.gshockGoogleSync.theme

import android.app.Activity
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.core.view.WindowCompat

// A single locked scheme: the LCD looks like an LCD in both system themes, so there
// is no dark variant and no dynamic (Material You) colour. Dynamic colour in
// particular has to stay off -- it overrides every colour below on Android 12+.
private val LcdColorScheme =
        lightColorScheme(
                primary = LcdInk,
                onPrimary = LcdBackground,
                primaryContainer = LcdSurfaceVariant,
                onPrimaryContainer = LcdInk,
                secondary = LcdInkDim,
                onSecondary = LcdBackground,
                secondaryContainer = LcdSurfaceVariant,
                onSecondaryContainer = LcdInk,
                tertiary = LcdOutlineStrong,
                onTertiary = LcdBackground,
                tertiaryContainer = LcdSurfaceVariant,
                onTertiaryContainer = LcdInk,
                error = LcdError,
                onError = LcdOnError,
                errorContainer = LcdErrorContainer,
                onErrorContainer = LcdOnErrorContainer,
                background = LcdBackground,
                onBackground = LcdInk,
                surface = LcdSurface,
                onSurface = LcdInk,
                surfaceVariant = LcdSurfaceVariant,
                onSurfaceVariant = LcdInkDim,
                surfaceContainerLowest = LcdBackground,
                surfaceContainerLow = LcdSurfaceContainer,
                surfaceContainer = LcdSurfaceContainer,
                surfaceContainerHigh = LcdSurfaceVariant,
                surfaceContainerHighest = LcdSurfaceVariant,
                outline = LcdOutline,
                outlineVariant = LcdInkGhost,
                inverseSurface = LcdInk,
                inverseOnSurface = LcdBackground,
                inversePrimary = LcdBackground,
                scrim = LcdInk,
        )

@Composable
fun getCurrentColorScheme(darkTheme: Boolean): ColorScheme = LcdColorScheme

@Composable
fun GShockSmartSyncTheme(
        darkTheme: Boolean = false,
        dynamicColor: Boolean = false,
        content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val activity = view.context as? Activity
            val window = activity?.window

            if (window != null) {
                // The LCD backing is light, so status bar icons must be dark.
                val insetsController = WindowCompat.getInsetsController(window, view)
                insetsController.isAppearanceLightStatusBars = true
                insetsController.isAppearanceLightNavigationBars = true
            }
        }
    }

    MaterialTheme(
            colorScheme = LcdColorScheme,
            shapes = Shapes,
            typography = Typography,
    ) {
        // Material3's Text reads LocalTextStyle, which defaults to TextStyle.Default
        // (sans-serif) rather than to the typography above. Without this, every bare
        // Text call in the app would keep the old font.
        //
        // Only the family is provided, deliberately. Providing a full style such as
        // bodyLarge would also impose its lineHeight on callers that override just
        // fontSize -- a 36.sp alarm clock would end up in a 24.sp line box.
        ProvideTextStyle(TextStyle(fontFamily = FontFamily.Monospace), content)
    }
}
