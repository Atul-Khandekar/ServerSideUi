package com.example.serversideui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.model.CornerRadius
import com.example.model.DataSource
import com.example.model.UIModelItem
import com.example.serversideui.ui.theme.ServerSideUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ServerSideUITheme {
                DeriveUIFromServer(components = DataSource.getData())
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ServerSideUITheme {
        Greeting("Android")
    }
}

@Composable
fun DeriveUIFromServer(components: List<UIModelItem>) {
    components.forEach { item ->
        when (item.viewType) {
            "Image" -> DeriveImage(component = item)
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
            ).size(modifier?.size?.width.toDp(), modifier?.size?.height.toDp() ),
        contentScale = ContentScale.Crop
    )
}

//extensions
fun Color.Companion.fromHex(colorString: String) =
    Color(android.graphics.Color.parseColor(colorString))

fun Int?.toDp(): Dp {
    return this?.dp ?: 0.dp
}

fun String?.getShape(radius: CornerRadius?): Shape {

    radius?.let {
        return RoundedCornerShape(
            radius.topLeft ?: 0,
            radius.topRight ?: 0,
            radius.bottomLeft ?: 0,
            radius.bottomRight ?: 0
        )
    }
    
    return if (this == "Circle") {
        CircleShape
    } else {
        RectangleShape
    }

}