package com.appmovil.azucaradafantasia.repository

import android.content.Context
import com.appmovil.azucaradafantasia.data.InventoryDB
import com.appmovil.azucaradafantasia.data.InventoryDao
import com.appmovil.azucaradafantasia.model.Inventory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InventoryRepository(val context: Context) {
    private var inventoryDao: InventoryDao = InventoryDB.getDatabase(context).inventoryDao()
    //private var apiService: ApiService = ApiUtils.getApiService()
    suspend fun saveInventory(inventory: Inventory) {
        withContext(Dispatchers.IO) {
            inventoryDao.saveInventory(inventory)
        }
    }

    suspend fun getListInventory():MutableList<Inventory>{
        return withContext(Dispatchers.IO){
            inventoryDao.getListInventory() //tiene toda la información de los cambios
        }
    }
}
