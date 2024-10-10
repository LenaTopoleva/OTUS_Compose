package com.example.cupcake


import android.annotation.SuppressLint

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.widget.TextViewCompat.AutoSizeTextType
import androidx.navigation.NavHostController

import com.idapgroup.autosizetext.AutoSizeText


@Composable
fun StartScreen(
    navHostController: NavHostController
) {
    StartContent(navHostController)
}

@Composable
fun StartContent(navHostController: NavHostController) {
    val image: Painter = painterResource(id = R.drawable.cupcake)
    val scrollState = rememberScrollState()

    Scaffold (
        topBar = {
            TopAppBar(
                backgroundColor = AppTheme.colors.toolbar,
                title = {
                    Text(
                        text = "Cupcake",
                        style = AppTheme.typography.textMediumBold,
                        color = AppTheme.colors.toolbarText
                    )
                },
                elevation = 0.dp
            )
        }
        )
    {
        Surface(
            color = AppTheme.colors.background
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .scrollable(
                        state = scrollState,
                        orientation = Orientation.Vertical
                    )
                    .fillMaxSize()
                    .padding(16.dp)

            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .height(300.dp)
                        .width(300.dp)
                        .padding(top = 8.dp),
                    contentScale = ContentScale.Inside

                )
                AutoSizeText(
                    text = "Order Cupcakes",
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    maxLines = 1,
                    minFontSize = 2.sp, fontSize = 34.sp, color = AppTheme.colors.text
                )
                Button(
                    onClick = {
                        navHostController.navigate("flavor/1")
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .sizeIn(
                            minWidth = 250.dp
                        )
                ) {
                    Text(text = "ONE CUPCAKE", color = AppTheme.colors.onPrimary)

                }
                Button(
                    onClick = {
                        navHostController.navigate("flavor/6")
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .sizeIn(
                            minWidth = 250.dp
                        )
                ) {
                    Text(text = "SIX CUPCAKE", color = AppTheme.colors.onPrimary)
                }
                Button(
                    onClick = {
                        navHostController.navigate("flavor/12")
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .sizeIn(
                            minWidth = 250.dp
                        )
                ) {
                    Text(text = "TWELVE CUPCAKE", color = AppTheme.colors.onPrimary)
                }
            }
        }
    }
}