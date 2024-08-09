package com.vinayakgupta3112.tracker_presentation.search

import com.vinayakgupta3112.tracker_domain.model.TrackableFood

data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)