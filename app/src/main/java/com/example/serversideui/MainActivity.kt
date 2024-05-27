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


                        try {
                            val ablyRealtime = AblyRealtime(AppConstants.ABLY_REALTIE_KEY)
                            val channel = ablyRealtime.channels.get("android-json")
                            ablyRealtime.connection.on(
                                ConnectionEvent.connected,
                                ConnectionStateListener {
                                    Log.d("connection", "connection Successfull")
                                    channel.subscribe(object: Channel.MessageListener{
                                        override fun onMessage(message: Message?) {
                                            Log.d("Ably",message.toString())
                                        }

                                    })
                                })
                        }catch (e:Exception){
                            Toast.makeText(this@MainActivity,e.toString(),Toast.LENGTH_LONG).show()
                            Log.d("error",e.toString())
                        }


                        DeriveUIFromServer(components = state?.json)



            }
        }
    }

    private fun subscribeToChannel(ablyRealtime: AblyRealtime) {


    }
}



