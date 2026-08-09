package org.avmedia.gshockGoogleSync.theme

import android.app.Activity
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.core.view.WindowCompat

// A single locked scheme: the LCD looks like an LCD in both system themes, so there
// is no light variant and no dynamic (Material You) colour. Dynamic colour in
// particular has to stay off -- it overrides every colour below on Android 12+.
//
// darkColorScheme, so that any token not named here (and Material's own elevation
// overlays) resolves dark rather than fighting the near-black backing.
private val LcdColorScheme =
        darkColorScheme(
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
                // Near-black, not ink: the scrim dims what is behind a dialog, and ink
                // is now the light colour.
                scrim = LcdBackground,
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
                // The LCD backing is near-black, so status bar icons must be light.
                val insetsController = WindowCompat.getInsetsController(window, view)
                insetsController.isAppearanceLightStatusBars = false
                insetsController.isAppearanceLightNavigationBars = false
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
