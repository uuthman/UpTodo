plugins {
    alias(libs.plugins.uptodo.android.library)

}

android {
    namespace = "com.uuthman.auth.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
    implementation(projects.core.data)
}