/*
 * Copyright 2019-2021 Louis Cognault Ayeva Derman. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    publish
}

android {
    setDefaults()
    buildTypes.getByName("release").consumerProguardFiles("proguard-rules.pro")
}

kotlin {
    android()

    configure(targets) { configureMavenPublication() }
    sourceSets {
        androidMain.dependencies {
            api(AndroidX.annotation)
            api(splitties("experimental"))
            compileOnly(AndroidX.fragment)
            implementation(splitties("appctx"))
            implementation(splitties("mainthread"))
            implementation(splitties("exceptions"))
        }
    }
}
