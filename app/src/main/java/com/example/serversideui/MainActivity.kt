package com.example.serversideui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.composables.DeriveUIFromServer
import com.example.model.DataSource
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


