package com.example.beeradviser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BeersFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedinstanceState: Bundle?) : View? {
        val view = inflater.inflate(R.layout.fragment_beers, container, false)
        val beerType = BeersFragmentArgs.fromBundle(requireArguments()).beerType
        val beers = view.findViewById<TextView>(R.id.beers)
        beers.text = getBeers(beerType).reduce { str, item -> str + '\n' + item }
        return view;
    }

    private fun getBeers(color: String): List<String> {
        val brands = when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lita")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Bear", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
        return brands
    }
}