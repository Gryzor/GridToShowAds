package com.neutobo.recyclerviewwithads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.neutobo.recyclerviewwithads.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var adapter: ThingAdapterWithAds = ThingAdapterWithAds()
    private var repository: FakeDataRepository = FakeDataRepository()
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = GridLayoutManager(this, 2)

        binding.mainRecyclerView.layoutManager = layoutManager
        binding.mainRecyclerView.adapter = adapter

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemViewType(position)) {
                    adapter.viewTypeGreen -> 1
                    adapter.viewTypePurple -> 1
                    adapter.viewTypeAd -> 2
                    else -> -1
                }
            }
        }

        adapter.submitList(repository.getData())
    }
}
