plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "me.dotcode.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}