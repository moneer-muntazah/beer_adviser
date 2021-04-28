package com.example.beeradviser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.navigation.findNavController

class ChooseTypeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?) : View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_choose_type, container, false)
        val spinner = view.findViewById<Spinner>(R.id.beer_color)
        val findBeerButton = view.findViewById<Button>(R.id.find_beer)
        findBeerButton.setOnClickListener{
            val beerType = spinner.selectedItem.toString()
            val action = ChooseTypeFragmentDirections
                .actionChooseTypeFragmentToBeersFragment(beerType)
            view.findNavController().navigate(action)
        }
        return view
    }
}