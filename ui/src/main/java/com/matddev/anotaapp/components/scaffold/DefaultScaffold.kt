package com.matddev.anotaapp.components.scaffold

import android.annotation.SuppressLint
import androidx.collection.emptyLongSet
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matddev.anotaapp.components.bottomBar.BottomBar
import com.matddev.anotaapp.theme.Theme
import com.matddev.anotaapp.ui.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DefaultScaffold(
    content: @Composable () -> Unit,
    totalAmount: String? = null,
    navigate: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                totalAmount = totalAmount
            )
        },
        bottomBar = {
            BottomBar(navigate = { route ->
                navigate.invoke(route)
            })
        }
    ) {
        content()
    }
}

@Composable
private fun TopBar(totalAmount: String?) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(160.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Theme.colors.backgroundComponent)
                .padding(horizontal = 16.dp)
                .align(Alignment.TopCenter)
                .height(128.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.keep_your_extracts_up_to_date),
                style = Theme.typography.subTitle.copy(
                    color = Color.Black
                )
            )
        }
        if (totalAmount?.isNotEmpty() == true) {
            Row(
                Modifier
                    .padding(horizontal = 32.dp)
                    .background(
                        color = Color(0XFF585666),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .align(Alignment.BottomCenter)
                    .height(64.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.ExitToApp,
                    contentDescription = "Ícone de exemplo",
                    tint = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Text(
                    text = "Olá",
                    style = Theme.typography.body.copy(
                        color = Color.White
                    ),
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun ScaffoldPreview() {

}