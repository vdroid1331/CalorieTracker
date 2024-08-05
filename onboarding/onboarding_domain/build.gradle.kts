plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.vinayakgupta3112.onboarding_domain"
}

dependencies {
    implementation(project(Modules.core))
}