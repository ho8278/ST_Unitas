package com.hyoungwoong.stunitas.view

import android.graphics.Point
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hyoungwoong.stunitas.ViewModelFactory
import com.hyoungwoong.stunitas.data.model.Image
import com.hyoungwoong.stunitas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel:MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProviders.of(this, ViewModelFactory((applicationContext as AppInitialize).dataSource))
            .get(MainViewModel::class.java)
        setContentView(binding.root)
        with(binding) {
            lifecycleOwner = this@MainActivity
            viewmodel = viewModel
            val point= Point()
            windowManager.defaultDisplay.getSize(point)
            val width = point.x
            val height = point.y
            rvImages.layoutManager = LinearLayoutManager(baseContext)
            rvImages.adapter = ImageAdapter(width,height)
            rvImages.addItemDecoration(TopMarginDecorator(20))
        }

    }
}
