package com.example.model

object  DataSource {

    fun getData(): List<UIModelItem> {

        val list = mutableListOf(
            UIModelItem(
                viewType = "Image",
                value = "https://images.unsplash.com/photo-1714572877812-7b416fbd4314?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                modifier = ModifierX(
                    alignment = "Center",
                    backgroundColor = null,
                    borderColor = "#FFFFFF",
                    borderWidth = 1,
                    clipShape = "Rectangle",
                    cornerRadius =  CornerRadius(24,24,24,24),
                    size = Size(400,400),
                    textStyle = null,
                    layoutParams = LayoutParams(
                        margin = Margin(0,0,0,0),
                        padding = Padding(0,0,0,0,)
                    )
                ),
                children = null

            )
        )
        return list
    }
}
