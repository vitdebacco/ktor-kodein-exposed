package com.example.config

import com.example.services.OfferingsService
import com.example.services.OfferingsServiceImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

// https://kodein.org/di/

fun DI.MainBuilder.bindServices() {
    bind<OfferingsService>() with singleton { OfferingsServiceImpl() }
}