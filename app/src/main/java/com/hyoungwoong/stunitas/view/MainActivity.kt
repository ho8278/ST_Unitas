package com.hyoungwoong.stunitas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.hyoungwoong.stunitas.R
import com.hyoungwoong.stunitas.ViewModelFactory
import com.hyoungwoong.stunitas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewModel = ViewModelProviders.of(this,ViewModelFactory(AppInitialize.dataSource)).get(MainViewModel::class.java)
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewmodel = viewModel
    }
}
