plugins {
    alias(libs.plugins.uptodo.android.library)
    alias(libs.plugins.ksp)

}

android {
    namespace = "com.uuthman.common.androidtest"

}

dependencies {
    implementation(libs.hilt.android.test)
    ksp(libs.hilt.android.compiler)
    implementation(libs.androidx.junit.runner)
    implementation(libs.androidx.test.core)
    implementation(libs.androidx.junit)
    implementation(libs.androidx.junit.ext)
}