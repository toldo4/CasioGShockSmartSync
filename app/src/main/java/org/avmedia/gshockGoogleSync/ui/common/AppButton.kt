package org.avmedia.gshockGoogleSync.ui.common

import AppText
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        // Hard rectangle with a solid rule around it -- reads as a moulded watch
        // button rather than a Material capsule.
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(
            1.dp,
            if (enabled) MaterialTheme.colorScheme.onSurface
            else MaterialTheme.colorScheme.outlineVariant
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.onSurface,
            disabledContentColor = MaterialTheme.colorScheme.outlineVariant
        ),
        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
    ) {
        AppText(
            text = text.uppercase(),
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            letterSpacing = 1.5.sp,
            textAlign = TextAlign.Center
        )
    }
}
