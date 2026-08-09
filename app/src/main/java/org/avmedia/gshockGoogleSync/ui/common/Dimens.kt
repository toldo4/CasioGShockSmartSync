package org.avmedia.gshockGoogleSync.ui.common

import androidx.compose.ui.unit.dp

/**
 * Shared minimum height for a toggleable list row (actions, alarms).
 *
 * An alarm row is naturally about this tall because it carries a 36.sp clock, while an
 * action row only carries a 20.sp label and would otherwise sit at roughly half the
 * height. Both apply this floor so the two lists read as the same control, and so the
 * rows stay a comfortable touch target.
 */
val ListRowMinHeight = 60.dp
