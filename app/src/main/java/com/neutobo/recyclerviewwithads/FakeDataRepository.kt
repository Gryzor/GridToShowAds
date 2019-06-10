package com.neutobo.recyclerviewwithads

import com.neutobo.recyclerviewwithads.model.AdPlaceholder
import com.neutobo.recyclerviewwithads.model.Thing
import com.neutobo.recyclerviewwithads.model.ThingType

class FakeDataRepository {
    private val listOfData: MutableList<Thing> = ArrayList()

    private fun createFakeData() {
        for (i in 1..1000) {

            // add green and purple things
            if (i % 3 == 0) {
                listOfData.add(Thing(i, "This is Item $i", ThingType.PURPLE))
            } else {
                listOfData.add(Thing(i, "This is Item $i", ThingType.GREEN))
            }

            // Add "Ad" where they belong
            if (i % 4 == 0) {
                listOfData.add(AdPlaceholder())
            }
        }
    }

    init {
        createFakeData()
    }

    fun getData(): List<Thing> {
        return listOfData
    }
}