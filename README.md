# GridToShowAds
Sample App With a RecyclerView GridLayoutManager to show full width "Ads" in the Grid.

Demonstrates how to show a Grid layout with RecyclerView and show "ads" that span the full width of the RV every 4 items. 
This would allow the grid to show items and then a banner AD.

The only "secrets" are:

* Use View Types in your RecyclerView adapter.
* Use a Type for Ad placeholders.
* Modify the `spanSizeLookup` dynamically based off of the view type.

### This Sample does NOT use any Ad library, that is left as an exercise to the reader.

### DISCLAIMER
This is by no means the *best* or *only* way to do this, as it has some drawbacks; you're mutating and copy data around, if you need to deal with Pagination, you may need to 
experiment if this still works, etc.

But if you receive a list of data, and have a GridLayout displaying two columns in portrait (for example), then this method will allow
you to insert a view that "spans" both columns whenever you want (based on Type).

![This is how it looks](https://github.com/Gryzor/GridToShowAds/blob/master/grid_sample.png)
