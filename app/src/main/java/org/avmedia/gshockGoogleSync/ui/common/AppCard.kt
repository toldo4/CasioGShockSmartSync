package org.avmedia.gshockGoogleSync.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    padding: Dp = 3.dp,
    // Flat by default. Elevation implies a surface floating above another one, which
    // is the opposite of a segment printed onto a single sheet of glass; panels are
    // separated by a hairline rule instead.
    elevation: Dp = 0.dp,
    borderWidth: Dp = 1.dp,
    borderColor: Color = MaterialTheme.colorScheme.outline,
    containerColor: Color = MaterialTheme.colorScheme.surfaceContainer,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier.padding(padding),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = containerColor),
        elevation = CardDefaults.cardElevation(elevation),
        border = if (borderWidth > 0.dp) BorderStroke(borderWidth, borderColor) else null
    ) {
        content()
    }
}
