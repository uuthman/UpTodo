plugins {
    alias(libs.plugins.uptodo.android.library)
    alias(libs.plugins.uptodo.android.hilt)

}

android {
    namespace = "com.uuthman.auth.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
    implementation(projects.core.data)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
}