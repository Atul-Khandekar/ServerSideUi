package com.example.serversideui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.*
import com.example.composables.DeriveUIFromServer
import com.example.model.AppConstants
import com.example.serversideui.ui.theme.ServerSideUITheme
import com.example.viewmodel.ServerSideUIViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.ably.lib.realtime.AblyRealtime
import io.ably.lib.realtime.Channel
import io.ably.lib.realtime.ConnectionEvent
import io.ably.lib.realtime.ConnectionStateListener
import io.ably.lib.types.Message


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ServerSideUIViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            ServerSideUITheme {

                val state by viewModel.uiList.collectAsState()
                LaunchedEffect(key1 = Unit) {
                    viewModel.getUIFromServer()
                }
                DeriveUIFromServer(components = state?.json?.json)
            }
        }
    }

    private fun subscribeToChannel(ablyRealtime: AblyRealtime) {


    }
}



