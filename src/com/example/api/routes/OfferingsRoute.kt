package com.example.api.routes

import com.example.com.example.models.api.OfferingCreateRequest
import com.example.com.example.models.api.OfferingUpdateRequest
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import com.example.services.OfferingsService
import io.ktor.features.BadRequestException
import io.ktor.features.NotFoundException
import io.ktor.request.receive
import io.ktor.routing.delete
import io.ktor.routing.post
import io.ktor.routing.put
import org.kodein.di.instance
import org.kodein.di.ktor.di

fun Route.offerings() {
    val offeringsService by di().instance<OfferingsService>()

    get("offerings") {
        val all = offeringsService.getAll()

        call.respond(all)
    }

    get("offerings/{id}") {
        val id = call.parameters["id"] ?: throw BadRequestException("invalid id: id")
        val offering = offeringsService.getById(id) ?: throw NotFoundException()

        call.respond(offering)
    }

    post("offerings") {
        val offeringRequest = call.receive<OfferingCreateRequest>()

        val offering = offeringsService.create(offeringRequest)
        call.respond(offering)
    }

    put("offerings/{id}") {
        val id = call.parameters["id"] ?: throw BadRequestException("invalid id: id")
        val offeringRequest = call.receive<OfferingUpdateRequest>()

        val offering = offeringsService.update(id, offeringRequest)
        call.respond(offering)
    }

    delete("offerings/{id}") {
        val id = call.parameters["id"] ?: throw BadRequestException("invalid id: id")

        val offering = offeringsService.delete(id)
        call.respond(offering)
    }
}