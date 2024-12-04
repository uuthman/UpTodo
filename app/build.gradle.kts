plugins {
    alias(libs.plugins.uptodo.android.application.compose)
    alias(libs.plugins.uptodo.android.hilt)
    alias(libs.plugins.firebase)
}

android {
    namespace = "com.uuthman.uptodo"


    defaultConfig {
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.navigation.compose)

    //Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Splash screen
    implementation(libs.androidx.core.splashscreen)

    // Timber
    implementation(libs.timber)

    // Crypto
    implementation(libs.androidx.security.crypto.ktx)

    implementation(projects.core.presentation.designsystem)
    implementation(projects.core.presentation.ui)
    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.core.data)

    implementation(projects.auth.data)
    implementation(projects.auth.domain)
    implementation(projects.auth.presentation)

    implementation(projects.home.presentation)

}