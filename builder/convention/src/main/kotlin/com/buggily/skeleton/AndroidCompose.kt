package com.buggily.skeleton

import com.android.build.api.dsl.CommonExtension
import ext.getLibs
import ext.getVersion
import org.gradle.api.Project

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) = with(commonExtension) {

    compileSdk = 35

    buildFeatures {
        compose = true
    }
}
