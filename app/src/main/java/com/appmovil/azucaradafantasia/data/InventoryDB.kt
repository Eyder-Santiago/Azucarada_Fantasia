package com.appmovil.azucaradafantasia.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appmovil.azucaradafantasia.model.Inventory
import com.appmovil.azucaradafantasia.util.Constans.NAME_BD

//trabajo con la entidad Inventory, para hacer la conexion con la base de datos
@Database(entities = [Inventory::class], version = 1) //sólo se usará una entidad por ahora
abstract class InventoryDB : RoomDatabase() {  //heredo de RoomDatabase

    abstract fun inventoryDao(): InventoryDao

    companion object{   //esto debe ser consumido por el repositorio
        fun getDatabase(context: Context): InventoryDB {
            return Room.databaseBuilder(
                context.applicationContext,
                InventoryDB::class.java,
                NAME_BD
            ).build()
        }
    }
}