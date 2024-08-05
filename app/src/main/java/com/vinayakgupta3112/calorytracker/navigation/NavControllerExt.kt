package com.vinayakgupta3112.calorytracker.navigation

import androidx.navigation.NavController
import com.vinayakgupta3112.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}