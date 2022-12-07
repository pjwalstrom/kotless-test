import io.kotless.plugin.gradle.dsl.kotless

plugins {
    kotlin("jvm") version "1.6.10" apply true
    id("io.kotless") version "0.2.0" apply true
    id("com.github.ben-manes.versions") version "0.42.0"
}
group = "me.pj"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = uri("https://packages.jetbrains.team/maven/p/ktls/maven"))
}
dependencies {
    //implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    //implementation(kotlin("stdlib"))
    implementation("io.kotless", "kotless-lang", "0.2.0")
    implementation("io.kotless", "kotless-lang-aws", "0.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.8.0")
    implementation("io.ktor:ktor-client-core:2.2.1")
    implementation("io.ktor:ktor-client-apache:2.1.0")
}

// https://github.com/ben-manes/gradle-versions-plugin
fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    // https://github.com/ben-manes/gradle-versions-plugin
    dependencyUpdates {
        rejectVersionIf {
            isNonStable(candidate.version)
        }
    }
}

kotless {
    config {
        aws {
            storage {
                bucket = "kotless.waperon.org"
            }
            profile = "kotless"
            region = "eu-north-1"
        }
    }

    webapp {
        dns("www", "waperon.org")
    }
}
