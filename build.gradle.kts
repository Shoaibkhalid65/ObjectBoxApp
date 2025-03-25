// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
//        classpath "io.objectbox:objectbox-gradle-plugin:4.2.0"
        classpath(libs.objectbox.gradle.plugin)
    }
}
plugins {
    alias(libs.plugins.android.application) apply false

}