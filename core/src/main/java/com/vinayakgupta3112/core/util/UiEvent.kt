package com.vinayakgupta3112.core.util

sealed class UiEvent {
    object Success: UiEvent()
    data class Navigate(val route: String): UiEvent()
    object NavigateUp: UiEvent()
    data class ShowSnackbar(val message: UiText): UiEvent()
}