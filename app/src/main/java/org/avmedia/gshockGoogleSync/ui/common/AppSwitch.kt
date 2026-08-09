import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

private val TrackWidth = 46.dp
private val TrackHeight = 26.dp
private val ThumbWidth = 18.dp
private val TrackInset = 3.dp

/**
 * Rectangular replacement for Material3's Switch, which has no shape parameter and is
 * always a capsule.
 *
 * Reads as a lit segment: the track fills solid with ink when on, and the thumb is a
 * hard block that slides between the two ends. No ripple -- a mechanical toggle does
 * not glow.
 */
@Composable
fun AppSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val ink =
        if (enabled) MaterialTheme.colorScheme.onSurface
        else MaterialTheme.colorScheme.outlineVariant
    val well = MaterialTheme.colorScheme.surface

    val thumbOffset by animateDpAsState(
        targetValue = if (checked) TrackWidth - ThumbWidth - TrackInset * 2 else 0.dp,
        label = "thumbOffset"
    )

    Box(
        modifier = modifier
            .size(width = TrackWidth, height = TrackHeight)
            .toggleable(
                value = checked,
                enabled = enabled,
                role = Role.Switch,
                // Null indication: the default ripple spills a soft round shape over
                // the square track.
                indication = null,
                interactionSource = null,
                onValueChange = onCheckedChange
            )
            .background(if (checked) ink else Color.Transparent)
            .border(1.dp, ink, RectangleShape)
            .padding(TrackInset),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .offset(x = thumbOffset)
                .width(ThumbWidth)
                .fillMaxHeight()
                .background(if (checked) well else ink)
        )
    }
}
