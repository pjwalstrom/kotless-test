package me.pj

import io.kotless.MimeType
import io.kotless.dsl.lang.http.Get
import io.kotless.dsl.lang.http.StaticGet
import kotlinx.html.*
import kotlinx.html.stream.createHTML
import java.io.File
import java.time.LocalDateTime
import java.util.TimeZone

@StaticGet("/fjell.jpg", MimeType.JPEG)
val fjell = File("fjell.jpg")

@StaticGet("/favicon.ico", MimeType.PNG)
val favicon = File("favicon.ico")

@Get("/")
fun root(): String {
    return createHTML().html {
        head {
            link {
                rel = "shortcut icon"
                type = "image/png"
                href = "/favicon.ico"
            }
        }
        body {
            h1 { +"Hello World" }
            div {
                +"Local datetime: ${LocalDateTime.now()} in TimeZone ${TimeZone.getDefault().id}"
                p {
                    +"Powered by "
                    a("https://github.com/JetBrains/kotless") { +"Kotless" }
                }
                p {
                    img(src = "/fjell.jpg")
                }
            }
        }
    }
}

@Get("/tz")
fun tz() = "${TimeZone.getDefault()}"