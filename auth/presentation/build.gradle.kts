plugins {
    alias(libs.plugins.uptodo.android.feature.ui)
    alias(libs.plugins.uptodo.android.junit5)
}

android {
    namespace = "com.uuthman.auth.presentation"

}

dependencies {

    implementation(projects.core.domain)
    implementation(projects.auth.domain)

}