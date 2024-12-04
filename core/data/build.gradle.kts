plugins {
    alias(libs.plugins.uptodo.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.uptodo.android.hilt)


}

android {
    namespace = "com.uuthman.core.data"
}

dependencies {

    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)

    implementation(libs.kotlinx.serialization.json)
}