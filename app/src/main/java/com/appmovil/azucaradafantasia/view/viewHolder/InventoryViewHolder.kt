package com.appmovil.azucaradafantasia.view.viewHolder

import android.os.Bundle
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.appmovil.azucaradafantasia.R
import com.appmovil.azucaradafantasia.databinding.ItemInventoryBinding
import com.appmovil.azucaradafantasia.model.Inventory

//hereda de RecyclerView.ViewHolder(binding.root), con la raíz de binding
//creando el contexto para poder pasarlo al repository
class InventoryViewHolder(binding: ItemInventoryBinding, navController: NavController) :
    RecyclerView.ViewHolder(binding.root) {
    val bindingItem = binding  //contiene el item que recibe como parámetro
    val navController = navController
    fun setItemInventory(inventory: Inventory) {
        bindingItem.tvName.text = inventory.name
        bindingItem.tvPrice.text = "$ ${inventory.price}"
        bindingItem.tvQuantity.text = "${inventory.quantity}"  //le añado el signo de pesos

        bindingItem.cvInventory.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("clave", inventory)
            //le paso el id que se seleccionó y le paso el bundle del card que el usuario quiere editar en una ventana
            //de detalle
            navController.navigate(R.id.action_homeInventoryFragment_to_itemDetailsFragment, bundle) //llevo la información a esa ventana
        }


    }

}