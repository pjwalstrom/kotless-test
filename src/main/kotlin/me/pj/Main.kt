package me.pj

import io.kotless.dsl.lang.http.Get
import java.time.LocalDateTime

@Get("/")
fun root(): String {
    return "Hello world! " + LocalDateTime.now()
}