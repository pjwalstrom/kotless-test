//import io.kotless.DSLType
import io.kotless.plugin.gradle.dsl.Webapp.Route53
import io.kotless.plugin.gradle.dsl.kotless
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72" apply true
    id("io.kotless") version "0.1.6" apply true
}
group = "me.pj"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.kotless", "kotless-lang", "0.1.6")
    //implementation("org.jetbrains.kotlinx", "kotlinx-html-jvm", "0.6.11")
    //testImplementation(kotlin("test-junit5"))
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
kotless {
    config {
        //bucket that kotless will use to store its artifacts
        bucket = "www.waperon.org"
        //prefix that will be added to all resources created in AWS
        //prefix = "dev"

        //directory against which @StaticGet annotated files are resolved
        //workDirectory = file("src/main/static")

//        dsl {
//            type = DSLType.Kotless
//            //or for Ktor
//            //type = DSLType.Ktor
//        }

        terraform {
            profile = "pj.kotless"
            region = "eu-north-1"
//            region = "us-east-1"
        }
    }

    //webapp for this gradle project
    webapp {
        //configuration of lambda created
        lambda {
//            memoryMb = 1024
//            timeoutSec = 120
            kotless {
                packages = setOf("me.pj")
            }
        }
        //route53 alias for deployed application, must be in us-east-1?
        route53 = Route53("_e491cf4eb0d63b4d22903af02782d761", "waperon.org")
    }
}