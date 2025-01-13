plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-parcelize") // For @Parcelize support
}

android {
    namespace = "com.example.tiptime"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.tiptime"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    // Core dependencies
    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")

    // Compose BOM (Bill of Materials) to manage all Compose versions
    implementation(platform("androidx.compose:compose-bom:2023.01.00"))

    // Material 3 dependency for Compose
    implementation("androidx.compose.material3:material3:1.0.0")

    // Core Compose UI
    implementation("androidx.compose.ui:ui:1.4.0")

    // UI tools
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.4.0")

    // Testing dependencies
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.0")
    androidTestImplementation(platform("androidx.compose:compose-bom"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.espresso:espresso-core:3.5.1")

    // Navigation and ViewModel support
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.navigation:navigation-compose:2.7.0")

    // Compose Foundation (necessary for some layout components)
    implementation("androidx.compose.foundation:foundation:1.4.0")

}
