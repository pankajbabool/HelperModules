package com.pankajbabool.modules.recycler_view_adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class AutoLoadRecyclerViewAdapter<VH: RecyclerView.ViewHolder>(recyclerView: RecyclerView, loadMore: (Int) -> Unit) : RecyclerView.Adapter<VH>() {

    init {
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = layoutManager.itemCount
                val lastVisibleIndex = layoutManager.findLastVisibleItemPosition()
                if (lastVisibleIndex == (totalItemCount - 1)) loadMore(totalItemCount)
            }
        })
    }

    abstract override fun onCreateViewHolder(v: ViewGroup, i: Int) : VH
    abstract override fun onBindViewHolder(holder: VH, position: Int)
    abstract override fun getItemCount() : Int
}