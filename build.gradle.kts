
buildscript {
    dependencies {
//        classpath(ClassPaths.safeArgs)
//        classpath(ClassPaths.daggerHilt)
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
    }
}
plugins {
    id ("com.android.application") version ("7.1.3") apply false
    id ("com.android.library") version ("7.1.3") apply false
    id ("org.jetbrains.kotlin.android") version ("1.6.20") apply false
}

tasks.register("clean").configure{
    delete("build")
}