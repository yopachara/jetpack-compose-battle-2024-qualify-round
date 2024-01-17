package com.github.thailandandroiddeveloper.common.ui.screen.qualify1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.screen.component.OverlappingBoxes
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify1Screen() {
    Qualify1ScreenContent(onThumbUpClicked = {}, onThumbDownClicked = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Qualify1ScreenContent(
    onThumbUpClicked: () -> Unit = {},
    onThumbDownClicked: () -> Unit = {},
) {
    Column {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            title = { },
            navigationIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_qualify_1_menu),
                    contentDescription = null
                )
            },
            actions = {
                Image(
                    painter = painterResource(id = R.drawable.ic_qualify_1_profile),
                    contentDescription = null
                )
            }
        )
        ProfileComponent(
            onThumbUpClicked = onThumbUpClicked,
            onThumbDownClicked = onThumbDownClicked
        )
    }
}

@Composable
private fun ProfileComponent(
    onThumbUpClicked: () -> Unit = {},
    onThumbDownClicked: () -> Unit = {},
) {
    Surface(Modifier.padding()) {
        OverlappingBoxes(
            modifier = Modifier
                .padding(top = 32.dp, bottom = 48.dp)
                .padding(horizontal = 16.dp)

        ) {
            ProfileContainer()
            ThumbButtonContainer(
                onThumbUpClicked = onThumbUpClicked,
                onThumbDownClicked = onThumbDownClicked
            )
        }
    }
}

@Composable
private fun ProfileContainer() {
    Surface(
        shape = RoundedCornerShape(16.dp),
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.img_qualify_1_profile),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.75f))
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp, bottom = 40.dp)

            ) {
                Text(
                    text = "John Doe",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.fillMaxWidth()
                )
                SexContent(Sex.Male)
                Text(
                    text = LoremIpsum(16).values.first(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Composable
private fun ThumbButtonContainer(
    onThumbUpClicked: () -> Unit = {},
    onThumbDownClicked: () -> Unit = {},
) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.errorContainer
            ),
            modifier = Modifier
                .width(120.dp)
                .height(48.dp),
            onClick = onThumbDownClicked
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_qualify_1_thumb_down),
                contentDescription = "thumb_down_button",
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.width(43.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            modifier = Modifier
                .width(120.dp)
                .height(48.dp),
            onClick = onThumbUpClicked
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_qualify_1_thumb_up),
                contentDescription = "thumb_up_button",
                tint = Color.Unspecified
            )
        }
    }
}


enum class Sex {
    Male, Female
}

@Composable
private fun SexContent(sex: Sex) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(
                id = if (sex == Sex.Male) {
                    R.drawable.ic_qualify_1_gender_male
                } else {
                    //TODO: need update female icon
                    R.drawable.ic_qualify_1_gender_male
                }
            ),
            contentDescription = "sex_icon",
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = if (sex == Sex.Male) "Male" else "Female",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify1ScreenPreview() = AppTheme {
    Qualify1Screen()
}
// endregion