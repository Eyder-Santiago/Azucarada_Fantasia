package com.appmovil.azucaradafantasia.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appmovil.azucaradafantasia.model.Inventory
import com.appmovil.azucaradafantasia.repository.InventoryRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.AndroidViewModel

class InventoryViewModel(application: Application) : AndroidViewModel(application) {
    //Crear el método de guardar; se llama el método saveInventoy() de la clase AddItemFragment
    val context = getApplication<Application>()
    private val inventoryRepository = InventoryRepository(context)

    fun saveInventory(inventory: Inventory) {  //creando un escenario donde un método que no es una ecorrutina
        viewModelScope.launch {
            inventoryRepository.saveInventory(inventory) //método guardar que es de segundo plano
        }

    }

}