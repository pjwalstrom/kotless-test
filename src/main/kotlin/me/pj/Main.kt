package me.pj

import io.kotless.MimeType
import io.kotless.dsl.lang.http.Get
import io.kotless.dsl.lang.http.StaticGet
import io.kotless.dsl.lang.http.href
import kotlinx.html.*
import kotlinx.html.stream.createHTML
import java.io.File
import java.time.LocalDateTime
import java.util.TimeZone

@StaticGet("/fjell.jpg", MimeType.JPEG)
val fjell = File("fjell.jpg")

@StaticGet("/favicon.png", MimeType.PNG)
val favicon = File("favicon.png")

@StaticGet("/kotless-test.css", MimeType.CSS)
val css = File("kotless-test.css")

@Get("/")
fun root(): String {
    return createHTML().html {
        head {
            link {
                href = ::favicon.href
                rel = "icon"
            }
            link {
                href = ::css.href
                rel = "stylesheet"
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