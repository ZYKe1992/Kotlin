package com.example.core

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("UseSparseArrays")
    private val viewHashMap: MutableMap<Int, View?> = HashMap()

    fun <T : View?> getView(@IdRes id: Int): T? {
        if (viewHashMap[id] == null) {
            viewHashMap[id] = itemView.findViewById(id)
        }
        return viewHashMap[id] as T?
    }

    fun setText(@IdRes id: Int, text: String?) {
        (getView<View>(id) as TextView).text = text
    }
}