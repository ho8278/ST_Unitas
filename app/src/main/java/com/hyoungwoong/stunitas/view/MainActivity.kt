package com.hyoungwoong.stunitas.view

import android.graphics.Point
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyoungwoong.stunitas.AppInitialize
import com.hyoungwoong.stunitas.TopMarginDecorator
import com.hyoungwoong.stunitas.ViewModelFactory
import com.hyoungwoong.stunitas.databinding.ActivityMainBinding
import com.hyoungwoong.stunitas.util.debounce

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
            rvImages.apply{
                layoutManager = LinearLayoutManager(baseContext)
                adapter = ImageAdapter(Glide.with(this@MainActivity),width)
                addItemDecoration(TopMarginDecorator(20))
                addOnScrollListener(object:RecyclerView.OnScrollListener(){
                    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                        if(!recyclerView.canScrollVertically(1)){
                            viewModel.refresh()
                        }
                    }
                })
            }
        }
        viewModel.exception.observe(this,object:Observer<String>{
            override fun onChanged(t: String?) {
                Toast.makeText(baseContext,t,Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.searchText.debounce(1000L).observe(this,object:Observer<String>{
            override fun onChanged(t: String?) {
                viewModel.getImage()
            }
        })
    }
}