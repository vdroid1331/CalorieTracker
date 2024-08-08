package com.vinayakgupta3112.onboarding_presentation.nutrient_goal

data class NutrientGoalState(
    val carbsRatio: String = "40",
    val proteinRatio: String = "30",
    val fatRatio: String = "30",
    val shouldShowOnboarding: Boolean = true
)
