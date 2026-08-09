package org.avmedia.gshockGoogleSync.ui.others

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.avmedia.gshockGoogleSync.R

@Composable
fun WatchImageWithOverlay(
    modifier: Modifier = Modifier,
    imageResId: Int = R.drawable.gw_b5600,
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Watch Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun WatchImageWithOverlayAlwaysConnected(
    modifier: Modifier = Modifier,
    imageResId: Int = R.drawable.gw_b5600,
) {
    BoxWithConstraints(modifier = modifier) {
        val screenHeightPx = with(LocalDensity.current) { maxHeight.toPx() }
        val textOffsetPx = screenHeightPx * 0.75f // Position text 3/4 down the screen

        // Background watch image
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Watch Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )

        // Centered text overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(top = with(LocalDensity.current) { textOffsetPx.toDp() }),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = stringResource(
                    R.string.find_phone_instruction
                ),
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
