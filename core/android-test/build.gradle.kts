plugins {
    alias(libs.plugins.uptodo.android.library)
    alias(libs.plugins.uptodo.android.junit5)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.uuthman.core.android_test"

}

dependencies {
    implementation(libs.hilt.android.test)
    ksp(libs.hilt.android.compiler)
    implementation(libs.androidx.junit.runner)
    implementation(libs.androidx.test.core)

}