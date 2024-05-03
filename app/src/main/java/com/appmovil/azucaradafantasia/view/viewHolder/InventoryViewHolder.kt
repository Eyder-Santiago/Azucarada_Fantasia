package com.appmovil.azucaradafantasia.view.viewHolder

import android.os.Bundle
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.appmovil.azucaradafantasia.R
import com.appmovil.azucaradafantasia.databinding.ItemInventoryBinding
import com.appmovil.azucaradafantasia.model.Inventory

//hereda de RecyclerView.ViewHolder(binding.root), con la raíz de binding
//creando el contexto para poder pasarlo al repository
class InventoryViewHolder(binding: ItemInventoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val bindingItem = binding  //contiene el item que recibe como parámetro
    fun setItemInventory(inventory: Inventory) {
        bindingItem.tvName.text = inventory.name
        bindingItem.tvPrice.text = "$ ${inventory.price}"
        bindingItem.tvQuantity.text = "${inventory.quantity}"  //le añado el signo de pesos

    }

}