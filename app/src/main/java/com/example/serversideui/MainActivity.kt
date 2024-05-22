package com.example.serversideui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.example.composables.DeriveUIFromServer
import com.example.serversideui.ui.theme.ServerSideUITheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
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

                val state by viewModel.uiList.collectAsState()

                    val pullToRefreshState = rememberPullToRefreshState()
                    Box(
                        modifier = Modifier
                            .nestedScroll(pullToRefreshState.nestedScrollConnection)
                            .verticalScroll(rememberScrollState())

                    ) {

                        LaunchedEffect(Unit) {
                            viewModel.getUIFromServer()
                        }

                        var isRefreshing by remember {
                            mutableStateOf(false)
                        }

                        if (pullToRefreshState.isRefreshing) {
                            LaunchedEffect(
                                key1 = true
                            ) {
                                isRefreshing = true
                                viewModel.getUIFromServer()
                                isRefreshing = false
                            }
                        }

                        LaunchedEffect(key1 = isRefreshing) {
                            if (isRefreshing) {
                                pullToRefreshState.startRefresh()
                            } else {
                                pullToRefreshState.endRefresh()
                            }

                        }


                        DeriveUIFromServer(components = state?.json)
                        PullToRefreshContainer(
                            state = pullToRefreshState,
                            modifier = Modifier.align(Alignment.TopCenter),
                        )

                    }


            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetUIFromServer(viewmodel: ServerSideUIViewModel) {
    val state by viewmodel.uiList.collectAsState()

    DeriveUIFromServer(components = state?.json)
}


