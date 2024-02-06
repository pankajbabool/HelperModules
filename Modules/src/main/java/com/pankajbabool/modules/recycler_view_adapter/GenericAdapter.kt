package com.pankajbabool.modules.recycler_view_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class GenericAdapter<B: ViewBinding, T>(
    private val bClass: Class<B>,
    private val mutableList: MutableList<T>,
    private val function: (adapter: GenericAdapter<B, T>, holder: GenericViewHolder<B>, binding: B, model: T, position: Int) -> Unit
) : RecyclerView.Adapter<GenericAdapter.GenericViewHolder<B>>() {

    class GenericViewHolder<B: ViewBinding>(val binding: B) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<B> {
        val method = bClass.getDeclaredMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        val binding = method.invoke(null, LayoutInflater.from(parent.context), parent, false) as B
        return GenericViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<B>, position: Int) {
        function(this, holder, holder.binding, mutableList[position], position)
    }

    override fun getItemCount() = mutableList.size

    fun addModel(model: T) {
        mutableList.add(model)
        notifyItemInserted(mutableList.lastIndex)
    }
    fun removeModel(predicate: (T) -> Boolean) {
        removeIndex(mutableList.indexOfFirst(predicate))
    }
    fun removeIndex(index: Int) {
        if (index !in mutableList.indices) return
        mutableList.removeAt(index)
        notifyItemRemoved(index)
    }
    fun addList(collection: Collection<T>) {
        if (collection.isEmpty()) return
        mutableList.addAll(collection)
        notifyItemInserted(mutableList.lastIndex)
    }
    fun clearList() {
        mutableList.clear()
        notifyDataSetChanged()
    }
}