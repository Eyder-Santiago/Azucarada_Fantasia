package com.appmovil.azucaradafantasia.model

import java.io.Serializable

data class Inventory (
    val name: String,
    val price: Int,
    val quantity: Int
): Serializable