package org.avmedia.gshockGoogleSync.theme

import androidx.compose.ui.graphics.Color

// Retro Casio LCD palette, negative (inverted) display.
//
// Same idea as a standard segment display, with the polarity flipped: the backing is
// near-black and the lit segments glow pale green-grey. There is deliberately no hue
// beyond that pairing -- an LCD only has two states, so emphasis comes from weight and
// borders rather than colour.

// Backing plate, darkest to lightest.
val LcdBackground = Color(0xFF101309)      // the screen itself
val LcdSurface = Color(0xFF101309)
val LcdSurfaceContainer = Color(0xFF1A1E14) // panels sitting on the screen
val LcdSurfaceVariant = Color(0xFF262B1E)   // raised / pressed areas

// Ink -- the lit segments.
val LcdInk = Color(0xFFC5CCB8)             // lit segment, full contrast
val LcdInkDim = Color(0xFF8A9280)          // secondary text
val LcdInkGhost = Color(0xFF4A5044)        // unlit segment / disabled

// Structure.
val LcdOutline = Color(0xFF5C6353)         // hairline borders between panels
val LcdOutlineStrong = Color(0xFF9AA38C)   // emphasised border, e.g. focused control

// The one place a hue is allowed: alerts, matching an LCD backlight warning.
val LcdError = Color(0xFFE0705F)
val LcdOnError = Color(0xFF2A0B06)
val LcdErrorContainer = Color(0xFF5A2018)
val LcdOnErrorContainer = Color(0xFFF2C4BC)
