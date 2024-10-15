package com.example.cupcake.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cupcake.theme.AppTheme
import com.example.cupcake.PICKUP_SCREEN
import com.example.cupcake.R
import com.example.cupcake.model.OrderViewModel

@Composable
fun FlavorScreen(
    navHostController: NavHostController,
    viewModel: OrderViewModel
) {
    FlavorContent(navHostController, viewModel)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FlavorContent(
    navHostController: NavHostController,
    viewModel: OrderViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = AppTheme.colors.toolbar,
                title = {
                    Text(
                        text = stringResource(R.string.choose_flavor),
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
        Surface(modifier = Modifier.fillMaxSize(), color = AppTheme.colors.background) {
            val radioOptions = listOf(
                stringResource(R.string.vanilla),
                stringResource(R.string.chocolate),
                stringResource(R.string.red_velvet),
                stringResource(R.string.salted_caramel),
                stringResource(R.string.coffee)
            )
            var selectedOption by remember { mutableStateOf(radioOptions[0]) }
            val subtotal = viewModel.price.observeAsState()

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                radioOptions.forEach { option ->
                    Row(
                        Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (option == selectedOption),
                            onClick = {
                                viewModel.setFlavor(option)
                                selectedOption = option
                            }

                        )
                        Text(
                            text = option,
                            color = AppTheme.colors.text

                        )
                    }
                }
                Divider(modifier = Modifier.padding(top = 16.dp))
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .align(Alignment.End),
                    text = stringResource(R.string.subtotal_price, subtotal.value ?: ""),
                    color = AppTheme.colors.text,
                    style = AppTheme.typography.body1
                )
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 16.dp),
                        onClick = {
                            viewModel.resetOrder()
                            navHostController.navigateUp()
                        },
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = AppTheme.colors.background,
                            contentColor = AppTheme.colors.primary
                        )
                    ) {
                        Text(stringResource(R.string.cancel).uppercase())
                    }

                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            navHostController.navigate(PICKUP_SCREEN)
                        }) {
                        Text(
                            text = stringResource(R.string.next).uppercase(),
                            color = AppTheme.colors.onPrimary
                        )
                    }
                }
            }
        }
    }
}