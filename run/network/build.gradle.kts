plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "me.dotcode.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}