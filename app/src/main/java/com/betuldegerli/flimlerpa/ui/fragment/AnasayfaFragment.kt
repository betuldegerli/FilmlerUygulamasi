package com.betuldegerli.flimlerpa.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.betuldegerli.flimlerpa.R
import com.betuldegerli.flimlerpa.data.entity.Filmler
import com.betuldegerli.flimlerpa.databinding.FragmentAnasayfaBinding
import com.betuldegerli.flimlerpa.ui.adapter.FilmlerAdapter


class AnasayfaFragment : Fragment() {
private  lateinit var binding:FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding=FragmentAnasayfaBinding.inflate(inflater, container, false)
binding.toolbar.title="Filmler"
        binding.filmlerRv.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

val filmlerListesi=ArrayList<Filmler>()
        val f1=Filmler(1, "Titanic", "titanic", 24)
        val f2=Filmler(2, "Man and The Kid", "manandkid", 24)
        val f3=Filmler(3, "Hobbit", "hobbit", 24)
        val f4=Filmler(4, "Thor", "thor", 24)
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)


val filmAdapter=FilmlerAdapter(requireContext(), filmlerListesi)
        binding.filmlerRv.adapter=filmAdapter
        return binding.root
    }

}