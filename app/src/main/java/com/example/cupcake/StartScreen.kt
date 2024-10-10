package com.example.cupcake

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.ui.tooling.preview.Preview

@Composable
fun StartScreen(
    navHostController: NavHostController
) {
    StartContent(navHostController)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartContent(navHostController: NavHostController) {
    val image: Painter = painterResource(id = R.drawable.cupcake)
    val scrollState = rememberScrollState()
    Scaffold {
        Surface(color = AppTheme.colors.background)  {
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
                Text(
                    text = "Order Cupcakes",
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        ,
                    style = AppTheme.typography.textMediumBold
                )
                Button(
                    onClick = {
                        navHostController.navigate("flavor")
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .sizeIn(
                            minWidth = 250.dp
                        )
                ) {
                    Text(text = "ONE CUPCAKE")

                }
                Button(
                    onClick = {
                        navHostController.navigate("flavor")
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .sizeIn(
                            minWidth = 250.dp
                        )
                ) {
                    Text("SIX CUPCAKE")
                }
                Button(
                    onClick = {
                        navHostController.navigate("flavor")
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .sizeIn(
                            minWidth = 250.dp
                        )
                ) {
                    Text("TWELVE CUPCAKE")
                }
            }
        }
    }
}