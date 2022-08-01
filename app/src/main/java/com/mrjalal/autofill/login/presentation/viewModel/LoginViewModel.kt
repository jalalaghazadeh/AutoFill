package com.mrjalal.autofill.login.presentation.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class UiState(
    val userName: String = "",
    val password: String = "",
    val isUserNameValid: Boolean? = null,
    val isPasswordValid: Boolean? = null
)

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState
}
