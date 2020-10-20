package com.example.com.example.models.api

import java.net.URL

data class OfferingCreateRequest (
    val name: String,
    val tastingNotes: String,
    val description: String,
    val url: URL,
    val roasterName: String
)