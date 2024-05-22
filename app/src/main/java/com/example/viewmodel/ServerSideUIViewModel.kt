package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.BaseResponse
import com.example.model.ServerResponseModel
import com.example.repository.ServerSideUIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ServerSideUIViewModel @Inject constructor(private val repository: ServerSideUIRepository) :
    ViewModel() {


    private var _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private var _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()

    private var _uiList = MutableStateFlow<ServerResponseModel?>(null)
    val uiList = _uiList.asStateFlow()


    fun getUIFromServer() {
        viewModelScope.launch {
            repository.getUIFromServer().collectLatest {
                when (it) {
                    is BaseResponse.Loading -> {
                        _isLoading.emit(true)
                    }

                    is BaseResponse.Success -> {
                        it.data.let { response ->
                            _uiList.emit(response)
                        }
                        _isLoading.emit(false)
                    }

                    is BaseResponse.Error -> {
                        _errorMessage.emit(it.msg)
                        _isLoading.emit(false)
                    }
                }
            }
        }
    }
}