package com.fianchi.plantlife

import java.time.Instant
import java.util.UUID

data class Plant(
        val id: String,
        val name: String,
        val species: String? = null,
        //val createdTimestamp: Instant,
        //val updatedTimestamp: Instant
)
