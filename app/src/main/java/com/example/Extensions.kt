package com.example

import android.util.Log
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CornerRadius

fun Color.Companion.fromHex(colorString: String?): Color {
    colorString?.let {
        return try {
            Color(android.graphics.Color.parseColor(colorString))
        } catch (e: Exception) {
            Log.d("exception", e.toString())
            return Color.Black
        }
    }
    return Color.Black
}


fun Int?.toDp(): Dp {
    return this?.dp ?: 0.dp
}

fun Int?.toSp(): TextUnit {
    return this?.sp ?: 0.sp
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

fun String?.getFontStyle(): FontWeight {
    return when (this) {
        "Bold" -> Bold
        else -> {
            Normal
        }
    }
}

fun String?.getTextAlignment(): TextAlign {
    return when (this) {
        "Center" -> TextAlign.Center
        "Left" -> TextAlign.Left
        "Right" -> TextAlign.Right
        "Justify" -> TextAlign.Justify
        "Start" -> TextAlign.Start
        "End" -> TextAlign.End
        else -> {
            TextAlign.Left
        }
    }
}

fun String?.getHorizontalAlignment(): Alignment.Horizontal {
    return when (this) {
        "CenterHorizontal" -> Alignment.CenterHorizontally
        "Start" -> Alignment.Start
        "End" -> Alignment.End
        else -> {
            Alignment.Start
        }
    }
}

fun String?.getVerticalAlignment(): Alignment.Vertical {
    return when (this) {
        "CenterVertical" -> Alignment.CenterVertically
        "Top" -> Alignment.Top
        "Bottom" -> Alignment.Bottom
        else -> {
            Alignment.CenterVertically
        }
    }
}