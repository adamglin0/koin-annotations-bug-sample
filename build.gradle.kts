plugins {
    kotlin("multiplatform") version "2.0.0"
    id("com.android.library") version "8.2.0"
    id("com.google.devtools.ksp") version "2.0.0-1.0.23"
}

group = "com.example"
version = "1.0-SNAPSHOT"

val koinCore = "4.0.0-RC1"
val koinAnnotations = "1.4.0-RC3"

kotlin {
    androidTarget()
    jvm()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation("io.insert-koin:koin-core:$koinCore")
            api("io.insert-koin:koin-annotations:$koinAnnotations")
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", "io.insert-koin:koin-ksp-compiler:$koinAnnotations")
    add("kspAndroid", "io.insert-koin:koin-ksp-compiler:$koinAnnotations")
    add("kspIosX64", "io.insert-koin:koin-ksp-compiler:$koinAnnotations")
    add("kspIosArm64", "io.insert-koin:koin-ksp-compiler:$koinAnnotations")
    add("kspIosSimulatorArm64", "io.insert-koin:koin-ksp-compiler:$koinAnnotations")
}

android {
    namespace = "com.example.example"
    compileSdk = 34

    defaultConfig {
        minSdk = 29
        lint.targetSdk = 34
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}