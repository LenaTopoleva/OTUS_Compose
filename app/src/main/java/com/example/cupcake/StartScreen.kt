package com.example.cupcake

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.ui.tooling.preview.Preview

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
    Column(
        modifier = Modifier.scrollable(
            state = scrollState,
            orientation = Orientation.Vertical
        )
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = "Order Cupcakes"
        )
        Button(
            onClick = {
                navHostController.navigate("flavor")
            }
        ){
            Text("ONE CUPCAKE")
        }
        Button(
            onClick = {
                navHostController.navigate("flavor")
            }
        ){
            Text("SIX CUPCAKE")
        }
        Button(
                onClick = {
                    navHostController.navigate("flavor")
                }
                ){
            Text("TWELVE CUPCAKE")
        }
    }
}