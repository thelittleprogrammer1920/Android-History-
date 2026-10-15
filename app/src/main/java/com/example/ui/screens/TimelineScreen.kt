package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.AndroidEra
import com.example.data.model.AndroidRelease
import com.example.data.model.EasterEggType
import com.example.ui.components.ReleaseCard
import com.example.ui.components.TimelineHeroBanner

@Composable
fun TimelineScreen(
    releases: List<AndroidRelease>,
    totalHardwareCount: Int,
    totalArchitectureCount: Int,
    searchQuery: String,
    selectedEra: AndroidEra?,
    bookmarkedIds: Set<String>,
    showOnlyBookmarked: Boolean,
    onSearchQueryChange: (String) -> Unit,
    onSelectEra: (AndroidEra?) -> Unit,
    onToggleBookmark: (String) -> Unit,
    onToggleShowOnlyBookmarked: () -> Unit,
    onSelectRelease: (AndroidRelease) -> Unit,
    onLaunchEasterEgg: (EasterEggType) -> Unit,
    modifier: Modifier = Modifier
) {
    var isNewestFirst by remember { mutableStateOf(false) }

    // Filter releases
    val filteredReleases = remember(releases, searchQuery, selectedEra, bookmarkedIds, showOnlyBookmarked, isNewestFirst) {
        val list = releases.filter { release ->
            val matchesQuery = searchQuery.isBlank() ||
                release.versionName.contains(searchQuery, ignoreCase = true) ||
                release.dessertName.contains(searchQuery, ignoreCase = true) ||
                release.internalCodename.contains(searchQuery, ignoreCase = true) ||
                release.tagline.contains(searchQuery, ignoreCase = true) ||
                release.whatGoogleDid.contains(searchQuery, ignoreCase = true) ||
                release.keyFeatures.any { it.title.contains(searchQuery, ignoreCase = true) || it.description.contains(searchQuery, ignoreCase = true) } ||
                release.majorHardware.any { it.name.contains(searchQuery, ignoreCase = true) || it.manufacturer.contains(searchQuery, ignoreCase = true) }

            val matchesEra = selectedEra == null || release.era == selectedEra
            val matchesBookmark = !showOnlyBookmarked || bookmarkedIds.contains(release.id)

            matchesQuery && matchesEra && matchesBookmark
        }
        if (isNewestFirst) list.reversed() else list
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("timeline_list")
    ) {
        // Hero Header
        item {
            TimelineHeroBanner(
                totalReleases = releases.size,
                totalHardware = totalHardwareCount,
                totalArchitectures = totalArchitectureCount,
                modifier = Modifier.padding(16.dp)
            )
        }

        // Search & Controls bar
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    placeholder = { Text("Search version, dessert, feature, device...", fontSize = 13.sp) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { onSearchQueryChange("") }) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                            }
                        }
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("search_field"),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Era Filter Chips
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilterChip(
                        selected = selectedEra == null,
                        onClick = { onSelectEra(null) },
                        label = { Text("All Eras") },
                        colors = FilterChipDefaults.filterChipColors()
                    )

                    AndroidEra.values().forEach { era ->
                        FilterChip(
                            selected = selectedEra == era,
                            onClick = { onSelectEra(era) },
                            label = { Text(era.displayName) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Secondary toggle row: Bookmarks & Sort
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Bookmark toggle chip
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = if (showOnlyBookmarked) MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                                else MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier
                            .clickable { onToggleShowOnlyBookmarked() }
                            .padding(vertical = 4.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Bookmark,
                                contentDescription = null,
                                tint = if (showOnlyBookmarked) MaterialTheme.colorScheme.primary
                                       else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Saved (${bookmarkedIds.size})",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = if (showOnlyBookmarked) MaterialTheme.colorScheme.primary
                                       else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    // Sort order toggle
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable { isNewestFirst = !isNewestFirst }
                            .padding(vertical = 4.dp, horizontal = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.SwapVert,
                            contentDescription = "Sort order",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (isNewestFirst) "Newest First" else "Oldest First",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        // Empty state when filters return no results
        if (filteredReleases.isEmpty()) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "No Android releases match your search.",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Try clearing your search query or switching era filters.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // Release items
        itemsIndexed(
            items = filteredReleases,
            key = { _, item -> item.id }
        ) { index, release ->
            ReleaseCard(
                release = release,
                isBookmarked = bookmarkedIds.contains(release.id),
                onToggleBookmark = { onToggleBookmark(release.id) },
                onClick = { onSelectRelease(release) },
                onLaunchEasterEgg = { onLaunchEasterEgg(release.easterEgg.type) },
                isFirst = index == 0,
                isLast = index == filteredReleases.lastIndex
            )
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}
