object Versions {

    //Version codes for all the libraries
    const val kotlin = "1.6.20"
    const val apollo = "2.5.4"
    const val hilt = "2.38.1"
    const val legacy_support_v4_version = "1.0.0"
    const val hiltCompiler = "2.38.1"
    const val buildToolsVersion = "3.5.3"
    const val nav = "2.4.2"
    const val lifecyle = "2.3.0"
    const val coil = "1.1.1"
    const val appcompat = "1.4.1"
    const val constraintLayout = "2.1.3"
    const val ktxCore = "1.7.0"
    const val material = "1.5.0"
    const val lottie = "3.6.0"

    //Version codes for all the test libraries
    const val junit4 = "4.13.2"
    const val testRunner = "1.1.1"
    const val espresso = "3.4.0"
    const val annotation = "1.1.0"

    object ClassPaths {
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav}"
        const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    }
    object BuildModules{
        const val App = ":app"
    }

    object BuildPlugins{
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val kotlinKapt = "kotlin-kapt"
        const val hiltPlugin = "dagger.hilt.android.plugin"
        const val navArgsPlugin = "androidx.navigation.safeargs.kotlin"
    }

    object Deps{
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy_support_v4_version}"
        //lifecycle
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecyle}"
        //navs
        const val nav = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
        const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
        //apollo
        const val apollo = "com.apollographql.apollo:apollo-runtime:${Versions.apollo}"
        const val coroutines = "com.apollographql.apollo:apollo-coroutines-support:${Versions.apollo}"
        //coil
        const val coil = "io.coil-kt:coil:${Versions.coil}"
        //lottie
        const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
        //hilt
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.hilt}"
        const val hiltVm = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltCompiler}"
        //core
        const val coreKtx = "androidx.core:core-ktx:${Versions.ktxCore}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"


    }


}