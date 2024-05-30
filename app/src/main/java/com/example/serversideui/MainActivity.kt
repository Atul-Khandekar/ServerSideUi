package com.example.serversideui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.composables.DeriveUIFromServer
import com.example.serversideui.ui.theme.ServerSideUITheme
import com.example.viewmodel.ServerSideUIViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.ably.lib.realtime.AblyRealtime


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ServerSideUIViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {

            ServerSideUITheme {
                Box(Modifier.verticalScroll(rememberScrollState())) {
                    val state by viewModel.uiList.collectAsState()
                    LaunchedEffect(key1 = Unit) {
                        viewModel.getUIFromServer()
                    }
                    DeriveUIFromServer(components = state?.json?.json)
                }

            }
        }
    }

    private fun subscribeToChannel(ablyRealtime: AblyRealtime) {

    }
}



