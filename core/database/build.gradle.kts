plugins {
    alias(libs.plugins.uptodo.android.library)
    alias(libs.plugins.uptodo.android.room)

}

android {
    namespace = "com.uuthman.core.database"
}

dependencies {

    implementation(projects.core.domain)
}