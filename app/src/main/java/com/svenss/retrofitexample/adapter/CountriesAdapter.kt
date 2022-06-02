package com.svenss.retrofitexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.svenss.retrofitexample.databinding.AdapterCountriesBinding
import com.svenss.retrofitexample.model.Country
import com.svenss.retrofitexample.ui.viewholder.ViewHolderCountries

/**
 * Created by miguelleon on 01,junio,2022
 */
class CountriesAdapter(private val countries: MutableList<Country>): RecyclerView.Adapter<ViewHolderCountries>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCountries {
        val binding = AdapterCountriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderCountries(binding, countries)
    }

    override fun onBindViewHolder(holder: ViewHolderCountries, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = countries.size

}