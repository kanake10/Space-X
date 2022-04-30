plugins {
    id(Versions.BuildPlugins.androidApplication)
    id(Versions.BuildPlugins.kotlinAndroid)
    id(Versions.BuildPlugins.kotlinKapt)
    id(Versions.BuildPlugins.hiltPlugin)
    id(Versions.BuildPlugins.navArgsPlugin)
    id("com.apollographql.apollo").version("2.5.4")
}

android {
    compileSdkVersion(BuildConfig.compileSdkVersion)

    android.buildFeatures.dataBinding = true
    android.buildFeatures.viewBinding = true

    compileSdk = 32
    buildToolsVersion = "30.0.3"

    defaultConfig {

        //object build is set for this
        applicationId = "com.example.spacex"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    apollo {
        // instruct the compiler to generate Kotlin models
        generateKotlinModels.set(true)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation (Versions.Deps.legacy)
    implementation (Versions.Deps.kotlin)
    implementation (Versions.Deps.lifecycle)
    implementation (Versions.Deps.nav)
    implementation (Versions.Deps.navigation)
    implementation (Versions.Deps.apollo)
    implementation (Versions.Deps.coil)
    implementation (Versions.Deps.hilt)
    implementation (Versions.Deps.hiltKapt)
    implementation (Versions.Deps.hiltVm)
    implementation (Versions.Deps.coreKtx)
    implementation (Versions.Deps.constraint)
    implementation (Versions.Deps.appCompat)
    implementation (Versions.Deps.material)


}