@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalLayoutApi::class
)

package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Text(
                text = "John Doe",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBackPressed,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_back),
                    contentDescription = "back_button",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            }
        },
        actions = {
            IconButton(
                onClick = onCopyPressed,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_copy),
                    contentDescription = "back_button",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            }
            IconButton(
                onClick = onCalendarPressed,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_calendar),
                    contentDescription = "back_button",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            }
            IconButton(
                onClick = onMenuPressed,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_menu),
                    contentDescription = "back_button",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
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
            .background(MaterialTheme.colorScheme.onPrimary)
            .fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(scrollState)
            .padding(vertical = 16.dp)
    ) {
        val tagList = listOf("Tag 1", "Tag 2", "Tag 3", "Tag 4")

        val isFilterSelected = rememberSavableSnapshotStateMap {
            List(tagList.size) { index: Int -> index to (index == 0) }.toMutableStateMap()
        }

        val contentList = listOf(
            "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.",
            "Morbi sed sagittis justo, at pulvinar ipsum. Praesent massa metus, interdum at suscipit a, interdum vel orci. Pellentesque in sapien. Integer faucibus mauris ac luctus aliquam accumsan.",
            "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo.",
            "Ut hendrerit neque nec accumsan hendrerit. Fusce lobortis rhoncus erat, a blandit nibh molestie vel. Cras commodo ligula ex, vitae venenatis lacus facilisis eget."
        )

        ProfileCarousel()
        FilterChips(tagList, isFilterSelected)
        ListContent(contentList)
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
        ProfileItem(drawableRes = profileList[page], isSelected = page == 0)
    }
}

@Composable
private fun ProfileItem(@DrawableRes drawableRes: Int, isSelected: Boolean = false) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        border = if (isSelected) {
            BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
        } else {
            BorderStroke(2.dp, MaterialTheme.colorScheme.primaryContainer)
        },
    ) {
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
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(32.dp)

    ) {
        repeat(list.size) {
            FilterChip(
                onClick = { isFilterSelected[it] = isFilterSelected[it]?.not() ?: true },
                label = {
                    Text(list[it], style = MaterialTheme.typography.labelLarge)
                },
                selected = isFilterSelected[it] ?: false,
                border = FilterChipDefaults.filterChipBorder(
                    borderWidth = 1.dp,
                    selectedBorderWidth = 1.dp,
                    borderColor = MaterialTheme.colorScheme.outline,
                    selectedBorderColor = MaterialTheme.colorScheme.primary,
                ),
                colors = FilterChipDefaults.filterChipColors(
                    labelColor = MaterialTheme.colorScheme.outline,
                    selectedContainerColor = Color.Transparent,
                    selectedLabelColor = MaterialTheme.colorScheme.primary,
                ),
                modifier = Modifier
                    .width(68.dp)
                    .height(32.dp)
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
            ListItem(list[it])
        }
    }
}

@Composable
private fun ListItem(value: String) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant),
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.surface)
            .width(380.dp)
            .height(96.dp)
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
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
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