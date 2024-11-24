plugins {
    alias(libs.plugins.uptodo.android.feature.ui)
}

android {
    namespace = "com.uuthman.auth.presentation"

}

dependencies {

    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}