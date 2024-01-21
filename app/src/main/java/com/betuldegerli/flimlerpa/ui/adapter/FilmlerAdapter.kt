package com.betuldegerli.flimlerpa.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.betuldegerli.flimlerpa.data.entity.Filmler
import com.betuldegerli.flimlerpa.databinding.CardTasarimBinding
import com.betuldegerli.flimlerpa.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter (var mContext:Context, var filmlerListesi:List<Filmler>)
    :RecyclerView.Adapter<FilmlerAdapter.cardTasarimTutucu>()
{

    inner class cardTasarimTutucu(var tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimTutucu {
        val binding= CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return cardTasarimTutucu(binding)
    }

//burda classtaki film fiyatı ve resmini çektik
    override fun onBindViewHolder(holder: cardTasarimTutucu, position: Int) {
        val film= filmlerListesi.get(position)
        val t=holder.tasarim
        t.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(film.resimadi, "drawable", mContext.packageName))
        t.textViewFiyat.text="${film.fiyat}"

    t.card.setOnClickListener{
        val gecis= AnasayfaFragmentDirections.detayGecis(film=film)
        Navigation.findNavController(it).navigate(gecis)
    }
    t.sepeteEkle.setOnClickListener {
        Snackbar.make(it, "${film.ad} sepete eklendi. ", Snackbar.LENGTH_SHORT).show()
    }
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }
}