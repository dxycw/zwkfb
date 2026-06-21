package com.dxyc.zwkfb

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import multiplatform.zwkfb.sayHello
import 安卓x.组合.材质3.文本

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    routing {
        get("/") {
            call.respondText(sayHello("Ktor"))
        }
    }
}