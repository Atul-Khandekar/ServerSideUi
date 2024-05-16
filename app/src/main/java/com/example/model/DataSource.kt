package com.example.model

object DataSource {

    fun getData(): List<UIModelItem> {

        val list = mutableListOf(
            UIModelItem(
                viewType = "Column", value = null, modifier = ModifierX(
                    textAlignment = "Center",
                    backgroundColor = "#123452",
                    borderColor = "#000000",
                    borderWidth = 1,
                    clipShape = "Rectangle",
                    cornerRadius = CornerRadius(4, 4, 4, 4),
                    size = null,
                    textStyle = null,
                    layoutParams = LayoutParams(
                        margin = Margin(0, 0, 0, 0), padding = Padding(0, 0, 0, 0)
                    ),
                    horizontalAlignment = "CenterHorizontal"
                ), children = mutableListOf(
                    UIModelItem(
                        viewType = "Image",
                        value = "https://images.unsplash.com/photo-1714572877812-7b416fbd4314?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                        modifier = ModifierX(
                            textAlignment = "Center",
                            backgroundColor = null,
                            borderColor = "#FFFFFF",
                            borderWidth = 1,
                            clipShape = "Rectangle",
                            cornerRadius = CornerRadius(24, 24, 24, 24),
                            size = Size(400, 400),
                            textStyle = null,
                            layoutParams = LayoutParams(
                                margin = Margin(0, 0, 0, 0), padding = Padding(0, 0, 0, 0)
                            )
                        ),
                        children = null

                    ), UIModelItem(
                        viewType = "Box", value = null, modifier = ModifierX(
                            textAlignment = "Center",
                            backgroundColor = "#F0FFFF",
                            borderColor = "#000000",
                            borderWidth = 1,
                            clipShape = null,
                            cornerRadius = CornerRadius(8, 8, 8, 8),
                            size = null,
                            textStyle = null,
                            layoutParams = LayoutParams(
                                margin = Margin(0, 0, 0, 0), padding = Padding(6, 6, 6, 6)
                            )
                        ), children = mutableListOf(
                            UIModelItem(
                                viewType = "Text",
                                value = "This is image from unsplash",
                                modifier = ModifierX(
                                    textAlignment = "Center",
                                    backgroundColor = null,
                                    borderColor = null,
                                    borderWidth = null,
                                    clipShape = null,
                                    cornerRadius = null,
                                    size = null,
                                    textStyle = TextStyle(
                                        textSize = 18,
                                        textColor = "#FF0000",
                                        textStyle = "Bold",
                                        lineHeight = null,
                                        maxLines = 1,
                                        alignment = "Center"
                                    ),
                                    layoutParams = LayoutParams(
                                        margin = Margin(0, 0, 0, 0), padding = Padding(6, 6, 6, 6)
                                    )
                                ),
                                children = null

                            )
                        )

                    )
                )
            )

        )
        return list
    }
}
