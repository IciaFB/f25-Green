plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.earsync"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.earsync"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.5.15" }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}
kotlin {
    jvmToolchain(21)
}
dependencies {
    // Use your version catalog if you have entries:
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // OR (no catalog) use explicit artifacts:
    // val composeBom = platform("androidx.compose:compose-bom:2024.10.00")
    // implementation(composeBom)
    // implementation("androidx.compose.ui:ui")
    // implementation("androidx.compose.ui:ui-tooling-preview")
    // implementation("androidx.activity:activity-compose:1.9.2")
    // implementation("androidx.compose.material3:material3")
    // debugImplementation("androidx.compose.ui:ui-tooling")
}
