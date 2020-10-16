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
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
kotless {
    config {
        //bucket that kotless will use to store its artifacts
        bucket = "www.waperon.org"

        terraform {
            profile = "pj"
            region = "eu-north-1"
        }
    }

    webapp {
//        lambda {
//            kotless {
//                packages = setOf("me.pj")
//            }
//        }
        //route53 alias for deployed application, must be in us-east-1?
        route53 = Route53("_e491cf4eb0d63b4d22903af02782d761", "waperon.org")
    }
}