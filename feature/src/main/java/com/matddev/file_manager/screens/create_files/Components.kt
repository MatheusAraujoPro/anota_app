package com.matddev.file_manager.screens.create_files

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.matddev.anotaapp.feature.R
import com.matddev.anotaapp.theme.Theme
import com.matddev.anotaapp.theme.Theme.colors
import com.matddev.anotaapp.theme.ThemeColors
import com.matddev.model.Extract
import kotlin.reflect.KFunction1


@Composable
fun Footer(
    color: ThemeColors,
    action: KFunction1<CreateFileAction, Unit>,
    modifier: Modifier
) {
    HorizontalDivider(
        modifier = Modifier.padding(
            start = 24.dp,
            end = 24.dp,
            top = 8.dp
        ),
        thickness = 2.dp,
        color = color.text
    )
    Summary(
        descriptionText = stringResource(R.string.total_spent),
        valueText = "$25,00"
    )
    Spacer(modifier = modifier)
    FloatingActionButton(
        modifier = Modifier.padding(bottom = 16.dp),
        shape = RoundedCornerShape(50),
        onClick = {
            action(CreateFileAction.OpenHideBottomSheet)
        },
        containerColor = color.text
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = null,
            tint = color.background
        )
    }
}

@Composable
fun Header(
    colors: ThemeColors,
    modifier: Modifier
) {
    Icon(
        imageVector = Icons.Rounded.ArrowBack,
        contentDescription = null,
        tint = colors.text,
        modifier = modifier
    )
    HeaderTexts()
}


@Composable
fun Summary(
    descriptionText: String,
    valueText: String,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = descriptionText,
            style = Theme.typography.body,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = valueText,
            style = Theme.typography.body,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun HeaderTexts() {
    Text(
        text = stringResource(R.string.month_extract),
        style = Theme.typography.title,
        modifier = Modifier.padding(top = 16.dp)
    )
    Text(
        text = "Março",
        style = Theme.typography.subTitle,
        modifier = Modifier.padding(bottom = 24.dp)
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(
    itemsList: MutableList<Extract>
) {
    LazyColumn {
        items(itemsList) { item ->
            ContentItem(
                description = item.description,
                value = item.value
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentItem(
    description: String,
    value: String,
) {
    val dismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            when (it) {
                SwipeToDismissBoxValue.Settled -> return@rememberSwipeToDismissBoxState false
                SwipeToDismissBoxValue.StartToEnd -> {
                    Log.d("teste", "Swipou pra direita")
                    true
                }

                SwipeToDismissBoxValue.EndToStart -> {
                    Log.d("teste", "Swipou pra esquerda")
                    true
                }
            }
        },
        positionalThreshold = { it * .25f }
    )
    SwipeToDismissBox(
        state = dismissState,
        modifier = Modifier
            .background(color = colors.backgroundComponent)
            .fillMaxWidth(),
        backgroundContent = { DismissBackground(dismissState) },
        content = {
            Row(
                modifier = Modifier
                    .background(color = colors.background)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = description,
                    style = Theme.typography.body,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = value,
                    style = Theme.typography.body,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissBackground(dismissState: SwipeToDismissBoxState) {
    val color = when (dismissState.dismissDirection) {
        SwipeToDismissBoxValue.StartToEnd -> Color(0xFFFF1744)
        SwipeToDismissBoxValue.EndToStart -> Color(0xFF1DE9B6)
        SwipeToDismissBoxValue.Settled -> Color.Transparent
    }
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(12.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            Icons.Default.Delete,
            contentDescription = "delete"
        )
        Spacer(modifier = Modifier)
        Icon(
            // make sure add baseline_archive_24 resource to drawable folder
            imageVector = Icons.Outlined.Done,
            contentDescription = "Archive"
        )
    }
}