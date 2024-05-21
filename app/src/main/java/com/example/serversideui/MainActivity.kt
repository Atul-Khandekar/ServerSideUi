package com.example.serversideui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.example.composables.DeriveUIFromServer
import com.example.model.DataSource
import com.example.serversideui.ui.theme.ServerSideUITheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.*
import com.example.viewmodel.ServerSideUIViewModel
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ServerSideUIViewModel by viewModels()
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            ServerSideUITheme {

                val pullToRefreshState = rememberPullToRefreshState()
                Box(modifier = Modifier
                    .nestedScroll(pullToRefreshState.nestedScrollConnection)
                    .verticalScroll(rememberScrollState())
                ) {
                    var isRefreshing by remember {
                        mutableStateOf(false)
                    }
                    DeriveUIFromServer(components = DataSource.getData())

                    if(pullToRefreshState.isRefreshing) {
                        LaunchedEffect(key1 = true) {
                           //api call
                            isRefreshing = true
                            delay(3000)
                            isRefreshing = false

                        }
                    }

                    LaunchedEffect(key1 = isRefreshing) {
                        if(isRefreshing) {
                            pullToRefreshState.startRefresh()
                        } else {
                            pullToRefreshState.endRefresh()
                        }

                    }


                    PullToRefreshContainer(state = pullToRefreshState
                    , modifier = Modifier.align(Alignment.TopCenter),
                    )
                }

            }
        }
    }
}


