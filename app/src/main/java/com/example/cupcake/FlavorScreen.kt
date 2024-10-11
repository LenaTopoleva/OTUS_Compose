package com.example.cupcake

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun FlavorScreen(
    navHostController: NavHostController,
    quantity: Int
) {
    FlavorContent(navHostController, quantity)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FlavorContent(
    navHostController: NavHostController,
    quantity: Int
) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = AppTheme.colors.toolbar,
                title = {
                    Text(
                        text = "Choose Flavor",
                        style = AppTheme.typography.textMediumBold,
                        color = AppTheme.colors.toolbarText
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            tint = AppTheme.colors.toolbarText,
                            contentDescription = null
                        )
                    }
                },
                elevation = 0.dp
            )
        }
    ) {
        Surface(color = AppTheme.colors.background) {
            val radioOptions = listOf("Vanilla", "Chocolate", "Red Velvet", "Salted Caramel", "Coffee")
            var selectedOption by remember { mutableStateOf(radioOptions[0]) }

            Column(
                modifier = Modifier
                    .scrollable(
                        state = scrollState,
                        orientation = Orientation.Vertical
                    )
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                radioOptions.forEach { option ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            ,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (option == selectedOption),
                            onClick = { selectedOption = option }
                        )
                        Text(
                            text = option,
                            color = AppTheme.colors.text

                        )
                    }
                }
                Divider(modifier = Modifier.padding(top = 16.dp))
                Text(modifier = Modifier.padding(top = 16.dp).align(Alignment.End),
                    text = "Subtotal $${calculatePrice(quantity)}",
                    color = AppTheme.colors.text,
                    style = AppTheme.typography.body1
                )
                Row (modifier = Modifier.padding(top = 16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    OutlinedButton(
                        modifier =  Modifier.weight(1f)
                            .padding(end = 16.dp),
                        onClick = {
                            navHostController.navigateUp()
                        },
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = AppTheme.colors.background,
                            contentColor = AppTheme.colors.primary
                        )
                    ) {
                        Text("CANCEL")
                    }

                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                        navHostController.navigate("pickup/$quantity")
                    }) { Text(text = "NEXT", color = AppTheme.colors.onPrimary) }
                }

            }
        }
    }
}

fun calculatePrice(quantity: Int) =
    (quantity ?: 0) * PRICE_PER_CUPCAKE

/** Price for a single cupcake */
private const val PRICE_PER_CUPCAKE = 2.00