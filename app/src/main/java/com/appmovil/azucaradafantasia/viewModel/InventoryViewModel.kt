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
    val context = getApplication<Application>()
    private val inventoryRepository = InventoryRepository(context)

    //usando los liveData, observa los cambios de la lista de inventario; captura los cambios con la variable _listInventory
    private val _listInventory = MutableLiveData<MutableList<Inventory>>()
    val listInventory: LiveData<MutableList<Inventory>> get() = _listInventory

    private val _progresState = MutableLiveData(false)
    val progresState: LiveData<Boolean> = _progresState



    fun saveInventory(inventory: Inventory) {  //creando un escenario donde un método que no es una ecorrutina
        viewModelScope.launch {

            _progresState.value = true
            try {
                inventoryRepository.saveInventory(inventory) //método guardar que es de segundo plano
                _progresState.value = false
            } catch (e: Exception) {
                _progresState.value = false
            }
        }
    }

    fun getListInventory() {
        viewModelScope.launch {
            _progresState.value = true
            try {
                _listInventory.value = inventoryRepository.getListInventory() //obteniendo la lista de inventario (los cambios)
                _progresState.value = false
            } catch (e: Exception) {
                _progresState.value = false
            }

        }
    }

    fun totalProducto(price: Int, quantity: Int): Double {
        val total = price * quantity
        return total.toDouble()
    }



}
