package com.example.api.routes

import io.ktor.routing.Routing
import io.ktor.routing.route

fun Routing.apiRoutes() {
    route("/api/v1") {
        offerings()
    }
}