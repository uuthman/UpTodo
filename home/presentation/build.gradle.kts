plugins {
    alias(libs.plugins.uptodo.android.feature.ui)
}

android {
    namespace = "com.uuthman.home.presentation"
}

dependencies {

    implementation(projects.core.domain)
}