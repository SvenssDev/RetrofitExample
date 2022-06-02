package com.svenss.retrofitexample.ui.viewholder

import androidx.recyclerview.widget.RecyclerView

import com.svenss.retrofitexample.databinding.AdapterCountriesBinding
import com.svenss.retrofitexample.model.Country
import com.svenss.retrofitexample.util.loadImage

/**
 * Created by miguelleon on 01,junio,2022
 */
class ViewHolderCountries(private val binding: AdapterCountriesBinding,
                          private val countries: MutableList<Country>): RecyclerView.ViewHolder(binding.root) {

    fun bind(){
        val country = countries[adapterPosition]
        with(binding){
            ivAdapterMain.loadImage(country.country_image)
            tvAdapterMain.text = country.country_name
        }
    }
}