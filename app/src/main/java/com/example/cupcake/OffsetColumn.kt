package com.example.cupcake

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.constrainHeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OffsetColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val resolveConstraints = constraints.copy(minHeight = 0, minWidth = 0)
        val placeables = measurables.map { measurable ->
            measurable.measure(resolveConstraints)
        }
        layout (
            placeables.sumOf { it.width },
            constraints.constrainHeight(placeables.sumOf { it.height })
        ) {
            var y = 0
            var x = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(x = x, y = y)
                y += placeable.height
                x += placeable.width
            }
        }
    }
}

@Preview
@Composable
fun TestScreen() {
   OffsetColumn {
       Text("RED")
       Text("ORANGE")
       Text("YELLOW")
       Text("GREEN")
       Text("BLUE")
       Text("PURPLE")
   }
}