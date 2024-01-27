package com.github.thailandandroiddeveloper.common.ui.screen.qualify2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme


@Composable
fun Qualify2Screen() {
    Scaffold(
        topBar = {
            TopContent(onSkipClicked = {
                // TODO: Need to implement
            })
        },
        bottomBar = {
            BottomContent(onNextClicked = {
                // TODO: Need to implement
            })
        },
        containerColor = MaterialTheme.colorScheme.onPrimary,
    ) { inner ->
        Qualify2Content(inner)

    }
}

@Composable
fun Qualify2Content(inner: PaddingValues) {
    Box(modifier = Modifier.padding(inner)) {
        TutorialContent()
    }
}

@Composable
fun TutorialContent() {
    Column(modifier = Modifier.padding(horizontal = 32.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Lorem ipsum dolor sit amet",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .fillMaxWidth()
                .padding()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec egestas dictum lacinia. Integer arcu  neque, porttitor ac metus quis, iaculis molestie magna. Vivamus molestie justo sed nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio  iaculis fringilla",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(35.dp))

        Image(
            painter = painterResource(id = R.drawable.img_qualify_2_onboard),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(348.dp)
                .height(446.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
        ) {
            Spacer(modifier = Modifier.height(34.dp))
            DotIndicator(totalPage = 5, currentPage = 3)
        }
    }
}

@Composable
private fun TopContent(onSkipClicked: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, end = 8.dp)
        ) {
            TextButton(
                onClick = onSkipClicked,
                modifier = Modifier
                    .width(59.dp)
                    .height(40.dp)
            ) {
                Text(
                    text = "Skip",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    letterSpacing = 0.1.sp
                )
            }
        }
    }
}

@Composable
private fun BottomContent(onNextClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .height(102.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier
                .width(251.dp)
                .height(40.dp),
            onClick = onNextClicked
        ) {
            Text(
                text = "Next",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                letterSpacing = 0.1.sp
            )
        }
    }
}

@Composable
private fun DotIndicator(totalPage: Int, currentPage: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        repeat(totalPage) { index ->
            val isSelected = index == currentPage
            Box(
                modifier = Modifier
                    .size(width = if (isSelected) 32.dp else 16.dp, height = 16.dp)
                    .background(
                        color = if (isSelected) {
                            MaterialTheme.colorScheme.primary
                        } else MaterialTheme.colorScheme.primaryContainer,
                        shape = if (!isSelected) CircleShape else RoundedCornerShape(16.dp)
                    )
            )
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify2Screen2() = AppTheme {
    Qualify2Screen()
}
// endregion