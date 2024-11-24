plugins {
    alias(libs.plugins.uptodo.android.library)
}

android {
    namespace = "com.uuthman.core.data"
}

dependencies {

    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}