import io.kotless.plugin.gradle.dsl.Webapp.Route53
import io.kotless.plugin.gradle.dsl.kotless
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72" apply true
    id("io.kotless") version "0.1.7-beta-4" apply true
}
group = "me.pj"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.kotless", "kotless-lang", "0.1.7-beta-4")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
kotless {
    config {
        bucket = "kotless.waperon.org"
        terraform {
            profile = "kotless"
            region = "eu-north-1"
        }
    }
    webapp {
        route53 = Route53("www", "waperon.org")
    }
}