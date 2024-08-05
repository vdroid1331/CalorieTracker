package com.vinayakgupta3112.calorytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.vinayakgupta3112.calorytracker.ui.theme.CaloryTrackerTheme
import com.vinayakgupta3112.onboarding_presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                WelcomeScreen()
            }
        }
    }
}