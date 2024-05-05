package com.appmovil.azucaradafantasia.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appmovil.azucaradafantasia.model.Inventory
import com.appmovil.azucaradafantasia.repository.InventoryRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class InventoryViewModel(application: Application) : AndroidViewModel(application) {
    //Crear el método de guardar; se llama el método saveInventoy() de la clase AddItemFragment
    val context = getApplication<Application>()
    private val inventoryRepository = InventoryRepository(context)

    //creando los observadores livedata
    private val _listInventory = MutableLiveData<MutableList<Inventory>>()
    val listInventory: LiveData<MutableList<Inventory>> get() = _listInventory //recibe la lista de inventario

    private val _progresState = MutableLiveData(false)
    val progresState: LiveData<Boolean> = _progresState

    fun saveInventory(inventory: Inventory) {  //creando un escenario donde un método que no es una ecorrutina
        viewModelScope.launch {
            inventoryRepository.saveInventory(inventory) //método guardar que es de segundo plano
        }

    }

    fun getListInventory() {
        viewModelScope.launch {
            _listInventory.value = inventoryRepository.getListInventory()
        }
    }

}