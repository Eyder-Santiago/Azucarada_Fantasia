package com.appmovil.azucaradafantasia.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.appmovil.azucaradafantasia.databinding.FragmentHomeInventoryBinding
import com.appmovil.azucaradafantasia.R
import com.appmovil.azucaradafantasia.model.Inventory
import com.appmovil.azucaradafantasia.view.adapter.InventoryAdapter

//import com.appmovil.azucaradafantasia.view.adapter.InventoryAdapter
//import com.appmovil.azucaradafantasia.viewmodel.InventoryViewModel
class HomeInventoryFragment : Fragment() {
    private lateinit var binding: FragmentHomeInventoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeInventoryBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
    }

    //llama los componentes de la vista para tener all mejor ordenado, cuando le dé clic al botón vaya a controladores()
    private fun controladores() {
        binding.fbagregar.setOnClickListener {//al dar clic me lleve al fragment de agregar
            findNavController().navigate(R.id.action_homeInventoryFragment_to_addItemFragment)
        }

        recycler()
    }

    fun recycler(){
        var listaPasteles = mutableListOf(
            Inventory("Pastel de Chocolate", 12000, 5),
            Inventory( "Pastel de Vainilla", 11000, 2),
            Inventory( "Pastel de Fresa", 10500, 1),
            Inventory( "Pastel de Avena", 16000, 6),
            Inventory( "Pastel de Durazno", 19000, 2),
        )

        val recyclerVar = binding.recyclerview
        recyclerVar.layoutManager = LinearLayoutManager(context)
        val adapter = InventoryAdapter(listaPasteles)
        recyclerVar.adapter = adapter
        adapter.notifyDataSetChanged()

    }


}