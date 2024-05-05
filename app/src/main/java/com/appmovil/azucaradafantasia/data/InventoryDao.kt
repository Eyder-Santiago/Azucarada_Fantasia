package com.appmovil.azucaradafantasia.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.appmovil.azucaradafantasia.model.Inventory

@Dao
interface InventoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend es para que se ejecute en un hilo secundario, corrutinas; haciendo instancias para consumir el método "que es una consulta de la base de datos"
    suspend fun saveInventory(inventory: Inventory)

    @Query("SELECT * FROM Inventory")
    suspend fun getListInventory(): MutableList<Inventory>

    @Delete
    suspend fun deleteInventory(inventory: Inventory)

    @Update
    suspend fun updateInventory(inventory: Inventory)
}