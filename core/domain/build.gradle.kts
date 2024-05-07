plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply(from = "${rootProject.projectDir}/android-common.gradle")

android {
    namespace = "com.matddev.anotaapp.core.domain"
}

dependencies {

    implementation(libs.androidx.paging.runtime)
    implementation(libs.paging.compose)
}
