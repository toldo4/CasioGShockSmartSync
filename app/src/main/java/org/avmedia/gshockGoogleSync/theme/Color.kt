package org.avmedia.gshockGoogleSync.theme

import androidx.compose.ui.graphics.Color

// Retro Casio LCD palette.
//
// The look is a segment display: a green-grey backing lit from behind, with
// near-black "ink" for lit segments and a washed-out version of that ink for
// unlit/secondary text. There is deliberately no colour hue beyond the green-grey
// and the ink -- an LCD only has two states, so accents are made with weight and
// borders instead of hue.

// Backing plate, lightest to darkest.
val LcdBackground = Color(0xFFC5CCB8)      // the screen itself
val LcdSurface = Color(0xFFC5CCB8)
val LcdSurfaceContainer = Color(0xFFBCC4AE) // panels sitting on the screen
val LcdSurfaceVariant = Color(0xFFB0B9A1)   // recessed / pressed areas

// Ink.
val LcdInk = Color(0xFF1C1F18)             // lit segment, full contrast
val LcdInkDim = Color(0xFF4A5044)          // secondary text
val LcdInkGhost = Color(0xFF8A9280)        // unlit segment / disabled

// Structure.
val LcdOutline = Color(0xFF6E7566)         // hairline borders between panels
val LcdOutlineStrong = Color(0xFF2E3D2A)   // emphasised border, e.g. focused control

// The one place a hue is allowed: alerts, matching an LCD backlight warning.
val LcdError = Color(0xFF8C2016)
val LcdOnError = Color(0xFFE6E9DE)
val LcdErrorContainer = Color(0xFFB8A99C)
val LcdOnErrorContainer = Color(0xFF3A0F0A)
