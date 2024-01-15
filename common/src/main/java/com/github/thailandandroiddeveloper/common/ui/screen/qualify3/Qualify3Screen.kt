package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify3Screen() {
    // TODO: Qualify3
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion