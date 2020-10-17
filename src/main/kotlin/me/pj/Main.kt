package me.pj

import io.kotless.dsl.lang.http.Get
import java.time.LocalDateTime
import java.util.TimeZone

@Get("/")
fun root() = "Local datetime: ${LocalDateTime.now()} in TimeZone ${TimeZone.getDefault().id}"

@Get("/tz")
fun tz() = "${TimeZone.getDefault()}"