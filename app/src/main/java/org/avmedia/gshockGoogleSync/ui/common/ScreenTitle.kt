package org.avmedia.gshockGoogleSync.ui.common

import AppText
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenTitle(
    text: String,
    modifier: Modifier
) {
    val defaultModifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 4.dp, vertical = 10.dp)

    // Wide-tracked caps, like the mode label silkscreened on a watch bezel.
    AppText(
        text = text.uppercase(),
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 4.sp,
        modifier = defaultModifier.then(modifier),
        textAlign = TextAlign.Center
    )
}
