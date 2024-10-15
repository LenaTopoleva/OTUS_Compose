package com.example.cupcake.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cupcake.theme.AppTheme
import com.example.cupcake.FLAVOR_SCREEN
import com.example.cupcake.R
import com.example.cupcake.model.OrderViewModel
import com.idapgroup.autosizetext.AutoSizeText


@Composable
fun StartScreen(
    navHostController: NavHostController,
    viewModel: OrderViewModel
) {
    StartContent(navHostController, viewModel)
}

@Composable
fun StartContent(navHostController: NavHostController, viewModel: OrderViewModel) {
    val image: Painter = painterResource(id = R.drawable.cupcake)
    val defaultFlavor = stringResource(R.string.vanilla)

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = AppTheme.colors.toolbar,
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
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
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colors.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

                modifier = Modifier
                    .verticalScroll(rememberScrollState())
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
                    text = stringResource(R.string.order_cupcakes),
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    maxLines = 1,
                    minFontSize = 2.sp,
                    fontSize = 34.sp,
                    color = AppTheme.colors.text,
                    lineHeight = 16.sp
                )
                Button(
                    onClick = {
                        orderCupcake(viewModel, 1, navHostController, defaultFlavor)
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .sizeIn(
                            minWidth = 250.dp
                        )
                ) {
                    Text(
                        text = stringResource(R.string.one_cupcake).uppercase(),
                        color = AppTheme.colors.onPrimary
                    )
                }
                Button(
                    onClick = {
                        orderCupcake(viewModel, 6, navHostController, defaultFlavor)

                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .sizeIn(
                            minWidth = 250.dp
                        )
                ) {
                    Text(
                        text = stringResource(R.string.six_cupcakes).uppercase(),
                        color = AppTheme.colors.onPrimary
                    )
                }
                Button(
                    onClick = {
                        orderCupcake(viewModel, 12, navHostController, defaultFlavor)

                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .sizeIn(
                            minWidth = 250.dp
                        )
                ) {
                    Text(
                        text = stringResource(R.string.twelve_cupcakes).uppercase(),
                        color = AppTheme.colors.onPrimary
                    )
                }
            }
        }
    }
}

fun orderCupcake(
    viewModel: OrderViewModel,
    quantity: Int,
    navHostController: NavHostController,
    defaultFlavor: String
) {
    // Update the view model with the quantity
    viewModel.setQuantity(quantity)

    // If no flavor is set in the view model yet, select vanilla as default flavor
    if (viewModel.hasNoFlavorSet()) {
        viewModel.setFlavor(defaultFlavor)
    }

    navHostController.navigate(FLAVOR_SCREEN)
}