plugins {
    alias(libs.plugins.uptodo.jvm.library)
    alias(libs.plugins.uptodo.jvm.junit5)
}

dependencies {
    implementation(projects.core.domain)
    implementation(libs.coroutines.test)
}
