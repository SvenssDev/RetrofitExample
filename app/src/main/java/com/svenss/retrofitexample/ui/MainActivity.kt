package com.svenss.retrofitexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.svenss.retrofitexample.R
import com.svenss.retrofitexample.adapter.CountriesAdapter
import com.svenss.retrofitexample.databinding.ActivityMainBinding
import com.svenss.retrofitexample.model.Country
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        initViews()
    }

    private fun initViews(){
        with(lifecycleScope){
            with(viewModel){
                launch { onCallCountriesService.collect{ bindRecycler(it)} }
            }
        }
    }

    private fun bindRecycler(countries: MutableList<Country>){
        binding.rvCountriesMainActivity.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CountriesAdapter(countries)
        }
    }
}