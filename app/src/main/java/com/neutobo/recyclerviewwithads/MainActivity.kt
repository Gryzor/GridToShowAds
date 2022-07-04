package com.neutobo.recyclerviewwithads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neutobo.recyclerviewwithads.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var adapter: ThingAdapterWithAds = ThingAdapterWithAds()
    private var repository: FakeDataRepository = FakeDataRepository()
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainRecyclerView.adapter = adapter

        setGridLayout(binding.mainRecyclerView)
        adapter.submitList(repository.getData())

        binding.swapLayouts.setOnClickListener {
            if (layoutManager is GridLayoutManager) {
                setLinearLayoutManager(binding.mainRecyclerView)
            } else {
                setGridLayout(binding.mainRecyclerView)
            }
        }
    }

    private fun setLinearLayoutManager(recyclerView: RecyclerView) {
        val layout = LinearLayoutManager(this)
        this.layoutManager = layout
        recyclerView.layoutManager = this.layoutManager
    }

    private fun setGridLayout(recyclerView: RecyclerView) {
        val layout = GridLayoutManager(this, 2)
        layout.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemViewType(position)) {
                    adapter.viewTypeGreen -> 1
                    adapter.viewTypePurple -> 1
                    adapter.viewTypeAd -> 2
                    else -> -1
                }
            }
        }

        this.layoutManager = layout
        recyclerView.layoutManager = this.layoutManager
    }
}
