package com.buggily.skeleton.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.buggily.skeleton.R

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Text(
            text = stringResource(R.string.greeting),
            modifier = Modifier.align(Alignment.Center),
        )
    }
}
