package com.betuldegerli.flimlerpa.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.betuldegerli.flimlerpa.R
import com.betuldegerli.flimlerpa.databinding.FragmentDetayBinding

class DetayFragment : Fragment() {
private lateinit var binding:FragmentDetayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
binding=FragmentDetayBinding.inflate(inflater, container, false)

        val bundle:DetayFragmentArgs by navArgs()
        val film=bundle.film
        binding.toolbar2.title=film.ad
        binding.filmresim.setImageResource(
            resources.getIdentifier(film.resimadi, "drawable", requireContext().packageName)
        )
        binding.fiyatTxt.text="${film.fiyat} ₺"

        return  binding.root
    }


}