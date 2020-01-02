package com.hyoungwoong.stunitas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        with(binding){
            viewmodel = viewModel
            rvImages.layoutManager = GridLayoutManager(baseContext,2, RecyclerView.VERTICAL,false)
            rvImages.adapter = ImageAdapter()
        }
    }
}
