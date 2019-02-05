/*
 * Copyright (c) 2017. Louis Cognault Ayeva Derman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(ProjectVersions.androidSdk)
    buildToolsVersion(ProjectVersions.androidBuildTools)
    defaultConfig {
        minSdkVersion(14)
        targetSdkVersion(ProjectVersions.androidSdk)
        versionCode = 1
        versionName = ProjectVersions.thisLibrary
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    sourceSets.forEach { it.java.srcDir("src/${it.name}/kotlin") }
}

dependencies {
    api(project(":experimental"))
    api(project(":mainhandler"))
    api(project(":mainthread"))
    api(Libs.kotlin.stdlibJdk7)
    api(Libs.kotlinX.coroutines.android)
    api(Libs.androidX.lifecycle.common)
    arrayOf(
        Libs.kotlinX.coroutines.test,
        Libs.kotlin.testJunit,
        Libs.androidX.lifecycle.runtime
    ).forEach {
        testImplementation(it)
        androidTestImplementation(it)
    }
    androidTestImplementation(Libs.androidX.test.runner)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().whenTaskAdded {
    kotlinOptions.freeCompilerArgs = listOf("-Xuse-experimental=kotlin.Experimental")
}

apply {
    from("../publish.gradle")
}