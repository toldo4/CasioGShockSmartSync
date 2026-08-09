import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun AppTextExtraLarge(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 36.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = fontWeight,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}