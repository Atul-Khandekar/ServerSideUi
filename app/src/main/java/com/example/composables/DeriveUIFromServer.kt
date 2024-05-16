package com.example.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.fromHex
import com.example.getFontStyle
import com.example.getHorizontalAlignment
import com.example.getShape
import com.example.getTextAlignment
import com.example.model.UIModelItem
import com.example.toDp
import com.example.toSp

@Composable
fun DeriveUIFromServer(components: List<UIModelItem>) {
    components.forEach { item ->
        when (item.viewType) {
            "Image" -> DeriveImage(component = item)
            "Column" -> DeriveColumn(component = item)
            "Row" -> DeriveRow(component = item)
            "Text" -> DeriveText(component = item)
            "Box" -> DeriveBox(component = item)
            else -> {
                Text("Invalid input")
            }
        }
    }
}

@Composable
fun DeriveBox(component: UIModelItem) {

    val size = component.modifier?.size
    Box(
        modifier = Modifier
            .padding(
                component.modifier?.layoutParams?.padding?.left?.dp ?: 0.dp,
                component.modifier?.layoutParams?.padding?.top?.dp ?: 0.dp,
                component.modifier?.layoutParams?.padding?.right?.dp ?: 0.dp,
                component.modifier?.layoutParams?.padding?.bottom?.dp ?: 0.dp,
            )
            .background(
                color = Color.fromHex(component.modifier?.backgroundColor),
            )
            .border(
                border = BorderStroke(
                    component.modifier?.borderWidth.toDp(),
                    Color.fromHex(component.modifier?.borderColor.toString())
                )
            )
            .clip(
                component.modifier?.clipShape.getShape(component.modifier?.cornerRadius)
            )

    ) {
        component.children?.let { DeriveUIFromServer(components = it) }
    }
}

@Composable
fun DeriveText(component: UIModelItem) {

    val textStyle = component.modifier?.textStyle
    Text(
        text = component.value ?: "Empty String",
        color = Color.fromHex(textStyle?.textColor.toString()),
        fontSize = textStyle?.textSize.toSp(),
        fontWeight = textStyle?.textStyle.getFontStyle(),
        textAlign = textStyle?.alignment.getTextAlignment(),
        maxLines = textStyle?.maxLines ?: 0,
        modifier = Modifier.padding(
            component.modifier?.layoutParams?.padding?.left?.dp ?: 0.dp,
            component.modifier?.layoutParams?.padding?.top?.dp ?: 0.dp,
            component.modifier?.layoutParams?.padding?.right?.dp ?: 0.dp,
            component.modifier?.layoutParams?.padding?.bottom?.dp ?: 0.dp,
        )
    )
}

@Composable
fun DeriveColumn(component: UIModelItem) {

    Column(
        modifier = Modifier.padding(
            component.modifier?.layoutParams?.padding?.left?.dp ?: 0.dp,
            component.modifier?.layoutParams?.padding?.top?.dp ?: 0.dp,
            component.modifier?.layoutParams?.padding?.right?.dp ?: 0.dp,
            component.modifier?.layoutParams?.padding?.bottom?.dp ?: 0.dp,
        ),
        horizontalAlignment = component.modifier?.horizontalAlignment.getHorizontalAlignment()

    ) {
        component.children?.let {
            DeriveUIFromServer(components = it)
        }
    }
}

@Composable
fun DeriveRow(component: UIModelItem) {

    Row(
        modifier = Modifier.padding(
            component.modifier?.layoutParams?.padding?.left?.dp ?: 0.dp,
            component.modifier?.layoutParams?.padding?.top?.dp ?: 0.dp,
            component.modifier?.layoutParams?.padding?.right?.dp ?: 0.dp,
            component.modifier?.layoutParams?.padding?.bottom?.dp ?: 0.dp,
        )

    ) {
        component.children?.let {
            DeriveUIFromServer(components = it)
        }
    }
}

@Composable
fun DeriveImage(component: UIModelItem) {
    val modifier = component.modifier
    Image(
        painter = rememberAsyncImagePainter(model = component.value),
        contentDescription = null,
        modifier = Modifier
            .padding(
                component.modifier?.layoutParams?.padding?.left?.dp ?: 0.dp,
                component.modifier?.layoutParams?.padding?.top?.dp ?: 0.dp,
                component.modifier?.layoutParams?.padding?.right?.dp ?: 0.dp,
                component.modifier?.layoutParams?.padding?.bottom?.dp ?: 0.dp,
            )
            .border(
                border = BorderStroke(
                    modifier?.borderWidth.toDp(), Color.fromHex(modifier?.borderColor.toString())
                )
            )
            .clip(
                modifier?.clipShape.getShape(modifier?.cornerRadius)
            )
            .size(modifier?.size?.width.toDp(), modifier?.size?.height.toDp()),
        contentScale = ContentScale.Crop
    )
}