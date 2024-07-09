plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "me.dotcode.auth.presentation"
}

dependencies {
    
    implementation(libs.coil.compose)
    implementation(libs.google.maps.android.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.timber)

    implementation(projects.auth.domain)
    implementation(projects.core.domain)
}