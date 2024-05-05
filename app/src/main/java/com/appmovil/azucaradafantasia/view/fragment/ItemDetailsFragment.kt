package com.appmovil.azucaradafantasia.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.appmovil.azucaradafantasia.R
import com.appmovil.azucaradafantasia.databinding.FragmentItemDetailsBinding
import com.appmovil.azucaradafantasia.databinding.FragmentItemEditBinding
import com.appmovil.azucaradafantasia.model.Inventory
import com.appmovil.azucaradafantasia.viewModel.InventoryViewModel



class ItemDetailsFragment : Fragment() {

    private lateinit var binding: FragmentItemDetailsBinding
    private val inventoryViewModel: InventoryViewModel by viewModels()
    private lateinit var receivedInventory: Inventory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
    }

    private fun controladores(){


    }

}