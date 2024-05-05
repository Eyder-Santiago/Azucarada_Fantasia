package com.appmovil.azucaradafantasia.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.appmovil.azucaradafantasia.databinding.ItemInventoryBinding
import com.appmovil.azucaradafantasia.model.Inventory
import com.appmovil.azucaradafantasia.view.viewHolder.InventoryViewHolder

//un adapter necesita de una lista, debe ser consumido por el recycler
class InventoryAdapter(private val listInventory:MutableList<Inventory>, private val navController: NavController):RecyclerView.Adapter<InventoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InventoryViewHolder {
        val binding = ItemInventoryBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return InventoryViewHolder(binding, navController)
    }

    //retorno el tamaño de la lista
    override fun getItemCount(): Int {
        return listInventory.size
    }

    //detecta en dónde hice touch y de acuerdo a eso obtiene el objeto
    override fun onBindViewHolder(holder: InventoryViewHolder, position: Int) {
        val inventory = listInventory[position]
        holder.setItemInventory(inventory)
    }
}