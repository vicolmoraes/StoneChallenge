package com.example.stonechallenge

import java.io.Serializable

data class ChuckResponse(
    var icon_url: String,
    var id: String,
    var url: String,
    var value: String
) : Serializable
