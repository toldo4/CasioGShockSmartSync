package org.avmedia.gshockGoogleSync.ui.actions

import AppTextLarge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.avmedia.gshockGoogleSync.R

@Composable
fun SeparatorView() {
    data class ViewState(
        val text: String
    )

    val viewState = ViewState(
        text = stringResource(id = R.string.emergency_actions)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            // Breathing room above, so the heading reads as starting a new group
            // rather than being clamped to the card above it.
            .padding(start = 12.dp, top = 20.dp, bottom = 4.dp)
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppTextLarge(text = viewState.text)
    }
}
