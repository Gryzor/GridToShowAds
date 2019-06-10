package com.neutobo.recyclerviewwithads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: ThingAdapterWithAds = ThingAdapterWithAds()
    private var repository: FakeDataRepository = FakeDataRepository()
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutManager = GridLayoutManager(this, 2)

        mainRecyclerView.layoutManager = layoutManager
        mainRecyclerView.adapter = adapter

        adapter.submitList(repository.getData())
    }
}
