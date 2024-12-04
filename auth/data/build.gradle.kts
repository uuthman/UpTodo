plugins {
    alias(libs.plugins.uptodo.android.library)
    alias(libs.plugins.uptodo.android.hilt)
    alias(libs.plugins.uptodo.android.junit5)

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

    testImplementation(libs.kotlinx.coroutines.play.services)
    testImplementation(projects.core.test)
}