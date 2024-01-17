@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalLayoutApi::class
)

package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.runtime.toMutableStateMap
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify3Screen() {
    Scaffold(topBar = {
        TopBarQualify3(
            onBackPressed = {},
            onCopyPressed = {},
            onCalendarPressed = {},
            onMenuPressed = {}
        )
    }) { innerPadding ->
        Qualify3Content(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBarQualify3(
    onBackPressed: () -> Unit = {},
    onCopyPressed: () -> Unit = {},
    onCalendarPressed: () -> Unit = {},
    onMenuPressed: () -> Unit = {},
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        title = {
            Text(text = "John Doe")
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_back),
                    contentDescription = "back_button",
                    tint = Color.Unspecified
                )
            }
        },
        actions = {
            IconButton(onClick = onCopyPressed) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_copy),
                    contentDescription = "back_button",
                    tint = Color.Unspecified
                )
            }
            IconButton(onClick = onCalendarPressed) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_calendar),
                    contentDescription = "back_button",
                    tint = Color.Unspecified
                )
            }
            IconButton(onClick = onMenuPressed) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_menu),
                    contentDescription = "back_button",
                    tint = Color.Unspecified
                )
            }
        }
    )
}

@Composable
private fun Qualify3Content(innerPadding: PaddingValues) {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(scrollState)
            .padding(vertical = 16.dp)
    ) {
        val tagList = listOf("Tag 1", "Tag 2", "Tag 3", "Tag 4")

        val isFilterSelected = rememberSavableSnapshotStateMap {
            List(tagList.size) { index: Int -> index to false }.toMutableStateMap()
        }


        ProfileCarousel()
        FilterChips(tagList, isFilterSelected)
        ListContent(tagList)
    }
}

@Composable
private fun ProfileCarousel() {
    val profileList = listOf(
        R.drawable.img_qualify_3_photo_1,
        R.drawable.img_qualify_3_photo_2,
        R.drawable.img_qualify_3_photo_3
    )
    val pageState = rememberPagerState(
        pageCount = { profileList.size }
    )
    HorizontalPager(
        pageSize = PageSize.Fixed(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        pageSpacing = 16.dp,
        state = pageState
    ) { page ->
        ProfileItem(profileList[page])
    }
}

@Composable
private fun ProfileItem(@DrawableRes drawableRes: Int) {
    Surface(shape = RoundedCornerShape(16.dp)) {
        Image(
            painter = painterResource(id = drawableRes),
            contentDescription = null
        )
    }
}

@Composable
private fun FilterChips(list: List<String>, isFilterSelected: SnapshotStateMap<Int, Boolean>) {

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        repeat(list.size) {
            FilterChip(
                onClick = { isFilterSelected[it] = isFilterSelected[it]?.not() ?: true },
                label = {
                    Text(list[it], style = MaterialTheme.typography.labelLarge)
                },
                selected = isFilterSelected[it] ?: false,
                border = FilterChipDefaults.filterChipBorder(
                    borderColor = MaterialTheme.colorScheme.outline,
                    selectedBorderColor = MaterialTheme.colorScheme.primary,
                ),
                colors = FilterChipDefaults.filterChipColors(
                    labelColor = MaterialTheme.colorScheme.outline,
                    selectedContainerColor = Color.Transparent,
                    selectedLabelColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    }
}

@Composable
private fun ListContent(
    list: List<String>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        repeat(list.size) {
            ListItem()
        }
    }
}

@Composable
private fun ListItem() {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.img_qualify_3_sender),
                contentDescription = "sender_image",
                tint = Color.Unspecified,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(48.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Lorem Ipsum",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

            }
        }
    }
}

fun <K, V> snapshotStateMapSaver() = Saver<SnapshotStateMap<K, V>, Any>(
    save = { state -> state.toList() },
    restore = { value ->
        @Suppress("UNCHECKED_CAST")
        (value as? List<Pair<K, V>>)?.toMutableStateMap() ?: mutableStateMapOf<K, V>()
    }
)

@Composable
fun <K, V> rememberSavableSnapshotStateMap(init: () -> SnapshotStateMap<K, V>): SnapshotStateMap<K, V> =
    rememberSaveable(saver = snapshotStateMapSaver(), init = init)


// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion