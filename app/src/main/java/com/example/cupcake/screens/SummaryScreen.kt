package com.example.cupcake.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cupcake.theme.AppTheme
import com.example.cupcake.R
import com.example.cupcake.START_SCREEN
import com.example.cupcake.model.OrderViewModel

@Composable
fun SummaryScreen(
    navHostController: NavHostController,
    viewModel: OrderViewModel,
    sendOrderCallback: () -> Unit
) {
    SummaryContent(navHostController, viewModel, sendOrderCallback)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SummaryContent(
    navHostController: NavHostController,
    viewModel: OrderViewModel,
    sendOrderCallback: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = AppTheme.colors.toolbar,
                title = {
                    Text(
                        text = stringResource(R.string.order_summary),
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
            val subtotal = viewModel.price.observeAsState()
            val quantity = viewModel.quantity.observeAsState()
            val flavor = viewModel.flavor.observeAsState()
            val pickupDate = viewModel.date.observeAsState()

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.quantity).uppercase(),
                    color = AppTheme.colors.text
                )
                Text(
                    text = quantity.value.toString(),
                    modifier = Modifier.padding(top = 4.dp),
                    color = AppTheme.colors.text,
                    style = AppTheme.typography.body2
                )
                Divider(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))

                Text(
                    text = stringResource(R.string.flavor).uppercase(),
                    color = AppTheme.colors.text
                )
                Text(
                    text = flavor.value.toString(),
                    modifier = Modifier.padding(top = 4.dp),
                    color = AppTheme.colors.text,
                    style = AppTheme.typography.body2
                )
                Divider(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))

                Text(
                    text = stringResource(R.string.pickup_date).uppercase(),
                    color = AppTheme.colors.text
                )
                Text(
                    text = pickupDate.value.toString(),
                    modifier = Modifier.padding(top = 4.dp),
                    color = AppTheme.colors.text,
                    style = AppTheme.typography.body2
                )
                Divider(modifier = Modifier.padding(top = 16.dp, bottom = 8.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .align(Alignment.End),
                    text = stringResource(R.string.total_price, subtotal.value ?: "").uppercase(),
                    color = AppTheme.colors.text,
                    style = AppTheme.typography.body1
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    onClick = sendOrderCallback
                ) {
                    Text(
                        text = stringResource(R.string.send).uppercase(),
                        color = AppTheme.colors.onPrimary
                    )
                }

                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    onClick = {
                        viewModel.resetOrder()
                        navHostController.navigate(START_SCREEN)
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = AppTheme.colors.background,
                        contentColor = AppTheme.colors.primary
                    )
                ) {
                    Text(stringResource(R.string.cancel).uppercase())
                }
            }
        }
    }
}
