package com.example.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.fromHex
import com.example.model.UIModelItem
import com.example.toDp
import androidx.compose.ui.draw.clip
import com.example.getShape
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import com.example.getFontStyle
import com.example.toSp

@Composable
fun DeriveUIFromServer(components: List<UIModelItem>) {
    components.forEach { item ->
        when (item.viewType) {
            "Image" -> DeriveImage(component = item)
            "Column" -> DeriveColumn(component = item)
            "Row" -> DeriveRow(component = item)
            "Text" -> DeriveText(component = item)
            else -> {
                Text("Invalid input")
            }
        }
    }
}

@Composable
fun DeriveText(component: UIModelItem) {

    val textStyle = component.modifier?.textStyle
    Text(
        text = component.value ?: "Empty String",
        color = Color.fromHex(textStyle?.textColor.toString()),
        fontSize = textStyle?.textSize.toSp(),
        fontWeight = textStyle?.textStyle.getFontStyle()
    )
}

@Composable
fun DeriveColumn(component: UIModelItem) {

    Column(
        modifier = Modifier
            .padding(
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
fun DeriveRow(component: UIModelItem) {

    Row(
        modifier = Modifier
            .padding(
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
                    modifier?.borderWidth.toDp(),
                    Color.fromHex(modifier?.borderColor.toString())
                )
            )
            .clip(
                modifier?.clipShape.getShape(modifier?.cornerRadius)
            )
            .size(modifier?.size?.width.toDp(), modifier?.size?.height.toDp()),
        contentScale = ContentScale.Crop
    )
}