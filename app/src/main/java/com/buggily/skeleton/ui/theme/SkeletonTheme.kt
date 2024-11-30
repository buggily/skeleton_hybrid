package com.buggily.skeleton.ui.theme

import android.content.Context
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun SkeletonTheme(content: @Composable () -> Unit) {
    val context: Context = LocalContext.current
    val isLight: Boolean = !isSystemInDarkTheme()

    val colorScheme: ColorScheme = remember(isLight) {
        if (isLight) {
            lightColorSchemeCompat(context)
        } else {
            darkColorSchemeCompat(context)
        }
    }

    SkeletonTheme(
        colorScheme = colorScheme,
        content = content,
    )
}

@Composable
fun SkeletonTheme(
    colorScheme: ColorScheme,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}
