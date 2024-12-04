plugins {
    alias(libs.plugins.uptodo.jvm.library)
}


dependencies {
    implementation(projects.core.domain)
}