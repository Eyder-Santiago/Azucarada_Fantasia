package com.appmovil.azucaradafantasia.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

//@Entity(tableName = "inventory"), colocamos @Entity para que el modelo haga el papel de tabla
//se necesita la librería de room
@Entity
data class Inventory(
    @PrimaryKey(autoGenerate = true) //enumera 1 2 3 cada dato creado
    val id: Int = 0,
    val name: String,
    val price: Int,
    val quantity: Int): Serializable  //hereda de Serializable para poder pasar el objeto entre actividades

